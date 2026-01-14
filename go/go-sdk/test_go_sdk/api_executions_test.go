package main

import (
	"context"
	"fmt"
	"testing"

	openapiclient "github.com/kestra-io/client-sdk/go-sdk"
	"github.com/stretchr/testify/require"
)

func FAILED_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: fail
    type: io.kestra.plugin.core.execution.Fail
`, id, ns)
}

func SLEEP_CONCURRENCY_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

concurrency:
  behavior: QUEUE
  limit: 1

tasks:
  - id: sleep
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT2S
`, id, ns)
}

func FILE_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: write
    type: io.kestra.plugin.core.storage.Write
    content: "Hello from file"
    extension: .txt
`, id, ns)
}

func LOG_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

inputs:
  - id: key
    type: STRING
    defaults: 'empty'

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Hello World! 🚀
`, id, ns)
}

func PAUSE_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: pause_flow
    type: io.kestra.plugin.core.flow.Pause
    delay: PT2S
`, id, ns)
}

func WEBHOOK_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: out
    type: io.kestra.plugin.core.debug.Return
    format: "{{trigger | json }}"

triggers:
  - id: webhook
    type: io.kestra.plugin.core.trigger.Webhook
    key: a-secret-key
`, id, ns)
}

func createFlow(ctx context.Context, id string, ns string, flowTemplate func(id string, ns string) string) {
	flowYaml := flowTemplate(id, ns)
	_, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(flowYaml).Execute()
	if err != nil {
		panic(fmt.Sprintf("error while inserting test flow with id: '%s', error: %s", id, err))
	}
}
func createSimpleFlow(ctx context.Context, id string, ns string) {
	createFlow(ctx, id, ns, LOG_FLOW)
}
func createSimpleExecution(ctx context.Context, flowId string, ns string) *openapiclient.ExecutionControllerExecutionResponse {
	res, _, err := KestraTestApiClient().ExecutionsAPI.
		CreateExecution(ctx, ns, flowId, MAIN_TENANT).
		Wait(true).
		Execute()
	if err != nil {
		panic(fmt.Sprintf("error while creating execution, ns: '%s', flowid: '%s', error: %s", ns, flowId, err))
	}
	return res
}
func TestExecutionsAPI_All(t *testing.T) {

	t.Run("createExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		labels := []string{"label1:created"}
		inputs := map[string]any{
			"key": "value1",
		}

		res, _, err := KestraTestApiClient().ExecutionsAPI.
			CreateExecution(ctx, namespace, flowId, MAIN_TENANT).
			Wait(false).
			Labels(labels).
			FormData(inputs).
			Execute()

		require.NoError(t, err)
		require.NotNil(t, res)
		require.Equal(t, flowId, res.FlowId)
		require.Equal(t, openapiclient.Label{Key: "label1", Value: "created", AdditionalProperties: map[string]interface{}{}}, res.Labels[0])
		require.Equal(t, map[string]any{
			"key": "value1",
		}, res.Inputs)
	})

	t.Run("deleteExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		exec := createSimpleExecution(ctx, flowId, namespace)

		firstGet, _, firstGetErr := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, firstGetErr)
		require.Equal(t, flowId, firstGet.FlowId, "expect GET to return an execution")

		_, deleteReqErr := KestraTestApiClient().ExecutionsAPI.DeleteExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, deleteReqErr)

		_, secondGetHttpRes, _ := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.Equal(t, 404, secondGetHttpRes.StatusCode)
	})

	t.Run("deleteExecutionsByIdTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		exec1 := createSimpleExecution(ctx, flowId, namespace)
		exec2 := createSimpleExecution(ctx, flowId, namespace)
		exec3 := createSimpleExecution(ctx, flowId, namespace)

		res, _, err := KestraTestApiClient().ExecutionsAPI.DeleteExecutionsByIds(ctx, MAIN_TENANT).
			RequestBody([]string{exec1.Id, exec3.Id}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 2, res.GetCount(), "only 2 exec should have been deleted")

		_, httpRes1, _ := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec1.Id, MAIN_TENANT).Execute()
		require.Equal(t, 404, httpRes1.StatusCode)
		_, httpRes3, _ := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec3.Id, MAIN_TENANT).Execute()
		require.Equal(t, 404, httpRes3.StatusCode)

		_, _, errget2 := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec2.Id, MAIN_TENANT).Execute()
		require.NoError(t, errget2)
	})

	t.Run("deleteExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		namespaceToDelete := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		createSimpleFlow(ctx, flowId, namespaceToDelete)
		exec1 := createSimpleExecution(ctx, flowId, namespaceToDelete)
		exec2 := createSimpleExecution(ctx, flowId, namespace)
		exec3 := createSimpleExecution(ctx, flowId, namespaceToDelete)

		field := openapiclient.QUERYFILTERFIELD_NAMESPACE
		op := openapiclient.QUERYFILTEROP_EQUALS
		nsFilter := openapiclient.QueryFilter{
			Field:     &field,
			Operation: &op,
			Value:     namespaceToDelete,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.DeleteExecutionsByQuery(ctx, MAIN_TENANT).Filters([]openapiclient.QueryFilter{nsFilter}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 2, res["count"], "only 2 exec should have been deleted")

		_, httpRes1, _ := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec1.Id, MAIN_TENANT).Execute()
		require.Equal(t, 404, httpRes1.StatusCode)
		_, httpRes3, _ := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec3.Id, MAIN_TENANT).Execute()
		require.Equal(t, 404, httpRes3.StatusCode)

		_, _, errget2 := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec2.Id, MAIN_TENANT).Execute()
		require.NoError(t, errget2)
	})
}
