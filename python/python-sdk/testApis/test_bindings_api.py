import pytest

from test_helpers import TENANT, random_id
from kestrapy import (
    IAMBindingControllerApiCreateBindingRequest,
    IAMRoleControllerApiRoleCreateOrUpdateRequest,
    IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions,
    ApiException,
)
from kestrapy.models.binding_type import BindingType


# ========================================================================
# Helpers
# ========================================================================

def _create_prereqs(client):
    group = client.groups.create_group(TENANT, {"name": "test_binding_group_" + random_id()})
    role_req = IAMRoleControllerApiRoleCreateOrUpdateRequest(
        name="test_binding_role_" + random_id(),
        permissions=IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions(flow=["READ"]),
    )
    role = client.roles.create_role(TENANT, role_req)
    return group.id, role.id


def _create_binding(client, group_id, role_id):
    req = IAMBindingControllerApiCreateBindingRequest(
        type=BindingType.GROUP,
        external_id=group_id,
        role_id=role_id,
    )
    return client.bindings.create_binding(TENANT, req)


# ========================================================================
# CRUD
# ========================================================================

def test_create_binding(client):
    group_id, role_id = _create_prereqs(client)
    created = _create_binding(client, group_id, role_id)
    assert created is not None
    assert created.id is not None and created.id != ""


def test_get_binding(client):
    group_id, role_id = _create_prereqs(client)
    created = _create_binding(client, group_id, role_id)

    fetched = client.bindings.binding(created.id, TENANT)
    assert fetched.id == created.id


def test_delete_binding(client):
    group_id, role_id = _create_prereqs(client)
    created = _create_binding(client, group_id, role_id)

    client.bindings.delete_binding(created.id, TENANT)

    with pytest.raises(ApiException):
        client.bindings.binding(created.id, TENANT)


# ========================================================================
# Search
# ========================================================================

def test_search_bindings_returns_created(client):
    group_id, role_id = _create_prereqs(client)
    created = _create_binding(client, group_id, role_id)

    result = client.bindings.search_bindings(
        TENANT, page=1, size=100,
        binding_type=BindingType.GROUP, external_id=group_id,
    )

    assert result is not None
    ids = [b.id for b in result.results]
    assert created.id in ids


def test_search_bindings_pagination(client):
    result = client.bindings.search_bindings(TENANT, page=1, size=2)
    assert result is not None
    assert len(result.results) <= 2
