import pytest

from test_helpers import TENANT, random_id
from kestrapy import (
    IAMTenantAccessControllerApiCreateTenantAccessRequest,
    ApiException,
)


# ========================================================================
# Helpers
# ========================================================================

def _invite_email():
    return f"sdktest-ta-{random_id()[:8]}@example.com"


def _grant_access(client, email=None):
    email = email or _invite_email()
    req = IAMTenantAccessControllerApiCreateTenantAccessRequest(email=email)
    client.tenant_access.create_tenant_access(TENANT, req)
    return email


# ========================================================================
# Tests
# ========================================================================

def test_create_tenant_access(client):
    _grant_access(client)


def test_list_tenant_access_returns_results(client):
    _grant_access(client)

    result = client.tenant_access.list_tenant_access(TENANT, page=1, size=100)
    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_list_tenant_access_pagination(client):
    result = client.tenant_access.list_tenant_access(TENANT, page=1, size=2)
    assert result is not None
    assert len(result.results) <= 2


def test_delete_tenant_access(client):
    _grant_access(client)

    result = client.tenant_access.list_tenant_access(TENANT, page=1, size=100)
    assert result is not None and len(result.results) > 0

    entry = result.results[0]
    user_id = entry.id
    assert user_id is not None and user_id != ""

    client.tenant_access.delete_tenant_access(user_id, TENANT)
