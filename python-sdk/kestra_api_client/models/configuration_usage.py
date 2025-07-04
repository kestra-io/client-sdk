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

from pydantic import BaseModel, ConfigDict, Field, StrictBool, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from typing import Optional, Set
from typing_extensions import Self

class ConfigurationUsage(BaseModel):
    """
    ConfigurationUsage
    """ # noqa: E501
    repository_type: Optional[StrictStr] = Field(default=None, alias="repositoryType")
    queue_type: Optional[StrictStr] = Field(default=None, alias="queueType")
    storage_type: Optional[StrictStr] = Field(default=None, alias="storageType")
    secret_type: Optional[StrictStr] = Field(default=None, alias="secretType")
    java_security_enabled: Optional[StrictBool] = Field(default=None, alias="javaSecurityEnabled")
    __properties: ClassVar[List[str]] = ["repositoryType", "queueType", "storageType", "secretType", "javaSecurityEnabled"]

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
        """Create an instance of ConfigurationUsage from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of ConfigurationUsage from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "repositoryType": obj.get("repositoryType"),
            "queueType": obj.get("queueType"),
            "storageType": obj.get("storageType"),
            "secretType": obj.get("secretType"),
            "javaSecurityEnabled": obj.get("javaSecurityEnabled")
        })
        return _obj


