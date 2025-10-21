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

import static io.kestra.example.CommonTestSetup.kestraClient;

public class ExecutionsApiTest {

    /**
     * Create a new execution for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createExecutionTest() throws ApiException {
        String namespace = null;
        String id = null;
        Boolean wait = null;
        String tenant = null;
        List<String> labels = null;
        Integer revision = null;
        OffsetDateTime scheduleDate = null;
        String breakpoints = null;
        ExecutionKind kind = null;
        ExecutionControllerExecutionResponse response = kestraClient().executions().createExecution(namespace, id, wait, tenant, labels, revision, scheduleDate, breakpoints, kind);

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
        String tenant = null;
        kestraClient().executions().deleteExecution(executionId, deleteLogs, deleteMetrics, deleteStorage, tenant);

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
        String tenant = null;
        List<String> requestBody = null;
        Boolean includeNonTerminated = null;
        BulkResponse response = kestraClient().executions().deleteExecutionsByIds(deleteLogs, deleteMetrics, deleteStorage, tenant, requestBody, includeNonTerminated);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Boolean includeNonTerminated = null;
        Object response = kestraClient().executions().deleteExecutionsByQuery(deleteLogs, deleteMetrics, deleteStorage, tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, includeNonTerminated);

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
        String tenant = null;
        File response = kestraClient().executions().downloadFileFromExecution(executionId, path, tenant);

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
        String tenant = null;
        String body = null;
        ExecutionControllerEvalResult response = kestraClient().executions().evalTaskRunExpression(executionId, taskRunId, tenant, body);

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
        String tenant = null;
        EventExecutionStatusEvent response = kestraClient().executions().followDependenciesExecutions(executionId, destinationOnly, expandAll, tenant);

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
        String tenant = null;
        EventExecution response = kestraClient().executions().followExecution(executionId, tenant);

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
        String tenant = null;
        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().forceRunByIds(tenant, requestBody);

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
        String tenant = null;
        Execution response = kestraClient().executions().forceRunExecution(executionId, tenant);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().forceRunExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String tenant = null;
        Execution response = kestraClient().executions().getExecution(executionId, tenant);

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
        String tenant = null;
        List<String> subflows = null;
        FlowGraph response = kestraClient().executions().getExecutionFlowGraph(executionId, tenant, subflows);

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
        String tenant = null;
        FileMetas response = kestraClient().executions().getFileMetadatasFromExecution(executionId, path, tenant);

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
        String namespace = null;
        String flowId = null;
        String tenant = null;
        Integer revision = null;
        FlowForExecution response = kestraClient().executions().getFlowFromExecution(namespace, flowId, tenant, revision);

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
        String tenant = null;
        FlowForExecution response = kestraClient().executions().getFlowFromExecutionById(executionId, tenant);

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
        String tenant = null;
        List<ExecutionRepositoryInterfaceFlowFilter> executionRepositoryInterfaceFlowFilter = null;
        List<ExecutionControllerLastExecutionResponse> response = kestraClient().executions().getLatestExecutions(tenant, executionRepositoryInterfaceFlowFilter);

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
        String tenant = null;
        Object response = kestraClient().executions().killExecution(executionId, isOnKillCascade, tenant);

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
        String tenant = null;
        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().killExecutionsByIds(tenant, requestBody);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().killExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String tenant = null;
        List<String> response = kestraClient().executions().listExecutableDistinctNamespaces(tenant);

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
        String namespace = null;
        String tenant = null;
        List<FlowForExecution> response = kestraClient().executions().listFlowExecutionsByNamespace(namespace, tenant);

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
        String tenant = null;
        kestraClient().executions().pauseExecution(executionId, tenant);

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
        String tenant = null;
        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().pauseExecutionsByIds(tenant, requestBody);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().pauseExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String tenant = null;
        Object response = kestraClient().executions().previewFileFromExecution(executionId, path, maxRows, encoding, tenant);

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
        String tenant = null;
        String taskRunId = null;
        Integer revision = null;
        String breakpoints = null;
        Execution response = kestraClient().executions().replayExecution(executionId, tenant, taskRunId, revision, breakpoints);

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
        String tenant = null;
        String taskRunId = null;
        Integer revision = null;
        String breakpoints = null;
        Execution response = kestraClient().executions().replayExecutionWithinputs(executionId, tenant, taskRunId, revision, breakpoints);

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
        String tenant = null;
        List<String> requestBody = null;
        Boolean latestRevision = null;
        BulkResponse response = kestraClient().executions().replayExecutionsByIds(tenant, requestBody, latestRevision);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Boolean latestRevision = null;
        Object response = kestraClient().executions().replayExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, latestRevision);

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
        String tenant = null;
        Integer revision = null;
        Execution response = kestraClient().executions().restartExecution(executionId, tenant, revision);

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
        String tenant = null;
        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().restartExecutionsByIds(tenant, requestBody);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().restartExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String tenant = null;
        Object response = kestraClient().executions().resumeExecution(executionId, tenant);

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
        String tenant = null;
        String breakpoints = null;
        kestraClient().executions().resumeExecutionFromBreakpoint(executionId, tenant, breakpoints);

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
        String tenant = null;
        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().resumeExecutionsByIds(tenant, requestBody);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().resumeExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String tenant = null;
        List<String> sort = null;
        List<QueryFilter> filters = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        PagedResultsExecution response = kestraClient().executions().searchExecutions(page, size, tenant, sort, filters, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String namespace = null;
        String flowId = null;
        Integer page = null;
        Integer size = null;
        String tenant = null;
        PagedResultsExecution response = kestraClient().executions().searchExecutionsByFlowId(namespace, flowId, page, size, tenant);

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
        String tenant = null;
        List<String> sort = null;
        List<QueryFilter> filters = null;
        String q = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        PagedResultsTaskRun response = kestraClient().executions().searchTaskRun(page, size, tenant, sort, filters, q, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String tenant = null;
        List<Label> label = null;
        Object response = kestraClient().executions().setLabelsOnTerminatedExecution(executionId, tenant, label);

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
        String tenant = null;
        ExecutionControllerSetLabelsByIdsRequest executionControllerSetLabelsByIdsRequest = null;
        BulkResponse response = kestraClient().executions().setLabelsOnTerminatedExecutionsByIds(tenant, executionControllerSetLabelsByIdsRequest);

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
        String tenant = null;
        List<Label> label = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        Object response = kestraClient().executions().setLabelsOnTerminatedExecutionsByQuery(tenant, label, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String namespace = null;
        String id = null;
        Boolean wait = null;
        String tenant = null;
        List<String> labels = null;
        Integer revision = null;
        List<ExecutionControllerExecutionResponse> response = kestraClient().executions().triggerExecution(namespace, id, wait, tenant, labels, revision);

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
        String namespace = null;
        String id = null;
        String key = null;
        String tenant = null;
        ExecutionControllerWebhookResponse response = kestraClient().executions().triggerExecutionByGetWebhook(namespace, id, key, tenant);

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
        String namespace = null;
        String id = null;
        String key = null;
        String tenant = null;
        ExecutionControllerWebhookResponse response = kestraClient().executions().triggerExecutionByPostWebhook(namespace, id, key, tenant);

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
        String namespace = null;
        String id = null;
        String key = null;
        String tenant = null;
        ExecutionControllerWebhookResponse response = kestraClient().executions().triggerExecutionByPutWebhook(namespace, id, key, tenant);

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
        String tenant = null;
        Execution response = kestraClient().executions().unqueueExecution(executionId, state, tenant);

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
        String tenant = null;
        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().unqueueExecutionsByIds(state, tenant, requestBody);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        StateType newState = null;
        Object response = kestraClient().executions().unqueueExecutionsByQuery(tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter, newState);

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
        String tenant = null;
        Execution response = kestraClient().executions().updateExecutionStatus(executionId, status, tenant);

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
        String tenant = null;
        List<String> requestBody = null;
        BulkResponse response = kestraClient().executions().updateExecutionsStatusByIds(newStatus, tenant, requestBody);

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
        String tenant = null;
        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        String flowId = null;
        OffsetDateTime startDate = null;
        OffsetDateTime endDate = null;
        String timeRange = null;
        List<StateType> state = null;
        List<String> labels = null;
        String triggerExecutionId = null;
        ExecutionRepositoryInterfaceChildFilter childFilter = null;
        BulkResponse response = kestraClient().executions().updateExecutionsStatusByQuery(newStatus, tenant, deleteExecutionsByQueryRequest, q, scope, namespace, flowId, startDate, endDate, timeRange, state, labels, triggerExecutionId, childFilter);

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
        String tenant = null;
        ExecutionControllerStateRequest executionControllerStateRequest = null;
        Execution response = kestraClient().executions().updateTaskRunState(executionId, tenant, executionControllerStateRequest);

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
        String namespace = null;
        String id = null;
        List<String> labels = null;
        String tenant = null;
        Integer revision = null;
        List<ExecutionControllerApiValidateExecutionInputsResponse> response = kestraClient().executions().validateNewExecutionInputs(namespace, id, labels, tenant, revision);

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
        String tenant = null;
        List<ExecutionControllerApiValidateExecutionInputsResponse> response = kestraClient().executions().validateResumeExecutionInputs(executionId, tenant);

        // TODO: test validations
    }
}
