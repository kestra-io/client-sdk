from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.paged_results_api_policy_summary import PagedResultsApiPolicySummary
from kestrapy.models.policy import Policy
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation


class PoliciesApi(BaseApi):
    """Instance-scope policies (`/api/v1/instance/policies`). Instance-owner-only.

    Policies are authored as YAML and returned as :class:`Policy`. Tenant- and
    namespace-scoped policies live on other resources and are not covered here.
    """


    def search_instance_policies(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsApiPolicySummary:
        path = self._superadmin_path("instance", "policies", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsApiPolicySummary, params=params)

    def instance_policy(self, id: str, scope: Optional[str] = None) -> Policy:
        path = self._superadmin_path("instance", "policies", id)
        params = self._build_query_params(scope=scope)
        return self._json_request("GET", path, Policy, params=params)

    def create_instance_policy(self, source: str) -> Policy:
        path = self._superadmin_path("instance", "policies")
        return self._json_request("POST", path, Policy, body=source, content_type=self.YAML)

    def update_instance_policy(self, id: str, source: str) -> Policy:
        path = self._superadmin_path("instance", "policies", id)
        return self._json_request("PUT", path, Policy, body=source, content_type=self.YAML)

    def validate_instance_policy(self, source: str) -> ValidateConstraintViolation:
        path = self._superadmin_path("instance", "policies", "validate")
        return self._json_request("POST", path, ValidateConstraintViolation, body=source, content_type=self.YAML)

    def delete_instance_policy(self, id: str) -> None:
        path = self._superadmin_path("instance", "policies", id)
        self._void_request("DELETE", path)

    def delete_instance_policies_by_ids(self, ids: List[str]) -> BulkResponse:
        path = self._superadmin_path("instance", "policies", "delete", "by-ids")
        return self._json_request("DELETE", path, BulkResponse, body=ids)

    def evaluate_instance_policy(
        self,
        id: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        scope: Optional[str] = None,
    ) -> Any:
        path = self._superadmin_path("instance", "policies", id, "evaluate")
        params = self._build_query_params(page=page, size=size, scope=scope)
        return self._raw_json_request("GET", path, params=params)

    def export_instance_policies(self) -> bytes:
        path = self._superadmin_path("instance", "policies", "export")
        return self._download_request("POST", path)

    def export_instance_policies_by_ids(self, ids: List[str]) -> bytes:
        path = self._superadmin_path("instance", "policies", "export", "by-ids")
        return self._download_request("POST", path, body=ids)
