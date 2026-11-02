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
        allow_draft: Optional[bool] = None,
    ) -> PagedResultsReusableInputsWithSource:
        """Lists the blocks visible from a namespace, including those inherited from parent namespaces. Without
        ``allow_draft``, only the blocks an execution can use are listed, each as the revision it would run."""
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs")
        params = self._build_query_params(page=page, size=size, allowDraft=allow_draft)
        return self._json_request("GET", path, PagedResultsReusableInputsWithSource, params=params)

    def reusable_inputs(
        self,
        namespace: str,
        id: str,
        tenant: str,
        revision: Optional[int] = None,
        allow_draft: Optional[bool] = None,
    ) -> ReusableInputsWithSource:
        """Retrieves a block, resolving namespace inheritance. Without ``allow_draft``, the revision an execution
        would use is returned: the latest that isn't a draft, unless ``revision`` is set; a block with only
        drafts fails with a 422."""
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs", id)
        params = self._build_query_params(revision=revision, allowDraft=allow_draft)
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
        draft: Optional[bool] = None,
    ) -> ReusableInputsWithSource:
        """Creates or updates a block from its YAML source. With ``draft``, the revision is saved as a draft,
        which executions skip and which may be invalid."""
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs", id)
        params = self._build_query_params(failIfExists=fail_if_exists, draft=draft)
        return self._json_request("PUT", path, ReusableInputsWithSource, params=params, body=body, content_type=self.YAML)

    def delete_reusable_inputs(self, namespace: str, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "namespaces", namespace, "reusable-inputs", id)
        self._void_request("DELETE", path)

    def list_reusable_inputs_namespaces(self, tenant: str) -> List[str]:
        path = self._tenant_path(tenant, "reusable-inputs", "namespaces")
        return self._json_list_request("GET", path, str)
