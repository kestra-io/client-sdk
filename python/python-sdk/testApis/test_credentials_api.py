"""Tests for the tenant-level credentials SDK surface added for #421.

Credentials are guarded by the ``CREDENTIAL`` resource and are typically an EE
feature. On an instance without it the backend answers 403/404/501 rather than
a payload, so the assertions below skip on those instead of failing — an infra
gap must not look like a coverage regression (see AGENTS.md).
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


def _create_credential(client):
    body = {
        "type": "GITHUB_APP",
        "name": f"sdk-cred-{random_id()[:8]}",
        "appId": "123456",
        "privateKey": "-----BEGIN PRIVATE KEY-----\nfake\n-----END PRIVATE KEY-----",
    }
    return client.credentials.create_credential(TENANT, body)


# --------------------------------------------------------------------------- #
# Read
# --------------------------------------------------------------------------- #

def test_list_credentials_returns_envelope(client):
    with _tolerate_gating("list_credentials"):
        result = client.credentials.list_credentials(TENANT, page=1, size=10)
    assert isinstance(result, dict)
    assert "results" in result or "total" in result


# --------------------------------------------------------------------------- #
# Create / read / update / delete round-trip
# --------------------------------------------------------------------------- #

def test_credential_crud_round_trip(client):
    with _tolerate_gating("create_credential"):
        created = _create_credential(client)
    credential_id = created["id"]
    assert credential_id
    try:
        fetched = client.credentials.credential(credential_id, TENANT)
        assert fetched["id"] == credential_id

        updated = client.credentials.update_credential(
            credential_id,
            TENANT,
            {**created, "name": created["name"], "appId": "654321"},
        )
        assert updated["id"] == credential_id
    finally:
        client.credentials.delete_credential(credential_id, TENANT)

    with pytest.raises(NotFoundException):
        client.credentials.credential(credential_id, TENANT)


# --------------------------------------------------------------------------- #
# Connection test
# --------------------------------------------------------------------------- #

def test_test_credential_reports_connection_result(client):
    with _tolerate_gating("create_credential"):
        created = _create_credential(client)
    try:
        with _tolerate_gating("test_credential"):
            result = client.credentials.test_credential(created["id"], TENANT)
        assert result.success is not None
    finally:
        with contextlib.suppress(Exception):
            client.credentials.delete_credential(created["id"], TENANT)
