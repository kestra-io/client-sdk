"""Tests for the AI Copilot SDK surface added for #421.

The AI endpoints are gated behind the ``COPILOT`` resource (licence) and require
a configured AI provider — without one the backend answers 403/404/501/503
rather than a payload, so the assertions below skip on those instead of failing
(an infra/licence gap must not look like a coverage regression, see AGENTS.md).
"""
import contextlib


from test_helpers import TENANT, gating, random_id
from kestrapy.models.agent_mode import AgentMode
from kestrapy.models.api_create_thread_request import ApiCreateThreadRequest
from kestrapy.models.api_rename_thread_request import ApiRenameThreadRequest
from kestrapy.models.flow_generation_prompt import FlowGenerationPrompt

# AI copilot answers 503 when no provider is configured, on top of the usual
# licence 403 / 404 / 501.

_tolerate_gating = gating(allow_503=True)


# --------------------------------------------------------------------------- #
# Providers
# --------------------------------------------------------------------------- #

def test_list_ai_providers_returns_list(client):
    with _tolerate_gating("list_ai_providers"):
        result = client.ai.list_ai_providers(TENANT)
    assert isinstance(result, list)


# --------------------------------------------------------------------------- #
# Threads
# --------------------------------------------------------------------------- #

def test_list_threads_returns_list(client):
    with _tolerate_gating("list_threads"):
        result = client.ai.list_threads(TENANT)
    assert isinstance(result, list)


def test_thread_crud_round_trip(client):
    with _tolerate_gating("create_thread"):
        created = client.ai.create_thread(
            TENANT,
            ApiCreateThreadRequest(mode=AgentMode.ASK, title=f"sdk-thread-{random_id()}"),
        )
    assert created.uid is not None
    thread_id = created.uid
    try:
        fetched = client.ai.thread(thread_id, TENANT)
        assert fetched.uid == thread_id

        renamed = client.ai.rename_thread(
            thread_id, TENANT, ApiRenameThreadRequest(title="renamed-by-sdk")
        )
        assert renamed.title == "renamed-by-sdk"
    finally:
        with contextlib.suppress(Exception):
            client.ai.delete_thread(thread_id, TENANT)


# --------------------------------------------------------------------------- #
# One-shot generators (return YAML text)
# --------------------------------------------------------------------------- #

def test_generate_flow_returns_yaml(client):
    prompt = FlowGenerationPrompt(
        conversationId=random_id(),
        userPrompt="Create a flow that logs hello world",
    )
    with _tolerate_gating("generate_flow"):
        result = client.ai.generate_flow(TENANT, prompt)
    assert isinstance(result, str)
    assert len(result) > 0
