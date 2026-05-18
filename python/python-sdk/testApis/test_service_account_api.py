import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    name_filter,
)
from kestrapy import (
    IAMServiceAccountControllerApiCreateServiceAccountRequest,
    IAMServiceAccountControllerApiServiceAccountRequest,
    IAMServiceAccountControllerApiPatchServiceAccountRequest,
    ApiPatchSuperAdminRequest,
    CreateApiTokenRequest,
    ApiException,
)


# ========================================================================
# CRUD (Superadmin-scoped)
# ========================================================================


def test_create_service_account_basic(client):
    request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-{random_id()}",
        description="Test service account",
    )

    result = client.service_account.create_service_account(request=request)

    assert result is not None
    assert result.id is not None and result.id != ""


def test_service_account_get_by_id(client):
    request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-get-{random_id()}",
        description="Test get",
    )

    created = client.service_account.create_service_account(request=request)

    result = client.service_account.service_account(id=created.id)

    assert result is not None
    assert result.id == created.id


def test_patch_service_account_details_basic(client):
    request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-patch-{random_id()}",
        description="Before",
    )

    created = client.service_account.create_service_account(request=request)

    patch_request = IAMServiceAccountControllerApiPatchServiceAccountRequest(
        name=request.name,
        description="After",
    )

    result = client.service_account.patch_service_account_details(
        id=created.id, request=patch_request
    )

    assert result is not None
    assert result.description == "After"


def test_delete_service_account_basic(client):
    request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-del-{random_id()}",
        description="To delete",
    )

    created = client.service_account.create_service_account(request=request)

    # Should not raise
    client.service_account.delete_service_account(id=created.id)


# ========================================================================
# Listing
# ========================================================================


def test_list_service_accounts_basic(client):
    result = client.service_account.list_service_accounts(page=1, size=10)

    assert result is not None
    assert result.results is not None


def test_list_service_accounts_with_pagination(client):
    result = client.service_account.list_service_accounts(page=1, size=2)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 2


def test_list_service_accounts_with_query_filter(client):
    unique_name = f"sa-search-{random_id()}"
    request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=unique_name,
        description="Search test",
    )

    client.service_account.create_service_account(request=request)
    time.sleep(0.3)

    result = client.service_account.list_service_accounts(
        page=1, size=10, filters=[name_filter(unique_name)]
    )

    assert result is not None
    assert len(result.results) > 0


def test_list_service_accounts_no_results(client):
    result = client.service_account.list_service_accounts(
        page=1, size=10, filters=[name_filter(f"nonexistent_sa_{random_id()}")]
    )

    assert result is not None
    assert len(result.results) == 0


# ========================================================================
# Tenant-scoped
# ========================================================================


def test_create_service_account_for_tenant_basic(client):
    request = IAMServiceAccountControllerApiServiceAccountRequest(
        name=f"sa-tenant-{random_id()}",
        description="Tenant-scoped SA",
    )

    result = client.service_account.create_service_account_for_tenant(
        tenant=TENANT, request=request
    )

    assert result is not None
    assert result.id is not None and result.id != ""


def test_service_account_for_tenant_get_by_id(client):
    request = IAMServiceAccountControllerApiServiceAccountRequest(
        name=f"sa-tenant-get-{random_id()}",
        description="Tenant get",
    )

    created = client.service_account.create_service_account_for_tenant(
        tenant=TENANT, request=request
    )

    result = client.service_account.service_account_for_tenant(
        id=created.id, tenant=TENANT
    )

    assert result is not None
    assert result.id == created.id


def test_update_service_account_basic(client):
    request = IAMServiceAccountControllerApiServiceAccountRequest(
        name=f"sa-update-{random_id()}",
        description="Before",
    )

    created = client.service_account.create_service_account_for_tenant(
        tenant=TENANT, request=request
    )

    update_request = IAMServiceAccountControllerApiServiceAccountRequest(
        name=request.name,
        description="After",
    )

    result = client.service_account.update_service_account(
        id=created.id, tenant=TENANT, request=update_request
    )

    assert result is not None
    assert result.description == "After"


def test_delete_service_account_for_tenant_basic(client):
    request = IAMServiceAccountControllerApiServiceAccountRequest(
        name=f"sa-tenant-del-{random_id()}",
        description="To delete",
    )

    created = client.service_account.create_service_account_for_tenant(
        tenant=TENANT, request=request
    )

    # Should not raise
    client.service_account.delete_service_account_for_tenant(
        id=created.id, tenant=TENANT
    )


# ========================================================================
# API tokens (tenant-scoped)
# ========================================================================


def test_api_tokens_tenant_scoped(client):
    sa_request = IAMServiceAccountControllerApiServiceAccountRequest(
        name=f"sa-token-{random_id()}",
        description="Token test",
    )

    sa = client.service_account.create_service_account_for_tenant(
        tenant=TENANT, request=sa_request
    )

    token_request = CreateApiTokenRequest(name=f"test-token-{random_id()}")
    token_resp = client.service_account.create_api_tokens_for_service_account_with_tenant(
        id=sa.id, tenant=TENANT, request=token_request
    )
    assert token_resp is not None

    tokens = client.service_account.list_api_tokens_for_service_account_with_tenant(
        id=sa.id, tenant=TENANT
    )
    assert tokens is not None


# ========================================================================
# Delete API token (tenant-scoped)
# ========================================================================


def test_delete_api_token_for_service_account_with_tenant_basic(client):
    sa_request = IAMServiceAccountControllerApiServiceAccountRequest(
        name=f"sa-del-token-{random_id()}",
        description="Delete token test",
    )

    sa = client.service_account.create_service_account_for_tenant(
        tenant=TENANT, request=sa_request
    )

    token_request = CreateApiTokenRequest(name=f"token-to-delete-{random_id()}")
    token_resp = client.service_account.create_api_tokens_for_service_account_with_tenant(
        id=sa.id, tenant=TENANT, request=token_request
    )
    assert token_resp is not None
    token_id = token_resp["id"] if isinstance(token_resp, dict) else token_resp.id
    assert token_id is not None and token_id != ""

    # Should not raise
    client.service_account.delete_api_token_for_service_account_with_tenant(
        id=sa.id, token_id=token_id, tenant=TENANT
    )


# ========================================================================
# API tokens (Superadmin-scoped)
# ========================================================================


def test_create_api_tokens_for_service_account_superadmin(client):
    sa_request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-sa-token-{random_id()}",
        description="Superadmin token test",
    )

    sa = client.service_account.create_service_account(request=sa_request)

    token_request = CreateApiTokenRequest(name=f"sa-token-{random_id()}")
    token_resp = client.service_account.create_api_tokens_for_service_account(
        id=sa.id, request=token_request
    )
    assert token_resp is not None


def test_list_api_tokens_for_service_account_superadmin(client):
    sa_request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-sa-list-{random_id()}",
        description="Superadmin list token test",
    )

    sa = client.service_account.create_service_account(request=sa_request)

    token_request = CreateApiTokenRequest(name=f"sa-list-token-{random_id()}")
    client.service_account.create_api_tokens_for_service_account(
        id=sa.id, request=token_request
    )

    tokens = client.service_account.list_api_tokens_for_service_account(id=sa.id)
    assert tokens is not None


def test_delete_api_token_for_service_account_superadmin(client):
    sa_request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-sa-del-{random_id()}",
        description="Superadmin delete token test",
    )

    sa = client.service_account.create_service_account(request=sa_request)

    token_request = CreateApiTokenRequest(name=f"sa-del-token-{random_id()}")
    token_resp = client.service_account.create_api_tokens_for_service_account(
        id=sa.id, request=token_request
    )
    assert token_resp is not None
    token_id = token_resp["id"] if isinstance(token_resp, dict) else token_resp.id
    assert token_id is not None and token_id != ""

    # Should not raise
    client.service_account.delete_api_token_for_service_account(
        id=sa.id, token_id=token_id
    )


# ========================================================================
# Patch superadmin
# ========================================================================


def test_patch_service_account_super_admin_basic(client):
    sa_request = IAMServiceAccountControllerApiCreateServiceAccountRequest(
        name=f"sa-superadmin-{random_id()}",
        description="Superadmin patch test",
    )

    sa = client.service_account.create_service_account(request=sa_request)

    patch_request = ApiPatchSuperAdminRequest(super_admin=True)
    # Should not raise
    client.service_account.patch_service_account_super_admin(
        id=sa.id, request=patch_request
    )

    # Reset back to non-superadmin
    reset_request = ApiPatchSuperAdminRequest(super_admin=False)
    client.service_account.patch_service_account_super_admin(
        id=sa.id, request=reset_request
    )
