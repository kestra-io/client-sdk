import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    query_filter,
)
from kestrapy import (
    Configuration,
    KestraClient,
    IAMUserControllerApiCreateOrUpdateUserRequest,
    IAMTenantAccessControllerUserApiAutocomplete,
    CreateApiTokenRequest,
    MeControllerApiUpdatePasswordRequest,
    MeControllerApiUserDetailsRequest,
    IAMUserControllerApiPatchUserPasswordRequest,
    ApiPatchSuperAdminRequest,
    IAMUserGroupControllerApiUpdateUserGroupsRequest,
    IAMGroupControllerApiCreateGroupRequest,
    ApiException,
)


# ========================================================================
# CRUD (Superadmin-scoped)
# ========================================================================


def test_create_user_basic(client):
    email = f"test-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Test",
        last_name="User",
        password="TestPass!1234",
    )

    result = client.users.create_user(request=request)

    assert result is not None
    assert result.id is not None and result.id != ""


def test_user_get_by_id(client):
    email = f"get-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Get",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    result = client.users.user(id=created.id)

    assert result is not None
    assert result.id == created.id


def test_update_user_basic(client):
    email = f"update-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Before",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    update_request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=created.email,
        first_name="After",
        last_name="User",
        password="TestPass!1234",
    )

    updated = client.users.update_user(id=created.id, request=update_request)

    assert updated.first_name == "After"


def test_delete_user_basic(client):
    email = f"delete-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Delete",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    # Should not raise
    client.users.delete_user(id=created.id)


# ========================================================================
# Search
# ========================================================================


def test_list_users_basic(client):
    result = client.users.list_users(page=1, size=10)

    assert result is not None
    assert result.results is not None


def test_list_users_with_pagination(client):
    result = client.users.list_users(page=1, size=2)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 2


def test_list_users_with_query_filter(client):
    email = f"filter-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Filter",
        last_name="User",
        password="TestPass!1234",
    )

    client.users.create_user(request=request)
    time.sleep(0.3)

    result = client.users.list_users(page=1, size=10, filters=[query_filter(email)])

    assert result is not None
    assert len(result.results) > 0


def test_list_users_no_results(client):
    result = client.users.list_users(
        page=1, size=10, filters=[query_filter(f"nonexistent_user_{random_id()}")]
    )

    assert result is not None
    assert len(result.results) == 0


# ========================================================================
# API tokens
# ========================================================================


def test_api_tokens_create_list_delete(client):
    email = f"token-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Token",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    token_request = CreateApiTokenRequest(name=f"test-token-{random_id()}")
    token_resp = client.users.create_api_tokens_for_user(
        id=created.id, request=token_request
    )
    assert token_resp is not None

    tokens = client.users.list_api_tokens_for_user(id=created.id)
    assert tokens is not None


# ========================================================================
# Patch operations
# ========================================================================


def test_patch_user_basic(client):
    email = f"patch-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Patch",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    patch_request = MeControllerApiUserDetailsRequest(first_name="Patched")
    result = client.users.patch_user(id=created.id, request=patch_request)

    assert result is not None
    assert result.first_name == "Patched"


# ========================================================================
# Autocomplete (tenant-scoped)
# ========================================================================


def test_autocomplete_users_basic(client):
    email = f"auto-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Auto",
        last_name="Complete",
        password="TestPass!1234",
    )

    client.users.create_user(request=request)

    autocomplete = IAMTenantAccessControllerUserApiAutocomplete(q="auto")
    result = client.users.autocomplete_users(tenant=TENANT, request=autocomplete)

    assert result is not None


# ========================================================================
# User groups (tenant-scoped)
# ========================================================================


def test_update_user_groups_basic(client):
    email = f"groups-{random_id()}@test.com"
    user_request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Groups",
        last_name="User",
        password="TestPass!1234",
    )

    user = client.users.create_user(request=user_request)

    group_request = IAMGroupControllerApiCreateGroupRequest(
        name=f"user-grp-{random_id()}",
        description="Test group for user",
    )
    group = client.groups.create_group(TENANT, group_request)

    update_request = IAMUserGroupControllerApiUpdateUserGroupsRequest(
        group_ids=[group.id]
    )

    with pytest.raises(ApiException):
        client.users.update_user_groups(
            id=user.id, tenant=TENANT, request=update_request
        )


# ========================================================================
# Delete API token
# ========================================================================


def test_delete_api_token_for_user_basic(client):
    email = f"del-token-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="DelToken",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    token_request = CreateApiTokenRequest(name=f"token-to-delete-{random_id()}")
    token_resp = client.users.create_api_tokens_for_user(
        id=created.id, request=token_request
    )
    assert token_resp is not None
    assert token_resp.id is not None and token_resp.id != ""

    # Should not raise
    client.users.delete_api_token_for_user(id=created.id, token_id=token_resp.id)


# ========================================================================
# Impersonation
# ========================================================================


def test_impersonate_basic(client):
    email = f"impersonate-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Impersonate",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    result = client.users.impersonate(id=created.id)

    assert result is not None


# ========================================================================
# Patch superadmin
# ========================================================================


def test_patch_user_super_admin_basic(client):
    email = f"superadmin-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Super",
        last_name="Admin",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    patch_request = ApiPatchSuperAdminRequest(super_admin=True)
    # Should not raise
    client.users.patch_user_super_admin(id=created.id, request=patch_request)

    # Reset back to non-superadmin
    reset_request = ApiPatchSuperAdminRequest(super_admin=False)
    client.users.patch_user_super_admin(id=created.id, request=reset_request)
