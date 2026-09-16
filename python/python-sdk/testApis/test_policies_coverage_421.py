"""Tests for the tenant- and namespace-scoped policy SDK surface added for #421.

The whole policy controller requires the FEATURE_POLICIES licence feature; on an
instance without it the backend answers 403/404/501, so read/validate assertions
skip on those instead of failing (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, random_id, random_namespace
from kestrapy.exceptions import ForbiddenException, NotFoundException, ServiceException

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


# --------------------------------------------------------------------------- #
# Tenant scope
# --------------------------------------------------------------------------- #

def test_search_tenant_policies_returns_paged_results(client):
    with _tolerate_gating("search_tenant_policies"):
        result = client.policies.search_tenant_policies(TENANT, page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_validate_tenant_policy_reports_constraints_on_garbage(client):
    with _tolerate_gating("validate_tenant_policy"):
        outcome = client.policies.validate_tenant_policy(TENANT, "id: not-a-real-policy")
    assert outcome is not None
    # A malformed source populates the positional validation index.
    assert outcome.index is not None


# --------------------------------------------------------------------------- #
# Namespace scope
# --------------------------------------------------------------------------- #

def test_search_namespace_policies_returns_paged_results(client):
    ns = random_namespace()
    with _tolerate_gating("search_namespace_policies"):
        result = client.policies.search_namespace_policies(ns, TENANT, page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_validate_namespace_policy_reports_constraints_on_garbage(client):
    ns = random_namespace()
    with _tolerate_gating("validate_namespace_policy"):
        outcome = client.policies.validate_namespace_policy(ns, TENANT, "id: not-a-real-policy")
    assert outcome is not None
    assert outcome.index is not None


# --------------------------------------------------------------------------- #
# Flow policy preview (FlowsApi)
# --------------------------------------------------------------------------- #

def test_preview_policies_returns_response(client):
    from kestrapy.models.policy_preview_request import PolicyPreviewRequest

    ns = random_namespace()
    request = PolicyPreviewRequest(
        namespace=ns,
        source=f"id: sdk-preview-{random_id()[:8]}\nnamespace: {ns}\ntasks:\n  - id: hello\n    type: io.kestra.plugin.core.log.Log\n    message: hi\n",
    )
    with _tolerate_gating("preview_policies"):
        result = client.flows.preview_policies(TENANT, request)
    # With no policies in force the preview still returns a structured response.
    assert result is not None
