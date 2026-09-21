from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.iam_tenant_access_controller_api_create_tenant_access_request import (
    IAMTenantAccessControllerApiCreateTenantAccessRequest,
)
from kestrapy.models.iam_tenant_access_controller_api_tenant_access import (
    IAMTenantAccessControllerApiTenantAccess,
)
from kestrapy.models.iam_tenant_access_controller_api_user_tenant_access import (
    IAMTenantAccessControllerApiUserTenantAccess,
)
from kestrapy.models.paged_results_iam_tenant_access_controller_api_user_tenant_access import (
    PagedResultsIAMTenantAccessControllerApiUserTenantAccess,
)
from kestrapy.models.query_filter import QueryFilter


class TenantAccessApi(BaseApi):
    """Tenant access (`/api/v1/{tenant}/tenant-access`).

    Since Kestra 2.0 tenant access is a prerequisite rather than a side effect:
    a user must be granted access before it can be added to a group.
    """

    def list_tenant_access(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsIAMTenantAccessControllerApiUserTenantAccess:
        """The users that can reach the tenant. GET /api/v1/{tenant}/tenant-access."""
        path = self._tenant_path(tenant, "tenant-access")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request(
            "GET", path, PagedResultsIAMTenantAccessControllerApiUserTenantAccess, params=params
        )

    def tenant_access(
        self, user_id: str, tenant: str
    ) -> IAMTenantAccessControllerApiTenantAccess:
        """One user's access to the tenant.
        GET /api/v1/{tenant}/tenant-access/{userId}."""
        path = self._tenant_path(tenant, "tenant-access", user_id)
        return self._json_request(
            "GET", path, IAMTenantAccessControllerApiTenantAccess
        )

    def create_tenant_access(self, user_id: str, tenant: str) -> None:
        """Grant access by user id. The server answers 201 with no body.
        PUT /api/v1/{tenant}/tenant-access/{userId}."""
        path = self._tenant_path(tenant, "tenant-access", user_id)
        self._void_request("PUT", path)

    def create_tenant_access_by_email(
        self, tenant: str, request: IAMTenantAccessControllerApiCreateTenantAccessRequest
    ) -> None:
        """Grant access by email. The server answers 204 with no body, and 409
        when the user already has access. POST /api/v1/{tenant}/tenant-access."""
        path = self._tenant_path(tenant, "tenant-access")
        self._void_request("POST", path, body=request)

    def delete_tenant_access(self, user_id: str, tenant: str) -> None:
        """Revoke a user's access to the tenant.
        DELETE /api/v1/{tenant}/tenant-access/{userId}."""
        path = self._tenant_path(tenant, "tenant-access", user_id)
        self._void_request("DELETE", path)

    def autocomplete_tenant_access(
        self, tenant: str, request: dict
    ) -> List[IAMTenantAccessControllerApiUserTenantAccess]:
        """Resolve users reachable from the tenant.
        POST /api/v1/{tenant}/tenant-access/autocomplete."""
        path = self._tenant_path(tenant, "tenant-access", "autocomplete")
        return self._json_list_request(
            "POST", path, IAMTenantAccessControllerApiUserTenantAccess, body=request
        )
