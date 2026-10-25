import os
from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.cases_controller_api_case import CasesControllerApiCase
from kestrapy.models.cases_controller_api_case_event import CasesControllerApiCaseEvent
from kestrapy.models.paged_results_cases_controller_api_case import (
    PagedResultsCasesControllerApiCase,
)
from kestrapy.models.paged_results_cases_controller_api_case_asset import (
    PagedResultsCasesControllerApiCaseAsset,
)
from kestrapy.models.paged_results_cases_controller_api_case_event import (
    PagedResultsCasesControllerApiCaseEvent,
)
from kestrapy.models.paged_results_cases_controller_api_case_execution import (
    PagedResultsCasesControllerApiCaseExecution,
)
from kestrapy.models.paged_results_cases_controller_api_case_summary import (
    PagedResultsCasesControllerApiCaseSummary,
)
from kestrapy.models.paged_results_cases_controller_api_subject_ref import (
    PagedResultsCasesControllerApiSubjectRef,
)
from kestrapy.models.query_filter import QueryFilter


class CasesApi(BaseApi):
    """Cases (`/api/v1/{tenant}/cases`).

    Cases group related executions, assets and actions under an
    acknowledge/resolve lifecycle. The controller is an EE feature gated by the
    ``CASE`` resource, so every route answers 403 when the feature is disabled.

    Case request/response bodies are large and nested; this wrapper types the
    response envelopes (paged results, ``Case``) but accepts request bodies as
    plain ``Dict[str, Any]`` so callers can send exactly what the backend
    expects without a brittle hand-written request model.
    """

    # ---- creation from a task ----

    def create_case_from_task(self, tenant: str, body: Dict[str, Any]) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "cases", "from-task")
        return self._raw_json_request("POST", path, body=body)

    # ---- search / counts ----

    def search_cases(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
        date_filter: Optional[str] = None,
    ) -> PagedResultsCasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", "search")
        params = list(self._build_query_params(page=page, size=size, dateFilter=date_filter).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsCasesControllerApiCase, params=params)

    def case_counts(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
        date_filter: Optional[str] = None,
    ) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "cases", "counts")
        params = list(self._build_query_params(dateFilter=date_filter).items())
        self._append_filter_params(params, filters)
        return self._raw_json_request("GET", path, params=params)

    def case_assignees(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
        date_filter: Optional[str] = None,
    ) -> PagedResultsCasesControllerApiSubjectRef:
        path = self._tenant_path(tenant, "cases", "assignees")
        params = list(self._build_query_params(dateFilter=date_filter).items())
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsCasesControllerApiSubjectRef, params=params)

    # ---- CRUD ----

    def create_case(self, tenant: str, body: Dict[str, Any]) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def get_case(
        self, tenant: str, id: str, allow_deleted: Optional[bool] = None
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id)
        params = self._build_query_params(allowDeleted=allow_deleted)
        return self._json_request("GET", path, CasesControllerApiCase, params=params)

    def update_case(self, tenant: str, id: str, body: Dict[str, Any]) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id)
        return self._json_request("PUT", path, CasesControllerApiCase, body=body)

    def delete_case(self, tenant: str, id: str) -> None:
        path = self._tenant_path(tenant, "cases", id)
        self._void_request("DELETE", path)

    def delete_cases_by_ids(self, tenant: str, case_ids: List[str]) -> BulkResponse:
        path = self._tenant_path(tenant, "cases", "by-ids", "delete")
        return self._json_request("POST", path, BulkResponse, body=case_ids)

    def delete_cases_by_query(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
        date_filter: Optional[str] = None,
    ) -> BulkResponse:
        path = self._tenant_path(tenant, "cases", "by-query")
        params = list(self._build_query_params(dateFilter=date_filter).items())
        self._append_filter_params(params, filters)
        return self._json_request("DELETE", path, BulkResponse, params=params)

    # ---- lifecycle ----

    def acknowledge_cases_by_ids(self, tenant: str, case_ids: List[str]) -> BulkResponse:
        path = self._tenant_path(tenant, "cases", "by-ids", "acknowledge")
        return self._json_request("POST", path, BulkResponse, body=case_ids)

    def acknowledge_case(self, tenant: str, id: str) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "acknowledge")
        return self._json_request("POST", path, CasesControllerApiCase)

    def resolve_case(self, tenant: str, id: str, body: Dict[str, Any]) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "resolve")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def cancel_case(
        self, tenant: str, id: str, body: Optional[Dict[str, Any]] = None
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "cancel")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def change_case_status(
        self, tenant: str, id: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "status")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def assign_case(self, tenant: str, id: str, body: Dict[str, Any]) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "assign")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def follow_case(self, tenant: str, id: str) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "follow")
        return self._json_request("POST", path, CasesControllerApiCase)

    def unfollow_case(self, tenant: str, id: str) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "unfollow")
        return self._json_request("POST", path, CasesControllerApiCase)

    # ---- events / comments / attachments ----

    def case_events(
        self, tenant: str, id: str, page: Optional[int] = None, size: Optional[int] = None
    ) -> PagedResultsCasesControllerApiCaseEvent:
        path = self._tenant_path(tenant, "cases", id, "events")
        params = self._build_query_params(page=page, size=size)
        return self._json_request("GET", path, PagedResultsCasesControllerApiCaseEvent, params=params)

    def add_case_comment(
        self,
        tenant: str,
        id: str,
        body: Optional[str] = None,
        file_path: Optional[str] = None,
    ) -> CasesControllerApiCaseEvent:
        """Post a comment on a case with an optional markdown body and an optional
        file attachment. Sent as ``multipart/form-data`` (fields ``body`` and
        ``files``)."""
        path = self._tenant_path(tenant, "cases", id, "comments")
        files: Dict[str, Any] = {}
        if body is not None:
            files["body"] = (None, body)
        if file_path is not None:
            with open(file_path, "rb") as f:
                files["files"] = (os.path.basename(file_path), f.read())
        resp = self._request("POST", path, files=files)
        return self._deserialize(resp.json(), CasesControllerApiCaseEvent)

    def download_case_attachment(self, tenant: str, id: str, attachment_id: str) -> bytes:
        path = self._tenant_path(tenant, "cases", id, "attachments", attachment_id)
        return self._download_request("GET", path)

    # ---- linked executions ----

    def case_executions(
        self, tenant: str, id: str, page: Optional[int] = None, size: Optional[int] = None
    ) -> PagedResultsCasesControllerApiCaseExecution:
        path = self._tenant_path(tenant, "cases", id, "executions")
        params = self._build_query_params(page=page, size=size)
        return self._json_request(
            "GET", path, PagedResultsCasesControllerApiCaseExecution, params=params
        )

    def link_case_executions(
        self, tenant: str, id: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "executions")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def link_case_executions_by_query(
        self, tenant: str, id: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "executions", "by-query")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def unlink_case_execution(self, tenant: str, id: str, execution_id: str) -> None:
        path = self._tenant_path(tenant, "cases", id, "executions", execution_id)
        self._void_request("DELETE", path)

    # ---- auto-attach ----

    def enable_case_auto_attach(
        self, tenant: str, id: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "auto-attach")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def disable_case_auto_attach(self, tenant: str, id: str) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "auto-attach")
        return self._json_request("DELETE", path, CasesControllerApiCase)

    # ---- creation from executions ----

    def create_case_from_executions(
        self, tenant: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", "from-executions")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def create_case_from_executions_by_query(
        self, tenant: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", "from-executions", "by-query")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def cases_by_executions(self, tenant: str, execution_ids: List[str]) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "cases", "by-executions")
        return self._raw_json_request("POST", path, body=execution_ids)

    # ---- assets ----

    def case_assets(self, tenant: str, id: str) -> PagedResultsCasesControllerApiCaseAsset:
        path = self._tenant_path(tenant, "cases", id, "assets")
        return self._json_request("GET", path, PagedResultsCasesControllerApiCaseAsset)

    def attach_case_asset(
        self, tenant: str, id: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "assets")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def detach_case_asset(self, tenant: str, id: str, asset_id: str) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "assets", asset_id)
        return self._json_request("DELETE", path, CasesControllerApiCase)

    def cases_by_asset(self, tenant: str, asset_id: str) -> PagedResultsCasesControllerApiCaseSummary:
        path = self._tenant_path(tenant, "cases", "by-asset", asset_id)
        return self._json_request("GET", path, PagedResultsCasesControllerApiCaseSummary)

    # ---- actions ----

    def attach_case_action(
        self, tenant: str, id: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "actions")
        return self._json_request("POST", path, CasesControllerApiCase, body=body)

    def update_case_action(
        self, tenant: str, id: str, namespace: str, flow_id: str, body: Dict[str, Any]
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "actions", namespace, flow_id)
        return self._json_request("PUT", path, CasesControllerApiCase, body=body)

    def detach_case_action(
        self, tenant: str, id: str, namespace: str, flow_id: str
    ) -> CasesControllerApiCase:
        path = self._tenant_path(tenant, "cases", id, "actions", namespace, flow_id)
        return self._json_request("DELETE", path, CasesControllerApiCase)

    def run_case_action(self, tenant: str, id: str, body: Dict[str, Any]) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "cases", id, "actions", "run")
        return self._raw_json_request("POST", path, body=body)
