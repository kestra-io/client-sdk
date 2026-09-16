"""Tests for the cases SDK surface added for #421.

Cases are an EE feature gated behind the ``CASE`` resource. On an instance
without that feature the backend answers 403/404/501 rather than a payload, so
the assertions below skip on those instead of failing — an infra gap must not
look like a coverage regression (see AGENTS.md).

Request bodies are sent as plain dicts (the wrapper accepts ``Dict[str, Any]``),
so the field names below are the backend's camelCase JSON keys.
"""
import contextlib

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    BadRequestException,
    ForbiddenException,
    NotFoundException,
    ServiceException,
    UnprocessableEntityException,
)

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


def _create_case(client, **overrides):
    body = {
        "namespace": "io.kestra.sdk",
        "title": f"sdk-case-{random_id()}",
        "severity": "LOW",
    }
    body.update(overrides)
    return client.cases.create_case(TENANT, body)


# --------------------------------------------------------------------------- #
# Search / counts / assignees
# --------------------------------------------------------------------------- #

def test_search_cases_returns_paged_results(client):
    with _tolerate_gating("search_cases"):
        result = client.cases.search_cases(TENANT, page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_case_counts_returns_mapping(client):
    with _tolerate_gating("case_counts"):
        result = client.cases.case_counts(TENANT)
    # A per-status count map; every value must be a non-negative integer.
    assert isinstance(result, dict)
    assert all(isinstance(v, int) and v >= 0 for v in result.values())


def test_case_assignees_returns_paged_results(client):
    with _tolerate_gating("case_assignees"):
        result = client.cases.case_assignees(TENANT)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


# --------------------------------------------------------------------------- #
# Create / read / update / delete round-trip
# --------------------------------------------------------------------------- #

def test_case_crud_round_trip(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    assert created.id is not None
    assert created.namespace == "io.kestra.sdk"
    assert created.title.startswith("sdk-case-")
    try:
        fetched = client.cases.get_case(TENANT, created.id)
        assert fetched.id == created.id
        assert fetched.title == created.title

        updated = client.cases.update_case(
            TENANT, created.id, {"title": "sdk-case-renamed", "severity": "HIGH"}
        )
        assert updated.title == "sdk-case-renamed"
    finally:
        client.cases.delete_case(TENANT, created.id)

    with pytest.raises(NotFoundException):
        client.cases.get_case(TENANT, created.id)


def test_delete_cases_by_ids_reports_count(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    result = client.cases.delete_cases_by_ids(TENANT, [created.id])
    assert result.count is not None and result.count >= 1


def test_delete_cases_by_query_reports_count(client):
    with _tolerate_gating("delete_cases_by_query"):
        result = client.cases.delete_cases_by_query(TENANT, filters=None)
    assert result.count is not None and result.count >= 0


# --------------------------------------------------------------------------- #
# Lifecycle
# --------------------------------------------------------------------------- #

def test_case_lifecycle_transitions(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        acked = client.cases.acknowledge_case(TENANT, created.id)
        assert acked.id == created.id
        assert acked.status in ("ACKNOWLEDGED", "INVESTIGATING", "OPEN")

        resolved = client.cases.resolve_case(
            TENANT, created.id, {"reason": "fixed", "note": "handled by sdk test"}
        )
        assert resolved.id == created.id
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_change_case_status(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        updated = client.cases.change_case_status(TENANT, created.id, {"status": "INVESTIGATING"})
        assert updated.id == created.id
        assert updated.status == "INVESTIGATING"
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_assign_and_follow_case(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        assigned = client.cases.assign_case(
            TENANT, created.id, {"assignees": {"users": [], "groups": []}}
        )
        assert assigned.id == created.id

        followed = client.cases.follow_case(TENANT, created.id)
        assert followed.id == created.id
        unfollowed = client.cases.unfollow_case(TENANT, created.id)
        assert unfollowed.id == created.id
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_cancel_case(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        cancelled = client.cases.cancel_case(TENANT, created.id, {"note": "no longer relevant"})
        assert cancelled.id == created.id
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_acknowledge_cases_by_ids(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        result = client.cases.acknowledge_cases_by_ids(TENANT, [created.id])
        assert result.count is not None and result.count >= 1
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


# --------------------------------------------------------------------------- #
# Events / comments / attachments
# --------------------------------------------------------------------------- #

def test_case_events_paged(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        events = client.cases.case_events(TENANT, created.id, page=1, size=10)
        assert events.total is not None and events.total >= 0
        assert isinstance(events.results, list)
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_add_case_comment(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        event = client.cases.add_case_comment(TENANT, created.id, body="a comment from the sdk")
        assert event.id is not None
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_download_case_attachment_missing_raises(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        with pytest.raises((NotFoundException, BadRequestException, UnprocessableEntityException)):
            client.cases.download_case_attachment(TENANT, created.id, random_id())
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


# --------------------------------------------------------------------------- #
# Linked executions
# --------------------------------------------------------------------------- #

def test_case_executions_paged(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        execs = client.cases.case_executions(TENANT, created.id, page=1, size=10)
        assert execs.total is not None and execs.total >= 0
        assert isinstance(execs.results, list)
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_cases_by_executions_returns_mapping(client):
    with _tolerate_gating("cases_by_executions"):
        result = client.cases.cases_by_executions(TENANT, [random_id()])
    assert isinstance(result, dict)


# --------------------------------------------------------------------------- #
# Assets
# --------------------------------------------------------------------------- #

def test_case_assets_paged(client):
    with _tolerate_gating("create_case"):
        created = _create_case(client)
    try:
        assets = client.cases.case_assets(TENANT, created.id)
        assert assets.total is not None and assets.total >= 0
        assert isinstance(assets.results, list)
    finally:
        with contextlib.suppress(Exception):
            client.cases.delete_case(TENANT, created.id)


def test_cases_by_asset_paged(client):
    with _tolerate_gating("cases_by_asset"):
        result = client.cases.cases_by_asset(TENANT, random_id())
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)
