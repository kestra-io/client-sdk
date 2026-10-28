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
from pydantic import BaseModel, ConfigDict, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from kestrapy.models.assets_controller_api_relation_node import AssetsControllerApiRelationNode
from kestrapy.models.relation_kind import RelationKind
from kestrapy.models.relation_origin import RelationOrigin
from kestrapy.models.relation_provenance import RelationProvenance
from kestrapy.models.relation_state import RelationState
from typing import Optional, Set
from typing_extensions import Self

class AssetsControllerApiRelation(BaseModel):
    """
    AssetsControllerApiRelation
    """ # noqa: E501
    uid: Optional[StrictStr] = None
    kind: Optional[RelationKind] = None
    role: Optional[StrictStr] = None
    origin: Optional[RelationOrigin] = None
    state: Optional[RelationState] = None
    source: Optional[AssetsControllerApiRelationNode] = None
    target: Optional[AssetsControllerApiRelationNode] = None
    provenance: Optional[RelationProvenance] = None
    created: Optional[datetime] = None
    updated: Optional[datetime] = None
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["uid", "kind", "role", "origin", "state", "source", "target", "provenance", "created", "updated"]

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
        """Create an instance of AssetsControllerApiRelation from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of source
        if self.source:
            _dict['source'] = self.source.to_dict()
        # override the default output from pydantic by calling `to_dict()` of target
        if self.target:
            _dict['target'] = self.target.to_dict()
        # override the default output from pydantic by calling `to_dict()` of provenance
        if self.provenance:
            _dict['provenance'] = self.provenance.to_dict()
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        # set to None if role (nullable) is None
        # and model_fields_set contains the field
        if self.role is None and "role" in self.model_fields_set:
            _dict['role'] = None

        # set to None if provenance (nullable) is None
        # and model_fields_set contains the field
        if self.provenance is None and "provenance" in self.model_fields_set:
            _dict['provenance'] = None

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of AssetsControllerApiRelation from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "uid": obj.get("uid"),
            "kind": obj.get("kind"),
            "role": obj.get("role"),
            "origin": obj.get("origin"),
            "state": obj.get("state"),
            "source": AssetsControllerApiRelationNode.from_dict(obj["source"]) if obj.get("source") is not None else None,
            "target": AssetsControllerApiRelationNode.from_dict(obj["target"]) if obj.get("target") is not None else None,
            "provenance": RelationProvenance.from_dict(obj["provenance"]) if obj.get("provenance") is not None else None,
            "created": obj.get("created"),
            "updated": obj.get("updated")
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj


