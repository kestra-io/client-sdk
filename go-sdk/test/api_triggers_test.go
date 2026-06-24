package test

import (
	"context"
	"fmt"
	"testing"
	"time"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
	"github.com/stretchr/testify/require"
)

func createFlowWithTrigger(t *testing.T, ctx context.Context, flowId string, triggerId string, namespace string) {
	t.Helper()

	body := fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: hello
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT5S

triggers:
  - id: %s
    type: io.kestra.plugin.core.trigger.Schedule
    cron: "*/5 * * * *"
`, flowId, namespace, triggerId)

	_, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, body)
	require.NoError(t, err)

	time.Sleep(200 * time.Millisecond)
}

func triggerIdRef(namespace string, flowId string, triggerId string) kestra_api_client.TriggerControllerApiTriggerId {
	return kestra_api_client.TriggerControllerApiTriggerId{
		Namespace: kestra_api_client.PtrString(namespace),
		FlowId:    kestra_api_client.PtrString(flowId),
		TriggerId: kestra_api_client.PtrString(triggerId),
	}
}

func TestTriggersAPI_All(t *testing.T) {
	t.Run("disabledTriggersByIdsTest", func(t *testing.T) {
		flowId := "disabledTriggersByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		trigId := triggerIdRef(namespace, flowId, triggerId)
		req := kestra_api_client.TriggerControllerSetDisabledRequest{
			Triggers: []kestra_api_client.TriggerControllerApiTriggerId{trigId},
			Disabled: true,
		}
		resp, err := KestraTestClient().Triggers().DisabledTriggersByIds(ctx, MAIN_TENANT, req)
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("disabledTriggersByQueryTest", func(t *testing.T) {
		flowId := "disabledTriggersByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterTriggerId,
				Operation: kestra_api_client.OpContains,
				Value:     flowId,
			},
		}
		resp, err := KestraTestClient().Triggers().DisabledTriggersByQuery(ctx, MAIN_TENANT, kestra_api_client.PtrBool(true), filters)
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("pauseBackfillByQueryTest", func(t *testing.T) {
		flowId := "pauseBackfillByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterTriggerId,
				Operation: kestra_api_client.OpContains,
				Value:     flowId,
			},
		}
		resp, err := KestraTestClient().Triggers().PauseBackfillByQuery(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("restartTriggerTest", func(t *testing.T) {
		flowId := "restartTriggerTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		resp, err := KestraTestClient().Triggers().RestartTrigger(ctx, MAIN_TENANT, namespace, flowId, triggerId)
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("searchTriggersTest", func(t *testing.T) {
		flowId := "searchTriggersTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		filters := []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     namespace,
			},
		}
		page, err := KestraTestClient().Triggers().SearchTriggers(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, filters)
		require.NoError(t, err)
		require.NotNil(t, page)
	})

	t.Run("searchTriggersForFlowTest", func(t *testing.T) {
		flowId := "searchTriggersForFlowTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		page, err := KestraTestClient().Triggers().SearchTriggersForFlow(ctx, MAIN_TENANT, namespace, flowId, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10), nil, nil)
		require.NoError(t, err)
		require.NotNil(t, page)
	})

	t.Run("unlockTriggerTest", func(t *testing.T) {
		flowId := "unlockTriggerTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		_, err := KestraTestClient().Triggers().UnlockTrigger(ctx, MAIN_TENANT, namespace, flowId, triggerId)
		require.Error(t, err)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr)
		require.Equal(t, 409, apiErr.StatusCode)
	})

	t.Run("unlockTriggersByIdsTest", func(t *testing.T) {
		flowId := "unlockTriggersByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		trigId := triggerIdRef(namespace, flowId, triggerId)
		resp, err := KestraTestClient().Triggers().UnlockTriggersByIds(ctx, MAIN_TENANT, []kestra_api_client.TriggerControllerApiTriggerId{trigId})
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("unlockTriggersByQueryTest", func(t *testing.T) {
		flowId := "unlockTriggersByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		resp, err := KestraTestClient().Triggers().UnlockTriggersByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{})
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("unpauseBackfillByQueryTest", func(t *testing.T) {
		flowId := "unpauseBackfillByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		resp, err := KestraTestClient().Triggers().UnpauseBackfillByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{})
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("exportTriggersTest", func(t *testing.T) {
		flowId := "exportTriggersTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		csv, err := KestraTestClient().Triggers().ExportTriggers(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{
			{
				Field:     kestra_api_client.FilterNamespace,
				Operation: kestra_api_client.OpEquals,
				Value:     namespace,
			},
		})
		require.NoError(t, err)
		require.NotEmpty(t, csv)
	})

	t.Run("deleteTriggerTest", func(t *testing.T) {
		flowId := "deleteTriggerTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		err := KestraTestClient().Triggers().DeleteTrigger(ctx, MAIN_TENANT, namespace, flowId, triggerId)
		require.NoError(t, err)
	})

	t.Run("deleteTriggersByIdsTest", func(t *testing.T) {
		flowId := "deleteTriggersByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		trigId := triggerIdRef(namespace, flowId, triggerId)
		resp, err := KestraTestClient().Triggers().DeleteTriggersByIds(ctx, MAIN_TENANT, []kestra_api_client.TriggerControllerApiTriggerId{trigId})
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("deleteTriggersByQueryTest", func(t *testing.T) {
		flowId := "deleteTriggersByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := context.Background()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		req := kestra_api_client.DeleteTriggersByQueryRequest{
			Filters: []kestra_api_client.SearchFilter{
				{
					Field:     kestra_api_client.FilterNamespace,
					Operation: kestra_api_client.OpEquals,
					Value:     namespace,
				},
			},
		}
		resp, err := KestraTestClient().Triggers().DeleteTriggersByQuery(ctx, MAIN_TENANT, req)
		require.NoError(t, err)
		require.NotNil(t, resp)
	})
}
