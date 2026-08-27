from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.paged_results_api_policy_summary import PagedResultsApiPolicySummary
from kestrapy.models.policy import Policy
from kestrapy.models.policy_evaluation import PolicyEvaluation
from kestrapy.models.policy_import_result import PolicyImportResult
from kestrapy.models.policy_preview_request import PolicyPreviewRequest
from kestrapy.models.policy_preview_response import PolicyPreviewResponse
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation


class PoliciesApi(BaseApi):
    """Governance Policies.

    A policy is authored as YAML and sent as the raw source: the API parses it, stamps the
    scope, tenant and namespace from the URL, and stores the source alongside the parsed
    model, so create/update/validate take a ``str`` rather than a ``Policy``.

    The same ten operations exist at each of the three scopes — INSTANCE (super-admin, not
    tenant-scoped), TENANT and NAMESPACE. ``STATIC`` policies are declared in the Kestra
    configuration and are read-only through the API.
    """

    # ---- Path builders ----

    def _instance_base(self, *segments: str) -> str:
        """INSTANCE-scope policies are not tenant-scoped: ``instance`` is a literal segment."""
        return self._tenant_path("instance", "policies", *segments)

    def _tenant_base(self, tenant: str, *segments: str) -> str:
        return self._tenant_path(tenant, "policies", *segments)

    def _namespace_base(self, tenant: str, namespace: str, *segments: str) -> str:
        return self._tenant_path(tenant, "namespaces", namespace, "policies", *segments)

    def _search_params(self, page, size, sort, filters):
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return params

    # ---- INSTANCE scope ----

    def create_instance_policy(self, source: str) -> Policy:
        return self._json_request("POST", self._instance_base(), Policy, body=source, content_type=self.YAML)

    def instance_policy(self, id: str) -> Policy:
        return self._json_request("GET", self._instance_base(id), Policy)

    def update_instance_policy(self, id: str, source: str) -> Policy:
        return self._json_request("PUT", self._instance_base(id), Policy, body=source, content_type=self.YAML)

    def delete_instance_policy(self, id: str) -> None:
        self._void_request("DELETE", self._instance_base(id))

    def delete_instance_policies_by_ids(self, ids: List[str]) -> BulkResponse:
        return self._json_request("DELETE", self._instance_base("delete", "by-ids"), BulkResponse, body=ids)

    def search_instance_policies(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsApiPolicySummary:
        return self._json_request("GET", self._instance_base("search"), PagedResultsApiPolicySummary,
                                  params=self._search_params(page, size, sort, filters))

    def validate_instance_policy(self, source: str) -> ValidateConstraintViolation:
        return self._json_request("POST", self._instance_base("validate"), ValidateConstraintViolation,
                                  body=source, content_type=self.YAML)

    def evaluate_instance_policy(self, id: str, page: Optional[int] = None,
                            size: Optional[int] = None) -> PolicyEvaluation:
        params = list(self._build_query_params(page=page, size=size).items())
        return self._json_request("GET", self._instance_base(id, "evaluate"), PolicyEvaluation, params=params)

    def export_instance_policies(self) -> bytes:
        return self._download_request("POST", self._instance_base("export"))

    def export_instance_policies_by_ids(self, ids: List[str]) -> bytes:
        return self._download_request("POST", self._instance_base("export", "by-ids"), body=ids)

    # ---- TENANT scope ----

    def create_tenant_policy(self, tenant: str, source: str) -> Policy:
        return self._json_request("POST", self._tenant_base(tenant), Policy, body=source, content_type=self.YAML)

    def tenant_policy(self, tenant: str, id: str) -> Policy:
        return self._json_request("GET", self._tenant_base(tenant, id), Policy)

    def update_tenant_policy(self, tenant: str, id: str, source: str) -> Policy:
        return self._json_request("PUT", self._tenant_base(tenant, id), Policy, body=source, content_type=self.YAML)

    def delete_tenant_policy(self, tenant: str, id: str) -> None:
        self._void_request("DELETE", self._tenant_base(tenant, id))

    def delete_tenant_policies_by_ids(self, tenant: str, ids: List[str]) -> BulkResponse:
        return self._json_request("DELETE", self._tenant_base(tenant, "delete", "by-ids"), BulkResponse, body=ids)

    def search_policies(
        self, tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsApiPolicySummary:
        return self._json_request("GET", self._tenant_base(tenant, "search"), PagedResultsApiPolicySummary,
                                  params=self._search_params(page, size, sort, filters))

    def validate_tenant_policy(self, tenant: str, source: str) -> ValidateConstraintViolation:
        return self._json_request("POST", self._tenant_base(tenant, "validate"), ValidateConstraintViolation,
                                  body=source, content_type=self.YAML)

    def evaluate_tenant_policy(self, tenant: str, id: str, page: Optional[int] = None,
                            size: Optional[int] = None) -> PolicyEvaluation:
        params = list(self._build_query_params(page=page, size=size).items())
        return self._json_request("GET", self._tenant_base(tenant, id, "evaluate"), PolicyEvaluation, params=params)

    def export_tenant_policies(self, tenant: str) -> bytes:
        return self._download_request("POST", self._tenant_base(tenant, "export"))

    def export_tenant_policies_by_ids(self, tenant: str, ids: List[str]) -> bytes:
        return self._download_request("POST", self._tenant_base(tenant, "export", "by-ids"), body=ids)

    # ---- NAMESPACE scope ----

    def create_namespace_policy(self, tenant: str, namespace: str, source: str) -> Policy:
        return self._json_request("POST", self._namespace_base(tenant, namespace), Policy, body=source, content_type=self.YAML)

    def namespace_policy(self, tenant: str, namespace: str, id: str) -> Policy:
        return self._json_request("GET", self._namespace_base(tenant, namespace, id), Policy)

    def update_namespace_policy(self, tenant: str, namespace: str, id: str, source: str) -> Policy:
        return self._json_request("PUT", self._namespace_base(tenant, namespace, id), Policy, body=source, content_type=self.YAML)

    def delete_namespace_policy(self, tenant: str, namespace: str, id: str) -> None:
        self._void_request("DELETE", self._namespace_base(tenant, namespace, id))

    def delete_namespace_policies_by_ids(self, tenant: str, namespace: str, ids: List[str]) -> BulkResponse:
        return self._json_request("DELETE", self._namespace_base(tenant, namespace, "delete", "by-ids"), BulkResponse, body=ids)

    def search_namespace_policies(
        self, tenant: str, namespace: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsApiPolicySummary:
        return self._json_request("GET", self._namespace_base(tenant, namespace, "search"), PagedResultsApiPolicySummary,
                                  params=self._search_params(page, size, sort, filters))

    def validate_namespace_policy(self, tenant: str, namespace: str, source: str) -> ValidateConstraintViolation:
        return self._json_request("POST", self._namespace_base(tenant, namespace, "validate"), ValidateConstraintViolation,
                                  body=source, content_type=self.YAML)

    def evaluate_namespace_policy(self, tenant: str, namespace: str, id: str, page: Optional[int] = None,
                            size: Optional[int] = None) -> PolicyEvaluation:
        params = list(self._build_query_params(page=page, size=size).items())
        return self._json_request("GET", self._namespace_base(tenant, namespace, id, "evaluate"), PolicyEvaluation, params=params)

    def export_namespace_policies(self, tenant: str, namespace: str) -> bytes:
        return self._download_request("POST", self._namespace_base(tenant, namespace, "export"))

    def export_namespace_policies_by_ids(self, tenant: str, namespace: str, ids: List[str]) -> bytes:
        return self._download_request("POST", self._namespace_base(tenant, namespace, "export", "by-ids"), body=ids)

    # ---- Import & Preview (tenant scope only) ----

    def import_policies(self, tenant: str, file_content: Any = None) -> PolicyImportResult:
        """Imports policies from an archive, as produced by any of the export endpoints."""
        return self._multipart_upload(
            "POST", self._tenant_base(tenant, "import"), PolicyImportResult,
            field_name="fileUpload", file_content=file_content, file_name="fileUpload",
        )

    def preview_policies(self, tenant: str, request: PolicyPreviewRequest) -> PolicyPreviewResponse:
        """Previews the policies that would apply to a flow, without persisting anything."""
        return self._json_request("POST", self._tenant_path(tenant, "flows", "policies", "preview"),
                                  PolicyPreviewResponse, body=request)
