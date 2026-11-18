# coding: utf-8

"""
    Kestra EE

    All API operations, except for Instance-owner-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Instance-owner-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import pprint
import regex as re
import json

from pydantic import BaseModel, ConfigDict, Field, StrictStr
from typing import Any, ClassVar, Dict, List, Optional, Tuple
from typing_extensions import Annotated
from kestrapy.models.worker_queue_fallback import WorkerQueueFallback
from kestrapy.models.worker_selector_match import WorkerSelectorMatch
from typing import Optional, Set
from typing_extensions import Self

class WorkerSelector(BaseModel):
    """
    Routing requirements for a Worker Queue.

    On a Flow, Task or Trigger, Kestra 2.0.11+ types ``tags`` as a property: the
    server returns it as a string, either the JSON text of a literal list
    (``["gpu"]``) or a Pebble expression. Kestra 2.0.0-2.0.10, and namespace /
    tenant defaults, use a plain list. To work with every 2.0.x server, a literal
    list is always read into ``tags`` and any other string into
    ``tags_expression``. On write, ``tags_expression`` is sent as the ``tags``
    string when set (Kestra 2.0.11+ only), otherwise ``tags`` is sent as a list.
    """ # noqa: E501
    tags: Optional[Annotated[List[StrictStr], Field(max_length=20)]] = Field(default=None, description="Required tags used to route to a matching Worker Queue. Each tag is an RFC 1123 label: lowercase alphanumerics and hyphens, must start and end with alphanumeric, max 64 chars per tag, max 20 tags.")
    tags_expression: Optional[StrictStr] = Field(default=None, description="Pebble expression rendering to the tags (Flow, Task and Trigger only, Kestra 2.0.11+), e.g. `{{ inputs.workers }}`. Sent as the `tags` string and takes precedence over `tags` when set.")
    match: Optional[WorkerSelectorMatch] = Field(default=None, description="How selector tags are matched against a Worker Queue's tag set. ALL: queue tags must be a superset of the selector tags. ANY: queue tags must intersect the selector tags. Defaults to ALL when null.")
    fallback: Optional[WorkerQueueFallback] = Field(default=None, description="Strategy when no worker is available. Defaults to FAIL when null.")
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["tags", "match", "fallback"]

    model_config = ConfigDict(
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )


    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True, exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of WorkerSelector from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        * Fields in `self.additional_properties` are added to the output dict.
        """
        excluded_fields: Set[str] = set([
            "additional_properties",
            "tags_expression",
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        if self.tags_expression is not None:
            _dict["tags"] = self.tags_expression
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of WorkerSelector from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        tags, tags_expression = _split_tags(obj.get("tags"))
        _obj = cls.model_validate({
            "tags": tags,
            "tags_expression": tags_expression,
            "match": obj.get("match"),
            "fallback": obj.get("fallback")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj




def _split_tags(value: Any) -> Tuple[Any, Optional[str]]:
    """Split a ``tags`` JSON value into ``(tags, tags_expression)``.

    A list (Kestra before 2.0.11, namespace / tenant defaults) is kept as is. A
    string (Kestra 2.0.11+ flows, tasks and triggers) holding the JSON text of a
    list of strings is read as that list; any other string is an expression.
    """
    if not isinstance(value, str):
        return value, None
    if value.strip().startswith("["):
        try:
            parsed = json.loads(value)
        except ValueError:
            parsed = None
        if isinstance(parsed, list) and all(isinstance(item, str) for item in parsed):
            return parsed, None
    return None, value
