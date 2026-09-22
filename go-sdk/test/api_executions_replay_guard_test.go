package test

import (
	"context"
	"testing"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
	"github.com/stretchr/testify/require"
)

// ReplayExecutionWithInputs requires a non-empty inputs body; the endpoint
// rejects a call with none. The client guards this before any HTTP request, so
// this runs offline against an unreachable host.
func TestReplayExecutionWithInputs_RequiresInputs(t *testing.T) {
	ctx := context.Background()
	client := kestra_api_client.NewClient("http://localhost:1", kestra_api_client.WithTokenAuth("unused"))

	t.Run("nil inputs", func(t *testing.T) {
		_, err := client.Executions().ReplayExecutionWithInputs(ctx, "some-execution", "some-tenant", nil, nil, nil, nil)
		require.Error(t, err)
	})

	t.Run("empty inputs", func(t *testing.T) {
		_, err := client.Executions().ReplayExecutionWithInputs(ctx, "some-execution", "some-tenant", nil, nil, nil, map[string]string{})
		require.Error(t, err)
	})
}
