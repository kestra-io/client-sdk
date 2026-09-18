package test

import (
	"context"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/kestra-io/client-sdk/go-sdk/v2/kestra_api_client"
)

func TestMcpServersAPI_CRUD(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()
	mcp := client.McpServers()

	t.Run("list includes the default server", func(t *testing.T) {
		page, size := 1, 100
		list, err := mcp.ListMcpServers(ctx, MAIN_TENANT, &page, &size, nil)
		require.NoError(t, err)
		found := false
		for _, s := range list.GetResults() {
			if s.GetId() == "default" {
				found = true
			}
		}
		require.True(t, found, "every tenant ships with a built-in \"default\" MCP server")
	})

	t.Run("tools of the default server are reachable", func(t *testing.T) {
		tools, err := mcp.McpServerTools(ctx, MAIN_TENANT, "default")
		require.NoError(t, err, "the tools endpoint is reachable for the default server")
		for _, tool := range tools {
			require.NotEmpty(t, tool.GetToolName(), "each exposed tool has a name")
		}
	})

	id := "sdk-mcp-" + strings.ToLower(randomId())
	created, err := mcp.CreateMcpServer(ctx, MAIN_TENANT, kestra_api_client.ApiMcpServer{
		Id:          id,
		Description: "created by the Go SDK test suite",
	})
	require.NoError(t, err, "creating an MCP server should succeed with the MCP_SERVER permission")
	require.Equal(t, id, created.GetId())
	require.Equal(t, "PRIVATE", created.GetServerType(), "serverType defaults to PRIVATE server-side")
	require.False(t, created.GetIsDefault(), "a created server is not the default one")

	deleted := false
	t.Cleanup(func() {
		if !deleted {
			_ = mcp.DeleteMcpServer(context.Background(), MAIN_TENANT, id)
		}
	})

	t.Run("get by id", func(t *testing.T) {
		got, err := mcp.McpServer(ctx, MAIN_TENANT, id)
		require.NoError(t, err)
		require.Equal(t, id, got.GetId())
		require.Equal(t, "created by the Go SDK test suite", got.GetDescription())
	})

	t.Run("update", func(t *testing.T) {
		updated, err := mcp.UpdateMcpServer(ctx, MAIN_TENANT, id, kestra_api_client.ApiMcpServer{
			Id:          id,
			Description: "updated description",
		})
		require.NoError(t, err)
		require.Equal(t, "updated description", updated.GetDescription(), "the description change round-trips")
	})

	t.Run("delete", func(t *testing.T) {
		require.NoError(t, mcp.DeleteMcpServer(ctx, MAIN_TENANT, id))
		deleted = true
		_, err := mcp.McpServer(ctx, MAIN_TENANT, id)
		var apiErr *kestra_api_client.ApiError
		require.ErrorAs(t, err, &apiErr, "the server must be gone after deletion")
		require.Equal(t, 404, apiErr.StatusCode)
	})
}
