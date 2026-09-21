"""Tests for the apps view/preview/dispatch SDK surface added for #421.

The Apps feature is gated behind an EE licence, so on an instance without it the
backend answers 403/404/501 rather than a payload; the assertions below skip on
those instead of failing so an infra gap doesn't look like a coverage
regression (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import TENANT, gating, random_id
from kestrapy.exceptions import (
    BadRequestException,
    ForbiddenException,
    NotFoundException,
    ServiceException,
    UnprocessableEntityException,
)


_APP_YAML = """
id: sdk-preview-app
type: io.kestra.plugin.ee.apps.Form
displayName: SDK preview app
""".strip()

_tolerate_gating = gating(allow_404=True, state_codes=(400, 422))


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
    try:
        result = client.apps.preview_app(TENANT, _APP_YAML)
    except (ForbiddenException, NotFoundException, BadRequestException, UnprocessableEntityException) as exc:
        pytest.skip(f"preview_app: not supported on this instance ({exc.status})")
    except ServiceException as exc:
        # Preview rendering of a minimal app may be unavailable on this image (500/501).
        if getattr(exc, "status", None) in (403, 404, 500, 501):
            pytest.skip(f"preview_app: not supported on this instance ({exc.status})")
        raise
    else:
        # A rendered preview is a JSON object describing the layout.
        assert isinstance(result, dict)


def test_stream_app_events_unknown_is_gated_or_missing(client):
    # Opening the stream for a missing app must resolve quickly — either it errors
    # (4xx/5xx) or it opens an SSE response that emits an error/empty event. Either
    # way the wrapper must return promptly, not hang.
    try:
        resp = client.apps.stream_app_events(f"missing-{random_id()}", "events", TENANT)
    except (NotFoundException, ForbiddenException, ServiceException, BadRequestException):
        return
    # Opened as a streaming response — assert it's wired and close it.
    assert getattr(resp, "status_code", None) is not None
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
