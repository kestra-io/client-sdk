# coding: utf-8

"""
    Kestra EE

    All API operations allow an optional tenant identifier in the HTTP path, if you don't use multi-tenancy you must omit the tenant identifier.<br/> This means that, for example, when trying to access the Flows API, instead of using <code>/api/v1/{tenant}/flows</code> you must use <code>/api/v1/flows</code>.

    The version of the OpenAPI document: v1
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from pydantic import BaseModel, ConfigDict, Field, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from kestra_api_client.models.role import Role
from typing import Optional, Set
from typing_extensions import Self

class AclServiceNamespaceRole(BaseModel):
    """
    AclServiceNamespaceRole
    """ # noqa: E501
    role: Optional[Role] = None
    namespace_id: Optional[StrictStr] = Field(default=None, alias="namespaceId")
    __properties: ClassVar[List[str]] = ["role", "namespaceId"]

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
        """Create an instance of AclServiceNamespaceRole from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        excluded_fields: Set[str] = set([
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of role
        if self.role:
            _dict['role'] = self.role.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of AclServiceNamespaceRole from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "role": Role.from_dict(obj["role"]) if obj.get("role") is not None else None,
            "namespaceId": obj.get("namespaceId")
        })
        return _obj


