# coding: utf-8

"""
    Kestra EE

    All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import json
from enum import Enum
from typing_extensions import Self


class Scope(str, Enum):
    """
    Scope
    """

    """
    allowed enum values
    """
    STATIC = 'STATIC'
    INSTANCE = 'INSTANCE'
    TENANT = 'TENANT'
    NAMESPACE = 'NAMESPACE'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Scope from a JSON string"""
        return cls(json.loads(json_str))
