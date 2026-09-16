"""Tests for the auditlogs SDK surface added for #421.

The audit-log controller is gated by the ``AUDITLOG`` resource plus a licence
feature, so routes answer 403 (or 404/501) when unavailable. Live calls are
wrapped in ``_tolerate_gating`` (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
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
    # An unknown id should be gated or 404, never crash.
    with _tolerate_gating("audit_log_diff"):
        result = client.auditlogs.audit_log_diff(random_id(), TENANT)
        assert result is None or isinstance(result, dict)


def test_global_audit_log_diff_unknown_id(client):
    with _tolerate_gating("global_audit_log_diff"):
        result = client.auditlogs.global_audit_log_diff(random_id())
        assert result is None or isinstance(result, dict)


def test_find_audit_log(client):
    body = {"resource": "FLOW"}
    with _tolerate_gating("find_audit_log"):
        result = client.auditlogs.find_audit_log(TENANT, body)
        assert result is None or isinstance(result, dict)


def test_audit_log_history_unknown_id(client):
    with _tolerate_gating("audit_log_history"):
        result = client.auditlogs.audit_log_history(random_id(), TENANT)
        assert result is None or isinstance(result, list)
