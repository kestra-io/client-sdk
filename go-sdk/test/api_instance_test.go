package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestInstanceAPI_ServicesAndMaintenance(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	t.Run("active services lists the running services", func(t *testing.T) {
		active, err := client.Instance().ActiveServices(ctx)
		require.NoError(t, err)
		require.Greater(t, active.GetTotal(), int32(0), "a running instance has at least one active service")
		require.NotEmpty(t, active.GetServices(), "the per-type breakdown must not be empty")
		for _, svc := range active.GetServices() {
			require.NotEmpty(t, svc.GetType(), "each active service reports its type")
		}
	})

	t.Run("search services returns the running services", func(t *testing.T) {
		page, size := 1, 50
		results, err := client.Instance().SearchServices(ctx, &page, &size, nil, nil)
		require.NoError(t, err)
		require.NotEmpty(t, results.GetResults(), "the search must return at least the webserver service")
		first := results.GetResults()[0]
		require.NotEmpty(t, first.GetId(), "each service instance has an id")
		require.NotEmpty(t, first.GetType(), "each service instance reports its type")

		t.Run("get service by id", func(t *testing.T) {
			svc, err := client.Instance().Service(ctx, first.GetId())
			require.NoError(t, err)
			require.Equal(t, first.GetId(), svc.GetId(), "fetching by id returns the same service")
		})
	})

	t.Run("maintenance status is off on a normal instance", func(t *testing.T) {
		status, err := client.Instance().MaintenanceStatus(ctx)
		require.NoError(t, err)
		require.False(t, status.GetMaintenance(), "a normal instance is not in maintenance mode")
	})

	t.Run("list all mcp servers across tenants", func(t *testing.T) {
		page, size := 1, 100
		results, err := client.Instance().ListAllMcpServers(ctx, &page, &size, nil)
		require.NoError(t, err, "the instance-wide MCP listing is reachable as instance owner")
		require.Equal(t, int64(len(results.GetResults())), min64(results.GetTotal(), int64(size)),
			"the page size matches the returned rows for the first page")
		for _, mcp := range results.GetResults() {
			require.NotEmpty(t, mcp.GetId(), "each MCP server has an id")
		}
	})
}

func min64(a, b int64) int64 {
	if a < b {
		return a
	}
	return b
}
