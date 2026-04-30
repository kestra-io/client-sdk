package io.kestra.sdk.api;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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
    }

    @Test
    void flowFromExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));

        FlowForExecution result = api().flowFromExecution(TENANT, ns, flowId, null);

        assertThat(result).isNotNull();
    }

    @Test
    void flowFromExecutionById_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        FlowForExecution result = api().flowFromExecutionById(executionId, TENANT);

        assertThat(result).isNotNull();
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
    // Labels
    // ========================================================================

    @Test
    void setLabelsOnTerminatedExecution_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        Label label = new Label().key("env").value("test");
        Execution result = api().setLabelsOnTerminatedExecution(executionId, TENANT, List.of(label));

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Eval
    // ========================================================================

    @Test
    void evalExpression_basic() throws ApiException {
        String ns = randomId();
        String flowId = randomId();
        createFlow(logFlowYaml(flowId, ns));
        String executionId = executeAndWaitForTermination(ns, flowId);

        ExecutionControllerEvalResult result = api().evalExpression(executionId, TENANT, "{{ execution.id }}");

        assertThat(result).isNotNull();
    }

    // ========================================================================
    // Replay
    // ========================================================================

    @Test
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
