"""Tests for the apps view/preview/dispatch SDK surface added for #421.

The Apps feature is gated behind an EE licence, so on an instance without it the
backend answers 403/404/501 rather than a payload; the assertions below skip on
those instead of failing so an infra gap doesn't look like a coverage
regression (see AGENTS.md).
"""
import contextlib

import pytest

from test_helpers import (
    TENANT,
    create_flow,
    gating,
    log_flow_yaml,
    random_id,
    random_namespace,
)
from kestrapy.exceptions import (
    BadRequestException,
    ForbiddenException,
    NotFoundException,
    ServiceException,
    UnprocessableEntityException,
)


_PREVIEW_MARKDOWN = "# SDK preview app"

# Not a valid app type (Form is a layout block, the only app type is Execution),
# so Kestra rejects the source while parsing it.
_INVALID_APP_YAML = """
id: sdk-invalid-app
type: io.kestra.plugin.ee.apps.Form
displayName: SDK invalid app
""".strip()


def _valid_app_yaml(client):
    ns = random_namespace()
    flow_id = random_id()
    create_flow(client, log_flow_yaml(flow_id, ns))
    return f"""\
id: sdk-preview-{random_id()}
type: io.kestra.plugin.ee.apps.Execution
namespace: {ns}
flowId: {flow_id}
displayName: SDK preview app
layout:
  - on: OPEN
    blocks:
      - type: io.kestra.plugin.ee.apps.core.blocks.Markdown
        content: "{_PREVIEW_MARKDOWN}"
"""

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
    source = _valid_app_yaml(client)
    try:
        result = client.apps.preview_app(TENANT, source)
    except (ForbiddenException, NotFoundException) as exc:
        pytest.skip(f"preview_app: not supported on this instance ({exc.status})")
    # The preview renders the OPEN layout, so our Markdown block comes back.
    contents = [b["block"].get("content") for b in result["layout"]["blocks"]]
    assert _PREVIEW_MARKDOWN in contents


def test_preview_app_invalid_source_is_422_with_error_layout(client):
    # Since v2.0.11 an invalid source is a 422 whose body is an error layout
    # (v2.0.10 answered 500).
    with pytest.raises(UnprocessableEntityException) as exc_info:
        client.apps.preview_app(TENANT, _INVALID_APP_YAML)
    assert exc_info.value.status == 422
    assert "Invalid type: io.kestra.plugin.ee.apps.Form" in exc_info.value.body


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


def test_preview_dispatch_app_invalid_source_is_422_with_error_layout(client):
    # The endpoint parses the posted source before dispatching; since v2.0.11 an
    # invalid one is a 422 whose body is the error layout for that dispatch
    # (v2.0.10 answered 500).
    dispatch = f"dispatch-{random_id()}"
    with pytest.raises(UnprocessableEntityException) as exc_info:
        resp = client.apps.preview_dispatch_app(
            dispatch, TENANT,
            {"__kestra_app_source__": _INVALID_APP_YAML},
        )
        with contextlib.suppress(Exception):
            resp.close()
    assert exc_info.value.status == 422
    assert f'"dispatch":"{dispatch}"' in exc_info.value.body
    assert "Invalid type: io.kestra.plugin.ee.apps.Form" in exc_info.value.body


def test_dispatch_app_unknown_is_gated_or_missing(client):
    with pytest.raises((NotFoundException, ForbiddenException, ServiceException, BadRequestException)):
        resp = client.apps.dispatch_app(
            f"missing-{random_id()}", f"dispatch-{random_id()}", TENANT,
            {"field": "value"},
        )
        with contextlib.suppress(Exception):
            resp.close()
