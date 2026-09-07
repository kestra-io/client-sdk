package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

// Kestra 2.0 removed `outputs` from the execution payload and moved it behind
// dedicated endpoints, which the Go SDK had no bindings for at all.
func TestOutputsAPI_All(t *testing.T) {
	ctx := context.Background()

	flowId := randomId()
	namespace := randomId()
	createSimpleFlow(ctx, flowId, namespace)
	execution := createExecution(t, ctx, flowId, namespace)

	t.Run("getExecutionOutputsTest", func(t *testing.T) {
		outputs, err := KestraTestClient().Outputs().ExecutionOutputs(ctx, execution.Id, MAIN_TENANT)
		require.NoError(t, err)
		// LOG_FLOW declares a flow-level output built from the `return` task.
		require.Equal(t, "default_value", outputs["flow_output"])
	})

	t.Run("getTaskOutputsInformationTest", func(t *testing.T) {
		infos, err := KestraTestClient().Outputs().TaskOutputsInformation(ctx, execution.Id, MAIN_TENANT)
		require.NoError(t, err)
		require.NotEmpty(t, infos, "the execution should have task runs carrying outputs")

		var returnTaskRunId string
		for _, info := range infos {
			if info.GetTaskId() == "return" {
				returnTaskRunId = info.GetTaskRunId()
			}
		}
		require.NotEmpty(t, returnTaskRunId, "the `return` task run should be listed")

		outputs, err := KestraTestClient().Outputs().TaskRunOutputs(ctx, execution.Id, returnTaskRunId, MAIN_TENANT)
		require.NoError(t, err)
		require.Equal(t, "default_value", outputs["value"])
	})
}
