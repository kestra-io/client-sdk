import time
import pytest

from test_helpers import (
    TENANT,
    random_id,
    log_flow_yaml,
    create_flow,
    ns_filter,
)
from kestrapy import (
    Namespace,
    ApiAutocomplete,
    ApiSecretValue,
    ApiSecretMetaEE,
    ApiException,
)


# ========================================================================
# CRUD
# ========================================================================


def test_create_namespace_basic(client):
    ns_id = random_id()
    ns = Namespace(id=ns_id, deleted=False, description="Test namespace")

    result = client.namespaces.create_namespace(tenant=TENANT, namespace=ns)

    assert result is not None
    assert result.id == ns_id
    assert result.description == "Test namespace"


def test_namespace_get_by_id(client):
    ns_id = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False))

    result = client.namespaces.namespace(id=ns_id, tenant=TENANT)

    assert result is not None
    assert result.id == ns_id


def test_update_namespace_change_description(client):
    ns_id = random_id()
    client.namespaces.create_namespace(
        tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False, description="original")
    )

    updated = client.namespaces.update_namespace(
        id=ns_id, tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False, description="updated")
    )

    assert updated.description == "updated"


def test_delete_namespace_basic(client):
    ns_id = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False))

    # Should not raise
    client.namespaces.delete_namespace(id=ns_id, tenant=TENANT)


# ========================================================================
# Search & Autocomplete
# ========================================================================


def test_search_namespaces_basic(client):
    result = client.namespaces.search_namespaces(tenant=TENANT, page=1, size=10)

    assert result is not None
    assert result.results is not None


def test_search_namespaces_with_query(client):
    ns_id = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False))

    result = client.namespaces.search_namespaces(tenant=TENANT, q=ns_id, page=1, size=10)

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0
    assert any(ns.id == ns_id for ns in result.results)


def test_search_namespaces_with_pagination(client):
    result = client.namespaces.search_namespaces(tenant=TENANT, page=1, size=2)

    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 2


def test_search_namespaces_existing_only(client):
    ns_id = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False))

    result = client.namespaces.search_namespaces(
        tenant=TENANT, q=ns_id, page=1, size=10, existing=True
    )

    assert result is not None
    assert result.results is not None
    assert len(result.results) > 0
    assert any(ns.id == ns_id for ns in result.results)


def test_search_namespaces_with_sort(client):
    prefix = f"sortns{random_id()[:6]}"
    id1 = f"{prefix}aaa"
    id2 = f"{prefix}zzz"
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=id2, deleted=False))
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=id1, deleted=False))

    result = client.namespaces.search_namespaces(
        tenant=TENANT, q=prefix, page=1, size=10, sort=["id:asc"]
    )

    assert len(result.results) >= 2
    ids = [ns.id for ns in result.results]
    idx1 = ids.index(id1)
    idx2 = ids.index(id2)
    assert idx1 >= 0
    assert idx2 > idx1


def test_search_namespaces_no_results(client):
    result = client.namespaces.search_namespaces(
        tenant=TENANT, q=f"nonexistent_ns_{random_id()}", page=1, size=10
    )

    assert result is not None
    assert len(result.results) == 0


def test_autocomplete_namespaces_basic(client):
    ns_id = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False))

    request = ApiAutocomplete(q=ns_id[:8])
    result = client.namespaces.autocomplete_namespaces(tenant=TENANT, request=request)

    assert result is not None


# ========================================================================
# Secrets
# ========================================================================


def test_put_secrets_basic(client):
    ns = random_id()
    create_flow(client, log_flow_yaml(random_id(), ns))

    secret = ApiSecretValue(key="MY_SECRET", value="secret_value")
    result = client.namespaces.put_secrets(namespace=ns, tenant=TENANT, secret_value=secret)

    assert result is not None


def test_delete_secret_basic(client):
    ns = random_id()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.namespaces.put_secrets(
        namespace=ns,
        tenant=TENANT,
        secret_value=ApiSecretValue(key="TO_DELETE", value="val"),
    )

    # Should not raise
    client.namespaces.delete_secret(namespace=ns, key="TO_DELETE", tenant=TENANT)


def test_inherited_secrets_basic(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    result = client.namespaces.inherited_secrets(namespace=ns, tenant=TENANT)

    assert result is not None


# ========================================================================
# Variables
# ========================================================================


def test_inherited_variables_basic(client):
    ns = random_id()
    create_flow(client, log_flow_yaml(random_id(), ns))

    result = client.namespaces.inherited_variables(id=ns, tenant=TENANT)

    assert result is not None


# ========================================================================
# Plugin Defaults
# ========================================================================


def test_inherited_plugin_defaults_basic(client):
    ns = random_id()
    create_flow(client, log_flow_yaml(random_id(), ns))

    result = client.namespaces.inherited_plugin_defaults(id=ns, tenant=TENANT)

    assert result is not None


# ========================================================================
# Patch secret
# ========================================================================


def test_patch_secret_basic(client):
    ns = random_id()
    create_flow(client, log_flow_yaml(random_id(), ns))

    client.namespaces.put_secrets(
        namespace=ns,
        tenant=TENANT,
        secret_value=ApiSecretValue(key="PATCH_ME", value="original"),
    )

    meta = ApiSecretMetaEE(key="PATCH_ME", description="patched description", tags=[])
    result = client.namespaces.patch_secret(
        namespace=ns, key="PATCH_ME", tenant=TENANT, meta=meta
    )

    assert result is not None


# ========================================================================
# Plugin defaults export/import
# ========================================================================


def test_export_plugin_defaults_basic(client):
    ns = random_id()
    # plugin_defaults must be a list (not None) — the server NPEs in /plugindefaults/export
    # when Namespace.pluginDefaults is null.
    client.namespaces.create_namespace(
        tenant=TENANT,
        namespace=Namespace(id=ns, deleted=False, plugin_defaults=[]),
    )

    result = client.namespaces.export_plugin_defaults(id=ns, tenant=TENANT)
    assert result is not None


def test_import_plugin_defaults_basic(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    # Import with None file -- may return error or empty list
    try:
        result = client.namespaces.import_plugin_defaults(id=ns, tenant=TENANT)
        assert result is not None
    except ApiException as e:
        assert e.status in (400, 500)
