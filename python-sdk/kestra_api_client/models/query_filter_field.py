# coding: utf-8

"""
    Kestra EE

    All API operations allow an optional tenant identifier in the HTTP path, if you don't use multi-tenancy you must omit the tenant identifier.<br/> This means that, for example, when trying to access the Flows API, instead of using <code>/api/v1/{tenant}/flows</code> you must use <code>/api/v1/flows</code>.

    The version of the OpenAPI document: v1
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import json
from enum import Enum
from typing_extensions import Self


class QueryFilterField(str, Enum):
    """
    QueryFilterField
    """

    """
    allowed enum values
    """
    QUERY = 'QUERY'
    SCOPE = 'SCOPE'
    NAMESPACE = 'NAMESPACE'
    LABELS = 'LABELS'
    FLOW_ID = 'FLOW_ID'
    START_DATE = 'START_DATE'
    END_DATE = 'END_DATE'
    STATE = 'STATE'
    TIME_RANGE = 'TIME_RANGE'
    TRIGGER_EXECUTION_ID = 'TRIGGER_EXECUTION_ID'
    TRIGGER_ID = 'TRIGGER_ID'
    CHILD_FILTER = 'CHILD_FILTER'
    WORKER_ID = 'WORKER_ID'
    EXISTING_ONLY = 'EXISTING_ONLY'
    MIN_LEVEL = 'MIN_LEVEL'

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of QueryFilterField from a JSON string"""
        return cls(json.loads(json_str))


