# coding: utf-8

"""
    Kestra EE

    All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

    The version of the OpenAPI document: v1
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import json
from enum import Enum
from typing_extensions import Self


class ServiceProviderConfigurationAuthenticationSchemaType(str, Enum):
    """
    ServiceProviderConfigurationAuthenticationSchemaType
    """

    """
    allowed enum values
    """
    OAUTH = 'OAUTH'
    OAUTH2 = 'OAUTH2'
    OAUTH_BEARER = 'OAUTH_BEARER'
    HTTP_BASIC = 'HTTP_BASIC'
    HTTP_DIGEST = 'HTTP_DIGEST'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of ServiceProviderConfigurationAuthenticationSchemaType from a JSON string"""
        return cls(json.loads(json_str))


