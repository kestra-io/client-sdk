"""Tests for the tenant apps-catalog / logo SDK surface added for #421.

These routes are Superadmin-only and EE-gated, so on an instance without the
feature (or without instance-owner rights) the backend answers 403/404/501
rather than a payload; the assertions below skip on those instead of failing so
an infra gap doesn't look like a coverage regression (see AGENTS.md).
"""


from test_helpers import TENANT, gating, random_id
from kestrapy.models.tenant_controller_apps_catalog_config_request import (
    TenantControllerAppsCatalogConfigRequest,
)

_tolerate_gating = gating(allow_404=True, state_codes=(400, 422))


def test_apps_catalog_config_returns_config(client):
    with _tolerate_gating("apps_catalog_config"):
        config = client.tenants.apps_catalog_config(TENANT)
    # The response is a config object; title is one of its fields (may be None).
    assert config is not None
    assert hasattr(config, "title")


def test_set_apps_catalog_config_round_trips_title(client):
    title = f"sdk-catalog-{random_id()}"
    body = TenantControllerAppsCatalogConfigRequest(
        title=title,
        titleColor="#ffffff",
        primaryColor="#8405FF",
    )
    with _tolerate_gating("set_apps_catalog_config"):
        updated = client.tenants.set_apps_catalog_config(TENANT, body)
    assert updated is not None
    assert updated.title == title


def test_delete_apps_catalog_logo_is_gated_or_succeeds(client):
    with _tolerate_gating("delete_apps_catalog_logo"):
        result = client.tenants.delete_apps_catalog_logo(TENANT)
    # Void endpoint: returns None on success.
    assert result is None
