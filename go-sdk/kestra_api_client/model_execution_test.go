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
		"originalId": "exec-1"
	}`

	var exec Execution
	err := json.Unmarshal([]byte(payload), &exec)
	require.NoError(t, err)

	assert.Equal(t, "exec-1", exec.GetId())
	assert.False(t, exec.HasDeleted())
	assert.False(t, exec.HasMetadata())

	serialized, err := exec.ToMap()
	require.NoError(t, err)
	assert.NotContains(t, serialized, "deleted")
	assert.NotContains(t, serialized, "metadata")
}