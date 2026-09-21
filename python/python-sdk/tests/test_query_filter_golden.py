"""JSON-driven offline serializer tests for complex query filters (issue #246).

Drives the shared golden vectors in ``test-utils/query-filter-golden.json`` —
every SDK asserts against the SAME expected wire strings so the implementations
cannot drift. No running Kestra is required; this is a pure serializer test.
"""

import json
from pathlib import Path

import pytest

from kestrapy import (
    QueryFilter,
    QueryFilterField,
    QueryFilterLogical,
    QueryFilterOp,
)
from kestrapy.query import where
from kestrapy.query_filter import append_filter_params


def _find_golden() -> Path:
    """Locate test-utils/query-filter-golden.json by walking up from here."""
    here = Path(__file__).resolve()
    for parent in here.parents:
        candidate = parent / "test-utils" / "query-filter-golden.json"
        if candidate.is_file():
            return candidate
    raise FileNotFoundError(
        "Could not locate test-utils/query-filter-golden.json"
    )


def _build(node: dict) -> QueryFilter:
    """Build a QueryFilter from a golden node (leaf or group)."""
    # Explicit logical -> group via logical + children.
    if "logical" in node:
        return QueryFilter(
            logical=QueryFilterLogical[node["logical"]],
            children=[_build(child) for child in node.get("children", [])],
        )
    # Children present but NO logical and NO field -> a raw group node (logical
    # None) so the serializer's default-AND path is exercised.
    if "children" in node and "field" not in node:
        return QueryFilter(children=[_build(child) for child in node["children"]])
    leaf_kwargs = dict(
        var_field=QueryFilterField[node["field"]],
        operation=QueryFilterOp[node["op"]],
        value=node.get("value"),
    )
    # An empty children list on a leaf is ignored (still a leaf); attach it so
    # that path is exercised.
    if "children" in node:
        leaf_kwargs["children"] = [_build(child) for child in node["children"]]
    return QueryFilter(**leaf_kwargs)


def _load_cases():
    data = json.loads(_find_golden().read_text())
    return [(case["name"], case) for case in data["cases"]]


_CASES = _load_cases()


@pytest.mark.parametrize("name, case", _CASES, ids=[n for n, _ in _CASES])
def test_golden_vector(name, case):
    inp = case["input"]
    if "where" in inp:
        filters = where(_build(inp["where"]))
    else:
        filters = [_build(node) for node in inp["list"]]

    params: list = []
    append_filter_params(params, filters)
    actual = ["%s=%s" % (k, v) for k, v in params]
    assert actual == case["expected"]


def test_all_golden_cases_present():
    # Guard against silently skipping the whole suite.
    assert len(_CASES) >= 12


# ---------------------------------------------------------------------------
# Per-SDK cases (SPEC "Python" section)
# ---------------------------------------------------------------------------

def test_level_field_serializes_to_level():
    # MIN_LEVEL -> level: QueryFilterField.LEVEL (value 'level').
    params: list = []
    filters = [
        QueryFilter(
            var_field=QueryFilterField.LEVEL,
            operation=QueryFilterOp.EQUALS,
            value="INFO",
        )
    ]
    append_filter_params(params, filters)
    assert ["%s=%s" % (k, v) for k, v in params] == [
        "filters[level][EQUALS]=INFO"
    ]


def test_nested_deeper_than_one_level_raises():
    inner_and = QueryFilter(
        logical=QueryFilterLogical.AND,
        children=[
            QueryFilter(
                var_field=QueryFilterField.SCOPE,
                operation=QueryFilterOp.EQUALS,
                value="s1",
            ),
            QueryFilter(
                var_field=QueryFilterField.FLOW_ID,
                operation=QueryFilterOp.EQUALS,
                value="f",
            ),
        ],
    )
    mid_or = QueryFilter(
        logical=QueryFilterLogical.OR,
        children=[
            inner_and,
            QueryFilter(
                var_field=QueryFilterField.SCOPE,
                operation=QueryFilterOp.EQUALS,
                value="s2",
            ),
        ],
    )
    top_and = QueryFilter(
        logical=QueryFilterLogical.AND,
        children=[
            mid_or,
            QueryFilter(
                var_field=QueryFilterField.NAMESPACE,
                operation=QueryFilterOp.EQUALS,
                value="ns",
            ),
        ],
    )
    params: list = []
    with pytest.raises(ValueError, match="one level"):
        append_filter_params(params, [top_and])


def test_ambiguous_leaf_and_group_raises():
    ambiguous = QueryFilter(
        var_field=QueryFilterField.NAMESPACE,
        operation=QueryFilterOp.EQUALS,
        value="ns",
        logical=QueryFilterLogical.AND,
        children=[
            QueryFilter(
                var_field=QueryFilterField.SCOPE,
                operation=QueryFilterOp.EQUALS,
                value="s1",
            )
        ],
    )
    params: list = []
    with pytest.raises(ValueError, match="both a leaf and a group"):
        append_filter_params(params, [ambiguous])


def test_null_value_serializes_to_empty_string():
    # A valueless leaf -> filters[namespace][EQUALS]= (consistent with Go/Java, not "None").
    f = QueryFilter(var_field=QueryFilterField.NAMESPACE, operation=QueryFilterOp.EQUALS, value=None)
    params: list = []
    append_filter_params(params, [f])
    assert params == [("filters[namespace][EQUALS]", "")]


def test_bool_list_serializes_lowercase():
    # Booleans inside a list must serialize lowercase (true,false) — same as a
    # bare bool — matching Java. The list branch used to use str(v) -> True,False.
    f = QueryFilter(
        var_field=QueryFilterField.STATE,
        operation=QueryFilterOp.IN,
        value=[True, False],
    )
    params: list = []
    append_filter_params(params, [f])
    assert ["%s=%s" % (k, v) for k, v in params] == [
        "filters[state][IN]=true,false"
    ]


def test_null_field_leaf_raises():
    f = QueryFilter(operation=QueryFilterOp.EQUALS, value="x")
    params: list = []
    with pytest.raises(ValueError, match="requires a field"):
        append_filter_params(params, [f])


def test_group_without_logical_defaults_to_and():
    # A raw group node with no logical set is an implicit AND.
    group = QueryFilter(children=[
        QueryFilter(var_field=QueryFilterField.NAMESPACE, operation=QueryFilterOp.EQUALS, value="ns"),
        QueryFilter(var_field=QueryFilterField.FLOW_ID, operation=QueryFilterOp.EQUALS, value="f"),
    ])
    params: list = []
    append_filter_params(params, [group])
    assert ["%s=%s" % (k, v) for k, v in params] == [
        "filters[namespace][EQUALS]=ns",
        "filters[flowId][EQUALS]=f",
    ]


# ---------------------------------------------------------------------------
# DSL drop / flatten rules (issue #246 review)
# ---------------------------------------------------------------------------

def test_dsl_drops_null_and_empty_then_flattens():
    from kestrapy.query import and_, or_, eq
    root = and_(eq(QueryFilterField.NAMESPACE, "ns"), None, or_())
    # None and the empty or() group are dropped; a single effective child flattens.
    assert root.var_field == QueryFilterField.NAMESPACE
    assert getattr(root, "logical", None) is None


def test_dsl_single_child_group_flattens():
    from kestrapy.query import or_, eq
    root = or_(eq(QueryFilterField.SCOPE, "s1"))
    assert root.var_field == QueryFilterField.SCOPE
    assert getattr(root, "logical", None) is None


def test_dsl_empty_group_is_none():
    from kestrapy.query import and_, or_
    assert and_() is None
    assert or_(and_(), None) is None
