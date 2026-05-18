import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    ns_filter,
    type_filter,
)
from kestrapy import ApiException


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
# Dependencies
# ========================================================================


def test_asset_dependencies_basic(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    result = client.assets.asset_dependencies(id=created.id, tenant=TENANT)

    assert result is not None


# ========================================================================
# Bulk delete
# ========================================================================


def test_delete_assets_by_ids_basic(client):
    asset_id = random_id()
    created = client.assets.create_asset(tenant=TENANT, yaml_body=asset_yaml(asset_id))

    result = client.assets.delete_assets_by_ids(tenant=TENANT, ids=[created.id])

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
