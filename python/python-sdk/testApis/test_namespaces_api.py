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


# ========================================================================
# Credentials
# ========================================================================

# Credentials are an EE-licensed feature; the local test server may answer
# 4xx/5xx if it isn't enabled. We exercise the SDK wiring (path, params,
# response shape) and tolerate "feature unavailable" responses.


def _oauth2_credential_body(name):
    return {
        "type": "OAUTH2",
        "name": name,
        "description": "test",
        "tokenEndpoint": "https://login.example.com/oauth2/token",
        "scopes": ["read"],
        "authConfig": {
            "type": "CLIENT_CREDENTIALS",
            "clientId": "client-id",
            "clientSecret": "client-secret",
        },
    }


def test_list_namespace_credentials_basic(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    try:
        result = client.namespaces.list_namespace_credentials(namespace=ns, tenant=TENANT)
        assert result is not None
        assert "results" in result or "total" in result
    except ApiException as e:
        assert e.status in (400, 403, 404, 500, 501)


def test_list_namespace_credentials_with_pagination(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    try:
        result = client.namespaces.list_namespace_credentials(
            namespace=ns, tenant=TENANT, page=1, size=5,
        )
        assert result is not None
    except ApiException as e:
        assert e.status in (400, 403, 404, 500, 501)


def test_create_namespace_credential_basic(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    body = _oauth2_credential_body(f"cred-{random_id()[:8]}")
    try:
        result = client.namespaces.create_namespace_credential(
            namespace=ns, tenant=TENANT, body=body,
        )
        assert result is not None
        assert result.get("name") == body["name"]
    except ApiException as e:
        # Feature may be disabled or validation may reject the dummy auth config.
        assert e.status in (400, 403, 404, 422, 500, 501)


def test_get_inherited_credentials_basic(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    try:
        result = client.namespaces.get_inherited_credentials(namespace=ns, tenant=TENANT)
        assert result is not None
        assert "levels" in result
    except ApiException as e:
        assert e.status in (400, 403, 404, 500, 501)


def test_namespace_credential_not_found(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    with pytest.raises(ApiException) as exc_info:
        client.namespaces.namespace_credential(
            namespace=ns, name=f"missing-{random_id()[:8]}", tenant=TENANT,
        )
    # 404 if feature is enabled, other 4xx/5xx if disabled.
    assert exc_info.value.status in (400, 403, 404, 500, 501)


def test_update_namespace_credential_not_found(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    body = {"type": "OAUTH2", "description": "updated"}
    with pytest.raises(ApiException) as exc_info:
        client.namespaces.update_namespace_credential(
            namespace=ns, name=f"missing-{random_id()[:8]}", tenant=TENANT, body=body,
        )
    assert exc_info.value.status in (400, 403, 404, 422, 500, 501)


def test_delete_namespace_credential_not_found(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    # Delete of a missing credential should not raise on a happy path with
    # idempotent delete; if the server returns 404, that's acceptable too.
    try:
        client.namespaces.delete_namespace_credential(
            namespace=ns, name=f"missing-{random_id()[:8]}", tenant=TENANT,
        )
    except ApiException as e:
        assert e.status in (400, 403, 404, 500, 501)


def test_test_namespace_connection_not_found(client):
    ns = random_id()
    client.namespaces.create_namespace(tenant=TENANT, namespace=Namespace(id=ns, deleted=False))

    with pytest.raises(ApiException) as exc_info:
        client.namespaces.test_namespace_connection(
            namespace=ns, name=f"missing-{random_id()[:8]}", tenant=TENANT,
        )
    assert exc_info.value.status in (400, 403, 404, 500, 501)


# ========================================================================
# Cross-namespace secrets listing
# ========================================================================


def test_list_secrets_basic(client):
    ns = random_id()
    create_flow(client, log_flow_yaml(random_id(), ns))
    client.namespaces.put_secrets(
        namespace=ns, tenant=TENANT,
        secret_value=ApiSecretValue(key="LIST_ME", value="val"),
    )

    result = client.namespaces.list_secrets(tenant=TENANT, page=1, size=50)
    assert result is not None
    assert result.results is not None


def test_list_secrets_with_namespace_filter(client):
    ns = random_id()
    create_flow(client, log_flow_yaml(random_id(), ns))
    client.namespaces.put_secrets(
        namespace=ns, tenant=TENANT,
        secret_value=ApiSecretValue(key="FILTER_ME", value="val"),
    )

    result = client.namespaces.list_secrets(
        tenant=TENANT, page=1, size=50, filters=[ns_filter(ns)],
    )
    assert result is not None
    assert result.results is not None
    keys = [getattr(s, "key", None) for s in result.results]
    assert "FILTER_ME" in keys


def test_list_secrets_pagination_bounds(client):
    result = client.namespaces.list_secrets(tenant=TENANT, page=1, size=1)
    assert result is not None
    assert result.results is not None
    assert len(result.results) <= 1


# ========================================================================
# 404 / 409 edge cases
# ========================================================================


def test_namespace_get_unknown_id_raises(client):
    with pytest.raises(ApiException) as exc_info:
        client.namespaces.namespace(id=f"missing-{random_id()}", tenant=TENANT)
    assert exc_info.value.status in (400, 404)


def test_update_namespace_unknown_id_raises(client):
    ns_id = f"missing-{random_id()}"
    with pytest.raises(ApiException) as exc_info:
        client.namespaces.update_namespace(
            id=ns_id, tenant=TENANT, namespace=Namespace(id=ns_id, deleted=False),
        )
    assert exc_info.value.status in (400, 404, 422)


def test_delete_namespace_unknown_id_does_not_error(client):
    # The namespace controller may treat delete-unknown as a no-op (silent)
    # or 404 — accept either as long as the SDK transports the call.
    try:
        client.namespaces.delete_namespace(id=f"missing-{random_id()}", tenant=TENANT)
    except ApiException as e:
        assert e.status in (400, 404)
