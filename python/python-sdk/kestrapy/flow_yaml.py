# coding: utf-8

"""Client-side serialization of a Kestra flow object to a YAML source string.

The flow-write endpoints (``POST``/``PUT`` ``/flows``) only consume
``application/x-yaml``; they do not accept JSON. To let callers build a flow
from a native object (a typed :class:`~kestrapy.models.flow.Flow` model or a
plain ``dict``) instead of hand-writing YAML, we serialize the object to a YAML
source string here and post it to the existing YAML endpoints.

Serialization rules:

* block style (never inline/flow style), no anchors/aliases;
* ``None`` fields are omitted rather than emitted as ``null``;
* insertion/key order is preserved;
* Kestra expressions such as ``{{ inputs.foo }}`` are quoted, not mangled
  (PyYAML quotes any scalar that would otherwise be read as a flow mapping);
* multi-line strings (shell ``commands``, python ``script``) are emitted as
  readable literal block scalars;
* non-ASCII characters are kept verbatim (never escaped to ``\\uXXXX``).
"""

from typing import Any, Dict, Union

import yaml


class _KestraFlowDumper(yaml.SafeDumper):
    """A dedicated Dumper so representers stay local to this module."""


def _str_representer(dumper: yaml.Dumper, data: str) -> Any:
    # Emit multi-line strings as literal block scalars for readability and
    # round-trip fidelity; single-line strings keep the default handling (which
    # already quotes expressions like ``{{ ... }}`` when needed).
    if "\n" in data:
        return dumper.represent_scalar("tag:yaml.org,2002:str", data, style="|")
    return dumper.represent_scalar("tag:yaml.org,2002:str", data)


_KestraFlowDumper.add_representer(str, _str_representer)


def _to_serializable(flow: Any) -> Dict[str, Any]:
    if hasattr(flow, "to_dict"):
        # Flow (or any generated model): to_dict() already omits None, recurses
        # into nested tasks and re-inserts additional (plugin-specific) props.
        return flow.to_dict()
    if isinstance(flow, dict):
        return flow
    raise TypeError(
        "flow must be a Flow model or a dict, got "
        f"{type(flow).__name__}"
    )


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
