# coding: utf-8

"""
    Kestra EE

    All API operations, except for Instance-owner-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Instance-owner-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import pprint
import regex as re
import json

from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictInt, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from kestrapy.models.asset_write_summary import AssetWriteSummary
from kestrapy.models.node_type import NodeType
from typing import Optional, Set
from typing_extensions import Self

class AssetRelationGraphNode(BaseModel):
    """
    AssetRelationGraphNode
    """ # noqa: E501
    uid: Optional[StrictStr] = None
    namespace: Optional[StrictStr] = None
    id: Optional[StrictStr] = None
    type: Optional[NodeType] = None
    asset_type: Optional[StrictStr] = Field(default=None, alias="assetType")
    display_name: Optional[StrictStr] = Field(default=None, alias="displayName")
    producer: Optional[AssetWriteSummary] = None
    runs: Optional[List[AssetWriteSummary]] = None
    collapsed: Optional[StrictBool] = None
    total_degree: Optional[StrictInt] = Field(default=None, alias="totalDegree")
    next_cursor: Optional[StrictStr] = Field(default=None, alias="nextCursor")
    exhausted: Optional[StrictBool] = None
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["uid", "namespace", "id", "type", "assetType", "displayName", "producer", "runs", "collapsed", "totalDegree", "nextCursor", "exhausted"]

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
        """Create an instance of AssetRelationGraphNode from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of producer
        if self.producer:
            _dict['producer'] = self.producer.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in runs (list)
        _items = []
        if self.runs:
            for _item_runs in self.runs:
                if _item_runs:
                    _items.append(_item_runs.to_dict())
            _dict['runs'] = _items
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        # set to None if namespace (nullable) is None
        # and model_fields_set contains the field
        if self.namespace is None and "namespace" in self.model_fields_set:
            _dict['namespace'] = None

        # set to None if id (nullable) is None
        # and model_fields_set contains the field
        if self.id is None and "id" in self.model_fields_set:
            _dict['id'] = None

        # set to None if asset_type (nullable) is None
        # and model_fields_set contains the field
        if self.asset_type is None and "asset_type" in self.model_fields_set:
            _dict['assetType'] = None

        # set to None if display_name (nullable) is None
        # and model_fields_set contains the field
        if self.display_name is None and "display_name" in self.model_fields_set:
            _dict['displayName'] = None

        # set to None if producer (nullable) is None
        # and model_fields_set contains the field
        if self.producer is None and "producer" in self.model_fields_set:
            _dict['producer'] = None

        # set to None if runs (nullable) is None
        # and model_fields_set contains the field
        if self.runs is None and "runs" in self.model_fields_set:
            _dict['runs'] = None

        # set to None if total_degree (nullable) is None
        # and model_fields_set contains the field
        if self.total_degree is None and "total_degree" in self.model_fields_set:
            _dict['totalDegree'] = None

        # set to None if next_cursor (nullable) is None
        # and model_fields_set contains the field
        if self.next_cursor is None and "next_cursor" in self.model_fields_set:
            _dict['nextCursor'] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of AssetRelationGraphNode from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "uid": obj.get("uid"),
            "namespace": obj.get("namespace"),
            "id": obj.get("id"),
            "type": obj.get("type"),
            "assetType": obj.get("assetType"),
            "displayName": obj.get("displayName"),
            "producer": AssetWriteSummary.from_dict(obj["producer"]) if obj.get("producer") is not None else None,
            "runs": [AssetWriteSummary.from_dict(_item) for _item in obj["runs"]] if obj.get("runs") is not None else None,
            "collapsed": obj.get("collapsed"),
            "totalDegree": obj.get("totalDegree"),
            "nextCursor": obj.get("nextCursor"),
            "exhausted": obj.get("exhausted")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj


