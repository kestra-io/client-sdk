package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.DeleteExecutionsByQueryRequest;
import io.kestra.sdk.model.EventExecution;
import io.kestra.sdk.model.EventExecutionStatusEvent;
import io.kestra.sdk.model.Execution;
import io.kestra.sdk.model.ExecutionControllerApiValidateExecutionInputsResponse;
import io.kestra.sdk.model.ExecutionControllerEvalResult;
import io.kestra.sdk.model.ExecutionControllerExecutionResponse;
import io.kestra.sdk.model.ExecutionControllerLastExecutionResponse;
import io.kestra.sdk.model.ExecutionControllerSetLabelsByIdsRequest;
import io.kestra.sdk.model.ExecutionControllerStateRequest;
import io.kestra.sdk.model.ExecutionControllerWebhookResponse;
import io.kestra.sdk.model.ExecutionKind;
import io.kestra.sdk.model.ExecutionRepositoryInterfaceChildFilter;
import io.kestra.sdk.model.ExecutionRepositoryInterfaceFlowFilter;
import java.io.File;
import io.kestra.sdk.model.FileMetas;
import io.kestra.sdk.model.FlowForExecution;
import io.kestra.sdk.model.FlowGraph;
import io.kestra.sdk.model.FlowScope;
import io.kestra.sdk.model.Label;
import java.time.OffsetDateTime;
import io.kestra.sdk.model.PagedResultsExecution;
import io.kestra.sdk.model.PagedResultsTaskRun;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.StateType;
import org.junit.jupiter.api.Test;

import java.net.URI;


import java.util.List;

import static io.kestra.example.CommonTestSetup.*;

public class ExecutionsApiTest {

    /** Create a flow via YAML with a single scheduled trigger; returns [flowId, triggerId]. */
    private void createSimpleFlowWithTrigger(String flowId, String namespace) throws ApiException {

        String body = """
            id: %s
            namespace: %s

            tasks:
              - id: hello
                type: io.kestra.plugin.core.log.Log
                message: Hello World! 🚀
            """.formatted(flowId, namespace);

        kestraClient().flows().createFlow(MAIN_TENANT, body);
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        Boolean wait = null;

        List<String> labels = null;
        Integer revision = null;
        OffsetDateTime scheduleDate = null;
        String breakpoints = null;
        ExecutionKind kind = null;
        ExecutionControllerExecutionResponse response = kestraClient().executions().createExecution(namespace, id, wait, MAIN_TENANT, labels, revision, scheduleDate, breakpoints, kind);

        // TODO: test validations
    }
    /**
     * Delete an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteExecutionTest() throws ApiException {
        String executionId = null;
        Boolean deleteLogs = null;
        Boolean deleteMetrics = null;
        Boolean deleteStorage = null;

        kestraClient().executions().deleteExecution(executionId, deleteLogs, deleteMetrics, deleteStorage, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Delete a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteExecutionsByIdsTest() throws ApiException {
        Boolean deleteLogs = null;
        Boolean deleteMetrics = null;
        Boolean deleteStorage = null;

        List<String> requestBody = null;
        Boolean includeNonTerminated = null;
        BulkResponse response = kestraClient().executions().deleteExecutionsByIds(deleteLogs, deleteMetrics, deleteStorage, MAIN_TENANT, requestBody, includeNonTerminated);

        // TODO: test validations
    }
    /**
     * Delete executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteExecutionsByQueryTest() throws ApiException {
        Boolean deleteLogs = null;
        Boolean deleteMetrics = null;
        Boolean deleteStorage = null;

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Boolean includeNonTerminated = null;
        Object response = kestraClient().executions().deleteExecutionsByQuery(deleteLogs, deleteMetrics, deleteStorage, MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, includeNonTerminated);

        // TODO: test validations
    }
    /**
     * Download file for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void downloadFileFromExecutionTest() throws ApiException {
        String executionId = null;
        URI path = null;

        File response = kestraClient().executions().downloadFileFromExecution(executionId, path, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Evaluate a variable expression for this taskrun
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void evalTaskRunExpressionTest() throws ApiException {
        String executionId = null;
        String taskRunId = null;

        String body = null;
        ExecutionControllerEvalResult response = kestraClient().executions().evalTaskRunExpression(executionId, taskRunId, MAIN_TENANT, body);

        // TODO: test validations
    }
    /**
     * Follow all execution dependencies executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void followDependenciesExecutionsTest() throws ApiException {
        String executionId = null;
        Boolean destinationOnly = null;
        Boolean expandAll = null;

        EventExecutionStatusEvent response = kestraClient().executions().followDependenciesExecutions(executionId, destinationOnly, expandAll, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Follow an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void followExecutionTest() throws ApiException {
        String executionId = null;

        EventExecution response = kestraClient().executions().followExecution(executionId, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Force run a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void forceRunByIdsTest() throws ApiException {

        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().forceRunByIds(MAIN_TENANT, requestBody);

        // TODO: test validations
    }
    /**
     * Force run an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void forceRunExecutionTest() throws ApiException {
        String executionId = null;

        Execution response = kestraClient().executions().forceRunExecution(executionId, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Force run executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void forceRunExecutionsByQueryTest() throws ApiException {

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().forceRunExecutionsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

        // TODO: test validations
    }
    /**
     * Get an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getExecutionTest() throws ApiException {
        String executionId = null;

        Execution response = kestraClient().executions().getExecution(executionId, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Generate a graph for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getExecutionFlowGraphTest() throws ApiException {
        String executionId = null;

        List<String> subflows = null;
        FlowGraph response = kestraClient().executions().getExecutionFlowGraph(executionId, MAIN_TENANT, subflows);

        // TODO: test validations
    }
    /**
     * Get file meta information for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFileMetadatasFromExecutionTest() throws ApiException {
        String executionId = null;
        URI path = null;

        FileMetas response = kestraClient().executions().getFileMetadatasFromExecution(executionId, path, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Get flow information&#39;s for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowFromExecutionTest() throws ApiException {
        String namespace = randomId();
        String flowId = null;

        Integer revision = null;
        FlowForExecution response = kestraClient().executions().getFlowFromExecution(namespace, flowId, MAIN_TENANT, revision);

        // TODO: test validations
    }
    /**
     * Get flow information&#39;s for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowFromExecutionByIdTest() throws ApiException {
        String executionId = null;

        FlowForExecution response = kestraClient().executions().getFlowFromExecutionById(executionId, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Get the latest execution for given flows
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getLatestExecutionsTest() throws ApiException {

        List<ExecutionRepositoryInterfaceFlowFilter> executionRepositoryInterfaceFlowFilter = null;
        List<ExecutionControllerLastExecutionResponse> response = kestraClient().executions().getLatestExecutions(MAIN_TENANT, executionRepositoryInterfaceFlowFilter);

        // TODO: test validations
    }
    /**
     * Kill an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void killExecutionTest() throws ApiException {
        String executionId = null;
        Boolean isOnKillCascade = null;

        Object response = kestraClient().executions().killExecution(executionId, isOnKillCascade, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Kill a list of executions
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void killExecutionsByIdsTest() throws ApiException {

        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().killExecutionsByIds(MAIN_TENANT, requestBody);

        // TODO: test validations
    }
    /**
     * Kill executions filter by query parameters
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void killExecutionsByQueryTest() throws ApiException {

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().killExecutionsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

        // TODO: test validations
    }
    /**
     * Get all namespaces that have executable flows
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listExecutableDistinctNamespacesTest() throws ApiException {

        List<String> response = kestraClient().executions().listExecutableDistinctNamespaces(MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Get all flow ids for a namespace. Data returned are FlowForExecution containing minimal information about a Flow for when you are allowed to executing but not reading.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listFlowExecutionsByNamespaceTest() throws ApiException {
        String namespace = randomId();

        List<FlowForExecution> response = kestraClient().executions().listFlowExecutionsByNamespace(namespace, MAIN_TENANT);

        // TODO: test validations
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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().pauseExecutionsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

        // TODO: test validations
    }
    /**
     * Get file preview for an execution
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void previewFileFromExecutionTest() throws ApiException {
        String executionId = null;
        URI path = null;
        Integer maxRows = null;
        String encoding = null;

        Object response = kestraClient().executions().previewFileFromExecution(executionId, path, maxRows, encoding, MAIN_TENANT);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Boolean latestRevision = null;
        Object response = kestraClient().executions().replayExecutionsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, latestRevision);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().restartExecutionsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
     * Resume an execution from a breakpoint (in the &#39;BREAKPOINT&#39; state).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void resumeExecutionFromBreakpointTest() throws ApiException {
        String executionId = null;

        String breakpoints = null;
        kestraClient().executions().resumeExecutionFromBreakpoint(executionId, MAIN_TENANT, breakpoints);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().resumeExecutionsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        List<QueryFilter> filters = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        PagedResultsExecution response = kestraClient().executions().searchExecutions(page, size, MAIN_TENANT, sort, filters, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

        // TODO: test validations
    }
    /**
     * Search for executions for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchExecutionsByFlowIdTest() throws ApiException {
        String namespace = randomId();
        String flowId = null;
        Integer page = null;
        Integer size = null;

        PagedResultsExecution response = kestraClient().executions().searchExecutionsByFlowId(namespace, flowId, page, size, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Search for taskruns, only available with the Elasticsearch repository
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchTaskRunTest() throws ApiException {
        Integer page = null;
        Integer size = null;

        List<String> sort = null;
        List<QueryFilter> filters = null;
        String q = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        PagedResultsTaskRun response = kestraClient().executions().searchTaskRun(page, size, MAIN_TENANT, sort, filters, q, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().setLabelsOnTerminatedExecutionsByQuery(MAIN_TENANT, label, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

        // TODO: test validations
    }
    /**
     * Trigger a new execution for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void triggerExecutionTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        Boolean wait = null;

        List<String> labels = null;
        Integer revision = null;
        List<ExecutionControllerExecutionResponse> response = kestraClient().executions().triggerExecution(namespace, id, wait, MAIN_TENANT, labels, revision);

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
     * Trigger a new execution by POST webhook trigger
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void triggerExecutionByPostWebhookTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        String key = null;

        ExecutionControllerWebhookResponse response = kestraClient().executions().triggerExecutionByPostWebhook(namespace, id, key, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Trigger a new execution by PUT webhook trigger
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void triggerExecutionByPutWebhookTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        String key = null;

        ExecutionControllerWebhookResponse response = kestraClient().executions().triggerExecutionByPutWebhook(namespace, id, key, MAIN_TENANT);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        StateType newState = null;
        Object response = kestraClient().executions().unqueueExecutionsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, newState);

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

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        BulkResponse response = kestraClient().executions().updateExecutionsStatusByQuery(newStatus, MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
    /**
     * Validate the creation of a new execution for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateNewExecutionInputsTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        List<String> labels = null;

        Integer revision = null;
        List<ExecutionControllerApiValidateExecutionInputsResponse> response = kestraClient().executions().validateNewExecutionInputs(namespace, id, labels, MAIN_TENANT, revision);

        // TODO: test validations
    }
    /**
     * Validate inputs to resume a paused execution.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateResumeExecutionInputsTest() throws ApiException {
        String executionId = null;

        List<ExecutionControllerApiValidateExecutionInputsResponse> response = kestraClient().executions().validateResumeExecutionInputs(executionId, MAIN_TENANT);

        // TODO: test validations
    }
}
