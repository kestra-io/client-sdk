import unittest

from kestrapy.api_client import ApiClient

class TestQueryFilters(unittest.TestCase):
    def test_parameters_to_tuples_queryfilter_map_value_is_expanded_for_any_field(self):
        client = ApiClient()

        # Use dict filter objects because the generated QueryFilter model currently types `value` as a dict.
        filters = [
            {"field": "ID", "operation": "EQUALS", "value": {"a": "b", "c": "d"}},
        ]

        tuples = client.parameters_to_tuples({"filters": filters}, collection_formats={})

        assert ("filters[id][EQUALS][a]", "b") in tuples
        assert ("filters[id][EQUALS][c]", "d") in tuples


    def test_parameters_to_url_query_query_field_is_q_and_encoded(self):
        client = ApiClient()

        filters = [
            {"field": "QUERY", "operation": "EQUALS", "value": "hello world"},
        ]

        query = client.parameters_to_url_query({"filters": filters}, collection_formats={})

        assert "filters[q][EQUALS]=hello%20world" in query


    def test_parameters_to_url_query_map_value_is_expanded_for_any_field(self):
        client = ApiClient()

        filters = [
            {"field": "ID", "operation": "EQUALS", "value": {"a": "b", "c": "d"}},
        ]

        query = client.parameters_to_url_query({"filters": filters}, collection_formats={})

        assert "filters[id][EQUALS][a]=b" in query
        assert "filters[id][EQUALS][c]=d" in query

