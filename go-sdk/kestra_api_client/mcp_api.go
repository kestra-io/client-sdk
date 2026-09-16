package kestra_api_client

import (
	"context"
	"net/http"
	"strings"
)

// McpAPI covers /api/v1/{tenant}/mcp/{id} — the MCP Streamable-HTTP transport
// proxy. It forwards a JSON-RPC message to the configured MCP server `id` and
// returns the raw response (an SSE stream or a JSON-RPC reply). The server
// answers 404 when no MCP server matches `id` and 503 when it is disabled.
//
// Session correlation uses the MCP-Session-Id header; the caller supplies it via
// the returned/passed response as required by the MCP spec. The caller owns and
// must close the returned response body.
type McpAPI struct {
	baseAPI
}

// OpenMcpSession issues the GET handshake that opens an MCP session stream. Backs
// GET /api/v1/{tenant}/mcp/{id}.
func (a *McpAPI) OpenMcpSession(ctx context.Context, id, tenant string) (*http.Response, error) {
	return a.doRequest(ctx, "GET", tenantPath(tenant, "mcp", id), nil, nil, "text/event-stream", contentJSON)
}

// SendMcpRequest forwards a JSON-RPC message (a raw JSON string) to the MCP
// server. Backs POST /api/v1/{tenant}/mcp/{id}.
func (a *McpAPI) SendMcpRequest(ctx context.Context, id, tenant, jsonRpcBody string) (*http.Response, error) {
	return a.doRequest(ctx, "POST", tenantPath(tenant, "mcp", id), strings.NewReader(jsonRpcBody), nil, "text/event-stream, application/json", contentJSON)
}

// CloseMcpSession issues the DELETE that terminates an MCP session. Backs DELETE
// /api/v1/{tenant}/mcp/{id}.
func (a *McpAPI) CloseMcpSession(ctx context.Context, id, tenant string) (*http.Response, error) {
	return a.doRequest(ctx, "DELETE", tenantPath(tenant, "mcp", id), nil, nil, "text/event-stream, application/json", contentJSON)
}
