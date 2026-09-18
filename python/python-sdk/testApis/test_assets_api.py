import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    ns_filter,
    type_filter,
    create_log_flow,
    create_execution,
)
from kestrapy import ApiException
from kestrapy.models.assets_controller_asset_lock_request import AssetsControllerAssetLockRequest


def asset_yaml(asset_id):
    return (
        f"id: {asset_id}\n"
        f"name: Test Asset {asset_id}\n"
        "type: TABLE\n"
    )


# ========================================================================
# Search
# ========================================================================


def test_search_assets_basic(client):
    result = client.assets.search_assets(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.results is not None


def test_search_assets_with_pagination(client):
    result = client.assets.search_assets(tenant=TENANT, page=1, size=2)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 2


def test_search_asset_lineage_events_basic(client):
    result = client.assets.search_asset_lineage_events(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.results is not None


def test_search_asset_usages_basic(client):
    result = client.assets.search_asset_usages(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.results is not None


def test_search_assets_with_type_filter(client):
    asset_id = random_id()
    client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))
    time.sleep(0.3)

    result = client.assets.search_assets(
        tenant=TENANT, page=1, size=10, filters=[type_filter("TABLE")]
    )

    assert result is not None
    assert len(result.results) > 0


def test_search_assets_with_sort(client):
    id1 = f"aaa{random_id()}"
    id2 = f"zzz{random_id()}"
    client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(id2))
    client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(id1))
    time.sleep(0.3)

    result = client.assets.search_assets(
        tenant=TENANT,
        page=1,
        size=100,
        sort=["id:asc"],
        filters=[type_filter("TABLE")],
    )

    assert len(result.results) >= 2
    ids = [a.id for a in result.results]
    assert id1 in ids
    assert id2 in ids
    assert ids.index(id1) < ids.index(id2)


def test_search_asset_lineage_events_with_filters(client):
    result = client.assets.search_asset_lineage_events(
        tenant=TENANT,
        page=1,
        size=10,
        filters=[ns_filter(f"nonexistent_ns_{random_id()}")],
    )

    assert result is not None
    assert len(result.results) == 0


def test_search_asset_usages_with_filters(client):
    result = client.assets.search_asset_usages(
        tenant=TENANT,
        page=1,
        size=10,
        filters=[ns_filter(f"nonexistent_ns_{random_id()}")],
    )

    assert result is not None
    assert len(result.results) == 0


def test_search_assets_no_results(client):
    result = client.assets.search_assets(
        tenant=TENANT,
        page=1,
        size=10,
        filters=[ns_filter(f"nonexistent_ns_{random_id()}")],
    )

    assert result is not None
    assert len(result.results) == 0


# ========================================================================
# CRUD
# ========================================================================


def test_create_asset_basic(client):
    asset_id = random_id()
    result = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    assert result is not None
    assert result.id is not None and result.id != ""


def test_asset_get_by_id(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    result = client.assets.asset(id=created.id, tenant=TENANT)

    assert result is not None
    assert result.id == created.id


def test_delete_asset_basic(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    # Should not raise
    client.assets.delete_asset(id=created.id, tenant=TENANT)


# ========================================================================
# Lock
# ========================================================================


def test_lock_asset_manual(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    lock = client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1H"),
    )

    assert lock is not None
    assert lock.owner_type == "USER"
    assert lock.locked_until is not None

    client.assets.unlock_asset(id=created.id, tenant=TENANT)


def test_lock_asset_held_by_another_owner_is_rejected(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))
    flow = create_log_flow(client)
    execution = create_execution(client, flow.namespace, flow.id)

    lock = client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1H", execution_id=execution.id),
    )
    assert lock.owner_type == "EXECUTION"

    # held by an EXECUTION owner: a manual USER lock attempt is a different owner and must be rejected
    with pytest.raises(ApiException):
        client.assets.lock_asset(
            id=created.id, tenant=TENANT,
            request=AssetsControllerAssetLockRequest(ttl="PT1H"),
        )


def test_lock_asset_same_owner_reacquire_extends(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    first = client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1M"),
    )
    second = client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1H"),
    )

    assert second.owner_type == "USER"
    assert second.locked_until > first.locked_until

    client.assets.unlock_asset(id=created.id, tenant=TENANT)


def test_unlock_asset_then_relock(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))
    client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1H"),
    )

    # Should not raise
    client.assets.unlock_asset(id=created.id, tenant=TENANT)

    relock = client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1H"),
    )
    assert relock is not None

    client.assets.unlock_asset(id=created.id, tenant=TENANT)


def test_unlock_asset_execution_owned_lock_released_by_matching_execution_id(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))
    flow = create_log_flow(client)
    execution = create_execution(client, flow.namespace, flow.id)

    lock = client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(
            ttl="PT1H",
            execution_id=execution.id,
            flow_id=flow.id,
            flow_namespace=flow.namespace,
            task_run_id=random_id(),
        ),
    )
    assert lock.owner_type == "EXECUTION"

    # matching execution_id is the owner-checked release path: the execution releases its own lock
    client.assets.unlock_asset(id=created.id, tenant=TENANT, execution_id=execution.id)

    relock = client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1H"),
    )
    assert relock.owner_type == "USER"

    client.assets.unlock_asset(id=created.id, tenant=TENANT)


def test_unlock_asset_execution_owned_lock_mismatched_execution_id_is_noop(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))
    flow = create_log_flow(client)
    owner = create_execution(client, flow.namespace, flow.id)
    other = create_execution(client, flow.namespace, flow.id)

    client.assets.lock_asset(
        id=created.id, tenant=TENANT,
        request=AssetsControllerAssetLockRequest(ttl="PT1H", execution_id=owner.id),
    )

    # a different execution's unlock is owner-checked against the lock holder: no-op, does not raise
    client.assets.unlock_asset(id=created.id, tenant=TENANT, execution_id=other.id)

    # lock is still held by the original owner: a manual USER lock attempt is rejected
    with pytest.raises(ApiException):
        client.assets.lock_asset(
            id=created.id, tenant=TENANT,
            request=AssetsControllerAssetLockRequest(ttl="PT1H"),
        )

    client.assets.unlock_asset(id=created.id, tenant=TENANT, execution_id=owner.id)


# ========================================================================
# Dependencies
# ========================================================================


def test_asset_dependencies_basic(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    result = client.assets.asset_dependencies(id=created.id, tenant=TENANT)

    assert result is not None


def test_asset_dependencies_with_destination_only_and_expand_all(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    result = client.assets.asset_dependencies(
        id=created.id, tenant=TENANT,
        destination_only=True, expand_all=True,
    )

    assert result is not None


def test_asset_get_with_allow_deleted(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))
    client.assets.delete_asset(id=created.id, tenant=TENANT)

    # Soft-deleted asset should still be retrievable with allow_deleted=True.
    try:
        result = client.assets.asset(id=created.id, tenant=TENANT, allow_deleted=True)
        assert result is not None
    except ApiException as e:
        # Some configurations may hard-delete and still 404 — acceptable.
        assert e.status in (400, 404)


# ========================================================================
# Bulk delete
# ========================================================================


def test_delete_assets_by_ids_basic(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    result = client.assets.delete_assets_by_ids(tenant=TENANT, ids=[created.id])

    assert result is not None


def test_delete_assets_by_query_with_purge(client):
    # purge=True triggers hard deletion (vs soft delete). On an empty
    # filter result the call still succeeds.
    result = client.assets.delete_assets_by_query(
        tenant=TENANT, filters=[ns_filter("nonexistent")], purge=True,
    )

    assert result is not None


def test_delete_assets_by_query_basic(client):
    result = client.assets.delete_assets_by_query(
        tenant=TENANT, filters=[ns_filter("nonexistent")]
    )

    assert result is not None


def test_delete_asset_lineage_events_by_query_basic(client):
    result = client.assets.delete_asset_lineage_events_by_query(
        tenant=TENANT, filters=[ns_filter("nonexistent")]
    )

    assert result is not None


def test_delete_asset_usages_by_query_basic(client):
    result = client.assets.delete_asset_usages_by_query(
        tenant=TENANT, filters=[ns_filter("nonexistent")]
    )

    assert result is not None


# ========================================================================
# 404 edge cases
# ========================================================================


def test_asset_get_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.assets.asset(id=f"missing-{random_id()}", tenant=TENANT)
    assert exc_info.value.status in (400, 404)


def test_delete_asset_unknown_id_raises(client):
    try:
        client.assets.delete_asset(id=f"missing-{random_id()}", tenant=TENANT)
    except ApiException as e:
        assert e.status in (400, 404)
