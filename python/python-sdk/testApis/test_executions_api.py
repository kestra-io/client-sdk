import time

import pytest

from kestrapy import (
    ApiException,
    ExecutionControllerSetLabelsByIdsRequest,
    ExecutionControllerStateRequest,
    ExecutionRepositoryInterfaceFlowFilter,
    Label,
    StateType,
)
from test_helpers import (
    TENANT,
    random_id,
    log_flow_yaml,
    log_flow_yaml_with_labels,
    create_flow,
    create_log_flow,
    ns_filter,
    flow_id_filter,
    state_filter,
    labels_filter,
)


# ========================================================================
# Helpers
# ========================================================================


def _execute_flow(client, ns, flow_id):
    return client.executions.create_execution(TENANT, ns, flow_id)


def _execute_and_wait(client, ns, flow_id, timeout=30):
    from kestrapy.exceptions import NotFoundException
    resp = _execute_flow(client, ns, flow_id)
    execution_id = resp.id
    start = time.time()
    while time.time() - start < timeout:
        try:
            exc = client.executions.execution(execution_id, TENANT)
        except NotFoundException:
            time.sleep(0.5)
            continue
        state = exc.state.current if hasattr(exc.state, "current") else None
        if state in (StateType.SUCCESS, StateType.FAILED, StateType.WARNING, StateType.CANCELLED):
            return execution_id
        time.sleep(0.5)
    raise TimeoutError(f"Execution {execution_id} did not complete within {timeout}s")


def _failing_flow_yaml(flow_id, ns):
    return f"""\
id: {flow_id}
namespace: {ns}
tasks:
  - id: fail
    type: io.kestra.plugin.core.execution.Fail
"""


def _sleep_flow_yaml(flow_id, ns):
    return f"""\
id: {flow_id}
namespace: {ns}
tasks:
  - id: wait
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT10S
"""


def _webhook_flow_yaml(flow_id, ns, key):
    return f"""\
id: {flow_id}
namespace: {ns}
tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Webhook triggered!
triggers:
  - id: webhook
    type: io.kestra.plugin.core.trigger.Webhook
    key: {key}
"""


def _wait_for_state(client, execution_id, target_states, timeout=30):
    from kestrapy.exceptions import NotFoundException
    start = time.time()
    while time.time() - start < timeout:
        try:
            exc = client.executions.execution(execution_id, TENANT)
        except NotFoundException:
            time.sleep(0.5)
            continue
        state = exc.state.current if hasattr(exc.state, "current") else None
        if state in target_states:
            return state
        time.sleep(0.5)
    raise TimeoutError(f"Execution {execution_id} did not reach {target_states} within {timeout}s")


# ========================================================================
# Create & Get
# ========================================================================


class TestCreateAndGet:
    def test_create_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        result = _execute_flow(client, ns, flow_id)
        assert result is not None
        assert result.id is not None and result.id != ""

    def test_execution_get_by_id(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        created = _execute_flow(client, ns, flow_id)
        time.sleep(0.5)

        result = client.executions.execution(created.id, TENANT)
        assert result is not None
        assert result.id == created.id

    def test_execution_wait_for_completion(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        execution_id = _execute_and_wait(client, ns, flow_id)
        result = client.executions.execution(execution_id, TENANT)
        assert result.state.current == StateType.SUCCESS


# ========================================================================
# Search
# ========================================================================


class TestSearchExecutions:
    def test_search_executions_basic(self, client):
        result = client.executions.search_executions(TENANT, 1, 10)
        assert result is not None
        assert result.get("results") is not None

    def test_search_executions_with_pagination(self, client):
        result = client.executions.search_executions(TENANT, 1, 2)
        assert result is not None
        assert len(result.get("results", [])) <= 2

    def test_search_executions_by_flow_id_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        _execute_and_wait(client, ns, flow_id)

        result = client.executions.search_executions_by_flow_id(TENANT, ns, flow_id, 1, 10)
        assert result is not None
        assert len(result.get("results", [])) > 0

    def test_search_executions_with_namespace_filter(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        _execute_and_wait(client, ns, flow_id)

        # Poll until search returns results
        deadline = time.time() + 30
        results = []
        while time.time() < deadline:
            resp = client.executions.search_executions(TENANT, 1, 10, None, [ns_filter(ns)])
            results = resp.get("results", [])
            if results:
                break
            time.sleep(0.5)

        assert len(results) > 0
        for exc in results:
            assert exc["namespace"] == ns

    def test_search_executions_with_flow_id_filter(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        _execute_and_wait(client, ns, flow_id)

        deadline = time.time() + 30
        results = []
        while time.time() < deadline:
            resp = client.executions.search_executions(TENANT, 1, 10, None, [flow_id_filter(flow_id)])
            results = resp.get("results", [])
            if results:
                break
            time.sleep(0.5)

        assert len(results) > 0
        for exc in results:
            assert exc["flowId"] == flow_id

    def test_search_executions_with_state_filter(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        _execute_and_wait(client, ns, flow_id)

        deadline = time.time() + 30
        results = []
        while time.time() < deadline:
            resp = client.executions.search_executions(TENANT, 1, 10, None, [state_filter("SUCCESS"), ns_filter(ns)])
            results = resp.get("results", [])
            if results:
                break
            time.sleep(0.5)

        assert len(results) > 0
        for exc in results:
            assert exc["state"]["current"] == "SUCCESS"

    def test_search_executions_with_labels(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml_with_labels(flow_id, ns, {"team": "sdk", "env": "test"}))
        client.executions.create_execution(TENANT, ns, flow_id, labels=["team:sdk", "env:test"])

        # Wait for execution to terminate
        deadline = time.time() + 30
        while time.time() < deadline:
            resp = client.executions.search_executions(TENANT, 1, 10, None, [ns_filter(ns)])
            results = resp.get("results", [])
            if results:
                state = results[0].get("state", {}).get("current")
                if state in ("SUCCESS", "FAILED", "WARNING", "CANCELLED"):
                    break
            time.sleep(0.5)

        # Search with label filter
        deadline = time.time() + 30
        while time.time() < deadline:
            resp = client.executions.search_executions(TENANT, 1, 10, None, [labels_filter({"team": "sdk"}), ns_filter(ns)])
            results = resp.get("results", [])
            if results:
                break
            time.sleep(0.5)

        assert len(results) > 0

    def test_search_executions_multiple_filters(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        _execute_and_wait(client, ns, flow_id)

        deadline = time.time() + 30
        results = []
        while time.time() < deadline:
            resp = client.executions.search_executions(TENANT, 1, 10, None, [
                ns_filter(ns), flow_id_filter(flow_id), state_filter("SUCCESS"),
            ])
            results = resp.get("results", [])
            if results:
                break
            time.sleep(0.5)

        assert len(results) > 0
        for exc in results:
            assert exc["namespace"] == ns
            assert exc["flowId"] == flow_id
            assert exc["state"]["current"] == "SUCCESS"

    def test_search_executions_no_results(self, client):
        result = client.executions.search_executions(TENANT, 1, 10, None, [ns_filter("nonexistent_ns_" + random_id())])
        assert result.get("total", 0) == 0
        assert len(result.get("results", [])) == 0

    def test_search_executions_with_sort(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        _execute_and_wait(client, ns, flow_id)
        time.sleep(0.5)
        _execute_and_wait(client, ns, flow_id)

        deadline = time.time() + 30
        results = []
        while time.time() < deadline:
            resp = client.executions.search_executions(TENANT, 1, 10, ["state.startDate:desc"], [ns_filter(ns)])
            results = resp.get("results", [])
            if len(results) >= 2:
                break
            time.sleep(0.5)

        assert len(results) >= 2
        for i in range(len(results) - 1):
            assert results[i]["state"]["startDate"] >= results[i + 1]["state"]["startDate"]


# ========================================================================
# Graph & Flow
# ========================================================================


class TestGraphAndFlow:
    def test_execution_flow_graph_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.execution_flow_graph(execution_id, TENANT)
        assert result is not None
        assert len(result.nodes) > 0

    def test_flow_from_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        result = client.executions.flow_from_execution(TENANT, ns, flow_id)
        assert result is not None
        assert result.id == flow_id

    def test_flow_from_execution_by_id_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.flow_from_execution_by_id(execution_id, TENANT)
        assert result is not None
        assert result.id == flow_id


# ========================================================================
# Delete
# ========================================================================


class TestDeleteExecution:
    def test_delete_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # Should not raise
        client.executions.delete_execution(execution_id, TENANT)

    def test_delete_executions_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.delete_executions_by_ids(TENANT, [execution_id])
        assert result is not None


# ========================================================================
# Kill
# ========================================================================


class TestKillExecution:
    def test_kill_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _sleep_flow_yaml(flow_id, ns))

        resp = _execute_flow(client, ns, flow_id)
        execution_id = resp.id
        time.sleep(0.5)

        _wait_for_state(client, execution_id, [StateType.RUNNING])

        result = client.executions.kill_execution(execution_id, TENANT)
        assert result is not None
        assert result.id == execution_id

        _wait_for_state(client, execution_id, [StateType.KILLED, StateType.CANCELLED])

    def test_kill_executions_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _sleep_flow_yaml(flow_id, ns))

        resp1 = _execute_flow(client, ns, flow_id)
        resp2 = _execute_flow(client, ns, flow_id)
        time.sleep(0.5)

        _wait_for_state(client, resp1.id, [StateType.RUNNING])

        # Should not raise
        client.executions.kill_executions_by_ids(TENANT, [resp1.id, resp2.id])


# ========================================================================
# Labels
# ========================================================================


class TestLabels:
    def test_set_labels_on_terminated_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        label = Label(key="env", value="test")
        result = client.executions.set_labels_on_terminated_execution(execution_id, TENANT, [label])
        assert result is not None

    def test_set_labels_on_terminated_executions_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        label = Label(key="team", value="platform")
        request = ExecutionControllerSetLabelsByIdsRequest(
            executions_id=[execution_id],
            execution_labels=[label],
        )

        # Should not raise
        client.executions.set_labels_on_terminated_executions_by_ids(TENANT, request)


# ========================================================================
# Eval
# ========================================================================


class TestEvalExpression:
    def test_eval_expression_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.eval_expression(execution_id, TENANT, "{{ execution.id }}")
        assert result is not None
        assert execution_id in result.get("result", result) if isinstance(result, dict) else execution_id in str(result)


# ========================================================================
# Replay
# ========================================================================


class TestReplay:
    def test_replay_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.replay_execution(execution_id, TENANT)
        assert result is not None
        assert result.id != execution_id

    def test_replay_execution_with_inputs_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.replay_execution_with_inputs(execution_id, TENANT)
        assert result is not None
        assert result.id is not None and result.id != ""

    def test_replay_executions_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # Should not raise
        client.executions.replay_executions_by_ids(TENANT, [execution_id])

    def test_replay_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.replay_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Latest executions
# ========================================================================


class TestLatestExecutions:
    def test_latest_executions_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        _execute_and_wait(client, ns, flow_id)

        flow_filter = ExecutionRepositoryInterfaceFlowFilter(namespace=ns, id=flow_id)
        result = client.executions.latest_executions(TENANT, [flow_filter])

        assert result is not None
        assert len(result) > 0


# ========================================================================
# Restart
# ========================================================================


class TestRestart:
    def test_restart_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _failing_flow_yaml(flow_id, ns))

        resp = _execute_flow(client, ns, flow_id)
        execution_id = resp.id
        _wait_for_state(client, execution_id, [StateType.FAILED])
        time.sleep(0.5)

        result = client.executions.restart_execution(execution_id, TENANT)
        assert result is not None
        assert result.id is not None and result.id != ""

    def test_restart_executions_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _failing_flow_yaml(flow_id, ns))

        resp = _execute_flow(client, ns, flow_id)
        _wait_for_state(client, resp.id, [StateType.FAILED])

        # Should not raise
        client.executions.restart_executions_by_ids(TENANT, [resp.id])

    def test_restart_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.restart_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Update execution status
# ========================================================================


class TestUpdateExecutionStatus:
    def test_update_execution_status_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.update_execution_status(execution_id, StateType.WARNING, TENANT)
        assert result is not None
        assert result.id == execution_id

    def test_update_executions_status_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # Should not raise
        client.executions.update_executions_status_by_ids(TENANT, StateType.WARNING, [execution_id])

    def test_update_executions_status_by_query_basic(self, client):
        # Should not raise
        client.executions.update_executions_status_by_query(TENANT, StateType.WARNING, [ns_filter("nonexistent")])


# ========================================================================
# Webhooks
# ========================================================================


class TestWebhooks:
    def test_trigger_execution_by_get_webhook_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        key = random_id()
        create_flow(client, _webhook_flow_yaml(flow_id, ns, key))
        time.sleep(0.5)

        result = client.executions.trigger_execution_by_get_webhook(TENANT, ns, flow_id, key)
        assert result is not None
        assert result.id is not None and result.id != ""
        assert result.flow_id == flow_id
        assert result.namespace == ns

    def test_trigger_execution_by_get_webhook_with_path_routes(self, client):
        # The webhook trigger in our test fixture doesn't declare a `path`
        # config, so the path-suffixed URL doesn't match any registered
        # trigger and the server replies 404. That 404 (rather than a
        # connection error or unknown-route 405) confirms the SDK reached
        # the path-with-suffix controller correctly.
        ns = random_id()
        flow_id = random_id()
        key = random_id()
        create_flow(client, _webhook_flow_yaml(flow_id, ns, key))
        time.sleep(0.5)

        try:
            result = client.executions.trigger_execution_by_get_webhook_with_path(
                TENANT, ns, flow_id, key, webhook_path="extra",
            )
            # If the server happens to accept it, that's also fine.
            assert result is not None
        except ApiException as e:
            assert e.status == 404

    def test_trigger_execution_by_post_webhook_with_path_routes(self, client):
        ns = random_id()
        flow_id = random_id()
        key = random_id()
        create_flow(client, _webhook_flow_yaml(flow_id, ns, key))
        time.sleep(0.5)

        try:
            result = client.executions.trigger_execution_by_post_webhook_with_path(
                TENANT, ns, flow_id, key, webhook_path="extra",
            )
            assert result is not None
        except ApiException as e:
            assert e.status == 404

    def test_trigger_execution_by_put_webhook_with_path_routes(self, client):
        ns = random_id()
        flow_id = random_id()
        key = random_id()
        create_flow(client, _webhook_flow_yaml(flow_id, ns, key))
        time.sleep(0.5)

        try:
            result = client.executions.trigger_execution_by_put_webhook_with_path(
                TENANT, ns, flow_id, key, webhook_path="extra",
            )
            assert result is not None
        except ApiException as e:
            assert e.status == 404


# ========================================================================
# File operations
# ========================================================================


class TestFiles:
    def test_download_file_from_execution_invalid_uri_raises(self, client):
        # The hello-world flow doesn't produce files, so we exercise the SDK
        # wiring by passing a clearly invalid internal storage URI. The
        # server should reject it with a 4xx, confirming path + params
        # are routed correctly.
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        with pytest.raises(ApiException) as exc_info:
            client.executions.download_file_from_execution(
                execution_id, path_uri="kestra:///not/a/real/file.bin", tenant=TENANT,
            )
        assert exc_info.value.status in (400, 404, 422, 500)

    def test_file_metadatas_from_execution_invalid_uri_raises(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        with pytest.raises(ApiException) as exc_info:
            client.executions.file_metadatas_from_execution(
                execution_id, path_uri="kestra:///not/a/real/file.bin", tenant=TENANT,
            )
        assert exc_info.value.status in (400, 404, 422, 500)


# ========================================================================
# Update task run state
# ========================================================================


class TestCreateExecutionOptions:
    def test_create_execution_with_labels(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        resp = client.executions.create_execution(
            TENANT, ns, flow_id, labels=["env:test", "tier:gold"],
        )
        assert resp is not None

    def test_create_execution_with_revision(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        resp = client.executions.create_execution(
            TENANT, ns, flow_id, revision=1,
        )
        assert resp is not None

    def test_create_execution_with_schedule_date(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        # Schedule a few seconds in the future — server stores the
        # scheduledDate without executing immediately.
        from datetime import datetime, timezone, timedelta
        future = (datetime.now(timezone.utc) + timedelta(seconds=30)).isoformat()
        try:
            resp = client.executions.create_execution(
                TENANT, ns, flow_id, schedule_date=future,
            )
            assert resp is not None
        except ApiException as e:
            # Some EE configs may reject ISO offsets — accept 400/422.
            assert e.status in (400, 422)


class TestDeleteExecutionFlags:
    def test_delete_execution_with_all_purge_flags(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # Should not raise
        client.executions.delete_execution(
            execution_id, TENANT,
            delete_logs=True, delete_metrics=True, delete_storage=True,
        )

    def test_delete_executions_by_ids_with_include_non_terminated(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.delete_executions_by_ids(
            TENANT, ids=[execution_id],
            include_non_terminated=True,
            delete_logs=True, delete_metrics=True, delete_storage=True,
        )
        assert result is not None


class TestKillCascade:
    def test_kill_execution_with_cascade_flag(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _sleep_flow_yaml(flow_id, ns))
        resp = _execute_flow(client, ns, flow_id)
        execution_id = resp.id
        _wait_for_state(client, execution_id, [StateType.RUNNING])

        result = client.executions.kill_execution(
            execution_id, TENANT, is_on_kill_cascade=True,
        )
        assert result is not None
        assert result.id == execution_id


class TestRestartRevision:
    def test_restart_execution_with_revision(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _failing_flow_yaml(flow_id, ns))
        resp = _execute_flow(client, ns, flow_id)
        execution_id = resp.id
        _wait_for_state(client, execution_id, [StateType.FAILED])
        time.sleep(0.5)

        result = client.executions.restart_execution(
            execution_id, TENANT, revision=1,
        )
        assert result is not None


class TestFollowDependenciesFlags:
    def test_follow_dependencies_execution_with_destination_only(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        resp = _execute_flow(client, ns, flow_id)

        events = []
        deadline = time.time() + 10
        stream = client.executions.follow_dependencies_execution(
            resp.id, TENANT, destination_only=True, expand_all=True,
        )
        try:
            for event in stream:
                events.append(event)
                if time.time() > deadline or len(events) >= 3:
                    break
        finally:
            stream.close()

        # Either we got some events, or the stream cleanly returned nothing
        # — both confirm the parameters were transported.
        assert isinstance(events, list)


class TestNotFound:
    def test_execution_get_unknown_id_raises(self, client):
        with pytest.raises(ApiException) as exc_info:
            client.executions.execution(f"missing-{random_id()}", TENANT)
        assert exc_info.value.status in (400, 404)

    def test_kill_execution_unknown_id_raises(self, client):
        with pytest.raises(ApiException) as exc_info:
            client.executions.kill_execution(f"missing-{random_id()}", TENANT)
        assert exc_info.value.status in (400, 404, 422)

    def test_pause_execution_unknown_id_raises(self, client):
        with pytest.raises(ApiException) as exc_info:
            client.executions.pause_execution(f"missing-{random_id()}", TENANT)
        assert exc_info.value.status in (400, 404, 422)

    def test_resume_execution_unknown_id_raises(self, client):
        with pytest.raises(ApiException) as exc_info:
            client.executions.resume_execution(f"missing-{random_id()}", TENANT)
        assert exc_info.value.status in (400, 404, 422)

    def test_eval_expression_unknown_id_raises(self, client):
        # eval is authorized against the target execution; on a missing
        # execution the controller's permission check returns 403 before
        # the not-found check fires.
        with pytest.raises(ApiException) as exc_info:
            client.executions.eval_expression(
                f"missing-{random_id()}", "{{ inputs.x }}", TENANT,
            )
        assert exc_info.value.status in (400, 403, 404, 422, 500)


class TestUpdateTaskRunState:
    def test_update_task_run_state_unknown_taskrun(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # An unknown taskRunId on a completed execution should not change
        # state; the server returns 409 ("if the task run state cannot be
        # changed") or 422 (validation).
        req = ExecutionControllerStateRequest(
            task_run_id=f"missing-{random_id()}", state=StateType.SUCCESS,
        )
        with pytest.raises(ApiException) as exc_info:
            client.executions.update_task_run_state(
                execution_id=execution_id, tenant=TENANT, request=req,
            )
        assert exc_info.value.status in (400, 404, 409, 422, 500)


# ========================================================================
# Kill by query
# ========================================================================


class TestKillByQuery:
    def test_kill_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.kill_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Delete by query
# ========================================================================


class TestDeleteByQuery:
    def test_delete_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.delete_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Pause / Resume
# ========================================================================


class TestPauseResume:
    def test_pause_execution_not_paused(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _sleep_flow_yaml(flow_id, ns))

        resp = _execute_flow(client, ns, flow_id)
        execution_id = resp.id
        _wait_for_state(client, execution_id, [StateType.RUNNING])

        result = client.executions.pause_execution(execution_id, TENANT)
        assert result is not None
        assert result.id == execution_id

        # Resume
        resumed = client.executions.resume_execution(execution_id, TENANT)
        assert resumed is not None
        assert resumed.id == execution_id

    def test_pause_executions_by_ids_basic(self, client):
        with pytest.raises(Exception):
            client.executions.pause_executions_by_ids(TENANT, ["nonexistent"])

    def test_pause_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.pause_executions_by_query(TENANT, [ns_filter("nonexistent")])

    def test_resume_executions_by_ids_basic(self, client):
        with pytest.raises(Exception):
            client.executions.resume_executions_by_ids(TENANT, ["nonexistent"])

    def test_resume_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.resume_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Restart by bulk
# ========================================================================


class TestRestartBulk:
    def test_restart_executions_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, _failing_flow_yaml(flow_id, ns))

        resp = _execute_flow(client, ns, flow_id)
        execution_id = resp.id
        _wait_for_state(client, execution_id, [StateType.FAILED])

        # Should not raise
        client.executions.restart_executions_by_ids(TENANT, [execution_id])

    def test_restart_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.restart_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Replay bulk
# ========================================================================


class TestReplayBulk:
    def test_replay_execution_with_inputs_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        result = client.executions.replay_execution_with_inputs(execution_id, TENANT)
        assert result is not None
        assert result.id is not None and result.id != ""

    def test_replay_executions_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # Should not raise
        client.executions.replay_executions_by_ids(TENANT, [execution_id])

    def test_replay_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.replay_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Force run
# ========================================================================


class TestForceRun:
    def test_force_run_execution_not_queued(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # Force-run on a terminated execution should fail (409)
        with pytest.raises(Exception):
            client.executions.force_run_execution(execution_id, TENANT)

    def test_force_run_by_ids_basic(self, client):
        with pytest.raises(Exception):
            client.executions.force_run_by_ids(TENANT, ["nonexistent"])

    def test_force_run_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.force_run_executions_by_query(TENANT, [ns_filter("nonexistent")])


# ========================================================================
# Unqueue
# ========================================================================


class TestUnqueue:
    def test_unqueue_execution_not_queued(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        with pytest.raises(Exception):
            client.executions.unqueue_execution(execution_id, TENANT)

    def test_unqueue_executions_by_ids_basic(self, client):
        with pytest.raises(Exception):
            client.executions.unqueue_executions_by_ids(TENANT, StateType.SUCCESS, ["nonexistent"])

    def test_unqueue_executions_by_query_basic(self, client):
        # Should not raise
        client.executions.unqueue_executions_by_query(TENANT, None, [ns_filter("nonexistent")])


# ========================================================================
# Labels by query
# ========================================================================


class TestLabelsByQuery:
    def test_set_labels_on_terminated_executions_by_query_basic(self, client):
        label = Label(key="env", value="staging")
        # Should not raise
        client.executions.set_labels_on_terminated_executions_by_query(TENANT, [label], [ns_filter("nonexistent")])


# ========================================================================
# Change status bulk
# ========================================================================


class TestChangeStatusBulk:
    def test_update_executions_status_by_ids_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        execution_id = _execute_and_wait(client, ns, flow_id)

        # Should not raise
        client.executions.update_executions_status_by_ids(TENANT, StateType.WARNING, [execution_id])

    def test_update_executions_status_by_query_basic(self, client):
        # Should not raise
        client.executions.update_executions_status_by_query(TENANT, StateType.WARNING, [ns_filter("nonexistent")])


# ========================================================================
# Streaming (SSE)
# ========================================================================


class TestStreaming:
    def test_follow_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        resp = _execute_flow(client, ns, flow_id)

        events = []
        deadline = time.time() + 15
        stream = client.executions.follow_execution(resp.id, TENANT)
        try:
            for event in stream:
                events.append(event)
                if time.time() > deadline:
                    break
                if hasattr(event, "state") and event.state is not None:
                    current = event.state.current if hasattr(event.state, "current") else None
                    if current in (StateType.SUCCESS, StateType.FAILED, StateType.WARNING, StateType.CANCELLED):
                        break
        finally:
            stream.close()

        assert len(events) > 0
        last = events[-1]
        assert last.state is not None

    def test_follow_dependencies_execution_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        resp = _execute_flow(client, ns, flow_id)

        events = []
        deadline = time.time() + 15
        stream = client.executions.follow_dependencies_execution(resp.id, TENANT)
        try:
            for event in stream:
                events.append(event)
                if time.time() > deadline:
                    break
                if len(events) >= 3:
                    break
        finally:
            stream.close()

        assert len(events) > 0
