"""Tests for the case-templates SDK surface added for #421.

Case templates are an EE feature gated behind the ``CASE`` resource. On an
instance without that feature the backend answers 403/404/501 rather than a
payload, so the assertions below skip on those instead of failing — an infra gap
must not look like a coverage regression (see AGENTS.md).

Request bodies are sent as plain dicts (the wrapper accepts ``Dict[str, Any]``),
so the field names below are the backend's camelCase JSON keys.
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


def _create_template(client, **overrides):
    body = {
        "name": f"sdk-tmpl-{random_id()}",
        "namespace": "io.kestra.sdk",
        "defaultSeverity": "MEDIUM",
    }
    body.update(overrides)
    return client.case_templates.create_case_template(TENANT, body)


def test_search_case_templates_returns_paged_results(client):
    with _tolerate_gating("search_case_templates"):
        result = client.case_templates.search_case_templates(TENANT, page=1, size=10)
    assert result.total is not None and result.total >= 0
    assert isinstance(result.results, list)


def test_case_template_crud_round_trip(client):
    with _tolerate_gating("create_case_template"):
        created = _create_template(client)
    assert created.id is not None
    assert created.namespace == "io.kestra.sdk"
    assert created.name.startswith("sdk-tmpl-")
    try:
        fetched = client.case_templates.get_case_template(TENANT, created.id)
        assert fetched.id == created.id
        assert fetched.name == created.name

        updated = client.case_templates.update_case_template(
            TENANT,
            created.id,
            {
                "name": created.name,
                "namespace": "io.kestra.sdk",
                "defaultSeverity": "CRITICAL",
            },
        )
        assert updated.default_severity == "CRITICAL"
    finally:
        client.case_templates.delete_case_template(TENANT, created.id)

    with pytest.raises(NotFoundException):
        client.case_templates.get_case_template(TENANT, created.id)
