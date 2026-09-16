from typing import Any, Dict, List, Optional

import requests

from kestrapy.base_api import BaseApi
from kestrapy.models.ai_controller_ai_provider_response import AiControllerAiProviderResponse
from kestrapy.models.api_chat_turn_request import ApiChatTurnRequest
from kestrapy.models.api_create_thread_request import ApiCreateThreadRequest
from kestrapy.models.api_rename_thread_request import ApiRenameThreadRequest
from kestrapy.models.api_thread_detail import ApiThreadDetail
from kestrapy.models.api_thread_summary import ApiThreadSummary
from kestrapy.models.app_generation_prompt import AppGenerationPrompt
from kestrapy.models.dashboard_generation_prompt import DashboardGenerationPrompt
from kestrapy.models.flow_generation_prompt import FlowGenerationPrompt
from kestrapy.models.test_suite_generation_prompt import TestSuiteGenerationPrompt


class AiApi(BaseApi):
    """AI Copilot endpoints.

    Covers the one-shot generators under ``/api/v1/{tenant}/ai/generate/*`` and
    ``/api/v1/main/ai/*``, plus the conversational thread endpoints under
    ``/api/v1/{tenant}/ai/threads``. The controllers are gated by the ``COPILOT``
    resource and require a configured AI provider, so every route answers 403
    (licence) or 503 (no provider) when the feature is not available.
    """

    # ---- One-shot generators (return a YAML definition as text) ---- #

    def generate_app(self, tenant: str, body: AppGenerationPrompt) -> str:
        """Generate an app definition (YAML) from a natural-language prompt.
        Backs POST /api/v1/{tenant}/ai/generate/app."""
        path = self._tenant_path(tenant, "ai", "generate", "app")
        resp = self._request("POST", path, body=body, accept=self.YAML)
        return resp.text

    def generate_dashboard(self, tenant: str, body: DashboardGenerationPrompt) -> str:
        """Generate a dashboard definition (YAML).
        Backs POST /api/v1/{tenant}/ai/generate/dashboard."""
        path = self._tenant_path(tenant, "ai", "generate", "dashboard")
        resp = self._request("POST", path, body=body, accept=self.YAML)
        return resp.text

    def generate_test(self, tenant: str, body: TestSuiteGenerationPrompt) -> str:
        """Generate a test-suite definition (YAML).
        Backs POST /api/v1/{tenant}/ai/generate/test."""
        path = self._tenant_path(tenant, "ai", "generate", "test")
        resp = self._request("POST", path, body=body, accept=self.YAML)
        return resp.text

    def generate_flow(self, body: FlowGenerationPrompt) -> str:
        """Generate a flow definition (YAML) from a natural-language prompt.
        Backs POST /api/v1/main/ai/generate/flow."""
        path = self._superadmin_path("main", "ai", "generate", "flow")
        resp = self._request("POST", path, body=body, accept=self.YAML)
        return resp.text

    # ---- Providers ---- #

    def list_ai_providers(self) -> List[AiControllerAiProviderResponse]:
        """List the configured AI providers. Backs GET /api/v1/main/ai/providers."""
        path = self._superadmin_path("main", "ai", "providers")
        return self._json_list_request("GET", path, AiControllerAiProviderResponse)

    # ---- Threads ---- #

    def list_threads(self, tenant: str) -> List[ApiThreadSummary]:
        """List the current user's AI threads. Backs GET /api/v1/{tenant}/ai/threads."""
        path = self._tenant_path(tenant, "ai", "threads")
        return self._json_list_request("GET", path, ApiThreadSummary)

    def create_thread(self, tenant: str, body: ApiCreateThreadRequest) -> ApiThreadDetail:
        """Open a new AI thread. Backs POST /api/v1/{tenant}/ai/threads."""
        path = self._tenant_path(tenant, "ai", "threads")
        return self._json_request("POST", path, ApiThreadDetail, body=body)

    def thread(self, thread_id: str, tenant: str) -> ApiThreadDetail:
        """Return a single AI thread with its messages.
        Backs GET /api/v1/{tenant}/ai/threads/{threadId}."""
        path = self._tenant_path(tenant, "ai", "threads", thread_id)
        return self._json_request("GET", path, ApiThreadDetail)

    def delete_thread(self, thread_id: str, tenant: str) -> None:
        """Delete an AI thread. Backs DELETE /api/v1/{tenant}/ai/threads/{threadId}."""
        path = self._tenant_path(tenant, "ai", "threads", thread_id)
        self._void_request("DELETE", path)

    def rename_thread(
        self, thread_id: str, tenant: str, body: ApiRenameThreadRequest
    ) -> ApiThreadDetail:
        """Rename an AI thread.
        Backs PATCH /api/v1/{tenant}/ai/threads/{threadId}/rename."""
        path = self._tenant_path(tenant, "ai", "threads", thread_id, "rename")
        return self._json_request("PATCH", path, ApiThreadDetail, body=body)

    def chat_in_thread(
        self, thread_id: str, tenant: str, body: ApiChatTurnRequest
    ) -> requests.Response:
        """Send a chat turn and return the raw SSE response for the caller to
        stream (Content-Type text/event-stream). The caller must close the body.
        Backs POST /api/v1/{tenant}/ai/threads/{threadId}/chat."""
        path = self._tenant_path(tenant, "ai", "threads", thread_id, "chat")
        return self._request(
            "POST", path, body=body, accept="text/event-stream", stream=True
        )

    def confirm_thread_action(
        self, thread_id: str, tenant: str, body: Dict[str, Any]
    ) -> requests.Response:
        """Confirm (or reject) a pending tool action and return the raw SSE
        response for the caller to stream. The caller must close the body.
        Backs POST /api/v1/{tenant}/ai/threads/{threadId}/confirm."""
        path = self._tenant_path(tenant, "ai", "threads", thread_id, "confirm")
        return self._request(
            "POST", path, body=body, accept="text/event-stream", stream=True
        )
