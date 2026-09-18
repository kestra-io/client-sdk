from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.case_templates_controller_api_case_template import (
    CaseTemplatesControllerApiCaseTemplate,
)
from kestrapy.models.paged_results_case_templates_controller_api_case_template import (
    PagedResultsCaseTemplatesControllerApiCaseTemplate,
)
from kestrapy.models.query_filter import QueryFilter


class CaseTemplatesApi(BaseApi):
    """Case templates (`/api/v1/{tenant}/case-templates`).

    A case template pre-fills default severity, assignees, watchers, SLA and
    actions when a case is created from it. Like cases, it is an EE feature gated
    by the ``CASE`` resource, so every route answers 403 when disabled. Request
    bodies are accepted as plain ``Dict[str, Any]``.
    """

    def search_case_templates(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsCaseTemplatesControllerApiCaseTemplate:
        path = self._tenant_path(tenant, "case-templates", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request(
            "GET", path, PagedResultsCaseTemplatesControllerApiCaseTemplate, params=params
        )

    def create_case_template(
        self, tenant: str, body: Dict[str, Any]
    ) -> CaseTemplatesControllerApiCaseTemplate:
        path = self._tenant_path(tenant, "case-templates")
        return self._json_request("POST", path, CaseTemplatesControllerApiCaseTemplate, body=body)

    def get_case_template(self, tenant: str, id: str) -> CaseTemplatesControllerApiCaseTemplate:
        path = self._tenant_path(tenant, "case-templates", id)
        return self._json_request("GET", path, CaseTemplatesControllerApiCaseTemplate)

    def update_case_template(
        self, tenant: str, id: str, body: Dict[str, Any]
    ) -> CaseTemplatesControllerApiCaseTemplate:
        path = self._tenant_path(tenant, "case-templates", id)
        return self._json_request("PUT", path, CaseTemplatesControllerApiCaseTemplate, body=body)

    def delete_case_template(self, tenant: str, id: str) -> None:
        path = self._tenant_path(tenant, "case-templates", id)
        self._void_request("DELETE", path)
