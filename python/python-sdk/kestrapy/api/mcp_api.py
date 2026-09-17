from typing import Optional

import requests

from kestrapy.base_api import BaseApi


class McpApi(BaseApi):
    """MCP Streamable-HTTP transport proxy (`/api/v1/{tenant}/mcp/{id}`).

    Forwards JSON-RPC messages to the configured MCP server ``id`` and returns
    the raw response (an SSE stream or a JSON-RPC reply). The server answers 404
    when no MCP server matches ``id`` and 503 when it is disabled.

    Session correlation uses the ``MCP-Session-Id`` header: read it off the
    response of :meth:`open_mcp_session`, then pass it back as ``mcp_session_id``
    to :meth:`send_mcp_request` and :meth:`close_mcp_session` so they address the
    same session. The caller owns and must close the returned response body.
    """

    _MCP_ACCEPT = "text/event-stream, application/json"
    _SESSION_HEADER = "MCP-Session-Id"

    def _session_headers(self, mcp_session_id: Optional[str]) -> Optional[dict]:
        return {self._SESSION_HEADER: mcp_session_id} if mcp_session_id else None

    def open_mcp_session(
        self, id: str, tenant: str, mcp_session_id: Optional[str] = None
    ) -> requests.Response:
        """Issue the GET handshake that opens (or resumes) an MCP session stream.
        Read the ``MCP-Session-Id`` response header to correlate later calls.
        Backs GET /api/v1/{tenant}/mcp/{id}."""
        path = self._tenant_path(tenant, "mcp", id)
        return self._request(
            "GET", path, accept="text/event-stream",
            headers=self._session_headers(mcp_session_id), stream=True,
        )

    def send_mcp_request(
        self, id: str, tenant: str, json_rpc_body: str,
        mcp_session_id: Optional[str] = None,
    ) -> requests.Response:
        """Forward a JSON-RPC message (a raw JSON string) to the MCP server.
        Pass ``mcp_session_id`` (from :meth:`open_mcp_session`) to route the
        message to an existing session. Backs POST /api/v1/{tenant}/mcp/{id}."""
        path = self._tenant_path(tenant, "mcp", id)
        return self._request(
            "POST",
            path,
            body=json_rpc_body,
            content_type=self.JSON,
            accept=self._MCP_ACCEPT,
            headers=self._session_headers(mcp_session_id),
            stream=True,
        )

    def close_mcp_session(
        self, id: str, tenant: str, mcp_session_id: Optional[str] = None
    ) -> requests.Response:
        """Issue the DELETE that terminates an MCP session.
        Pass ``mcp_session_id`` (from :meth:`open_mcp_session`) to terminate a
        specific session. Backs DELETE /api/v1/{tenant}/mcp/{id}."""
        path = self._tenant_path(tenant, "mcp", id)
        return self._request(
            "DELETE", path, accept=self._MCP_ACCEPT,
            headers=self._session_headers(mcp_session_id), stream=True,
        )
