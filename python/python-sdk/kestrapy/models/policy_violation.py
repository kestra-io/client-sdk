# coding: utf-8

"""
    Kestra EE

    All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import pprint
import regex as re
import json

from pydantic import BaseModel, ConfigDict, Field, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from kestrapy.models.rule_action import RuleAction
from kestrapy.models.scope import Scope
from typing import Optional, Set
from typing_extensions import Self

class PolicyViolation(BaseModel):
    """
    PolicyViolation
    """ # noqa: E501
    severity: Optional[RuleAction] = None
    rule_type: Optional[StrictStr] = Field(default=None, alias="ruleType")
    target: Optional[StrictStr] = None
    message: Optional[StrictStr] = None
    policy_id: Optional[StrictStr] = Field(default=None, alias="policyId")
    scope: Optional[Scope] = None
    task_id: Optional[StrictStr] = Field(default=None, alias="taskId")
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["severity", "ruleType", "target", "message", "policyId", "scope", "taskId"]

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
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of PolicyViolation from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias."""
        excluded_fields: Set[str] = set([
            "additional_properties",
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of PolicyViolation from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "severity": obj.get("severity"),
            "ruleType": obj.get("ruleType"),
            "target": obj.get("target"),
            "message": obj.get("message"),
            "policyId": obj.get("policyId"),
            "scope": obj.get("scope"),
            "taskId": obj.get("taskId")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj
