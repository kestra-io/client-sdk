"""Tests for the query_filter module (filter encoding into query params)."""

from kestrapy.query_filter import append_filter_params, _to_camel_case, _FIELD_MAP
from kestrapy import QueryFilter, QueryFilterField, QueryFilterOp


# ========================================================================
# _to_camel_case
# ========================================================================

def test_to_camel_case_single_word():
    assert _to_camel_case("LABELS") == "labels"


def test_to_camel_case_two_words():
    assert _to_camel_case("FLOW_ID") == "flowId"


def test_to_camel_case_three_words():
    assert _to_camel_case("START_DATE") == "startDate"


# ========================================================================
# _FIELD_MAP overrides
# ========================================================================

def test_field_map_query_is_q():
    assert _FIELD_MAP["QUERY"] == "q"


def test_field_map_min_level_is_level():
    assert _FIELD_MAP["MIN_LEVEL"] == "level"


# ========================================================================
# append_filter_params - scalar values
# ========================================================================

def test_scalar_filter_basic():
    params = []
    filters = [
        QueryFilter(
            var_field=QueryFilterField.NAMESPACE,
            operation=QueryFilterOp.EQUALS,
            value={"value": "my.namespace"},
        )
    ]
    append_filter_params(params, filters)
    assert ("filters[namespace][EQUALS]", "my.namespace") in params


def test_query_field_uses_q():
    params = []
    filters = [
        QueryFilter(
            var_field=QueryFilterField.QUERY,
            operation=QueryFilterOp.EQUALS,
            value={"value": "hello world"},
        )
    ]
    append_filter_params(params, filters)
    assert ("filters[q][EQUALS]", "hello world") in params


def test_min_level_field_uses_level():
    params = []
    filters = [
        QueryFilter(
            var_field=QueryFilterField.MIN_LEVEL,
            operation=QueryFilterOp.EQUALS,
            value={"value": "INFO"},
        )
    ]
    append_filter_params(params, filters)
    assert ("filters[level][EQUALS]", "INFO") in params


def test_flow_id_field_camel_case():
    params = []
    filters = [
        QueryFilter(
            var_field=QueryFilterField.FLOW_ID,
            operation=QueryFilterOp.EQUALS,
            value={"value": "my-flow"},
        )
    ]
    append_filter_params(params, filters)
    assert ("filters[flowId][EQUALS]", "my-flow") in params


# ========================================================================
# append_filter_params - map values (e.g. labels)
# ========================================================================

def test_map_value_expanded():
    params = []
    filters = [
        QueryFilter(
            var_field=QueryFilterField.LABELS,
            operation=QueryFilterOp.EQUALS,
            value={"env": "prod", "team": "backend"},
        )
    ]
    append_filter_params(params, filters)
    assert ("filters[labels][EQUALS][env]", "prod") in params
    assert ("filters[labels][EQUALS][team]", "backend") in params


def test_map_value_with_dict_filter():
    """Test that plain dict filters (not QueryFilter model) also work."""
    params = []
    filters = [
        {"field": "ID", "operation": "EQUALS", "value": {"a": "b", "c": "d"}},
    ]
    append_filter_params(params, filters)
    assert ("filters[id][EQUALS][a]", "b") in params
    assert ("filters[id][EQUALS][c]", "d") in params


# ========================================================================
# append_filter_params - empty / None
# ========================================================================

def test_empty_filters():
    params = []
    append_filter_params(params, [])
    assert len(params) == 0


def test_none_filters():
    params = []
    append_filter_params(params, None)
    assert len(params) == 0


# ========================================================================
# Multiple filters
# ========================================================================

def test_multiple_filters():
    params = []
    filters = [
        QueryFilter(
            var_field=QueryFilterField.NAMESPACE,
            operation=QueryFilterOp.EQUALS,
            value={"value": "ns1"},
        ),
        QueryFilter(
            var_field=QueryFilterField.FLOW_ID,
            operation=QueryFilterOp.EQUALS,
            value={"value": "flow1"},
        ),
    ]
    append_filter_params(params, filters)
    assert ("filters[namespace][EQUALS]", "ns1") in params
    assert ("filters[flowId][EQUALS]", "flow1") in params
