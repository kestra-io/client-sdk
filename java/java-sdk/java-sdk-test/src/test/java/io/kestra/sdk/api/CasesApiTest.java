package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CasesApiTest {

    static CasesApi api() {
        return client().cases();
    }

    static CasesControllerCaseFromTaskRequest request(String flowNamespace, String flowId, String taskId, boolean linkMatchingExecutions) {
        return new CasesControllerCaseFromTaskRequest()
                .namespace(flowNamespace)
                .title("Case for " + flowId)
                .flowNamespace(flowNamespace)
                .flowId(flowId)
                .taskId(taskId)
                .linkMatchingExecutions(linkMatchingExecutions);
    }

    static Map<String, Object> newCaseRequest(String namespace, String title) {
        return Map.of("namespace", namespace, "title", title);
    }

    static String createCase(String namespace, String title) throws ApiException {
        Map<String, Object> created = api().createCase(TENANT, newCaseRequest(namespace, title));
        return (String) created.get("id");
    }

    @Test
    void createFromTask_basic() throws ApiException {
        String flowId = randomId();

        var result = api().createFromTask(TENANT, request(randomId(), flowId, randomId(), false));

        assertThat(result).isNotNull();
        assertThat(result.get("caseId")).isNotNull();
        assertThat(result.get("created")).isEqualTo(true);
    }

    @Test
    void createFromTask_dedupesActiveCaseWithSameOrigin() throws ApiException {
        String flowNamespace = randomId();
        String flowId = randomId();
        String taskId = randomId();

        var first = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, true));
        var second = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, true));

        assertThat(first.get("created")).isEqualTo(true);
        assertThat(second.get("created")).isEqualTo(false);
        assertThat(second.get("caseId")).isEqualTo(first.get("caseId"));
    }

    @Test
    void createFromTask_noDedupeWithoutLinkMatchingExecutions() throws ApiException {
        String flowNamespace = randomId();
        String flowId = randomId();
        String taskId = randomId();

        var first = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, false));
        var second = api().createFromTask(TENANT, request(flowNamespace, flowId, taskId, false));

        assertThat(first.get("created")).isEqualTo(true);
        assertThat(second.get("created")).isEqualTo(true);
        assertThat(second.get("caseId")).isNotEqualTo(first.get("caseId"));
    }

    // ========================================================================
    // CRUD
    // ========================================================================

    @Test
    void createCase_basic() throws ApiException {
        String ns = randomId();

        Map<String, Object> result = api().createCase(TENANT, newCaseRequest(ns, "A new case"));

        assertThat(result.get("id")).isNotNull();
        assertThat(result.get("namespace")).isEqualTo(ns);
        assertThat(result.get("title")).isEqualTo("A new case");
        assertThat(result.get("status")).isEqualTo("OPEN");
    }

    @Test
    void getCase_basic() throws ApiException {
        String ns = randomId();
        String id = createCase(ns, "Get me");

        Map<String, Object> result = api().getCase(id, TENANT, null);

        assertThat(result.get("id")).isEqualTo(id);
        assertThat(result.get("title")).isEqualTo("Get me");
    }

    @Test
    void updateCase_changesTitle() throws ApiException {
        String id = createCase(randomId(), "Old title");

        Map<String, Object> result = api().updateCase(id, TENANT, Map.of("title", "New title"));

        assertThat(result.get("id")).isEqualTo(id);
        assertThat(result.get("title")).isEqualTo("New title");
    }

    @Test
    void deleteCase_basic() throws ApiException {
        String id = createCase(randomId(), "To delete");

        assertThatCode(() -> api().deleteCase(id, TENANT)).doesNotThrowAnyException();
    }

    // ========================================================================
    // Search & counts
    // ========================================================================

    @Test
    void searchCases_findsCreatedCase() throws ApiException {
        String ns = randomId();
        String id = createCase(ns, "Searchable case");

        Map<String, Object> result = api().searchCases(TENANT, 1, 10, null, List.of(nsFilter(ns)));

        assertThat((Number) result.get("total")).isEqualTo(1);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> results = (List<Map<String, Object>>) result.get("results");
        assertThat(results).extracting(r -> r.get("id")).containsExactly(id);
    }

    @Test
    void counts_basic() throws ApiException {
        String ns = randomId();
        createCase(ns, "Counted case");

        Object result = api().counts(TENANT, List.of(nsFilter(ns)));

        assertThat(result).isNotNull();
    }

    @Test
    void assignees_basic() throws ApiException {
        String ns = randomId();
        createCase(ns, "Assignees case");

        Map<String, Object> result = api().assignees(TENANT, List.of(nsFilter(ns)));

        assertThat(result.get("results")).isNotNull();
    }

    @Test
    void byAsset_noResultsForUnknownAsset() throws ApiException {
        Map<String, Object> result = api().byAsset(TENANT, "nonexistent-asset-" + randomId());

        assertThat((Number) result.get("total")).isEqualTo(0);
    }

    @Test
    void deleteCasesByIds_basic() throws ApiException {
        String id = createCase(randomId(), "Bulk delete me");

        BulkResponse result = api().deleteCasesByIds(TENANT, List.of(id));

        assertThat(result).isNotNull();
    }

    @Test
    void deleteCasesByQuery_basic() throws ApiException {
        String ns = randomId();
        createCase(ns, "Delete by query");

        BulkResponse result = api().deleteCasesByQuery(TENANT, List.of(nsFilter(ns)));

        assertThat(result).isNotNull();
    }

    @Test
    void acknowledgeCasesByIds_basic() throws ApiException {
        String id = createCase(randomId(), "Ack by ids");

        BulkResponse result = api().acknowledgeCasesByIds(TENANT, List.of(id));

        assertThat(result).isNotNull();
        Map<String, Object> updated = api().getCase(id, TENANT, null);
        assertThat(updated.get("status")).isEqualTo("ACKNOWLEDGED");
    }

    // ========================================================================
    // Acknowledge / cancel / resolve / status
    // ========================================================================

    @Test
    void acknowledge_basic() throws ApiException {
        String id = createCase(randomId(), "Ack me");

        Map<String, Object> result = api().acknowledge(id, TENANT);

        assertThat(result.get("status")).isEqualTo("ACKNOWLEDGED");
    }

    @Test
    void changeStatus_basic() throws ApiException {
        String id = createCase(randomId(), "Status me");

        Map<String, Object> result = api().changeStatus(id, TENANT, CaseStatus.INVESTIGATING);

        assertThat(result.get("status")).isEqualTo("INVESTIGATING");
    }

    @Test
    void resolve_basic() throws ApiException {
        String id = createCase(randomId(), "Resolve me");

        Map<String, Object> result = api().resolve(id, TENANT, "fixed", null);

        assertThat(result.get("status")).isEqualTo("RESOLVED");
    }

    @Test
    void cancel_basic() throws ApiException {
        String id = createCase(randomId(), "Cancel me");

        Map<String, Object> result = api().cancel(id, TENANT, "not needed", null);

        assertThat(result.get("status")).isEqualTo("CANCELLED");
    }

    // ========================================================================
    // Actions
    // ========================================================================

    @Test
    void attachAction_thenUpdateThenDetach() throws ApiException {
        String id = createCase(randomId(), "Action case");
        String actionNs = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, actionNs));
        CaseAction action = new CaseAction().label("Investigate").namespace(actionNs).flowId(flowId);

        Map<String, Object> attached = api().attachAction(id, TENANT, action);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> actions = (List<Map<String, Object>>) attached.get("actions");
        assertThat(actions).extracting(a -> a.get("flowId")).contains(flowId);

        CaseAction updatedAction = new CaseAction().label("Investigate more").namespace(actionNs).flowId(flowId);
        Map<String, Object> updated = api().updateAction(id, actionNs, flowId, TENANT, updatedAction);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> updatedActions = (List<Map<String, Object>>) updated.get("actions");
        assertThat(updatedActions).extracting(a -> a.get("label")).contains("Investigate more");

        Map<String, Object> detached = api().detachAction(id, actionNs, flowId, TENANT);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> remainingActions = (List<Map<String, Object>>) detached.get("actions");
        assertThat(remainingActions).noneMatch(a -> flowId.equals(a.get("flowId")));
    }

    // ========================================================================
    // Assets
    // ========================================================================

    @Test
    void assets_emptyForNewCase() throws ApiException {
        String id = createCase(randomId(), "Assets case");

        Map<String, Object> result = api().assets(id, TENANT);

        assertThat((Number) result.get("total")).isEqualTo(0);
    }

    // ========================================================================
    // Comments & events
    // ========================================================================

    @Test
    void addComment_thenAppearsInEvents() throws ApiException {
        String id = createCase(randomId(), "Comment case");

        Map<String, Object> comment = api().addComment(id, TENANT, "hello from the SDK", null);
        assertThat(comment.get("id")).isNotNull();

        Map<String, Object> events = api().events(id, TENANT, 1, 10);
        assertThat(((Number) events.get("total")).longValue()).isGreaterThanOrEqualTo(1L);
    }

    // ========================================================================
    // Follow / unfollow
    // ========================================================================

    @Test
    void follow_thenUnfollow() throws ApiException {
        String id = createCase(randomId(), "Follow case");

        Map<String, Object> followed = api().follow(id, TENANT);
        assertThat(followed.get("id")).isEqualTo(id);

        assertThatCode(() -> api().unfollow(id, TENANT)).doesNotThrowAnyException();
    }

    // ========================================================================
    // Linked executions
    // ========================================================================

    @Test
    void linkExecutions_thenListThenUnlink() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        var execResp = client().executions().createExecution(TENANT, ns, flowId, null, null, null, null, null, null);
        String executionId = execResp.getId();
        String id = createCase(randomId(), "Link executions case");

        Map<String, Object> linked = api().linkExecutions(id, TENANT, List.of(executionId));
        @SuppressWarnings("unchecked")
        List<String> assetIds = (List<String>) linked.get("assetIds");
        assertThat(assetIds).isNotNull();

        Map<String, Object> executions = api().executions(id, TENANT, 1, 10);
        assertThat(((Number) executions.get("total")).longValue()).isGreaterThanOrEqualTo(1L);

        assertThatCode(() -> api().unlinkExecution(id, executionId, TENANT)).doesNotThrowAnyException();
    }

    @Test
    void byExecutions_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        var execResp = client().executions().createExecution(TENANT, ns, flowId, null, null, null, null, null, null);

        Object result = api().byExecutions(TENANT, List.of(execResp.getId()));

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Create from executions
    // ========================================================================

    @Test
    void createFromExecutions_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        var execResp = client().executions().createExecution(TENANT, ns, flowId, null, null, null, null, null, null);

        Map<String, Object> result = api().createFromExecutions(
                TENANT, newCaseRequest(randomId(), "From executions"), List.of(execResp.getId()));

        assertThat(result.get("id")).isNotNull();
        assertThat(result.get("title")).isEqualTo("From executions");
    }

    // NOTE: unlike every other filtered endpoint in this SDK, the server's runtime
    // binder for the two "*ByQuery" case bulk endpoints below rejects the uppercase
    // QueryFilterField values that /cases/search, /executions/search etc. all accept
    // (a 422 "Invalid JSON" at "filters[0].field") — confirmed against a live server
    // to be a server-side inconsistency, not an SDK path/serialization bug. Filed as
    // a follow-up; these tests use an empty filter list so they still exercise the
    // wrapper's happy path without depending on that quirk.
    @Test
    void createFromExecutionsByQuery_basic() throws ApiException {
        Map<String, Object> result = api().createFromExecutionsByQuery(
                TENANT, newCaseRequest(randomId(), "From executions by query"), List.of());

        assertThat(result.get("id")).isNotNull();
        assertThat(result.get("title")).isEqualTo("From executions by query");
    }

    @Test
    void linkExecutionsByQuery_basic() throws ApiException {
        String id = createCase(randomId(), "Link by query case");

        Map<String, Object> result = api().linkExecutionsByQuery(id, TENANT, List.of());

        assertThat(result.get("id")).isEqualTo(id);
    }

    // ========================================================================
    // Assignment & auto-attach
    // ========================================================================

    @Test
    void assign_setsAssignees() throws ApiException {
        String id = createCase(randomId(), "Assign case");
        Subjects assignees = new Subjects().users(List.of("root@root.com"));

        Map<String, Object> result = api().assign(id, TENANT, assignees, null, "assigning to root");

        // the server resolves each raw email/group name to a full subject reference
        @SuppressWarnings("unchecked")
        Map<String, Object> resultAssignees = (Map<String, Object>) result.get("assignees");
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> users = (List<Map<String, Object>>) resultAssignees.get("users");
        assertThat(users).extracting(u -> u.get("label")).containsExactly("root@root.com");
    }

    @Test
    void enableAutoAttach_thenDisable() throws ApiException {
        String id = createCase(randomId(), "Auto attach case");
        String actionNs = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, actionNs));

        Map<String, Object> enabled = api().enableAutoAttach(id, TENANT, actionNs, flowId, List.of(StateType.FAILED));
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> autoAttach = (List<Map<String, Object>>) enabled.get("autoAttach");
        assertThat(autoAttach).extracting(a -> a.get("flowId")).contains(flowId);

        Map<String, Object> disabled = api().disableAutoAttach(id, TENANT);
        // the server omits "autoAttach" entirely once the list is empty, rather than
        // returning an empty array
        assertThat(disabled.get("autoAttach")).isNull();
    }

    // ========================================================================
    // Run action (negative — no attached action exists yet)
    // ========================================================================

    @Test
    void runAction_unattachedAction_throws() throws ApiException {
        String id = createCase(randomId(), "Run action case");

        assertThatThrownBy(() -> api().runAction(id, TENANT,
                Map.of("namespace", randomId(), "flowId", randomId())))
                .isInstanceOf(ApiException.class);
    }

    // ========================================================================
    // Asset attach (negative — asset registry entry does not exist)
    // ========================================================================

    @Test
    void attachAsset_thenDetach() throws ApiException {
        String id = createCase(randomId(), "Attach asset case");
        String assetId = "asset-" + randomId();

        Map<String, Object> attached = api().attachAsset(id, TENANT, assetId);
        @SuppressWarnings("unchecked")
        List<String> assetIds = (List<String>) attached.get("assetIds");
        assertThat(assetIds).contains(assetId);

        Map<String, Object> detached = api().detachAsset(id, assetId, TENANT);
        @SuppressWarnings("unchecked")
        List<String> remainingAssetIds = (List<String>) detached.get("assetIds");
        assertThat(remainingAssetIds).doesNotContain(assetId);
    }
}
