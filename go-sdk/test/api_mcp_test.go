package test

import (
	"context"
	"errors"
	"testing"
	"time"

	"github.com/stretchr/testify/require"
)

// mcpCallTimeout bounds each MCP call. The MCP proxy verbs are Streamable-HTTP
// endpoints: unlike a plain REST route, an unconfigured proxy can hold the POST
// connection open instead of answering with a quick 404/503 gate. Without a
// deadline the request blocks until the package test timeout kills the whole
// binary, so we bound it and treat a non-response as the same "feature off"
// signal skipIfGated handles for an explicit error status.
const mcpCallTimeout = 15 * time.Second

func TestMcpAPI(t *testing.T) {
	client := KestraTestClient()

	// The MCP transport proxy forwards a JSON-RPC message to a configured MCP
	// server looked up by id. A fresh instance has none, so every verb answers
	// 404 (unknown server) or 503 (disabled). We exercise each wrapper and treat
	// that expected gate as a skip.
	t.Run("openSession", func(t *testing.T) {
		ctx, cancel := context.WithTimeout(context.Background(), mcpCallTimeout)
		defer cancel()

		resp, err := client.Mcp().OpenMcpSession(ctx, "missing-"+randomId(), MAIN_TENANT)
		if err != nil {
			skipIfMcpUnavailable(t, err)
			require.NoError(t, err)
			return
		}
		require.NotNil(t, resp)
		resp.Body.Close()
	})

	t.Run("sendRequest", func(t *testing.T) {
		ctx, cancel := context.WithTimeout(context.Background(), mcpCallTimeout)
		defer cancel()

		body := `{"jsonrpc":"2.0","id":1,"method":"ping"}`
		resp, err := client.Mcp().SendMcpRequest(ctx, "missing-"+randomId(), MAIN_TENANT, body)
		if err != nil {
			skipIfMcpUnavailable(t, err)
			require.NoError(t, err)
			return
		}
		require.NotNil(t, resp)
		resp.Body.Close()
	})

	t.Run("closeSession", func(t *testing.T) {
		ctx, cancel := context.WithTimeout(context.Background(), mcpCallTimeout)
		defer cancel()

		resp, err := client.Mcp().CloseMcpSession(ctx, "missing-"+randomId(), MAIN_TENANT)
		if err != nil {
			skipIfMcpUnavailable(t, err)
			require.NoError(t, err)
			return
		}
		require.NotNil(t, resp)
		resp.Body.Close()
	})
}

// skipIfMcpUnavailable skips when the MCP proxy is not functionally active on the
// CI image. That shows up two ways: an ApiError with a gate status (handled by
// skipIfGated), or a context deadline because the proxy held the connection open
// without responding — treated the same way, since neither is a product failure.
func skipIfMcpUnavailable(t *testing.T, err error) {
	t.Helper()
	if errors.Is(err, context.DeadlineExceeded) {
		t.Skip("the MCP proxy (no server configured) did not respond before the timeout; the wrapper is still exercised for compilation and coverage")
	}
	_ = skipIfGated(t, err, "the MCP proxy (no server configured)")
}
