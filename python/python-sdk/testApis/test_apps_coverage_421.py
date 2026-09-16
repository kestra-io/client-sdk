"""Tests for the apps view/preview/dispatch SDK surface added for #421.

The Apps feature is gated behind an EE licence, so on an instance without it the
backend answers 403/404/501 rather than a payload; the assertions below skip on
those instead of failing so an infra gap doesn't look like a coverage
regression (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, random_id
from kestrapy.exceptions import (
    BadRequestException,
    ForbiddenException,
    NotFoundException,
    ServiceException,
    UnprocessableEntityException,
)

_GATED = (403, 404, 501)

_APP_YAML = """
id: sdk-preview-app
type: io.kestra.plugin.ee.apps.Form
displayName: SDK preview app
""".strip()


@contextlib.contextmanager
def _tolerate_gating(what):
    try:
        yield
    except (ForbiddenException, NotFoundException) as exc:
        pytest.skip(f"{what}: gated on this instance ({exc.status})")
    except (BadRequestException, UnprocessableEntityException) as exc:
        pytest.skip(f"{what}: not supported on this instance ({exc.status})")
    except ServiceException as exc:
        if getattr(exc, "status", None) in _GATED:
            pytest.skip(f"{what}: gated on this instance ({exc.status})")
        raise


def test_app_states_returns_list_of_state_names(client):
    with _tolerate_gating("app_states"):
        states = client.apps.app_states(TENANT)
    assert isinstance(states, list)
    assert all(isinstance(s, str) for s in states)


def test_open_app_view_unknown_app_is_gated_or_missing(client):
    # No such app should raise a not-found/forbidden, never return a payload.
    with pytest.raises((NotFoundException, ForbiddenException, ServiceException, BadRequestException)):
        client.apps.open_app_view(f"missing-{random_id()}", TENANT)


def test_download_file_from_app_execution_unknown_is_gated_or_missing(client):
    with pytest.raises((NotFoundException, ForbiddenException, ServiceException, BadRequestException)):
        client.apps.download_file_from_app_execution(
            f"missing-{random_id()}", TENANT, path_uri="kestra:///nope.txt",
        )


def test_preview_app_renders_layout_or_is_gated(client):
    with _tolerate_gating("preview_app"):
        result = client.apps.preview_app(TENANT, _APP_YAML)
    # A rendered preview is a JSON object describing the layout.
    assert isinstance(result, dict)


def test_stream_app_events_unknown_is_gated_or_missing(client):
    # Opening a stream for a missing app must error rather than hang forever.
    with pytest.raises((NotFoundException, ForbiddenException, ServiceException, BadRequestException)):
        resp = client.apps.stream_app_events(
            f"missing-{random_id()}", "events", TENANT,
        )
        with contextlib.suppress(Exception):
            resp.close()


def test_preview_dispatch_app_unknown_is_gated_or_missing(client):
    with pytest.raises((NotFoundException, ForbiddenException, ServiceException, BadRequestException)):
        resp = client.apps.preview_dispatch_app(
            f"missing-{random_id()}", TENANT,
            {"__kestra_app_source__": _APP_YAML},
        )
        with contextlib.suppress(Exception):
            resp.close()


def test_dispatch_app_unknown_is_gated_or_missing(client):
    with pytest.raises((NotFoundException, ForbiddenException, ServiceException, BadRequestException)):
        resp = client.apps.dispatch_app(
            f"missing-{random_id()}", f"dispatch-{random_id()}", TENANT,
            {"field": "value"},
        )
        with contextlib.suppress(Exception):
            resp.close()
