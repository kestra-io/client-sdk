from typing import Any, Dict, Generator, List, Optional

import requests

from kestrapy.base_api import BaseApi
from kestrapy.models.apps_controller_api_app import AppsControllerApiApp
from kestrapy.models.apps_controller_api_app_source import AppsControllerApiAppSource
from kestrapy.models.apps_controller_api_app_tags import AppsControllerApiAppTags
from kestrapy.models.apps_controller_api_bulk_import_response import AppsControllerApiBulkImportResponse
from kestrapy.models.apps_controller_api_bulk_operation_request import AppsControllerApiBulkOperationRequest
from kestrapy.models.file_metas import FileMetas
from kestrapy.models.level import Level
from kestrapy.models.paged_results_apps_controller_api_app import PagedResultsAppsControllerApiApp
from kestrapy.models.paged_results_apps_controller_api_app_catalog_item import PagedResultsAppsControllerApiAppCatalogItem
from kestrapy.models.query_filter import QueryFilter


class AppsApi(BaseApi):

    # ========================================================================
    # CRUD
    # ========================================================================

    def create_app(self, tenant: str, yaml_body: str) -> AppsControllerApiAppSource:
        path = self._tenant_path(tenant, "apps")
        return self._json_request("POST", path, AppsControllerApiAppSource, body=yaml_body, content_type=self.YAML)

    def app(self, uid: str, tenant: str) -> AppsControllerApiAppSource:
        path = self._tenant_path(tenant, "apps", uid)
        return self._json_request("GET", path, AppsControllerApiAppSource)

    def update_app(self, uid: str, tenant: str, yaml_body: str) -> None:
        path = self._tenant_path(tenant, "apps", uid)
        self._void_request("PUT", path, body=yaml_body, content_type=self.YAML)

    def delete_app(self, uid: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "apps", uid)
        self._void_request("DELETE", path)

    # ========================================================================
    # Enable / Disable
    # ========================================================================

    def enable_app(self, uid: str, tenant: str) -> AppsControllerApiApp:
        path = self._tenant_path(tenant, "apps", uid, "enable")
        return self._json_request("POST", path, AppsControllerApiApp)

    def disable_app(self, uid: str, tenant: str) -> AppsControllerApiApp:
        path = self._tenant_path(tenant, "apps", uid, "disable")
        return self._json_request("POST", path, AppsControllerApiApp)

    # ========================================================================
    # Bulk operations
    # ========================================================================

    def bulk_delete_apps(
        self, tenant: str, request: AppsControllerApiBulkOperationRequest,
    ) -> Any:
        path = self._tenant_path(tenant, "apps")
        return self._raw_json_request("DELETE", path, body=request)

    def bulk_enable_apps(
        self, tenant: str, request: AppsControllerApiBulkOperationRequest,
    ) -> Any:
        path = self._tenant_path(tenant, "apps", "enable")
        return self._raw_json_request("POST", path, body=request)

    def bulk_disable_apps(
        self, tenant: str, request: AppsControllerApiBulkOperationRequest,
    ) -> Any:
        path = self._tenant_path(tenant, "apps", "disable")
        return self._raw_json_request("POST", path, body=request)

    def bulk_export_apps(
        self, tenant: str, request: AppsControllerApiBulkOperationRequest,
    ) -> bytes:
        path = self._tenant_path(tenant, "apps", "export")
        return self._download_request("POST", path, body=request)

    def bulk_import_apps(
        self, tenant: str, file_content: Optional[bytes] = None,
    ) -> AppsControllerApiBulkImportResponse:
        path = self._tenant_path(tenant, "apps", "import")
        return self._multipart_upload(
            "POST", path, AppsControllerApiBulkImportResponse,
            field_name="fileUpload", file_content=file_content, file_name="fileUpload",
        )

    # ========================================================================
    # Search
    # ========================================================================

    def search_apps(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsAppsControllerApiApp:
        path = self._tenant_path(tenant, "apps", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsAppsControllerApiApp, params=params)

    def search_apps_from_catalog(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsAppsControllerApiAppCatalogItem:
        path = self._tenant_path(tenant, "apps", "catalog")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsAppsControllerApiAppCatalogItem, params=params)

    # ========================================================================
    # Tags
    # ========================================================================

    def list_tags(self, tenant: str) -> AppsControllerApiAppTags:
        path = self._tenant_path(tenant, "apps", "tags")
        return self._json_request("GET", path, AppsControllerApiAppTags)

    # ========================================================================
    # App execution helpers
    # ========================================================================

    def file_meta_from_app_execution(
        self, id: str, path_uri: str, tenant: str,
    ) -> FileMetas:
        path = self._tenant_path(tenant, "apps", "view", id, "file", "meta")
        params = self._build_query_params(path=path_uri)
        return self._json_request("GET", path, FileMetas, params=params)

    def file_preview_from_app_execution(
        self,
        id: str,
        path_uri: str,
        tenant: str,
        max_rows: Optional[int] = None,
        encoding: Optional[str] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "apps", "view", id, "file", "preview")
        params = self._build_query_params(path=path_uri, maxRows=max_rows, encoding=encoding)
        return self._raw_json_request("GET", path, params=params)

    def logs_from_app_execution(
        self,
        uid: str,
        execution_id: str,
        tenant: str,
        min_level: Optional[Level] = None,
        task_ids: Optional[List[str]] = None,
    ) -> bytes:
        path = self._tenant_path(tenant, "apps", "view", uid, "logs", "download")
        level_val = min_level.value if min_level is not None and hasattr(min_level, 'value') else min_level
        params = list(self._build_query_params(executionId=execution_id, minLevel=level_val).items())
        self._append_repeated_param(params, "taskIds", task_ids)
        return self._download_request("GET", path, params=params)

    # ========================================================================
    # Streaming (SSE)
    # ========================================================================

    def stream_events_from_app(
        self, id: str, stream: str, tenant: str,
    ) -> Generator[Any, None, None]:
        path = self._tenant_path(tenant, "apps", "view", id, "streams", stream)
        return self._sse_stream(path, dict)

    # ========================================================================
    # App view / preview / dispatch (#421)
    # ========================================================================

    def app_states(self, tenant: str) -> List[str]:
        """List the possible app execution-layout state names.

        Backs ``GET /api/v1/{tenant}/apps/states``.
        """
        path = self._tenant_path(tenant, "apps", "states")
        return self._json_list_request("GET", path, str)

    def open_app_view(self, uid: str, tenant: str) -> Dict[str, Any]:
        """Render a published app's current layout.

        Backs ``GET /api/v1/{tenant}/apps/view/{uid}``.
        """
        path = self._tenant_path(tenant, "apps", "view", uid)
        return self._raw_json_request("GET", path)

    def download_file_from_app_execution(
        self, id: str, tenant: str, path_uri: str,
    ) -> bytes:
        """Download a file produced by an app execution.

        Backs ``GET /api/v1/{tenant}/apps/view/{id}/file/download``.
        """
        path = self._tenant_path(tenant, "apps", "view", id, "file", "download")
        params = self._build_query_params(path=path_uri)
        return self._download_request("GET", path, params=params)

    def stream_app_events(
        self, id: str, stream: str, tenant: str,
    ) -> requests.Response:
        """Follow an app's event stream, returning the raw streaming response.

        Backs ``GET /api/v1/{tenant}/apps/view/{id}/streams/{stream}``.
        """
        path = self._tenant_path(tenant, "apps", "view", id, "streams", stream)
        return self._request("GET", path, accept="text/event-stream", stream=True)

    def preview_app(
        self, tenant: str, yaml_source: str, state: Optional[str] = None,
    ) -> Dict[str, Any]:
        """Render an app layout from its YAML source without persisting it.

        Backs ``POST /api/v1/{tenant}/apps/preview``.
        """
        path = self._tenant_path(tenant, "apps", "preview")
        params = self._build_query_params(state=state)
        return self._raw_json_request(
            "POST", path, body=yaml_source, content_type=self.YAML, params=params,
        )

    def preview_dispatch_app(
        self, dispatch: str, tenant: str, form_params: Dict[str, Any],
    ) -> requests.Response:
        """Dispatch an app preview with multipart input data.

        The YAML source goes in the ``__kestra_app_source__`` form field; every
        app input is an additional form field. Returns the raw response.
        Backs ``POST /api/v1/{tenant}/apps/preview/dispatch/{dispatch}``.
        """
        path = self._tenant_path(tenant, "apps", "preview", "dispatch", dispatch)
        files = {k: (None, str(v)) for k, v in (form_params or {}).items()}
        return self._request("POST", path, files=files)

    def dispatch_app(
        self, id: str, dispatch: str, tenant: str, form_params: Dict[str, Any],
    ) -> requests.Response:
        """Dispatch a published app with multipart input data.

        Returns the raw response for the caller to read.
        Backs ``POST /api/v1/{tenant}/apps/view/{id}/dispatch/{dispatch}``.
        """
        path = self._tenant_path(tenant, "apps", "view", id, "dispatch", dispatch)
        files = {k: (None, str(v)) for k, v in (form_params or {}).items()}
        return self._request("POST", path, files=files)
