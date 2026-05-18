from typing import Any, Dict, List, Optional
from datetime import datetime, date


# Special field name mappings where the server-side @JsonValue
# differs from the UPPER_SNAKE_CASE -> lowerCamelCase conversion.
_FIELD_MAP = {
    "QUERY": "q",
    "MIN_LEVEL": "level",
}


def _to_camel_case(s: str) -> str:
    """Convert UPPER_SNAKE or snake_case to lowerCamelCase.

    FLOW_ID -> flowId, START_DATE -> startDate, LABELS -> labels
    """
    if s is None:
        return s
    parts = str(s).lower().split('_')
    if not parts:
        return s
    return parts[0] + ''.join(p.capitalize() for p in parts[1:])


def _encode_value(value: Any) -> str:
    """Encode a filter value to string."""
    if isinstance(value, (datetime, date)):
        return value.isoformat()
    if isinstance(value, list):
        return ",".join(str(v) for v in value)
    if isinstance(value, bool):
        return str(value).lower()
    return str(value)


def append_filter_params(params: list, filters: Optional[list]) -> None:
    """Encode QueryFilter list into query param tuples.

    Appends (key, value) tuples to params list.
    Format: filters[field][OPERATION]=value
    For map values: filters[field][OPERATION][key]=value
    """
    if not filters:
        return

    for f in filters:
        # Support both QueryFilter model instances and dicts.
        # QueryFilter uses 'var_field' (aliased to "field") for the field attribute.
        if hasattr(f, 'var_field'):
            field_obj = f.var_field
            raw_field = field_obj.value if hasattr(field_obj, 'value') else str(field_obj)
            op_obj = f.operation
            operation = op_obj.value if hasattr(op_obj, 'value') else str(op_obj)
            value = f.value
        elif hasattr(f, 'field'):
            field_obj = f.field
            raw_field = field_obj.value if hasattr(field_obj, 'value') else str(field_obj)
            op_obj = f.operation
            operation = op_obj.value if hasattr(op_obj, 'value') else str(op_obj)
            value = f.value
        elif isinstance(f, dict):
            raw_field = str(f.get('field', ''))
            operation = str(f.get('operation', ''))
            value = f.get('value')
        else:
            continue

        # Map field name: check special overrides first, then camelCase convert
        field_upper = raw_field.upper()
        if field_upper in _FIELD_MAP:
            field_name = _FIELD_MAP[field_upper]
        else:
            field_name = _to_camel_case(raw_field)

        # Unwrap {'value': actual} shape (backward compat)
        if isinstance(value, dict) and 'value' in value and len(value) == 1:
            value = value['value']

        # Expand dict/map values
        if isinstance(value, dict):
            for k, v in value.items():
                params.append((f"filters[{field_name}][{operation}][{k}]", _encode_value(v)))
        else:
            params.append((f"filters[{field_name}][{operation}]", _encode_value(value)))
