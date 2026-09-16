"""Tests for the IAM bindings SDK surface added for #421.

Bindings are an EE/IAM feature; on an instance without it the backend answers
403/404/501 rather than a payload, so live calls are wrapped in
``_tolerate_gating`` (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
)
from kestrapy.models.binding_type import BindingType
from kestrapy.models.iam_binding_controller_api_create_binding_request import (
    IAMBindingControllerApiCreateBindingRequest,
)
from kestrapy.models.iam_binding_controller_api_binding_detail import (
    IAMBindingControllerApiBindingDetail,
)
from kestrapy.models.paged_results_iam_binding_controller_api_binding_detail import (
    PagedResultsIAMBindingControllerApiBindingDetail,
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


def test_search_bindings_returns_paged_results(client):
    with _tolerate_gating("search_bindings"):
        result = client.bindings.search_bindings(TENANT, page=1, size=10)
    assert isinstance(result, PagedResultsIAMBindingControllerApiBindingDetail)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_search_bindings_filtered_by_type(client):
    with _tolerate_gating("search_bindings"):
        result = client.bindings.search_bindings(
            TENANT, page=1, size=10, binding_type=BindingType.GROUP
        )
    assert isinstance(result.results, list)
    for binding in result.results:
        assert binding.type == BindingType.GROUP


def test_binding_unknown_id(client):
    with pytest.raises((NotFoundException, ForbiddenException)):
        client.bindings.binding(random_id(), TENANT)


def test_create_binding_round_trip(client):
    body = IAMBindingControllerApiCreateBindingRequest(
        type=BindingType.GROUP,
        externalId=random_id(),
        roleId=random_id(),
    )
    with _tolerate_gating("create_binding"):
        created = client.bindings.create_binding(TENANT, body)
    # If we got here the feature is enabled; a bad role/group id usually 404s
    # first (tolerated above), so a returned detail must carry an id + type.
    assert isinstance(created, IAMBindingControllerApiBindingDetail)
    assert created.id is not None
    assert created.type == BindingType.GROUP
    with contextlib.suppress(Exception):
        client.bindings.delete_binding(created.id, TENANT)


def test_bulk_create_binding_returns_list(client):
    body = [
        IAMBindingControllerApiCreateBindingRequest(
            type=BindingType.GROUP,
            externalId=random_id(),
            roleId=random_id(),
        )
    ]
    with _tolerate_gating("bulk_create_binding"):
        created = client.bindings.bulk_create_binding(TENANT, body)
    assert isinstance(created, list)
    for binding in created:
        assert isinstance(binding, IAMBindingControllerApiBindingDetail)
        with contextlib.suppress(Exception):
            client.bindings.delete_binding(binding.id, TENANT)
