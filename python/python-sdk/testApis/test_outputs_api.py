"""Tests for the outputs SDK surface added for #421.

Kestra 2.0 dropped the ``outputs`` property from the execution payload, so these
routes are the only way to read flow- and task-level outputs. They can be
licence/feature gated, so live calls are wrapped in ``_tolerate_gating``.
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
from kestrapy.models.output_controller_task_output_information import (
    OutputControllerTaskOutputInformation,
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
    execution = wait_for_execution(client, execution.id, timeout=30)
    task_run_id = None
    if execution.task_run_list:
        task_run_id = execution.task_run_list[0].id
    return {"execution_id": execution.id, "task_run_id": task_run_id}


def test_execution_outputs_returns_dict(client, executed_flow):
    with _tolerate_gating("execution_outputs"):
        result = client.outputs.execution_outputs(executed_flow["execution_id"], TENANT)
    # A flow with no outputs still returns an object (possibly empty), not a raise.
    assert result is None or isinstance(result, dict)


def test_task_outputs_information_returns_list(client, executed_flow):
    with _tolerate_gating("task_outputs_information"):
        result = client.outputs.task_outputs_information(
            executed_flow["execution_id"], TENANT
        )
    assert isinstance(result, list)
    for item in result:
        assert isinstance(item, OutputControllerTaskOutputInformation)
        assert item.task_id is not None


def test_task_run_outputs_returns_dict(client, executed_flow):
    task_run_id = executed_flow["task_run_id"]
    if task_run_id is None:
        pytest.skip("no task run available on the execution")
    with _tolerate_gating("task_run_outputs"):
        result = client.outputs.task_run_outputs(
            executed_flow["execution_id"], task_run_id, TENANT
        )
    assert result is None or isinstance(result, dict)
