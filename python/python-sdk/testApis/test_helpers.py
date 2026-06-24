import os
import time
import uuid

from kestrapy import (
    Configuration,
    KestraClient,
    QueryFilter,
    QueryFilterField,
    QueryFilterOp,
)

TENANT = "main"

TEST_DATA_PATH = os.path.join(os.path.dirname(__file__), "..", "..", "..", "test-utils")


# ========================================================================
# ID helpers
# ========================================================================

def random_id():
    return uuid.uuid4().hex


# Namespaces materialize per-namespace state server-side (EE/RBAC) that
# lives until deleted and feeds the CI container's heap. Namespaces minted
# through random_namespace() are registered here and bulk-purged after each
# test module by the autouse _namespace_gc fixture in conftest.py, bounding
# live namespace cardinality to one module's worth.
_REGISTERED_NAMESPACES = set()


def random_namespace():
    """Random namespace id, purged automatically after the current module."""
    return register_namespace(random_id())


def register_namespace(ns):
    """Register an externally-built namespace id (e.g. dotted children) for purge."""
    _REGISTERED_NAMESPACES.add(ns)
    return ns


def drain_registered_namespaces():
    namespaces = list(_REGISTERED_NAMESPACES)
    _REGISTERED_NAMESPACES.clear()
    return namespaces


# ========================================================================
# Flow YAML templates
# ========================================================================

def log_flow_yaml(flow_id, namespace):
    return f"""\
id: {flow_id}
namespace: {namespace}
description: a test flow

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World!
"""


def log_flow_yaml_with_description(flow_id, namespace, description):
    return f"""\
id: {flow_id}
namespace: {namespace}
description: {description}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World!
"""


def two_task_flow_yaml(flow_id, namespace):
    return f"""\
id: {flow_id}
namespace: {namespace}
description: two-task flow

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World!
  - id: goodbye
    type: io.kestra.plugin.core.log.Log
    message: Goodbye World!
"""


def concurrency_flow_yaml(flow_id, namespace, limit):
    return f"""\
id: {flow_id}
namespace: {namespace}
concurrency:
  behavior: QUEUE
  limit: {limit}
tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World!
"""


def invalid_task_flow_yaml(flow_id, namespace):
    return f"""\
id: {flow_id}
namespace: {namespace}
tasks:
  - id: bad
    type: io.kestra.plugin.nonexistent.BadTask
"""


def log_flow_yaml_with_labels(flow_id, namespace, labels_dict):
    labels_yaml = "\n".join(f"  {k}: {v}" for k, v in labels_dict.items())
    return f"""\
id: {flow_id}
namespace: {namespace}
description: a test flow with labels
labels:
{labels_yaml}

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World!
"""


# ========================================================================
# Flow creation helpers
# ========================================================================

def create_flow(client, yaml_body):
    flow = client.flows.create_flow(TENANT, yaml_body)
    time.sleep(0.2)
    return flow


def create_log_flow(client):
    return create_flow(client, log_flow_yaml(random_id(), random_namespace()))


# ========================================================================
# File helpers
# ========================================================================

def read_file(relative_path):
    path = os.path.join(TEST_DATA_PATH, relative_path)
    with open(path, "r") as f:
        return f.read()


def simple_flow_fixture():
    fid = random_id()
    ns = random_namespace()
    body = read_file("flows/simple_flow.yml") \
        .replace("simple_flow_id_to_replace_by_random_id", fid) \
        .replace("simple_flow_namespace_to_replace_by_random_id", ns)
    return body, ns, fid


def complete_flow_body():
    return read_file("flows/flow_complete.yml") \
        .replace("flow_complete", random_id()) \
        .replace("tests", random_namespace())


# ========================================================================
# Filter helpers
# ========================================================================

def ns_filter(ns):
    return QueryFilter(var_field=QueryFilterField.NAMESPACE, operation=QueryFilterOp.EQUALS, value={"value": ns})


def query_filter(q):
    return QueryFilter(var_field=QueryFilterField.QUERY, operation=QueryFilterOp.EQUALS, value={"value": q})


def flow_id_filter(flow_id):
    return QueryFilter(var_field=QueryFilterField.FLOW_ID, operation=QueryFilterOp.EQUALS, value={"value": flow_id})


def state_filter(state):
    return QueryFilter(var_field=QueryFilterField.STATE, operation=QueryFilterOp.EQUALS, value={"value": state})


def labels_filter(labels):
    return QueryFilter(var_field=QueryFilterField.LABELS, operation=QueryFilterOp.EQUALS, value=labels)


def min_level_filter(level):
    return QueryFilter(var_field=QueryFilterField.MIN_LEVEL, operation=QueryFilterOp.EQUALS, value={"value": level})


def execution_id_filter(exec_id):
    return QueryFilter(var_field=QueryFilterField.EXECUTION_ID, operation=QueryFilterOp.EQUALS, value={"value": exec_id})


def type_filter(type_val):
    return QueryFilter(var_field=QueryFilterField.TYPE, operation=QueryFilterOp.EQUALS, value={"value": type_val})


# ========================================================================
# Execution helpers
# ========================================================================

def create_execution(client, namespace, flow_id, timeout=15, interval=0.5, **kwargs):
    """Start an execution, retrying past the create-flow -> create-execution race.

    Kestra 2.0 is eventually consistent: an execution requested right after the
    flow is created can 404 until the flow propagates to the executor. Unlike
    wait_for_execution (which polls an existing execution), this retries the POST
    itself until the flow is visible and the execution is accepted.
    """
    from kestrapy.exceptions import NotFoundException
    elapsed = 0.0
    while True:
        try:
            return client.executions.create_execution(TENANT, namespace, flow_id, **kwargs)
        except NotFoundException:
            if elapsed >= timeout:
                raise
            time.sleep(interval)
            elapsed += interval


def wait_for_execution(client, execution_id, timeout=30, interval=0.5):
    """Poll until execution reaches SUCCESS. Returns the execution."""
    from kestrapy.exceptions import NotFoundException
    elapsed = 0.0
    while elapsed < timeout:
        try:
            execution = client.executions.execution(execution_id, TENANT)
        except NotFoundException:
            time.sleep(interval)
            elapsed += interval
            continue
        state = execution.state.current if hasattr(execution.state, "current") else None
        if state is not None:
            state_str = state.value if hasattr(state, "value") else str(state)
            if state_str == "SUCCESS":
                return execution
        time.sleep(interval)
        elapsed += interval
    raise TimeoutError(f"Execution {execution_id} did not reach SUCCESS within {timeout}s")


# NOTE: tests that only need "an execution with logs" should use the shared
# `succeeded_execution` fixture from conftest.py instead of creating their
# own namespace+flow+execution — accumulated server-side state is what OOMs
# the CI Kestra container.
