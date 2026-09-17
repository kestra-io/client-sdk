"""Tests for the security-integrations (SCIM) SDK surface added for #421.

Security integrations require instance-owner access and the ``FEATURE_SCIM``
licence feature. On an instance without that feature the backend answers
403/404/501 rather than a payload, so the assertions below skip on those
instead of failing — an infra gap must not look like a coverage regression
(see AGENTS.md).
"""

import pytest

from test_helpers import TENANT, gating, random_id
from kestrapy.exceptions import (
    NotFoundException,
)
from kestrapy.models.create_security_integration_request import CreateSecurityIntegrationRequest
from kestrapy.models.security_integration_type import SecurityIntegrationType

_tolerate_gating = gating()


def _create_integration(client):
    body = CreateSecurityIntegrationRequest(
        name=f"sdk-scim-{random_id()[:8]}",
        description="SDK test integration",
        type=SecurityIntegrationType.SCIM,
    )
    return client.security_integrations.create_security_integration(TENANT, body)


# --------------------------------------------------------------------------- #
# Read
# --------------------------------------------------------------------------- #

def test_list_security_integrations_returns_envelope(client):
    with _tolerate_gating("list_security_integrations"):
        result = client.security_integrations.list_security_integrations(TENANT)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_search_security_integrations_returns_paged_results(client):
    with _tolerate_gating("search_security_integrations"):
        result = client.security_integrations.search_security_integrations(TENANT, page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


# --------------------------------------------------------------------------- #
# Create / read / enable / disable / delete round-trip
# --------------------------------------------------------------------------- #

def test_security_integration_crud_round_trip(client):
    with _tolerate_gating("create_security_integration"):
        created = _create_integration(client)
    # The create response is a raw dict that also carries the one-time SCIM token.
    integration_id = created["id"]
    assert integration_id
    assert created["name"].startswith("sdk-scim-")
    try:
        fetched = client.security_integrations.security_integration(integration_id, TENANT)
        assert fetched.id == integration_id
        assert fetched.type == SecurityIntegrationType.SCIM

        disabled = client.security_integrations.disable_security_integration(integration_id, TENANT)
        assert disabled.enabled is False

        enabled = client.security_integrations.enable_security_integration(integration_id, TENANT)
        assert enabled.enabled is True
    finally:
        client.security_integrations.delete_security_integration(integration_id, TENANT)

    with pytest.raises(NotFoundException):
        client.security_integrations.security_integration(integration_id, TENANT)
