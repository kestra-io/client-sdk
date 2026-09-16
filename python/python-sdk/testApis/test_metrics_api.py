"""Tests for the metrics SDK surface added for #421.

The metrics controller is gated by the ``EXECUTION`` resource; on an instance
without it the backend answers 403/404/501 rather than a payload, so the
live calls are wrapped in ``_tolerate_gating`` (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import (
    TENANT,
    create_execution,
    create_flow,
    log_flow_yaml,
    random_id,
    random_namespace,
    wait_for_execution,
)
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
)

_GATED = (403, 404, 501)


@contextlib.contextmanager
def _tolerate_gating(what):
    try:
        yield
    except (ForbiddenException, NotFoundException) as exc:
        pytest.skip(f"{what}: gated on this instance ({exc.status})")
    except ServiceException as exc:
        if getattr(exc, "status", None) in _GATED:
            pytest.skip(f"{what}: gated on this instance ({exc.status})")
        raise


@pytest.fixture(scope="module")
def executed_flow(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))
    execution = create_execution(client, ns, fid)
    wait_for_execution(client, execution.id, timeout=30)
    return {"namespace": ns, "flow_id": fid, "execution_id": execution.id, "task_id": "hello"}


def test_execution_metrics_returns_page(client, executed_flow):
    with _tolerate_gating("execution_metrics"):
        result = client.metrics.execution_metrics(
            executed_flow["execution_id"], TENANT, page=1, size=10
        )
    assert isinstance(result, dict)
    # A metrics page is a PagedResults shape: results + total.
    assert "results" in result
    assert isinstance(result["results"], list)


def test_flow_metric_names_returns_list(client, executed_flow):
    with _tolerate_gating("flow_metric_names"):
        names = client.metrics.flow_metric_names(
            executed_flow["namespace"], executed_flow["flow_id"], TENANT
        )
    assert isinstance(names, list)


def test_task_metric_names_returns_list(client, executed_flow):
    with _tolerate_gating("task_metric_names"):
        names = client.metrics.task_metric_names(
            executed_flow["namespace"],
            executed_flow["flow_id"],
            executed_flow["task_id"],
            TENANT,
        )
    assert isinstance(names, list)


def test_tasks_with_metrics_returns_list(client, executed_flow):
    with _tolerate_gating("tasks_with_metrics"):
        tasks = client.metrics.tasks_with_metrics(
            executed_flow["namespace"], executed_flow["flow_id"], TENANT
        )
    assert isinstance(tasks, list)


def test_aggregate_flow_metric_returns_dict(client, executed_flow):
    with _tolerate_gating("aggregate_flow_metric"):
        result = client.metrics.aggregate_flow_metric(
            executed_flow["namespace"],
            executed_flow["flow_id"],
            "duration",
            TENANT,
            aggregation="sum",
        )
    assert isinstance(result, dict)


def test_aggregate_task_metric_returns_dict(client, executed_flow):
    with _tolerate_gating("aggregate_task_metric"):
        result = client.metrics.aggregate_task_metric(
            executed_flow["namespace"],
            executed_flow["flow_id"],
            executed_flow["task_id"],
            "duration",
            TENANT,
            aggregation="sum",
        )
    assert isinstance(result, dict)
