package test

import (
	"context"
	"fmt"
	"io"
	"testing"
	"time"

	"github.com/kestra-io/client-sdk/go-sdk/kestra_api_client"
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
    duration: PT10S
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
description: simple_flow_description

inputs:
  - id: inputA
    type: STRING
    defaults: 'default_value'

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: "Hello World! {{ inputs.inputA }}🚀"
  - id: return
    type: io.kestra.plugin.core.debug.Return
    format: "{{ inputs.inputA }}"
outputs:
  - id: flow_output
    type: STRING
    value: "{{ outputs.return.value }}"
`, id, ns)
}
func DEPENDENT_FLOW_OF_LOG_FLOW(id string, ns string, triggeringFlowId string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

triggers:
  - id: upstream_dependancy
    type: io.kestra.plugin.core.trigger.Flow
    preconditions:
        id: flow_trigger
        flows:
          - flowId: %s
            namespace: %s
tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: Dependent flow triggered
`, id, ns, triggeringFlowId, ns)
}
func LONG_RUNNING_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

tasks:
  - id: sleep
    type: io.kestra.plugin.core.flow.Sleep
    duration: PT10S
`, id, ns)
}
func SIMPLE_BUT_LONG_FLOW(id string, ns string) string {
	return fmt.Sprintf(`
id: %s
namespace: %s

inputs:
  - id: key
    type: STRING
    defaults: 'default_value'

tasks:
  - id: hello
    type: io.kestra.plugin.core.log.Log
    message: "Hello World! {{ inputs.key }}🚀"
  - id: sleep
    type: io.kestra.plugin.core.flow.Sleep
    duration: "PT0.5S"
  - id: hello2
    type: io.kestra.plugin.core.log.Log
    message: "Hello 2"
  - id: sleep2
    type: io.kestra.plugin.core.flow.Sleep
    duration: "PT0.5S"
  - id: hello3
    type: io.kestra.plugin.core.log.Log
    message: "Hello 3"
  - id: sleep3
    type: io.kestra.plugin.core.flow.Sleep
    duration: "PT0.5S"
  - id: return
    type: io.kestra.plugin.core.debug.Return
    format: "{{ inputs.key }}"
outputs:
  - id: flow_output
    type: STRING
    value: "{{ outputs.return.value }}"
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
func createDependentFlow(ctx context.Context, id string, ns string, triggeringFlowId string, flowTemplate func(id string, ns string, triggeringFlowId string) string) {
	flowYaml := flowTemplate(id, ns, triggeringFlowId)
	_, _, err := KestraTestApiClient().FlowsAPI.CreateFlow(ctx, MAIN_TENANT).Body(flowYaml).Execute()
	if err != nil {
		panic(fmt.Sprintf("error while inserting dependent test flow with id: '%s', error: %s", id, err))
	}
}
func createSimpleFlow(ctx context.Context, id string, ns string) {
	createFlow(ctx, id, ns, LOG_FLOW)
}
func createExecution(t *testing.T, ctx context.Context, flowId string, ns string) *kestra_api_client.ExecutionControllerExecutionResponse {
	res, _, err := KestraTestApiClient().ExecutionsAPI.
		CreateExecution(ctx, ns, flowId, MAIN_TENANT).
		Wait(true).
		Execute()
	require.NoError(t, err, fmt.Sprintf("error while creating execution, ns: '%s', flowid: '%s', error: %s", ns, flowId, err))
	return res
}
func createExecutionAsync(t *testing.T, ctx context.Context, flowId string, ns string) *kestra_api_client.ExecutionControllerExecutionResponse {
	res, _, err := KestraTestApiClient().ExecutionsAPI.
		CreateExecution(ctx, ns, flowId, MAIN_TENANT).
		Wait(false).
		Execute()
	require.NoError(t, err, fmt.Sprintf("error while creating execution, ns: '%s', flowid: '%s', error: %s", ns, flowId, err))
	return res
}
func TestExecutionsAPI_All(t *testing.T) {

	t.Run("createExecution_request_shouldHaveWaitFalseByDefault", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		request := KestraTestApiClient().ExecutionsAPI.
			CreateExecution(ctx, namespace, flowId, MAIN_TENANT)

		require.Equal(t, flowId, request.GetId())
		require.Equal(t, MAIN_TENANT, request.GetTenant())
		require.Equal(t, namespace, request.GetNamespace())
		require.Equal(t, false, *request.GetWait())
		require.Nil(t, request.GetBreakpoints())
		require.Nil(t, request.GetKind())
		require.Nil(t, request.GetRevision())
		require.Nil(t, request.GetScheduleDate())
		require.Nil(t, request.GetLabels())
	})

	t.Run("createExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		labels := []string{"label1:created"}
		inputs := map[string]any{
			"inputA": "value1",
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
		require.Equal(t, kestra_api_client.Label{Key: "label1", Value: "created", AdditionalProperties: map[string]interface{}{}}, res.Labels[0])
		require.Equal(t, map[string]any{
			"inputA": "value1",
		}, res.Inputs)
	})

	t.Run("createExecutionWithInputsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		labels := []string{"label1:created"}
		inputs := map[string]any{
			"inputA": "value1",
		}

		created, _, err := KestraTestApiClient().ExecutionsAPI.
			CreateExecution(ctx, namespace, flowId, MAIN_TENANT).
			Wait(false).
			Labels(labels).
			FormData(inputs).
			Execute()
		require.Eventually(t, executionInState(ctx, created.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
		exec, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, created.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, map[string]any{
			"inputA": "value1",
		}, exec.Inputs)

		require.Equal(t, map[string]any{
			"flow_output": "value1",
		}, exec.Outputs)

		require.Equal(t, map[string]any{
			"value": "value1",
		}, exec.TaskRunList[1].Outputs)
	})

	t.Run("deleteExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		exec := createExecution(t, ctx, flowId, namespace)

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
		exec1 := createExecution(t, ctx, flowId, namespace)
		exec2 := createExecution(t, ctx, flowId, namespace)
		exec3 := createExecution(t, ctx, flowId, namespace)

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
		exec1 := createExecution(t, ctx, flowId, namespaceToDelete)
		exec2 := createExecution(t, ctx, flowId, namespace)
		exec3 := createExecution(t, ctx, flowId, namespaceToDelete)

		nsFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     namespaceToDelete,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.DeleteExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{nsFilter}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 2, res["count"], "only 2 exec should have been deleted")

		_, httpRes1, _ := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec1.Id, MAIN_TENANT).Execute()
		require.Equal(t, 404, httpRes1.StatusCode)
		_, httpRes3, _ := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec3.Id, MAIN_TENANT).Execute()
		require.Equal(t, 404, httpRes3.StatusCode)

		_, _, errget2 := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec2.Id, MAIN_TENANT).Execute()
		require.NoError(t, errget2)
	})

	t.Run("downloadFileFromExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, FILE_FLOW)
		exec := createExecution(t, ctx, flowId, namespace)

		require.NotNil(t, exec.TaskRunList[0])
		filePath := fmt.Sprintf("%s", exec.TaskRunList[0].Outputs["uri"])
		require.NotNil(t, filePath)

		res, _, err := KestraTestApiClient().ExecutionsAPI.DownloadFileFromExecution(ctx, exec.Id, MAIN_TENANT).Path(filePath).Execute()
		require.NoError(t, err)
		contentBytes, err := io.ReadAll(res)
		require.NoError(t, err)

		content := string(contentBytes)
		require.Contains(t, content, "Hello from file")
	})

	t.Run("forceRunByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		res, _, err := KestraTestApiClient().ExecutionsAPI.ForceRunByIds(ctx, MAIN_TENANT).RequestBody([]string{execQueued.Id}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("forceRunExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		_, _, err := KestraTestApiClient().ExecutionsAPI.ForceRunExecution(ctx, execQueued.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("forceRunExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		flowFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_FLOW_ID),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     exec.FlowId,
		}
		_, _, err := KestraTestApiClient().ExecutionsAPI.ForceRunExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{flowFilter}).Execute()
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("getExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		fetchedExec, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, exec.Id, fetchedExec.Id)
	})

	t.Run("getExecutionFlowGraphTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		flowGraph, _, err := KestraTestApiClient().ExecutionsAPI.ExecutionFlowGraph(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, flowGraph.GetNodes())
	})

	t.Run("getFileMetadatasFromExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, FILE_FLOW)

		exec := createExecution(t, ctx, flowId, namespace)
		filePath := fmt.Sprintf("%s", exec.TaskRunList[0].Outputs["uri"])
		require.NotNil(t, filePath)

		fileMetas, _, err := KestraTestApiClient().ExecutionsAPI.FileMetadatasFromExecution(ctx, exec.Id, MAIN_TENANT).Path(filePath).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 15, fileMetas.GetSize())
	})

	t.Run("getFlowFromExecutionByIdTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		res, _, err := KestraTestApiClient().ExecutionsAPI.FlowFromExecutionById(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.EqualValues(t, flowId, res.Id)
		require.EqualValues(t, namespace, res.Namespace)
	})

	t.Run("getLatestExecutionsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		otherFlowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		createSimpleFlow(ctx, otherFlowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)
		otherExec := createExecution(t, ctx, otherFlowId, namespace)

		input := []kestra_api_client.ExecutionRepositoryInterfaceFlowFilter{
			{
				Id:        flowId,
				Namespace: namespace,
			},
			{
				Id:        otherFlowId,
				Namespace: namespace,
			},
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.LatestExecutions(ctx, MAIN_TENANT).ExecutionRepositoryInterfaceFlowFilter(input).Execute()
		require.NoError(t, err)
		require.Len(t, res, 2)
		ids := make([]string, 0, len(res))
		for _, r := range res {
			ids = append(ids, *r.Id)
		}
		require.ElementsMatch(t,
			[]string{exec.Id, otherExec.Id},
			ids,
		)
	})

	t.Run("killExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)

		_, _, err := KestraTestApiClient().ExecutionsAPI.KillExecution(ctx, exec.Id, MAIN_TENANT).IsOnKillCascade(true).Execute()
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_KILLED), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("killExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		createExecutionAsync(t, ctx, flowId, namespace)
		exec2 := createExecutionAsync(t, ctx, flowId, namespace)
		exec3 := createExecutionAsync(t, ctx, flowId, namespace)

		res, _, err := KestraTestApiClient().ExecutionsAPI.KillExecutionsByIds(ctx, MAIN_TENANT).RequestBody([]string{exec2.Id, exec3.Id}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 2, res.GetCount())

		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_KILLED), 5*time.Second, 100*time.Millisecond)
		require.Eventually(t, executionInState(ctx, exec3.Id, kestra_api_client.STATETYPE_KILLED), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("killExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		namespaceToDelete := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespaceToDelete, SLEEP_CONCURRENCY_FLOW)

		createExecutionAsync(t, ctx, flowId, namespace)
		exec2 := createExecutionAsync(t, ctx, flowId, namespaceToDelete)
		exec3 := createExecutionAsync(t, ctx, flowId, namespaceToDelete)

		nsFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     namespaceToDelete,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.KillExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{nsFilter}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 2, res["count"])

		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_KILLED), 5*time.Second, 100*time.Millisecond)
		require.Eventually(t, executionInState(ctx, exec3.Id, kestra_api_client.STATETYPE_KILLED), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("pauseExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_RUNNING)

		_, err := KestraTestApiClient().ExecutionsAPI.PauseExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_PAUSED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("pauseExecutionsByIdsTest", func(t *testing.T) {
		namespace1 := randomId()
		namespace2 := randomId()
		namespace3 := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace1, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace2, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace3, SLEEP_CONCURRENCY_FLOW)

		exec1 := createExecutionUntil(t, ctx, flowId, namespace1, kestra_api_client.STATETYPE_RUNNING)
		exec2 := createExecutionUntil(t, ctx, flowId, namespace2, kestra_api_client.STATETYPE_RUNNING)
		createExecutionUntil(t, ctx, flowId, namespace3, kestra_api_client.STATETYPE_RUNNING)

		res, _, err := KestraTestApiClient().ExecutionsAPI.PauseExecutionsByIds(ctx, MAIN_TENANT).RequestBody([]string{exec1.Id, exec2.Id}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 2, res.GetCount())
		require.Eventually(t, executionInState(ctx, exec1.Id, kestra_api_client.STATETYPE_PAUSED), 5*time.Second, 100*time.Millisecond)
		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_PAUSED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("pauseExecutionsByQueryTest", func(t *testing.T) {
		namespace1 := randomId()
		namespace2 := randomId()
		namespace3 := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace1, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace2, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace3, SLEEP_CONCURRENCY_FLOW)

		createExecutionUntil(t, ctx, flowId, namespace1, kestra_api_client.STATETYPE_RUNNING)
		exec2 := createExecutionUntil(t, ctx, flowId, namespace2, kestra_api_client.STATETYPE_RUNNING)
		createExecutionUntil(t, ctx, flowId, namespace3, kestra_api_client.STATETYPE_RUNNING)

		filter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     namespace2,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.PauseExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{filter}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res["count"])
		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_PAUSED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("replayExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		res, _, err := KestraTestApiClient().ExecutionsAPI.ReplayExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_CREATED, res.State.Current)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("replayExecutionWithinputsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		// first created it and wait for run
		exec := createExecution(t, ctx, flowId, namespace)
		require.Equal(t, map[string]any{
			"flow_output": "default_value",
		}, exec.Outputs)

		// then replay with other inputs
		inputs := map[string]any{
			"inputA": "value1FromReplay",
		}
		replayingExec, _, err := KestraTestApiClient().ExecutionsAPI.ReplayExecutionWithinputs(ctx, exec.Id, MAIN_TENANT).FormData(inputs).Execute()
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_CREATED, replayingExec.State.Current)
		require.Eventually(t, executionInState(ctx, replayingExec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)

		replayed, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, replayingExec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Equal(t, map[string]any{
			"flow_output": "value1FromReplay",
		}, replayed.Outputs)
	})
	t.Run("replayExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		res, _, err := KestraTestApiClient().ExecutionsAPI.ReplayExecutionsByIds(ctx, MAIN_TENANT).RequestBody([]string{exec.Id}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
	})
	t.Run("replayExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		createExecution(t, ctx, flowId, namespace)
		filter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     namespace,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.ReplayExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{filter}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res["count"])
	})
	t.Run("restartExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, FAILED_FLOW)

		exec := createExecution(t, ctx, flowId, namespace)

		res, _, err := KestraTestApiClient().ExecutionsAPI.RestartExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_RESTARTED, res.State.Current)
	})
	t.Run("restartExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, FAILED_FLOW)

		exec := createExecution(t, ctx, flowId, namespace)

		res, _, err := KestraTestApiClient().ExecutionsAPI.RestartExecutionsByIds(ctx, MAIN_TENANT).RequestBody([]string{exec.Id}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
	})
	t.Run("restartExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, FAILED_FLOW)

		createExecution(t, ctx, flowId, namespace)
		filter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     namespace,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.RestartExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{filter}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res["count"])
	})
	t.Run("resumeExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, PAUSE_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_PAUSED)

		_, _, err := KestraTestApiClient().ExecutionsAPI.ResumeExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("resumeExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, PAUSE_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_PAUSED)

		res, _, err := KestraTestApiClient().ExecutionsAPI.ResumeExecutionsByIds(ctx, MAIN_TENANT).RequestBody([]string{exec.Id}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("resumeExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, PAUSE_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_PAUSED)
		filter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     namespace,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.ResumeExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{filter}).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 1, res["count"])
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("searchExecutionsTest", func(t *testing.T) {
		namespace := randomId()
		otherNamespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		createSimpleFlow(ctx, flowId, otherNamespace)

		exec1 := createExecution(t, ctx, flowId, namespace)
		exec2 := createExecution(t, ctx, flowId, namespace)
		exec3 := createExecution(t, ctx, flowId, otherNamespace)
		exec4 := createExecution(t, ctx, flowId, otherNamespace)
		exec5 := createExecution(t, ctx, flowId, otherNamespace)

		flowFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_FLOW_ID),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     flowId,
		}
		res, _, err := KestraTestApiClient().ExecutionsAPI.SearchExecutions(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{flowFilter}).Page(1).Size(50).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 5, res.Total)
		require.Len(t, res.Results, 5)
		assertResultsContainExecutions(t, res.Results, exec1, exec2, exec3, exec4, exec5)

		// page 1 and size 1
		res, _, err = KestraTestApiClient().ExecutionsAPI.SearchExecutions(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{flowFilter}).Page(1).Size(1).Execute()
		require.NoError(t, err)
		require.EqualValues(t, 5, res.Total)
		require.Len(t, res.Results, 1)

		// add namespace filter
		nsFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     namespace,
		}
		res, _, err = KestraTestApiClient().ExecutionsAPI.SearchExecutions(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{flowFilter, nsFilter}).Page(1).Size(50).Execute()
		require.NoError(t, err)
		require.Len(t, res.Results, 2)
		assertResultsContainExecutions(t, res.Results, exec1, exec2)

		// invert ns filter
		notEqualNsFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_NAMESPACE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_NOT_EQUALS),
			Value:     namespace,
		}
		res, _, err = KestraTestApiClient().ExecutionsAPI.SearchExecutions(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{flowFilter, notEqualNsFilter}).Page(1).Size(50).Execute()
		require.NoError(t, err)
		require.Len(t, res.Results, 3)
		assertResultsContainExecutions(t, res.Results, exec3, exec4, exec5)
	})
	t.Run("setLabelsOnTerminatedExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		labels := []kestra_api_client.Label{{Key: "label1", Value: "created"}}

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		_, _, err := KestraTestApiClient().ExecutionsAPI.SetLabelsOnTerminatedExecution(ctx, exec.Id, MAIN_TENANT).Label(labels).Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		found := false
		for _, l := range res.Labels {
			if l.Key == labels[0].Key && l.Value == labels[0].Value {
				found = true
				break
			}
		}
		require.True(t, found, "expected label %v to be in res.Labels: %v", labels[0], res.Labels)
	})
	t.Run("setLabelsOnTerminatedExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		labels := []kestra_api_client.Label{{Key: "label1", Value: "created"}}

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)
		req := kestra_api_client.ExecutionControllerSetLabelsByIdsRequest{
			ExecutionsId:    []string{exec.Id},
			ExecutionLabels: labels,
		}
		_, _, err := KestraTestApiClient().ExecutionsAPI.SetLabelsOnTerminatedExecutionsByIds(ctx, MAIN_TENANT).ExecutionControllerSetLabelsByIdsRequest(req).Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		found := false
		for _, l := range res.Labels {
			if l.Key == labels[0].Key && l.Value == labels[0].Value {
				found = true
				break
			}
		}
		require.True(t, found, "expected label %v to be in res.Labels: %v", labels[0], res.Labels)
	})
	t.Run("setLabelsOnTerminatedExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)
		labels := []kestra_api_client.Label{{Key: "label1", Value: "created"}}

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)
		filter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_FLOW_ID),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     flowId,
		}
		_, _, err := KestraTestApiClient().ExecutionsAPI.SetLabelsOnTerminatedExecutionsByQuery(ctx, MAIN_TENANT).Filters([]kestra_api_client.QueryFilter{filter}).Label(labels).Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		found := false
		for _, l := range res.Labels {
			if l.Key == labels[0].Key && l.Value == labels[0].Value {
				found = true
				break
			}
		}
		require.True(t, found, "expected label %v to be in res.Labels: %v", labels[0], res.Labels)
	})
	t.Run("triggerExecutionByGetWebhookTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, WEBHOOK_FLOW)
		key := "a-secret-key"

		res, _, err := KestraTestApiClient().ExecutionsAPI.TriggerExecutionByGetWebhook(ctx, namespace, flowId, key, MAIN_TENANT).Execute()
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, *res.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("unqueueExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		res, _, err := KestraTestApiClient().ExecutionsAPI.UnqueueExecution(ctx, execQueued.Id, MAIN_TENANT).State(kestra_api_client.STATETYPE_CANCELLED).Execute()
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
		require.Eventually(t, executionInState(ctx, res.Id, kestra_api_client.STATETYPE_CANCELLED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("unqueueExecutionTest_QA_REPRODUCER", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		res, _, err := KestraTestApiClient().ExecutionsAPI.UnqueueExecution(ctx, execQueued.Id, MAIN_TENANT).State(kestra_api_client.STATETYPE_RUNNING).Execute()
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_RUNNING, res.State.Current)
		require.Eventually(t, executionInState(ctx, res.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("unqueueExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		_, _, err := KestraTestApiClient().ExecutionsAPI.UnqueueExecutionsByIds(ctx, MAIN_TENANT).RequestBody([]string{execQueued.Id}).State(kestra_api_client.STATETYPE_CANCELLED).Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, execQueued.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)

		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
		require.Eventually(t, executionInState(ctx, res.Id, kestra_api_client.STATETYPE_CANCELLED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("unqueueExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		nsFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_STATE),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     kestra_api_client.STATETYPE_QUEUED,
		}
		flowFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_FLOW_ID),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     flowId,
		}
		_, _, err := KestraTestApiClient().ExecutionsAPI.UnqueueExecutionsByQuery(ctx, MAIN_TENANT).
			Filters([]kestra_api_client.QueryFilter{nsFilter, flowFilter}).
			NewState(kestra_api_client.STATETYPE_CANCELLED).
			Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, execQueued.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)

		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
		require.Eventually(t, executionInState(ctx, res.Id, kestra_api_client.STATETYPE_CANCELLED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("updateExecutionStatusTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		_, _, err := KestraTestApiClient().ExecutionsAPI.UpdateExecutionStatus(ctx, exec.Id, MAIN_TENANT).Status(kestra_api_client.STATETYPE_CANCELLED).Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
	})
	t.Run("updateExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		_, _, err := KestraTestApiClient().ExecutionsAPI.UpdateExecutionsStatusByIds(ctx, MAIN_TENANT).RequestBody([]string{exec.Id}).NewStatus(kestra_api_client.STATETYPE_CANCELLED).Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)

		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
	})
	t.Run("updateExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		flowFilter := kestra_api_client.QueryFilter{
			Field:     ptr(kestra_api_client.QUERYFILTERFIELD_FLOW_ID),
			Operation: ptr(kestra_api_client.QUERYFILTEROP_EQUALS),
			Value:     flowId,
		}
		_, _, err := KestraTestApiClient().ExecutionsAPI.UpdateExecutionsStatusByQuery(ctx, MAIN_TENANT).
			Filters([]kestra_api_client.QueryFilter{flowFilter}).
			NewStatus(kestra_api_client.STATETYPE_CANCELLED).
			Execute()
		require.NoError(t, err)

		res, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)

		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
	})
	t.Run("updateTaskRunState", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		res, _, err := KestraTestApiClient().ExecutionsAPI.UpdateTaskRunState(ctx, exec.Id, MAIN_TENANT).
			ExecutionControllerStateRequest(
				kestra_api_client.ExecutionControllerStateRequest{
					TaskRunId: ptr(exec.TaskRunList[0].Id),
					State:     ptr(kestra_api_client.STATETYPE_FAILED),
				},
			).
			Execute()
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_FAILED, res.TaskRunList[0].State.Current)
	})

	t.Run("followExecution_shouldWorkForASuccessExecution", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		createFlow(ctx, flowId, namespace, SIMPLE_BUT_LONG_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)

		// this endpoint is returning SSE
		// executions is a channel that receive execution events and then get closed when execution is completed
		// to test it we just run an execution as would a real user do, accumulate with an infinite loop and run assertions when 'close' signal was received
		executions, err := KestraTestApiClient().ExecutionsAPI.FollowExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, executions)

		var receivedExecutions []*kestra_api_client.Execution
	loop:
		for {
			select {
			case exec, ok := <-executions:
				if !ok {
					// received channel close
					break loop
				} else {
					receivedExecutions = append(receivedExecutions, exec)
					fmt.Printf("received execution event with state: %s", exec.State.Current)
					if len(exec.TaskRunList) > 0 {
						lastTaskRun := exec.TaskRunList[len(exec.TaskRunList)-1]
						fmt.Printf("\tlastTaskRun id: %s, state: %s", lastTaskRun.TaskId, lastTaskRun.State.Current)
					}
					fmt.Println()
				}
			case <-ctx.Done():
				// caller canceled
				break loop
			}
		}
		require.NotEmpty(t, receivedExecutions, "expected to receive at least one execution event")
		last := receivedExecutions[len(receivedExecutions)-1]
		require.NotNil(t, last)
		require.Equal(t, kestra_api_client.STATETYPE_SUCCESS, last.State.Current, "last SSE execution state should be SUCCESS")
		lastTaskRun := last.TaskRunList[len(last.TaskRunList)-1]
		require.Equal(t, "return", lastTaskRun.TaskId, "last SSE execution taskRun should be 'return'")
	})

	t.Run("followExecution_shouldAllowGettingCancelledByUser", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		ctx, cancel := context.WithCancel(ctx)
		defer cancel()

		createFlow(ctx, flowId, namespace, LONG_RUNNING_FLOW)
		exec := createExecutionAsync(t, ctx, flowId, namespace)

		executions, err := KestraTestApiClient().ExecutionsAPI.FollowExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, executions)

		// when a user explicitly cancel
		cancel()

		// then
		require.Eventually(t, func() bool {
			return checkChannelIsClosed(executions)
		}, 5*time.Second, 100*time.Millisecond,
			"channel should be closed soon after cancelling")
	})

	t.Run("followExecution_shouldAllowGettingTimedoutByUser", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := GetAuthContext()
		ctx, cancel := context.WithTimeout(ctx, 200*time.Millisecond)
		defer cancel()

		createFlow(ctx, flowId, namespace, LONG_RUNNING_FLOW)
		exec := createExecutionAsync(t, ctx, flowId, namespace)

		executions, err := KestraTestApiClient().ExecutionsAPI.FollowExecution(ctx, exec.Id, MAIN_TENANT).Execute()
		require.NoError(t, err)
		require.NotNil(t, executions)

		// when timeout is set and reached

		// then
		require.Eventually(t, func() bool {
			return checkChannelIsClosed(executions)
		}, 5*time.Second, 100*time.Millisecond,
			"channel should be closed soon after timeout")
	})

	t.Run("followDependenciesExecution", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		dependentFlowId := randomId()
		ctx := GetAuthContext()
		createDependentFlow(ctx, dependentFlowId, namespace, flowId, DEPENDENT_FLOW_OF_LOG_FLOW)
		time.Sleep(200 * time.Millisecond) // wait for flow topology
		createFlow(ctx, flowId, namespace, LOG_FLOW)

		awaitUntilFlowDependenciesContainsSpecificFlowId(t, ctx, namespace, flowId, dependentFlowId)

		exec := createExecution(t, ctx, flowId, namespace)

		// this endpoint is returning SSE
		executions, err := KestraTestApiClient().ExecutionsAPI.FollowDependenciesExecution(ctx, exec.Id, MAIN_TENANT).
			ExpandAll(false).
			DestinationOnly(false).
			Execute()
		require.NoError(t, err)
		require.NotNil(t, executions)

		var foundDependentExecution []*kestra_api_client.ExecutionStatusEvent
	loop:
		for {
			select {
			case executionStatusEvent, ok := <-executions:
				if !ok {
					// received channel close
					break loop
				} else {
					if *executionStatusEvent.FlowId == dependentFlowId {
						// if there was an event of the dependent flow we are interested in, add it
						foundDependentExecution = append(foundDependentExecution, executionStatusEvent)
					}
				}
			case <-ctx.Done():
				// caller canceled
				break loop
			}
		}
		hasAtLeastOneCreatedSuccessOrRunning := false
		states := make([]kestra_api_client.StateType, 0, len(foundDependentExecution))

		for _, e := range foundDependentExecution {
			if e != nil && e.State != nil {
				states = append(states, e.State.Current)
				if e.State.Current == kestra_api_client.STATETYPE_CREATED || e.State.Current == kestra_api_client.STATETYPE_RUNNING || e.State.Current == kestra_api_client.STATETYPE_SUCCESS {
					hasAtLeastOneCreatedSuccessOrRunning = true
					break
				}
			}
		}
		require.True(t, hasAtLeastOneCreatedSuccessOrRunning, "at least one CREATED or RUNNING or SUCCESS event should be returned for this dependent flow, but there was instead: %s", states)
	})
}

func awaitUntilFlowDependenciesContainsSpecificFlowId(t *testing.T, ctx context.Context, namespace string, flowId string, dependentFlowId string) {
	require.Eventually(t, flowDependenciesContainsSpecificFlowId(t, ctx, namespace, flowId, dependentFlowId), 5*time.Second, 100*time.Millisecond)
}
func flowDependenciesContainsSpecificFlowId(t *testing.T, ctx context.Context, namespace string, flowId string, dependencyToFind string) func() bool {
	return func() bool {
		dependencies, _, err := KestraTestApiClient().FlowsAPI.FlowDependencies(ctx, namespace, flowId, MAIN_TENANT).DestinationOnly(false).ExpandAll(false).Execute()
		require.NoError(t, err)
		for _, node := range dependencies.Nodes {
			if node.Id != nil {
				if *node.Id == dependencyToFind {
					return true
				}
			}
		}
		return false
	}
}

func checkChannelIsClosed[T any](channel <-chan T) bool {
	_, ok := <-channel
	return !ok
}

func assertResultsContainExecutions(
	t *testing.T,
	results []kestra_api_client.Execution,
	execs ...*kestra_api_client.ExecutionControllerExecutionResponse,
) {
	t.Helper()

	expectedIds := make([]string, 0, len(execs))
	for _, e := range execs {
		require.NotNil(t, e)
		expectedIds = append(expectedIds, e.Id)
	}

	actualIds := make([]string, 0, len(results))
	for _, r := range results {
		actualIds = append(actualIds, r.Id)
	}

	// "contains all" (ignores ordering, allows extras)
	require.Subset(t, actualIds, expectedIds)
}
func executionInState(ctx context.Context, execId string, expectedType kestra_api_client.StateType) func() bool {
	return func() bool {
		exec, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, execId, MAIN_TENANT).Execute()
		if err != nil {
			return false
		}
		return exec.State.Current == expectedType
	}
}
func createExecutionUntil(t *testing.T, ctx context.Context, flowId string, ns string, expectedType kestra_api_client.StateType) *kestra_api_client.Execution {
	res := createExecutionAsync(t, ctx, flowId, ns)
	execId := res.Id
	require.Eventually(t, executionInState(ctx, execId, expectedType), 5*time.Second, 100*time.Millisecond)
	ress, _, err := KestraTestApiClient().ExecutionsAPI.Execution(ctx, execId, MAIN_TENANT).Execute()
	require.NoError(t, err)
	return ress
}
