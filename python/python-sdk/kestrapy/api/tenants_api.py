from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.paged_results_tenant import PagedResultsTenant
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.tenant import Tenant


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
