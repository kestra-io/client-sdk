"""Tests for the promotion-targets SDK surface added for #421.

Promotion targets are gated behind the ``PROMOTION_TARGET`` resource and the
``FEATURE_PROMOTE`` licence feature. On an instance without that feature the
backend answers 403/404/501 rather than a payload, so the assertions below skip
on those instead of failing — an infra gap must not look like a coverage
regression (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
)
from kestrapy.models.api_create_promotion_target_request import ApiCreatePromotionTargetRequest
from kestrapy.models.api_flow_hash_batch_ref import ApiFlowHashBatchRef
from kestrapy.models.api_flow_hash_batch_request import ApiFlowHashBatchRequest
from kestrapy.models.api_update_promotion_target_request import ApiUpdatePromotionTargetRequest
from kestrapy.models.connection_mode import ConnectionMode

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


def _create_target(client):
    body = ApiCreatePromotionTargetRequest(
        name=f"sdk-promo-{random_id()}",
        url="https://prod.kestra.example.com",
        targetTenant="production",
        connectionMode=ConnectionMode.SERVER,
        apiToken="sdk-test-token",
    )
    return client.promotion_targets.create_promotion_target(TENANT, body)


# --------------------------------------------------------------------------- #
# Read
# --------------------------------------------------------------------------- #

def test_list_promotion_targets_returns_paged_results(client):
    with _tolerate_gating("list_promotion_targets"):
        result = client.promotion_targets.list_promotion_targets(TENANT, page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


# --------------------------------------------------------------------------- #
# Create / read / update / delete round-trip
# --------------------------------------------------------------------------- #

def test_promotion_target_crud_round_trip(client):
    with _tolerate_gating("create_promotion_target"):
        created = _create_target(client)
    assert created.id is not None
    assert created.url == "https://prod.kestra.example.com"
    assert created.target_tenant == "production"
    # apiToken is encrypted at rest and never returned.
    try:
        fetched = client.promotion_targets.promotion_target(created.id, TENANT)
        assert fetched.id == created.id
        assert fetched.name == created.name

        updated = client.promotion_targets.update_promotion_target(
            created.id,
            TENANT,
            ApiUpdatePromotionTargetRequest(
                name=created.name,
                url="https://staging.kestra.example.com",
                targetTenant="production",
                connectionMode=ConnectionMode.SERVER,
                disabled=True,
            ),
        )
        assert updated.url == "https://staging.kestra.example.com"
        assert updated.disabled is True
    finally:
        client.promotion_targets.delete_promotion_target(created.id, TENANT)

    with pytest.raises(NotFoundException):
        client.promotion_targets.promotion_target(created.id, TENANT)


# --------------------------------------------------------------------------- #
# Connection test
# --------------------------------------------------------------------------- #

def test_test_promotion_target_reports_connection_result(client):
    body = ApiCreatePromotionTargetRequest(
        name=f"sdk-promo-{random_id()}",
        url="https://unreachable.invalid",
        targetTenant="production",
        connectionMode=ConnectionMode.SERVER,
        apiToken="sdk-test-token",
    )
    with _tolerate_gating("test_promotion_target"):
        result = client.promotion_targets.test_promotion_target(TENANT, body)
    # An unreachable host should fail the connection test, not raise.
    assert result.success is False


# --------------------------------------------------------------------------- #
# Flow hashes / flow source
# --------------------------------------------------------------------------- #

def test_promotion_target_flow_hashes_returns_hashes(client):
    with _tolerate_gating("create_promotion_target"):
        created = _create_target(client)
    try:
        batch = ApiFlowHashBatchRequest(
            flows=[ApiFlowHashBatchRef(namespace="io.kestra.sdk", flowId="unknown-flow")]
        )
        with _tolerate_gating("promotion_target_flow_hashes"):
            result = client.promotion_targets.promotion_target_flow_hashes(created.id, TENANT, batch)
        assert result.hashes is not None
    finally:
        with contextlib.suppress(Exception):
            client.promotion_targets.delete_promotion_target(created.id, TENANT)
