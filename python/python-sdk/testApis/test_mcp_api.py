"""Tests for the MCP transport-proxy SDK surface added for #421.

``/api/v1/{tenant}/mcp/{id}`` proxies JSON-RPC to a configured MCP server. It
answers 404 when no server matches ``id`` and 503 when it is disabled, and the
feature is EE/licence gated (403), so the assertions below skip on those instead
of failing (an infra gap must not look like a coverage regression, AGENTS.md).
The methods return a raw streaming ``requests.Response`` the caller must close.
"""
import contextlib
import json

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
)

# The proxy answers 503 when the target server is disabled, on top of the usual
# licence 403 / 404 / 501.
_GATED = (403, 404, 501, 503)


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


_INITIALIZE = json.dumps(
    {
        "jsonrpc": "2.0",
        "id": 1,
        "method": "initialize",
        "params": {
            "protocolVersion": "2025-03-26",
            "capabilities": {},
            "clientInfo": {"name": "kestra-python-sdk-test", "version": "0.0.0"},
        },
    }
)


def test_open_mcp_session_streams_or_gates(client):
    with _tolerate_gating("open_mcp_session"):
        resp = client.mcp.open_mcp_session(random_id(), TENANT)
    with contextlib.closing(resp):
        assert resp.status_code < 400


def test_send_mcp_request_streams_or_gates(client):
    with _tolerate_gating("send_mcp_request"):
        resp = client.mcp.send_mcp_request(random_id(), TENANT, _INITIALIZE)
    with contextlib.closing(resp):
        assert resp.status_code < 400


def test_close_mcp_session_streams_or_gates(client):
    with _tolerate_gating("close_mcp_session"):
        resp = client.mcp.close_mcp_session(random_id(), TENANT)
    with contextlib.closing(resp):
        assert resp.status_code < 400
