package test

import (
	"context"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestMcpAPI(t *testing.T) {
	ctx := context.Background()
	client := KestraTestClient()

	// The MCP transport proxy forwards a JSON-RPC message to a configured MCP
	// server looked up by id. A fresh instance has none, so every verb answers
	// 404 (unknown server) or 503 (disabled). We exercise each wrapper and treat
	// that expected gate as a skip.
	t.Run("openSession", func(t *testing.T) {
		resp, err := client.Mcp().OpenMcpSession(ctx, "missing-"+randomId(), MAIN_TENANT)
		if err != nil {
			_ = skipIfGated(t, err, "the MCP proxy (no server configured)")
			require.NoError(t, err)
			return
		}
		require.NotNil(t, resp)
		resp.Body.Close()
	})

	t.Run("sendRequest", func(t *testing.T) {
		body := `{"jsonrpc":"2.0","id":1,"method":"ping"}`
		resp, err := client.Mcp().SendMcpRequest(ctx, "missing-"+randomId(), MAIN_TENANT, body)
		if err != nil {
			_ = skipIfGated(t, err, "the MCP proxy (no server configured)")
			require.NoError(t, err)
			return
		}
		require.NotNil(t, resp)
		resp.Body.Close()
	})

	t.Run("closeSession", func(t *testing.T) {
		resp, err := client.Mcp().CloseMcpSession(ctx, "missing-"+randomId(), MAIN_TENANT)
		if err != nil {
			_ = skipIfGated(t, err, "the MCP proxy (no server configured)")
			require.NoError(t, err)
			return
		}
		require.NotNil(t, resp)
		resp.Body.Close()
	})
}
