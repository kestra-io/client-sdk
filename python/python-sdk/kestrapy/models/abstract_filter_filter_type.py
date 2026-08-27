# coding: utf-8

"""
    Kestra EE

    All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.
"""  # noqa: E501


from __future__ import annotations
import json
from enum import Enum
from typing_extensions import Self


class AbstractFilterFilterType(str, Enum):
    """
    AbstractFilterFilterType
    """

    """
    allowed enum values
    """
    CONTAINS = 'CONTAINS'
    ENDS_WITH = 'ENDS_WITH'
    EQUAL_TO = 'EQUAL_TO'
    GREATER_THAN = 'GREATER_THAN'
    GREATER_THAN_OR_EQUAL_TO = 'GREATER_THAN_OR_EQUAL_TO'
    IN = 'IN'
    IS_FALSE = 'IS_FALSE'
    IS_NOT_NULL = 'IS_NOT_NULL'
    IS_NULL = 'IS_NULL'
    IS_TRUE = 'IS_TRUE'
    LESS_THAN = 'LESS_THAN'
    LESS_THAN_OR_EQUAL_TO = 'LESS_THAN_OR_EQUAL_TO'
    NOT_CONTAINS = 'NOT_CONTAINS'
    NOT_EQUAL_TO = 'NOT_EQUAL_TO'
    NOT_IN = 'NOT_IN'
    OR = 'OR'
    REGEX = 'REGEX'
    STARTS_WITH = 'STARTS_WITH'
    PREFIX = 'PREFIX'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of AbstractFilterFilterType from a JSON string"""
        return cls(json.loads(json_str))
