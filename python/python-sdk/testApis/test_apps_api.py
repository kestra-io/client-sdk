import time

import pytest

from kestrapy import (
    ApiException,
    AppsControllerApiBulkOperationRequest,
)
from test_helpers import (
    TENANT,
    random_id,
    log_flow_yaml,
    create_flow,
    ns_filter,
)


# ========================================================================
# Helpers
# ========================================================================


def _app_yaml(app_id, namespace, flow_id):
    return f"""\
id: {app_id}
type: io.kestra.plugin.ee.apps.Execution
namespace: {namespace}
flowId: {flow_id}
displayName: Test App {app_id}
layout:
  - on: OPEN
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "# Test App"
  - on: RUNNING
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "Running..."
  - on: SUCCESS
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "Done!"
"""


def _create_app_with_flow(client):
    """Helper: create a flow and an app pointing to it. Returns (app, ns, flow_id)."""
    ns = random_id()
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))
    app = client.apps.create_app(TENANT, _app_yaml(random_id(), ns, flow_id))
    return app, ns, flow_id


# ========================================================================
# CRUD
# ========================================================================


class TestCRUD:
    def test_create_app_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        result = client.apps.create_app(TENANT, _app_yaml(random_id(), ns, flow_id))
        assert result is not None
        assert result.namespace == ns

    def test_app_get_by_uid(self, client):
        created, _, _ = _create_app_with_flow(client)

        result = client.apps.app(created.uid, TENANT)
        assert result is not None
        assert result.uid == created.uid

    def test_update_app_basic(self, client):
        ns = random_id()
        flow_id = random_id()
        app_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        created = client.apps.create_app(TENANT, _app_yaml(app_id, ns, flow_id))
        updated_yaml = created.source.replace(f"Test App {app_id}", f"Updated App {app_id}")

        client.apps.update_app(created.uid, TENANT, updated_yaml)

        fetched = client.apps.app(created.uid, TENANT)
        assert fetched is not None
        assert fetched.uid == created.uid

    def test_delete_app_basic(self, client):
        created, _, _ = _create_app_with_flow(client)

        # Should not raise
        client.apps.delete_app(created.uid, TENANT)


# ========================================================================
# Enable / Disable
# ========================================================================


class TestEnableDisable:
    def test_enable_disable_app(self, client):
        created, _, _ = _create_app_with_flow(client)

        disabled = client.apps.disable_app(created.uid, TENANT)
        assert disabled is not None

        enabled = client.apps.enable_app(created.uid, TENANT)
        assert enabled is not None


# ========================================================================
# Search
# ========================================================================


class TestSearch:
    def test_search_apps_basic(self, client):
        result = client.apps.search_apps(TENANT, 1, 10)
        assert result is not None
        assert result.results is not None

    def test_search_apps_from_catalog_basic(self, client):
        result = client.apps.search_apps_from_catalog(TENANT, 1, 10)
        assert result is not None
        assert result.results is not None

    def test_search_apps_with_namespace(self, client):
        created, ns, _ = _create_app_with_flow(client)

        result = client.apps.search_apps(TENANT, 1, 10, namespace=ns)
        assert result is not None
        assert len(result.results) > 0
        assert any(app.uid == created.uid for app in result.results)

    def test_search_apps_with_flow_id(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        created = client.apps.create_app(TENANT, _app_yaml(random_id(), ns, flow_id))

        result = client.apps.search_apps(TENANT, 1, 10, namespace=ns, flow_id=flow_id)
        assert result is not None
        assert len(result.results) > 0
        assert any(app.uid == created.uid for app in result.results)

    def test_search_apps_with_query(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        app_id1 = "searchq" + random_id()
        app_id2 = "other" + random_id()
        client.apps.create_app(TENANT, _app_yaml(app_id1, ns, flow_id))
        client.apps.create_app(TENANT, _app_yaml(app_id2, ns, flow_id))

        result = client.apps.search_apps(TENANT, 1, 10, q=f"Test App {app_id1}", namespace=ns)
        assert len(result.results) > 0
        for app in result.results:
            assert app_id1 in app.name

    def test_search_apps_with_sort(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))

        app_id1 = "aaa" + random_id()
        app_id2 = "zzz" + random_id()
        client.apps.create_app(TENANT, _app_yaml(app_id2, ns, flow_id))
        client.apps.create_app(TENANT, _app_yaml(app_id1, ns, flow_id))

        result = client.apps.search_apps(TENANT, 1, 10, namespace=ns, sort=["id:asc"])
        assert len(result.results) >= 2
        ids = [app.id for app in result.results]
        idx1 = ids.index(app_id1)
        idx2 = ids.index(app_id2)
        assert idx1 >= 0
        assert idx2 > idx1

    def test_search_apps_with_tags(self, client):
        all_apps = client.apps.search_apps(TENANT, 1, 10)

        if all_apps.results:
            first_with_tags = next(
                (a for a in all_apps.results if a.tags is not None and len(a.tags) > 0),
                None,
            )
            if first_with_tags is not None:
                tag = first_with_tags.tags[0]
                result = client.apps.search_apps(TENANT, 1, 10, tags=[tag])
                assert len(result.results) > 0
                for app in result.results:
                    assert tag in app.tags

    def test_search_apps_with_filters(self, client):
        ns1 = random_id()
        ns2 = random_id()
        flow_id1 = random_id()
        flow_id2 = random_id()
        create_flow(client, log_flow_yaml(flow_id1, ns1))
        create_flow(client, log_flow_yaml(flow_id2, ns2))

        client.apps.create_app(TENANT, _app_yaml(random_id(), ns1, flow_id1))
        client.apps.create_app(TENANT, _app_yaml(random_id(), ns2, flow_id2))

        result = client.apps.search_apps(TENANT, 1, 10, filters=[ns_filter(ns1)])
        assert len(result.results) > 0
        for app in result.results:
            assert app.namespace == ns1

    def test_search_apps_from_catalog_with_filters(self, client):
        ns = random_id()
        flow_id = random_id()
        create_flow(client, log_flow_yaml(flow_id, ns))
        client.apps.create_app(TENANT, _app_yaml(random_id(), ns, flow_id))

        result = client.apps.search_apps_from_catalog(TENANT, 1, 10, [ns_filter(ns)])
        assert result is not None
        assert len(result.results) > 0

    def test_search_apps_no_results(self, client):
        result = client.apps.search_apps(TENANT, 1, 10, namespace="nonexistent_ns_" + random_id())
        assert result is not None
        assert len(result.results) == 0


# ========================================================================
# Tags
# ========================================================================


class TestTags:
    def test_list_tags_basic(self, client):
        result = client.apps.list_tags(TENANT)
        assert result is not None


# ========================================================================
# Bulk operations
# ========================================================================


class TestBulkOperations:
    def test_bulk_delete_apps_basic(self, client):
        created, _, _ = _create_app_with_flow(client)

        request = AppsControllerApiBulkOperationRequest(uids=[created.uid])
        # Should not raise
        client.apps.bulk_delete_apps(TENANT, request)

    def test_bulk_enable_apps_basic(self, client):
        created, _, _ = _create_app_with_flow(client)

        request = AppsControllerApiBulkOperationRequest(uids=[created.uid])
        # Should not raise
        client.apps.bulk_enable_apps(TENANT, request)

    def test_bulk_disable_apps_basic(self, client):
        created, _, _ = _create_app_with_flow(client)

        request = AppsControllerApiBulkOperationRequest(uids=[created.uid])
        # Should not raise
        client.apps.bulk_disable_apps(TENANT, request)

    def test_bulk_export_apps_basic(self, client):
        created, _, _ = _create_app_with_flow(client)

        request = AppsControllerApiBulkOperationRequest(uids=[created.uid])
        result = client.apps.bulk_export_apps(TENANT, request)
        assert result is not None
        assert len(result) > 0

    def test_bulk_import_apps_no_file(self, client):
        # Import with None file should fail
        with pytest.raises(Exception):
            client.apps.bulk_import_apps(TENANT, None)
