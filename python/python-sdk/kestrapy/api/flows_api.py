from typing import Any, Dict, Generator, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.concurrency_limit import ConcurrencyLimit
from kestrapy.models.flow import Flow
from kestrapy.models.flow_graph import FlowGraph
from kestrapy.models.flow_interface import FlowInterface
from kestrapy.models.flow_topology_graph import FlowTopologyGraph
from kestrapy.models.flow_with_source import FlowWithSource
from kestrapy.models.id_with_namespace import IdWithNamespace
from kestrapy.models.paged_results_concurrency_limit import PagedResultsConcurrencyLimit
from kestrapy.models.paged_results_flow import PagedResultsFlow
from kestrapy.models.policy_preview_request import PolicyPreviewRequest
from kestrapy.models.policy_preview_response import PolicyPreviewResponse
from kestrapy.models.paged_results_source_search_result import PagedResultsSourceSearchResult
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.source_search_scope import SourceSearchScope
from kestrapy.models.task import Task
from kestrapy.models.validate_constraint_violation import ValidateConstraintViolation


class FlowsApi(BaseApi):

    # ========================================================================
    # CRUD
    # ========================================================================

    def create_flow(self, tenant: str, body: str) -> FlowWithSource:
        path = self._tenant_path(tenant, "flows")
        return self._json_request("POST", path, FlowWithSource, body=body, content_type=self.YAML)

    def flow(
        self,
        namespace: str,
        id: str,
        tenant: str,
        source: Optional[bool] = None,
        revision: Optional[int] = None,
        allow_deleted: Optional[bool] = None,
    ) -> FlowWithSource:
        path = self._tenant_path(tenant, "flows", namespace, id)
        params = self._build_query_params(source=source, revision=revision, allowDeleted=allow_deleted)
        return self._json_request("GET", path, FlowWithSource, params=params)

    def update_flow(self, namespace: str, id: str, tenant: str, body: str) -> FlowWithSource:
        path = self._tenant_path(tenant, "flows", namespace, id)
        return self._json_request("PUT", path, FlowWithSource, body=body, content_type=self.YAML)

    def delete_flow(self, namespace: str, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "flows", namespace, id)
        self._void_request("DELETE", path)

    # ========================================================================
    # Bulk CRUD
    # ========================================================================

    def bulk_update_flows(
        self,
        tenant: str,
        delete: Optional[bool] = None,
        namespace: Optional[str] = None,
        allow_namespace_child: Optional[bool] = None,
        body: Optional[str] = None,
    ) -> List[FlowInterface]:
        path = self._tenant_path(tenant, "flows", "bulk")
        params = self._build_query_params(
            delete=delete, namespace=namespace, allowNamespaceChild=allow_namespace_child,
        )
        return self._json_list_request("POST", path, FlowInterface, params=params, body=body, content_type=self.YAML)

    def delete_flows_by_ids(self, tenant: str, ids: List[IdWithNamespace]) -> BulkResponse:
        path = self._tenant_path(tenant, "flows", "delete", "by-ids")
        body = [i.model_dump(by_alias=True, exclude_none=True) if hasattr(i, 'model_dump') else i for i in ids]
        return self._json_request("DELETE", path, BulkResponse, body=body)

    def delete_flows_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> BulkResponse:
        path = self._tenant_path(tenant, "flows", "delete", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._json_request("DELETE", path, BulkResponse, params=params)

    def disable_flows_by_ids(self, tenant: str, ids: List[IdWithNamespace]) -> BulkResponse:
        path = self._tenant_path(tenant, "flows", "disable", "by-ids")
        body = [i.model_dump(by_alias=True, exclude_none=True) if hasattr(i, 'model_dump') else i for i in ids]
        return self._json_request("POST", path, BulkResponse, body=body)

    def disable_flows_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> BulkResponse:
        path = self._tenant_path(tenant, "flows", "disable", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._json_request("POST", path, BulkResponse, params=params)

    def enable_flows_by_ids(self, tenant: str, ids: List[IdWithNamespace]) -> BulkResponse:
        path = self._tenant_path(tenant, "flows", "enable", "by-ids")
        body = [i.model_dump(by_alias=True, exclude_none=True) if hasattr(i, 'model_dump') else i for i in ids]
        return self._json_request("POST", path, BulkResponse, body=body)

    def enable_flows_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> BulkResponse:
        path = self._tenant_path(tenant, "flows", "enable", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._json_request("POST", path, BulkResponse, params=params)

    # ========================================================================
    # Search & List
    # ========================================================================

    def search_flows(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsFlow:
        path = self._tenant_path(tenant, "flows", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsFlow, params=params)

    def search_flows_by_source_code(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        q: Optional[str] = None,
        namespace: Optional[str] = None,
        case_sensitive: Optional[bool] = None,
        whole_word: Optional[bool] = None,
        regex: Optional[bool] = None,
        scope: Optional[SourceSearchScope] = None,
    ) -> PagedResultsSourceSearchResult:
        """Search flows by their source code content.

        2.0: each hit is a flat SourceSearchResult carrying the matching lines,
        not a wrapper around the flow itself.
        """
        path = self._tenant_path(tenant, "flows", "source")
        params = list(self._build_query_params(
            page=page, size=size, q=q, namespace=namespace,
            caseSensitive=case_sensitive, wholeWord=whole_word, regex=regex, scope=scope,
        ).items())
        self._append_repeated_param(params, "sort", sort)
        return self._json_request("GET", path, PagedResultsSourceSearchResult, params=params)

    def list_flows_by_namespace(self, namespace: str, tenant: str) -> List[Flow]:
        path = self._tenant_path(tenant, "flows", namespace)
        return self._json_list_request("GET", path, Flow)

    def list_distinct_namespaces(self, tenant: str, q: Optional[str] = None) -> List[str]:
        path = self._tenant_path(tenant, "flows", "distinct-namespaces")
        params = self._build_query_params(q=q)
        return self._json_list_request("GET", path, str, params=params)

    def list_deprecated(self, tenant: str, namespace: Optional[str] = None) -> Any:
        path = self._tenant_path(tenant, "flows", "deprecated")
        params = self._build_query_params(namespace=namespace)
        return self._raw_json_request("GET", path, params=params)

    # ========================================================================
    # Revisions
    # ========================================================================

    def list_flow_revisions(
        self,
        namespace: str,
        id: str,
        tenant: str,
        allow_delete: Optional[bool] = None,
    ) -> List[FlowWithSource]:
        path = self._tenant_path(tenant, "flows", namespace, id, "revisions")
        params = self._build_query_params(allowDelete=allow_delete)
        return self._json_list_request("GET", path, FlowWithSource, params=params)

    def delete_revisions(
        self, namespace: str, id: str, tenant: str, revisions: List[int],
    ) -> None:
        path = self._tenant_path(tenant, "flows", namespace, id, "revisions")
        params = self._build_query_params(revisions=",".join(str(r) for r in revisions))
        self._void_request("DELETE", path, params=params)

    # ========================================================================
    # Namespace operations
    # ========================================================================

    def update_flows_in_namespace(
        self,
        namespace: str,
        tenant: str,
        body: str,
        delete: Optional[bool] = None,
        override: Optional[bool] = None,
    ) -> List[FlowInterface]:
        path = self._tenant_path(tenant, "flows", namespace)
        params = self._build_query_params(delete=delete, override=override)
        return self._json_list_request("POST", path, FlowInterface, params=params, body=body, content_type=self.YAML)

    # ========================================================================
    # Export & Import
    # ========================================================================

    def export_flows_by_ids(self, tenant: str, ids: List[IdWithNamespace]) -> bytes:
        path = self._tenant_path(tenant, "flows", "export", "by-ids")
        body = [i.model_dump(by_alias=True, exclude_none=True) if hasattr(i, 'model_dump') else i for i in ids]
        return self._download_request("POST", path, body=body)

    def export_flows_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> bytes:
        path = self._tenant_path(tenant, "flows", "export", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._download_request("GET", path, params=params)

    def import_flows(
        self,
        tenant: str,
        fail_on_error: Optional[bool] = None,
        file_content: Optional[bytes] = None,
    ) -> List[str]:
        path = self._tenant_path(tenant, "flows", "import")
        params = self._build_query_params(failOnError=fail_on_error)
        # Server picks the parser (ZIP vs YAML) from the filename extension and
        # crashes on filenames without a dot, so derive one from the content.
        is_zip = isinstance(file_content, (bytes, bytearray)) and file_content[:4] == b"PK\x03\x04"
        file_name = "flows.zip" if is_zip else "flows.yml"
        return self._multipart_upload_list(
            "POST", path, str,
            params=params, field_name="fileUpload", file_content=file_content, file_name=file_name,
        )

    # ========================================================================
    # Graph & Dependencies
    # ========================================================================

    def generate_flow_graph(
        self,
        namespace: str,
        id: str,
        tenant: str,
        revision: Optional[int] = None,
        subflows: Optional[List[str]] = None,
    ) -> FlowGraph:
        path = self._tenant_path(tenant, "flows", namespace, id, "graph")
        params = list(self._build_query_params(revision=revision).items())
        self._append_repeated_param(params, "subflows", subflows)
        return self._json_request("GET", path, FlowGraph, params=params)

    def generate_flow_graph_from_source(
        self,
        tenant: str,
        body: str,
        subflows: Optional[List[str]] = None,
    ) -> FlowGraph:
        path = self._tenant_path(tenant, "flows", "graph")
        params: list = []
        self._append_repeated_param(params, "subflows", subflows)
        return self._json_request("POST", path, FlowGraph, params=params, body=body, content_type=self.YAML)

    def flow_dependencies(
        self,
        namespace: str,
        id: str,
        tenant: str,
        destination_only: Optional[bool] = None,
        expand_all: Optional[bool] = None,
    ) -> FlowTopologyGraph:
        path = self._tenant_path(tenant, "flows", namespace, id, "dependencies")
        params = self._build_query_params(destinationOnly=destination_only, expandAll=expand_all)
        return self._json_request("GET", path, FlowTopologyGraph, params=params)

    def flow_dependencies_from_namespace(
        self,
        namespace: str,
        tenant: str,
        destination_only: Optional[bool] = None,
    ) -> FlowTopologyGraph:
        path = self._tenant_path(tenant, "namespaces", namespace, "dependencies")
        params = self._build_query_params(destinationOnly=destination_only)
        return self._json_request("GET", path, FlowTopologyGraph, params=params)

    # ========================================================================
    # Tasks
    # ========================================================================

    def task_from_flow(
        self,
        namespace: str,
        id: str,
        task_id: str,
        tenant: str,
        revision: Optional[int] = None,
    ) -> Task:
        path = self._tenant_path(tenant, "flows", namespace, id, "tasks", task_id)
        params = self._build_query_params(revision=revision)
        return self._json_request("GET", path, Task, params=params)

    # ========================================================================
    # Concurrency
    # ========================================================================

    def search_concurrency_limits(self, tenant: str) -> PagedResultsConcurrencyLimit:
        path = self._tenant_path(tenant, "concurrency-limit", "search")
        return self._json_request("GET", path, PagedResultsConcurrencyLimit)

    def update_concurrency_limit(
        self,
        namespace: str,
        flow_id: str,
        tenant: str,
        concurrency_limit: ConcurrencyLimit,
    ) -> ConcurrencyLimit:
        path = self._tenant_path(tenant, "concurrency-limit", namespace, flow_id)
        return self._json_request("PUT", path, ConcurrencyLimit, body=concurrency_limit)

    # ========================================================================
    # Validation
    # ========================================================================

    def validate_flows(self, tenant: str, body: str) -> List[ValidateConstraintViolation]:
        path = self._tenant_path(tenant, "flows", "validate")
        return self._json_list_request("POST", path, ValidateConstraintViolation, body=body, content_type=self.YAML)

    def validate_task(
        self,
        section: str,
        tenant: str,
        body: Any,
    ) -> ValidateConstraintViolation:
        path = self._tenant_path(tenant, "flows", "validate", "task")
        section_val = section.value if hasattr(section, 'value') else str(section)
        params = self._build_query_params(section=section_val)
        return self._json_request("POST", path, ValidateConstraintViolation, params=params, body=body)

    def validate_trigger(self, tenant: str, body: Any) -> ValidateConstraintViolation:
        path = self._tenant_path(tenant, "flows", "validate", "trigger")
        return self._json_request("POST", path, ValidateConstraintViolation, body=body)

    # ========================================================================
    # Expressions
    # ========================================================================

    def expressions(
        self, tenant: str, body: str, task_id: Optional[str] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "flows", "expressions")
        params = self._build_query_params(taskId=task_id)
        return self._raw_json_request("POST", path, params=params, body=body, content_type=self.YAML)

    # ========================================================================
    # Governance policies (EE)
    # ========================================================================

    def preview_policies(
        self, tenant: str, body: PolicyPreviewRequest
    ) -> PolicyPreviewResponse:
        """Preview the governance policy effects (mutations + violations) on a
        flow source. Backs POST /api/v1/{tenant}/flows/policies/preview.
        Requires the FEATURE_POLICIES licence feature."""
        path = self._tenant_path(tenant, "flows", "policies", "preview")
        return self._json_request("POST", path, PolicyPreviewResponse, body=body)

    # ========================================================================
    # CSV export (#421)
    # ========================================================================

    def export_flows_by_query_csv(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> str:
        """Export all flows matching the given filters as a CSV document.
        Backs GET /api/v1/{tenant}/flows/export/by-query/csv."""
        path = self._tenant_path(tenant, "flows", "export", "by-query", "csv")
        params: list = []
        self._append_filter_params(params, filters)
        return self._text_request("GET", path, params=params, accept=self.CSV)

    # ========================================================================
    # Source-search replace (#421)
    # ========================================================================

    def preview_replace_by_source_code(self, tenant: str, body: Dict[str, Any]) -> Dict[str, Any]:
        """Compute matched lines and their proposed replacement for every
        matching flow without persisting anything. Backs
        POST /api/v1/{tenant}/flows/source/replace/preview."""
        path = self._tenant_path(tenant, "flows", "source", "replace", "preview")
        return self._raw_json_request("POST", path, body=body)

    def apply_replace_by_source_code(self, tenant: str, body: Dict[str, Any]) -> Dict[str, Any]:
        """Replace every match in the given flows and persist the new revisions.
        Backs POST /api/v1/{tenant}/flows/source/replace/apply."""
        path = self._tenant_path(tenant, "flows", "source", "replace", "apply")
        return self._raw_json_request("POST", path, body=body)

    def replace_line_by_source_code(self, tenant: str, body: Dict[str, Any]) -> Dict[str, Any]:
        """Replace the matches on one line of one flow and persist the new
        revision. Backs POST /api/v1/{tenant}/flows/source/replace/line."""
        path = self._tenant_path(tenant, "flows", "source", "replace", "line")
        return self._raw_json_request("POST", path, body=body)

    # ========================================================================
    # Drift detection (EE) (#421)
    # ========================================================================

    def flow_hashes_by_ids(
        self, tenant: str, ids: List[IdWithNamespace],
    ) -> Dict[str, Any]:
        """Batch-compute source hashes for flows by id (drift detection).
        Backs POST /api/v1/{tenant}/flows/hashes/by-ids."""
        path = self._tenant_path(tenant, "flows", "hashes", "by-ids")
        body = [i.model_dump(by_alias=True, exclude_none=True) if hasattr(i, 'model_dump') else i for i in ids]
        return self._raw_json_request("POST", path, body=body)

    # ========================================================================
    # Promotions (EE) (#421)
    # ========================================================================

    def promote(
        self, namespace: str, id: str, tenant: str, body: Dict[str, Any],
    ) -> Dict[str, Any]:
        """Promote a flow to one or more SERVER-mode targets. Backs
        POST /api/v1/{tenant}/flows/{namespace}/{id}/promote."""
        path = self._tenant_path(tenant, "flows", namespace, id, "promote")
        return self._raw_json_request("POST", path, body=body)

    def promote_by_ids(self, tenant: str, body: Dict[str, Any]) -> Dict[str, Any]:
        """Promote flows by their ids to one or more SERVER-mode targets. Backs
        POST /api/v1/{tenant}/flows/promote/by-ids."""
        path = self._tenant_path(tenant, "flows", "promote", "by-ids")
        return self._raw_json_request("POST", path, body=body)

    def report_promote(
        self, namespace: str, id: str, tenant: str, body: Dict[str, Any],
    ) -> None:
        """Report a CLIENT-mode promote performed by the browser. Backs
        POST /api/v1/{tenant}/flows/{namespace}/{id}/promotions."""
        path = self._tenant_path(tenant, "flows", namespace, id, "promotions")
        self._void_request("POST", path, body=body)

    def list_promotions(
        self,
        namespace: str,
        id: str,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
    ) -> Dict[str, Any]:
        """List a flow's promotion history. Backs
        GET /api/v1/{tenant}/flows/{namespace}/{id}/promotions."""
        path = self._tenant_path(tenant, "flows", namespace, id, "promotions")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        return self._raw_json_request("GET", path, params=params)

    def promote_diff(
        self, namespace: str, id: str, audit_id: str, tenant: str,
    ) -> Dict[str, Any]:
        """Recompute the diff of a past promote from its audit record. Backs
        GET /api/v1/{tenant}/flows/{namespace}/{id}/promotions/{auditId}/diff."""
        path = self._tenant_path(tenant, "flows", namespace, id, "promotions", audit_id, "diff")
        return self._raw_json_request("GET", path)
