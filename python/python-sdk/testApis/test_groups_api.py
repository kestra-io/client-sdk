import pytest

from kestrapy import (
    IAMGroupControllerApiCreateGroupRequest,
    IAMGroupControllerApiUpdateGroupRequest,
    IAMUserControllerApiCreateOrUpdateUserRequest,
    ApiAutocomplete,
    ApiIds,
    GroupIdentifierMembership,
)
from kestrapy.exceptions import ApiException
from test_helpers import TENANT, random_id, query_filter


# ========================================================================
# Helpers
# ========================================================================

def create_test_group(client, name):
    request = IAMGroupControllerApiCreateGroupRequest(
        name=name,
        description="Test group: " + name,
    )
    return client.groups.create_group(TENANT, request)


def create_test_user(client):
    request = IAMUserControllerApiCreateOrUpdateUserRequest(
        email="grp-" + random_id() + "@test.com",
        first_name="Group",
        last_name="Member",
        password="TestPass!1234",
    )
    return client.users.create_user(request)


# ========================================================================
# CRUD
# ========================================================================

def test_create_group_basic(client):
    name = "test-group-" + random_id()
    result = create_test_group(client, name)

    assert result is not None
    assert result.name == name
    assert name in result.description
    assert result.id is not None and result.id != ""


def test_group_get_by_id(client):
    name = "test-group-" + random_id()
    created = create_test_group(client, name)

    result = client.groups.group(created.id, TENANT)

    assert result is not None
    assert result.id == created.id
    assert result.name == name


def test_group_not_found(client):
    with pytest.raises(ApiException):
        client.groups.group("nonexistent-group-id", TENANT)


def test_update_group_change_name(client):
    created = create_test_group(client, "before-" + random_id())
    new_name = "after-" + random_id()

    update = IAMGroupControllerApiUpdateGroupRequest(
        name=new_name,
        description="Updated description",
    )

    updated = client.groups.update_group(created.id, TENANT, update)

    assert updated.name == new_name
    assert updated.description == "Updated description"


def test_delete_group_basic(client):
    created = create_test_group(client, "to-delete-" + random_id())

    client.groups.delete_group(created.id, TENANT)

    with pytest.raises(ApiException):
        client.groups.group(created.id, TENANT)


# ========================================================================
# Search & List
# ========================================================================

def test_search_groups_basic(client):
    create_test_group(client, "searchable-" + random_id())

    result = client.groups.search_groups(TENANT, 1, 10)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_groups_with_pagination(client):
    result = client.groups.search_groups(TENANT, 1, 2)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 2


def test_search_groups_with_query_filter(client):
    prefix = "qfgrp" + random_id()
    create_test_group(client, prefix)

    result = client.groups.search_groups(TENANT, 1, 10, filters=[query_filter(prefix)])

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0


def test_search_groups_with_sort(client):
    name1 = "aaa" + random_id()
    name2 = "zzz" + random_id()
    create_test_group(client, name2)
    create_test_group(client, name1)

    result = client.groups.search_groups(TENANT, 1, 100, sort=["name:asc"])

    assert len(result.results) >= 2
    names = [r.name for r in result.results]
    idx1 = names.index(name1)
    idx2 = names.index(name2)
    assert idx1 >= 0
    assert idx2 > idx1


def test_search_groups_no_results(client):
    result = client.groups.search_groups(
        TENANT, 1, 10, filters=[query_filter("nonexistent_group_" + random_id())]
    )

    assert result is not None
    assert result.results is None or len(result.results) == 0 or result.total == 0


def test_autocomplete_groups_basic(client):
    created = create_test_group(client, "autocomplete-" + random_id())

    request = ApiAutocomplete(q=created.name[:10])
    result = client.groups.autocomplete_groups(TENANT, request)

    assert result is not None
    assert len(result) > 0


def test_list_group_ids_basic(client):
    g1 = create_test_group(client, "ids-test-" + random_id())

    ids = ApiIds(ids=[g1.id])
    result = client.groups.list_group_ids(TENANT, ids)

    assert result is not None
    assert len(result) == 1


def test_list_group_ids_multiple(client):
    g1 = create_test_group(client, "ids1-" + random_id())
    g2 = create_test_group(client, "ids2-" + random_id())

    ids = ApiIds(ids=[g1.id, g2.id])
    result = client.groups.list_group_ids(TENANT, ids)

    assert result is not None
    assert len(result) == 2


# ========================================================================
# Members
# ========================================================================

def test_search_group_members_basic(client):
    group = create_test_group(client, "members-" + random_id())

    result = client.groups.search_group_members(group.id, TENANT, 1, 10)

    assert result is not None
    assert result.results is not None


def test_search_group_members_with_filters(client):
    group = create_test_group(client, "members-filter-" + random_id())
    user1 = create_test_user(client)
    user2 = create_test_user(client)
    client.groups.add_user_to_group(group.id, user1.id, TENANT)
    client.groups.add_user_to_group(group.id, user2.id, TENANT)

    result = client.groups.search_group_members(
        group.id, TENANT, 1, 10, filters=[query_filter(user1.email)]
    )

    assert len(result.results) > 0
    assert all(m.username == user1.email for m in result.results)


# ========================================================================
# Member management
# ========================================================================

def test_add_user_to_group_basic(client):
    group = create_test_group(client, "add-member-" + random_id())
    user = create_test_user(client)

    result = client.groups.add_user_to_group(group.id, user.id, TENANT)

    assert result is not None
    assert result.id == user.id


def test_delete_user_from_group_basic(client):
    group = create_test_group(client, "del-member-" + random_id())
    user = create_test_user(client)

    client.groups.add_user_to_group(group.id, user.id, TENANT)

    result = client.groups.delete_user_from_group(group.id, user.id, TENANT)

    assert result is not None
    assert result.id == user.id


def test_set_user_membership_for_group_basic(client):
    group = create_test_group(client, "membership-" + random_id())
    user = create_test_user(client)

    client.groups.add_user_to_group(group.id, user.id, TENANT)

    result = client.groups.set_user_membership_for_group(
        group.id, user.id, GroupIdentifierMembership.OWNER, TENANT
    )

    assert result is not None
    assert result.id == user.id


# ========================================================================
# 404 / 409 edge cases
# ========================================================================


def test_set_user_membership_for_group_member_role(client):
    group = create_test_group(client, "member-role-" + random_id())
    user = create_test_user(client)

    client.groups.add_user_to_group(group.id, user.id, TENANT)

    result = client.groups.set_user_membership_for_group(
        group.id, user.id, GroupIdentifierMembership.MEMBER, TENANT,
    )

    assert result is not None
    assert result.id == user.id


def test_delete_group_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.groups.delete_group(f"missing-{random_id()}", TENANT)
    assert exc_info.value.status in (400, 404)


def test_create_group_duplicate_name_conflicts(client):
    name = "dup-group-" + random_id()
    request = IAMGroupControllerApiCreateGroupRequest(
        name=name, description="duplicate test",
    )
    client.groups.create_group(TENANT, request)

    with pytest.raises(ApiException) as exc_info:
        client.groups.create_group(TENANT, request)
    assert exc_info.value.status in (409, 422)
