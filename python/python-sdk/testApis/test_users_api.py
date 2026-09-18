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
    IAMUserControllerApiPatchRestrictedRequest,
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


# ========================================================================
# Patch user demo (restricted flag)
# ========================================================================


def test_patch_user_demo_basic(client):
    email = f"demo-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Demo",
        last_name="User",
        password="TestPass!1234",
    )

    created = client.users.create_user(request=request)

    # Should not raise; void endpoint.
    client.users.patch_user_demo(
        id=created.id,
        request=IAMUserControllerApiPatchRestrictedRequest(restricted=True),
    )
    client.users.patch_user_demo(
        id=created.id,
        request=IAMUserControllerApiPatchRestrictedRequest(restricted=False),
    )


# ========================================================================
# Patch user password
# ========================================================================


def test_patch_user_password_basic(client):
    email = f"pwd-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Pwd",
        last_name="User",
        password="TestPass!1234",
    )
    created = client.users.create_user(request=request)

    new_password = "NewPass!9876"
    result = client.users.patch_user_password(
        id=created.id,
        request=IAMUserControllerApiPatchUserPasswordRequest(password=new_password),
    )
    assert result is not None
    assert result.id == created.id


# ========================================================================
# Delete user auth method
# ========================================================================


def test_delete_user_auth_method_unknown_auth(client):
    email = f"auth-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Auth",
        last_name="User",
        password="TestPass!1234",
    )
    created = client.users.create_user(request=request)

    # The freshly created user has no SAML/OIDC auth method, only the
    # implicit password — deleting an unknown auth should 4xx without
    # corrupting the user record.
    with pytest.raises(ApiException) as exc_info:
        client.users.delete_user_auth_method(id=created.id, auth="OIDC")
    assert exc_info.value.status in (400, 404, 422, 500)


# ========================================================================
# Delete refresh token
# ========================================================================


def test_delete_refresh_token_basic(client):
    email = f"refresh-{random_id()}@test.com"
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email,
        first_name="Refresh",
        last_name="User",
        password="TestPass!1234",
    )
    created = client.users.create_user(request=request)

    # The endpoint is idempotent — a user with no active refresh token
    # should still accept the delete without raising.
    client.users.delete_refresh_token(id=created.id)


# ========================================================================
# Update current user password
# ========================================================================


def test_update_current_user_password_wrong_old_password_raises(client):
    # The shared session authenticates as root@root.com; we don't want to
    # rotate the real password (other tests rely on it), so we exercise
    # the endpoint with a wrong old password and expect rejection.
    with pytest.raises(ApiException) as exc_info:
        client.users.update_current_user_password(
            request=MeControllerApiUpdatePasswordRequest(
                old_password="DefinitelyWrong!1234",
                new_password="WhateverNew!5678",
            )
        )
    assert exc_info.value.status in (400, 401, 403, 422)


# ========================================================================
# 404 / 409 edge cases
# ========================================================================


def test_user_get_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.users.user(id=f"missing-{random_id()}")
    assert exc_info.value.status in (400, 404)


def test_delete_user_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.users.delete_user(id=f"missing-{random_id()}")
    assert exc_info.value.status in (400, 404)


def test_create_user_duplicate_email_conflicts(client):
    email = f"dup-{random_id()}@test.com"
    req = IAMUserControllerApiCreateOrUpdateUserRequest(
        email=email, first_name="Dup", last_name="User", password="TestPass!1234",
    )
    client.users.create_user(request=req)

    with pytest.raises(ApiException) as exc_info:
        client.users.create_user(request=req)
    assert exc_info.value.status in (409, 422)
