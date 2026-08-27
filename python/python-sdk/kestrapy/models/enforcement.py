# coding: utf-8

"""
    Kestra EE

    All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import json
from enum import Enum
from typing_extensions import Self


class Enforcement(str, Enum):
    """
    Enforcement
    """

    """
    allowed enum values
    """
    ACTIVE = 'ACTIVE'
    EVALUATE = 'EVALUATE'
    DISABLED = 'DISABLED'
    REFERENCE = 'REFERENCE'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Enforcement from a JSON string"""
        return cls(json.loads(json_str))
