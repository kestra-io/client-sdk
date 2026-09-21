import pytest

from test_helpers import random_id
from kestrapy import (
    Concurrency,
    ConcurrencyBehavior,
    Quota,
    QuotaBehavior,
    Tenant,
)
from kestrapy.exceptions import NotFoundException


def _tenant(tenant_id, name, concurrency_limit, quota_limit):
    return Tenant(
        id=tenant_id,
        name=name,
        deleted=False,
        concurrency=Concurrency(limit=concurrency_limit, behavior=ConcurrencyBehavior.QUEUE),
        quotas=[Quota(duration="PT1H", limit=quota_limit, behavior=QuotaBehavior.FAIL)],
    )


@pytest.fixture
def temp_tenant(client):
    tenant_id = "t" + random_id()[:12]
    yield tenant_id
    try:
        client.tenants.delete_tenant(tenant_id)
    except NotFoundException:
        pass


def test_tenant_crud_roundtrip_with_concurrency_and_quotas(client, temp_tenant):
    tenant_id = temp_tenant

    created = client.tenants.create_tenant(_tenant(tenant_id, "SDK test tenant", 5, 100))

    assert created.id == tenant_id
    assert created.concurrency is not None
    assert created.concurrency.limit == 5
    assert created.concurrency.behavior == ConcurrencyBehavior.QUEUE
    assert created.quotas is not None and len(created.quotas) == 1
    assert created.quotas[0].duration == "PT1H"
    assert created.quotas[0].limit == 100
    assert created.quotas[0].behavior == QuotaBehavior.FAIL

    fetched = client.tenants.tenant(tenant_id)

    assert fetched.id == tenant_id
    assert fetched.name == "SDK test tenant"
    assert fetched.concurrency.limit == 5
    assert fetched.quotas[0].limit == 100

    updated = client.tenants.update_tenant(
        tenant_id, _tenant(tenant_id, "SDK test tenant updated", 7, 50)
    )

    assert updated.name == "SDK test tenant updated"
    assert updated.concurrency.limit == 7
    assert updated.quotas[0].limit == 50

    client.tenants.delete_tenant(tenant_id)

    with pytest.raises(NotFoundException):
        client.tenants.tenant(tenant_id)


def test_search_tenants_finds_created_tenant(client, temp_tenant):
    tenant_id = temp_tenant
    client.tenants.create_tenant(_tenant(tenant_id, "SDK search tenant", 2, 10))

    result = client.tenants.search_tenants(page=1, size=100)

    assert result.total >= 2
    assert tenant_id in [t.id for t in result.results]


def test_get_unknown_tenant_returns_404(client):
    with pytest.raises(NotFoundException) as exc_info:
        client.tenants.tenant("does-not-exist-" + random_id()[:8])
    assert exc_info.value.status == 404
