"""Offline test: replay_execution_with_inputs sends a well-formed empty multipart
body when no inputs are given.

The `replay-with-inputs` endpoint requires a multipart body even with nothing to
override (it rejects a bodyless request with 422). This mirrors the Go/Java SDKs,
which send a well-formed empty multipart that the server binds. Runs offline: the
outgoing request is captured before it leaves the client.
"""
import pytest

from kestrapy import KestraClient


class _Captured(Exception):
    pass


def _client_capturing(captured):
    client = KestraClient(host="http://localhost:1", token="unused")

    def fake_request(method, url, **kwargs):
        captured["method"] = method
        captured["url"] = url
        captured.update(kwargs)
        raise _Captured()

    # Patch the session used by the executions API so nothing hits the network.
    client.executions._session.request = fake_request
    return client


def test_replay_with_inputs_sends_wellformed_empty_multipart_when_no_inputs():
    captured = {}
    client = _client_capturing(captured)

    with pytest.raises(_Captured):
        client.executions.replay_execution_with_inputs("some-execution", "some-tenant")

    content_type = captured["headers"]["Content-Type"]
    assert content_type.startswith("multipart/form-data; boundary=")
    # A well-formed multipart body carries at least the closing boundary and no
    # form parts (no Content-Disposition sections).
    body = captured["data"]
    assert isinstance(body, (bytes, bytearray))
    assert b"--" in body
    assert b"Content-Disposition" not in body
    # It must be a real body, not requests' `files=` path (which would drop it).
    assert captured.get("files") is None


def test_replay_with_inputs_uses_files_path_when_inputs_present():
    captured = {}
    client = _client_capturing(captured)

    with pytest.raises(_Captured):
        client.executions.replay_execution_with_inputs(
            "some-execution", "some-tenant", inputs={"greeting": "hello"}
        )

    # With real inputs, the request goes out as multipart parts via requests' files=.
    assert captured.get("files") is not None
