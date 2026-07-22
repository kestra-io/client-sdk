package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.kestra.TestUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExecutionsApiTest {

    static ExecutionsApi api() {
        return client().executions();
    }

    private ExecutionControllerExecutionResponse executeFlow(String ns, String flowId) throws ApiException {
        return api().createExecution(TENANT, ns, flowId, null, null, null, null, null, null);
    }

    private String executeAndWaitForTermination(String ns, String flowId) throws ApiException {
        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);
        String executionId = resp.getId();
        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(executionId, TENANT);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.SUCCESS || state == StateType.FAILED
                    || state == StateType.WARNING || state == StateType.CANCELLED;
        });
        return executionId;
    }

    static String failingFlowYaml(String id, String ns) {
        return """
                id: %s
                namespace: %s
                tasks:
                  - id: fail
                    type: io.kestra.plugin.core.execution.Fail
                """.formatted(id, ns);
    }

    static String sleepFlowYaml(String id, String ns) {
        return """
                id: %s
                namespace: %s
                tasks:
                  - id: wait
                    type: io.kestra.plugin.core.flow.Sleep
                    duration: PT10S
                """.formatted(id, ns);
    }

    static String pauseWithInputsFlowYaml(String id, String ns) {
        return """
                id: %s
                namespace: %s
                tasks:
                  - id: pause
                    type: io.kestra.plugin.core.flow.Pause
                    onResume:
                      - id: quorum_status
                        type: STRING
                        required: true
                """.formatted(id, ns);
    }

    static String webhookFlowYaml(String id, String ns, String key) {
        return """
                id: %s
                namespace: %s
                tasks:
                  - id: hello
                    type: io.kestra.plugin.core.log.Log
                    message: Webhook triggered!
                triggers:
                  - id: webhook
                    type: io.kestra.plugin.core.trigger.Webhook
                    key: %s
                """.formatted(id, ns, key);
    }

    // ========================================================================
    // Create & Get
    // ========================================================================

    @Test
    void createExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse result = executeFlow(ns, flowId);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void execution_getById() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse created = executeFlow(ns, flowId);
        sleep(500);

        ApiExecution result = api().execution(created.getId(), TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(created.getId());
    }

    @Test
    void execution_waitForCompletion() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        String executionId = executeAndWaitForTermination(ns, flowId);

        ApiExecution result = api().execution(executionId, TENANT);
        assertThat(result.getState().getCurrent()).isEqualTo(StateType.SUCCESS);
    }

    // ========================================================================
    // Search
    // ========================================================================

    @Test
    void searchExecutions_basic() throws ApiException {
        PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
    }

    @Test
    void searchExecutions_withPagination() throws ApiException {
        PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 2, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotNull();
        assertThat(result.getResults().size()).isLessThanOrEqualTo(2);
    }

    @Test
    void searchExecutionsByFlowId_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        executeAndWaitForTermination(ns, flowId);

        PagedResultsApiLightExecution result = api().searchExecutionsByFlowId(TENANT, ns, flowId, 1, 10);

        assertThat(result).isNotNull();
        assertThat(result.getResults()).isNotEmpty();
    }

    @Test
    void searchExecutions_withNamespaceFilter() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        executeAndWaitForTermination(ns, flowId);

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10, null,
                    List.of(nsFilter(ns)));
            assertThat(result.getResults()).isNotEmpty();
            assertThat(result.getResults()).allSatisfy(exec ->
                    assertThat(exec.getNamespace()).isEqualTo(ns));
        });
    }

    @Test
    void searchExecutions_withFlowIdFilter() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        executeAndWaitForTermination(ns, flowId);

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10, null,
                    List.of(flowIdFilter(flowId)));
            assertThat(result.getResults()).isNotEmpty();
            assertThat(result.getResults()).allSatisfy(exec ->
                    assertThat(exec.getFlowId()).isEqualTo(flowId));
        });
    }

    @Test
    void searchExecutions_withStateFilter() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        executeAndWaitForTermination(ns, flowId);

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10, null,
                    List.of(stateFilter("SUCCESS"), nsFilter(ns)));
            assertThat(result.getResults()).isNotEmpty();
            assertThat(result.getResults()).allSatisfy(exec ->
                    assertThat(exec.getState().getCurrent()).isEqualTo(StateType.SUCCESS));
        });
    }

    @Test
    void searchExecutions_withLabels() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYamlWithLabels(flowId, ns, Map.of("team", "sdk", "env", "test")));
        api().createExecution(TENANT, ns, flowId, List.of("team:sdk", "env:test"), null, null, null, null, null);

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            PagedResultsApiLightExecution r = api().searchExecutions(TENANT, 1, 10, null, List.of(nsFilter(ns)));
            if (r.getResults() == null || r.getResults().isEmpty()) return false;
            ApiLightExecution exec = r.getResults().get(0);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.SUCCESS || state == StateType.FAILED
                    || state == StateType.WARNING || state == StateType.CANCELLED;
        });

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10, null,
                    List.of(labelsFilter(Map.of("team", "sdk")), nsFilter(ns)));
            assertThat(result.getResults()).isNotEmpty();
        });
    }

    @Test
    void searchExecutions_multipleFilters() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        executeAndWaitForTermination(ns, flowId);

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10, null,
                    List.of(nsFilter(ns), flowIdFilter(flowId), stateFilter("SUCCESS")));
            assertThat(result.getResults()).isNotEmpty();
            assertThat(result.getResults()).allSatisfy(exec -> {
                assertThat(exec.getNamespace()).isEqualTo(ns);
                assertThat(exec.getFlowId()).isEqualTo(flowId);
                assertThat(exec.getState().getCurrent()).isEqualTo(StateType.SUCCESS);
            });
        });
    }

    @Test
    void searchExecutions_noResults() throws ApiException {
        PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10, null,
                List.of(nsFilter("nonexistent_ns_" + randomId())));

        assertThat(result.getTotal()).isEqualTo(0);
        assertThat(result.getResults()).isEmpty();
    }

    @Test
    void searchExecutions_withSort() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        executeAndWaitForTermination(ns, flowId);
        sleep(500);
        executeAndWaitForTermination(ns, flowId);

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).untilAsserted(() -> {
            PagedResultsApiLightExecution result = api().searchExecutions(TENANT, 1, 10,
                    List.of("state.startDate:desc"), List.of(nsFilter(ns)));
            assertThat(result.getResults()).hasSizeGreaterThanOrEqualTo(2);
            for (int i = 0; i < result.getResults().size() - 1; i++) {
                assertThat(result.getResults().get(i).getState().getStartDate())
                        .isAfterOrEqualTo(result.getResults().get(i + 1).getState().getStartDate());
            }
        });
    }

    // ========================================================================
    // Graph & Flow
    // ========================================================================

    @Test
    void executionFlowGraph_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        FlowGraph result = api().executionFlowGraph(executionId, TENANT, null);

        assertThat(result).isNotNull();
        assertThat(result.getNodes()).isNotEmpty();
    }

    @Test
    void flowFromExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        FlowForExecution result = api().flowFromExecution(TENANT, ns, flowId, null);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(flowId);
    }

    @Test
    void flowFromExecutionById_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        FlowForExecution result = api().flowFromExecutionById(executionId, TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(flowId);
    }

    // ========================================================================
    // Delete
    // ========================================================================

    @Test
    void deleteExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        assertThatCode(() -> api().deleteExecution(executionId, TENANT, null, null, null))
                .doesNotThrowAnyException();
    }

    @Test
    void deleteExecutionsByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        BulkResponse result = api().deleteExecutionsByIds(TENANT, List.of(executionId), null, null, null, null);

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Kill
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 403 Forbidden — RBAC restricts this execution action for the test API token")
    void killExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(sleepFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);
        String executionId = resp.getId();
        sleep(500);

        // Wait until execution is RUNNING before killing
        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(executionId, TENANT);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.RUNNING;
        });

        Execution result = api().killExecution(executionId, TENANT, null);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(executionId);

        // Wait for the execution to reach KILLED state
        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(executionId, TENANT);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.KILLED || state == StateType.CANCELLED;
        });
    }

    @Test
    void killExecutionsByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(sleepFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp1 = executeFlow(ns, flowId);
        ExecutionControllerExecutionResponse resp2 = executeFlow(ns, flowId);
        String execId1 = resp1.getId();
        String execId2 = resp2.getId();
        sleep(500);

        // Wait until at least one execution is RUNNING
        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(execId1, TENANT);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.RUNNING;
        });

        assertThatCode(() -> api().killExecutionsByIds(TENANT, List.of(execId1, execId2)))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Labels
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 403 Forbidden — RBAC restricts this execution action for the test API token")
    void setLabelsOnTerminatedExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        Label label = new Label().key("env").value("test");
        Execution result = api().setLabelsOnTerminatedExecution(executionId, TENANT, List.of(label));

        assertThat(result).isNotNull();
    }

    @Test
    void setLabelsOnTerminatedExecutionsByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        Label label = new Label().key("team").value("platform");
        ExecutionControllerSetLabelsByIdsRequest request = new ExecutionControllerSetLabelsByIdsRequest()
                .executionsId(List.of(executionId))
                .executionLabels(List.of(label));

        assertThatCode(() -> api().setLabelsOnTerminatedExecutionsByIds(TENANT, request))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Eval
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 403 Forbidden — RBAC restricts this execution action for the test API token")
    void evalExpression_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        ExecutionControllerEvalResult result = api().evalExpression(executionId, TENANT, "{{ execution.id }}");

        assertThat(result).isNotNull();
        assertThat(result.getResult()).contains(executionId);
    }

    // ========================================================================
    // Replay
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 404 'Requested Flow is not found' — execution action now requires the source flow to exist")
    void replayExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        Execution result = api().replayExecution(executionId, TENANT, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotEqualTo(executionId);
    }

    // ========================================================================
    // Latest executions
    // ========================================================================

    @Test
    void latestExecutions_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        executeAndWaitForTermination(ns, flowId);

        ExecutionRepositoryInterfaceFlowFilter filter = new ExecutionRepositoryInterfaceFlowFilter()
                .namespace(ns)
                .id(flowId);

        List<ExecutionControllerLastExecutionResponse> result =
                api().latestExecutions(TENANT, List.of(filter));

        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }

    // ========================================================================
    // Restart
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 404 'Requested Flow is not found' — execution action now requires the source flow to exist")
    void restartExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(failingFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);
        String executionId = resp.getId();
        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(executionId, TENANT);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.FAILED;
        });
        sleep(500);

        Execution result = api().restartExecution(executionId, TENANT, null);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    // ========================================================================
    // Update execution status
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 404 'Requested Flow is not found' — execution action now requires the source flow to exist")
    void updateExecutionStatus_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        // Change a SUCCESS execution to WARNING
        Execution result = api().updateExecutionStatus(executionId, StateType.WARNING, TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(executionId);
    }

    // ========================================================================
    // Webhooks
    // ========================================================================

    @Test
    void triggerExecutionByGetWebhook_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        String key = randomId();
        createFlow(webhookFlowYaml(flowId, ns, key));
        sleep(500);

        WebhookResponse result = api().triggerExecutionByGetWebhook(TENANT, ns, flowId, key);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
        assertThat(result.getFlowId()).isEqualTo(flowId);
        assertThat(result.getNamespace()).isEqualTo(ns);
    }


    // ========================================================================
    // Kill by query
    // ========================================================================

    @Test
    void killExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().killExecutionsByQuery(TENANT, List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Delete by query
    // ========================================================================

    @Test
    void deleteExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().deleteExecutionsByQuery(TENANT, List.of(nsFilter("nonexistent")), null, null, null, null))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Pause / Resume
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 404 'Requested Flow is not found' — execution action now requires the source flow to exist")
    void pauseExecution_notPaused() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(sleepFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);
        String executionId = resp.getId();

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(executionId, TENANT);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.RUNNING;
        });

        Execution result = api().pauseExecution(executionId, TENANT);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(executionId);

        // Resume
        Execution resumed = api().resumeExecution(executionId, TENANT);
        assertThat(resumed).isNotNull();
        assertThat(resumed.getId()).isEqualTo(executionId);
    }

    @Test
    @Disabled("Kestra 2.0: returns 404 'Requested Flow is not found' — execution action now requires the source flow to exist")
    void resumeExecution_withInputs() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(pauseWithInputsFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);
        String executionId = resp.getId();

        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(executionId, TENANT);
            StateType state = exec.getState() != null ? exec.getState().getCurrent() : null;
            return state == StateType.PAUSED;
        });

        // onResume declares a required input, so resume succeeds only if inputs are forwarded
        Execution resumed = api().resumeExecution(executionId, TENANT, Map.of("quorum_status", "TIMEOUT"));

        assertThat(resumed).isNotNull();
        assertThat(resumed.getId()).isEqualTo(executionId);
    }

    @Test
    void pauseExecutionsByIds_basic() throws ApiException {
        assertThatThrownBy(() -> api().pauseExecutionsByIds(TENANT, List.of("nonexistent")))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void pauseExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().pauseExecutionsByQuery(TENANT, List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    @Test
    void resumeExecutionsByIds_basic() throws ApiException {
        assertThatThrownBy(() -> api().resumeExecutionsByIds(TENANT, List.of("nonexistent")))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void resumeExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().resumeExecutionsByQuery(TENANT, List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Restart by bulk
    // ========================================================================

    @Test
    void restartExecutionsByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(failingFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);
        String executionId = resp.getId();
        await().atMost(30, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS).until(() -> {
            ApiExecution exec = api().execution(executionId, TENANT);
            return exec.getState() != null && exec.getState().getCurrent() == StateType.FAILED;
        });

        assertThatCode(() -> api().restartExecutionsByIds(TENANT, List.of(executionId)))
                .doesNotThrowAnyException();
    }

    @Test
    void restartExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().restartExecutionsByQuery(TENANT, List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Replay bulk
    // ========================================================================

    @Test
    @Disabled("Kestra 2.0: returns 404 'Requested Flow is not found' — execution action now requires the source flow to exist")
    void replayExecutionWithInputs_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        Execution result = api().replayExecutionWithInputs(executionId, TENANT, null, null, null);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotBlank();
    }

    @Test
    void replayExecutionsByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        assertThatCode(() -> api().replayExecutionsByIds(TENANT, List.of(executionId), null))
                .doesNotThrowAnyException();
    }

    @Test
    void replayExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().replayExecutionsByQuery(TENANT, List.of(nsFilter("nonexistent")), null))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Force run
    // ========================================================================

    @Test
    void forceRunExecution_notQueued() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        // Force-run on a terminated execution should fail (409)
        assertThatThrownBy(() -> api().forceRunExecution(executionId, TENANT))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void forceRunByIds_basic() throws ApiException {
        assertThatThrownBy(() -> api().forceRunByIds(TENANT, List.of("nonexistent")))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void forceRunExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().forceRunExecutionsByQuery(TENANT, List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Unqueue
    // ========================================================================

    @Test
    void unqueueExecution_notQueued() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        assertThatThrownBy(() -> api().unqueueExecution(executionId, TENANT, null))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void unqueueExecutionsByIds_basic() throws ApiException {
        assertThatThrownBy(() -> api().unqueueExecutionsByIds(TENANT, StateType.SUCCESS, List.of("nonexistent")))
                .isInstanceOf(ApiException.class);
    }

    @Test
    void unqueueExecutionsByQuery_basic() throws ApiException {
        assertThatCode(() -> api().unqueueExecutionsByQuery(TENANT, null, List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Labels by query
    // ========================================================================

    @Test
    void setLabelsOnTerminatedExecutionsByQuery_basic() throws ApiException {
        Label label = new Label().key("env").value("staging");
        assertThatCode(() -> api().setLabelsOnTerminatedExecutionsByQuery(TENANT, List.of(label), List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Change status bulk
    // ========================================================================

    @Test
    void updateExecutionsStatusByIds_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        assertThatCode(() -> api().updateExecutionsStatusByIds(TENANT, StateType.WARNING, List.of(executionId)))
                .doesNotThrowAnyException();
    }

    @Test
    void updateExecutionsStatusByQuery_basic() throws ApiException {
        assertThatCode(() -> api().updateExecutionsStatusByQuery(TENANT, StateType.WARNING, List.of(nsFilter("nonexistent"))))
                .doesNotThrowAnyException();
    }

    // ========================================================================
    // Streaming (SSE)
    // ========================================================================

    @Test
    void followExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);

        Flux<Execution> flux = api().followExecution(resp.getId(), TENANT);

        List<Execution> events = new ArrayList<>();
        flux.take(Duration.ofSeconds(15))
                .doOnNext(events::add)
                .blockLast(Duration.ofSeconds(20));

        assertThat(events).isNotEmpty();
        Execution last = events.get(events.size() - 1);
        assertThat(last.getState()).isNotNull();
    }

    @Test
    void followDependenciesExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        ExecutionControllerExecutionResponse resp = executeFlow(ns, flowId);

        Flux<ExecutionStatusEvent> flux = api().followDependenciesExecution(resp.getId(), TENANT, null, null);

        List<ExecutionStatusEvent> events = new ArrayList<>();
        flux.take(Duration.ofSeconds(15))
                .doOnNext(events::add)
                .blockLast(Duration.ofSeconds(20));

        assertThat(events).isNotEmpty();
    }
}
