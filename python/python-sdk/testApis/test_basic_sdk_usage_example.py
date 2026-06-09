"""Executes the README usage example end-to-end.

This is the CI guarantee for the curated snippet: if the example in
`basic_sdk_usage_example.py` (and therefore the injected README block) ever
stops matching the SDK, this test fails against the live Kestra container.
"""
from basic_sdk_usage_example import search_and_create_flow
from test_helpers import TENANT, register_namespace


def test_search_and_create_flow_example(client):
    # The example creates company.team/hello_from_sdk; register the namespace
    # so the autouse GC purges it, and delete the flow ourselves so the example
    # is re-runnable within a session.
    register_namespace("company.team")
    try:
        created = search_and_create_flow(client, TENANT)

        assert created.id == "hello_from_sdk"
        assert created.namespace == "company.team"
        assert created.revision >= 1
    finally:
        try:
            client.flows.delete_flow("company.team", "hello_from_sdk", TENANT)
        except Exception:
            pass
