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
    where,
)
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
    if "logical" in node:
        return QueryFilter(
            logical=QueryFilterLogical[node["logical"]],
            children=[_build(child) for child in node["children"]],
        )
    return QueryFilter(
        var_field=QueryFilterField[node["field"]],
        operation=QueryFilterOp[node["op"]],
        value=node.get("value"),
    )


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
