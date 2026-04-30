package io.kestra.sdk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlowsApiTest {

    static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static FlowsApi api() {
        return client().flows();
    }

    // ========================================================================
    // CRUD — createFlow
    // ========================================================================

    @Test
    void createFlow_simple() throws ApiException {
        FlowFixture f = simpleFlowFixture();
        FlowWithSource result = api().createFlow(TENANT, f.body());

        assertThat(result.getId()).isEqualTo(f.id());
        assertThat(result.getNamespace()).isEqualTo(f.namespace());
        assertThat(result.getDescription()).isEqualTo("simple_flow_description");
        assertThat(result.getRevision()).isEqualTo(1);
        assertThat(result.getDisabled()).isFalse();
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getTasks()).isNotEmpty();
    }

    @Test
    void createFlow_complete() throws ApiException {
        String body = completeFlowBody();
        FlowWithSource result = api().createFlow(TENANT, body);

        assertThat(result.getId()).isNotBlank();
        assertThat(result.getNamespace()).isNotBlank();
        assertThat(result.getDescription()).contains("markdown");
        assertThat(result.getLabels()).isNotNull().isNotEmpty();
        assertThat(result.getInputs()).isNotNull().hasSizeGreaterThanOrEqualTo(3);
        assertThat(result.getOutputs()).isNotNull().isNotEmpty();
        assertThat(result.getTasks()).hasSizeGreaterThanOrEqualTo(3);
        assertThat(result.getTriggers()).isNotNull().isNotEmpty();
        assertThat(result.getRevision()).isEqualTo(1);
    }

    // ========================================================================
    // CRUD — flow (get)
    // ========================================================================

    @Test
    void flow_basic() throws ApiException {
        FlowWithSource created = createLogFlow();

        FlowWithSource result = api().flow(created.getNamespace(), created.getId(), TENANT, null, null, null);

        assertThat(result.getId()).isEqualTo(created.getId());
        assertThat(result.getNamespace()).isEqualTo(created.getNamespace());
        assertThat(result.getDisabled()).isFalse();
        assertThat(result.getDeleted()).isFalse();
        assertThat(result.getTasks()).isNotEmpty();
    }

    @Test
    void flow_withSource() throws ApiException {
        FlowWithSource created = createLogFlow();

        FlowWithSource result = api().flow(created.getNamespace(), created.getId(), TENANT, true, null, null);

        assertThat(result.getSource()).isNotBlank();
        assertThat(result.getSource()).contains(created.getId());
    }

    @Test
    void flow_withSpecificRevision() throws ApiException {
        String id = randomId();
        String ns = randomId();
        FlowWithSource v1 = createFlow(logFlowYamlWithDescription(id, ns, "version-one"));
        assertThat(v1.getRevision()).isEqualTo(1);

        FlowWithSource v2 = api().updateFlow(ns, id, TENANT,
                logFlowYamlWithDescription(id, ns, "version-two"));
        assertThat(v2.getRevision()).isEqualTo(2);

        FlowWithSource gotV1 = api().flow(ns, id, TENANT, null, 1, null);
        assertThat(gotV1.getRevision()).isEqualTo(1);
        assertThat(gotV1.getDescription()).isEqualTo("version-one");

        FlowWithSource gotV2 = api().flow(ns, id, TENANT, null, 2, null);
        assertThat(gotV2.getRevision()).isEqualTo(2);
        assertThat(gotV2.getDescription()).isEqualTo("version-two");
    }

    @Test
    void flow_allowDeleted() throws ApiException {
        FlowWithSource created = createLogFlow();
        api().deleteFlow(created.getNamespace(), created.getId(), TENANT);
        sleep(200);

        FlowWithSource result = api().flow(created.getNamespace(), created.getId(), TENANT, null, null, true);
        assertThat(result.getId()).isEqualTo(created.getId());
        assertThat(result.getDeleted()).isTrue();
    }

    @Test
    void flow_allowDeletedFalse_throws() throws ApiException {
        FlowWithSource created = createLogFlow();
        api().deleteFlow(created.getNamespace(), created.getId(), TENANT);
        sleep(200);

        assertThatThrownBy(() -> api().flow(created.getNamespace(), created.getId(), TENANT, null, null, null))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void flow_revisionAndAllowDeleted() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYamlWithDescription(id, ns, "v1"));
        api().updateFlow(ns, id, TENANT, logFlowYamlWithDescription(id, ns, "v2"));
        api().deleteFlow(ns, id, TENANT);
        sleep(200);

        FlowWithSource v1 = api().flow(ns, id, TENANT, null, 1, true);
        assertThat(v1.getRevision()).isEqualTo(1);
        assertThat(v1.getDescription()).isEqualTo("v1");
        assertThat(v1.getDeleted()).isFalse();

        FlowWithSource v2 = api().flow(ns, id, TENANT, null, 2, true);
        assertThat(v2.getRevision()).isEqualTo(2);
        assertThat(v2.getDescription()).isEqualTo("v2");
    }

    @Test
    void flow_notFound() {
        assertThatThrownBy(() -> api().flow("nonexistent", "nonexistent", TENANT, null, null, null))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // CRUD — updateFlow
    // ========================================================================

    @Test
    void updateFlow_changeDescription() throws ApiException {
        String id = randomId();
        String ns = randomId();
        FlowWithSource created = createFlow(logFlowYamlWithDescription(id, ns, "original"));

        FlowWithSource updated = api().updateFlow(ns, id, TENANT,
                logFlowYamlWithDescription(id, ns, "updated-description"));

        assertThat(updated.getDescription()).isEqualTo("updated-description");
        assertThat(updated.getRevision()).isEqualTo(created.getRevision() + 1);
    }

    @Test
    void updateFlow_addTask() throws ApiException {
        String id = randomId();
        String ns = randomId();
        FlowWithSource created = createFlow(logFlowYaml(id, ns));
        assertThat(created.getTasks()).hasSize(1);

        FlowWithSource updated = api().updateFlow(ns, id, TENANT, twoTaskFlowYaml(id, ns));
        assertThat(updated.getTasks()).hasSize(2);
    }

    // ========================================================================
    // CRUD — deleteFlow
    // ========================================================================

    @Test
    void deleteFlow_basic() throws ApiException {
        FlowWithSource created = createLogFlow();

        api().deleteFlow(created.getNamespace(), created.getId(), TENANT);
        sleep(200);

        assertThatThrownBy(() -> api().flow(created.getNamespace(), created.getId(), TENANT, null, null, null))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void deleteFlow_nonexistent() {
        assertThatThrownBy(() -> api().deleteFlow("nonexistent", "nonexistent", TENANT))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // Bulk — deleteFlowsByIds
    // ========================================================================

    @Test
    void deleteFlowsByIds_single() throws ApiException {
        FlowWithSource f = createLogFlow();

        BulkResponse resp = api().deleteFlowsByIds(TENANT,
                List.of(new IdWithNamespace().id(f.getId()).namespace(f.getNamespace())));

        assertThat(resp.getCount()).isEqualTo(1);
    }

    @Test
    void deleteFlowsByIds_multiple() throws ApiException {
        String ns = randomId();
        FlowWithSource f1 = createFlow(logFlowYaml(randomId(), ns));
        FlowWithSource f2 = createFlow(logFlowYaml(randomId(), ns));
        FlowWithSource f3 = createFlow(logFlowYaml(randomId(), ns));

        BulkResponse resp = api().deleteFlowsByIds(TENANT, List.of(
                new IdWithNamespace().id(f1.getId()).namespace(ns),
                new IdWithNamespace().id(f2.getId()).namespace(ns),
                new IdWithNamespace().id(f3.getId()).namespace(ns)));

        assertThat(resp.getCount()).isEqualTo(3);
    }

    // ========================================================================
    // Bulk — deleteFlowsByQuery
    // ========================================================================

    @Test
    void deleteFlowsByQuery_namespaceFilter() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));
        createFlow(logFlowYaml(randomId(), ns));

        BulkResponse resp = api().deleteFlowsByQuery(TENANT, List.of(nsFilter(ns)));

        assertThat(resp.getCount()).isEqualTo(2);
    }

    @Test
    void deleteFlowsByQuery_flowIdFilter() throws ApiException {
        String ns = randomId();
        FlowWithSource target = createFlow(logFlowYaml(randomId(), ns));
        createFlow(logFlowYaml(randomId(), ns));

        BulkResponse resp = api().deleteFlowsByQuery(TENANT, List.of(
                new QueryFilter()
                        .field(QueryFilterField.FLOW_ID)
                        .operation(QueryFilterOp.EQUALS)
                        .value(target.getId())));

        assertThat(resp.getCount()).isEqualTo(1);
        List<Flow> remaining = api().listFlowsByNamespace(ns, TENANT);
        assertThat(remaining).hasSize(1);
        assertThat(remaining.get(0).getId()).isNotEqualTo(target.getId());
    }

    // ========================================================================
    // Bulk — disable/enable by ids
    // ========================================================================

    @Test
    void disableFlowsByIds_single() throws ApiException {
        FlowWithSource f = createLogFlow();

        BulkResponse resp = api().disableFlowsByIds(TENANT,
                List.of(new IdWithNamespace().id(f.getId()).namespace(f.getNamespace())));
        assertThat(resp.getCount()).isEqualTo(1);

        FlowWithSource disabled = api().flow(f.getNamespace(), f.getId(), TENANT, null, null, null);
        assertThat(disabled.getDisabled()).isTrue();
    }

    @Test
    void disableFlowsByIds_alreadyDisabled() throws ApiException {
        FlowWithSource f = createLogFlow();
        IdWithNamespace idNs = new IdWithNamespace().id(f.getId()).namespace(f.getNamespace());

        BulkResponse resp1 = api().disableFlowsByIds(TENANT, List.of(idNs));
        assertThat(resp1.getCount()).isEqualTo(1);

        BulkResponse resp2 = api().disableFlowsByIds(TENANT, List.of(idNs));
        assertThat(resp2.getCount()).isEqualTo(0);
    }

    @Test
    void enableFlowsByIds_afterDisable() throws ApiException {
        FlowWithSource f = createLogFlow();
        IdWithNamespace idNs = new IdWithNamespace().id(f.getId()).namespace(f.getNamespace());

        api().disableFlowsByIds(TENANT, List.of(idNs));
        FlowWithSource disabled = api().flow(f.getNamespace(), f.getId(), TENANT, null, null, null);
        assertThat(disabled.getDisabled()).isTrue();

        api().enableFlowsByIds(TENANT, List.of(idNs));
        FlowWithSource enabled = api().flow(f.getNamespace(), f.getId(), TENANT, null, null, null);
        assertThat(enabled.getDisabled()).isFalse();
    }

    // ========================================================================
    // Bulk — disable/enable by query
    // ========================================================================

    @Test
    void disableFlowsByQuery_namespaceFilter() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));
        createFlow(logFlowYaml(randomId(), ns));

        BulkResponse resp = api().disableFlowsByQuery(TENANT, List.of(nsFilter(ns)));
        assertThat(resp.getCount()).isEqualTo(2);
    }

    @Test
    void enableFlowsByQuery_afterDisable() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        List<QueryFilter> filters = List.of(nsFilter(ns));

        api().disableFlowsByQuery(TENANT, filters);
        BulkResponse resp = api().enableFlowsByQuery(TENANT, filters);
        assertThat(resp.getCount()).isEqualTo(1);
    }

    // ========================================================================
    // Bulk — bulkUpdateFlows
    // ========================================================================

    @Test
    void bulkUpdateFlows_updateDescription() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYamlWithDescription(id, ns, "before"));

        List<FlowInterface> result = api().bulkUpdateFlows(TENANT, false, null, null,
                logFlowYamlWithDescription(id, ns, "after-bulk"));

        assertThat(result).isNotEmpty();
    }

    @Test
    void bulkUpdateFlows_deleteTrue_removesStaleFlows() throws ApiException {
        String ns = randomId();
        String id1 = randomId();
        String id2 = randomId();
        createFlow(logFlowYaml(id1, ns));
        createFlow(logFlowYaml(id2, ns));

        api().bulkUpdateFlows(TENANT, true, ns, false, logFlowYaml(id1, ns));
        sleep(200);

        List<Flow> remaining = api().listFlowsByNamespace(ns, TENANT);
        assertThat(remaining).hasSize(1);
        assertThat(remaining.get(0).getId()).isEqualTo(id1);
    }

    @Test
    void bulkUpdateFlows_deleteFalse_keepsStaleFlows() throws ApiException {
        String ns = randomId();
        String id1 = randomId();
        String id2 = randomId();
        createFlow(logFlowYaml(id1, ns));
        createFlow(logFlowYaml(id2, ns));

        api().bulkUpdateFlows(TENANT, false, ns, false, logFlowYaml(id1, ns));
        sleep(200);

        List<Flow> remaining = api().listFlowsByNamespace(ns, TENANT);
        assertThat(remaining).hasSize(2);
    }

    @Test
    void bulkUpdateFlows_withNamespaceAndAllowChild() throws ApiException {
        String ns = randomId();
        String id = randomId();
        createFlow(logFlowYaml(id, ns));

        List<FlowInterface> result = api().bulkUpdateFlows(TENANT, false, ns, true,
                logFlowYamlWithDescription(id, ns, "updated via bulk with allowChild"));

        assertThat(result).isNotEmpty();
    }

    // ========================================================================
    // Revisions — deleteRevisions
    // ========================================================================

    @Test
    void deleteRevisions_single() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYamlWithDescription(id, ns, "v1"));
        api().updateFlow(ns, id, TENANT, logFlowYamlWithDescription(id, ns, "v2"));
        api().updateFlow(ns, id, TENANT, logFlowYamlWithDescription(id, ns, "v3"));

        List<FlowWithSource> before = api().listFlowRevisions(ns, id, TENANT, null);
        assertThat(before).hasSize(3);

        api().deleteRevisions(ns, id, TENANT, List.of(1));

        List<FlowWithSource> after = api().listFlowRevisions(ns, id, TENANT, null);
        assertThat(after).hasSize(2);
    }

    @Test
    void deleteRevisions_multiple() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYamlWithDescription(id, ns, "v1"));
        api().updateFlow(ns, id, TENANT, logFlowYamlWithDescription(id, ns, "v2"));
        api().updateFlow(ns, id, TENANT, logFlowYamlWithDescription(id, ns, "v3"));

        api().deleteRevisions(ns, id, TENANT, List.of(1, 2));

        List<FlowWithSource> after = api().listFlowRevisions(ns, id, TENANT, null);
        assertThat(after).hasSize(1);
        assertThat(after.get(0).getRevision()).isEqualTo(3);
    }

    // ========================================================================
    // Search — searchFlows
    // ========================================================================

    @Test
    void searchFlows_byNamespace() throws ApiException {
        String ns = randomId();
        FlowWithSource f = createFlow(logFlowYaml(randomId(), ns));

        PagedResultsFlow result = api().searchFlows(TENANT, 1, 10, null, List.of(nsFilter(ns)));

        assertThat(result.getTotal()).isEqualTo(1);
        assertThat(result.getResults()).hasSize(1);
        assertThat(result.getResults().get(0).getId()).isEqualTo(f.getId());
    }

    @Test
    void searchFlows_byFlowId() throws ApiException {
        FlowWithSource f = createLogFlow();

        PagedResultsFlow result = api().searchFlows(TENANT, 1, 10, null,
                List.of(new QueryFilter()
                        .field(QueryFilterField.FLOW_ID)
                        .operation(QueryFilterOp.EQUALS)
                        .value(f.getId())));

        assertThat(result.getTotal()).isEqualTo(1);
        assertThat(result.getResults().get(0).getNamespace()).isEqualTo(f.getNamespace());
    }

    @Test
    void searchFlows_byQuery() throws ApiException {
        String ns = randomId();
        String id = randomId();
        createFlow(logFlowYaml(id, ns));

        PagedResultsFlow result = api().searchFlows(TENANT, 1, 10, null,
                List.of(nsFilter(ns),
                        new QueryFilter()
                                .field(QueryFilterField.QUERY)
                                .operation(QueryFilterOp.EQUALS)
                                .value(id)));

        assertThat(result.getTotal()).isEqualTo(1);
    }

    @Test
    void searchFlows_multipleFilters() throws ApiException {
        String ns = randomId();
        FlowWithSource f = createFlow(logFlowYaml(randomId(), ns));

        PagedResultsFlow result = api().searchFlows(TENANT, 1, 10, null,
                List.of(nsFilter(ns),
                        new QueryFilter()
                                .field(QueryFilterField.FLOW_ID)
                                .operation(QueryFilterOp.EQUALS)
                                .value(f.getId())));

        assertThat(result.getTotal()).isEqualTo(1);
    }

    @Test
    void searchFlows_pagination() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));
        createFlow(logFlowYaml(randomId(), ns));
        createFlow(logFlowYaml(randomId(), ns));

        List<QueryFilter> filters = List.of(nsFilter(ns));

        PagedResultsFlow page1 = api().searchFlows(TENANT, 1, 2, null, filters);
        assertThat(page1.getTotal()).isEqualTo(3);
        assertThat(page1.getResults()).hasSize(2);

        PagedResultsFlow page2 = api().searchFlows(TENANT, 2, 2, null, filters);
        assertThat(page2.getResults()).hasSize(1);
    }

    @Test
    void searchFlows_sortAsc() throws ApiException {
        String ns = randomId();
        String id1 = "aaa" + randomId();
        String id2 = "zzz" + randomId();
        createFlow(logFlowYaml(id2, ns));
        createFlow(logFlowYaml(id1, ns));

        PagedResultsFlow result = api().searchFlows(TENANT, 1, 10, List.of("id:asc"), List.of(nsFilter(ns)));
        assertThat(result.getResults()).hasSize(2);
        assertThat(result.getResults().get(0).getId()).isEqualTo(id1);
        assertThat(result.getResults().get(1).getId()).isEqualTo(id2);
    }

    @Test
    void searchFlows_sortDesc() throws ApiException {
        String ns = randomId();
        String id1 = "aaa" + randomId();
        String id2 = "zzz" + randomId();
        createFlow(logFlowYaml(id2, ns));
        createFlow(logFlowYaml(id1, ns));

        PagedResultsFlow result = api().searchFlows(TENANT, 1, 10, List.of("id:desc"), List.of(nsFilter(ns)));
        assertThat(result.getResults()).hasSize(2);
        assertThat(result.getResults().get(0).getId()).isEqualTo(id2);
        assertThat(result.getResults().get(1).getId()).isEqualTo(id1);
    }

    @Test
    void searchFlows_noResults() throws ApiException {
        PagedResultsFlow result = api().searchFlows(TENANT, 1, 10, null,
                List.of(nsFilter("nonexistent_ns_" + randomId())));

        assertThat(result.getTotal()).isEqualTo(0);
        assertThat(result.getResults()).isEmpty();
    }

    // ========================================================================
    // Search — searchFlowsBySourceCode
    // ========================================================================

    @Test
    void searchFlowsBySourceCode_byFlowId() throws ApiException {
        FlowWithSource f = createLogFlow();

        PagedResultsSearchResultFlow result = api().searchFlowsBySourceCode(
                TENANT, 1, 10, null, f.getId(), null);

        assertThat(result.getTotal()).isGreaterThanOrEqualTo(1);
        assertThat(result.getResults()).anyMatch(r -> r.getModel() != null && f.getId().equals(r.getModel().getId()));
    }

    @Test
    void searchFlowsBySourceCode_withNamespace() throws ApiException {
        String ns = randomId();
        FlowWithSource f = createFlow(logFlowYaml(randomId(), ns));

        PagedResultsSearchResultFlow result = api().searchFlowsBySourceCode(
                TENANT, 1, 10, null, f.getId(), ns);

        assertThat(result.getTotal()).isGreaterThanOrEqualTo(1);
    }

    @Test
    void searchFlowsBySourceCode_byDescription() throws ApiException {
        String ns = randomId();
        String uniqueDesc = "unique_" + randomId();
        createFlow(logFlowYamlWithDescription(randomId(), ns, uniqueDesc));

        PagedResultsSearchResultFlow result = api().searchFlowsBySourceCode(
                TENANT, 1, 10, null, uniqueDesc, null);

        assertThat(result.getTotal()).isGreaterThanOrEqualTo(1);
    }

    // ========================================================================
    // List — listFlowsByNamespace
    // ========================================================================

    @Test
    void listFlowsByNamespace_single() throws ApiException {
        String ns = randomId();
        FlowWithSource f = createFlow(logFlowYaml(randomId(), ns));

        List<Flow> result = api().listFlowsByNamespace(ns, TENANT);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(f.getId());
    }

    @Test
    void listFlowsByNamespace_multiple() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));
        createFlow(logFlowYaml(randomId(), ns));
        createFlow(logFlowYaml(randomId(), ns));

        List<Flow> result = api().listFlowsByNamespace(ns, TENANT);
        assertThat(result).hasSize(3);
    }

    @Test
    void listFlowsByNamespace_empty() throws ApiException {
        List<Flow> result = api().listFlowsByNamespace("empty_ns_" + randomId(), TENANT);
        assertThat(result).isEmpty();
    }

    // ========================================================================
    // List — listDistinctNamespaces
    // ========================================================================

    @Test
    void listDistinctNamespaces_containsCreated() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        List<String> namespaces = api().listDistinctNamespaces(TENANT, null);

        assertThat(namespaces).contains(ns);
    }

    @Test
    void listDistinctNamespaces_withQFilter() throws ApiException {
        String prefix = "filtertest" + randomId().substring(0, 8);
        String ns = prefix + "sub";
        createFlow(logFlowYaml(randomId(), ns));

        List<String> namespaces = api().listDistinctNamespaces(TENANT, prefix);

        assertThat(namespaces).contains(ns);
        assertThat(namespaces).allMatch(n -> n.startsWith(prefix));
    }

    // ========================================================================
    // Revisions — listFlowRevisions
    // ========================================================================

    @Test
    void listFlowRevisions_multipleRevisions() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYamlWithDescription(id, ns, "v1"));
        api().updateFlow(ns, id, TENANT, logFlowYamlWithDescription(id, ns, "v2"));
        api().updateFlow(ns, id, TENANT, logFlowYamlWithDescription(id, ns, "v3"));

        List<FlowWithSource> revisions = api().listFlowRevisions(ns, id, TENANT, null);

        assertThat(revisions).hasSize(3);
        assertThat(revisions.get(0).getRevision()).isEqualTo(1);
        assertThat(revisions.get(1).getRevision()).isEqualTo(2);
        assertThat(revisions.get(2).getRevision()).isEqualTo(3);
    }

    @Test
    void listFlowRevisions_allowDeleteTrue() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYaml(id, ns));
        api().deleteFlow(ns, id, TENANT);
        sleep(200);

        List<FlowWithSource> revisions = api().listFlowRevisions(ns, id, TENANT, true);
        assertThat(revisions).isNotEmpty();
        assertThat(revisions.get(revisions.size() - 1).getDeleted()).isTrue();
    }

    @Test
    void listFlowRevisions_allowDeleteFalse_excludesDeleted() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYaml(id, ns));
        api().deleteFlow(ns, id, TENANT);
        sleep(200);

        List<FlowWithSource> revisions = api().listFlowRevisions(ns, id, TENANT, false);
        assertThat(revisions).allSatisfy(r -> assertThat(r.getDeleted()).isFalse());
    }

    // ========================================================================
    // Namespace operations — updateFlowsInNamespace
    // ========================================================================

    @Test
    void updateFlowsInNamespace_basic() throws ApiException {
        String ns = randomId();
        String id = randomId();

        List<FlowInterface> result = api().updateFlowsInNamespace(ns, TENANT,
                logFlowYaml(id, ns), false, false);

        assertThat(result).isNotEmpty();
    }

    @Test
    void updateFlowsInNamespace_deleteTrue() throws ApiException {
        String ns = randomId();
        String id1 = randomId();
        String id2 = randomId();
        createFlow(logFlowYaml(id1, ns));
        createFlow(logFlowYaml(id2, ns));

        api().updateFlowsInNamespace(ns, TENANT, logFlowYaml(id1, ns), true, false);
        sleep(200);

        List<Flow> remaining = api().listFlowsByNamespace(ns, TENANT);
        assertThat(remaining).hasSize(1);
        assertThat(remaining.get(0).getId()).isEqualTo(id1);
    }

    @Test
    void updateFlowsInNamespace_deleteFalse() throws ApiException {
        String ns = randomId();
        String id1 = randomId();
        String id2 = randomId();
        createFlow(logFlowYaml(id1, ns));
        createFlow(logFlowYaml(id2, ns));

        api().updateFlowsInNamespace(ns, TENANT, logFlowYaml(id1, ns), false, false);
        sleep(200);

        List<Flow> remaining = api().listFlowsByNamespace(ns, TENANT);
        assertThat(remaining).hasSize(2);
    }

    @Test
    void updateFlowsInNamespace_overrideTrue() throws ApiException {
        String targetNs = randomId();
        String id = randomId();

        List<FlowInterface> result = api().updateFlowsInNamespace(targetNs, TENANT,
                logFlowYaml(id, targetNs), false, true);

        assertThat(result).isNotEmpty();
        List<Flow> flows = api().listFlowsByNamespace(targetNs, TENANT);
        assertThat(flows).anyMatch(f -> f.getId().equals(id));
    }

    // ========================================================================
    // Export & Import
    // ========================================================================

    @Test
    void exportFlowsByIds_single() throws ApiException {
        FlowWithSource f = createLogFlow();

        byte[] zip = api().exportFlowsByIds(TENANT,
                List.of(new IdWithNamespace().id(f.getId()).namespace(f.getNamespace())));

        assertThat(zip).isNotEmpty();
        assertThat(zip.length).isGreaterThan(10);
    }

    @Test
    void exportFlowsByIds_multiple() throws ApiException {
        String ns = randomId();
        FlowWithSource f1 = createFlow(logFlowYaml(randomId(), ns));
        FlowWithSource f2 = createFlow(logFlowYaml(randomId(), ns));

        byte[] singleZip = api().exportFlowsByIds(TENANT,
                List.of(new IdWithNamespace().id(f1.getId()).namespace(ns)));
        byte[] doubleZip = api().exportFlowsByIds(TENANT,
                List.of(new IdWithNamespace().id(f1.getId()).namespace(ns),
                        new IdWithNamespace().id(f2.getId()).namespace(ns)));

        assertThat(doubleZip.length).isGreaterThan(singleZip.length);
    }

    @Test
    void exportFlowsByQuery_namespaceFilter() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        byte[] zip = api().exportFlowsByQuery(TENANT, List.of(nsFilter(ns)));

        assertThat(zip).isNotEmpty();
    }

    @Test
    void importFlows_yamlFile() throws ApiException, IOException {
        String id1 = randomId();
        String id2 = randomId();
        String ns = randomId();
        String yaml = logFlowYaml(id1, ns) + "\n---\n" + logFlowYaml(id2, ns);

        Path tempFile = Files.createTempFile("flows-import", ".yml");
        Files.writeString(tempFile, yaml);

        try {
            List<String> result = api().importFlows(TENANT, false, tempFile.toFile());
            assertThat(result).isNotNull();

            sleep(200);
            List<Flow> flows = api().listFlowsByNamespace(ns, TENANT);
            assertThat(flows).hasSizeGreaterThanOrEqualTo(2);
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    void importFlows_exportThenReimport() throws ApiException, IOException {
        String ns = randomId();
        FlowWithSource f = createFlow(logFlowYaml(randomId(), ns));

        byte[] zipBytes = api().exportFlowsByIds(TENANT,
                List.of(new IdWithNamespace().id(f.getId()).namespace(ns)));

        api().deleteFlow(ns, f.getId(), TENANT);
        sleep(200);

        Path tempZip = Files.createTempFile("flows-reimport", ".zip");
        Files.write(tempZip, zipBytes);

        try {
            List<String> result = api().importFlows(TENANT, false, tempZip.toFile());
            assertThat(result).isNotNull();

            sleep(200);
            FlowWithSource reimported = api().flow(ns, f.getId(), TENANT, null, null, null);
            assertThat(reimported.getId()).isEqualTo(f.getId());
        } finally {
            Files.deleteIfExists(tempZip);
        }
    }

    // ========================================================================
    // Graph & Dependencies
    // ========================================================================

    @Test
    void generateFlowGraph_basic() throws ApiException {
        FlowWithSource f = createLogFlow();

        FlowGraph graph = api().generateFlowGraph(f.getNamespace(), f.getId(), TENANT, null, null);

        assertThat(graph).isNotNull();
        assertThat(graph.getNodes()).isNotNull().isNotEmpty();
        assertThat(graph.getEdges()).isNotNull().isNotEmpty();
    }

    @Test
    void generateFlowGraph_withRevision() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYaml(id, ns));
        api().updateFlow(ns, id, TENANT, twoTaskFlowYaml(id, ns));

        FlowGraph graphV1 = api().generateFlowGraph(ns, id, TENANT, 1, null);
        FlowGraph graphV2 = api().generateFlowGraph(ns, id, TENANT, 2, null);

        assertThat(graphV1.getNodes()).isNotNull();
        assertThat(graphV2.getNodes()).isNotNull();
        assertThat(graphV2.getNodes().size()).isGreaterThan(graphV1.getNodes().size());
    }

    @Test
    void generateFlowGraph_complexFlow() throws ApiException {
        String body = completeFlowBody();
        FlowWithSource f = createFlow(body);

        FlowGraph graph = api().generateFlowGraph(f.getNamespace(), f.getId(), TENANT, null, null);

        assertThat(graph.getNodes().size()).isGreaterThanOrEqualTo(3);
        assertThat(graph.getEdges()).isNotEmpty();
    }

    @Test
    void generateFlowGraphFromSource_basic() throws ApiException {
        String id = randomId();
        String ns = randomId();
        String yaml = logFlowYaml(id, ns);

        FlowGraph graph = api().generateFlowGraphFromSource(TENANT, yaml, null);

        assertThat(graph).isNotNull();
        assertThat(graph.getNodes()).isNotNull().isNotEmpty();
        assertThat(graph.getEdges()).isNotNull().isNotEmpty();
    }

    @Test
    void flowDependencies_basic() throws ApiException {
        FlowWithSource f = createLogFlow();

        FlowTopologyGraph deps = api().flowDependencies(f.getNamespace(), f.getId(), TENANT, null, null);

        assertThat(deps).isNotNull();
        assertThat(deps.getNodes()).isNotNull();
    }

    @Test
    void flowDependencies_destinationOnly() throws ApiException {
        FlowWithSource f = createLogFlow();

        FlowTopologyGraph deps = api().flowDependencies(f.getNamespace(), f.getId(), TENANT, true, null);

        assertThat(deps).isNotNull();
        assertThat(deps.getNodes()).isNotNull();
    }

    @Test
    void flowDependencies_expandAll() throws ApiException {
        FlowWithSource f = createLogFlow();

        FlowTopologyGraph deps = api().flowDependencies(f.getNamespace(), f.getId(), TENANT, null, true);

        assertThat(deps).isNotNull();
        assertThat(deps.getNodes()).isNotNull();
    }

    @Test
    void flowDependenciesFromNamespace_basic() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        FlowTopologyGraph deps = api().flowDependenciesFromNamespace(ns, TENANT, null);

        assertThat(deps).isNotNull();
        assertThat(deps.getNodes()).isNotNull();
    }

    @Test
    void flowDependenciesFromNamespace_destinationOnly() throws ApiException {
        String ns = randomId();
        createFlow(logFlowYaml(randomId(), ns));

        FlowTopologyGraph deps = api().flowDependenciesFromNamespace(ns, TENANT, true);

        assertThat(deps).isNotNull();
    }

    // ========================================================================
    // Tasks
    // ========================================================================

    @Test
    void taskFromFlow_basic() throws ApiException {
        FlowWithSource f = createLogFlow();

        Task task = api().taskFromFlow(f.getNamespace(), f.getId(), "hello", TENANT, null);

        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualTo("hello");
        assertThat(task.getType()).isEqualTo("io.kestra.plugin.core.log.Log");
    }

    @Test
    void taskFromFlow_withRevision() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYaml(id, ns));

        Task task = api().taskFromFlow(ns, id, "hello", TENANT, 1);

        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualTo("hello");
    }

    @Test
    void taskFromFlow_notFound() {
        FlowWithSource f;
        try {
            f = createLogFlow();
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        assertThatThrownBy(() -> api().taskFromFlow(f.getNamespace(), f.getId(), "nonexistent_task", TENANT, null))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void taskFromFlow_revisionWithDifferentTasks() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(logFlowYaml(id, ns));
        api().updateFlow(ns, id, TENANT, twoTaskFlowYaml(id, ns));

        Task v1Task = api().taskFromFlow(ns, id, "hello", TENANT, 1);
        assertThat(v1Task.getId()).isEqualTo("hello");

        assertThatThrownBy(() -> api().taskFromFlow(ns, id, "goodbye", TENANT, 1))
                .isInstanceOf(ApiException.class);

        Task v2Task = api().taskFromFlow(ns, id, "goodbye", TENANT, 2);
        assertThat(v2Task.getId()).isEqualTo("goodbye");
    }

    @Test
    void taskFromFlow_specificTaskInTwoTaskFlow() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(twoTaskFlowYaml(id, ns));

        Task task1 = api().taskFromFlow(ns, id, "hello", TENANT, null);
        assertThat(task1.getId()).isEqualTo("hello");

        Task task2 = api().taskFromFlow(ns, id, "goodbye", TENANT, null);
        assertThat(task2.getId()).isEqualTo("goodbye");
        assertThat(task2.getType()).isEqualTo("io.kestra.plugin.core.log.Log");
    }

    // ========================================================================
    // Concurrency
    // ========================================================================

    @Test
    void searchConcurrencyLimits_basic() throws ApiException {
        PagedResultsConcurrencyLimit result = api().searchConcurrencyLimits(TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    @Disabled("Concurrency limit PUT returns 404 on this kestra-ee image — may require specific EE feature/plugin")
    void updateConcurrencyLimit_set() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(concurrencyFlowYaml(id, ns, 1));

        ConcurrencyLimit limit = new ConcurrencyLimit()
                .tenantId(TENANT)
                .namespace(ns)
                .flowId(id)
                .running(5);

        ConcurrencyLimit result = api().updateConcurrencyLimit(ns, id, TENANT, limit);

        assertThat(result).isNotNull();
        assertThat(result.getNamespace()).isEqualTo(ns);
        assertThat(result.getFlowId()).isEqualTo(id);
    }

    @Test
    @Disabled("Concurrency limit PUT returns 404 on this kestra-ee image — may require specific EE feature/plugin")
    void updateConcurrencyLimit_update() throws ApiException {
        String id = randomId();
        String ns = randomId();
        createFlow(concurrencyFlowYaml(id, ns, 3));

        ConcurrencyLimit limit = new ConcurrencyLimit()
                .tenantId(TENANT).namespace(ns).flowId(id).running(10);
        ConcurrencyLimit result = api().updateConcurrencyLimit(ns, id, TENANT, limit);

        assertThat(result).isNotNull();
        assertThat(result.getFlowId()).isEqualTo(id);
    }

    // ========================================================================
    // Validation
    // ========================================================================

    @Test
    void validateFlows_valid() throws ApiException {
        String yaml = logFlowYaml(randomId(), randomId());

        List<ValidateConstraintViolation> result = api().validateFlows(TENANT, yaml);

        assertThat(result).isNotNull().hasSize(1);
        assertThat(result.get(0).getConstraints()).isNullOrEmpty();
    }

    @Test
    void validateFlows_completeFlow() throws ApiException {
        String yaml = completeFlowBody();

        List<ValidateConstraintViolation> result = api().validateFlows(TENANT, yaml);

        assertThat(result).isNotNull().hasSize(1);
        assertThat(result.get(0).getConstraints()).isNullOrEmpty();
    }

    @Test
    void validateFlows_invalidTaskType() throws ApiException {
        String yaml = invalidTaskFlowYaml(randomId(), randomId());

        List<ValidateConstraintViolation> result = api().validateFlows(TENANT, yaml);

        assertThat(result).isNotNull().isNotEmpty();
        assertThat(result.get(0).getConstraints()).isNotEmpty();
    }

    @Test
    void validateFlows_multipleFlows() throws ApiException {
        String validYaml = logFlowYaml(randomId(), randomId());
        String invalidYaml = invalidTaskFlowYaml(randomId(), randomId());

        List<ValidateConstraintViolation> result = api().validateFlows(TENANT,
                validYaml + "\n---\n" + invalidYaml);

        assertThat(result).hasSize(2);
    }

    @Test
    void validateTask_valid() throws ApiException, JsonProcessingException {
        String taskJson = """
                {
                  "id": "test_log",
                  "type": "io.kestra.plugin.core.log.Log",
                  "message": "Hello"
                }
                """;

        ValidateConstraintViolation result = api().validateTask(
                FlowControllerTaskValidationType.TASKS, TENANT, OBJECT_MAPPER.readValue(taskJson, Object.class));

        assertThat(result).isNotNull();
        assertThat(result.getConstraints()).isNullOrEmpty();
    }

    @Test
    void validateTask_invalidType() throws ApiException, JsonProcessingException {
        String taskJson = """
                {
                  "id": "bad_task",
                  "type": "io.kestra.plugin.nonexistent.BadTask"
                }
                """;

        ValidateConstraintViolation result = api().validateTask(
                FlowControllerTaskValidationType.TASKS, TENANT, OBJECT_MAPPER.readValue(taskJson, Object.class));

        assertThat(result).isNotNull();
        assertThat(result.getConstraints()).isNotEmpty();
    }

    @Test
    void validateTrigger_valid() throws ApiException, JsonProcessingException {
        String triggerJson = """
                {
                  "id": "test_schedule",
                  "type": "io.kestra.plugin.core.trigger.Schedule",
                  "cron": "0 9 * * *"
                }
                """;

        ValidateConstraintViolation result = api().validateTrigger(
                TENANT, OBJECT_MAPPER.readValue(triggerJson, Object.class));

        assertThat(result).isNotNull();
        assertThat(result.getConstraints()).isNullOrEmpty();
    }

    @Test
    void validateTrigger_invalidType() throws ApiException, JsonProcessingException {
        String triggerJson = """
                {
                  "id": "bad_trigger",
                  "type": "io.kestra.plugin.nonexistent.BadTrigger"
                }
                """;

        ValidateConstraintViolation result = api().validateTrigger(
                TENANT, OBJECT_MAPPER.readValue(triggerJson, Object.class));

        assertThat(result).isNotNull();
        assertThat(result.getConstraints()).isNotEmpty();
    }

    // ========================================================================
    // Expressions
    // ========================================================================

    @Test
    void expressions_basic() throws ApiException {
        FlowWithSource f = createLogFlow();
        FlowWithSource withSource = api().flow(f.getNamespace(), f.getId(), TENANT, true, null, null);

        ExpressionContext result = api().expressions(TENANT, withSource.getSource(), null);

        assertThat(result).isNotNull();
    }

    @Test
    void expressions_withTaskId() throws ApiException {
        FlowWithSource f = createLogFlow();
        FlowWithSource withSource = api().flow(f.getNamespace(), f.getId(), TENANT, true, null, null);

        ExpressionContext result = api().expressions(TENANT, withSource.getSource(), "hello");

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Deprecated
    // ========================================================================

    @Test
    void listDeprecated_basic() throws ApiException {
        List<FlowControllerFlowWithDeprecatedTasks> result = api().listDeprecated(TENANT, null);

        assertThat(result).isNotNull();
    }

    @Test
    void listDeprecated_withNamespace() throws ApiException {
        List<FlowControllerFlowWithDeprecatedTasks> result = api().listDeprecated(TENANT, "some.namespace");

        assertThat(result).isNotNull();
    }
}
