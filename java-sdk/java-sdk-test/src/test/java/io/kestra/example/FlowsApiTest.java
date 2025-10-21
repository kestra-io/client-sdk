package io.kestra.example;

import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.AppsControllerApiBulkImportResponse;
import io.kestra.sdk.model.BulkResponse;
import io.kestra.sdk.model.DeleteExecutionsByQueryRequest;
import java.io.File;
import io.kestra.sdk.model.Flow;
import io.kestra.sdk.model.FlowControllerTaskValidationType;
import io.kestra.sdk.model.FlowGraph;
import io.kestra.sdk.model.FlowInterface;
import io.kestra.sdk.model.FlowScope;
import io.kestra.sdk.model.FlowTopologyGraph;
import io.kestra.sdk.model.FlowWithSource;
import io.kestra.sdk.model.IdWithNamespace;
import io.kestra.sdk.model.PagedResultsFlow;
import io.kestra.sdk.model.PagedResultsSearchResultFlow;
import io.kestra.sdk.model.QueryFilter;
import io.kestra.sdk.model.Task;
import io.kestra.sdk.model.UpdateFlow200Response;
import io.kestra.sdk.model.UpdateFlowsInNamespaceFromJson200Response;
import io.kestra.sdk.model.ValidateConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.kestra.example.CommonTestSetup.*;

public class FlowsApiTest {

    /**
     *     Import apps as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more apps, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void bulkImportAppsTest() throws ApiException {

        File fileUpload = null;
        AppsControllerApiBulkImportResponse response = kestraClient().flows().bulkImportApps(MAIN_TENANT, fileUpload);

        // TODO: test validations
    }
    /**
     * Update from multiples yaml sources
     *
     * All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void bulkUpdateFlowsTest() throws ApiException {
        Boolean delete = null;
        Boolean allowNamespaceChild = null;

        String namespace = randomId();
        String body = null;
        List<FlowInterface> response = kestraClient().flows().bulkUpdateFlows(delete, allowNamespaceChild, MAIN_TENANT, namespace, body);

        // TODO: test validations
    }
    /**
     * Create a flow from yaml source
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createFlowTest_simple() throws ApiException {

        String body = getSimpleFlow();
        FlowWithSource response = kestraClient().flows().createFlow(MAIN_TENANT, body);

        // TODO: test validations
    }

    @Test
    public void createFlowTest_full() throws ApiException {

        String body = getCompleteFlow();
        FlowWithSource response = kestraClient().flows().createFlow(MAIN_TENANT, body);

        // TODO: test validations
    }
    /**
     * Delete a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFlowTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();

        kestraClient().flows().deleteFlow(namespace, id, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Delete flows by their IDs.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFlowsByIdsTest() throws ApiException {

        List<IdWithNamespace> idWithNamespace = null;
        BulkResponse response = kestraClient().flows().deleteFlowsByIds(MAIN_TENANT, idWithNamespace);

        // TODO: test validations
    }
    /**
     * Delete flows returned by the query parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFlowsByQueryTest() throws ApiException {

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        List<String> labels = null;
        BulkResponse response = kestraClient().flows().deleteFlowsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, labels);

        // TODO: test validations
    }
    /**
     * Disable flows by their IDs.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void disableFlowsByIdsTest() throws ApiException {

        List<IdWithNamespace> idWithNamespace = null;
        BulkResponse response = kestraClient().flows().disableFlowsByIds(MAIN_TENANT, idWithNamespace);

        // TODO: test validations
    }
    /**
     * Disable flows returned by the query parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void disableFlowsByQueryTest() throws ApiException {

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        List<String> labels = null;
        BulkResponse response = kestraClient().flows().disableFlowsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, labels);

        // TODO: test validations
    }
    /**
     * Enable flows by their IDs.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void enableFlowsByIdsTest() throws ApiException {

        List<IdWithNamespace> idWithNamespace = null;
        BulkResponse response = kestraClient().flows().enableFlowsByIds(MAIN_TENANT, idWithNamespace);

        // TODO: test validations
    }
    /**
     * Enable flows returned by the query parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void enableFlowsByQueryTest() throws ApiException {

        DeleteExecutionsByQueryRequest deleteExecutionsByQueryRequest = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        List<String> labels = null;
        BulkResponse response = kestraClient().flows().enableFlowsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, labels);

        // TODO: test validations
    }
    /**
     * Export flows as a ZIP archive of yaml sources.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void exportFlowsByIdsTest() throws ApiException {

        List<IdWithNamespace> idWithNamespace = null;
        byte[] response = kestraClient().flows().exportFlowsByIds(MAIN_TENANT, idWithNamespace);

        // TODO: test validations
    }
    /**
     * Export flows as a ZIP archive of yaml sources.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void exportFlowsByQueryTest() throws ApiException {

        List<QueryFilter> filters = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        List<String> labels = null;
        byte[] response = kestraClient().flows().exportFlowsByQuery(MAIN_TENANT, filters, q, scope, namespace, labels);

        // TODO: test validations
    }
    /**
     * Generate a graph for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void generateFlowGraphTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();

        Integer revision = null;
        List<String> subflows = null;
        FlowGraph response = kestraClient().flows().generateFlowGraph(namespace, id, MAIN_TENANT, revision, subflows);

        // TODO: test validations
    }
    /**
     * Generate a graph for a flow source
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void generateFlowGraphFromSourceTest() throws ApiException {

        String body = null;
        List<String> subflows = null;
        FlowGraph response = kestraClient().flows().generateFlowGraphFromSource(MAIN_TENANT, body, subflows);

        // TODO: test validations
    }
    /**
     * Get a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        Boolean source = null;
        Boolean allowDeleted = null;

        Integer revision = null;
        Object response = kestraClient().flows().getFlow(namespace, id, source, allowDeleted, MAIN_TENANT, revision);

        // TODO: test validations
    }
    /**
     * Get flow dependencies
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowDependenciesTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        Boolean destinationOnly = null;
        Boolean expandAll = null;

        FlowTopologyGraph response = kestraClient().flows().getFlowDependencies(namespace, id, destinationOnly, expandAll, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Retrieve flow dependencies
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowDependenciesFromNamespaceTest() throws ApiException {
        String namespace = randomId();
        Boolean destinationOnly = null;

        FlowTopologyGraph response = kestraClient().flows().getFlowDependenciesFromNamespace(namespace, destinationOnly, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Get a flow task
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTaskFromFlowTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        String taskId = null;

        Integer revision = null;
        Task response = kestraClient().flows().getTaskFromFlow(namespace, id, taskId, MAIN_TENANT, revision);

        // TODO: test validations
    }
    /**
     *     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void importFlowsTest() throws ApiException {

        File fileUpload = null;
        List<String> response = kestraClient().flows().importFlows(MAIN_TENANT, fileUpload);

        // TODO: test validations
    }
    /**
     * List all distinct namespaces
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listDistinctNamespacesTest() throws ApiException {

        String q = null;
        List<String> response = kestraClient().flows().listDistinctNamespaces(MAIN_TENANT, q);

        // TODO: test validations
    }
    /**
     * Get revisions for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listFlowRevisionsTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();

        List<FlowWithSource> response = kestraClient().flows().listFlowRevisions(namespace, id, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Retrieve all flows from a given namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listFlowsByNamespaceTest() throws ApiException {
        String namespace = randomId();

        List<Flow> response = kestraClient().flows().listFlowsByNamespace(namespace, MAIN_TENANT);

        // TODO: test validations
    }
    /**
     * Search for flows
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchFlowsTest() throws ApiException {
        Integer page = null;
        Integer size = null;

        List<String> sort = null;
        List<QueryFilter> filters = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = randomId();
        List<String> labels = null;
        PagedResultsFlow response = kestraClient().flows().searchFlows(page, size, MAIN_TENANT, sort, filters, q, scope, namespace, labels);

        // TODO: test validations
    }
    /**
     * Search for flows source code
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchFlowsBySourceCodeTest() throws ApiException {
        Integer page = null;
        Integer size = null;

        List<String> sort = null;
        String q = null;
        String namespace = randomId();
        PagedResultsSearchResultFlow response = kestraClient().flows().searchFlowsBySourceCode(page, size, MAIN_TENANT, sort, q, namespace);

        // TODO: test validations
    }
    /**
     * Update a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateFlowTest() throws ApiException {
        String id = randomId();
        String namespace = randomId();

        String body = null;
        UpdateFlow200Response response = kestraClient().flows().updateFlow(id, namespace, MAIN_TENANT, body);

        // TODO: test validations
    }
    /**
     * Update a complete namespace from json object
     *
     * All flow will be created / updated for this namespace. Flow that already created but not in &#x60;flows&#x60; will be deleted if the query delete is &#x60;true&#x60;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateFlowsInNamespaceFromJsonTest() throws ApiException {
        Boolean delete = null;
        String namespace = randomId();

        List<Flow> flow = null;
        UpdateFlowsInNamespaceFromJson200Response response = kestraClient().flows().updateFlowsInNamespaceFromJson(delete, namespace, MAIN_TENANT, flow);

        // TODO: test validations
    }
    /**
     * Update a single task on a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateTaskTest() throws ApiException {
        String namespace = randomId();
        String id = randomId();
        String taskId = null;

        Task task = null;
        Flow response = kestraClient().flows().updateTask(namespace, id, taskId, MAIN_TENANT, task);

        // TODO: test validations
    }
    /**
     * Validate a list of flows
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateFlowsTest() throws ApiException {

        String body = null;
        List<ValidateConstraintViolation> response = kestraClient().flows().validateFlows(MAIN_TENANT, body);

        // TODO: test validations
    }
    /**
     * Validate a task
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateTaskTest() throws ApiException {
        FlowControllerTaskValidationType section = null;

        String body = null;
        ValidateConstraintViolation response = kestraClient().flows().validateTask(section, MAIN_TENANT, body);

        // TODO: test validations
    }
    /**
     * Validate trigger
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateTriggerTest() throws ApiException {

        Object body = null;
        ValidateConstraintViolation response = kestraClient().flows().validateTrigger(MAIN_TENANT, body);

        // TODO: test validations
    }
}
