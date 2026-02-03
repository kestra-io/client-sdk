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

	_, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(body).Execute()
	require.NoError(t, err)

	time.Sleep(200 * time.Millisecond)
}

func createBackfillForTrigger(ctx context.Context, flowId string, triggerId string, namespace string) (*kestra_api_client.Trigger, error) {
	now := time.Now().UTC()
	start := now.Add(-5 * time.Hour)

	backfill := kestra_api_client.Backfill{Start: start}
	trigger := kestra_api_client.Trigger{
		Namespace: namespace,
		FlowId:    flowId,
		TriggerId: triggerId,
		Date:      now,
	}
	trigger.SetBackfill(backfill)
	trigger.SetTenantId(MAIN_TENANT)

	updated, _, err := KestraTestApiClient().TriggersAPI.UpdateTrigger(ctx, MAIN_TENANT).Trigger(trigger).Execute()
	return updated, err
}

func triggerRef(namespace string, flowId string, triggerId string) kestra_api_client.Trigger {
	trigger := kestra_api_client.Trigger{
		Namespace: namespace,
		FlowId:    flowId,
		TriggerId: triggerId,
		Date:      time.Now().UTC(),
	}
	trigger.SetTenantId(MAIN_TENANT)
	return trigger
}

func TestTriggersAPI_All(t *testing.T) {
	t.Run("deleteBackfillTest", func(t *testing.T) {
		flowId := "deleteBackfillTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)
		time.Sleep(1 * time.Second)
		_, err := createBackfillForTrigger(ctx, flowId, triggerId, namespace)
		require.NoError(t, err)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.DeleteBackfill(ctx, MAIN_TENANT).Trigger(trigger).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("deleteBackfillByIdsTest", func(t *testing.T) {
		flowId := "deleteBackfillByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)
		_, err := createBackfillForTrigger(ctx, flowId, triggerId, namespace)
		require.NoError(t, err)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.DeleteBackfillByIds(ctx, MAIN_TENANT).Trigger([]kestra_api_client.Trigger{trigger}).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("deleteBackfillByQueryTest", func(t *testing.T) {
		flowId := "deleteBackfillByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)
		_, err := createBackfillForTrigger(ctx, flowId, triggerId, namespace)
		require.NoError(t, err)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     ptr(kestra_api_client.QUERYFILTERFIELD_TRIGGER_ID),
				Operation: ptr(kestra_api_client.QUERYFILTEROP_CONTAINS),
				Value:     flowId,
			},
		}

		resp, _, err := KestraTestApiClient().TriggersAPI.DeleteBackfillByQuery(ctx, MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("disabledTriggersByIdsTest", func(t *testing.T) {
		flowId := "disabledTriggersByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		trigger := triggerRef(namespace, flowId, triggerId)
		req := kestra_api_client.TriggerControllerSetDisabledRequest{
			Triggers: []kestra_api_client.Trigger{trigger},
			Disabled: true,
		}
		resp, _, err := KestraTestApiClient().TriggersAPI.DisabledTriggersByIds(ctx, MAIN_TENANT).TriggerControllerSetDisabledRequest(req).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("disabledTriggersByQueryTest", func(t *testing.T) {
		flowId := "disabledTriggersByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     ptr(kestra_api_client.QUERYFILTERFIELD_TRIGGER_ID),
				Operation: ptr(kestra_api_client.QUERYFILTEROP_CONTAINS),
				Value:     flowId,
			},
		}
		resp, _, err := KestraTestApiClient().TriggersAPI.DisabledTriggersByQuery(ctx, MAIN_TENANT).Disabled(true).Filters(filters).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("pauseBackfillTest", func(t *testing.T) {
		flowId := "pauseBackfillTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)
		_, err := createBackfillForTrigger(ctx, flowId, triggerId, namespace)
		require.NoError(t, err)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.PauseBackfill(ctx, MAIN_TENANT).Trigger(trigger).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("pauseBackfillByIdsTest", func(t *testing.T) {
		flowId := "pauseBackfillByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)
		_, err := createBackfillForTrigger(ctx, flowId, triggerId, namespace)
		require.NoError(t, err)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.PauseBackfillByIds(ctx, MAIN_TENANT).Trigger([]kestra_api_client.Trigger{trigger}).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("pauseBackfillByQueryTest", func(t *testing.T) {
		flowId := "pauseBackfillByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     ptr(kestra_api_client.QUERYFILTERFIELD_TRIGGER_ID),
				Operation: ptr(kestra_api_client.QUERYFILTEROP_CONTAINS),
				Value:     flowId,
			},
		}
		resp, _, err := KestraTestApiClient().TriggersAPI.PauseBackfillByQuery(ctx, MAIN_TENANT).Filters(filters).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("restartTriggerTest", func(t *testing.T) {
		flowId := "restartTriggerTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		resp, _, err := KestraTestApiClient().TriggersAPI.RestartTrigger(ctx, namespace, flowId, triggerId, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("searchTriggersTest", func(t *testing.T) {
		flowId := "searchTriggersTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		filters := []kestra_api_client.QueryFilter{
			{
				Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
				Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
				Value:     namespace,
			},
		}
		page, _, err := KestraTestApiClient().TriggersAPI.SearchTriggers(ctx, MAIN_TENANT).Page(1).Size(10).Filters(filters).Execute()
		require.NoError(t, err)
		require.NotNil(t, page)
	})

	t.Run("searchTriggersForFlowTest", func(t *testing.T) {
		flowId := "searchTriggersForFlowTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		page, _, err := KestraTestApiClient().TriggersAPI.SearchTriggersForFlow(ctx, namespace, flowId, MAIN_TENANT).Page(1).Size(10).Execute()
		require.NoError(t, err)
		require.NotNil(t, page)
	})

	t.Run("unlockTriggerTest", func(t *testing.T) {
		flowId := "unlockTriggerTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		_, httpResp, err := KestraTestApiClient().TriggersAPI.UnlockTrigger(ctx, namespace, flowId, triggerId, MAIN_TENANT).Execute()
		require.Error(t, err)
		require.NotNil(t, httpResp)
		require.Equal(t, 409, httpResp.StatusCode)
	})

	t.Run("unlockTriggersByIdsTest", func(t *testing.T) {
		flowId := "unlockTriggersByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.UnlockTriggersByIds(ctx, MAIN_TENANT).Trigger([]kestra_api_client.Trigger{trigger}).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("unlockTriggersByQueryTest", func(t *testing.T) {
		flowId := "unlockTriggersByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		resp, _, err := KestraTestApiClient().TriggersAPI.UnlockTriggersByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{}).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("unpauseBackfillTest", func(t *testing.T) {
		flowId := "unpauseBackfillTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)
		_, err := createBackfillForTrigger(ctx, flowId, triggerId, namespace)
		require.NoError(t, err)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.UnpauseBackfill(ctx, MAIN_TENANT).Trigger(trigger).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("unpauseBackfillByIdsTest", func(t *testing.T) {
		flowId := "unpauseBackfillByIdsTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)
		_, err := createBackfillForTrigger(ctx, flowId, triggerId, namespace)
		require.NoError(t, err)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.UnpauseBackfillByIds(ctx, MAIN_TENANT).Trigger([]kestra_api_client.Trigger{trigger}).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("unpauseBackfillByQueryTest", func(t *testing.T) {
		flowId := "unpauseBackfillByQueryTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		resp, _, err := KestraTestApiClient().TriggersAPI.UnpauseBackfillByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{}).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})

	t.Run("updateTriggerTest", func(t *testing.T) {
		flowId := "updateTriggerTest_" + randomId()
		triggerId := flowId + "_trigger"
		namespace := "test.triggers." + randomId()
		ctx := GetAuthContext()

		createFlowWithTrigger(t, ctx, flowId, triggerId, namespace)

		trigger := triggerRef(namespace, flowId, triggerId)
		resp, _, err := KestraTestApiClient().TriggersAPI.UpdateTrigger(ctx, MAIN_TENANT).Trigger(trigger).Execute()
		require.NoError(t, err)
		require.NotNil(t, resp)
	})
}
