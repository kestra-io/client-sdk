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

    private void createSimpleFlow(String flowId, String namespace) throws ApiException {

        String flow = """
            id: %s
            namespace: %s

            tasks:
              - id: hello
                type: io.kestra.plugin.core.log.Log
                message: Hello World! 🚀
            """.formatted(flowId, namespace);

        createSimpleFlow(flow);
    }

    private void createSimpleFlow(String flow) throws ApiException {
        kestraClient().flows().createFlow(MAIN_TENANT, flow);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ExecutionControllerExecutionResponse createFlowWithExecution(String flowId, String namespace){
        createSimpleFlow(flowId, namespace);
        return kestraClient().executions().createExecution(namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);
    }

    private Execution getExecutionWithFile(String flowId,
        String namespace) {
        String flow = """
            id: %s
            namespace: %s

            tasks:
                - id: write
                  type: io.kestra.plugin.core.storage.Write
                  content: "Hello from file"
                  extension: .txt
            """.formatted(flowId, namespace);
        createSimpleFlow(flow);
        ExecutionControllerExecutionResponse execution = kestraClient().executions().createExecution(
            namespace, flowId, false, MAIN_TENANT, null, null, null, null, null);

        AtomicReference<Execution> executionAtomic = new AtomicReference<>();
        await().atMost(Duration.ofSeconds(5)).until(() -> {
            executionAtomic.set(kestraClient().executions().getExecution(execution.getId(), MAIN_TENANT));
            return executionAtomic.get().getState().getCurrent().equals(StateType.SUCCESS);
        });
        return executionAtomic.get();
    }

    private void createSleepConcurrencyFlow(String flowId, String namespace) {
        String flow = """
            id: %s
            namespace: %s

            concurrency:
              behavior: QUEUE
              limit: 1

            tasks:
              - id: sleep
                type: io.kestra.plugin.core.flow.Sleep
                duration: PT2S
            """.formatted(flowId, namespace);
        createSimpleFlow(flow);
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

        kestraClient().executions().deleteExecution(executionId, deleteLogs, deleteMetrics, deleteStorage, MAIN_TENANT);

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
        BulkResponse response = kestraClient().executions().deleteExecutionsByIds(deleteLogs, deleteMetrics, deleteStorage, MAIN_TENANT, executionIds, includeNonTerminated);

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

        Object response = kestraClient().executions().deleteExecutionsByQuery(deleteLogs, deleteMetrics, deleteStorage, MAIN_TENANT, filters, includeNonTerminated);

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
        String executionId = null;

        kestraClient().executions().pauseExecution(executionId, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Pause a list of running executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseExecutionsByIdsTest() throws ApiException {

        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().pauseExecutionsByIds(MAIN_TENANT, requestBody);

        // TODO: test validations
    }
    /**
     * Pause executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pauseExecutionsByQueryTest() throws ApiException {

        List<QueryFilter> filters = new ArrayList<>();

//        Object response = kestraClient().executions().pauseExecutionsByQuery(MAIN_TENANT, filters); FIXME NICO

        // TODO: test validations
    }
    /**
     * Create a new execution from an old one and start it from a specified task run id
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void replayExecutionTest() throws ApiException {
        String executionId = null;

        String taskRunId = null;
        Integer revision = null;
        String breakpoints = null;
        Execution response = kestraClient().executions().replayExecution(executionId, MAIN_TENANT, taskRunId, revision, breakpoints);

        // TODO: test validations
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

        List<String> requestBody = null;
        Boolean latestRevision = null;
        BulkResponse response = kestraClient().executions().replayExecutionsByIds(MAIN_TENANT, requestBody, latestRevision);

        // TODO: test validations
    }
    /**
     * Create new executions from old ones filter by query parameters. Keep the flow revision
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void replayExecutionsByQueryTest() throws ApiException {

        List<QueryFilter> filters = new ArrayList<>();

//        Object response = kestraClient().executions().replayExecutionsByQuery(MAIN_TENANT, filters, true); FIXME NICO

        // TODO: test validations
    }
    /**
     * Restart a new execution from an old one
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartExecutionTest() throws ApiException {
        String executionId = null;

        Integer revision = null;
        Execution response = kestraClient().executions().restartExecution(executionId, MAIN_TENANT, revision);

        // TODO: test validations
    }
    /**
     * Restart a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartExecutionsByIdsTest() throws ApiException {

        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().restartExecutionsByIds(MAIN_TENANT, requestBody);

        // TODO: test validations
    }
    /**
     * Restart executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartExecutionsByQueryTest() throws ApiException {

        List<QueryFilter> filters = new ArrayList<>();

//        Object response = kestraClient().executions().restartExecutionsByQuery(MAIN_TENANT, filters); FIXME NICO

        // TODO: test validations
    }
    /**
     * Resume a paused execution.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeExecutionTest() throws ApiException {
        String executionId = null;

        Object response = kestraClient().executions().resumeExecution(executionId, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Resume a list of paused executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeExecutionsByIdsTest() throws ApiException {

        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().resumeExecutionsByIds(MAIN_TENANT, requestBody);

        // TODO: test validations
    }
    /**
     * Resume executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeExecutionsByQueryTest() throws ApiException {

        List<QueryFilter> filters = new ArrayList<>();

//        Object response = kestraClient().executions().resumeExecutionsByQuery(MAIN_TENANT, filters); FIXME NICO

        // TODO: test validations
    }
    /**
     * Search for executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchExecutionsTest() throws ApiException {
        Integer page = null;
        Integer size = null;
        List<String> sort = null;
        List<QueryFilter> filters = new ArrayList<>();

        PagedResultsExecution response = kestraClient().executions().searchExecutions(page, size, MAIN_TENANT, sort, filters);

        // TODO: test validations
    }
    /**
     * Add or update labels of a terminated execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setLabelsOnTerminatedExecutionTest() throws ApiException {
        String executionId = null;

        List<Label> label = null;
        Object response = kestraClient().executions().setLabelsOnTerminatedExecution(executionId, MAIN_TENANT, label);

        // TODO: test validations
    }
    /**
     * Set labels on a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setLabelsOnTerminatedExecutionsByIdsTest() throws ApiException {

        ExecutionControllerSetLabelsByIdsRequest executionControllerSetLabelsByIdsRequest = null;
        BulkResponse response = kestraClient().executions().setLabelsOnTerminatedExecutionsByIds(MAIN_TENANT, executionControllerSetLabelsByIdsRequest);

        // TODO: test validations
    }
    /**
     * Set label on executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void setLabelsOnTerminatedExecutionsByQueryTest() throws ApiException {

        List<Label> label = null;
        List<QueryFilter> filters = new ArrayList<>();
//        Object response = kestraClient().executions().setLabelsOnTerminatedExecutionsByQuery(MAIN_TENANT, label, filters); FIXME NICO

        // TODO: test validations
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
        String key = null;

        ExecutionControllerWebhookResponse response = kestraClient().executions().triggerExecutionByGetWebhook(namespace, id, key, MAIN_TENANT);

        // TODO: test validations
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
