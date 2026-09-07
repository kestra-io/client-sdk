package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestCasesAPI_All(t *testing.T) {
	t.Run("createCaseFromTaskTest", func(t *testing.T) {
		ctx := context.Background()
		namespace := randomId()
		flowId := randomId()
		createSimpleFlow(ctx, flowId, namespace)

		res, err := KestraTestClient().Cases().CreateCaseFromTask(ctx, MAIN_TENANT, map[string]interface{}{
			"namespace":     namespace,
			"flowNamespace": namespace,
			"flowId":        flowId,
			"taskId":        "hello",
			"title":         "case from " + flowId,
		})
		require.NoError(t, err)
		require.NotNil(t, res)
	})
}
