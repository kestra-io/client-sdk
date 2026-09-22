"""Fluent DSL for building complex AND/OR query filters (issue #246).

Typed against the field/op/logical enums, this layer constructs
``QueryFilter`` trees that drop straight into any ``*ByQuery`` method::

    from kestrapy.query import where, and_, or_, eq, in_
    from kestrapy import QueryFilterField as F
    from kestrapy.models.state_type import StateType

    filters = where(
        and_(
            eq(F.NAMESPACE, "prod"),
            or_(
                eq(F.FLOW_ID, "a"),
                eq(F.FLOW_ID, "b"),
            ),
        )
    )
    client.search_executions(tenant="main", filters=filters)

``where`` returns ``list[QueryFilter]`` — the exact type every ``*ByQuery``
method already accepts.
"""

from typing import Any, List, Optional

from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.query_filter_field import QueryFilterField
from kestrapy.models.query_filter_logical import QueryFilterLogical
from kestrapy.models.query_filter_op import QueryFilterOp

__all__ = [
    "where",
    "and_",
    "or_",
    "filter_",
    "eq",
    "not_eq",
    "in_",
    "not_in",
    "contains",
    "starts_with",
    "ends_with",
    "regex",
    "prefix",
    "gt",
    "gte",
    "lt",
    "lte",
]


def filter_(
    field: QueryFilterField, op: QueryFilterOp, value: Any = None
) -> QueryFilter:
    """Build a single leaf filter."""
    return QueryFilter(var_field=field, operation=op, value=value)


# --- convenience leaves -----------------------------------------------------

def eq(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.EQUALS, value)


def not_eq(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.NOT_EQUALS, value)


def in_(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.IN, value)


def not_in(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.NOT_IN, value)


def contains(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.CONTAINS, value)


def starts_with(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.STARTS_WITH, value)


def ends_with(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.ENDS_WITH, value)


def regex(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.REGEX, value)


def prefix(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.PREFIX, value)


def gt(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.GREATER_THAN, value)


def gte(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.GREATER_THAN_OR_EQUAL_TO, value)


def lt(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.LESS_THAN, value)


def lte(field: QueryFilterField, value: Any) -> QueryFilter:
    return filter_(field, QueryFilterOp.LESS_THAN_OR_EQUAL_TO, value)


# --- groups -----------------------------------------------------------------

def _is_empty_group(node: QueryFilter) -> bool:
    # Unified with the Java DSL's isEmptyGroup (issue #246 review): a node is an
    # empty group iff it is not a leaf (no field) and has no children. A leaf
    # (field set) is never an empty group.
    return (
        getattr(node, "var_field", None) is None
        and not getattr(node, "children", None)
    )


def _group(
    logical: QueryFilterLogical, children: tuple
) -> Optional[QueryFilter]:
    effective = [
        c for c in children if c is not None and not _is_empty_group(c)
    ]
    if not effective:
        return None
    if len(effective) == 1:
        return effective[0]
    return QueryFilter(logical=logical, children=effective)


def and_(*children: Optional[QueryFilter]) -> Optional[QueryFilter]:
    """AND-group its children (dropping None/empty; single-child flattens)."""
    return _group(QueryFilterLogical.AND, children)


def or_(*children: Optional[QueryFilter]) -> Optional[QueryFilter]:
    """OR-group its children (dropping None/empty; single-child flattens)."""
    return _group(QueryFilterLogical.OR, children)


# --- root -------------------------------------------------------------------

def where(root: Optional[QueryFilter]) -> List[QueryFilter]:
    """Turn a filter tree into the ``list[QueryFilter]`` ``*ByQuery`` expects.

    - ``None`` root -> ``[]``.
    - A top-level AND group -> its children flattened one level.
    - Anything else -> ``[root]``.
    """
    if root is None:
        return []
    logical = getattr(root, "logical", None)
    children = getattr(root, "children", None)
    if (
        logical is not None
        and str(logical.value if hasattr(logical, "value") else logical).lower()
        == "and"
        and children is not None
    ):
        return list(children)
    return [root]
