"""Tests for the auditlogs SDK surface added for #421.

The audit-log controller is gated by the ``AUDITLOG`` resource plus a licence
feature, so routes answer 403 (or 404/501) when unavailable. Live calls are
wrapped in ``_tolerate_gating`` (see AGENTS.md).
"""
import pytest

from test_helpers import TENANT, gating, random_id
from kestrapy.exceptions import NotFoundException

_tolerate_gating = gating()


def test_search_audit_logs_returns_page(client):
    with _tolerate_gating("search_audit_logs"):
        result = client.auditlogs.search_audit_logs(TENANT, page=1, size=10)
    assert isinstance(result, dict)
    assert "results" in result
    assert isinstance(result["results"], list)


def test_search_all_audit_logs_returns_page(client):
    with _tolerate_gating("search_all_audit_logs"):
        result = client.auditlogs.search_all_audit_logs(page=1, size=10)
    assert isinstance(result, dict)
    assert "results" in result


def test_export_audit_logs_returns_csv(client):
    with _tolerate_gating("export_audit_logs"):
        csv = client.auditlogs.export_audit_logs(TENANT)
    assert isinstance(csv, str)


def test_export_all_audit_logs_returns_csv(client):
    with _tolerate_gating("export_all_audit_logs"):
        csv = client.auditlogs.export_all_audit_logs()
    assert isinstance(csv, str)


def test_audit_log_diff_unknown_id(client):
    # An unknown id must 404 (the diff target doesn't exist), not resolve to a
    # payload — that a wrong id still returns 200 would be the bug worth catching.
    with _tolerate_gating("audit_log_diff"):
        with pytest.raises(NotFoundException):
            client.auditlogs.audit_log_diff(random_id(), TENANT)


def test_global_audit_log_diff_unknown_id(client):
    with _tolerate_gating("global_audit_log_diff"):
        with pytest.raises(NotFoundException):
            client.auditlogs.global_audit_log_diff(random_id())


def test_find_audit_log(client):
    body = {"resource": "FLOW"}
    with _tolerate_gating("find_audit_log"):
        result = client.auditlogs.find_audit_log(TENANT, body)
    # find returns the same paged envelope as search_audit_logs above.
    assert isinstance(result, dict)
    assert "results" in result
    assert isinstance(result["results"], list)


def test_audit_log_history_unknown_id(client):
    # History is a revision query, not a fetch: an unknown id has no revisions,
    # so it resolves to an empty result rather than 404 (asserting emptiness is
    # the real signal — a non-empty history for a random id would be the bug).
    with _tolerate_gating("audit_log_history"):
        result = client.auditlogs.audit_log_history(random_id(), TENANT)
    assert not result
