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


class StateType(str, Enum):
    """
    StateType
    """

    """
    allowed enum values
    """
    CREATED = 'CREATED'
    RUNNING = 'RUNNING'
    PAUSED = 'PAUSED'
    RESTARTED = 'RESTARTED'
    KILLING = 'KILLING'
    SUCCESS = 'SUCCESS'
    WARNING = 'WARNING'
    FAILED = 'FAILED'
    KILLED = 'KILLED'
    CANCELLED = 'CANCELLED'
    QUEUED = 'QUEUED'
    RETRYING = 'RETRYING'
    RETRIED = 'RETRIED'
    SKIPPED = 'SKIPPED'
    BREAKPOINT = 'BREAKPOINT'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of StateType from a JSON string"""
        return cls(json.loads(json_str))


