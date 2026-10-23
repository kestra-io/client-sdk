# coding: utf-8

"""
    Kestra EE

    All API operations, except for Instance-owner-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Instance-owner-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import pprint
import regex as re
import json

from datetime import datetime
from pydantic import BaseModel, ConfigDict, Field, StrictInt, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from kestrapy.models.state_type import StateType
from typing import Optional, Set
from typing_extensions import Self

class RelationProvenance(BaseModel):
    """
    RelationProvenance
    """ # noqa: E501
    namespace: Optional[StrictStr] = None
    flow_id: Optional[StrictStr] = Field(default=None, alias="flowId")
    flow_revision: Optional[StrictInt] = Field(default=None, alias="flowRevision")
    execution_id: Optional[StrictStr] = Field(default=None, alias="executionId")
    task_id: Optional[StrictStr] = Field(default=None, alias="taskId")
    task_run_id: Optional[StrictStr] = Field(default=None, alias="taskRunId")
    task_type: Optional[StrictStr] = Field(default=None, alias="taskType")
    state: Optional[StateType] = None
    start_date: Optional[datetime] = Field(default=None, alias="startDate")
    end_date: Optional[datetime] = Field(default=None, alias="endDate")
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["namespace", "flowId", "flowRevision", "executionId", "taskId", "taskRunId", "taskType", "state", "startDate", "endDate"]

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
        """Create an instance of RelationProvenance from a JSON string"""
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

        # set to None if task_type (nullable) is None
        # and model_fields_set contains the field
        if self.task_type is None and "task_type" in self.model_fields_set:
            _dict['taskType'] = None

        # set to None if end_date (nullable) is None
        # and model_fields_set contains the field
        if self.end_date is None and "end_date" in self.model_fields_set:
            _dict['endDate'] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of RelationProvenance from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "namespace": obj.get("namespace"),
            "flowId": obj.get("flowId"),
            "flowRevision": obj.get("flowRevision"),
            "executionId": obj.get("executionId"),
            "taskId": obj.get("taskId"),
            "taskRunId": obj.get("taskRunId"),
            "taskType": obj.get("taskType"),
            "state": obj.get("state"),
            "startDate": obj.get("startDate"),
            "endDate": obj.get("endDate")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj


