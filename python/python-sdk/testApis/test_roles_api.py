import pytest

from kestrapy import (
    IAMRoleControllerApiRoleCreateOrUpdateRequest,
    IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions,
    ApiAutocomplete,
    ApiIds,
)
from kestrapy.exceptions import ApiException
from test_helpers import TENANT, random_id


# ========================================================================
# Helpers
# ========================================================================

def create_test_role(client, name):
    request = IAMRoleControllerApiRoleCreateOrUpdateRequest(
        name=name,
        description="Test role: " + name,
        permissions=IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions(flow=["READ"]),
    )
    return client.roles.create_role(TENANT, request)


# ========================================================================
# CRUD
# ========================================================================

def test_create_role_basic(client):
    name = "test-role-" + random_id()
    result = create_test_role(client, name)

    assert result is not None
    assert result.name == name
    assert name in result.description
    assert result.id is not None and result.id != ""


def test_role_get_by_id(client):
    name = "test-role-" + random_id()
    created = create_test_role(client, name)

    result = client.roles.role(created.id, TENANT)

    assert result is not None
    assert result.id == created.id
    assert result.name == name


def test_role_not_found(client):
    with pytest.raises(ApiException):
        client.roles.role("nonexistent-role-id", TENANT)


def test_update_role_change_name(client):
    created = create_test_role(client, "before-" + random_id())
    new_name = "after-" + random_id()

    update = IAMRoleControllerApiRoleCreateOrUpdateRequest(
        name=new_name,
        description="Updated description",
        permissions=IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions(flow=["READ"]),
    )

    updated = client.roles.update_role(created.id, TENANT, update)

    assert updated.name == new_name
    assert updated.description == "Updated description"


def test_delete_role_basic(client):
    created = create_test_role(client, "to-delete-" + random_id())

    client.roles.delete_role(created.id, TENANT)

    with pytest.raises(ApiException):
        client.roles.role(created.id, TENANT)


# ========================================================================
# Search
# ========================================================================

def test_search_roles_basic(client):
    create_test_role(client, "searchable-" + random_id())

    result = client.roles.search_roles(TENANT, 1, 10)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_roles_with_pagination(client):
    result = client.roles.search_roles(TENANT, 1, 2)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 2


def test_search_roles_with_query_filter(client):
    name = "query-filter-" + random_id()
    create_test_role(client, name)

    result = client.roles.search_roles(TENANT, 1, 10, q=name)

    assert result is not None
    assert len(result.results) > 0


def test_search_roles_with_sort(client):
    name1 = "aaa" + random_id()
    name2 = "zzz" + random_id()
    create_test_role(client, name2)
    create_test_role(client, name1)

    result = client.roles.search_roles(TENANT, 1, 100, sort=["name:asc"])

    assert len(result.results) >= 2
    names = [r.name for r in result.results]
    idx1 = names.index(name1)
    idx2 = names.index(name2)
    assert idx1 >= 0
    assert idx2 > idx1


def test_search_roles_no_results(client):
    result = client.roles.search_roles(
        TENANT, 1, 10, q="nonexistent_role_" + random_id()
    )

    assert result is not None
    assert len(result.results) == 0


# ========================================================================
# Autocomplete & List by IDs
# ========================================================================

def test_autocomplete_roles_basic(client):
    created = create_test_role(client, "autocomplete-" + random_id())

    request = ApiAutocomplete(q=created.name[:10])
    result = client.roles.autocomplete_roles(TENANT, request)

    assert result is not None
    assert len(result) > 0


def test_list_roles_from_given_ids_basic(client):
    r1 = create_test_role(client, "ids-test-" + random_id())

    ids = ApiIds(ids=[r1.id])
    result = client.roles.list_roles_from_given_ids(TENANT, ids)

    assert result is not None
    assert len(result) == 1
    assert result[0].id == r1.id


def test_list_roles_from_given_ids_multiple(client):
    r1 = create_test_role(client, "ids1-" + random_id())
    r2 = create_test_role(client, "ids2-" + random_id())

    ids = ApiIds(ids=[r1.id, r2.id])
    result = client.roles.list_roles_from_given_ids(TENANT, ids)

    assert result is not None
    assert len(result) == 2


# ========================================================================
# 404 / 409 edge cases
# ========================================================================


def test_delete_role_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.roles.delete_role(f"missing-{random_id()}", TENANT)
    assert exc_info.value.status in (400, 404)


def test_create_role_with_write_permission(client):
    name = "wr-role-" + random_id()
    request = IAMRoleControllerApiRoleCreateOrUpdateRequest(
        name=name,
        description="role with write permission",
        permissions=IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions(
            flow=["READ", "CREATE", "UPDATE", "DELETE"],
        ),
    )

    result = client.roles.create_role(TENANT, request)

    assert result is not None
    assert result.name == name


def test_create_role_with_execution_and_namespace_permissions(client):
    name = "multi-perm-role-" + random_id()
    request = IAMRoleControllerApiRoleCreateOrUpdateRequest(
        name=name,
        description="role spanning multiple permission domains",
        permissions=IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions(
            flow=["READ"],
            execution=["READ", "UPDATE"],
            namespace=["READ"],
        ),
    )

    result = client.roles.create_role(TENANT, request)

    assert result is not None
    assert result.name == name


def test_create_role_duplicate_name_does_not_uniqueness_check(client):
    # The server does NOT enforce unique role names — two roles with the
    # same name can coexist (the id is the actual unique identifier).
    # We assert the second create succeeds AND produces a distinct id, so
    # this regression is caught if the server later starts rejecting dupes.
    name = "dup-role-" + random_id()
    request = IAMRoleControllerApiRoleCreateOrUpdateRequest(
        name=name,
        description="duplicate test",
        permissions=IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions(flow=["READ"]),
    )
    first = client.roles.create_role(TENANT, request)
    second = client.roles.create_role(TENANT, request)

    assert first.id != second.id
    assert first.name == second.name
