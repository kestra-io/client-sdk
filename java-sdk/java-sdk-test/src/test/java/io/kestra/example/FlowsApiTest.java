package io.kestra.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kestra.sdk.internal.ApiException;
import io.kestra.sdk.model.*;
import netscape.javascript.JSObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.kestra.example.CommonTestSetup.*;
import static org.assertj.core.api.Assertions.*;

public class FlowsApiTest {

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
        var flowBody = getSimpleFlow();
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, flowBody);
        assertFlowExist(flow);
        assertThat(flow).extracting(FlowWithSource::getDescription).isEqualTo("simple_flow_description");

        String id = flow.getId();
        String namespace = flow.getNamespace();
        String body = flowBody.replace("simple_flow_description", "simple_flow_description_updated");

        var response = kestraClient().flows().updateFlow(id, namespace, MAIN_TENANT, body);

        assertThat(response).extracting(UpdateFlow200Response::getDescription).isEqualTo("simple_flow_description_updated");
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

        assertFlowExist(response);
    }

    @Test
    public void createFlowTest_full() throws ApiException {

        String body = getCompleteFlow();
        FlowWithSource response = kestraClient().flows().createFlow(MAIN_TENANT, body);

        assertFlowExist(response);
    }
    /**
     * Delete a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFlowTest() throws ApiException {
        var flow = createSimpleFlow();

        kestraClient().flows().deleteFlow(flow.getNamespace(), flow.getId(), MAIN_TENANT);

        assertFlowDoesNotExist(flow);
    }

    /**
     * Delete flows by their IDs.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFlowsByIdsTest() throws ApiException {
        var flow = createSimpleFlow();

        var idWithNamespace = List.of(new IdWithNamespace().id(flow.getId()).namespace(flow.getNamespace()));
        kestraClient().flows().deleteFlowsByIds(MAIN_TENANT, idWithNamespace);

        assertFlowDoesNotExist(flow);
    }
    /**
     * Delete flows returned by the query parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFlowsByQueryTest() throws ApiException {
        var flow = createSimpleFlow();

        var filters = List.of(new QueryFilter().field(QueryFilterField.NAMESPACE).operation(QueryFilterOp.EQUALS).value(flow.getNamespace()));
        kestraClient().flows().deleteFlowsByQuery(MAIN_TENANT, filters);

        assertFlowDoesNotExist(flow);
    }

    /**
     * Disable flows by their IDs.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void disableFlowsByIdsTest() throws ApiException {
        var flow = createSimpleFlow();

        List<IdWithNamespace> idWithNamespace = List.of(new IdWithNamespace().id(flow.getId()).namespace(flow.getNamespace()));
        kestraClient().flows().disableFlowsByIds(MAIN_TENANT, idWithNamespace);
    }

    /**
     * Disable flows returned by the query parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void disableFlowsByQueryTest() throws ApiException {
        var flow = createSimpleFlow();

        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        List<String> labels = null;
//        kestraClient().flows().disableFlowsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, labels); TODO
    }

    /**
     * Enable flows by their IDs.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void enableFlowsByIdsTest() throws ApiException {
        var flow = createSimpleFlow();

        List<IdWithNamespace> idWithNamespace = List.of(new IdWithNamespace().id(flow.getId()).namespace(flow.getNamespace()));
        kestraClient().flows().enableFlowsByIds(MAIN_TENANT, idWithNamespace);
    }
    /**
     * Enable flows returned by the query parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void enableFlowsByQueryTest() throws ApiException {

        String q = null;
        List<FlowScope> scope = null;
        String namespace = null;
        List<String> labels = null;
//        BulkResponse response = kestraClient().flows().enableFlowsByQuery(MAIN_TENANT, deleteExecutionsByQueryRequest, q, scope, namespace, labels); TODO

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
        var flow = createSimpleFlow();
        List<IdWithNamespace> idWithNamespace = List.of(new IdWithNamespace().id(flow.getId()).namespace(flow.getNamespace()));

        kestraClient().flows().exportFlowsByIds(MAIN_TENANT, idWithNamespace);
    }
    /**
     * Export flows as a ZIP archive of yaml sources.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void exportFlowsByQueryTest() throws ApiException {
        var flow = createSimpleFlow();

        List<QueryFilter> filters = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = flow.getNamespace();
        List<String> labels = null;
//        byte[] response = kestraClient().flows().exportFlowsByQuery(MAIN_TENANT, filters, q, scope, namespace, labels); TODO
    }
    /**
     * Generate a graph for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void generateFlowGraphTest() throws ApiException {
        var flow = createSimpleFlow();
        String namespace = flow.getNamespace();
        String id = flow.getId();

        Integer revision = null;
        List<String> subflows = null;
        kestraClient().flows().generateFlowGraph(namespace, id, MAIN_TENANT, revision, subflows);
    }
    /**
     * Generate a graph for a flow source
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void generateFlowGraphFromSourceTest() throws ApiException {
        var flow = getSimpleFlow();
        String body = flow;
        List<String> subflows = null;
        kestraClient().flows().generateFlowGraphFromSource(MAIN_TENANT, body, subflows);
    }
    /**
     * Get a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowTest() throws ApiException {
        var flow = createSimpleFlow();

        String namespace = flow.getNamespace();
        String id = flow.getId();
        Boolean source = false;
        Boolean allowDeleted = false;

        Integer revision = null;
        Object response = kestraClient().flows().getFlow(namespace, id, source, allowDeleted, MAIN_TENANT, revision);

        assertThat(response).isInstanceOf(Map.class);
        assertThat((Map<String, Object>) response)
            .containsEntry("id", id);
        // TODO: check if this is acceptable
    }

    /**
     * Get flow dependencies
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowDependenciesTest() throws ApiException {
        var flow = createSimpleFlow();
        String namespace = flow.getNamespace();
        String id = flow.getId();
        Boolean destinationOnly = true;
        Boolean expandAll = false;

        kestraClient().flows().getFlowDependencies(namespace, id, destinationOnly, expandAll, MAIN_TENANT);
    }
    /**
     * Retrieve flow dependencies
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFlowDependenciesFromNamespaceTest() throws ApiException {
        var flow = createSimpleFlow();

        String namespace = flow.getNamespace();
        Boolean destinationOnly = true;

        FlowTopologyGraph response = kestraClient().flows().getFlowDependenciesFromNamespace(namespace, destinationOnly, MAIN_TENANT);
    }
    /**
     * Get a flow task
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTaskFromFlowTest() throws ApiException {
        var flow = createSimpleFlow();
        String namespace = flow.getNamespace();
        String id = flow.getId();
        String taskId = flow.getTasks().get(0).getId();

        Integer revision = null;
        Task response = kestraClient().flows().getTaskFromFlow(namespace, id, taskId, MAIN_TENANT, revision);
    }
    /**
     *     Import flows as a ZIP archive of yaml sources or a multi-objects YAML file.     When sending a Yaml that contains one or more flows, a list of index is returned.     When sending a ZIP archive, a list of files that couldn&#39;t be imported is returned.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    @Disabled
    public void importFlowsTest() throws ApiException {
        File fileUpload = null;
        List<String> response = kestraClient().flows().importFlows(MAIN_TENANT, fileUpload);

        // FIXME not sure the impl can ever work
    }
    /**
     * List all distinct namespaces
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listDistinctNamespacesTest() throws ApiException {
        var flow = createSimpleFlow();

        String q = null;
        List<String> response = kestraClient().flows().listDistinctNamespaces(MAIN_TENANT, q);
    }
    /**
     * Get revisions for a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listFlowRevisionsTest() throws ApiException {
        var flow = createSimpleFlow();

        String namespace = flow.getNamespace();
        String id = flow.getId();

        List<FlowWithSource> response = kestraClient().flows().listFlowRevisions(namespace, id, MAIN_TENANT);
    }
    /**
     * Retrieve all flows from a given namespace
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listFlowsByNamespaceTest() throws ApiException {
        var flow = createSimpleFlow();
        String namespace = flow.getNamespace();

        List<Flow> response = kestraClient().flows().listFlowsByNamespace(namespace, MAIN_TENANT);
    }
    /**
     * Search for flows
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchFlowsTest() throws ApiException {
        var flow = createSimpleFlow();

        Integer page = null;
        Integer size = null;

        List<String> sort = null;
        List<QueryFilter> filters = null;
        String q = null;
        List<FlowScope> scope = null;
        String namespace = flow.getNamespace();
        List<String> labels = null;
//        PagedResultsFlow response = kestraClient().flows().searchFlows(page, size, MAIN_TENANT, sort, filters, q, scope, namespace, labels); TODO
    }
    /**
     * Search for flows source code
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchFlowsBySourceCodeTest() throws ApiException {
        var flow = createSimpleFlow();
        Integer page = 1;
        Integer size = 10000;

        List<String> sort = null;
        String q = flow.getId();
        String namespace = flow.getNamespace();
        PagedResultsSearchResultFlow response = kestraClient().flows().searchFlowsBySourceCode(page, size, MAIN_TENANT, sort, q, namespace);

        assertThat(response.getResults().stream().map(x -> x.getModel().getId())).containsOnly(flow.getId());
    }
    /**
     * Update a flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateFlowTest() throws ApiException {
        var flowBody = getSimpleFlow();
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, flowBody);
        assertFlowExist(flow);
        assertThat(flow).extracting(FlowWithSource::getDescription).isEqualTo("simple_flow_description");

        String id = flow.getId();
        String namespace = flow.getNamespace();
        String body = flowBody.replace("simple_flow_description", "simple_flow_description_updated");
        var response = kestraClient().flows().updateFlow(id, namespace, MAIN_TENANT, body);

        assertThat(response).extracting(UpdateFlow200Response::getDescription).isEqualTo("simple_flow_description_updated");
    }

    /**
     * Validate a list of flows
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateFlowsTest_simpleFlow() throws ApiException {
        var flow = getSimpleFlow();

        String body = flow;
        kestraClient().flows().validateFlows(MAIN_TENANT, body);
    }

    @Test
    public void validateFlowsTest_completeFlow() throws ApiException {
        var flow = getCompleteFlow();

        String body = flow;
        kestraClient().flows().validateFlows(MAIN_TENANT, body);
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
    public void validateTriggerTest() throws ApiException, JsonProcessingException {

        var triggerJson = """
                {
                    "id": "monthly",
                    "type": "io.kestra.plugin.core.trigger.Schedule",
                    "cron": "0 9 1 * *"
                }
            """;
        ValidateConstraintViolation response = kestraClient().flows().validateTrigger(MAIN_TENANT, new ObjectMapper().readValue(triggerJson, Object.class));

        assertThat(response.getConstraints()).isNullOrEmpty();
        assertThat(response.getWarnings()).isNullOrEmpty();
    }

    @Test
    public void validateTriggerTest_invalid() throws ApiException, JsonProcessingException {

        var triggerJson = """
                {
                    "id": "monthly",
                    "type": "io.kestra.plugin.core.trigger.InvalidType",
                    "cron": "0 9 1 * *"
                }
            """;
        ValidateConstraintViolation response = kestraClient().flows().validateTrigger(MAIN_TENANT, new ObjectMapper().readValue(triggerJson, Object.class));

        assertThat(response.getConstraints()).contains("Invalid type: io.kestra.plugin.core.trigger.InvalidType");
    }

    private static FlowWithSource createSimpleFlow() throws ApiException {
        var flow = kestraClient().flows().createFlow(MAIN_TENANT, getSimpleFlow());
        assertFlowExist(flow);
        return flow;
    }

    private static void assertFlowExist(FlowWithSource flow) {
        assertThatCode(() -> kestraClient().flows().getFlow(flow.getNamespace(), flow.getId(), false, false, MAIN_TENANT, null))
            .as("assert flow exists")
            .doesNotThrowAnyException();
    }

    private static void assertFlowDoesNotExist(FlowWithSource flow) {
        assertThatThrownBy(() -> kestraClient().flows().getFlow(flow.getNamespace(), flow.getId(), false, false, MAIN_TENANT, null)).isInstanceOf(ApiException.class)
            .as("assert flow does not exist")
            .hasMessageContaining("Not Found");
    }
}
