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
* ``None`` fields are omitted rather than emitted as ``null``;
* server-managed / read-only fields (``revision``, ``deleted``, ``draft``,
  ``tenantId``, ``source``, ``updated``) are stripped so the YAML mirrors what a
  user writes as flow source (``draft`` is a query parameter, not a body field);
* insertion/key order is preserved;
* Kestra expressions such as ``{{ inputs.foo }}`` are quoted, not mangled
  (PyYAML quotes any scalar that would otherwise be read as a flow mapping);
* multi-line strings (shell ``commands``, python ``script``) are emitted as
  readable literal block scalars;
* non-primitive values inside a dict input (nested pydantic models, enums,
  datetimes) are converted at every depth, so the ergonomic dict path never
  raises ``RepresenterError``;
* non-ASCII characters are kept verbatim (never escaped to ``\\uXXXX``).
"""

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


def _str_representer(dumper: yaml.Dumper, data: str) -> Any:
    # Emit multi-line strings as literal block scalars for readability and
    # round-trip fidelity; single-line strings keep the default handling (which
    # already quotes expressions like ``{{ ... }}`` when needed).
    if "\n" in data:
        return dumper.represent_scalar("tag:yaml.org,2002:str", data, style="|")
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
    if hasattr(value, "to_dict"):
        return _make_serializable(value.to_dict())
    if hasattr(value, "model_dump"):
        return _make_serializable(value.model_dump(by_alias=True, exclude_none=True))
    if isinstance(value, dict):
        return {k: _make_serializable(v) for k, v in value.items()}
    if isinstance(value, (list, tuple, set)):
        return [_make_serializable(v) for v in value]
    return value


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
    )
