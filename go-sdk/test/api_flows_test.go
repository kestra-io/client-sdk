package test

import (
	"context"
	"errors"
	"fmt"
	"os"
	"strings"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
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

	// Kestra 2.0 serializes flow labels as a list of {key, value} pairs, while
	// the spec only declares the map form. Deserializing either shape has to
	// work, or every labelled flow fails to read back at all.
	t.Run("createFlowTest_withLabels", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()

		body := fmt.Sprintf(`
id: %s
namespace: %s
labels:
  phase: created
tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: hello
`, flowId, namespace)

		created, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, body)
		require.NoError(t, err)
		require.Equal(t, "created", created.GetLabels().AdditionalProperties["phase"])

		read, err := KestraTestClient().Flows().Flow(ctx, namespace, flowId, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.Equal(t, "created", read.GetLabels().AdditionalProperties["phase"])
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

		searchResponse, err := KestraTestClient().Flows().SearchFlowsBySourceCode(ctx, MAIN_TENANT, nil, nil, nil, kestra_api_client.PtrString(flowId), kestra_api_client.PtrString(namespace), nil, nil, nil, nil)
		require.NoError(t, err)
		require.NotNil(t, searchResponse.Results)
		require.Greater(t, len(searchResponse.Results), 0)

		foundIds := []string{}
		for _, result := range searchResponse.Results {
			foundIds = append(foundIds, result.GetId())
		}
		require.Contains(t, foundIds, flowId)
	})

	// Pins both sides of the server's page-size cap: the cap itself is a valid
	// request, above it the server answers 422 instead of clamping. A test asking
	// for "everything" with size=10000 used to work and now breaks, so keep the
	// boundary asserted rather than rediscovering it endpoint by endpoint.
	t.Run("searchFlowsBySourceCodePageSizeCapTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		atCap, err := KestraTestClient().Flows().SearchFlowsBySourceCode(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(MAX_PAGE_SIZE), nil, kestra_api_client.PtrString(flowId), kestra_api_client.PtrString(namespace), nil, nil, nil, nil)
		require.NoError(t, err, "size == MAX_PAGE_SIZE must be accepted")
		require.NotNil(t, atCap.Results)
		foundIds := []string{}
		for _, result := range atCap.Results {
			foundIds = append(foundIds, result.GetId())
		}
		require.Contains(t, foundIds, flowId)

		_, err = KestraTestClient().Flows().SearchFlowsBySourceCode(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(MAX_PAGE_SIZE+1), nil, kestra_api_client.PtrString(flowId), kestra_api_client.PtrString(namespace), nil, nil, nil, nil)
		require.Error(t, err, "size > MAX_PAGE_SIZE must be rejected")
		var apiErr *kestra_api_client.ApiError
		require.True(t, errors.As(err, &apiErr))
		require.Equal(t, 422, apiErr.StatusCode)
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

	t.Run("createAndUpdateFlowFromObjectTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		message := "Hello {{ flow.id }}\nsecond line"

		// A plain map with a plugin-specific task property (Log.message).
		flow := map[string]interface{}{
			"id":          flowId,
			"namespace":   namespace,
			"description": "from_object_description",
			"tasks": []map[string]interface{}{
				{"id": "hello", "type": "io.kestra.plugin.core.log.Log", "message": message},
			},
		}
		created, err := KestraTestClient().Flows().CreateFlowFromObject(ctx, MAIN_TENANT, flow, nil)
		require.NoError(t, err)
		require.Equal(t, flowId, created.GetId())
		require.Equal(t, namespace, created.GetNamespace())
		require.Equal(t, "from_object_description", created.GetDescription())
		require.Len(t, created.Tasks, 1)
		require.Equal(t, "io.kestra.plugin.core.log.Log", created.Tasks[0].Type)
		// The plugin-specific `message` (expression + multi-line) round-trips from the server.
		require.Equal(t, message, created.Tasks[0].AdditionalProperties["message"])

		updatedMessage := "updated {{ flow.namespace }}"
		flow["description"] = "from_object_description_updated"
		flow["tasks"] = []map[string]interface{}{
			{"id": "hello", "type": "io.kestra.plugin.core.log.Log", "message": updatedMessage},
		}
		updated, err := KestraTestClient().Flows().UpdateFlowFromObject(ctx, namespace, flowId, MAIN_TENANT, flow, nil)
		require.NoError(t, err)
		require.Equal(t, flowId, updated.GetId())
		require.Equal(t, "from_object_description_updated", updated.GetDescription())
		require.Equal(t, updatedMessage, updated.Tasks[0].AdditionalProperties["message"])
		require.Equal(t, created.GetRevision()+1, updated.GetRevision())

		fetched, err := KestraTestClient().Flows().Flow(ctx, namespace, flowId, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.Equal(t, updatedMessage, fetched.Tasks[0].AdditionalProperties["message"])
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

	t.Run("expressionsTest", func(t *testing.T) {
		t.Skip("Expressions endpoint requires specific flow YAML context")
	})

	t.Run("exportFlowsByQueryCsvTest", func(t *testing.T) {
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
		csv, err := KestraTestClient().Flows().ExportFlowsByQueryCsv(ctx, MAIN_TENANT, filters)
		if err != nil {
			// Flow CSV export is gated behind an export permission that the EE image
			// does not grant to the bootstrap super-admin (403), mirroring the known
			// export-permission gap. The wrapper is still exercised for coverage.
			var apiErr *kestra_api_client.ApiError
			if errors.As(err, &apiErr) && apiErr.StatusCode == 403 {
				t.Skipf("flows CSV export is permission-gated on this image: %v", err)
			}
			require.NoError(t, err)
		}
		require.Contains(t, csv, flowId, "CSV export should contain the created flow id")
	})

	t.Run("flowHashesByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		ids := []kestra_api_client.IdWithNamespace{
			{
				Id:        ptr(flowId),
				Namespace: ptr(namespace),
			},
		}
		res, err := KestraTestClient().Flows().FlowHashesByIds(ctx, MAIN_TENANT, ids)
		require.NoError(t, err)
		require.NotNil(t, res)
		// Response carries a "hashes" collection keyed/entries for the requested flow.
		require.Contains(t, res, "hashes")
		require.NotNil(t, res["hashes"])
	})

	t.Run("previewReplaceBySourceCodeTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		body := map[string]interface{}{
			"query":         flowId,
			"caseSensitive": true,
			"wholeWord":     false,
			"regex":         false,
			"namespace":     namespace,
			"replacement":   flowId,
		}
		res, err := KestraTestClient().Flows().PreviewReplaceBySourceCode(ctx, MAIN_TENANT, body)
		require.NoError(t, err)
		require.NotNil(t, res)
		// The preview reports the matched flows and a running match tally.
		require.Contains(t, res, "flows")
		flows, ok := res["flows"].([]interface{})
		require.True(t, ok, "preview response should carry a flows array: %+v", res)
		require.NotEmpty(t, flows, "the created flow must appear in the preview")
		require.Equal(t, float64(1), res["totalMatches"], "exactly one occurrence of the flow id should match")
	})

	t.Run("applyReplaceBySourceCodeTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		// Replace the log message text; scope the apply to the single created flow.
		body := map[string]interface{}{
			"query":         "Hello World!",
			"caseSensitive": false,
			"wholeWord":     false,
			"regex":         false,
			"replacement":   "Hello Kestra!",
			"flows": []map[string]interface{}{
				{"id": flowId, "namespace": namespace},
			},
		}
		res, err := KestraTestClient().Flows().ApplyReplaceBySourceCode(ctx, MAIN_TENANT, body)
		require.NoError(t, err)
		require.NotNil(t, res)
	})

	t.Run("replaceLineBySourceCodeTest", func(t *testing.T) {
		t.Skip("needs an exact matched line/column from a prior source-search preview")
	})

	t.Run("previewPoliciesTest", func(t *testing.T) {
		t.Skip("needs FEATURE_POLICIES license and a configured governance policy")
	})

	t.Run("promoteTest", func(t *testing.T) {
		t.Skip("needs configured promotion target")
	})

	t.Run("promoteByIdsTest", func(t *testing.T) {
		t.Skip("needs configured promotion target")
	})

	t.Run("reportPromoteTest", func(t *testing.T) {
		t.Skip("needs configured promotion target")
	})

	t.Run("listPromotionsTest", func(t *testing.T) {
		t.Skip("needs configured promotion target")
	})

	t.Run("promoteDiffTest", func(t *testing.T) {
		t.Skip("needs configured promotion target")
	})

}
