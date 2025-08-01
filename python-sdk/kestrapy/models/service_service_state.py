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


class ServiceServiceState(str, Enum):
    """
    ServiceServiceState
    """

    """
    allowed enum values
    """
    CREATED = 'CREATED'
    RUNNING = 'RUNNING'
    ERROR = 'ERROR'
    DISCONNECTED = 'DISCONNECTED'
    TERMINATING = 'TERMINATING'
    TERMINATED_GRACEFULLY = 'TERMINATED_GRACEFULLY'
    TERMINATED_FORCED = 'TERMINATED_FORCED'
    NOT_RUNNING = 'NOT_RUNNING'
    EMPTY = 'EMPTY'
    MAINTENANCE = 'MAINTENANCE'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of ServiceServiceState from a JSON string"""
        return cls(json.loads(json_str))


