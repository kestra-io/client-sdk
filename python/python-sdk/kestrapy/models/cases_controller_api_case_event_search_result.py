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
from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from kestrapy.models.cases_controller_api_case_event_with_case import CasesControllerApiCaseEventWithCase
from typing import Optional, Set
from typing_extensions import Self

class CasesControllerApiCaseEventSearchResult(BaseModel):
    """
    CasesControllerApiCaseEventSearchResult
    """ # noqa: E501
    results: Optional[List[CasesControllerApiCaseEventWithCase]] = None
    next_since_created: Optional[datetime] = Field(default=None, alias="nextSinceCreated")
    next_since_id: Optional[StrictStr] = Field(default=None, alias="nextSinceId")
    has_more: Optional[StrictBool] = Field(default=None, alias="hasMore")
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["results", "nextSinceCreated", "nextSinceId", "hasMore"]

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
        """Create an instance of CasesControllerApiCaseEventSearchResult from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in results (list)
        _items = []
        if self.results:
            for _item_results in self.results:
                if _item_results:
                    _items.append(_item_results.to_dict())
            _dict['results'] = _items
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        # set to None if next_since_created (nullable) is None
        # and model_fields_set contains the field
        if self.next_since_created is None and "next_since_created" in self.model_fields_set:
            _dict['nextSinceCreated'] = None

        # set to None if next_since_id (nullable) is None
        # and model_fields_set contains the field
        if self.next_since_id is None and "next_since_id" in self.model_fields_set:
            _dict['nextSinceId'] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of CasesControllerApiCaseEventSearchResult from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "results": [CasesControllerApiCaseEventWithCase.from_dict(_item) for _item in obj["results"]] if obj.get("results") is not None else None,
            "nextSinceCreated": obj.get("nextSinceCreated"),
            "nextSinceId": obj.get("nextSinceId"),
            "hasMore": obj.get("hasMore")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj


