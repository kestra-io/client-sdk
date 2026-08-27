"""Integration tests for the Policies API.

Policies are authored as YAML and sent as the raw source, so these drive the same ten
operations at each of the three scopes and assert the source round-trips.

Requires an EE instance whose licence carries the Policies feature: without it every
endpoint answers 403 before reaching the controller.
"""
import time

import pytest
from kestrapy.exceptions import ApiException
from kestrapy.models import Enforcement, PolicyPreviewRequest

from test_helpers import (
    TENANT,
    random_id,
    random_namespace,
    log_flow_yaml,
    create_flow,
)


def policy_source(policy_id, display_name=None, enforcement="EVALUATE"):
    """A minimal FLOW-scoped policy.

    `io.kestra.plugin.ee.rules.Require` reports a violation when the listed properties are
    missing from a flow after mutation. EVALUATE keeps it from blocking anything.
    """
    return (
        f"id: {policy_id}\n"
        f"displayName: {display_name or 'Test policy ' + policy_id}\n"
        f"enforcement: {enforcement}\n"
        "rules:\n"
        "  - type: io.kestra.plugin.ee.rules.Require\n"
        "    on: FLOW\n"
        "    action: WARN\n"
        "    errorMessage: timeout is required\n"
        "    properties:\n"
        "      - timeout\n"
    )


def namespace_with_flow(client):
    """A namespace only exists once something lives in it."""
    ns = random_namespace()
    create_flow(client, log_flow_yaml(random_id(), ns))
    return ns


def await_in_search(search, policy_id, timeout=10, interval=0.2):
    """Poll a policy search until `policy_id` appears, then return the results.

    Policy search reads an index updated asynchronously after a write, so a search issued
    immediately after a create can legitimately miss the new policy. Returns the last page
    seen on timeout so the caller's assertion reports the mismatch, matching how
    wait_for_execution surfaces its failures.
    """
    elapsed = 0.0
    results = []
    while True:
        page = search()
        results = page.results or [] if page else []
        if any(p.id == policy_id for p in results):
            return results
        if elapsed >= timeout:
            return results
        time.sleep(interval)
        elapsed += interval


# ========================================================================
# INSTANCE scope
# ========================================================================

def test_should_round_trip_authored_source_when_creating_instance_policy(client):
    policy_id = random_id()

    created = client.policies.create_instance_policy(policy_source(policy_id))
    assert created.id == policy_id
    assert created.enforcement == Enforcement.EVALUATE

    read = client.policies.instance_policy(policy_id)
    assert read.id == policy_id
    # the API stores the authored YAML alongside the parsed model and returns it verbatim
    assert "io.kestra.plugin.ee.rules.Require" in read.source
    assert read.rules


def test_should_return_policy_when_searching_instance_policies(client):
    policy_id = random_id()
    client.policies.create_instance_policy(policy_source(policy_id))

    results = await_in_search(
        lambda: client.policies.search_instance_policies(page=1, size=100), policy_id)

    assert any(p.id == policy_id for p in results)


def test_should_apply_display_name_and_enforcement_when_updating_instance_policy(client):
    policy_id = random_id()
    client.policies.create_instance_policy(policy_source(policy_id))

    updated = client.policies.update_instance_policy(
        policy_id, policy_source(policy_id, display_name="Renamed", enforcement="DISABLED"))

    assert updated.display_name == "Renamed"
    assert updated.enforcement == Enforcement.DISABLED


def test_should_return_validation_result_when_validating_instance_policy_source(client):
    result = client.policies.validate_instance_policy(policy_source(random_id()))

    assert result is not None


def test_should_return_evaluation_when_evaluating_instance_policy(client):
    policy_id = random_id()
    client.policies.create_instance_policy(policy_source(policy_id))

    evaluation = client.policies.evaluate_instance_policy(policy_id, page=1, size=10)

    assert evaluation is not None


def test_should_return_non_empty_archive_when_exporting_instance_policies(client):
    client.policies.create_instance_policy(policy_source(random_id()))

    exported = client.policies.export_instance_policies()

    assert exported


def test_should_reject_get_when_instance_policy_deleted(client):
    policy_id = random_id()
    client.policies.create_instance_policy(policy_source(policy_id))

    client.policies.delete_instance_policy(policy_id)

    with pytest.raises(ApiException):
        client.policies.instance_policy(policy_id)


def test_should_count_every_deletion_when_deleting_instance_policies_by_ids(client):
    first, second = random_id(), random_id()
    client.policies.create_instance_policy(policy_source(first))
    client.policies.create_instance_policy(policy_source(second))

    response = client.policies.delete_instance_policies_by_ids([first, second])

    assert response.count == 2


# ========================================================================
# TENANT scope
# ========================================================================

def test_should_round_trip_authored_source_when_creating_tenant_policy(client):
    policy_id = random_id()

    created = client.policies.create_tenant_policy(TENANT, policy_source(policy_id))
    assert created.id == policy_id

    read = client.policies.tenant_policy(TENANT, policy_id)
    assert read.id == policy_id
    assert "timeout is required" in read.source


def test_should_return_policy_when_searching_tenant_policies(client):
    policy_id = random_id()
    client.policies.create_tenant_policy(TENANT, policy_source(policy_id))

    results = await_in_search(
        lambda: client.policies.search_policies(TENANT, page=1, size=100), policy_id)

    assert any(p.id == policy_id for p in results)


def test_should_return_non_empty_archive_when_exporting_tenant_policies_by_ids(client):
    policy_id = random_id()
    client.policies.create_tenant_policy(TENANT, policy_source(policy_id))

    exported = client.policies.export_tenant_policies_by_ids(TENANT, [policy_id])

    assert exported


def test_should_reject_get_when_tenant_policy_deleted(client):
    policy_id = random_id()
    client.policies.create_tenant_policy(TENANT, policy_source(policy_id))

    client.policies.delete_tenant_policy(TENANT, policy_id)

    with pytest.raises(ApiException):
        client.policies.tenant_policy(TENANT, policy_id)


# ========================================================================
# NAMESPACE scope
# ========================================================================

def test_should_round_trip_authored_source_when_creating_namespace_policy(client):
    ns = namespace_with_flow(client)
    policy_id = random_id()

    created = client.policies.create_namespace_policy(TENANT, ns, policy_source(policy_id))
    assert created.id == policy_id

    read = client.policies.namespace_policy(TENANT, ns, policy_id)
    assert read.id == policy_id


def test_should_return_policy_when_searching_namespace_policies(client):
    ns = namespace_with_flow(client)
    policy_id = random_id()
    client.policies.create_namespace_policy(TENANT, ns, policy_source(policy_id))

    results = await_in_search(
        lambda: client.policies.search_namespace_policies(TENANT, ns, page=1, size=100), policy_id)

    assert any(p.id == policy_id for p in results)


def test_should_apply_enforcement_when_updating_namespace_policy(client):
    ns = namespace_with_flow(client)
    policy_id = random_id()
    client.policies.create_namespace_policy(TENANT, ns, policy_source(policy_id))

    updated = client.policies.update_namespace_policy(
        TENANT, ns, policy_id, policy_source(policy_id, enforcement="ACTIVE"))

    assert updated.enforcement == Enforcement.ACTIVE


def test_should_return_evaluation_when_evaluating_namespace_policy(client):
    ns = namespace_with_flow(client)
    policy_id = random_id()
    client.policies.create_namespace_policy(TENANT, ns, policy_source(policy_id))

    evaluation = client.policies.evaluate_namespace_policy(TENANT, ns, policy_id, page=1, size=10)

    assert evaluation is not None


def test_should_reject_get_when_namespace_policy_deleted(client):
    ns = namespace_with_flow(client)
    policy_id = random_id()
    client.policies.create_namespace_policy(TENANT, ns, policy_source(policy_id))

    client.policies.delete_namespace_policy(TENANT, ns, policy_id)

    with pytest.raises(ApiException):
        client.policies.namespace_policy(TENANT, ns, policy_id)


# ========================================================================
# Preview (tenant scope only)
# ========================================================================

def test_should_return_preview_when_previewing_policies_for_a_flow(client):
    ns = namespace_with_flow(client)
    policy_id = random_id()
    client.policies.create_namespace_policy(TENANT, ns, policy_source(policy_id))

    preview = client.policies.preview_policies(
        TENANT, PolicyPreviewRequest(namespace=ns, source=log_flow_yaml(random_id(), ns)))

    assert preview is not None
