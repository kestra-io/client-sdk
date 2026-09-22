"""Offline guard test for replay_execution_with_inputs.

The ``replay-with-inputs`` endpoint requires a multipart inputs body; a call with
no inputs is rejected client-side before any HTTP request. Replaying without
changing inputs is ``replay_execution``, not this method. This runs offline — the
guard raises before the client ever opens a connection.
"""
import pytest

from kestrapy import ApiValueError, KestraClient


def _offline_client():
    # A bogus host that is never contacted: the guard must raise first.
    return KestraClient(host="http://localhost:1", token="unused")


def test_replay_execution_with_inputs_rejects_missing_inputs():
    client = _offline_client()
    with pytest.raises(ApiValueError):
        client.executions.replay_execution_with_inputs("some-execution", "some-tenant")


def test_replay_execution_with_inputs_rejects_empty_inputs():
    client = _offline_client()
    with pytest.raises(ApiValueError):
        client.executions.replay_execution_with_inputs(
            "some-execution", "some-tenant", inputs={}
        )
