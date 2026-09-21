from typing import Any, Dict, List, Optional
from datetime import datetime, date


# Special field name mappings where the server-side @JsonValue
# differs from the UPPER_SNAKE_CASE -> lowerCamelCase conversion.
_FIELD_MAP = {
    "QUERY": "q",
}


def _to_camel_case(s: str) -> str:
    """Normalize a filter field name to the server-side @JsonValue.

    Only legacy UPPER_SNAKE names are converted (FLOW_ID -> flowId,
    SEVERITY -> severity). Anything with lowercase in it is already the
    server-side @JsonValue (startDate, external_id, q) and must pass
    through verbatim — lowercasing 'startDate' would corrupt it to
    'startdate', which the server rejects.
    """
    if s is None:
        return s
    s = str(s)
    if not s.isupper():
        return s
    parts = s.lower().split('_')
    return parts[0] + ''.join(p.capitalize() for p in parts[1:])


def _encode_scalar(value: Any) -> str:
    """Encode a single scalar filter value to string.

    Matches Java: '' for None, lowercase for bool, isoformat for datetime/date,
    else str(). Used for both the scalar and per-element list paths so a bool
    (or None/datetime) inside a list serializes exactly like a bare scalar
    (e.g. [True, False] -> "true,false", not "True,False").
    """
    if value is None:
        # A valueless leaf serializes to an empty string, matching the UI encoder
        # and the Go/Java serializers (rather than the literal "None").
        return ""
    if isinstance(value, bool):
        return str(value).lower()
    if isinstance(value, (datetime, date)):
        return value.isoformat()
    return str(value)


def _encode_value(value: Any) -> str:
    """Encode a filter value (scalar or list) to string."""
    if isinstance(value, list):
        return ",".join(_encode_scalar(v) for v in value)
    return _encode_scalar(value)


# ---------------------------------------------------------------------------
# Node accessors — work uniformly over QueryFilter model instances and plain
# dicts. A node is EITHER a leaf (field + operation) or a group (logical +
# children); the serializer classifies each node with these helpers.
# ---------------------------------------------------------------------------

def _enum_value(x: Any) -> Any:
    return x.value if hasattr(x, 'value') else x


def _node_field(f: Any) -> Any:
    if isinstance(f, dict):
        return f.get('field', f.get('var_field'))
    if hasattr(f, 'var_field'):
        return f.var_field
    if hasattr(f, 'field'):
        return f.field
    return None


def _node_operation(f: Any) -> Any:
    if isinstance(f, dict):
        return f.get('operation')
    return getattr(f, 'operation', None)


def _node_value(f: Any) -> Any:
    if isinstance(f, dict):
        return f.get('value')
    return getattr(f, 'value', None)


def _node_logical(f: Any) -> Any:
    if isinstance(f, dict):
        return f.get('logical')
    return getattr(f, 'logical', None)


def _node_children(f: Any) -> Any:
    if isinstance(f, dict):
        return f.get('children')
    return getattr(f, 'children', None)


def _logical_str(f: Any) -> str:
    """Wire form of a group's logical operator: lowercase 'and'/'or'."""
    lg = _enum_value(_node_logical(f))
    return str(lg).lower() if lg is not None else 'and'


def _classify(f: Any) -> str:
    """Return 'leaf' or 'group'; raise if a node is ambiguously both.

    Unified cross-SDK rule (issue #246 review): a node is a group iff it has a
    logical OR a NON-EMPTY children list. An empty children list on a leaf is
    ignored (the node stays a leaf).
    """
    has_field = _node_field(f) is not None
    has_group = _node_logical(f) is not None or bool(_node_children(f))
    if has_field and has_group:
        raise ValueError(
            "a filter node cannot be both a leaf and a group"
        )
    return 'group' if has_group else 'leaf'


# Internal normalized node representation:
#   ('leaf', <original node>)
#   ('group', <'and'|'or'>, [<normalized node>, ...])
def _normalize(f: Any) -> Optional[tuple]:
    """Collapse single-child groups and drop empty groups (DSL semantics)."""
    if _classify(f) == 'leaf':
        return ('leaf', f)
    children = _node_children(f) or []
    norm = []
    for c in children:
        n = _normalize(c)
        if n is not None:
            norm.append(n)
    if not norm:
        return None
    if len(norm) == 1:
        return norm[0]
    return ('group', _logical_str(f), norm)


def _emit_leaf(params: list, prefix: str, f: Any) -> None:
    """Encode a single leaf filter under `prefix`.

    base = prefix[fieldName][OPERATION]
      - map/dict value  -> base[key] = value  (keys sorted for determinism)
      - list value      -> CSV-joined single value
      - scalar          -> single value
    """
    if _classify(f) != 'leaf':
        raise ValueError("a filter node cannot be both a leaf and a group")

    raw_field = _enum_value(_node_field(f))
    if raw_field is None:
        raise ValueError("a leaf filter requires a field")
    raw_field = str(raw_field)

    op_obj = _enum_value(_node_operation(f))
    operation = str(op_obj) if op_obj is not None else ''

    value = _node_value(f)

    # Map field name: check special overrides first, then camelCase convert.
    field_upper = raw_field.upper()
    if field_upper in _FIELD_MAP:
        field_name = _FIELD_MAP[field_upper]
    else:
        field_name = _to_camel_case(raw_field)

    base = f"{prefix}[{field_name}][{operation}]"

    # Unwrap {'value': actual} shape (backward compat).
    if isinstance(value, dict) and 'value' in value and len(value) == 1:
        value = value['value']

    # Expand dict/map values (e.g. labels), sorting keys for determinism.
    if isinstance(value, dict):
        for k in sorted(value.keys()):
            params.append((f"{base}[{k}]", _encode_value(value[k])))
    else:
        params.append((base, _encode_value(value)))


def append_filter_params(
    params: list, filters: Optional[list], prefix: str = "filters"
) -> None:
    """Encode a QueryFilter list into query param tuples.

    Implements the shared complex-filter serializer (issue #246):
    - The input list is an implicit AND of its elements (legacy semantics).
    - A top-level AND of leaves flattens to bare `filters[field][OP]`
      (byte-identical to the legacy flat form — the backward-compat invariant).
    - A single top-level group is promoted to top level; explicit
      `filters[and][i]` / `filters[or][i]` segments appear only when the top
      logical is OR or a nested group is present.
    - Single-child groups collapse to their child; empty groups emit nothing.
    - Nesting is limited to one level; deeper nesting raises ValueError.

    Appends (key, value) tuples to `params`, preserving list/children order.
    Supports QueryFilter model instances, `.logical`/enum values, and dicts.
    """
    if not filters:
        return

    nodes = [_normalize(f) for f in filters]
    nodes = [n for n in nodes if n is not None]
    if not nodes:
        return

    # Determine (top_logical, units): promote a lone top-level group.
    if len(nodes) == 1 and nodes[0][0] == 'group':
        top_logical = nodes[0][1]
        units = nodes[0][2]
    else:
        top_logical = 'and'
        units = nodes

    # Flat form: top-level AND whose units are all leaves.
    if top_logical == 'and' and all(u[0] == 'leaf' for u in units):
        for u in units:
            _emit_leaf(params, prefix, u[1])
        return

    for i, unit in enumerate(units):
        unit_prefix = f"{prefix}[{top_logical}][{i}]"
        if unit[0] == 'group':
            group_logical = unit[1]
            for j, child in enumerate(unit[2]):
                if child[0] == 'group':
                    raise ValueError(
                        "nested groups are limited to one level; "
                        "flatten the inner group"
                    )
                _emit_leaf(
                    params,
                    f"{unit_prefix}[{group_logical}][{j}]",
                    child[1],
                )
        else:
            _emit_leaf(params, unit_prefix, unit[1])
