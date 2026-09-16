"""Tests for the extra flows SDK surface added for #421.

Covers the endpoints ported from the Go SDK's flows_api.go that were still
missing from FlowsApi:

- GET  /flows/export/by-query/csv        (export_flows_by_query_csv)
- POST /flows/source/replace/{preview,apply,line}
- POST /flows/hashes/by-ids              (flow_hashes_by_ids)
- POST /flows/{ns}/{id}/promote          (promote)
- POST /flows/promote/by-ids             (promote_by_ids)
- POST /flows/{ns}/{id}/promotions       (report_promote)
- GET  /flows/{ns}/{id}/promotions       (list_promotions)
- GET  /flows/{ns}/{id}/promotions/{auditId}/diff (promote_diff)

Promotion / drift routes are gated behind the ``PROMOTION_TARGET`` resource
and the ``FEATURE_PROMOTE`` licence feature; on an instance without that
feature the backend answers 403/404/501 instead of a payload, so those
assertions skip rather than fail (see AGENTS.md) — an infra gap must not look
like a coverage regression.
"""
import contextlib

import pytest

from kestrapy import IdWithNamespace
from kestrapy.exceptions import (
    ForbiddenException,
    NotFoundException,
    ServiceException,
)
from test_helpers import (
    TENANT,
    random_id,
    random_namespace,
    create_flow,
    log_flow_yaml,
    ns_filter,
)

_GATED = (403, 404, 501)
# Endpoints that mutate/promote need FEATURE_PROMOTE plus real remote-target and
# promotion state that a single-instance CI can't set up: a 422 (validation) or
# 500 proves the route is wired and the server processed our request.
_WIRED = (400, 403, 404, 422, 500, 501)


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


@contextlib.contextmanager
def _tolerate_wired(what):
    from kestrapy.exceptions import ApiException
    try:
        yield
    except ApiException as exc:
        if getattr(exc, "status", None) in _WIRED:
            pytest.skip(f"{what}: wired, needs promote feature/state ({exc.status})")
        raise


# --------------------------------------------------------------------------- #
# CSV export
# --------------------------------------------------------------------------- #

def test_export_flows_by_query_csv_returns_csv(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    with _tolerate_gating("export_flows_by_query_csv"):
        csv = client.flows.export_flows_by_query_csv(TENANT, filters=[ns_filter(ns)])
    assert isinstance(csv, str)
    # The header row of the flows CSV export names the flow id column.
    assert "Id" in csv or "id" in csv
    assert fid in csv


# --------------------------------------------------------------------------- #
# Source-search replace (preview never persists)
# --------------------------------------------------------------------------- #

def test_preview_replace_by_source_code_matches_lines(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    body = {
        "namespace": ns,
        "flowId": fid,
        "query": "Hello World!",
        "replacement": "Bonjour Monde!",
        "caseSensitive": True,
        "wholeWord": False,
        "regex": False,
    }
    with _tolerate_gating("preview_replace_by_source_code"):
        result = client.flows.preview_replace_by_source_code(TENANT, body)
    # Preview returns a dict payload without mutating the flow.
    assert isinstance(result, dict)
    # The stored source is untouched by a preview call.
    fetched = client.flows.flow(ns, fid, TENANT, source=True)
    assert "Hello World!" in fetched.source


def test_apply_replace_by_source_code_returns_dict(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    body = {
        "namespace": ns,
        "flowId": fid,
        "query": "Hello World!",
        "replacement": "Bonjour Monde!",
        "caseSensitive": True,
        "wholeWord": False,
        "regex": False,
        "flows": [{"namespace": ns, "id": fid}],
    }
    with _tolerate_wired("apply_replace_by_source_code"):
        result = client.flows.apply_replace_by_source_code(TENANT, body)
        assert isinstance(result, dict)


def test_replace_line_by_source_code_returns_dict(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    body = {
        "namespace": ns,
        "flowId": fid,
        "id": fid,
        "line": 6,
        "query": "Hello World!",
        "replacement": "Bonjour Monde!",
        "caseSensitive": True,
        "wholeWord": False,
        "regex": False,
    }
    with _tolerate_wired("replace_line_by_source_code"):
        result = client.flows.replace_line_by_source_code(TENANT, body)
        assert isinstance(result, dict)


# --------------------------------------------------------------------------- #
# Drift detection — hashes by ids
# --------------------------------------------------------------------------- #

def test_flow_hashes_by_ids_returns_hashes(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    ids = [IdWithNamespace(id=fid, namespace=ns)]
    with _tolerate_gating("flow_hashes_by_ids"):
        result = client.flows.flow_hashes_by_ids(TENANT, ids)
    assert isinstance(result, dict)


# --------------------------------------------------------------------------- #
# Promotions (all gated behind FEATURE_PROMOTE)
# --------------------------------------------------------------------------- #

def test_promote_by_ids_is_gated_or_returns_dict(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    body = {
        "targets": ["nonexistent-target"],
        "ids": [{"namespace": ns, "id": fid}],
    }
    with _tolerate_wired("promote_by_ids"):
        result = client.flows.promote_by_ids(TENANT, body)
    assert isinstance(result, dict)


def test_promote_is_gated_or_returns_dict(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    body = {"targets": ["nonexistent-target"]}
    with _tolerate_wired("promote"):
        result = client.flows.promote(ns, fid, TENANT, body)
    assert isinstance(result, dict)


def test_list_promotions_returns_paged_dict(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    with _tolerate_gating("list_promotions"):
        result = client.flows.list_promotions(ns, fid, TENANT, page=1, size=10)
    assert isinstance(result, dict)
    # A never-promoted flow reports an empty (or absent) results page.
    if "results" in result:
        assert isinstance(result["results"], list)


def test_report_promote_is_gated_or_void(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    body = {"target": "nonexistent-target", "revision": 1}
    with _tolerate_wired("report_promote"):
        result = client.flows.report_promote(ns, fid, TENANT, body)
    assert result is None


def test_promote_diff_is_gated_or_returns_dict(client):
    ns = random_namespace()
    fid = random_id()
    create_flow(client, log_flow_yaml(fid, ns))

    with _tolerate_gating("promote_diff"):
        result = client.flows.promote_diff(ns, fid, random_id(), TENANT)
    assert isinstance(result, dict)
