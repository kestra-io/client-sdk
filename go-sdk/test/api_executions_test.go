package test

import (
	"context"
	"errors"
	"fmt"
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
    pauseDuration: PT2S
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
	_, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, flowYaml)
	if err != nil {
		panic(fmt.Sprintf("error while inserting test flow with id: '%s', error: %s", id, err))
	}
}
func createDependentFlow(ctx context.Context, id string, ns string, triggeringFlowId string, flowTemplate func(id string, ns string, triggeringFlowId string) string) {
	flowYaml := flowTemplate(id, ns, triggeringFlowId)
	_, err := KestraTestClient().Flows().CreateFlow(ctx, MAIN_TENANT, flowYaml)
	if err != nil {
		panic(fmt.Sprintf("error while inserting dependent test flow with id: '%s', error: %s", id, err))
	}
}
func createSimpleFlow(ctx context.Context, id string, ns string) {
	createFlow(ctx, id, ns, LOG_FLOW)
}
func createExecution(t *testing.T, ctx context.Context, flowId string, ns string) *kestra_api_client.ExecutionControllerExecutionResponse {
	res, err := KestraTestClient().Executions().CreateExecution(ctx, MAIN_TENANT, ns, flowId, nil, kestra_api_client.PtrBool(true), nil, nil, nil, nil)
	require.NoError(t, err, fmt.Sprintf("error while creating execution, ns: '%s', flowid: '%s', error: %s", ns, flowId, err))
	return res
}
func createExecutionAsync(t *testing.T, ctx context.Context, flowId string, ns string) *kestra_api_client.ExecutionControllerExecutionResponse {
	res, err := KestraTestClient().Executions().CreateExecution(ctx, MAIN_TENANT, ns, flowId, nil, kestra_api_client.PtrBool(false), nil, nil, nil, nil)
	require.NoError(t, err, fmt.Sprintf("error while creating execution, ns: '%s', flowid: '%s', error: %s", ns, flowId, err))
	return res
}
func TestExecutionsAPI_All(t *testing.T) {

	t.Run("createExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		labels := []string{"label1:created"}

		res, err := KestraTestClient().Executions().CreateExecution(ctx, MAIN_TENANT, namespace, flowId, labels, kestra_api_client.PtrBool(false), nil, nil, nil, nil)

		require.NoError(t, err)
		require.NotNil(t, res)
		require.Equal(t, flowId, res.FlowId)
		require.NotEmpty(t, res.Labels)
	})

	t.Run("createExecutionWithInputsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		created, err := KestraTestClient().Executions().CreateExecution(ctx, MAIN_TENANT, namespace, flowId, []string{"label1:created"}, kestra_api_client.PtrBool(false), nil, nil, nil, nil)
		require.NoError(t, err)
		require.Eventually(t, executionInState(ctx, created.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
		exec, err := KestraTestClient().Executions().Execution(ctx, created.Id, MAIN_TENANT)
		require.NoError(t, err)

		require.NotNil(t, exec)
		require.Equal(t, flowId, exec.FlowId)
		require.GreaterOrEqual(t, len(exec.TaskRunList), 2)
	})

	t.Run("deleteExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		exec := createExecution(t, ctx, flowId, namespace)

		firstGet, firstGetErr := KestraTestClient().Executions().Execution(ctx, exec.Id, MAIN_TENANT)
		require.NoError(t, firstGetErr)
		require.Equal(t, flowId, firstGet.FlowId, "expect GET to return an execution")

		deleteReqErr := KestraTestClient().Executions().DeleteExecution(ctx, exec.Id, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, deleteReqErr)

		_, secondGetErr := KestraTestClient().Executions().Execution(ctx, exec.Id, MAIN_TENANT)
		require.Error(t, secondGetErr)
		var apiErr *kestra_api_client.ApiError
		require.True(t, errors.As(secondGetErr, &apiErr))
		require.Equal(t, 404, apiErr.StatusCode)
	})

	t.Run("deleteExecutionsByIdTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		exec1 := createExecution(t, ctx, flowId, namespace)
		exec2 := createExecution(t, ctx, flowId, namespace)
		exec3 := createExecution(t, ctx, flowId, namespace)

		res, err := KestraTestClient().Executions().DeleteExecutionsByIds(ctx, MAIN_TENANT, []string{exec1.Id, exec3.Id}, nil, nil, nil, nil)
		require.NoError(t, err)
		require.EqualValues(t, 2, *res.Count, "only 2 exec should have been deleted")

		_, errGet1 := KestraTestClient().Executions().Execution(ctx, exec1.Id, MAIN_TENANT)
		require.Error(t, errGet1)
		var apiErr1 *kestra_api_client.ApiError
		require.True(t, errors.As(errGet1, &apiErr1))
		require.Equal(t, 404, apiErr1.StatusCode)

		_, errGet3 := KestraTestClient().Executions().Execution(ctx, exec3.Id, MAIN_TENANT)
		require.Error(t, errGet3)
		var apiErr3 *kestra_api_client.ApiError
		require.True(t, errors.As(errGet3, &apiErr3))
		require.Equal(t, 404, apiErr3.StatusCode)

		_, errget2 := KestraTestClient().Executions().Execution(ctx, exec2.Id, MAIN_TENANT)
		require.NoError(t, errget2)
	})

	t.Run("deleteExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		namespaceToDelete := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		createSimpleFlow(ctx, flowId, namespaceToDelete)
		exec1 := createExecution(t, ctx, flowId, namespaceToDelete)
		exec2 := createExecution(t, ctx, flowId, namespace)
		exec3 := createExecution(t, ctx, flowId, namespaceToDelete)

		nsFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     namespaceToDelete,
		}
		res, err := KestraTestClient().Executions().DeleteExecutionsByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{nsFilter}, nil, nil, nil, nil)
		require.NoError(t, err)
		require.EqualValues(t, 2, res["count"], "only 2 exec should have been deleted")

		_, errGet1 := KestraTestClient().Executions().Execution(ctx, exec1.Id, MAIN_TENANT)
		require.Error(t, errGet1)
		var apiErr1 *kestra_api_client.ApiError
		require.True(t, errors.As(errGet1, &apiErr1))
		require.Equal(t, 404, apiErr1.StatusCode)

		_, errGet3 := KestraTestClient().Executions().Execution(ctx, exec3.Id, MAIN_TENANT)
		require.Error(t, errGet3)
		var apiErr3 *kestra_api_client.ApiError
		require.True(t, errors.As(errGet3, &apiErr3))
		require.Equal(t, 404, apiErr3.StatusCode)

		_, errget2 := KestraTestClient().Executions().Execution(ctx, exec2.Id, MAIN_TENANT)
		require.NoError(t, errget2)
	})

	t.Run("downloadFileFromExecutionTest", func(t *testing.T) {
		t.Skip("ApiTaskRun model does not include outputs; cannot get file URI from task run")
	})

	t.Run("forceRunByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		res, err := KestraTestClient().Executions().ForceRunByIds(ctx, MAIN_TENANT, []string{execQueued.Id})
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("forceRunExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		_, err := KestraTestClient().Executions().ForceRunExecution(ctx, execQueued.Id, MAIN_TENANT)
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("forceRunExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		flowFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterFlowId,
			Operation: kestra_api_client.OpEquals,
			Value:     exec.FlowId,
		}
		_, err := KestraTestClient().Executions().ForceRunExecutionsByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{flowFilter})
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("getExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		fetchedExec, err := KestraTestClient().Executions().Execution(ctx, exec.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, exec.Id, fetchedExec.Id)
	})

	t.Run("getExecutionFlowGraphTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		flowGraph, err := KestraTestClient().Executions().ExecutionFlowGraph(ctx, exec.Id, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.NotNil(t, flowGraph.Nodes)
	})

	t.Run("getFileMetadatasFromExecutionTest", func(t *testing.T) {
		t.Skip("ApiTaskRun model does not include outputs; cannot get file URI from task run")
	})

	t.Run("getFlowFromExecutionByIdTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		res, err := KestraTestClient().Executions().FlowFromExecutionById(ctx, exec.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.EqualValues(t, flowId, res.Id)
		require.EqualValues(t, namespace, res.Namespace)
	})

	t.Run("getLatestExecutionsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		otherFlowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		createSimpleFlow(ctx, otherFlowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)
		otherExec := createExecution(t, ctx, otherFlowId, namespace)

		filters := []kestra_api_client.ExecutionRepositoryInterfaceFlowFilter{
			{Namespace: namespace, Id: flowId},
			{Namespace: namespace, Id: otherFlowId},
		}
		res, err := KestraTestClient().Executions().LatestExecutions(ctx, MAIN_TENANT, filters)
		require.NoError(t, err)
		require.GreaterOrEqual(t, len(res), 2)
		ids := make([]string, 0, len(res))
		for _, r := range res {
			ids = append(ids, r.Id)
		}
		require.Contains(t, ids, exec.Id)
		require.Contains(t, ids, otherExec.Id)
	})

	t.Run("killExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)

		_, err := KestraTestClient().Executions().KillExecution(ctx, exec.Id, MAIN_TENANT, kestra_api_client.PtrBool(true))
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_KILLED), 5*time.Second, 100*time.Millisecond)
	})

	t.Run("killExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, LONG_RUNNING_FLOW)

		exec1 := createExecutionAsync(t, ctx, flowId, namespace)
		exec2 := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec1.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 200*time.Millisecond)
		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 200*time.Millisecond)

		res, err := KestraTestClient().Executions().KillExecutionsByIds(ctx, MAIN_TENANT, []string{exec1.Id, exec2.Id})
		require.NoError(t, err)
		require.EqualValues(t, 2, res.GetCount())

		require.Eventually(t, executionInState(ctx, exec1.Id, kestra_api_client.STATETYPE_KILLED), 10*time.Second, 500*time.Millisecond)
		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_KILLED), 10*time.Second, 500*time.Millisecond)
	})

	t.Run("killExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, LONG_RUNNING_FLOW)

		exec1 := createExecutionAsync(t, ctx, flowId, namespace)
		exec2 := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec1.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 200*time.Millisecond)
		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_RUNNING), 5*time.Second, 200*time.Millisecond)

		nsFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     namespace,
		}
		_, err := KestraTestClient().Executions().KillExecutionsByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{nsFilter})
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, exec1.Id, kestra_api_client.STATETYPE_KILLED), 10*time.Second, 500*time.Millisecond)
		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_KILLED), 10*time.Second, 500*time.Millisecond)
	})

	t.Run("pauseExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_RUNNING)

		_, err := KestraTestClient().Executions().PauseExecution(ctx, exec.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_PAUSED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("pauseExecutionsByIdsTest", func(t *testing.T) {
		namespace1 := randomId()
		namespace2 := randomId()
		namespace3 := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace1, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace2, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace3, SLEEP_CONCURRENCY_FLOW)

		exec1 := createExecutionUntil(t, ctx, flowId, namespace1, kestra_api_client.STATETYPE_RUNNING)
		exec2 := createExecutionUntil(t, ctx, flowId, namespace2, kestra_api_client.STATETYPE_RUNNING)
		createExecutionUntil(t, ctx, flowId, namespace3, kestra_api_client.STATETYPE_RUNNING)

		res, err := KestraTestClient().Executions().PauseExecutionsByIds(ctx, MAIN_TENANT, []string{exec1.Id, exec2.Id})
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
		ctx := context.Background()
		createFlow(ctx, flowId, namespace1, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace2, SLEEP_CONCURRENCY_FLOW)
		createFlow(ctx, flowId, namespace3, SLEEP_CONCURRENCY_FLOW)

		createExecutionUntil(t, ctx, flowId, namespace1, kestra_api_client.STATETYPE_RUNNING)
		exec2 := createExecutionUntil(t, ctx, flowId, namespace2, kestra_api_client.STATETYPE_RUNNING)
		createExecutionUntil(t, ctx, flowId, namespace3, kestra_api_client.STATETYPE_RUNNING)

		filter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     namespace2,
		}
		res, err := KestraTestClient().Executions().PauseExecutionsByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{filter})
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
		require.Eventually(t, executionInState(ctx, exec2.Id, kestra_api_client.STATETYPE_PAUSED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("replayExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		res, err := KestraTestClient().Executions().ReplayExecution(ctx, exec.Id, MAIN_TENANT, nil, nil, nil)
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_CREATED, res.State.Current)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("replayExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecution(t, ctx, flowId, namespace)

		res, err := KestraTestClient().Executions().ReplayExecutionsByIds(ctx, MAIN_TENANT, []string{exec.Id}, nil)
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
	})
	t.Run("replayExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		createExecution(t, ctx, flowId, namespace)
		filter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     namespace,
		}
		res, err := KestraTestClient().Executions().ReplayExecutionsByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{filter}, nil)
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
	})
	t.Run("restartExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, FAILED_FLOW)

		exec := createExecution(t, ctx, flowId, namespace)

		res, err := KestraTestClient().Executions().RestartExecution(ctx, exec.Id, MAIN_TENANT, nil)
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_RESTARTED, res.State.Current)
	})
	t.Run("restartExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, FAILED_FLOW)

		exec := createExecution(t, ctx, flowId, namespace)

		res, err := KestraTestClient().Executions().RestartExecutionsByIds(ctx, MAIN_TENANT, []string{exec.Id})
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
	})
	t.Run("restartExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, FAILED_FLOW)

		createExecution(t, ctx, flowId, namespace)
		filter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     namespace,
		}
		res, err := KestraTestClient().Executions().RestartExecutionsByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{filter})
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
	})
	t.Run("resumeExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, PAUSE_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_PAUSED)

		_, err := KestraTestClient().Executions().ResumeExecution(ctx, exec.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("resumeExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, PAUSE_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_PAUSED)

		res, err := KestraTestClient().Executions().ResumeExecutionsByIds(ctx, MAIN_TENANT, []string{exec.Id})
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("resumeExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, PAUSE_FLOW)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_PAUSED)
		filter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     namespace,
		}
		res, err := KestraTestClient().Executions().ResumeExecutionsByQuery(ctx, MAIN_TENANT, []kestra_api_client.SearchFilter{filter})
		require.NoError(t, err)
		require.EqualValues(t, 1, res.GetCount())
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("searchExecutionsTest", func(t *testing.T) {
		namespace := randomId()
		otherNamespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		createSimpleFlow(ctx, flowId, otherNamespace)

		exec1 := createExecution(t, ctx, flowId, namespace)
		exec2 := createExecution(t, ctx, flowId, namespace)
		exec3 := createExecution(t, ctx, flowId, otherNamespace)
		exec4 := createExecution(t, ctx, flowId, otherNamespace)
		exec5 := createExecution(t, ctx, flowId, otherNamespace)

		flowFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterFlowId,
			Operation: kestra_api_client.OpEquals,
			Value:     flowId,
		}
		res, err := KestraTestClient().Executions().SearchExecutions(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(50), nil, []kestra_api_client.SearchFilter{flowFilter})
		require.NoError(t, err)
		require.EqualValues(t, 5, res.Total)
		require.Len(t, res.Results, 5)
		assertResultsContainExecutions(t, res.Results, exec1, exec2, exec3, exec4, exec5)

		// page 1 and size 1
		res, err = KestraTestClient().Executions().SearchExecutions(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(1), nil, []kestra_api_client.SearchFilter{flowFilter})
		require.NoError(t, err)
		require.EqualValues(t, 5, res.Total)
		require.Len(t, res.Results, 1)

		// add namespace filter
		nsFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpEquals,
			Value:     namespace,
		}
		res, err = KestraTestClient().Executions().SearchExecutions(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(50), nil, []kestra_api_client.SearchFilter{flowFilter, nsFilter})
		require.NoError(t, err)
		require.Len(t, res.Results, 2)
		assertResultsContainExecutions(t, res.Results, exec1, exec2)

		// invert ns filter
		notEqualNsFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterNamespace,
			Operation: kestra_api_client.OpNotEquals,
			Value:     namespace,
		}
		res, err = KestraTestClient().Executions().SearchExecutions(ctx, MAIN_TENANT, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(50), nil, []kestra_api_client.SearchFilter{flowFilter, notEqualNsFilter})
		require.NoError(t, err)
		require.Len(t, res.Results, 3)
		assertResultsContainExecutions(t, res.Results, exec3, exec4, exec5)
	})
	t.Run("setLabelsOnTerminatedExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		labels := []kestra_api_client.Label{{Key: "label1", Value: "created"}}

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		_, err := KestraTestClient().Executions().SetLabelsOnTerminatedExecution(ctx, exec.Id, MAIN_TENANT, labels)
		require.NoError(t, err)

		res, err := KestraTestClient().Executions().Execution(ctx, exec.Id, MAIN_TENANT)
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
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		labels := []kestra_api_client.Label{{Key: "label1", Value: "created"}}

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)
		req := kestra_api_client.ExecutionControllerSetLabelsByIdsRequest{
			ExecutionsId:    []string{exec.Id},
			ExecutionLabels: labels,
		}
		_, err := KestraTestClient().Executions().SetLabelsOnTerminatedExecutionsByIds(ctx, MAIN_TENANT, req)
		require.NoError(t, err)

		require.Eventually(t, func() bool {
			res, err := KestraTestClient().Executions().Execution(ctx, exec.Id, MAIN_TENANT)
			if err != nil {
				return false
			}
			for _, l := range res.Labels {
				if l.Key == labels[0].Key && l.Value == labels[0].Value {
					return true
				}
			}
			return false
		}, 10*time.Second, 500*time.Millisecond, "expected label to be set on execution")
	})
	t.Run("setLabelsOnTerminatedExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		labels := []kestra_api_client.Label{{Key: "label1", Value: "created"}}

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)
		filter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterFlowId,
			Operation: kestra_api_client.OpEquals,
			Value:     flowId,
		}
		_, err := KestraTestClient().Executions().SetLabelsOnTerminatedExecutionsByQuery(ctx, MAIN_TENANT, labels, []kestra_api_client.SearchFilter{filter})
		require.NoError(t, err)

		require.Eventually(t, func() bool {
			res, err := KestraTestClient().Executions().Execution(ctx, exec.Id, MAIN_TENANT)
			if err != nil {
				return false
			}
			for _, l := range res.Labels {
				if l.Key == labels[0].Key && l.Value == labels[0].Value {
					return true
				}
			}
			return false
		}, 10*time.Second, 500*time.Millisecond, "expected label to be set on execution")
	})
	t.Run("triggerExecutionByGetWebhookTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, WEBHOOK_FLOW)
		key := "a-secret-key"

		res, err := KestraTestClient().Executions().TriggerExecutionByGetWebhook(ctx, MAIN_TENANT, namespace, flowId, key)
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, *res.Id, kestra_api_client.STATETYPE_SUCCESS), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("unqueueExecutionTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		res, err := KestraTestClient().Executions().UnqueueExecution(ctx, execQueued.Id, MAIN_TENANT, kestra_api_client.PtrString(string(kestra_api_client.STATETYPE_CANCELLED)))
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
		require.Eventually(t, executionInState(ctx, res.Id, kestra_api_client.STATETYPE_CANCELLED), 5*time.Second, 100*time.Millisecond)
	})
	t.Run("unqueueExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		_, err := KestraTestClient().Executions().UnqueueExecutionsByIds(ctx, MAIN_TENANT, kestra_api_client.PtrString(string(kestra_api_client.STATETYPE_CANCELLED)), []string{execQueued.Id})
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_CANCELLED), 10*time.Second, 500*time.Millisecond)
	})
	t.Run("unqueueExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SLEEP_CONCURRENCY_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_RUNNING), 1*time.Second, 100*time.Millisecond)
		execQueued := createExecutionAsync(t, ctx, flowId, namespace)
		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_QUEUED), 1*time.Second, 100*time.Millisecond)

		nsFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterState,
			Operation: kestra_api_client.OpEquals,
			Value:     kestra_api_client.STATETYPE_QUEUED,
		}
		flowFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterFlowId,
			Operation: kestra_api_client.OpEquals,
			Value:     flowId,
		}
		_, err := KestraTestClient().Executions().UnqueueExecutionsByQuery(ctx, MAIN_TENANT, kestra_api_client.PtrString(string(kestra_api_client.STATETYPE_CANCELLED)), []kestra_api_client.SearchFilter{nsFilter, flowFilter})
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, execQueued.Id, kestra_api_client.STATETYPE_CANCELLED), 10*time.Second, 500*time.Millisecond)
	})
	t.Run("updateExecutionStatusTest", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		_, err := KestraTestClient().Executions().UpdateExecutionStatus(ctx, exec.Id, string(kestra_api_client.STATETYPE_CANCELLED), MAIN_TENANT)
		require.NoError(t, err)

		res, err := KestraTestClient().Executions().Execution(ctx, exec.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_CANCELLED, res.State.Current)
	})
	t.Run("updateExecutionsByIdsTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		_, err := KestraTestClient().Executions().UpdateExecutionsStatusByIds(ctx, MAIN_TENANT, string(kestra_api_client.STATETYPE_CANCELLED), []string{exec.Id})
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_CANCELLED), 10*time.Second, 500*time.Millisecond)
	})
	t.Run("updateExecutionsByQueryTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		flowFilter := kestra_api_client.SearchFilter{
			Field:     kestra_api_client.FilterFlowId,
			Operation: kestra_api_client.OpEquals,
			Value:     flowId,
		}
		_, err := KestraTestClient().Executions().UpdateExecutionsStatusByQuery(ctx, MAIN_TENANT, string(kestra_api_client.STATETYPE_CANCELLED), []kestra_api_client.SearchFilter{flowFilter})
		require.NoError(t, err)

		require.Eventually(t, executionInState(ctx, exec.Id, kestra_api_client.STATETYPE_CANCELLED), 10*time.Second, 500*time.Millisecond)
	})
	t.Run("updateTaskRunState", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)

		exec := createExecutionUntil(t, ctx, flowId, namespace, kestra_api_client.STATETYPE_SUCCESS)

		res, err := KestraTestClient().Executions().UpdateTaskRunState(ctx, exec.Id, MAIN_TENANT,
			kestra_api_client.ExecutionControllerStateRequest{
				TaskRunId: exec.TaskRunList[0].Id,
				State:     kestra_api_client.STATETYPE_FAILED,
			},
		)
		require.NoError(t, err)
		require.EqualValues(t, kestra_api_client.STATETYPE_FAILED, res.TaskRunList[0].State.Current)
	})

	t.Run("followExecution_shouldWorkForASuccessExecution", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createFlow(ctx, flowId, namespace, SIMPLE_BUT_LONG_FLOW)

		exec := createExecutionAsync(t, ctx, flowId, namespace)

		// this endpoint is returning SSE
		// executions is a channel that receive execution events and then get closed when execution is completed
		// to test it we just run an execution as would a real user do, accumulate with an infinite loop and run assertions when 'close' signal was received
		executions, err := KestraTestClient().Executions().FollowExecution(ctx, exec.Id, MAIN_TENANT)
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
		ctx := context.Background()
		ctx, cancel := context.WithCancel(ctx)
		defer cancel()

		createFlow(ctx, flowId, namespace, LONG_RUNNING_FLOW)
		exec := createExecutionAsync(t, ctx, flowId, namespace)

		executions, err := KestraTestClient().Executions().FollowExecution(ctx, exec.Id, MAIN_TENANT)
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
		ctx := context.Background()
		ctx, cancel := context.WithTimeout(ctx, 200*time.Millisecond)
		defer cancel()

		createFlow(ctx, flowId, namespace, LONG_RUNNING_FLOW)
		exec := createExecutionAsync(t, ctx, flowId, namespace)

		executions, err := KestraTestClient().Executions().FollowExecution(ctx, exec.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.NotNil(t, executions)

		// when timeout is set and reached

		// then
		require.Eventually(t, func() bool {
			return checkChannelIsClosed(executions)
		}, 5*time.Second, 100*time.Millisecond,
			"channel should be closed soon after timeout")
	})

	t.Run("followDependenciesExecutions", func(t *testing.T) {
		t.Skip("Requires new /actions/ execution paths not yet in the Docker image")
		namespace := randomId()
		flowId := randomId()
		dependentFlowId := randomId()
		ctx := context.Background()
		createDependentFlow(ctx, dependentFlowId, namespace, flowId, DEPENDENT_FLOW_OF_LOG_FLOW)
		time.Sleep(200 * time.Millisecond) // wait for flow topology
		createFlow(ctx, flowId, namespace, LOG_FLOW)

		awaitUntilFlowDependenciesContainsSpecificFlowId(t, ctx, namespace, flowId, dependentFlowId)

		exec := createExecution(t, ctx, flowId, namespace)

		// this endpoint is returning SSE
		executions, err := KestraTestClient().Executions().FollowDependenciesExecution(ctx, exec.Id, MAIN_TENANT, kestra_api_client.PtrBool(false), kestra_api_client.PtrBool(false))
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
					if executionStatusEvent.FlowId == dependentFlowId {
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
			if e != nil {
				states = append(states, e.State.Current)
				if e.State.Current == kestra_api_client.STATETYPE_CREATED || e.State.Current == kestra_api_client.STATETYPE_RUNNING || e.State.Current == kestra_api_client.STATETYPE_SUCCESS {
					hasAtLeastOneCreatedSuccessOrRunning = true
					break
				}
			}
		}
		require.True(t, hasAtLeastOneCreatedSuccessOrRunning, "at least one CREATED or RUNNING or SUCCESS event should be returned for this dependent flow, but there was instead: %s", states)
	})

	t.Run("searchExecutionsByFlowIdTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		createExecution(t, ctx, flowId, namespace)

		res, err := KestraTestClient().Executions().SearchExecutionsByFlowId(ctx, MAIN_TENANT, namespace, flowId, kestra_api_client.PtrInt(1), kestra_api_client.PtrInt(10))
		require.NoError(t, err)
		require.NotNil(t, res)
		require.NotEmpty(t, res.GetResults())
	})

	t.Run("flowFromExecutionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		createExecution(t, ctx, flowId, namespace)

		flow, err := KestraTestClient().Executions().FlowFromExecution(ctx, MAIN_TENANT, namespace, flowId, nil)
		require.NoError(t, err)
		require.NotNil(t, flow)
	})

	t.Run("evalExpressionTest", func(t *testing.T) {
		namespace := randomId()
		flowId := randomId()
		ctx := context.Background()
		createSimpleFlow(ctx, flowId, namespace)
		exec := createExecution(t, ctx, flowId, namespace)

		result, err := KestraTestClient().Executions().EvalExpression(ctx, exec.Id, MAIN_TENANT, "{{ execution.id }}")
		require.NoError(t, err)
		require.NotNil(t, result)
	})

	t.Run("triggerExecutionByGetWebhookWithPathTest", func(t *testing.T) {
		t.Skip("Requires a flow with webhook trigger configured")
	})

	t.Run("triggerExecutionByPostWebhookWithPathTest", func(t *testing.T) {
		t.Skip("Requires a flow with webhook trigger configured")
	})

	t.Run("triggerExecutionByPutWebhookWithPathTest", func(t *testing.T) {
		t.Skip("Requires a flow with webhook trigger configured")
	})
}

func awaitUntilFlowDependenciesContainsSpecificFlowId(t *testing.T, ctx context.Context, namespace string, flowId string, dependentFlowId string) {
	require.Eventually(t, flowDependenciesContainsSpecificFlowId(t, ctx, namespace, flowId, dependentFlowId), 5*time.Second, 100*time.Millisecond)
}
func flowDependenciesContainsSpecificFlowId(t *testing.T, ctx context.Context, namespace string, flowId string, dependencyToFind string) func() bool {
	return func() bool {
		dependencies, err := KestraTestClient().Flows().FlowDependencies(ctx, namespace, flowId, MAIN_TENANT, kestra_api_client.PtrBool(false), kestra_api_client.PtrBool(false))
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
	results []kestra_api_client.ApiLightExecution,
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
		exec, err := KestraTestClient().Executions().Execution(ctx, execId, MAIN_TENANT)
		if err != nil {
			return false
		}
		return exec.State.Current == expectedType
	}
}
func createExecutionUntil(t *testing.T, ctx context.Context, flowId string, ns string, expectedType kestra_api_client.StateType) *kestra_api_client.ApiExecution {
	res := createExecutionAsync(t, ctx, flowId, ns)
	execId := res.Id
	require.Eventually(t, executionInState(ctx, execId, expectedType), 5*time.Second, 100*time.Millisecond)
	ress, err := KestraTestClient().Executions().Execution(ctx, execId, MAIN_TENANT)
	require.NoError(t, err)
	return ress
}
