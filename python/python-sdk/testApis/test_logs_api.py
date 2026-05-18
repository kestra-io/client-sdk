import time

import pytest

from kestrapy.exceptions import ApiException
from test_helpers import (
    TENANT,
    random_id,
    log_flow_yaml,
    create_flow,
    ns_filter,
    flow_id_filter,
    execution_id_filter,
    min_level_filter,
    create_execution_with_logs,
    wait_for_execution,
)


# ========================================================================
# List logs
# ========================================================================

def test_list_logs_from_execution_basic(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    logs = client.logs.list_logs_from_execution(execution_id, TENANT)

    assert logs is not None
    assert len(logs) > 0
    assert logs[0].execution_id == execution_id


def test_list_logs_from_execution_with_min_level(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    logs = client.logs.list_logs_from_execution(execution_id, TENANT, min_level="INFO")

    assert logs is not None
    for log in logs:
        assert log.level is not None


def test_list_logs_from_execution_with_task_id(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    # Retry to allow indexing
    for _ in range(20):
        logs = client.logs.list_logs_from_execution(execution_id, TENANT, task_id="hello")
        if logs and len(logs) > 0:
            break
        time.sleep(0.5)

    assert logs is not None
    assert len(logs) > 0
    assert all(log.task_id == "hello" for log in logs)


# ========================================================================
# Download logs
# ========================================================================

def test_download_logs_from_execution_basic(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    content = client.logs.download_logs_from_execution(execution_id, TENANT)

    assert content is not None
    assert len(content) > 0


# ========================================================================
# Search logs
# ========================================================================

def test_search_logs_basic(client):
    create_execution_with_logs(client)

    result = client.logs.search_logs(TENANT, 1, 10)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0
    assert all(r.execution_id is not None for r in result.results)


def test_search_logs_with_pagination(client):
    result = client.logs.search_logs(TENANT, 1, 5)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 5


def test_search_logs_with_namespace_filter(client):
    ns = random_id()
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))
    exec_resp = client.executions.create_execution(TENANT, ns, flow_id)
    wait_for_execution(client, exec_resp.id)

    # Retry to allow log indexing
    result = None
    for _ in range(20):
        result = client.logs.search_logs(TENANT, 1, 25, filters=[ns_filter(ns)])
        if result and result.results and len(result.results) > 0:
            break
        time.sleep(0.5)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_logs_with_flow_id_and_namespace_filter(client):
    ns = random_id()
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))
    exec_resp = client.executions.create_execution(TENANT, ns, flow_id)
    wait_for_execution(client, exec_resp.id)

    result = None
    for _ in range(20):
        result = client.logs.search_logs(
            TENANT, 1, 25, filters=[ns_filter(ns), flow_id_filter(flow_id)]
        )
        if result and result.results and len(result.results) > 0:
            break
        time.sleep(0.5)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_logs_with_execution_id_filter(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    result = None
    for _ in range(20):
        result = client.logs.search_logs(
            TENANT, 1, 25, filters=[execution_id_filter(execution_id)]
        )
        if result and result.results and len(result.results) > 0:
            break
        time.sleep(0.5)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0
    assert all(r.execution_id == execution_id for r in result.results)


def test_search_logs_with_flow_id_filter(client):
    ns = random_id()
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))
    exec_resp = client.executions.create_execution(TENANT, ns, flow_id)
    wait_for_execution(client, exec_resp.id)

    result = None
    for _ in range(20):
        result = client.logs.search_logs(
            TENANT, 1, 25, filters=[flow_id_filter(flow_id), ns_filter(ns)]
        )
        if result and result.results and len(result.results) > 0:
            break
        time.sleep(0.5)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_logs_with_sort(client):
    ns = random_id()
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))

    client.executions.create_execution(TENANT, ns, flow_id)
    client.executions.create_execution(TENANT, ns, flow_id)

    result = None
    for _ in range(30):
        result = client.logs.search_logs(
            TENANT, 1, 25, sort=["timestamp:desc"], filters=[ns_filter(ns)]
        )
        if result and result.results and len(result.results) >= 2:
            break
        time.sleep(0.5)

    assert result is not None
    assert len(result.results) >= 2
    # Verify descending order
    for i in range(len(result.results) - 1):
        assert result.results[i].timestamp >= result.results[i + 1].timestamp


def test_search_logs_with_min_level_filter(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    result = None
    for _ in range(20):
        result = client.logs.search_logs(
            TENANT, 1, 25,
            filters=[execution_id_filter(execution_id), min_level_filter("INFO")],
        )
        if result and result.results and len(result.results) > 0:
            break
        time.sleep(0.5)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_logs_no_results(client):
    result = client.logs.search_logs(
        TENANT, 1, 10, filters=[ns_filter("nonexistent_ns_" + random_id())]
    )

    assert result is not None
    assert result.results is not None
    assert len(result.results) == 0


# ========================================================================
# Delete logs
# ========================================================================

def test_delete_logs_from_execution_basic(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    # Should not raise
    client.logs.delete_logs_from_execution(execution_id, TENANT)


def test_delete_logs_from_execution_with_min_level(client):
    execution_id, ns, flow_id = create_execution_with_logs(client)

    # Should not raise
    client.logs.delete_logs_from_execution(execution_id, TENANT, min_level="TRACE")


def test_delete_logs_from_flow_basic(client):
    ns = random_id()
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))

    exec_resp = client.executions.create_execution(TENANT, ns, flow_id)
    wait_for_execution(client, exec_resp.id)

    # Should not raise
    client.logs.delete_logs_from_flow(ns, flow_id, "hello", TENANT)
