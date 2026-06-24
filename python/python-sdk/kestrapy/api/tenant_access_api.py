from typing import Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.iam_tenant_access_controller_api_create_tenant_access_request import IAMTenantAccessControllerApiCreateTenantAccessRequest
from kestrapy.models.paged_results_iam_tenant_access_controller_api_user_tenant_access import PagedResultsIAMTenantAccessControllerApiUserTenantAccess


class TenantAccessApi(BaseApi):

    def create_tenant_access(
        self,
        tenant: str,
        request: IAMTenantAccessControllerApiCreateTenantAccessRequest,
    ) -> None:
        path = self._tenant_path(tenant, "tenant-access")
        self._void_request("POST", path, body=request, content_type=self.JSON)

    def delete_tenant_access(self, user_id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "tenant-access", user_id)
        self._void_request("DELETE", path)

    def list_tenant_access(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
    ) -> PagedResultsIAMTenantAccessControllerApiUserTenantAccess:
        path = self._tenant_path(tenant, "tenant-access")
        params = list(self._build_query_params(page=page, size=size).items())
        return self._json_request("GET", path, PagedResultsIAMTenantAccessControllerApiUserTenantAccess, params=params)
