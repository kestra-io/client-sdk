"""Offline test: search_case_events sends its list filters as repeated query params
alongside the cursor, the shape the CaseEvent trigger relies on. The outgoing
request is captured before it leaves the client.
"""
import pytest

from kestrapy import KestraClient


class _Captured(Exception):
    pass


def test_search_case_events_sends_the_cursor_and_repeated_list_filters():
    captured = {}
    client = KestraClient(host="http://localhost:1", token="unused")

    def fake_request(method, url, **kwargs):
        captured["method"] = method
        captured["url"] = url
        captured.update(kwargs)
        raise _Captured()

    client.cases._session.request = fake_request

    with pytest.raises(_Captured):
        client.cases.search_case_events(
            "main",
            since_created="2026-10-16T10:00:00Z",
            since_id="evt1",
            events=["CREATED", "TICKET_LINKED"],
            severities=["CRITICAL"],
            namespace="io.kestra",
            assignees=["alice", "ops"],
            size=50,
        )

    assert captured["method"] == "GET"
    assert captured["url"].endswith("/api/v1/main/cases/events/search")
    assert sorted(captured["params"]) == sorted([
        ("sinceCreated", "2026-10-16T10:00:00Z"),
        ("sinceId", "evt1"),
        ("namespace", "io.kestra"),
        ("size", 50),
        ("events", "CREATED"),
        ("events", "TICKET_LINKED"),
        ("severities", "CRITICAL"),
        ("assignees", "alice"),
        ("assignees", "ops"),
    ])
