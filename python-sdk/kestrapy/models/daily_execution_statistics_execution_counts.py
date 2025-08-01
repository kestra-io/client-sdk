# coding: utf-8

"""
    Kestra EE

    All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

    The version of the OpenAPI document: v1
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from pydantic import BaseModel, ConfigDict, Field, StrictInt
from typing import Any, ClassVar, Dict, List, Optional
from typing import Optional, Set
from typing_extensions import Self

class DailyExecutionStatisticsExecutionCounts(BaseModel):
    """
    DailyExecutionStatisticsExecutionCounts
    """ # noqa: E501
    created: Optional[StrictInt] = Field(default=None, alias="CREATED")
    running: Optional[StrictInt] = Field(default=None, alias="RUNNING")
    paused: Optional[StrictInt] = Field(default=None, alias="PAUSED")
    restarted: Optional[StrictInt] = Field(default=None, alias="RESTARTED")
    killing: Optional[StrictInt] = Field(default=None, alias="KILLING")
    success: Optional[StrictInt] = Field(default=None, alias="SUCCESS")
    warning: Optional[StrictInt] = Field(default=None, alias="WARNING")
    failed: Optional[StrictInt] = Field(default=None, alias="FAILED")
    killed: Optional[StrictInt] = Field(default=None, alias="KILLED")
    cancelled: Optional[StrictInt] = Field(default=None, alias="CANCELLED")
    queued: Optional[StrictInt] = Field(default=None, alias="QUEUED")
    retrying: Optional[StrictInt] = Field(default=None, alias="RETRYING")
    retried: Optional[StrictInt] = Field(default=None, alias="RETRIED")
    skipped: Optional[StrictInt] = Field(default=None, alias="SKIPPED")
    breakpoint: Optional[StrictInt] = Field(default=None, alias="BREAKPOINT")
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["CREATED", "RUNNING", "PAUSED", "RESTARTED", "KILLING", "SUCCESS", "WARNING", "FAILED", "KILLED", "CANCELLED", "QUEUED", "RETRYING", "RETRIED", "SKIPPED", "BREAKPOINT"]

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
        """Create an instance of DailyExecutionStatisticsExecutionCounts from a JSON string"""
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

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of DailyExecutionStatisticsExecutionCounts from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "CREATED": obj.get("CREATED"),
            "RUNNING": obj.get("RUNNING"),
            "PAUSED": obj.get("PAUSED"),
            "RESTARTED": obj.get("RESTARTED"),
            "KILLING": obj.get("KILLING"),
            "SUCCESS": obj.get("SUCCESS"),
            "WARNING": obj.get("WARNING"),
            "FAILED": obj.get("FAILED"),
            "KILLED": obj.get("KILLED"),
            "CANCELLED": obj.get("CANCELLED"),
            "QUEUED": obj.get("QUEUED"),
            "RETRYING": obj.get("RETRYING"),
            "RETRIED": obj.get("RETRIED"),
            "SKIPPED": obj.get("SKIPPED"),
            "BREAKPOINT": obj.get("BREAKPOINT")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj


