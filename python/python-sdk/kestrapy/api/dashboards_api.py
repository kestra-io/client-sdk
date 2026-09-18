from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.chart_filters_overrides import ChartFiltersOverrides
from kestrapy.models.dashboard_controller_preview_request import DashboardControllerPreviewRequest
from kestrapy.models.paged_results_map_string_object import PagedResultsMapStringObject
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation


class DashboardsApi(BaseApi):

    # ---- CRUD ----

    def create_dashboard(self, tenant: str, yaml_body: str) -> dict:
        path = self._tenant_path(tenant, "dashboards")
        return self._raw_json_request("POST", path, body=yaml_body, content_type=self.YAML)

    def dashboard(self, id: str, tenant: str) -> dict:
        path = self._tenant_path(tenant, "dashboards", id)
        return self._raw_json_request("GET", path)

    def update_dashboard(self, id: str, tenant: str, yaml_body: str) -> dict:
        path = self._tenant_path(tenant, "dashboards", id)
        return self._raw_json_request("PUT", path, body=yaml_body, content_type=self.YAML)

    def delete_dashboard(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "dashboards", id)
        self._void_request("DELETE", path)

    # ---- Search ----

    def search_dashboards(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        q: Optional[str] = None,
        sort: Optional[List[str]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "dashboards")
        params = list(self._build_query_params(page=page, size=size, q=q).items())
        self._append_repeated_param(params, "sort", sort)
        return self._raw_json_request("GET", path, params=params)

    # ---- Charts ----

    def dashboard_chart_data(self, id: str, chart_id: str, tenant: str, filters: ChartFiltersOverrides) -> PagedResultsMapStringObject:
        path = self._tenant_path(tenant, "dashboards", id, "charts", chart_id)
        return self._json_request("POST", path, PagedResultsMapStringObject, body=filters)

    def preview_chart(self, tenant: str, request: DashboardControllerPreviewRequest) -> PagedResultsMapStringObject:
        path = self._tenant_path(tenant, "dashboards", "charts", "preview")
        return self._json_request("POST", path, PagedResultsMapStringObject, body=request)

    def export_chart(self, tenant: str, request: DashboardControllerPreviewRequest, format: Optional[str] = None) -> bytes:
        path = self._tenant_path(tenant, "dashboards", "charts", "export")
        params = list(self._build_query_params(format=format).items())
        return self._download_request("POST", path, body=request, params=params, accept=self.OCTET)

    def export_dashboard_chart(self, id: str, chart_id: str, tenant: str, filters: ChartFiltersOverrides, format: Optional[str] = None) -> bytes:
        path = self._tenant_path(tenant, "dashboards", id, "charts", chart_id, "export")
        params = list(self._build_query_params(format=format).items())
        return self._download_request("POST", path, body=filters, params=params, accept=self.OCTET)

    # ---- Settings ----

    def default_dashboards(self, tenant: str) -> dict:
        path = self._tenant_path(tenant, "dashboards", "settings", "default-dashboards")
        return self._raw_json_request("GET", path)

    # ---- Validation ----

    def validate_dashboard(self, tenant: str, yaml_body: str) -> ValidateConstraintViolation:
        path = self._tenant_path(tenant, "dashboards", "validate")
        return self._json_request("POST", path, ValidateConstraintViolation, body=yaml_body, content_type=self.YAML)

    def validate_chart(self, tenant: str, yaml_body: str) -> ValidateConstraintViolation:
        path = self._tenant_path(tenant, "dashboards", "validate", "chart")
        return self._json_request("POST", path, ValidateConstraintViolation, body=yaml_body, content_type=self.YAML)
