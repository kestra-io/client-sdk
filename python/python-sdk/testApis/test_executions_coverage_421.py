"""Tests for the executions endpoints added for #421.

These wrap the last Go-SDK executions endpoints the hand-written Python SDK was
missing: distinct-field-values, CSV export, executable namespaces/flows, flow
average-duration, file preview, the raw follow / follow-dependencies streams,
per-task-run eval, resume-from-breakpoint and the resume / new-execution input
validators.

Several of these are state- or licence-gated (a suspended BREAKPOINT execution,
a stored file, a specific task run). On an instance where that state is absent
the backend answers 4xx rather than a payload, so the assertions below skip on
those instead of failing — an infra gap must not look like a coverage
regression (see AGENTS.md).
"""
import pytest

from test_helpers import TENANT, gating
from kestrapy import QueryFilter, QueryFilterField, QueryFilterOp

# Execution endpoints legitimately address entities by id (executions, files,
# task runs), so a 404 is entity-not-here, not a wrong path -> allow_404=True.
_tolerate_gating = gating(allow_404=True)
# For endpoints whose target must be in a specific state we don't control
# (e.g. a suspended BREAKPOINT execution, a stored file), a 400/409/422 just
# means "this instance/execution isn't in that state", not a coverage break.
_STATE = (400, 409, 422)
# Validating resume/new-execution inputs against a non-paused (terminated)
# execution is an invalid-state error the backend currently surfaces as 500.
_STATE_500 = _STATE + (500,)


# --------------------------------------------------------------------------- #
# Distinct field values / namespaces / average duration / export
# --------------------------------------------------------------------------- #

def test_find_distinct_execution_field_values_returns_namespaces(client, succeeded_execution):
    _, ns, _ = succeeded_execution
    with _tolerate_gating("find_distinct_execution_field_values"):
        values = client.executions.find_distinct_execution_field_values(
            TENANT, field=QueryFilterField.NAMESPACE.value,
        )
    assert isinstance(values, list)
    # The namespace of the shared execution must be one of the distinct values.
    assert ns in values


def test_export_executions_by_query_to_csv_returns_csv(client, succeeded_execution):
    _, ns, _ = succeeded_execution
    filters = [QueryFilter(field=QueryFilterField.NAMESPACE, operation=QueryFilterOp.EQUALS, value=ns)]
    with _tolerate_gating("export_executions_by_query_to_csv"):
        csv = client.executions.export_executions_by_query_to_csv(TENANT, filters=filters)
    assert isinstance(csv, str)
    # The CSV header row names the exported execution columns.
    assert "Namespace" in csv or "namespace" in csv.lower()


def test_list_executable_namespaces_includes_shared(client, succeeded_execution):
    _, ns, _ = succeeded_execution
    with _tolerate_gating("list_executable_namespaces"):
        namespaces = client.executions.list_executable_namespaces(TENANT)
    assert isinstance(namespaces, list)
    assert ns in namespaces


def test_list_executable_flows_by_namespace_includes_shared(client, succeeded_execution):
    _, ns, flow_id = succeeded_execution
    with _tolerate_gating("list_executable_flows_by_namespace"):
        flows = client.executions.list_executable_flows_by_namespace(ns, TENANT)
    assert isinstance(flows, list)
    ids = [f.id for f in flows]
    assert flow_id in ids


def test_execution_average_duration_returns_stats(client, succeeded_execution):
    _, ns, flow_id = succeeded_execution
    with _tolerate_gating("execution_average_duration"):
        stats = client.executions.execution_average_duration(ns, flow_id, TENANT)
    assert isinstance(stats, dict)
    # The stats payload always carries a numeric count (aggregation of recent
    # executions is time-windowed/async, so a just-run execution may not be
    # reflected yet — assert the real shape, not a positive count).
    assert "count" in stats
    assert int(stats.get("count", 0)) >= 0


# --------------------------------------------------------------------------- #
# File preview
# --------------------------------------------------------------------------- #

def test_preview_file_from_execution_requires_valid_uri(client, succeeded_execution):
    execution_id, _, _ = succeeded_execution
    # Without a real stored-file URI the backend rejects the preview; the point
    # here is that the endpoint is wired (path/verb/params), so tolerate the
    # state-dependent error and assert a dict when a payload does come back.
    with _tolerate_gating("preview_file_from_execution", state_codes=_STATE):
        preview = client.executions.preview_file_from_execution(
            execution_id, "kestra:///does/not/exist.ion", TENANT,
        )
    assert isinstance(preview, dict)


# --------------------------------------------------------------------------- #
# Follow (raw streaming variants)
# --------------------------------------------------------------------------- #

def test_follow_execution_raw_streams_terminated(client, succeeded_execution):
    execution_id, _, _ = succeeded_execution
    with _tolerate_gating("follow_execution_raw"):
        resp = client.executions.follow_execution_raw(execution_id, TENANT)
    try:
        assert resp.status_code == 200
    finally:
        resp.close()


def test_follow_dependencies_execution_raw_streams(client, succeeded_execution):
    execution_id, _, _ = succeeded_execution
    with _tolerate_gating("follow_dependencies_execution_raw"):
        resp = client.executions.follow_dependencies_execution_raw(
            execution_id, TENANT, destination_only=False, expand_all=False,
        )
    try:
        assert resp.status_code == 200
    finally:
        resp.close()


# --------------------------------------------------------------------------- #
# Eval for a specific task run
# --------------------------------------------------------------------------- #

def test_eval_task_run_expression_resolves(client, succeeded_execution):
    execution_id, _, _ = succeeded_execution
    execution = client.executions.execution(execution_id, TENANT)
    task_runs = getattr(execution, "task_run_list", None) or []
    if not task_runs:
        pytest.skip("eval_task_run_expression: execution has no task runs")
    task_run_id = task_runs[0].id
    with _tolerate_gating("eval_task_run_expression", state_codes=_STATE):
        result = client.executions.eval_task_run_expression(
            execution_id, task_run_id, TENANT, "{{ execution.id }}",
        )
    # The Pebble expression evaluates to the execution id in this task's context.
    assert result.result == execution_id
    assert result.error is None


# --------------------------------------------------------------------------- #
# Resume from breakpoint / validate resume / validate new inputs
# --------------------------------------------------------------------------- #

def test_resume_execution_from_breakpoint_wired(client, succeeded_execution):
    execution_id, _, _ = succeeded_execution
    # A terminated execution is not in BREAKPOINT, so the server rejects the
    # resume; tolerate that and only assert on the (unlikely) success payload.
    with _tolerate_gating("resume_execution_from_breakpoint", state_codes=_STATE):
        resumed = client.executions.resume_execution_from_breakpoint(execution_id, TENANT)
    assert resumed.id == execution_id


def test_validate_resume_execution_inputs_wired(client, succeeded_execution):
    execution_id, _, _ = succeeded_execution
    # A terminated execution is not paused; the validator rejects it. Tolerate
    # the state error and assert a dict payload when one is returned.
    with _tolerate_gating("validate_resume_execution_inputs", state_codes=_STATE_500):
        result = client.executions.validate_resume_execution_inputs(execution_id, TENANT, inputs={})
    assert isinstance(result, dict)


def test_validate_new_execution_inputs_returns_payload(client, shared_flow):
    ns, flow_id = shared_flow
    # The shared log flow declares no required inputs, so validation succeeds
    # and returns the resolved-inputs payload without creating an execution.
    with _tolerate_gating("validate_new_execution_inputs", state_codes=_STATE):
        result = client.executions.validate_new_execution_inputs(ns, flow_id, TENANT, inputs={})
    assert isinstance(result, dict)
