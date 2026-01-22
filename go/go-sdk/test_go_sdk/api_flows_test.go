package main

import (
	"context"
	"os"
	"strings"
	"testing"

	openapiclient "github.com/kestra-io/client-sdk/go/go-sdk"
	"github.com/stretchr/testify/require"
)

// Helper assertion functions
func assertFlowExist(t *testing.T, ctx context.Context, namespace string, flowId string) {
	_, _, err := KestraTestApiClient().FlowsAPI.Flow(ctx, namespace, flowId, MAIN_TENANT).Execute()
	require.NoError(t, err, "Flow should exist")
}

func assertFlowDoesNotExist(t *testing.T, ctx context.Context, namespace string, flowId string) {
	_, _, err := KestraTestApiClient().FlowsAPI.Flow(ctx, namespace, flowId, MAIN_TENANT).Execute()
	require.Error(t, err, "Flow should not exist after deletion")
}

func TestFlowsAPI_All(t *testing.T) {

	t.Run("bulkUpdateFlowsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()

		// Create initial flow
		simpleFlowYaml := LOG_FLOW(flowId, namespace)
		flowWithDesc := strings.Replace(simpleFlowYaml, "Hello World!", "simple_flow_description", 1)
		flow, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(flowWithDesc).Execute()
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.Equal(t, "simple_flow_description", flow.GetDescription())

		// Update the description via bulk update
		updatedDesc := strings.Replace(flowWithDesc, "simple_flow_description", "simple_flow_description_updated", 1)

		response, _, err := KestraTestApiClient().FlowsAPI.BulkUpdateFlows(ctx, MAIN_TENANT).Namespace(namespace).Body(updatedDesc).Execute()
		require.NoError(t, err)
		require.Greater(t, len(response), 0)
		require.Equal(t, "simple_flow_description_updated", response[0].GetDescription())
	})

	t.Run("createFlowTest_simple", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()

		body := LOG_FLOW(flowId, namespace)
		response, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(body).Execute()
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.NotNil(t, response)
	})

	t.Run("createFlowTest_full", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()

		body := SIMPLE_BUT_LONG_FLOW(flowId, namespace)
		response, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(body).Execute()
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.NotNil(t, response)
	})

	t.Run("deleteFlowTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		_, err := KestraTestApiClient().FlowsAPI.DeleteFlow(ctx, namespace, flowId, MAIN_TENANT).Execute()
		require.NoError(t, err)

		assertFlowDoesNotExist(t, ctx, namespace, flowId)
	})

	t.Run("deleteFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []openapiclient.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.DeleteFlowsByIds(ctx, MAIN_TENANT).IdWithNamespace(idWithNamespace).Execute()
		require.NoError(t, err)

		assertFlowDoesNotExist(t, ctx, namespace, flowId)
	})

	t.Run("deleteFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []openapiclient.QueryFilter{
			{
				Field:     ptr(openapiclient.QUERYFILTERFIELD_NAMESPACE),
				Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS),
				Value:     namespace,
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.DeleteFlowsByQuery(ctx, MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)

		assertFlowDoesNotExist(t, ctx, namespace, flowId)
	})

	t.Run("disableFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []openapiclient.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.DisableFlowsByIds(ctx, MAIN_TENANT).IdWithNamespace(idWithNamespace).Execute()
		require.NoError(t, err)
	})

	t.Run("disableFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []openapiclient.QueryFilter{
			{
				Field:     ptr(openapiclient.QUERYFILTERFIELD_NAMESPACE),
				Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS),
				Value:     namespace,
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.DisableFlowsByQuery(ctx, MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)
	})

	t.Run("enableFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []openapiclient.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.EnableFlowsByIds(ctx, MAIN_TENANT).IdWithNamespace(idWithNamespace).Execute()
		require.NoError(t, err)
	})

	t.Run("enableFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []openapiclient.QueryFilter{
			{
				Field:     ptr(openapiclient.QUERYFILTERFIELD_NAMESPACE),
				Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS),
				Value:     namespace,
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.EnableFlowsByQuery(ctx, MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)
	})

	t.Run("exportFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []openapiclient.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.ExportFlowsByIds(ctx, MAIN_TENANT).IdWithNamespace(idWithNamespace).Execute()
		require.NoError(t, err)
	})

	t.Run("exportFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []openapiclient.QueryFilter{
			{
				Field:     ptr(openapiclient.QUERYFILTERFIELD_NAMESPACE),
				Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS),
				Value:     namespace,
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.ExportFlowsByQuery(ctx, MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)
	})

	t.Run("generateFlowGraphTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		_, _, err := KestraTestApiClient().FlowsAPI.GenerateFlowGraph(ctx, namespace, flowId, MAIN_TENANT).Execute()
		require.NoError(t, err)
	})

	t.Run("generateFlowGraphFromSourceTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()

		flow := LOG_FLOW(flowId, namespace)

		_, _, err := KestraTestApiClient().FlowsAPI.GenerateFlowGraphFromSource(ctx, MAIN_TENANT).Body(flow).Execute()
		require.NoError(t, err)
	})

	t.Run("getFlowTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		result, _, err := KestraTestApiClient().FlowsAPI.Flow(ctx, namespace, flowId, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, result.GetId(), flowId)
	})

	t.Run("getFlowDependenciesTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		_, _, err := KestraTestApiClient().FlowsAPI.FlowDependencies(ctx, namespace, flowId, MAIN_TENANT).Execute()
		require.NoError(t, err)
	})

	t.Run("getFlowDependenciesFromNamespaceTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		response, _, err := KestraTestApiClient().FlowsAPI.FlowDependenciesFromNamespace(ctx, namespace, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, response)
	})

	t.Run("getTaskFromFlowTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		flow, _, err := KestraTestApiClient().FlowsAPI.Flow(ctx, namespace, flowId, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Greater(t, len(flow.Tasks), 0, "Flow should have at least one task")
		taskId := flow.Tasks[0].Id

		_, _, err = KestraTestApiClient().FlowsAPI.TaskFromFlow(ctx, namespace, flowId, taskId, MAIN_TENANT).Execute()
		require.NoError(t, err)
	})

	t.Run("importFlowsTest", func(t *testing.T) {
		namespace1 := randomId()
		flowId1 := randomId()
		namespace2 := randomId()
		flowId2 := randomId()
		ctx := GetAuthContext()

		fileContent := LOG_FLOW(flowId1, namespace1) + "\n---\n" + LOG_FLOW(flowId2, namespace2)

		tmpFile, err := os.CreateTemp("", "flows-*.yaml")
		require.NoError(t, err)
		defer func() { _ = os.Remove(tmpFile.Name()) }()

		_, err = tmpFile.WriteString(fileContent)
		require.NoError(t, err)
		_ = tmpFile.Close()

		file, err := os.Open(tmpFile.Name())
		require.NoError(t, err)
		defer func() { _ = file.Close() }()

		_, _, err = KestraTestApiClient().FlowsAPI.ImportFlows(ctx, MAIN_TENANT).FileUpload(file).Execute()
		require.NoError(t, err)

		assertFlowExist(t, ctx, namespace1, flowId1)
		assertFlowExist(t, ctx, namespace2, flowId2)
	})

	t.Run("listDistinctNamespacesTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		_, _, err := KestraTestApiClient().FlowsAPI.ListDistinctNamespaces(ctx, MAIN_TENANT).Execute()
		require.NoError(t, err)
	})

	t.Run("listFlowRevisionsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		_, _, err := KestraTestApiClient().FlowsAPI.ListFlowRevisions(ctx, namespace, flowId, MAIN_TENANT).Execute()
		require.NoError(t, err)
	})

	t.Run("listFlowsByNamespaceTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		_, _, err := KestraTestApiClient().FlowsAPI.ListFlowsByNamespace(ctx, namespace, MAIN_TENANT).Execute()
		require.NoError(t, err)
	})

	t.Run("searchFlowsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []openapiclient.QueryFilter{
			{
				Field:     ptr(openapiclient.QUERYFILTERFIELD_NAMESPACE),
				Operation: ptr(openapiclient.QUERYFILTEROP_EQUALS),
				Value:     namespace,
			},
		}
		_, _, err := KestraTestApiClient().FlowsAPI.SearchFlows(ctx, MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)
	})

	t.Run("searchFlowsBySourceCodeTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		searchResponse, _, err := KestraTestApiClient().FlowsAPI.SearchFlowsBySourceCode(ctx, MAIN_TENANT).Q(flowId).Namespace(namespace).Execute()
		require.NoError(t, err)
		require.NotNil(t, searchResponse.Results)
		require.Greater(t, len(searchResponse.Results), 0)

		// Verify search results contain our flow - matching Java: assertThat(response.getResults().stream().map(x -> x.getModel().getId())).containsOnly(flow.getId());
		foundIds := []string{}
		for _, result := range searchResponse.Results {
			foundIds = append(foundIds, result.GetModel().Id)
		}
		require.Contains(t, foundIds, flowId)
	})

	t.Run("updateFlowTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()

		// Create flow with original description
		flowWithDesc := strings.Replace(LOG_FLOW(flowId, namespace), "Hello World!", "simple_flow_description", 1)
		flow, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(flowWithDesc).Execute()
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.Equal(t, "simple_flow_description", flow.GetDescription())

		// Update the description - matching Java: body = flowBody.replace("simple_flow_description", "simple_flow_description_updated");
		updatedDesc := strings.Replace(flowWithDesc, "simple_flow_description", "simple_flow_description_updated", 1)
		response, _, err := KestraTestApiClient().FlowsAPI.UpdateFlow(ctx, namespace, flowId, MAIN_TENANT).Body(updatedDesc).Execute()
		require.NoError(t, err)

		require.Equal(t, "simple_flow_description_updated", response.GetDescription())
	})

	t.Run("validateFlowsTest_simpleFlow", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := randomId()
		flowId := randomId()
		flow := LOG_FLOW(flowId, namespace)
		body := flow

		_, _, err := KestraTestApiClient().FlowsAPI.ValidateFlows(ctx, MAIN_TENANT).Body(body).Execute()
		require.NoError(t, err)
	})

	t.Run("validateFlowsTest_completeFlow", func(t *testing.T) {
		ctx := GetAuthContext()

		namespace := randomId()
		flowId := randomId()
		flow := SIMPLE_BUT_LONG_FLOW(flowId, namespace)
		body := flow

		_, _, err := KestraTestApiClient().FlowsAPI.ValidateFlows(ctx, MAIN_TENANT).Body(body).Execute()
		require.NoError(t, err)
	})

	t.Run("validateTaskTest", func(t *testing.T) {
		ctx := GetAuthContext()

		taskJson := map[string]interface{}{
			"id":      "task_one",
			"type":    "io.kestra.plugin.core.log.Log",
			"message": "strange---string",
		}

		response, _, err := KestraTestApiClient().FlowsAPI.
			ValidateTask(ctx, MAIN_TENANT).
			Section(openapiclient.FLOWCONTROLLERTASKVALIDATIONTYPE_TASKS).
			Body(taskJson).
			Execute()
		require.NoError(t, err)

		require.Empty(t, response.GetConstraints())
		require.Empty(t, response.GetWarnings())
	})

	t.Run("validateTaskTest_invalid", func(t *testing.T) {
		ctx := GetAuthContext()

		taskJson := map[string]interface{}{
			"id":      "task_one",
			"type":    "io.kestra.plugin.core.log.InvalidTask",
			"message": "strange---string",
		}

		response, _, err := KestraTestApiClient().FlowsAPI.
			ValidateTask(ctx, MAIN_TENANT).
			Section(openapiclient.FLOWCONTROLLERTASKVALIDATIONTYPE_TASKS).
			Body(taskJson).
			Execute()
		require.NoError(t, err)

		require.Contains(t, response.GetConstraints(), "Invalid type: io.kestra.plugin.core.log.InvalidTask")
	})

	t.Run("validateTriggerTest", func(t *testing.T) {
		ctx := GetAuthContext()

		triggerJson := map[string]interface{}{
			"id":   "monthly",
			"type": "io.kestra.plugin.core.trigger.Schedule",
			"cron": "0 9 1 * *",
		}

		response, _, err := KestraTestApiClient().FlowsAPI.ValidateTrigger(ctx, MAIN_TENANT).Body(triggerJson).Execute()
		require.NoError(t, err)

		require.Empty(t, response.GetConstraints())
		require.Empty(t, response.GetWarnings())
	})

	t.Run("validateTriggerTest_invalid", func(t *testing.T) {
		ctx := GetAuthContext()

		triggerJson := map[string]interface{}{
			"id":   "monthly",
			"type": "io.kestra.plugin.core.trigger.InvalidType",
			"cron": "0 9 1 * *",
		}

		response, _, err := KestraTestApiClient().FlowsAPI.ValidateTrigger(ctx, MAIN_TENANT).Body(triggerJson).Execute()
		require.NoError(t, err)

		require.Contains(t, response.GetConstraints(), "Invalid type: io.kestra.plugin.core.trigger.InvalidType")
	})

}
