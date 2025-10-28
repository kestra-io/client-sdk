package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.Execution;
import io.kestra.sdk.model.ExecutionControllerExecutionResponse;
import io.kestra.sdk.model.ExecutionControllerLastExecutionResponse;
import io.kestra.sdk.model.ExecutionControllerSetLabelsByIdsRequest;
import io.kestra.sdk.model.ExecutionControllerStateRequest;
import io.kestra.sdk.model.ExecutionControllerWebhookResponse;
import io.kestra.sdk.model.ExecutionKind;
import io.kestra.sdk.model.ExecutionRepositoryInterfaceFlowFilter;
import io.kestra.sdk.model.FlowWithSource;
import io.kestra.sdk.model.QueryFilterField;
import io.kestra.sdk.model.QueryFilterOp;
import java.io.File;
import io.kestra.sdk.model.FileMetas;
import io.kestra.sdk.model.FlowForExecution;
import io.kestra.sdk.model.FlowGraph;
import io.kestra.sdk.model.Label;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Duration;
import java.time.OffsetDateTime;
import io.kestra.sdk.model.PagedResultsExecution;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.StateType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

import java.net.URI;


import java.util.List;

import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExecutionsApiTest {

    public static final String FAILED_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: fail
            type: io.kestra.plugin.core.execution.Fail
        """;
    public static final String SLEEP_CONCURRENCY_FLOW = """
        id: %s
        namespace: %s

        concurrency:
          behavior: QUEUE
          limit: 1

        tasks:
          - id: sleep
            type: io.kestra.plugin.core.flow.Sleep
            duration: PT2S
        """;
    public static final String FILE_FLOW = """
        id: %s
        namespace: %s

        tasks:
            - id: write
              type: io.kestra.plugin.core.storage.Write
              content: "Hello from file"
              extension: .txt
        """;
    public static final String LOG_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: hello
            type: io.kestra.plugin.core.log.Log
            message: Hello World! 🚀
        """;
    public static final String PAUSE_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: pause_flow
            type: io.kestra.plugin.core.flow.Pause
            delay: PT2S
        """;
    public static final String WEBHOOK_FLOW = """
        id: %s
        namespace: %s

        tasks:
          - id: out
            type: io.kestra.plugin.core.debug.Return
            format: "{{trigger | json }}"

        triggers:
          - id: webhook
            type: io.kestra.plugin.core.trigger.Webhook
            key: a-secret-key
        """;

    private void createSimpleFlow(String flowId, String namespace) throws ApiException {
        String flow = LOG_FLOW.formatted(flowId, namespace);
        createSimpleFlow(flow);
    }

    private FlowWithSource createSimpleFlow(String flow) throws ApiException {
        FlowWithSource flowWithSource = kestraClient().flows().createFlow(MAIN_TENANT, flow);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return flowWithSource;
    }

    public ExecutionControllerExecutionResponse createFlowWithExecution(String flowId, String namespace){
        createSimpleFlow(flowId, namespace);
        return kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
    }

    public ExecutionControllerExecutionResponse createFlowWithExecution(String flow){
        FlowWithSource simpleFlow = createSimpleFlow(flow);
        return kestraClient().executions().createExecution(simpleFlow.getNamespace(), simpleFlow.getId(), false, MAIN_TENANT, null, null, null, null, null);
    }

    private Execution getExecutionWithFile(String flowId, String namespace) {
        String flow = FILE_FLOW.formatted(flowId, namespace);
        ExecutionControllerExecutionResponse execution = createFlowWithExecution(flow);

        AtomicReference<Execution> executionAtomic = new AtomicReference<>();
        await().atMost(Duration.ofSeconds(5)).until(() -> {
            executionAtomic.set(kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT));
            return executionAtomic.get().getState().getCurrent().equals(StateType.SUCCESS);
        });
        return executionAtomic.get();
    }

    private void createSleepConcurrencyFlow(String flowId, String namespace) {
        String flow = SLEEP_CONCURRENCY_FLOW.formatted(flowId, namespace);
        createSimpleFlow(flow);
    }

    private Execution createdExecution(String flow, StateType state) {
        String namespace = randomId();
        String flowId = randomId();
        ExecutionControllerExecutionResponse execution = createFlowWithExecution(flow.formatted(flowId, namespace));
        return awaitExecution(state, execution.getId());
    }

    private static Execution awaitExecution(StateType state,String executionId) {
        AtomicReference<Execution> executionAtomicReference = new AtomicReference<>();
        await().atMost(Duration.ofSeconds(1)).until(() -> {
            executionAtomicReference.set(kestraClient().executions().getExecution(executionId, MAIN_TENANT));
            return executionAtomicReference.get().getState().getCurrent().equals(state);
        });
        return executionAtomicReference.get();
    }

    /**
     * Create a new execution for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createExecutionTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        createSimpleFlow(id, namespace);

        Boolean wait = false;
        List<String> labels = List.of("label1:created");
        Integer revision = null;
        OffsetDateTime scheduleDate = null;
        String breakpoints = null;
        ExecutionKind kind = ExecutionKind.NORMAL;
        ExecutionControllerExecutionResponse response = kestraClient().executions().createExecution(namespace, id, wait, MAIN_TENANT, labels, revision, scheduleDate, breakpoints, kind);

        assertThat(response.getLabels()).contains(new Label().key("label1").value("created"));
        assertThat(response.getFlowId()).isEqualTo(id);
        assertThat(response.getNamespace()).isEqualTo(namespace);
    }
    /**
     * Delete an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteExecutionTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        ExecutionControllerExecutionResponse response = createFlowWithExecution(id, namespace);

        String executionId = response.getId();
        Boolean deleteLogs = false;
        Boolean deleteMetrics = false;
        Boolean deleteStorage = false;

        Execution execution = kestraClient().executions().getExecution(executionId, MAIN_TENANT);
        assertThat(execution).isNotNull();

        kestraClient().executions().deleteExecution(executionId, MAIN_TENANT, deleteLogs, deleteMetrics, deleteStorage);

        ApiException apiException = assertThrows(ApiException.class,
            () -> kestraClient().executions().getExecution(executionId, MAIN_TENANT));
        assertThat(apiException.getCode()).isEqualTo(404);
    }
    /**
     * Delete a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteExecutionsByIdsTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        ExecutionControllerExecutionResponse execution1 = createFlowWithExecution(id, namespace);
        ExecutionControllerExecutionResponse execution2 = kestraClient().executions().createExecution(namespace, id, false, MAIN_TENANT, null, null, null, null, ExecutionKind.NORMAL);
        ExecutionControllerExecutionResponse execution3 = kestraClient().executions().createExecution(namespace, id, false, MAIN_TENANT, null, null, null, null, ExecutionKind.NORMAL);

        Boolean deleteLogs = false;
        Boolean deleteMetrics = false;
        Boolean deleteStorage = false;

        List<String> executionIds = List.of(execution1.getId(), execution3.getId());
        Boolean includeNonTerminated = true;
        BulkResponse response = kestraClient().executions().deleteExecutionsByIds(MAIN_TENANT, executionIds, includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage);

        assertThat(response.getCount()).isEqualTo(2);
        assertThrows(ApiException.class, () -> kestraClient().executions().getExecution(execution1.getId(), MAIN_TENANT));
        assertThrows(ApiException.class, () -> kestraClient().executions().getExecution(execution3.getId(), MAIN_TENANT));
        assertThat(kestraClient().executions().getExecution(execution2.getId(), MAIN_TENANT)).isNotNull();
    }
    /**
     * Delete executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteExecutionsByQueryTest() throws ApiException {
        String namespace1 = randomId();
        String id1 = randomId();
        ExecutionControllerExecutionResponse execution = createFlowWithExecution(id1, namespace1);
        ExecutionControllerExecutionResponse execution1 = kestraClient().executions().createExecution(namespace1, id1, false, MAIN_TENANT, null, null, null, null, null);

        String namespace2 = randomId();
        String id2= randomId();
        ExecutionControllerExecutionResponse execution2 = createFlowWithExecution(id2, namespace2);


        Boolean deleteLogs = false;
        Boolean deleteMetrics = false;
        Boolean deleteStorage = false;
        Boolean includeNonTerminated = true;
        List<QueryFilter> filters = List.of(new QueryFilter()
            .field(QueryFilterField.NAMESPACE)
            .operation(QueryFilterOp.EQUALS)
            .value(namespace1));

        Object response = kestraClient().executions().deleteExecutionsByQuery(MAIN_TENANT, filters, includeNonTerminated, deleteLogs, deleteMetrics, deleteStorage);

        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(2);

        assertThrows(ApiException.class, () -> kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT));
        assertThrows(ApiException.class, () -> kestraClient().executions().getExecution(execution1.getId(), MAIN_TENANT));
        assertThat(kestraClient().executions().getExecution(execution2.getId(), MAIN_TENANT)).isNotNull();
    }
    /**
     * Download file for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void downloadFileFromExecutionTest() throws ApiException, IOException {
        String namespace = randomId();
        String flowId = randomId();
        Execution execution = getExecutionWithFile(flowId, namespace);

        String executionId = execution.getId();
        URI path = URI.create(execution.getTaskRunList().getFirst().getOutputs().get("uri").toString());

        File response = kestraClient().executions().downloadFileFromExecution(executionId, path, MAIN_TENANT);
        String content = Files.readString(response.toPath(), StandardCharsets.UTF_8);
        assertThat(content).isEqualTo("Hello from file");
    }

    /**
     * Force run a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void forceRunByIdsTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.RUNNING));
        ExecutionControllerExecutionResponse executionQueued = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(executionQueued.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.QUEUED));

        List<String> ids = List.of(executionQueued.getId());
        BulkResponse response = kestraClient().executions().forceRunByIds(MAIN_TENANT, ids);
        assertThat(response.getCount()).isEqualTo(1);
        assertThat(kestraClient().executions().getExecution(executionQueued.getId(), MAIN_TENANT).getState().getCurrent()).isEqualTo(StateType.RUNNING);
    }
    /**
     * Force run an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void forceRunExecutionTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.RUNNING));
        ExecutionControllerExecutionResponse executionQueued = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(executionQueued.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.QUEUED));

        String executionId = executionQueued.getId();

        Execution response = kestraClient().executions().forceRunExecution(executionId, MAIN_TENANT);
        assertThat(kestraClient().executions().getExecution(response.getId(), MAIN_TENANT).getState().getCurrent()).isEqualTo(StateType.RUNNING);
    }
    /**
     * Force run executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void forceRunExecutionsByQueryTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.RUNNING));
        ExecutionControllerExecutionResponse executionQueued = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(executionQueued.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.QUEUED));


        List<QueryFilter> queryFilters = List.of(new QueryFilter()
            .field(QueryFilterField.FLOW_ID)
            .operation(QueryFilterOp.EQUALS)
            .value(flowId));
        Object response = kestraClient().executions().forceRunExecutionsByQuery(MAIN_TENANT, queryFilters);
        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(2);
        assertThat(kestraClient().executions().getExecution(executionQueued.getId(), MAIN_TENANT).getState().getCurrent()).isEqualTo(StateType.RUNNING);
    }

    /**
     * Get an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getExecutionTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        ExecutionControllerExecutionResponse execution = createFlowWithExecution(id, namespace);

        String executionId = execution.getId();

        Execution response = kestraClient().executions().getExecution(executionId, MAIN_TENANT);
        assertThat(response.getId()).isEqualTo(executionId);
    }
    /**
     * Generate a graph for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getExecutionFlowGraphTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        ExecutionControllerExecutionResponse execution = createFlowWithExecution(id, namespace);

        String executionId = execution.getId();

        List<String> subflows = null;
        FlowGraph response = kestraClient().executions().getExecutionFlowGraph(executionId, MAIN_TENANT, subflows);
        assertThat(response).isNotNull();
    }
    /**
     * Get file meta information for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFileMetadatasFromExecutionTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        Execution execution = getExecutionWithFile(id, namespace);

        String executionId = execution.getId();
        URI path = URI.create(execution.getTaskRunList().getFirst().getOutputs().get("uri").toString());

        FileMetas response = kestraClient().executions().getFileMetadatasFromExecution(executionId, path, MAIN_TENANT);
        assertThat(response.getSize()).isEqualTo(15);
    }
    /**
     * Get flow information&#39;s for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowFromExecutionByIdTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        Execution execution = getExecutionWithFile(id, namespace);

        String executionId = execution.getId();

        FlowForExecution response = kestraClient().executions().getFlowFromExecutionById(executionId, MAIN_TENANT);
        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getNamespace()).isEqualTo(namespace);
    }
    /**
     * Get the latest execution for given flows
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getLatestExecutionsTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        Execution execution = getExecutionWithFile(flowId, namespace);
        ExecutionControllerExecutionResponse execution1 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        String otherFlowId = randomId();
        Execution otherExecution = getExecutionWithFile(otherFlowId, namespace);

        List<ExecutionRepositoryInterfaceFlowFilter> executionRepositoryInterfaceFlowFilter = List.of(
            new ExecutionRepositoryInterfaceFlowFilter().id(flowId).namespace(namespace),
            new ExecutionRepositoryInterfaceFlowFilter().id(otherFlowId).namespace(namespace));
        List<ExecutionControllerLastExecutionResponse> response = kestraClient().executions().getLatestExecutions(MAIN_TENANT, executionRepositoryInterfaceFlowFilter);
        assertThat(response).hasSize(2);
        assertThat(response).extracting(ExecutionControllerLastExecutionResponse::getId).containsExactly(execution1.getId(), otherExecution.getId());
    }
    /**
     * Kill an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void killExecutionTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);

        String executionId = execution.getId();
        Boolean isOnKillCascade = true;

        kestraClient().executions().killExecution(executionId, isOnKillCascade, MAIN_TENANT);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.KILLED));
    }
    /**
     * Kill a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void killExecutionsByIdsTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution1 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        ExecutionControllerExecutionResponse execution2 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        ExecutionControllerExecutionResponse execution3 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);

        List<String> requestBody = List.of(execution2.getId(), execution3.getId());
        BulkResponse response = kestraClient().executions().killExecutionsByIds(MAIN_TENANT, requestBody);
        assertThat(response.getCount()).isEqualTo(2);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution2.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.KILLED));
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution3.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.KILLED));
        await().atMost(Duration.ofSeconds(3)).until(() -> kestraClient().executions().getExecution(execution1.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
    }
    /**
     * Kill executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void killExecutionsByQueryTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        String anotherFlowId = randomId();
        createSleepConcurrencyFlow(anotherFlowId, namespace);
        ExecutionControllerExecutionResponse execution1 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        ExecutionControllerExecutionResponse execution2 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        ExecutionControllerExecutionResponse anotherExec = kestraClient().executions().createExecution(namespace, anotherFlowId, false, MAIN_TENANT, null, null, null, null, null);

        List<QueryFilter> filters = List.of(new QueryFilter()
            .field(QueryFilterField.FLOW_ID)
            .operation(QueryFilterOp.EQUALS)
            .value(flowId));

        Object response = kestraClient().executions().killExecutionsByQuery(MAIN_TENANT, filters);
        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(2);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution1.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.KILLED));
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution2.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.KILLED));
        await().atMost(Duration.ofSeconds(3)).until(() -> kestraClient().executions().getExecution(anotherExec.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
    }
    /**
     * Pause a running execution.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseExecutionTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);

        String executionId = execution.getId();

        kestraClient().executions().pauseExecution(executionId, MAIN_TENANT);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(executionId, MAIN_TENANT).getState().getCurrent().equals(StateType.PAUSED));
    }
    /**
     * Pause a list of running executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseExecutionsByIdsTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);

        List<String> requestBody = List.of(execution.getId());
        BulkResponse response = kestraClient().executions().pauseExecutionsByIds(MAIN_TENANT, requestBody);
        assertThat(response.getCount()).isEqualTo(1);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.PAUSED));
    }
    /**
     * Pause executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseExecutionsByQueryTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        createSleepConcurrencyFlow(flowId, namespace);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        String otherFlowId = randomId();
        createSleepConcurrencyFlow(otherFlowId, namespace);
        ExecutionControllerExecutionResponse otherExecution = kestraClient().executions().createExecution(namespace, otherFlowId, false, MAIN_TENANT, null, null, null, null, null);


        List<QueryFilter> filters = List.of(new QueryFilter()
            .field(QueryFilterField.FLOW_ID)
            .operation(QueryFilterOp.EQUALS)
            .value(flowId));

        Object response = kestraClient().executions().pauseExecutionsByQuery(MAIN_TENANT, filters);
        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(1);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.PAUSED));
        await().atMost(Duration.ofSeconds(3)).until(() -> kestraClient().executions().getExecution(otherExecution.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
    }
    /**
     * Create a new execution from an old one and start it from a specified task run id
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void replayExecutionTest() throws ApiException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);

        String executionId = exec.getId();

        String taskRunId = null;
        Integer revision = null;
        String breakpoints = null;
        Execution response = kestraClient().executions().replayExecution(executionId, MAIN_TENANT, taskRunId, revision, breakpoints);
        assertThat(response.getState().getCurrent()).isEqualTo(StateType.CREATED);
        await().atMost(Duration.ofSeconds(1)).until(() -> kestraClient().executions().getExecution(response.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
    }

    /**
     * Create a new execution from an old one and start it from a specified task run id
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void replayExecutionWithinputsTest() throws ApiException {
        String executionId = null;

        String taskRunId = null;
        Integer revision = null;
        String breakpoints = null;
        Execution response = kestraClient().executions().replayExecutionWithinputs(executionId, MAIN_TENANT, taskRunId, revision, breakpoints);

        // TODO: test validations
    }
    /**
     * Create new executions from old ones. Keep the flow revision
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void replayExecutionsByIdsTest() throws ApiException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);
        Execution otherExec = createdExecution(LOG_FLOW, StateType.SUCCESS);

        List<String> requestBody = List.of(exec.getId(), otherExec.getId());
        Boolean latestRevision = null;
        BulkResponse response = kestraClient().executions().replayExecutionsByIds(MAIN_TENANT, requestBody, latestRevision);
        assertThat(response.getCount()).isEqualTo(2);
    }
    /**
     * Create new executions from old ones filter by query parameters. Keep the flow revision
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void replayExecutionsByQueryTest() throws ApiException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);
        Execution otherExec = createdExecution(LOG_FLOW, StateType.SUCCESS);

        List<QueryFilter> filters = List.of(new QueryFilter()
            .field(QueryFilterField.FLOW_ID)
            .operation(QueryFilterOp.EQUALS)
            .value(exec.getFlowId()));

        Object response = kestraClient().executions().replayExecutionsByQuery(MAIN_TENANT, filters, true);
        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(1);
    }
    /**
     * Restart a new execution from an old one
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartExecutionTest() throws ApiException {
        Execution exec = createdExecution(FAILED_FLOW, StateType.FAILED);
        String executionId = exec.getId();

        Integer revision = null;
        Execution response = kestraClient().executions().restartExecution(executionId, MAIN_TENANT, revision);
        assertThat(response.getState().getCurrent()).isEqualTo(StateType.RESTARTED);
    }
    /**
     * Restart a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartExecutionsByIdsTest() throws ApiException {
        Execution exec1 = createdExecution(FAILED_FLOW, StateType.FAILED);
        Execution exec2 = createdExecution(FAILED_FLOW, StateType.FAILED);
        Execution otherExec = createdExecution(FAILED_FLOW, StateType.FAILED);

        List<String> requestBody = List.of(exec1.getId(), exec2.getId());
        BulkResponse response = kestraClient().executions().restartExecutionsByIds(MAIN_TENANT, requestBody);

        assertThat(response.getCount()).isEqualTo(2);
    }
    /**
     * Restart executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartExecutionsByQueryTest() throws ApiException {
        Execution exec1 = createdExecution(FAILED_FLOW, StateType.FAILED);
        Execution exec2 = createdExecution(FAILED_FLOW, StateType.FAILED);
        Execution otherExec = createdExecution(FAILED_FLOW, StateType.FAILED);

        List<QueryFilter> filters = List.of(new QueryFilter().field(QueryFilterField.NAMESPACE)
            .operation(QueryFilterOp.IN)
            .value(List.of(exec1.getNamespace(), exec2.getNamespace())));

        Object response = kestraClient().executions().restartExecutionsByQuery(MAIN_TENANT, filters);
        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(2);
    }
    /**
     * Resume a paused execution.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeExecutionTest() throws ApiException {
        Execution exec = createdExecution(PAUSE_FLOW, StateType.PAUSED);
        String executionId = exec.getId();

        kestraClient().executions().resumeExecution(executionId, MAIN_TENANT);
        await().atMost(Duration.ofMillis(500)).until(() -> kestraClient().executions().getExecution(executionId, MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
    }
    /**
     * Resume a list of paused executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeExecutionsByIdsTest() throws ApiException {
        Execution exec1 = createdExecution(PAUSE_FLOW, StateType.PAUSED);
        Execution exec2 = createdExecution(PAUSE_FLOW, StateType.PAUSED);
        Execution otherExec = createdExecution(PAUSE_FLOW, StateType.PAUSED);
        List<String> requestBody = List.of(exec1.getId(), exec2.getId());
        BulkResponse response = kestraClient().executions().resumeExecutionsByIds(MAIN_TENANT, requestBody);
        assertThat(response.getCount()).isEqualTo(2);
        await().atMost(Duration.ofMillis(500)).until(() -> kestraClient().executions().getExecution(exec1.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
        await().atMost(Duration.ofMillis(500)).until(() -> kestraClient().executions().getExecution(exec2.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
    }
    /**
     * Resume executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeExecutionsByQueryTest() throws ApiException {
        Execution exec1 = createdExecution(PAUSE_FLOW, StateType.PAUSED);
        Execution exec2 = createdExecution(PAUSE_FLOW, StateType.PAUSED);
        Execution otherExec = createdExecution(PAUSE_FLOW, StateType.PAUSED);

        List<QueryFilter> filters = List.of(new QueryFilter().field(QueryFilterField.NAMESPACE)
            .operation(QueryFilterOp.IN)
            .value(List.of(exec1.getNamespace(), exec2.getNamespace())));

        Object response = kestraClient().executions().resumeExecutionsByQuery(MAIN_TENANT, filters);
        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(2);
        await().atMost(Duration.ofMillis(500)).until(() -> kestraClient().executions().getExecution(exec1.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
        await().atMost(Duration.ofMillis(500)).until(() -> kestraClient().executions().getExecution(exec2.getId(), MAIN_TENANT).getState().getCurrent().equals(StateType.SUCCESS));
    }
    /**
     * Search for executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchExecutionsTest() throws ApiException {
        String namespace = randomId();
        String flowId = randomId();
        ExecutionControllerExecutionResponse exec1 = createFlowWithExecution(flowId, namespace);
        ExecutionControllerExecutionResponse exec2 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        ExecutionControllerExecutionResponse exec3 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        ExecutionControllerExecutionResponse exec4 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        ExecutionControllerExecutionResponse exec5 = kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
        Execution otherExec = createdExecution(LOG_FLOW, StateType.SUCCESS);

        Integer page = 1;
        Integer size = 2;
        List<String> sort = List.of("state.startDate:asc");
        List<QueryFilter> filters = List.of(new QueryFilter().field(QueryFilterField.NAMESPACE)
            .operation(QueryFilterOp.EQUALS)
            .value(List.of(namespace)));

        PagedResultsExecution response = kestraClient().executions().searchExecutions(page, size, MAIN_TENANT, sort, filters);
        assertThat(response.getTotal()).isEqualTo(5);
        assertThat(response.getResults().size()).isEqualTo(2);
        assertThat(response.getResults().getFirst().getId()).isEqualTo(exec1.getId());
        assertThat(response.getResults().getLast().getId()).isEqualTo(exec2.getId());

        response = kestraClient().executions().searchExecutions(3, size, MAIN_TENANT, sort, filters);
        assertThat(response.getTotal()).isEqualTo(5);
        assertThat(response.getResults().size()).isEqualTo(1);
        assertThat(response.getResults().getFirst().getId()).isEqualTo(exec5.getId());
    }
    /**
     * Add or update labels of a terminated execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setLabelsOnTerminatedExecutionTest() throws ApiException {
        Execution exec = createdExecution(LOG_FLOW, StateType.SUCCESS);
        String executionId = exec.getId();

        Label labelFoo = new Label().key("foo").value("bar");
        Label labelTerminated = new Label().key("terminated").value("yes");
        List<Label> label = List.of(labelFoo, labelTerminated);

        Object response = kestraClient().executions().setLabelsOnTerminatedExecution(executionId, MAIN_TENANT, label);
        assertNotNull(response);
        Execution execWithLabel = kestraClient().executions().getExecution(executionId, MAIN_TENANT);
        assertThat(execWithLabel.getLabels()).contains(labelFoo, labelTerminated);
    }
    /**
     * Set labels on a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setLabelsOnTerminatedExecutionsByIdsTest() throws ApiException {
        Execution exec1 = createdExecution(LOG_FLOW, StateType.SUCCESS);
        Execution exec2 = createdExecution(LOG_FLOW, StateType.SUCCESS);
        Execution otherExec = createdExecution(LOG_FLOW, StateType.SUCCESS);

        Label labelFoo = new Label().key("foo").value("bar");
        Label labelTerminated = new Label().key("terminated").value("yes");
        List<Label> labels = List.of(labelFoo, labelTerminated);

        ExecutionControllerSetLabelsByIdsRequest executionControllerSetLabelsByIdsRequest = new ExecutionControllerSetLabelsByIdsRequest()
            .executionsId(List.of(exec1.getId(), exec2.getId()))
            .executionLabels(labels);
        BulkResponse response = kestraClient().executions().setLabelsOnTerminatedExecutionsByIds(MAIN_TENANT, executionControllerSetLabelsByIdsRequest);

        assertThat(response.getCount()).isEqualTo(2);
        Execution exec1WithLabel = kestraClient().executions().getExecution(exec1.getId(), MAIN_TENANT);
        assertThat(exec1WithLabel.getLabels()).contains(labelFoo, labelTerminated);
        Execution exec2WithLabel = kestraClient().executions().getExecution(exec2.getId(), MAIN_TENANT);
        assertThat(exec2WithLabel.getLabels()).contains(labelFoo, labelTerminated);
        Execution otherExecWithLabel = kestraClient().executions().getExecution(otherExec.getId(), MAIN_TENANT);
        assertThat(otherExecWithLabel.getLabels()).doesNotContain(labelFoo, labelTerminated);
    }
    /**
     * Set label on executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setLabelsOnTerminatedExecutionsByQueryTest() throws ApiException {
        Execution exec1 = createdExecution(LOG_FLOW, StateType.SUCCESS);
        Execution exec2 = createdExecution(LOG_FLOW, StateType.SUCCESS);
        Execution otherExec = createdExecution(LOG_FLOW, StateType.SUCCESS);

        Label labelFoo = new Label().key("foo").value("bar");
        Label labelTerminated = new Label().key("terminated").value("yes");
        List<Label> labels = List.of(labelFoo, labelTerminated);
        List<QueryFilter> filters = List.of(new QueryFilter().field(QueryFilterField.NAMESPACE)
            .operation(QueryFilterOp.IN)
            .value(List.of(exec1.getNamespace(), exec2.getNamespace())));

        Object response = kestraClient().executions().setLabelsOnTerminatedExecutionsByQuery(MAIN_TENANT, labels, filters);
        assertThat(response).isInstanceOf(LinkedHashMap.class).extracting("count").isEqualTo(2);
        Execution exec1WithLabel = kestraClient().executions().getExecution(exec1.getId(), MAIN_TENANT);
        assertThat(exec1WithLabel.getLabels()).contains(labelFoo, labelTerminated);
        Execution exec2WithLabel = kestraClient().executions().getExecution(exec2.getId(), MAIN_TENANT);
        assertThat(exec2WithLabel.getLabels()).contains(labelFoo, labelTerminated);
        Execution otherExecWithLabel = kestraClient().executions().getExecution(otherExec.getId(), MAIN_TENANT);
        assertThat(otherExecWithLabel.getLabels()).doesNotContain(labelFoo, labelTerminated);
    }
    /**
     * Trigger a new execution by GET webhook trigger
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void triggerExecutionByGetWebhookTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        createSimpleFlow(WEBHOOK_FLOW.formatted(id, namespace));
        String key = "a-secret-key";

        ExecutionControllerWebhookResponse response = kestraClient().executions().triggerExecutionByGetWebhook(namespace, id, key, MAIN_TENANT);
        assertThat(response).isNotNull();
        awaitExecution(StateType.SUCCESS, response.getId());
    }
    /**
     * Unqueue an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unqueueExecutionTest() throws ApiException {
        String executionId = null;
        StateType state = null;

        Execution response = kestraClient().executions().unqueueExecution(executionId, state, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Unqueue a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unqueueExecutionsByIdsTest() throws ApiException {
        StateType state = null;

        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().unqueueExecutionsByIds(state, MAIN_TENANT, requestBody);

        // TODO: test validations
    }
    /**
     * Unqueue executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void unqueueExecutionsByQueryTest() throws ApiException {

        List<QueryFilter> filters = new ArrayList<>();
        StateType newState = null;
//        Object response = kestraClient().executions().unqueueExecutionsByQuery(MAIN_TENANT, filters, newState); FIXME NICO

        // TODO: test validations
    }
    /**
     * Change the state of an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateExecutionStatusTest() throws ApiException {
        String executionId = null;
        StateType status = null;

        Execution response = kestraClient().executions().updateExecutionStatus(executionId, status, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Change executions state by id
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateExecutionsStatusByIdsTest() throws ApiException {
        StateType newStatus = null;

        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().updateExecutionsStatusByIds(newStatus, MAIN_TENANT, requestBody);

        // TODO: test validations
    }
    /**
     * Change executions state by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateExecutionsStatusByQueryTest() throws ApiException {
        StateType newStatus = null;
        List<QueryFilter> filters = new ArrayList<>();

//        BulkResponse response = kestraClient().executions().updateExecutionsStatusByQuery(newStatus, MAIN_TENANT, filters); FIXME NICO

        // TODO: test validations
    }
    /**
     * Change state for a taskrun in an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateTaskRunStateTest() throws ApiException {
        String executionId = null;

        ExecutionControllerStateRequest executionControllerStateRequest = null;
        Execution response = kestraClient().executions().updateTaskRunState(executionId, MAIN_TENANT, executionControllerStateRequest);

        // TODO: test validations
    }
}
