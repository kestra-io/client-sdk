"""Tests for the tenant-access SDK surface added for #421.

Tenant access is an EE/IAM feature; on an instance without it the backend
answers 403/404/501, so live calls are wrapped in ``_tolerate_gating``
(see AGENTS.md).
"""

import pytest

from test_helpers import TENANT, gating, random_id
from kestrapy.exceptions import (
    ConflictException,
)
from kestrapy.models.iam_tenant_access_controller_api_create_tenant_access_request import (
    IAMTenantAccessControllerApiCreateTenantAccessRequest,
)
from kestrapy.models.iam_tenant_access_controller_api_tenant_access import (
    IAMTenantAccessControllerApiTenantAccess,
)
from kestrapy.models.iam_tenant_access_controller_api_user_tenant_access import (
    IAMTenantAccessControllerApiUserTenantAccess,
)
from kestrapy.models.paged_results_iam_tenant_access_controller_api_user_tenant_access import (
    PagedResultsIAMTenantAccessControllerApiUserTenantAccess,
)

_tolerate_gating = gating()


def test_list_tenant_access_returns_paged_results(client):
    with _tolerate_gating("list_tenant_access"):
        result = client.tenant_access.list_tenant_access(TENANT, page=1, size=10)
    assert isinstance(result, PagedResultsIAMTenantAccessControllerApiUserTenantAccess)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)
    for access in result.results:
        assert isinstance(access, IAMTenantAccessControllerApiUserTenantAccess)


def test_tenant_access_round_trip_from_list(client):
    # The listing gives us a real user id to fetch a single record for.
    with _tolerate_gating("list_tenant_access"):
        listed = client.tenant_access.list_tenant_access(TENANT, page=1, size=10)
    if not listed.results:
        pytest.skip("no users with tenant access to fetch")
    user_id = listed.results[0].id
    with _tolerate_gating("tenant_access"):
        access = client.tenant_access.tenant_access(user_id, TENANT)
    assert isinstance(access, IAMTenantAccessControllerApiTenantAccess)
    assert access.user_id == user_id


def test_create_tenant_access_unknown_user(client):
    # An unknown user id is gated (403) or missing (404), never a crash.
    with _tolerate_gating("create_tenant_access"):
        client.tenant_access.create_tenant_access(random_id(), TENANT)


def test_create_tenant_access_by_email(client):
    body = IAMTenantAccessControllerApiCreateTenantAccessRequest(
        email=f"sdk-{random_id()}@example.com"
    )
    try:
        with _tolerate_gating("create_tenant_access_by_email"):
            result = client.tenant_access.create_tenant_access_by_email(TENANT, body)
        # Void endpoint: returns None on success.
        assert result is None
    except ConflictException:
        pytest.skip("user already has tenant access")


def test_delete_tenant_access_unknown_user(client):
    with _tolerate_gating("delete_tenant_access"):
        client.tenant_access.delete_tenant_access(random_id(), TENANT)


def test_autocomplete_tenant_access_returns_list(client):
    with _tolerate_gating("autocomplete_tenant_access"):
        result = client.tenant_access.autocomplete_tenant_access(TENANT, {"ids": []})
    assert isinstance(result, list)
    for access in result:
        assert isinstance(access, IAMTenantAccessControllerApiUserTenantAccess)
