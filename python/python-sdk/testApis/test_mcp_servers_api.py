"""Tests for the MCP servers SDK surface added for #421.

MCP servers are gated behind the ``MCP_SERVER`` permission and are an EE
feature, so on an instance without it the backend answers 403/404/501 rather
than a payload; the assertions below skip on those instead of failing (an infra
gap must not look like a coverage regression, see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
)
from kestrapy.models.api_mcp_server import ApiMcpServer
from kestrapy.models.mcp_server_server_type import McpServerServerType

_GATED = (403, 404, 501)


@contextlib.contextmanager
def _tolerate_gating(what):
    try:
        yield
    except (ForbiddenException, NotFoundException) as exc:
        pytest.skip(f"{what}: gated on this instance ({exc.status})")
    except ServiceException as exc:
        if getattr(exc, "status", None) in _GATED:
            pytest.skip(f"{what}: gated on this instance ({exc.status})")
        raise


def _create_server(client):
    server_id = f"sdk-mcp-{random_id()}"
    body = ApiMcpServer(
        id=server_id,
        description="created by the python SDK test suite",
        serverType=McpServerServerType.PRIVATE,
    )
    return server_id, client.mcp_servers.create_mcp_server(TENANT, body)


# --------------------------------------------------------------------------- #
# Read
# --------------------------------------------------------------------------- #

def test_list_mcp_servers_returns_paged_results(client):
    with _tolerate_gating("list_mcp_servers"):
        result = client.mcp_servers.list_mcp_servers(TENANT, page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


# --------------------------------------------------------------------------- #
# Create / read / update / toggle / delete round-trip
# --------------------------------------------------------------------------- #

def test_mcp_server_crud_round_trip(client):
    with _tolerate_gating("create_mcp_server"):
        server_id, created = _create_server(client)
    assert created.id == server_id
    assert created.description == "created by the python SDK test suite"
    try:
        fetched = client.mcp_servers.mcp_server(server_id, TENANT)
        assert fetched.id == server_id

        updated = client.mcp_servers.update_mcp_server(
            server_id,
            TENANT,
            ApiMcpServer(
                id=server_id,
                description="updated by the python SDK test suite",
                serverType=McpServerServerType.PRIVATE,
            ),
        )
        assert updated.description == "updated by the python SDK test suite"

        # tools listing is best-effort — it may be empty for a stub server.
        tools = client.mcp_servers.mcp_server_tools(server_id, TENANT)
        assert isinstance(tools, list)

        with _tolerate_gating("toggle_mcp_server"):
            client.mcp_servers.toggle_mcp_server(server_id, TENANT)
    finally:
        client.mcp_servers.delete_mcp_server(server_id, TENANT)

    with pytest.raises(NotFoundException):
        client.mcp_servers.mcp_server(server_id, TENANT)
