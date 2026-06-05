import json
import os
import tempfile
import time

import pytest

from kestrapy import (
    ApiException,
    ConcurrencyLimit,
    FlowControllerTaskValidationType,
    IdWithNamespace,
    QueryFilter,
    QueryFilterField,
    QueryFilterOp,
)
from test_helpers import (
    TENANT,
    random_id,
    random_namespace,
    log_flow_yaml,
    log_flow_yaml_with_description,
    log_flow_yaml_with_labels,
    two_task_flow_yaml,
    concurrency_flow_yaml,
    invalid_task_flow_yaml,
    create_flow,
    create_log_flow,
    simple_flow_fixture,
    complete_flow_body,
    ns_filter,
    query_filter,
    flow_id_filter,
    labels_filter,
)


# ========================================================================
# CRUD -- createFlow
# ========================================================================


class TestCreateFlow:
    def test_simple(self, client):
        body, ns, fid = simple_flow_fixture()
        result = client.flows.create_flow(TENANT, body)

        assert result.id == fid
        assert result.namespace == ns
        assert result.description == "simple_flow_description"
        assert result.revision == 1
        assert result.disabled is False
        assert result.deleted is False
        assert result.tasks is not None and len(result.tasks) > 0

    @pytest.mark.xfail(
        reason="kestra-ee 2.0 validates Schedule-trigger inputs more strictly and "
        "rejects the shared complete flow (422 / 'Missing inputs for Schedule "
        "Trigger'); the fixture flow predates the stricter 2.0 schema",
        strict=False,
    )
    def test_complete(self, client):
        body = complete_flow_body()
        result = client.flows.create_flow(TENANT, body)

        assert result.id is not None and result.id != ""
        assert result.namespace is not None and result.namespace != ""
        assert "markdown" in result.description
        assert result.labels is not None and len(result.labels) > 0
        assert result.inputs is not None and len(result.inputs) >= 3
        assert result.outputs is not None and len(result.outputs) > 0
        assert len(result.tasks) >= 3
        assert result.triggers is not None and len(result.triggers) > 0
        assert result.revision == 1


# ========================================================================
# CRUD -- flow (get)
# ========================================================================


class TestGetFlow:
    def test_basic(self, client):
        created = create_log_flow(client)

        result = client.flows.flow(created.namespace, created.id, TENANT)

        assert result.id == created.id
        assert result.namespace == created.namespace
        assert result.disabled is False
        assert result.deleted is False
        assert result.tasks is not None and len(result.tasks) > 0

    def test_with_source(self, client):
        created = create_log_flow(client)

        result = client.flows.flow(created.namespace, created.id, TENANT, source=True)

        assert result.source is not None and result.source != ""
        assert created.id in result.source

    def test_with_specific_revision(self, client):
        fid = random_id()
        ns = random_namespace()
        v1 = create_flow(client, log_flow_yaml_with_description(fid, ns, "version-one"))
        assert v1.revision == 1

        v2 = client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "version-two"))
        assert v2.revision == 2

        got_v1 = client.flows.flow(ns, fid, TENANT, revision=1)
        assert got_v1.revision == 1
        assert got_v1.description == "version-one"

        got_v2 = client.flows.flow(ns, fid, TENANT, revision=2)
        assert got_v2.revision == 2
        assert got_v2.description == "version-two"

    def test_allow_deleted(self, client):
        created = create_log_flow(client)
        client.flows.delete_flow(created.namespace, created.id, TENANT)
        time.sleep(0.2)

        result = client.flows.flow(created.namespace, created.id, TENANT, allow_deleted=True)
        assert result.id == created.id
        assert result.deleted is True

    def test_allow_deleted_false_raises(self, client):
        created = create_log_flow(client)
        client.flows.delete_flow(created.namespace, created.id, TENANT)
        time.sleep(0.2)

        with pytest.raises(ApiException):
            client.flows.flow(created.namespace, created.id, TENANT)

    def test_revision_and_allow_deleted(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml_with_description(fid, ns, "v1"))
        client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "v2"))
        client.flows.delete_flow(ns, fid, TENANT)
        time.sleep(0.2)

        v1 = client.flows.flow(ns, fid, TENANT, revision=1, allow_deleted=True)
        assert v1.revision == 1
        assert v1.description == "v1"
        assert v1.deleted is False

        v2 = client.flows.flow(ns, fid, TENANT, revision=2, allow_deleted=True)
        assert v2.revision == 2
        assert v2.description == "v2"

    def test_not_found(self, client):
        with pytest.raises(ApiException):
            client.flows.flow("nonexistent", "nonexistent", TENANT)


# ========================================================================
# CRUD -- updateFlow
# ========================================================================


class TestUpdateFlow:
    def test_change_description(self, client):
        fid = random_id()
        ns = random_namespace()
        created = create_flow(client, log_flow_yaml_with_description(fid, ns, "original"))

        updated = client.flows.update_flow(
            ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "updated-description")
        )

        assert updated.description == "updated-description"
        assert updated.revision == created.revision + 1

    def test_add_task(self, client):
        fid = random_id()
        ns = random_namespace()
        created = create_flow(client, log_flow_yaml(fid, ns))
        assert len(created.tasks) == 1

        updated = client.flows.update_flow(ns, fid, TENANT, two_task_flow_yaml(fid, ns))
        assert len(updated.tasks) == 2


# ========================================================================
# CRUD -- deleteFlow
# ========================================================================


class TestDeleteFlow:
    def test_basic(self, client):
        created = create_log_flow(client)

        client.flows.delete_flow(created.namespace, created.id, TENANT)
        time.sleep(0.2)

        with pytest.raises(ApiException):
            client.flows.flow(created.namespace, created.id, TENANT)

    def test_nonexistent(self, client):
        with pytest.raises(ApiException):
            client.flows.delete_flow("nonexistent", "nonexistent", TENANT)


# ========================================================================
# Bulk -- deleteFlowsByIds
# ========================================================================


class TestDeleteFlowsByIds:
    def test_single(self, client):
        f = create_log_flow(client)

        resp = client.flows.delete_flows_by_ids(
            TENANT, [IdWithNamespace(id=f.id, namespace=f.namespace)]
        )
        assert resp.count == 1

    def test_multiple(self, client):
        ns = random_namespace()
        f1 = create_flow(client, log_flow_yaml(random_id(), ns))
        f2 = create_flow(client, log_flow_yaml(random_id(), ns))
        f3 = create_flow(client, log_flow_yaml(random_id(), ns))

        resp = client.flows.delete_flows_by_ids(
            TENANT,
            [
                IdWithNamespace(id=f1.id, namespace=ns),
                IdWithNamespace(id=f2.id, namespace=ns),
                IdWithNamespace(id=f3.id, namespace=ns),
            ],
        )
        assert resp.count == 3


# ========================================================================
# Bulk -- deleteFlowsByQuery
# ========================================================================


class TestDeleteFlowsByQuery:
    def test_namespace_filter(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))
        create_flow(client, log_flow_yaml(random_id(), ns))

        resp = client.flows.delete_flows_by_query(TENANT, [ns_filter(ns)])
        assert resp.count == 2

    def test_flow_id_filter(self, client):
        ns = random_namespace()
        target = create_flow(client, log_flow_yaml(random_id(), ns))
        create_flow(client, log_flow_yaml(random_id(), ns))

        resp = client.flows.delete_flows_by_query(TENANT, [flow_id_filter(target.id)])
        assert resp.count == 1

        remaining = client.flows.list_flows_by_namespace(ns, TENANT)
        assert len(remaining) == 1
        assert remaining[0].id != target.id


# ========================================================================
# Bulk -- disable/enable by ids
# ========================================================================


class TestDisableEnableByIds:
    def test_disable_single(self, client):
        f = create_log_flow(client)

        resp = client.flows.disable_flows_by_ids(
            TENANT, [IdWithNamespace(id=f.id, namespace=f.namespace)]
        )
        assert resp.count == 1

        disabled = client.flows.flow(f.namespace, f.id, TENANT)
        assert disabled.disabled is True

    def test_disable_already_disabled(self, client):
        f = create_log_flow(client)
        id_ns = IdWithNamespace(id=f.id, namespace=f.namespace)

        resp1 = client.flows.disable_flows_by_ids(TENANT, [id_ns])
        assert resp1.count == 1

        resp2 = client.flows.disable_flows_by_ids(TENANT, [id_ns])
        assert resp2.count == 0

    def test_enable_after_disable(self, client):
        f = create_log_flow(client)
        id_ns = IdWithNamespace(id=f.id, namespace=f.namespace)

        client.flows.disable_flows_by_ids(TENANT, [id_ns])
        disabled = client.flows.flow(f.namespace, f.id, TENANT)
        assert disabled.disabled is True

        client.flows.enable_flows_by_ids(TENANT, [id_ns])
        enabled = client.flows.flow(f.namespace, f.id, TENANT)
        assert enabled.disabled is False


# ========================================================================
# Bulk -- disable/enable by query
# ========================================================================


class TestDisableEnableByQuery:
    def test_disable_namespace_filter(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))
        create_flow(client, log_flow_yaml(random_id(), ns))

        resp = client.flows.disable_flows_by_query(TENANT, [ns_filter(ns)])
        assert resp.count == 2

    def test_enable_after_disable(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))

        filters = [ns_filter(ns)]

        client.flows.disable_flows_by_query(TENANT, filters)
        resp = client.flows.enable_flows_by_query(TENANT, filters)
        assert resp.count == 1


# ========================================================================
# Bulk -- bulkUpdateFlows
# ========================================================================


class TestBulkUpdateFlows:
    def test_update_description(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml_with_description(fid, ns, "before"))

        result = client.flows.bulk_update_flows(
            TENANT, delete=False, body=log_flow_yaml_with_description(fid, ns, "after-bulk")
        )
        assert result is not None and len(result) > 0

    def test_delete_true_removes_stale_flows(self, client):
        ns = random_namespace()
        id1 = random_id()
        id2 = random_id()
        create_flow(client, log_flow_yaml(id1, ns))
        create_flow(client, log_flow_yaml(id2, ns))

        client.flows.bulk_update_flows(
            TENANT, delete=True, namespace=ns, allow_namespace_child=False,
            body=log_flow_yaml(id1, ns),
        )
        time.sleep(0.2)

        remaining = client.flows.list_flows_by_namespace(ns, TENANT)
        assert len(remaining) == 1
        assert remaining[0].id == id1

    def test_delete_false_keeps_stale_flows(self, client):
        ns = random_namespace()
        id1 = random_id()
        id2 = random_id()
        create_flow(client, log_flow_yaml(id1, ns))
        create_flow(client, log_flow_yaml(id2, ns))

        client.flows.bulk_update_flows(
            TENANT, delete=False, namespace=ns, allow_namespace_child=False,
            body=log_flow_yaml(id1, ns),
        )
        time.sleep(0.2)

        remaining = client.flows.list_flows_by_namespace(ns, TENANT)
        assert len(remaining) == 2

    def test_with_namespace_and_allow_child(self, client):
        ns = random_namespace()
        fid = random_id()
        create_flow(client, log_flow_yaml(fid, ns))

        result = client.flows.bulk_update_flows(
            TENANT, delete=False, namespace=ns, allow_namespace_child=True,
            body=log_flow_yaml_with_description(fid, ns, "updated via bulk with allowChild"),
        )
        assert result is not None and len(result) > 0


# ========================================================================
# Revisions -- listFlowRevisions
# ========================================================================


class TestListFlowRevisions:
    def test_multiple_revisions(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml_with_description(fid, ns, "v1"))
        client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "v2"))
        client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "v3"))

        revisions = client.flows.list_flow_revisions(ns, fid, TENANT)

        assert len(revisions) == 3
        assert revisions[0].revision == 1
        assert revisions[1].revision == 2
        assert revisions[2].revision == 3

    def test_allow_delete_true(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml(fid, ns))
        client.flows.delete_flow(ns, fid, TENANT)
        time.sleep(0.2)

        revisions = client.flows.list_flow_revisions(ns, fid, TENANT, allow_delete=True)
        assert len(revisions) > 0
        assert revisions[-1].deleted is True

    def test_allow_delete_false_excludes_deleted(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml(fid, ns))
        client.flows.delete_flow(ns, fid, TENANT)
        time.sleep(0.2)

        revisions = client.flows.list_flow_revisions(ns, fid, TENANT, allow_delete=False)
        for r in revisions:
            assert r.deleted is False


# ========================================================================
# Revisions -- deleteRevisions
# ========================================================================


class TestDeleteRevisions:
    def test_single(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml_with_description(fid, ns, "v1"))
        client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "v2"))
        client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "v3"))

        before = client.flows.list_flow_revisions(ns, fid, TENANT)
        assert len(before) == 3

        client.flows.delete_revisions(ns, fid, TENANT, [1])

        after = client.flows.list_flow_revisions(ns, fid, TENANT)
        assert len(after) == 2

    def test_multiple(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml_with_description(fid, ns, "v1"))
        client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "v2"))
        client.flows.update_flow(ns, fid, TENANT, log_flow_yaml_with_description(fid, ns, "v3"))

        client.flows.delete_revisions(ns, fid, TENANT, [1, 2])

        after = client.flows.list_flow_revisions(ns, fid, TENANT)
        assert len(after) == 1
        assert after[0].revision == 3


# ========================================================================
# Search -- searchFlows
# ========================================================================


class TestSearchFlows:
    def test_by_namespace(self, client):
        ns = random_namespace()
        f = create_flow(client, log_flow_yaml(random_id(), ns))

        result = client.flows.search_flows(TENANT, page=1, size=10, filters=[ns_filter(ns)])

        assert result.total == 1
        assert len(result.results) == 1
        assert result.results[0].id == f.id

    def test_by_flow_id(self, client):
        f = create_log_flow(client)

        result = client.flows.search_flows(TENANT, page=1, size=10, filters=[flow_id_filter(f.id)])

        assert result.total == 1
        assert result.results[0].namespace == f.namespace

    def test_by_query(self, client):
        ns = random_namespace()
        fid = random_id()
        create_flow(client, log_flow_yaml(fid, ns))

        result = client.flows.search_flows(
            TENANT, page=1, size=10, filters=[ns_filter(ns), query_filter(fid)]
        )
        assert result.total == 1

    def test_multiple_filters(self, client):
        ns = random_namespace()
        f = create_flow(client, log_flow_yaml(random_id(), ns))

        result = client.flows.search_flows(
            TENANT, page=1, size=10, filters=[ns_filter(ns), flow_id_filter(f.id)]
        )
        assert result.total == 1

    def test_pagination(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))
        create_flow(client, log_flow_yaml(random_id(), ns))
        create_flow(client, log_flow_yaml(random_id(), ns))

        filters = [ns_filter(ns)]

        page1 = client.flows.search_flows(TENANT, page=1, size=2, filters=filters)
        assert page1.total == 3
        assert len(page1.results) == 2

        page2 = client.flows.search_flows(TENANT, page=2, size=2, filters=filters)
        assert len(page2.results) == 1

    def test_sort_asc(self, client):
        ns = random_namespace()
        id1 = "aaa" + random_id()
        id2 = "zzz" + random_id()
        create_flow(client, log_flow_yaml(id2, ns))
        create_flow(client, log_flow_yaml(id1, ns))

        result = client.flows.search_flows(
            TENANT, page=1, size=10, sort=["id:asc"], filters=[ns_filter(ns)]
        )
        assert len(result.results) == 2
        assert result.results[0].id == id1
        assert result.results[1].id == id2

    def test_sort_desc(self, client):
        ns = random_namespace()
        id1 = "aaa" + random_id()
        id2 = "zzz" + random_id()
        create_flow(client, log_flow_yaml(id2, ns))
        create_flow(client, log_flow_yaml(id1, ns))

        result = client.flows.search_flows(
            TENANT, page=1, size=10, sort=["id:desc"], filters=[ns_filter(ns)]
        )
        assert len(result.results) == 2
        assert result.results[0].id == id2
        assert result.results[1].id == id1

    def test_no_results(self, client):
        result = client.flows.search_flows(
            TENANT, page=1, size=10, filters=[ns_filter("nonexistent_ns_" + random_id())]
        )
        assert result.total == 0
        assert len(result.results) == 0

    def test_with_labels(self, client):
        ns = random_namespace()
        fid = random_id()
        create_flow(client, log_flow_yaml_with_labels(fid, ns, {"team": "sdk", "env": "test"}))

        result = client.flows.search_flows(
            TENANT, page=1, size=10, filters=[ns_filter(ns), labels_filter({"team": "sdk"})]
        )
        assert result.total == 1
        assert result.results[0].id == fid

    def test_with_labels_no_match(self, client):
        ns = random_namespace()
        fid = random_id()
        create_flow(client, log_flow_yaml_with_labels(fid, ns, {"team": "sdk"}))

        result = client.flows.search_flows(
            TENANT, page=1, size=10, filters=[ns_filter(ns), labels_filter({"team": "other"})]
        )
        assert result.total == 0


# ========================================================================
# Search -- searchFlowsBySourceCode
# ========================================================================


class TestSearchFlowsBySourceCode:
    def test_by_flow_id(self, client):
        f = create_log_flow(client)

        result = client.flows.search_flows_by_source_code(TENANT, page=1, size=10, q=f.id)

        assert result.total >= 1
        assert any(r.model is not None and r.model.id == f.id for r in result.results)

    def test_with_namespace(self, client):
        ns = random_namespace()
        f = create_flow(client, log_flow_yaml(random_id(), ns))

        result = client.flows.search_flows_by_source_code(
            TENANT, page=1, size=10, q=f.id, namespace=ns
        )
        assert result.total >= 1

    def test_with_query_and_namespace(self, client):
        ns = random_namespace()
        id1 = random_id()
        id2 = random_id()
        create_flow(client, log_flow_yaml_with_description(id1, ns, "Hello World unique marker"))
        create_flow(client, log_flow_yaml_with_description(id2, ns, "Goodbye World different text"))

        result = client.flows.search_flows_by_source_code(
            TENANT, page=1, size=10, q="Hello World unique marker", namespace=ns
        )
        assert result.total >= 1
        for r in result.results:
            assert r.model is not None

    def test_with_sort(self, client):
        ns = random_namespace()
        id1 = "aaa" + random_id()
        id2 = "zzz" + random_id()
        create_flow(client, log_flow_yaml(id1, ns))
        create_flow(client, log_flow_yaml(id2, ns))

        result = client.flows.search_flows_by_source_code(
            TENANT, page=1, size=10, sort=["id:asc"], namespace=ns
        )
        assert len(result.results) >= 2
        ids = [r.model.id for r in result.results]
        idx1 = ids.index(id1)
        idx2 = ids.index(id2)
        assert idx1 >= 0
        assert idx2 > idx1

    def test_by_description(self, client):
        ns = random_namespace()
        unique_desc = "unique_" + random_id()
        create_flow(client, log_flow_yaml_with_description(random_id(), ns, unique_desc))

        result = client.flows.search_flows_by_source_code(TENANT, page=1, size=10, q=unique_desc)
        assert result.total >= 1


# ========================================================================
# List -- listFlowsByNamespace
# ========================================================================


class TestListFlowsByNamespace:
    def test_single(self, client):
        ns = random_namespace()
        f = create_flow(client, log_flow_yaml(random_id(), ns))

        result = client.flows.list_flows_by_namespace(ns, TENANT)

        assert len(result) == 1
        assert result[0].id == f.id

    def test_multiple(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))
        create_flow(client, log_flow_yaml(random_id(), ns))
        create_flow(client, log_flow_yaml(random_id(), ns))

        result = client.flows.list_flows_by_namespace(ns, TENANT)
        assert len(result) == 3

    def test_empty(self, client):
        result = client.flows.list_flows_by_namespace("empty_ns_" + random_id(), TENANT)
        assert len(result) == 0


# ========================================================================
# List -- listDistinctNamespaces
# ========================================================================


class TestListDistinctNamespaces:
    def test_contains_created(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))

        namespaces = client.flows.list_distinct_namespaces(TENANT)
        assert ns in namespaces

    def test_with_q_filter(self, client):
        prefix = "filtertest" + random_id()[:8]
        ns = prefix + "sub"
        create_flow(client, log_flow_yaml(random_id(), ns))

        namespaces = client.flows.list_distinct_namespaces(TENANT, q=prefix)
        assert ns in namespaces
        assert all(n.startswith(prefix) for n in namespaces)


# ========================================================================
# Namespace operations -- updateFlowsInNamespace
# ========================================================================


class TestUpdateFlowsInNamespace:
    def test_basic(self, client):
        ns = random_namespace()
        fid = random_id()

        result = client.flows.update_flows_in_namespace(ns, TENANT, log_flow_yaml(fid, ns), delete=False, override=False)
        assert result is not None and len(result) > 0

    def test_delete_true(self, client):
        ns = random_namespace()
        id1 = random_id()
        id2 = random_id()
        create_flow(client, log_flow_yaml(id1, ns))
        create_flow(client, log_flow_yaml(id2, ns))

        client.flows.update_flows_in_namespace(ns, TENANT, log_flow_yaml(id1, ns), delete=True, override=False)
        time.sleep(0.2)

        remaining = client.flows.list_flows_by_namespace(ns, TENANT)
        assert len(remaining) == 1
        assert remaining[0].id == id1

    def test_delete_false(self, client):
        ns = random_namespace()
        id1 = random_id()
        id2 = random_id()
        create_flow(client, log_flow_yaml(id1, ns))
        create_flow(client, log_flow_yaml(id2, ns))

        client.flows.update_flows_in_namespace(ns, TENANT, log_flow_yaml(id1, ns), delete=False, override=False)
        time.sleep(0.2)

        remaining = client.flows.list_flows_by_namespace(ns, TENANT)
        assert len(remaining) == 2

    def test_override_true(self, client):
        target_ns = random_namespace()
        fid = random_id()

        result = client.flows.update_flows_in_namespace(
            target_ns, TENANT, log_flow_yaml(fid, target_ns), delete=False, override=True
        )
        assert result is not None and len(result) > 0

        flows = client.flows.list_flows_by_namespace(target_ns, TENANT)
        assert any(f.id == fid for f in flows)


# ========================================================================
# Export & Import
# ========================================================================


class TestExportImport:
    def test_export_by_ids_single(self, client):
        f = create_log_flow(client)

        zip_bytes = client.flows.export_flows_by_ids(
            TENANT, [IdWithNamespace(id=f.id, namespace=f.namespace)]
        )
        assert zip_bytes is not None and len(zip_bytes) > 10

    def test_export_by_ids_multiple(self, client):
        ns = random_namespace()
        f1 = create_flow(client, log_flow_yaml(random_id(), ns))
        f2 = create_flow(client, log_flow_yaml(random_id(), ns))

        single_zip = client.flows.export_flows_by_ids(
            TENANT, [IdWithNamespace(id=f1.id, namespace=ns)]
        )
        double_zip = client.flows.export_flows_by_ids(
            TENANT,
            [
                IdWithNamespace(id=f1.id, namespace=ns),
                IdWithNamespace(id=f2.id, namespace=ns),
            ],
        )
        assert len(double_zip) > len(single_zip)

    def test_export_by_query_namespace_filter(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))

        zip_bytes = client.flows.export_flows_by_query(TENANT, [ns_filter(ns)])
        assert zip_bytes is not None and len(zip_bytes) > 0

    def test_import_yaml_file(self, client):
        id1 = random_id()
        id2 = random_id()
        ns = random_namespace()
        yaml = log_flow_yaml(id1, ns) + "\n---\n" + log_flow_yaml(id2, ns)

        result = client.flows.import_flows(TENANT, fail_on_error=False, file_content=yaml.encode("utf-8"))
        assert result is not None

        time.sleep(0.2)
        flows = client.flows.list_flows_by_namespace(ns, TENANT)
        assert len(flows) >= 2

    def test_import_export_then_reimport(self, client):
        ns = random_namespace()
        f = create_flow(client, log_flow_yaml(random_id(), ns))

        zip_bytes = client.flows.export_flows_by_ids(
            TENANT, [IdWithNamespace(id=f.id, namespace=ns)]
        )

        client.flows.delete_flow(ns, f.id, TENANT)
        time.sleep(0.2)

        result = client.flows.import_flows(TENANT, fail_on_error=False, file_content=zip_bytes)
        assert result is not None

        time.sleep(0.2)
        reimported = client.flows.flow(ns, f.id, TENANT)
        assert reimported.id == f.id


# ========================================================================
# Graph & Dependencies
# ========================================================================


class TestFlowGraph:
    def test_basic(self, client):
        f = create_log_flow(client)

        graph = client.flows.generate_flow_graph(f.namespace, f.id, TENANT)

        assert graph is not None
        assert graph.nodes is not None and len(graph.nodes) > 0
        assert graph.edges is not None and len(graph.edges) > 0

    def test_with_revision(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml(fid, ns))
        client.flows.update_flow(ns, fid, TENANT, two_task_flow_yaml(fid, ns))

        graph_v1 = client.flows.generate_flow_graph(ns, fid, TENANT, revision=1)
        graph_v2 = client.flows.generate_flow_graph(ns, fid, TENANT, revision=2)

        assert graph_v1.nodes is not None
        assert graph_v2.nodes is not None
        assert len(graph_v2.nodes) > len(graph_v1.nodes)

    @pytest.mark.xfail(
        reason="kestra-ee 2.0 validates Schedule-trigger inputs more strictly and "
        "rejects the shared complete flow (422); the fixture flow predates the "
        "stricter 2.0 schema",
        strict=False,
    )
    def test_complex_flow(self, client):
        body = complete_flow_body()
        f = create_flow(client, body)

        graph = client.flows.generate_flow_graph(f.namespace, f.id, TENANT)

        assert len(graph.nodes) >= 3
        assert len(graph.edges) > 0

    def test_from_source(self, client):
        fid = random_id()
        ns = random_namespace()
        yaml = log_flow_yaml(fid, ns)

        graph = client.flows.generate_flow_graph_from_source(TENANT, yaml)

        assert graph is not None
        assert graph.nodes is not None and len(graph.nodes) > 0
        assert graph.edges is not None and len(graph.edges) > 0

    def test_with_subflows(self, client):
        f = create_log_flow(client)

        graph = client.flows.generate_flow_graph(
            f.namespace, f.id, TENANT, subflows=["some.subflow.id"],
        )

        # The flow has no subflows; the parameter is accepted but doesn't
        # change the output for this fixture. We assert the call succeeds.
        assert graph is not None

    def test_from_source_with_subflows(self, client):
        fid = random_id()
        ns = random_namespace()
        yaml = log_flow_yaml(fid, ns)

        graph = client.flows.generate_flow_graph_from_source(
            TENANT, yaml, subflows=["some.subflow.id"],
        )

        assert graph is not None


class TestFlowDependencies:
    def test_basic(self, client):
        f = create_log_flow(client)

        deps = client.flows.flow_dependencies(f.namespace, f.id, TENANT)

        assert deps is not None
        assert deps.nodes is not None

    def test_destination_only(self, client):
        f = create_log_flow(client)

        deps = client.flows.flow_dependencies(f.namespace, f.id, TENANT, destination_only=True)

        assert deps is not None
        assert deps.nodes is not None

    def test_expand_all(self, client):
        f = create_log_flow(client)

        deps = client.flows.flow_dependencies(f.namespace, f.id, TENANT, expand_all=True)

        assert deps is not None
        assert deps.nodes is not None

    def test_from_namespace(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))

        deps = client.flows.flow_dependencies_from_namespace(ns, TENANT)

        assert deps is not None
        assert deps.nodes is not None

    def test_from_namespace_destination_only(self, client):
        ns = random_namespace()
        create_flow(client, log_flow_yaml(random_id(), ns))

        deps = client.flows.flow_dependencies_from_namespace(ns, TENANT, destination_only=True)

        assert deps is not None


# ========================================================================
# Tasks
# ========================================================================


class TestTaskFromFlow:
    def test_basic(self, client):
        f = create_log_flow(client)

        task = client.flows.task_from_flow(f.namespace, f.id, "hello", TENANT)

        assert task is not None
        assert task.id == "hello"
        assert task.type == "io.kestra.plugin.core.log.Log"

    def test_with_revision(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml(fid, ns))

        task = client.flows.task_from_flow(ns, fid, "hello", TENANT, revision=1)

        assert task is not None
        assert task.id == "hello"

    def test_not_found(self, client):
        f = create_log_flow(client)
        with pytest.raises(ApiException):
            client.flows.task_from_flow(f.namespace, f.id, "nonexistent_task", TENANT)

    def test_revision_with_different_tasks(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, log_flow_yaml(fid, ns))
        client.flows.update_flow(ns, fid, TENANT, two_task_flow_yaml(fid, ns))

        v1_task = client.flows.task_from_flow(ns, fid, "hello", TENANT, revision=1)
        assert v1_task.id == "hello"

        with pytest.raises(ApiException):
            client.flows.task_from_flow(ns, fid, "goodbye", TENANT, revision=1)

        v2_task = client.flows.task_from_flow(ns, fid, "goodbye", TENANT, revision=2)
        assert v2_task.id == "goodbye"

    def test_specific_task_in_two_task_flow(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, two_task_flow_yaml(fid, ns))

        task1 = client.flows.task_from_flow(ns, fid, "hello", TENANT)
        assert task1.id == "hello"

        task2 = client.flows.task_from_flow(ns, fid, "goodbye", TENANT)
        assert task2.id == "goodbye"
        assert task2.type == "io.kestra.plugin.core.log.Log"


# ========================================================================
# Concurrency
# ========================================================================


class TestConcurrency:
    def test_search_concurrency_limits(self, client):
        result = client.flows.search_concurrency_limits(TENANT)

        assert result is not None
        assert result.results is not None

    @pytest.mark.skip(reason="Concurrency limit PUT returns 404 on this kestra-ee image")
    def test_update_concurrency_limit_set(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, concurrency_flow_yaml(fid, ns, 1))

        limit = ConcurrencyLimit(tenant_id=TENANT, namespace=ns, flow_id=fid, running=5)

        result = client.flows.update_concurrency_limit(ns, fid, TENANT, limit)

        assert result is not None
        assert result.namespace == ns
        assert result.flow_id == fid

    @pytest.mark.skip(reason="Concurrency limit PUT returns 404 on this kestra-ee image")
    def test_update_concurrency_limit_update(self, client):
        fid = random_id()
        ns = random_namespace()
        create_flow(client, concurrency_flow_yaml(fid, ns, 3))

        limit = ConcurrencyLimit(tenant_id=TENANT, namespace=ns, flow_id=fid, running=10)
        result = client.flows.update_concurrency_limit(ns, fid, TENANT, limit)

        assert result is not None
        assert result.flow_id == fid


# ========================================================================
# Validation
# ========================================================================


class TestValidation:
    def test_validate_flows_valid(self, client):
        yaml = log_flow_yaml(random_id(), random_id())

        result = client.flows.validate_flows(TENANT, yaml)

        assert result is not None and len(result) == 1
        assert result[0].constraints is None or len(result[0].constraints) == 0

    @pytest.mark.xfail(
        reason="kestra-ee 2.0 validates Schedule-trigger inputs more strictly, so "
        "the shared complete flow now reports validation errors instead of "
        "validating clean; the fixture flow predates the stricter 2.0 schema",
        strict=False,
    )
    def test_validate_flows_complete(self, client):
        yaml = complete_flow_body()

        result = client.flows.validate_flows(TENANT, yaml)

        assert result is not None and len(result) == 1
        assert result[0].constraints is None or len(result[0].constraints) == 0

    def test_validate_flows_invalid_task_type(self, client):
        yaml = invalid_task_flow_yaml(random_id(), random_id())

        result = client.flows.validate_flows(TENANT, yaml)

        assert result is not None and len(result) > 0
        assert result[0].constraints is not None and len(result[0].constraints) > 0

    def test_validate_flows_multiple(self, client):
        valid_yaml = log_flow_yaml(random_id(), random_id())
        invalid_yaml = invalid_task_flow_yaml(random_id(), random_id())

        result = client.flows.validate_flows(TENANT, valid_yaml + "\n---\n" + invalid_yaml)

        assert len(result) == 2

    def test_validate_task_valid(self, client):
        task_dict = {
            "id": "test_log",
            "type": "io.kestra.plugin.core.log.Log",
            "message": "Hello",
        }

        result = client.flows.validate_task(FlowControllerTaskValidationType.TASKS, TENANT, task_dict)

        assert result is not None
        assert result.constraints is None or len(result.constraints) == 0

    def test_validate_task_invalid_type(self, client):
        task_dict = {
            "id": "bad_task",
            "type": "io.kestra.plugin.nonexistent.BadTask",
        }

        result = client.flows.validate_task(FlowControllerTaskValidationType.TASKS, TENANT, task_dict)

        assert result is not None
        assert result.constraints is not None and len(result.constraints) > 0

    def test_validate_trigger_valid(self, client):
        trigger_dict = {
            "id": "test_schedule",
            "type": "io.kestra.plugin.core.trigger.Schedule",
            "cron": "0 9 * * *",
        }

        result = client.flows.validate_trigger(TENANT, trigger_dict)

        assert result is not None
        assert result.constraints is None or len(result.constraints) == 0

    def test_validate_trigger_invalid_type(self, client):
        trigger_dict = {
            "id": "bad_trigger",
            "type": "io.kestra.plugin.nonexistent.BadTrigger",
        }

        result = client.flows.validate_trigger(TENANT, trigger_dict)

        assert result is not None
        assert result.constraints is not None and len(result.constraints) > 0


# ========================================================================
# Expressions
# ========================================================================


class TestExpressions:
    def test_basic(self, client):
        f = create_log_flow(client)
        with_source = client.flows.flow(f.namespace, f.id, TENANT, source=True)

        result = client.flows.expressions(TENANT, with_source.source)

        assert result is not None

    def test_with_task_id(self, client):
        f = create_log_flow(client)
        with_source = client.flows.flow(f.namespace, f.id, TENANT, source=True)

        result = client.flows.expressions(TENANT, with_source.source, task_id="hello")

        assert result is not None


# ========================================================================
# Deprecated
# ========================================================================


class TestListDeprecated:
    def test_basic(self, client):
        result = client.flows.list_deprecated(TENANT)

        assert result is not None

    def test_with_namespace(self, client):
        result = client.flows.list_deprecated(TENANT, namespace="some.namespace")

        assert result is not None


# ========================================================================
# 404 / 409 edge cases
# ========================================================================


class TestErrorPaths:
    @pytest.mark.skip(
        reason="Flaky in full suite due to Kestra IO-pool/H2 contention from accumulated state; "
               "passes in isolation. Re-enable once suite has per-test cleanup or Kestra is investigated."
    )
    def test_update_flow_unknown_id_raises(self, client):
        ns = random_namespace()
        flow_id = random_id()
        yaml_body = log_flow_yaml(flow_id, ns)
        with pytest.raises(ApiException) as exc_info:
            client.flows.update_flow(ns, flow_id, TENANT, yaml_body)
        # 404 if the controller checks existence first, 422 if it tries
        # to apply and the (namespace, id) doesn't match an existing flow.
        assert exc_info.value.status in (400, 404, 422)

    @pytest.mark.timeout(60)
    def test_create_flow_duplicate_conflicts(self, client):
        ns = random_namespace()
        flow_id = random_id()
        yaml_body = log_flow_yaml(flow_id, ns)
        client.flows.create_flow(TENANT, yaml_body)

        with pytest.raises(ApiException) as exc_info:
            client.flows.create_flow(TENANT, yaml_body)
        assert exc_info.value.status in (409, 422)
