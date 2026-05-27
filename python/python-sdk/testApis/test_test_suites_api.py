import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    log_flow_yaml,
    create_flow,
)
from kestrapy import (
    TestSuiteControllerTestSuiteBulkRequest,
    TestSuiteControllerTestSuiteApiId,
    TestSuiteControllerSearchTestsLastResult,
    TestSuiteServiceRunByQueryRequest,
    ApiException,
)


def _test_suite_yaml(suite_id, namespace, flow_id):
    return (
        f"id: {suite_id}\n"
        f"namespace: {namespace}\n"
        f"flowId: {flow_id}\n"
        "disabled: false\n"
        "testCases:\n"
        "  - id: test_case_1\n"
        "    type: io.kestra.core.test.flow.UnitTest\n"
        "    description: Basic test case\n"
        "    assertions:\n"
        "      - taskId: hello\n"
        '        value: "{{ outputs.hello }}"\n'
        "        isNotNull: true\n"
    )


def _create_flow_and_suite(client, suite_id=None):
    ns = random_id()
    flow_id = random_id()
    if suite_id is None:
        suite_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))
    return ns, flow_id, suite_id


# ========================================================================
# CRUD
# ========================================================================


def test_create_test_suite_basic(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)

    result = client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    assert result is not None
    assert result.namespace == ns


def test_test_suite_get_by_namespace_and_id(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    result = client.test_suites.test_suite(namespace=ns, id=suite_id, tenant=TENANT)

    assert result is not None
    assert result.id == suite_id


def test_delete_test_suite_basic(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    # Should not raise
    client.test_suites.delete_test_suite(namespace=ns, id=suite_id, tenant=TENANT)


# ========================================================================
# Search
# ========================================================================


def test_search_test_suites_basic(client):
    result = client.test_suites.search_test_suites(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.results is not None


def test_search_test_suites_with_include_child_namespaces(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    # Searching at the parent namespace with include_child_namespaces=True
    # should still find the suite even if it lives under a child namespace.
    result = client.test_suites.search_test_suites(
        tenant=TENANT, page=1, size=50,
        namespace=ns, include_child_namespaces=True,
    )

    assert result is not None
    assert result.results is not None


def test_search_test_suites_with_namespace_and_flow_id(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    by_ns = client.test_suites.search_test_suites(
        tenant=TENANT, page=1, size=10, namespace=ns
    )
    assert by_ns is not None
    assert by_ns.results is not None

    by_flow_id = client.test_suites.search_test_suites(
        tenant=TENANT, page=1, size=10, namespace=ns, flow_id=flow_id
    )
    assert by_flow_id is not None
    assert by_flow_id.results is not None
    assert len(by_flow_id.results) > 0
    for ts in by_flow_id.results:
        assert ts.flow_id == flow_id


def test_search_test_suites_with_sort(client):
    ns, flow_id, _ = _create_flow_and_suite(client)

    suite_id1 = f"aaa{random_id()}"
    suite_id2 = f"zzz{random_id()}"
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id2, ns, flow_id)
    )
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id1, ns, flow_id)
    )

    sorted_result = client.test_suites.search_test_suites(
        tenant=TENANT, page=1, size=10, sort=["id:asc"], namespace=ns
    )
    assert len(sorted_result.results) >= 2
    ids = [ts.id for ts in sorted_result.results]
    assert ids.index(suite_id1) < ids.index(suite_id2)


def test_search_test_suites_no_results(client):
    result = client.test_suites.search_test_suites(
        tenant=TENANT, page=1, size=10, namespace=f"nonexistent_ns_{random_id()}"
    )

    assert result is not None
    assert len(result.results) == 0


# ========================================================================
# Results
# ========================================================================


def test_search_test_suites_results_all_params(client):
    result = client.test_suites.search_test_suites_results(
        tenant=TENANT, page=1, size=10
    )
    assert result is not None
    assert result.results is not None

    sorted_result = client.test_suites.search_test_suites_results(
        tenant=TENANT, page=1, size=10, sort=["id:asc"]
    )
    assert sorted_result is not None
    assert sorted_result.results is not None

    by_ns = client.test_suites.search_test_suites_results(
        tenant=TENANT, page=1, size=10, namespace="nonexistent_ns"
    )
    assert by_ns is not None
    assert len(by_ns.results) == 0

    by_suite_id = client.test_suites.search_test_suites_results(
        tenant=TENANT, page=1, size=10, test_suite_id="nonexistent_suite"
    )
    assert by_suite_id is not None
    assert len(by_suite_id.results) == 0

    by_flow_id = client.test_suites.search_test_suites_results(
        tenant=TENANT, page=1, size=10, flow_id="nonexistent_flow"
    )
    assert by_flow_id is not None
    assert len(by_flow_id.results) == 0


# ========================================================================
# Validation
# ========================================================================


def test_validate_test_suite_valid(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)

    result = client.test_suites.validate_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    assert result is not None


# ========================================================================
# Update
# ========================================================================


def test_update_test_suite_basic(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    updated_yaml = _test_suite_yaml(suite_id, ns, flow_id).replace(
        "Basic test case", "Updated test case"
    )
    result = client.test_suites.update_test_suite(
        namespace=ns, id=suite_id, tenant=TENANT, yaml_body=updated_yaml
    )

    assert result is not None
    assert result.id == suite_id


# ========================================================================
# Bulk operations
# ========================================================================


def test_delete_test_suites_by_ids_basic(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    request = TestSuiteControllerTestSuiteBulkRequest(
        ids=[TestSuiteControllerTestSuiteApiId(namespace=ns, id=suite_id)]
    )

    result = client.test_suites.delete_test_suites_by_ids(
        tenant=TENANT, request=request
    )

    assert result is not None


def test_enable_disable_test_suites_by_ids_basic(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    request = TestSuiteControllerTestSuiteBulkRequest(
        ids=[TestSuiteControllerTestSuiteApiId(namespace=ns, id=suite_id)]
    )

    disabled = client.test_suites.disable_test_suites_by_ids(
        tenant=TENANT, request=request
    )
    assert disabled is not None

    enabled = client.test_suites.enable_test_suites_by_ids(
        tenant=TENANT, request=request
    )
    assert enabled is not None


# ========================================================================
# Run
# ========================================================================


def test_run_test_suite_basic(client):
    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    result = client.test_suites.run_test_suite(
        namespace=ns, id=suite_id, tenant=TENANT
    )

    assert result is not None


def test_run_test_suite_with_request_body(client):
    from kestrapy import TestSuiteControllerRunRequest

    ns, flow_id, suite_id = _create_flow_and_suite(client)
    client.test_suites.create_test_suite(
        tenant=TENANT, yaml_body=_test_suite_yaml(suite_id, ns, flow_id)
    )

    # The optional request body lets the caller restrict execution to a
    # subset of test cases. Our fixture defines a single case `test_case_1`.
    request = TestSuiteControllerRunRequest(test_cases=["test_case_1"])
    result = client.test_suites.run_test_suite(
        namespace=ns, id=suite_id, tenant=TENANT, request=request,
    )

    assert result is not None


def test_run_test_suites_by_query_basic(client):
    request = TestSuiteServiceRunByQueryRequest(include_child_namespaces=False)

    result = client.test_suites.run_test_suites_by_query(
        tenant=TENANT, request=request
    )

    assert result is not None


# ========================================================================
# Results details
# ========================================================================


def test_tests_last_result_basic(client):
    request = TestSuiteControllerSearchTestsLastResult(test_suite_ids=[])

    result = client.test_suites.tests_last_result(tenant=TENANT, request=request)

    assert result is not None


# ========================================================================
# 404 edge cases
# ========================================================================


def test_test_suite_get_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.test_suites.test_suite(
            namespace=f"missing-ns-{random_id()}",
            id=f"missing-id-{random_id()}",
            tenant=TENANT,
        )
    assert exc_info.value.status in (400, 404)


def test_delete_test_suite_unknown_id_raises(client):
    try:
        client.test_suites.delete_test_suite(
            namespace=f"missing-ns-{random_id()}",
            id=f"missing-id-{random_id()}",
            tenant=TENANT,
        )
    except ApiException as e:
        assert e.status in (400, 404)
