import requests

from kestrapy.base_api import BaseApi


class McpApi(BaseApi):
    """MCP Streamable-HTTP transport proxy (`/api/v1/{tenant}/mcp/{id}`).

    Forwards JSON-RPC messages to the configured MCP server ``id`` and returns
    the raw response (an SSE stream or a JSON-RPC reply). The server answers 404
    when no MCP server matches ``id`` and 503 when it is disabled. Session
    correlation uses the ``MCP-Session-Id`` header; the caller owns and must
    close the returned response body.
    """

    _MCP_ACCEPT = "text/event-stream, application/json"

    def open_mcp_session(self, id: str, tenant: str) -> requests.Response:
        """Issue the GET handshake that opens an MCP session stream.
        Backs GET /api/v1/{tenant}/mcp/{id}."""
        path = self._tenant_path(tenant, "mcp", id)
        return self._request("GET", path, accept="text/event-stream", stream=True)

    def send_mcp_request(self, id: str, tenant: str, json_rpc_body: str) -> requests.Response:
        """Forward a JSON-RPC message (a raw JSON string) to the MCP server.
        Backs POST /api/v1/{tenant}/mcp/{id}."""
        path = self._tenant_path(tenant, "mcp", id)
        return self._request(
            "POST",
            path,
            body=json_rpc_body,
            content_type=self.JSON,
            accept=self._MCP_ACCEPT,
            stream=True,
        )

    def close_mcp_session(self, id: str, tenant: str) -> requests.Response:
        """Issue the DELETE that terminates an MCP session.
        Backs DELETE /api/v1/{tenant}/mcp/{id}."""
        path = self._tenant_path(tenant, "mcp", id)
        return self._request("DELETE", path, accept=self._MCP_ACCEPT, stream=True)
