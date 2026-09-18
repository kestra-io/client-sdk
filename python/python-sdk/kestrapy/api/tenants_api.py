from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_tenant import ApiTenant
from kestrapy.models.paged_results_tenant import PagedResultsTenant
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.tenant import Tenant
from kestrapy.models.tenant_controller_apps_catalog_config_request import (
    TenantControllerAppsCatalogConfigRequest,
)
from kestrapy.models.tenant_controller_apps_catalog_config_response import (
    TenantControllerAppsCatalogConfigResponse,
)


class TenantsApi(BaseApi):

    # ---- CRUD (Instance-owner-only) ----

    def create_tenant(self, tenant: Tenant) -> Tenant:
        path = self._superadmin_path("tenants")
        return self._json_request("POST", path, Tenant, body=tenant)

    def tenant(self, id: str) -> Tenant:
        path = self._superadmin_path("tenants", id)
        return self._json_request("GET", path, Tenant)

    def update_tenant(self, id: str, tenant: Tenant) -> Tenant:
        path = self._superadmin_path("tenants", id)
        return self._json_request("PUT", path, Tenant, body=tenant)

    def delete_tenant(self, id: str) -> None:
        path = self._superadmin_path("tenants", id)
        self._void_request("DELETE", path)

    # ---- Search (Instance-owner-only) ----

    def search_tenants(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsTenant:
        path = self._superadmin_path("tenants", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsTenant, params=params)

    # ---- Apps catalog config (Superadmin-only) (#421) ----

    def apps_catalog_config(self, id: str) -> TenantControllerAppsCatalogConfigResponse:
        """Get the apps catalog config for the specified tenant.

        Backs ``GET /api/v1/tenants/{id}/apps-catalog``.
        """
        path = self._superadmin_path("tenants", id, "apps-catalog")
        return self._json_request("GET", path, TenantControllerAppsCatalogConfigResponse)

    def set_apps_catalog_config(
        self, id: str, body: TenantControllerAppsCatalogConfigRequest,
    ) -> TenantControllerAppsCatalogConfigResponse:
        """Set the apps catalog config for the specified tenant.

        Backs ``POST /api/v1/tenants/{id}/apps-catalog``.
        """
        path = self._superadmin_path("tenants", id, "apps-catalog")
        return self._json_request(
            "POST", path, TenantControllerAppsCatalogConfigResponse, body=body,
        )

    def delete_apps_catalog_logo(self, id: str) -> None:
        """Remove the apps catalog logo for the specified tenant.

        Backs ``DELETE /api/v1/tenants/{id}/apps-catalog/logo``.
        """
        path = self._superadmin_path("tenants", id, "apps-catalog", "logo")
        self._void_request("DELETE", path)

    def set_apps_catalog_logo(
        self, id: str, logo: Optional[bytes] = None,
    ) -> TenantControllerAppsCatalogConfigResponse:
        """Set the apps catalog logo (multipart upload) for the specified tenant.

        Backs ``POST /api/v1/tenants/{id}/apps-catalog/logo``.
        """
        path = self._superadmin_path("tenants", id, "apps-catalog", "logo")
        return self._multipart_upload(
            "POST", path, TenantControllerAppsCatalogConfigResponse,
            field_name="logo", file_content=logo, file_name="logo",
        )

    def set_logo(self, id: str, logo: Optional[bytes] = None) -> ApiTenant:
        """Set a tenant logo (multipart upload).

        Backs ``POST /api/v1/tenants/{id}/logo``.
        """
        path = self._superadmin_path("tenants", id, "logo")
        return self._multipart_upload(
            "POST", path, ApiTenant,
            field_name="logo", file_content=logo, file_name="logo",
        )
