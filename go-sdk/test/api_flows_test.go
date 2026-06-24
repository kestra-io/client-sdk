package test

import (
	"context"
	"os"
	"strings"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// Helper assertion functions
func assertFlowExist(t *testing.T, ctx context.Context, namespace string, flowId string) {
	_, err := KestraTestClient().Flows().Flow(ctx, namespace, flowId, MAIN_TENANT, nil, nil, nil)
	require.NoError(t, err, "Flow should exist")
}

func assertFlowDoesNotExist(t *testing.T, ctx context.Context, namespace string, flowId string) {
	_, err := KestraTestClient().Flows().Flow(ctx, namespace, flowId, MAIN_TENANT, nil, nil, nil)
	require.Error(t, err, "Flow should not exist after deletion")
}

func TestFlowsAPI_All(t *testing.T) {

	t.Run("bulkUpdateFlowsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()

		// Create initial flow
		simpleFlowYaml := LOG_FLOW(flowId, namespace)
		flowWithDesc := strings.Replace(simpleFlowYaml, "Hello World!", "simple_flow_description", 1)
		flow, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, flowWithDesc)
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.Equal(t, "simple_flow_description", flow.GetDescription())

		// Update the description via bulk update
		updatedDesc := strings.Replace(flowWithDesc, "simple_flow_description", "simple_flow_description_updated", 1)

		response, err := KestraTestClient().Flows().BulkUpdateFlows(ctx, MAIN_TENANT, nil, kestra_api_client.PtrString(namespace), nil, updatedDesc)
		require.NoError(t, err)
		require.Greater(t, len(response), 0)
		require.Equal(t, "simple_flow_description_updated", response[0].GetDescription())
	})

	t.Run("createFlowTest_simple", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()

		body := LOG_FLOW(flowId, namespace)
		response, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, body)
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.NotNil(t, response)
	})

	t.Run("createFlowTest_full", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()

		body := SIMPLE_BUT_LONG_FLOW(flowId, namespace)
		response, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, body)
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.NotNil(t, response)
	})

	t.Run("deleteFlowTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		err := KestraTestClient().Flows().DeleteFlow(ctx, namespace, flowId, MAIN_TENANT)
		require.NoError(t, err)

		assertFlowDoesNotExist(t, ctx, namespace, flowId)
	})

	t.Run("deleteFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []kestra_api_client.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, err := KestraTestClient().Flows().DeleteFlowsByIds(ctx, MAIN_TENANT, idWithNamespace)
		require.NoError(t, err)

		assertFlowDoesNotExist(t, ctx, namespace, flowId)
	})

	t.Run("deleteFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     namespace,
			},
		}
		_, err := KestraTestClient().Flows().DeleteFlowsByQuery(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)

		assertFlowDoesNotExist(t, ctx, namespace, flowId)
	})

	t.Run("disableFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []kestra_api_client.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, err := KestraTestClient().Flows().DisableFlowsByIds(ctx, MAIN_TENANT, idWithNamespace)
		require.NoError(t, err)
	})

	t.Run("disableFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     namespace,
			},
		}
		_, err := KestraTestClient().Flows().DisableFlowsByQuery(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)
	})

	t.Run("enableFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []kestra_api_client.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, err := KestraTestClient().Flows().EnableFlowsByIds(ctx, MAIN_TENANT, idWithNamespace)
		require.NoError(t, err)
	})

	t.Run("enableFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     namespace,
			},
		}
		_, err := KestraTestClient().Flows().EnableFlowsByQuery(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)
	})

	t.Run("exportFlowsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		idWithNamespace := []kestra_api_client.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		_, err := KestraTestClient().Flows().ExportFlowsByIds(ctx, MAIN_TENANT, idWithNamespace)
		require.NoError(t, err)
	})

	t.Run("exportFlowsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     namespace,
			},
		}
		_, err := KestraTestClient().Flows().ExportFlowsByQuery(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)
	})

	t.Run("generateFlowGraphTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		_, err := KestraTestClient().Flows().GenerateFlowGraph(ctx, namespace, flowId, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
	})

	t.Run("generateFlowGraphFromSourceTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()

		flow := LOG_FLOW(flowId, namespace)

		_, err := KestraTestClient().Flows().GenerateFlowGraphFromSource(ctx, MAIN_TENANT, flow, nil)
		require.NoError(t, err)
	})

	t.Run("getFlowTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		result, err := KestraTestClient().Flows().Flow(ctx, namespace, flowId, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.Equal(t, result.GetId(), flowId)
	})

	t.Run("getFlowDependenciesTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		_, err := KestraTestClient().Flows().FlowDependencies(ctx, namespace, flowId, MAIN_TENANT, nil, nil)
		require.NoError(t, err)
	})

	t.Run("getFlowDependenciesFromNamespaceTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		response, err := KestraTestClient().Flows().FlowDependenciesFromNamespace(ctx, namespace, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.NotNil(t, response)
	})

	t.Run("getTaskFromFlowTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		flow, err := KestraTestClient().Flows().Flow(ctx, namespace, flowId, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.Greater(t, len(flow.Tasks), 0, "Flow should have at least one task")
		taskId := flow.Tasks[0].Id

		_, err = KestraTestClient().Flows().TaskFromFlow(ctx, namespace, flowId, taskId, MAIN_TENANT, nil)
		require.NoError(t, err)
	})

	t.Run("importFlowsTest", func(t *testing.T) {
		namespace1 := randomId()
		flowId1 := randomId()
		namespace2 := randomId()
		flowId2 := randomId()
		ctx := context.Background()

		fileContent := LOG_FLOW(flowId1, namespace1) + "\n---\n" + LOG_FLOW(flowId2, namespace2)

		tmpFile, err := os.CreateTemp("", "flows-*.yaml")
		require.NoError(t, err)
		defer func() { _ = os.Remove(tmpFile.Name()) }()

		_, err = tmpFile.WriteString(fileContent)
		require.NoError(t, err)
		_ = tmpFile.Close()

		_, err = KestraTestClient().Flows().ImportFlows(ctx, MAIN_TENANT, nil, tmpFile.Name())
		require.NoError(t, err)

		assertFlowExist(t, ctx, namespace1, flowId1)
		assertFlowExist(t, ctx, namespace2, flowId2)
	})

	t.Run("listDistinctNamespacesTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		_, err := KestraTestClient().Flows().ListDistinctNamespaces(ctx, MAIN_TENANT, nil)
		require.NoError(t, err)
	})

	t.Run("listFlowRevisionsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		_, err := KestraTestClient().Flows().ListFlowRevisions(ctx, namespace, flowId, MAIN_TENANT, nil)
		require.NoError(t, err)
	})

	t.Run("listFlowsByNamespaceTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		_, err := KestraTestClient().Flows().ListFlowsByNamespace(ctx, namespace, MAIN_TENANT)
		require.NoError(t, err)
	})

	t.Run("searchFlowsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     namespace,
			},
		}
		_, err := KestraTestClient().Flows().SearchFlows(ctx, MAIN_TENANT, nil, nil, nil, filters)
		require.NoError(t, err)
	})

	t.Run("searchFlowsBySourceCodeTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		searchResponse, err := KestraTestClient().Flows().SearchFlowsBySourceCode(ctx, MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrString(flowId), kestra_api_client.PtrString(namespace))
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
		ctx := context.Background()

		// Create flow with original description
		flowWithDesc := strings.Replace(LOG_FLOW(flowId, namespace), "Hello World!", "simple_flow_description", 1)
		flow, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, flowWithDesc)
		require.NoError(t, err)
		assertFlowExist(t, ctx, namespace, flowId)
		require.Equal(t, "simple_flow_description", flow.GetDescription())

		// Update the description - matching Java: body = flowBody.replace("simple_flow_description", "simple_flow_description_updated");
		updatedDesc := strings.Replace(flowWithDesc, "simple_flow_description", "simple_flow_description_updated", 1)
		response, err := KestraTestClient().Flows().UpdateFlow(ctx, namespace, flowId, MAIN_TENANT, updatedDesc)
		require.NoError(t, err)

		require.Equal(t, "simple_flow_description_updated", response.GetDescription())
	})

	t.Run("validateFlowsTest_simpleFlow", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		flowId := randomId()
		body := LOG_FLOW(flowId, namespace)

		_, err := KestraTestClient().Flows().ValidateFlows(ctx, MAIN_TENANT, body)
		require.NoError(t, err)
	})

	t.Run("validateFlowsTest_completeFlow", func(t *testing.T) {
		ctx := context.Background()

		namespace := randomId()
		flowId := randomId()
		body := SIMPLE_BUT_LONG_FLOW(flowId, namespace)

		_, err := KestraTestClient().Flows().ValidateFlows(ctx, MAIN_TENANT, body)
		require.NoError(t, err)
	})

	t.Run("validateTaskTest", func(t *testing.T) {
		ctx := context.Background()

		taskJson := map[string]interface{}{
			"id":      "task_one",
			"type":    "io.kestra.plugin.core.log.Log",
			"message": "strange---string",
		}

		response, err := KestraTestClient().Flows().ValidateTask(ctx, string(kestra_api_client.FLOWCONTROLLERTASKVALIDATIONTYPE_TASKS), MAIN_TENANT, taskJson)
		require.NoError(t, err)

		require.Empty(t, response.GetConstraints())
		require.Empty(t, response.GetWarnings())
	})

	t.Run("validateTaskTest_invalid", func(t *testing.T) {
		ctx := context.Background()

		taskJson := map[string]interface{}{
			"id":      "task_one",
			"type":    "io.kestra.plugin.core.log.InvalidTask",
			"message": "strange---string",
		}

		response, err := KestraTestClient().Flows().ValidateTask(ctx, string(kestra_api_client.FLOWCONTROLLERTASKVALIDATIONTYPE_TASKS), MAIN_TENANT, taskJson)
		require.NoError(t, err)

		require.Contains(t, response.GetConstraints(), "Invalid type: io.kestra.plugin.core.log.InvalidTask")
	})

	t.Run("validateTriggerTest", func(t *testing.T) {
		ctx := context.Background()

		triggerJson := map[string]interface{}{
			"id":   "monthly",
			"type": "io.kestra.plugin.core.trigger.Schedule",
			"cron": "0 9 1 * *",
		}

		response, err := KestraTestClient().Flows().ValidateTrigger(ctx, MAIN_TENANT, triggerJson)
		require.NoError(t, err)

		require.Empty(t, response.GetConstraints())
		require.Empty(t, response.GetWarnings())
	})

	t.Run("validateTriggerTest_invalid", func(t *testing.T) {
		ctx := context.Background()

		triggerJson := map[string]interface{}{
			"id":   "monthly",
			"type": "io.kestra.plugin.core.trigger.InvalidType",
			"cron": "0 9 1 * *",
		}

		response, err := KestraTestClient().Flows().ValidateTrigger(ctx, MAIN_TENANT, triggerJson)
		require.NoError(t, err)

		require.Contains(t, response.GetConstraints(), "Invalid type: io.kestra.plugin.core.trigger.InvalidType")
	})

	t.Run("listDeprecatedTest", func(t *testing.T) {
		ctx := context.Background()
		result, err := KestraTestClient().Flows().ListDeprecated(ctx, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("deleteRevisionsTest", func(t *testing.T) {
		t.Skip("Deleting revisions requires specific revision IDs")
	})

	t.Run("updateFlowsInNamespaceTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		flowId := randomId()
		yamlBody := LOG_FLOW(flowId, namespace)
		result, err := KestraTestClient().Flows().UpdateFlowsInNamespace(ctx, namespace, MAIN_TENANT, yamlBody, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("searchConcurrencyLimitsTest", func(t *testing.T) {
		ctx := context.Background()
		result, err := KestraTestClient().Flows().SearchConcurrencyLimits(ctx, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, result)
	})

}
