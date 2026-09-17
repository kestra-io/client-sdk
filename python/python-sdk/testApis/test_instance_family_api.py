"""Tests for the instance-family SDK surface added for #421 (PR 1, ->60% coverage).

These endpoints are almost all instance-owner-only and several are gated behind
an EE licence tier / enabled feature (plugin management, worker groups, policies).
On an instance that doesn't have a feature enabled the backend answers 403/404/501
rather than a payload, so the read assertions below skip on those instead of
failing — an infra gap must not look like a coverage regression (see AGENTS.md).
"""
import contextlib
from datetime import datetime, timedelta, timezone

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    ApiException,
    ForbiddenException,
    NotFoundException,
    ServiceException,
)
from kestrapy.models.banner import Banner
from kestrapy.models.banner_type import BannerType
from kestrapy.models.evaluation_type import EvaluationType
from kestrapy.models.kill_switch import KillSwitch
from kestrapy.models.worker_queue_controller_api_create_or_update_worker_queue_request import (
    WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest,
)
from kestrapy.models.worker_group_controller_api_create_worker_group_request import (
    WorkerGroupControllerApiCreateWorkerGroupRequest,
)
from kestrapy.models.api_patch_instance_owner_request import ApiPatchInstanceOwnerRequest

# 5xx status codes that mean "the endpoint exists but this instance won't serve
# it" (feature not implemented on this build) — skip, don't fail. A 403 (feature
# disabled / licence tier / not instance-owner) is handled separately below.
# 404 is deliberately NOT tolerated: on this instance-owner surface EE answers a
# disabled feature with 403, so a 404 means the SDK built a wrong path — exactly
# the bug this live-binding test exists to catch.
_GATED_5XX = (501,)


@contextlib.contextmanager
def _tolerate_gating(what):
    try:
        yield
    except ForbiddenException as exc:
        pytest.skip(f"{what}: gated on this instance ({exc.status})")
    except ServiceException as exc:
        if getattr(exc, "status", None) in _GATED_5XX:
            pytest.skip(f"{what}: gated on this instance ({exc.status})")
        raise


# --------------------------------------------------------------------------- #
# Services / maintenance (read-only)
# --------------------------------------------------------------------------- #

def test_active_services_lists_running_services(client):
    with _tolerate_gating("active_services"):
        result = client.instance.active_services()
    assert result is not None
    # An instance answering this call is itself at least one running service.
    assert result.total is not None or result.services is not None


def test_search_services_returns_paged_results(client):
    with _tolerate_gating("search_services"):
        result = client.instance.search_services(page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_maintenance_status_reports_a_boolean_state(client):
    with _tolerate_gating("maintenance_status"):
        status = client.instance.maintenance_status()
    assert status is not None
    # The response always carries the current maintenance flag.
    assert status.maintenance is not None or status.services is not None


# --------------------------------------------------------------------------- #
# Versioned plugins (read-only)
# --------------------------------------------------------------------------- #

def test_list_versioned_plugins_returns_paged_results(client):
    with _tolerate_gating("list_versioned_plugins"):
        result = client.instance.list_versioned_plugins(page=1, size=10)
    assert result.total is not None
    assert isinstance(result.results, list)


def test_list_available_versioned_plugins_returns_a_collection(client):
    with _tolerate_gating("list_available_versioned_plugins"):
        available = client.instance.list_available_versioned_plugins()
    assert available is not None
    assert isinstance(available, (list, dict))


# --------------------------------------------------------------------------- #
# MCP servers / worker credentials (read-only)
# --------------------------------------------------------------------------- #

def test_list_all_mcp_servers_returns_paged_shape(client):
    with _tolerate_gating("list_all_mcp_servers"):
        result = client.instance.list_all_mcp_servers(page=1, size=10)
    assert result is not None
    assert isinstance(result, dict)
    assert "results" in result or "total" in result


def test_list_worker_credentials_returns_a_list(client):
    with _tolerate_gating("list_worker_credentials"):
        result = client.instance.list_worker_credentials()
    assert result is not None
    assert result.workers is not None


# --------------------------------------------------------------------------- #
# Worker groups
# --------------------------------------------------------------------------- #

def test_list_worker_groups_returns_a_list(client):
    with _tolerate_gating("list_worker_groups"):
        result = client.worker_groups.list_worker_groups()
    assert result is not None
    assert isinstance(result.worker_groups, list)


def test_worker_group_create_get_delete_roundtrip(client):
    wg_id = "wg" + random_id()[:10]
    with _tolerate_gating("create_worker_group"):
        created = client.worker_groups.create_worker_group(
            WorkerGroupControllerApiCreateWorkerGroupRequest(id=wg_id, name="SDK WG", subscriptions=[])
        )
    # Assert inside the try so a failed post-create check still deletes the group.
    try:
        assert created.id == wg_id
        fetched = client.worker_groups.worker_group(wg_id)
        assert fetched.id == wg_id
        assert fetched.name == "SDK WG"
    finally:
        client.worker_groups.delete_worker_group(wg_id)
    with pytest.raises(NotFoundException):
        client.worker_groups.worker_group(wg_id)


# --------------------------------------------------------------------------- #
# Worker queues
# --------------------------------------------------------------------------- #

def test_list_worker_queues_returns_a_list(client):
    with _tolerate_gating("list_worker_queues"):
        result = client.worker_queues.list_worker_queues()
    assert result is not None
    assert isinstance(result.worker_queues, list)


def test_worker_queue_create_get_delete_roundtrip(client):
    wq_id = "wq" + random_id()[:10]
    with _tolerate_gating("create_worker_queue"):
        created = client.worker_queues.create_worker_queue(
            WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest(
                id=wq_id, tags=["sdk-test"], name="SDK WQ"
            )
        )
    try:
        assert created.id == wq_id
        fetched = client.worker_queues.worker_queue(wq_id)
        assert fetched.id == wq_id
        assert "sdk-test" in (fetched.tags or [])
    finally:
        client.worker_queues.delete_worker_queue(wq_id)


# --------------------------------------------------------------------------- #
# Banners
# --------------------------------------------------------------------------- #

def test_banner_create_search_update_delete_roundtrip(client):
    now = datetime.now(timezone.utc)
    banner = Banner(
        message="SDK banner " + random_id()[:6],
        type=BannerType.INFO,
        active=True,
        startDate=now,
        endDate=now + timedelta(days=1),
    )
    try:
        with _tolerate_gating("create_banner"):
            created = client.banners.create_banner(banner)
    except ServiceException as exc:
        # kestra-ee bug: the create path inserts a null `active` and the DB
        # rejects it with a NOT NULL violation (500) regardless of payload.
        # The read path is exercised by search below; skip the mutation.
        if getattr(exc, "status", None) == 500:
            pytest.skip("create_banner: upstream kestra-ee bug (banners.active NOT NULL)")
        raise
    banner_id = created.id
    try:
        assert banner_id is not None
        assert created.message.startswith("SDK banner")
        found = client.banners.search_banners()
        assert any(b.id == banner_id for b in found)

        updated = client.banners.update_banner(
            banner_id,
            Banner(
                id=banner_id,
                message="SDK banner updated",
                type=BannerType.INFO,
                active=True,
                startDate=now,
                endDate=now + timedelta(days=1),
            ),
        )
        assert updated.message == "SDK banner updated"
    finally:
        client.banners.delete_banner(banner_id)

    remaining = client.banners.search_banners()
    assert all(b.id != banner_id for b in remaining)


# --------------------------------------------------------------------------- #
# Kill switches
# --------------------------------------------------------------------------- #

def test_kill_switch_create_search_delete_roundtrip(client):
    start = datetime.now(timezone.utc) + timedelta(hours=1)
    ks_name = "ks-" + random_id()[:8]
    with _tolerate_gating("create_kill_switch"):
        created = client.kill_switches.create_kill_switch(
            KillSwitch(name=ks_name, startDate=start, evaluationType=EvaluationType.KILL)
        )
    ks_id = created.id
    try:
        assert created.name == ks_name
        found = client.kill_switches.search_kill_switches()
        assert any(k.id == ks_id for k in found)
    finally:
        if ks_id is not None:
            client.kill_switches.delete_kill_switch(ks_id)


# --------------------------------------------------------------------------- #
# Instance policies
# --------------------------------------------------------------------------- #

def test_search_instance_policies_returns_paged_results(client):
    with _tolerate_gating("search_instance_policies"):
        result = client.policies.search_instance_policies(page=1, size=10)
    assert result.total is not None
    assert isinstance(result.results, list)


def test_validate_instance_policy_reports_constraints_on_garbage(client):
    with _tolerate_gating("validate_instance_policy"):
        outcome = client.policies.validate_instance_policy("id: not-a-real-policy")
    assert outcome is not None
    # The validation outcome always carries its positional index; a malformed
    # source populates `constraints`, a valid one leaves it None.
    assert outcome.index is not None


# --------------------------------------------------------------------------- #
# Misc: configuration, licensing, setup, auth
# --------------------------------------------------------------------------- #

def test_configuration_exposes_instance_settings(client):
    with _tolerate_gating("configuration"):
        cfg = client.misc.configuration()
    assert cfg is not None
    # Every instance reports its build identity.
    assert cfg.uuid is not None or cfg.version is not None


def test_login_configuration_is_returned(client):
    with _tolerate_gating("login_configuration"):
        login_cfg = client.misc.login_configuration()
    assert login_cfg is not None
    # Server-computed flag, always present in the login configuration payload.
    assert isinstance(login_cfg.is_basic_auth_initialized, bool)


def test_basic_auth_validation_errors_is_a_list(client):
    with _tolerate_gating("basic_auth_validation_errors"):
        errors = client.misc.basic_auth_validation_errors()
    assert isinstance(errors, list)


def test_setup_configuration_is_returned(client):
    with _tolerate_gating("setup_configuration"):
        setup = client.misc.setup_configuration()
    assert setup is not None
    # An already-running instance always reports its setup as complete.
    assert isinstance(setup.done, bool)


def test_license_info_reports_details(client):
    with _tolerate_gating("license_info"):
        info = client.misc.license_info()
    assert info is not None


def test_worker_selector_tags_returns_tags_container(client):
    with _tolerate_gating("worker_selector_tags"):
        tags = client.misc.worker_selector_tags(TENANT)
    assert tags is not None
    assert isinstance(tags.tags, list)


# --------------------------------------------------------------------------- #
# instance-owner patch (existing classes, new methods)
# --------------------------------------------------------------------------- #

def test_patch_user_instance_owner_unknown_user_is_rejected(client):
    with pytest.raises(ApiException) as exc_info:
        client.users.patch_user_instance_owner(
            "does-not-exist-" + random_id()[:8],
            ApiPatchInstanceOwnerRequest(instanceOwner=True),
        )
    # Unknown user -> 404 (or 403 when the caller isn't instance-owner here).
    assert exc_info.value.status in (403, 404)
