package kestra_api_client

import (
	"encoding/json"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestExecutionUnmarshalWithoutDeletedAndMetadata(t *testing.T) {
	payload := `{
		"id": "exec-1",
		"namespace": "company.team",
		"flowId": "my-flow",
		"flowRevision": 1,
		"state": {"current": "SUCCESS", "histories": []},
		"originalId": "exec-1",
		"taskRunList": [
			{
				"id": "tr-1",
				"taskId": "log",
				"state": {"current": "SUCCESS", "histories": []},
				"attempts": []
			}
		]
	}`

	var exec Execution
	err := json.Unmarshal([]byte(payload), &exec)
	require.NoError(t, err)

	assert.Equal(t, "exec-1", exec.GetId())
	assert.False(t, exec.HasDeleted())
	assert.False(t, exec.HasMetadata())

	taskRuns := exec.GetTaskRunList()
	require.Len(t, taskRuns, 1)
	assert.Equal(t, "tr-1", taskRuns[0].GetId())
	assert.False(t, taskRuns[0].HasExecutionId())
	assert.False(t, taskRuns[0].HasNamespace())
	assert.False(t, taskRuns[0].HasFlowId())

	serialized, err := exec.ToMap()
	require.NoError(t, err)
	assert.NotContains(t, serialized, "deleted")
	assert.NotContains(t, serialized, "metadata")

	trMap, err := taskRuns[0].ToMap()
	require.NoError(t, err)
	assert.NotContains(t, trMap, "executionId")
	assert.NotContains(t, trMap, "namespace")
	assert.NotContains(t, trMap, "flowId")
}
