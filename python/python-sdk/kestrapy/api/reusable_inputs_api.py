from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.paged_results_reusable_inputs_with_source import PagedResultsReusableInputsWithSource
from kestrapy.models.reusable_inputs_with_source import ReusableInputsWithSource


class ReusableInputsApi(BaseApi):
    """Namespace-scoped reusable inputs blocks: named sets of flow input
    definitions that flows reference via a REUSABLE_INPUTS input."""

    def list_reusable_inputs(
        self,
        namespace: str,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
    ) -> PagedResultsReusableInputsWithSource:
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs")
        params = self._build_query_params(page=page, size=size)
        return self._json_request("GET", path, PagedResultsReusableInputsWithSource, params=params)

    def reusable_inputs(
        self,
        namespace: str,
        id: str,
        tenant: str,
        revision: Optional[int] = None,
    ) -> ReusableInputsWithSource:
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs", id)
        params = self._build_query_params(revision=revision)
        return self._json_request("GET", path, ReusableInputsWithSource, params=params)

    def list_reusable_inputs_revisions(self, namespace: str, id: str, tenant: str) -> List[ReusableInputsWithSource]:
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs", id, "revisions")
        return self._json_list_request("GET", path, ReusableInputsWithSource)

    def create_or_update_reusable_inputs(
        self,
        namespace: str,
        id: str,
        tenant: str,
        body: str,
        fail_if_exists: Optional[bool] = None,
    ) -> ReusableInputsWithSource:
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs", id)
        params = self._build_query_params(failIfExists=fail_if_exists)
        return self._json_request("PUT", path, ReusableInputsWithSource, params=params, body=body, content_type=self.YAML)

    def delete_reusable_inputs(self, namespace: str, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs", id)
        self._void_request("DELETE", path)

    def list_reusable_inputs_namespaces(self, tenant: str) -> List[str]:
        path = self._tenant_path(tenant, "reusable-inputs", "namespaces")
        return self._json_list_request("GET", path, str)
