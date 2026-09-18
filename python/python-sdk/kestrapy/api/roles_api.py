from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_autocomplete import ApiAutocomplete
from kestrapy.models.api_ids import ApiIds
from kestrapy.models.api_role_summary import ApiRoleSummary
from kestrapy.models.iam_role_controller_api_role_create_or_update_request import IAMRoleControllerApiRoleCreateOrUpdateRequest
from kestrapy.models.iam_role_controller_api_role_detail import IAMRoleControllerApiRoleDetail
from kestrapy.models.paged_results_api_role_summary import PagedResultsApiRoleSummary
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.role import Role


class RolesApi(BaseApi):

    # ── CRUD ────────────────────────────────────────────────────────

    def create_role(
        self,
        tenant: str,
        request: IAMRoleControllerApiRoleCreateOrUpdateRequest,
    ) -> IAMRoleControllerApiRoleDetail:
        path = self._tenant_path(tenant, "roles")
        return self._json_request("POST", path, IAMRoleControllerApiRoleDetail, body=request)

    def role(
        self,
        id: str,
        tenant: str,
    ) -> IAMRoleControllerApiRoleDetail:
        path = self._tenant_path(tenant, "roles", id)
        return self._json_request("GET", path, IAMRoleControllerApiRoleDetail)

    def update_role(
        self,
        id: str,
        tenant: str,
        request: IAMRoleControllerApiRoleCreateOrUpdateRequest,
    ) -> IAMRoleControllerApiRoleDetail:
        path = self._tenant_path(tenant, "roles", id)
        return self._json_request("PUT", path, IAMRoleControllerApiRoleDetail, body=request)

    def delete_role(
        self,
        id: str,
        tenant: str,
    ) -> None:
        path = self._tenant_path(tenant, "roles", id)
        self._void_request("DELETE", path)

    # ── Search & List ───────────────────────────────────────────────

    def search_roles(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsApiRoleSummary:
        path = self._tenant_path(tenant, "roles", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsApiRoleSummary, params=params)

    def autocomplete_roles(
        self,
        tenant: str,
        request: ApiAutocomplete,
    ) -> List[ApiRoleSummary]:
        path = self._tenant_path(tenant, "roles", "autocomplete")
        return self._json_list_request("POST", path, ApiRoleSummary, body=request)

    def list_roles_from_given_ids(
        self,
        tenant: str,
        ids: ApiIds,
    ) -> List[Role]:
        path = self._tenant_path(tenant, "roles", "ids")
        return self._json_list_request("POST", path, Role, body=ids)
