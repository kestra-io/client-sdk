# coding: utf-8

"""Client-side serialization of a Kestra flow object to a YAML source string.

The flow-write endpoints (``POST``/``PUT`` ``/flows``) only consume
``application/x-yaml``; they do not accept JSON. To let callers build a flow
from a native object (a typed :class:`~kestrapy.models.flow.Flow` model or a
plain ``dict``) instead of hand-writing YAML, we serialize the object to a YAML
source string here and post it to the existing YAML endpoints.

Serialization rules:

* block style (never inline/flow style), no anchors/aliases (shared object
  references are expanded, never emitted as ``&anchor``/``*alias``);
* ``None`` fields are omitted rather than emitted as ``null``, at every depth
  (for both the typed-model path and the dict path);
* server-managed / read-only fields (``revision``, ``deleted``, ``draft``,
  ``tenantId``, ``source``, ``updated``) are stripped so the YAML mirrors what a
  user writes as flow source (``draft`` is a query parameter, not a body field);
* insertion/key order is preserved;
* Kestra expressions such as ``{{ inputs.foo }}`` are quoted, not mangled
  (PyYAML quotes any scalar that would otherwise be read as a flow mapping);
* multi-line strings (shell ``commands``, python ``script``) are emitted as
  readable literal block scalars;
* non-primitive values inside a dict input (nested pydantic models, enums,
  datetimes, ``bytes`` decoded as UTF-8) are converted at every depth; a truly
  unsupported value raises a clear :class:`TypeError` naming its type rather than
  a low-level ``yaml.representer.RepresenterError``;
* non-ASCII characters are kept verbatim (never escaped to ``\\uXXXX``);
* long lines are never folded.
"""

import re
from datetime import date, datetime
from enum import Enum
from typing import Any, Dict, Union

import yaml

# Read-only / server-managed flow fields that must not appear in flow source.
_SERVER_MANAGED_FIELDS = frozenset(
    {"revision", "deleted", "draft", "tenantId", "source", "updated"}
)


class _KestraFlowDumper(yaml.SafeDumper):
    """A dedicated Dumper so representers stay local to this module."""

    def ignore_aliases(self, data: Any) -> bool:
        # Never emit YAML anchors/aliases (&id / *id) for repeated objects; a
        # flow source must be a plain, self-contained document.
        return True


# Plain scalars some YAML reader resolves to a boolean or null (compared
# case-insensitively).
_AMBIGUOUS_YAML_WORDS = frozenset(
    {"", "~", "null", "y", "yes", "n", "no", "true", "false", "on", "off"}
)

# Strings a YAML 1.1 / 1.2 or Jackson reader (Kestra's server parses flow source
# with Jackson's YAMLParser) may resolve to a number or timestamp: signed
# ints/floats with underscores and exponents (with or without a dot or exponent
# sign), hex/octal/binary, .inf/.nan, sexagesimal (12:30) and dates. PyYAML's
# own resolver is YAML 1.1 and leaves e.g. ``1e3`` (no dot) plain, which
# Jackson reads as 1000.0. Deliberately permissive: quoting a string that did
# not need it is harmless, leaving one plain is not. Same predicate as the
# Go/JS/Java SDKs, pinned by test-utils/yaml-ambiguous-strings.json.
_AMBIGUOUS_YAML_SCALAR = re.compile(
    r"^[-+]?("
    r"0x[0-9a-f_]+|0o[0-7_]+|0b[01_]+|"
    r"[0-9][0-9_]*(\.[0-9_]*)?(e[-+]?[0-9_]+)?|"
    r"\.[0-9][0-9_]*(e[-+]?[0-9_]+)?|"
    r"\.(inf|nan)|"
    r"[0-9][0-9_]*(:[0-5]?[0-9])+(\.[0-9_]*)?"
    r")$|^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}",
    re.IGNORECASE,
)


def _is_ambiguous_yaml_string(data: str) -> bool:
    return data.lower() in _AMBIGUOUS_YAML_WORDS or bool(_AMBIGUOUS_YAML_SCALAR.match(data))


def _str_representer(dumper: yaml.Dumper, data: str) -> Any:
    # Emit multi-line strings as literal block scalars for readability and
    # round-trip fidelity; strings a YAML reader would re-type (yes, off, 1e3,
    # 1_000, ...) are force-quoted; other single-line strings keep the default
    # handling (which already quotes expressions like ``{{ ... }}``).
    if "\n" in data:
        return dumper.represent_scalar("tag:yaml.org,2002:str", data, style="|")
    if _is_ambiguous_yaml_string(data):
        return dumper.represent_scalar("tag:yaml.org,2002:str", data, style='"')
    return dumper.represent_scalar("tag:yaml.org,2002:str", data)


_KestraFlowDumper.add_representer(str, _str_representer)


def _make_serializable(value: Any) -> Any:
    """Recursively convert an arbitrary value to YAML-safe primitives.

    Handles the ergonomic dict path where nested values may be pydantic/generated
    models, enums or datetimes at any depth.
    """
    if value is None:
        return value
    # Enum before the primitive check: a str-/int-based enum passes the
    # ``isinstance(str/int)`` test but is not the exact type SafeDumper knows how
    # to represent, so it must be unwrapped to its underlying value first.
    if isinstance(value, Enum):
        return _make_serializable(value.value)
    if isinstance(value, (datetime, date)):
        return value.isoformat()
    if isinstance(value, (str, bool, int, float)):
        return value
    if isinstance(value, bytes):
        return value.decode("utf-8")
    if hasattr(value, "to_dict"):
        return _make_serializable(value.to_dict())
    if hasattr(value, "model_dump"):
        return _make_serializable(value.model_dump(by_alias=True, exclude_none=True))
    if isinstance(value, dict):
        # Drop keys whose (recursively serialized) value is None at every depth,
        # matching the typed-Flow path (exclude_none) and the JS/Java behavior.
        result: Dict[Any, Any] = {}
        for k, v in value.items():
            serialized = _make_serializable(v)
            if serialized is None:
                continue
            result[k] = serialized
        return result
    if isinstance(value, (list, tuple, set)):
        return [_make_serializable(v) for v in value]
    raise TypeError(
        f"Cannot serialize value of type {type(value).__name__!r} to flow YAML"
    )


def _to_serializable(flow: Any) -> Dict[str, Any]:
    if hasattr(flow, "to_dict"):
        # Flow (or any generated model): to_dict() already omits None, recurses
        # into nested tasks and re-inserts additional (plugin-specific) props.
        data: Any = flow.to_dict()
    elif isinstance(flow, dict):
        data = flow
    else:
        raise TypeError(
            "flow must be a Flow model or a dict, got "
            f"{type(flow).__name__}"
        )

    data = _make_serializable(data)
    if isinstance(data, dict):
        data = {k: v for k, v in data.items() if k not in _SERVER_MANAGED_FIELDS}
    return data


def flow_to_yaml(flow: Union[Dict[str, Any], Any]) -> str:
    """Serialize a flow object (Flow model or dict) to a YAML source string."""
    data = _to_serializable(flow)
    return yaml.dump(
        data,
        Dumper=_KestraFlowDumper,
        default_flow_style=False,
        allow_unicode=True,
        sort_keys=False,
        # Never fold long lines: the YAML is the flow source the server stores
        # and the UI shows (Go and Java don't fold either).
        width=float("inf"),
    )
