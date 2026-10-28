# coding: utf-8

"""
    Kestra EE

    All API operations, except for Instance-owner-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Instance-owner-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import json
from enum import Enum
from typing_extensions import Self


class RelationKind(str, Enum):
    """
    RelationKind
    """

    """
    allowed enum values
    """
    PRODUCES = 'PRODUCES'
    CONSUMED_BY = 'CONSUMED_BY'
    UPSTREAM_OF = 'UPSTREAM_OF'
    PART_OF = 'PART_OF'
    RELATED = 'RELATED'
    WRITES = 'WRITES'
    READS = 'READS'
    UNKNOWN = 'UNKNOWN'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of RelationKind from a JSON string"""
        return cls(json.loads(json_str))


