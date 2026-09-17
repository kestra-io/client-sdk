"""Tests for the tenant-level credentials SDK surface added for #421.

Credentials are guarded by the ``CREDENTIAL`` resource and are typically an EE
feature. On an instance without it the backend answers 403/404/501 rather than
a payload, so the assertions below skip on those instead of failing — an infra
gap must not look like a coverage regression (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, gating, random_id
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
)

_tolerate_gating = gating()


def _oauth2_body(name):
    # OAuth2 create/update request: polymorphic on `type`, with a nested
    # authConfig that is itself polymorphic (CLIENT_CREDENTIALS grant). clientId
    # is an AuthProperty (VALUE), clientSecret a SecretAuthProperty (secretKey).
    return {
        "type": "OAUTH2",
        "name": name,
        "description": "sdk coverage test",
        "tokenEndpoint": "https://login.example.com/oauth/token",
        "scopes": ["read"],
        "authConfig": {
            "type": "CLIENT_CREDENTIALS",
            "clientId": {"type": "VALUE", "value": "sdk-client-id"},
            "clientSecret": {"type": "SECRET", "secretKey": "SDK_OAUTH_SECRET"},
        },
    }


def _create_credential(client):
    return client.credentials.create_credential(
        TENANT, _oauth2_body(f"sdk-cred-{random_id()[:8]}")
    )


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
            _oauth2_body(created["name"]),
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
        try:
            result = client.credentials.test_credential(created["id"], TENANT)
        except (ForbiddenException, NotFoundException) as exc:
            pytest.skip(f"test_credential gated ({exc.status})")
        except ServiceException as exc:
            # Testing an unreachable token endpoint may surface as a 500/501.
            if getattr(exc, "status", None) in (403, 404, 500, 501):
                pytest.skip(f"test_credential: remote unreachable ({exc.status})")
            raise
        else:
            # success is a real boolean result of the connection attempt.
            assert result.success is not None
    finally:
        with contextlib.suppress(Exception):
            client.credentials.delete_credential(created["id"], TENANT)
