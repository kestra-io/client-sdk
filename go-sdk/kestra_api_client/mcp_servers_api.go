package kestra_api_client

import "context"

// McpServersAPI covers the tenant-scoped /api/v1/{tenant}/mcp-servers routes.
// Each endpoint requires the matching MCP_SERVER permission (LIST/VIEW/CREATE/
// UPDATE/DELETE).
type McpServersAPI struct {
	baseAPI
}

// ListMcpServers returns a page of the tenant's MCP servers.
func (a *McpServersAPI) ListMcpServers(ctx context.Context, tenant string, page, size *int, sort []string) (*PagedResultsApiMcpServer, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[*PagedResultsApiMcpServer](&a.baseAPI, ctx, "GET", tenantPath(tenant, "mcp-servers"), nil, params)
}

// McpServer returns a single MCP server by id.
func (a *McpServersAPI) McpServer(ctx context.Context, tenant, id string) (*ApiMcpServer, error) {
	return doJSON[*ApiMcpServer](&a.baseAPI, ctx, "GET", tenantPath(tenant, "mcp-servers", id), nil, nil)
}

// McpServerTools lists the tools an MCP server exposes.
func (a *McpServersAPI) McpServerTools(ctx context.Context, tenant, id string) ([]ApiMcpTool, error) {
	return doJSON[[]ApiMcpTool](&a.baseAPI, ctx, "GET", tenantPath(tenant, "mcp-servers", id, "tools"), nil, nil)
}

// CreateMcpServer creates an MCP server. Only Id is required; ServerType and
// AuthType default server-side.
func (a *McpServersAPI) CreateMcpServer(ctx context.Context, tenant string, server ApiMcpServer) (*ApiMcpServer, error) {
	return doJSON[*ApiMcpServer](&a.baseAPI, ctx, "POST", tenantPath(tenant, "mcp-servers"), server, nil)
}

// UpdateMcpServer updates the MCP server with the given id.
func (a *McpServersAPI) UpdateMcpServer(ctx context.Context, tenant, id string, server ApiMcpServer) (*ApiMcpServer, error) {
	return doJSON[*ApiMcpServer](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "mcp-servers", id), server, nil)
}

// DeleteMcpServer deletes the MCP server with the given id.
func (a *McpServersAPI) DeleteMcpServer(ctx context.Context, tenant, id string) error {
	return a.doVoid(ctx, "DELETE", tenantPath(tenant, "mcp-servers", id), nil, nil)
}
