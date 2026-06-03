import time

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
    wait_for_execution,
)

# The shared flow is a Log task, so `succeeded_execution` doubles as "an
# execution with logs" — read-only tests consume it instead of spawning a
# namespace+flow+execution each (server-side state feeds the CI OOM).
# Tests that DELETE logs use `fresh_execution` (or their own flow) so the
# shared execution's logs stay intact for later tests.


# ========================================================================
# List logs
# ========================================================================

def test_list_logs_from_execution_basic(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    logs = client.logs.list_logs_from_execution(execution_id, TENANT)

    assert logs is not None
    assert len(logs) > 0
    assert logs[0].execution_id == execution_id


def test_list_logs_from_execution_with_min_level(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    logs = client.logs.list_logs_from_execution(execution_id, TENANT, min_level="INFO")

    assert logs is not None
    for log in logs:
        assert log.level is not None


def test_list_logs_from_execution_with_task_id(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

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

def test_download_logs_from_execution_basic(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    content = client.logs.download_logs_from_execution(execution_id, TENANT)

    assert content is not None
    assert len(content) > 0


def test_download_logs_from_execution_with_min_level(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    content = client.logs.download_logs_from_execution(
        execution_id, TENANT, min_level="INFO",
    )
    assert content is not None


def test_download_logs_from_execution_with_task_filters(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    content = client.logs.download_logs_from_execution(
        execution_id, TENANT, task_id="hello", attempt=0,
    )
    assert content is not None


def test_list_logs_from_execution_with_attempt_and_trace_level(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    logs = client.logs.list_logs_from_execution(
        execution_id, TENANT, min_level="TRACE", attempt=0,
    )
    assert logs is not None


def test_list_logs_from_execution_with_debug_level(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    logs = client.logs.list_logs_from_execution(
        execution_id, TENANT, min_level="DEBUG",
    )
    assert logs is not None


def test_list_logs_from_execution_with_error_level(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    # A successful flow emits only INFO; an ERROR filter should yield
    # an empty list (the call still succeeds).
    logs = client.logs.list_logs_from_execution(
        execution_id, TENANT, min_level="ERROR",
    )
    assert logs is not None
    assert len(logs) == 0


# ========================================================================
# Search logs
# ========================================================================

def test_search_logs_basic(client, succeeded_execution):
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


def test_search_logs_with_namespace_filter(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

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


def test_search_logs_with_flow_id_and_namespace_filter(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

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


def test_search_logs_with_execution_id_filter(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

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


def test_search_logs_with_flow_id_filter(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

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


def test_search_logs_with_sort(client, shared_flow):
    ns, flow_id = shared_flow

    client.executions.create_execution(TENANT, ns, flow_id)
    # Server sorts at millisecond precision, so space the two runs apart
    # to guarantee distinct millisecond buckets.
    time.sleep(0.05)
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
    # Verify descending order at millisecond precision (the server's sort granularity).
    def _to_ms(ts):
        return ts.replace(microsecond=(ts.microsecond // 1000) * 1000)
    for i in range(len(result.results) - 1):
        assert _to_ms(result.results[i].timestamp) >= _to_ms(result.results[i + 1].timestamp)


def test_search_logs_with_min_level_filter(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

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

def test_delete_logs_from_execution_basic(client, fresh_execution):
    execution_id, ns, flow_id = fresh_execution

    # Should not raise
    client.logs.delete_logs_from_execution(execution_id, TENANT)


def test_delete_logs_from_execution_with_min_level(client, fresh_execution):
    execution_id, ns, flow_id = fresh_execution

    # Should not raise
    client.logs.delete_logs_from_execution(execution_id, TENANT, min_level="TRACE")


# ========================================================================
# Follow logs (SSE)
# ========================================================================


def test_follow_logs_from_execution_basic(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    # The server interleaves empty {} keepalive frames with real log
    # events; collect a handful and assert on the real ones.
    events = []
    real_events = []
    deadline = time.time() + 8
    for event in client.logs.follow_logs_from_execution(execution_id, TENANT):
        events.append(event)
        if event.execution_id is not None:
            real_events.append(event)
        if time.time() > deadline or len(real_events) >= 1:
            break

    assert len(real_events) > 0
    assert real_events[0].execution_id == execution_id
    assert real_events[0].message is not None


def test_follow_logs_from_execution_with_min_level(client, succeeded_execution):
    execution_id, ns, flow_id = succeeded_execution

    # min_level=INFO matches the log flow's emitted level; we exercise
    # the parameter and verify the events that come through respect it.
    events = []
    deadline = time.time() + 8
    for event in client.logs.follow_logs_from_execution(execution_id, TENANT, min_level="INFO"):
        if event.execution_id is not None:
            events.append(event)
        if time.time() > deadline or len(events) >= 1:
            break

    assert len(events) > 0
    for e in events:
        if e.level is not None:
            # `level` is a Level enum — str() would yield 'Level.INFO'.
            level_str = getattr(e.level, "value", str(e.level)).upper()
            assert level_str in ("INFO", "WARN", "ERROR")


def test_delete_logs_from_flow_basic(client, shared_flow):
    # Deleting logs is flow-wide, so use a private flow (in the shared
    # namespace) to keep the shared execution's logs intact.
    ns, _ = shared_flow
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))

    exec_resp = client.executions.create_execution(TENANT, ns, flow_id)
    wait_for_execution(client, exec_resp.id)

    # Should not raise
    client.logs.delete_logs_from_flow(ns, flow_id, "hello", TENANT)
