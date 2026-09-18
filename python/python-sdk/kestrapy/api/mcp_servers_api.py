from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_mcp_server import ApiMcpServer
from kestrapy.models.mcp_server_controller_api_mcp_tool import McpServerControllerApiMcpTool
from kestrapy.models.paged_results_api_mcp_server import PagedResultsApiMcpServer


class McpServersApi(BaseApi):
    """Tenant-scoped MCP servers (`/api/v1/{tenant}/mcp-servers`).

    Each endpoint requires the matching ``MCP_SERVER`` permission
    (LIST/VIEW/CREATE/UPDATE/DELETE) and is licence-gated on EE.
    """

    def list_mcp_servers(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
    ) -> PagedResultsApiMcpServer:
        path = self._tenant_path(tenant, "mcp-servers")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        return self._json_request("GET", path, PagedResultsApiMcpServer, params=params)

    def mcp_server(self, id: str, tenant: str) -> ApiMcpServer:
        path = self._tenant_path(tenant, "mcp-servers", id)
        return self._json_request("GET", path, ApiMcpServer)

    def mcp_server_tools(self, id: str, tenant: str) -> List[McpServerControllerApiMcpTool]:
        path = self._tenant_path(tenant, "mcp-servers", id, "tools")
        return self._json_list_request("GET", path, McpServerControllerApiMcpTool)

    def create_mcp_server(self, tenant: str, body: ApiMcpServer) -> ApiMcpServer:
        path = self._tenant_path(tenant, "mcp-servers")
        return self._json_request("POST", path, ApiMcpServer, body=body)

    def update_mcp_server(self, id: str, tenant: str, body: ApiMcpServer) -> ApiMcpServer:
        path = self._tenant_path(tenant, "mcp-servers", id)
        return self._json_request("PUT", path, ApiMcpServer, body=body)

    def delete_mcp_server(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "mcp-servers", id)
        self._void_request("DELETE", path)

    def toggle_mcp_server(self, id: str, tenant: str) -> Dict[str, Any]:
        """Enable/disable an MCP server.
        Backs PATCH /api/v1/{tenant}/mcp-servers/{id}/toggle."""
        path = self._tenant_path(tenant, "mcp-servers", id, "toggle")
        return self._raw_json_request("PATCH", path)
