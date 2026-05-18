from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_patch_super_admin_request import ApiPatchSuperAdminRequest
from kestrapy.models.api_token_list import ApiTokenList
from kestrapy.models.create_api_token_request import CreateApiTokenRequest
from kestrapy.models.create_api_token_response import CreateApiTokenResponse
from kestrapy.models.iam_tenant_access_controller_api_user_tenant_access import IAMTenantAccessControllerApiUserTenantAccess
from kestrapy.models.iam_tenant_access_controller_user_api_autocomplete import IAMTenantAccessControllerUserApiAutocomplete
from kestrapy.models.iam_user_controller_api_create_or_update_user_request import IAMUserControllerApiCreateOrUpdateUserRequest
from kestrapy.models.iam_user_controller_api_patch_restricted_request import IAMUserControllerApiPatchRestrictedRequest
from kestrapy.models.iam_user_controller_api_patch_user_password_request import IAMUserControllerApiPatchUserPasswordRequest
from kestrapy.models.iam_user_controller_api_user import IAMUserControllerApiUser
from kestrapy.models.iam_user_group_controller_api_update_user_groups_request import IAMUserGroupControllerApiUpdateUserGroupsRequest
from kestrapy.models.me_controller_api_update_password_request import MeControllerApiUpdatePasswordRequest
from kestrapy.models.me_controller_api_user_details_request import MeControllerApiUserDetailsRequest
from kestrapy.models.paged_results_iam_user_controller_api_user_summary import PagedResultsIAMUserControllerApiUserSummary
from kestrapy.models.query_filter import QueryFilter


class UsersApi(BaseApi):

    # ---- CRUD (Superadmin-scoped) ----

    def create_user(self, request: IAMUserControllerApiCreateOrUpdateUserRequest) -> IAMUserControllerApiUser:
        path = self._superadmin_path("users")
        return self._json_request("POST", path, IAMUserControllerApiUser, body=request)

    def user(self, id: str) -> IAMUserControllerApiUser:
        path = self._superadmin_path("users", id)
        return self._json_request("GET", path, IAMUserControllerApiUser)

    def update_user(self, id: str, request: IAMUserControllerApiCreateOrUpdateUserRequest) -> IAMUserControllerApiUser:
        path = self._superadmin_path("users", id)
        return self._json_request("PUT", path, IAMUserControllerApiUser, body=request)

    def delete_user(self, id: str) -> None:
        path = self._superadmin_path("users", id)
        self._void_request("DELETE", path)

    # ---- Listing & search (Superadmin-scoped) ----

    def list_users(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsIAMUserControllerApiUserSummary:
        path = self._superadmin_path("users")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsIAMUserControllerApiUserSummary, params=params)

    # ---- Patch operations (Superadmin-scoped) ----

    def patch_user(self, id: str, request: MeControllerApiUserDetailsRequest) -> IAMUserControllerApiUser:
        path = self._superadmin_path("users", id)
        return self._json_request("PATCH", path, IAMUserControllerApiUser, body=request)

    def patch_user_demo(self, id: str, request: IAMUserControllerApiPatchRestrictedRequest) -> None:
        path = self._superadmin_path("users", id, "restricted")
        self._void_request("PATCH", path, body=request, content_type=self.JSON)

    def patch_user_password(self, id: str, request: IAMUserControllerApiPatchUserPasswordRequest) -> IAMUserControllerApiUser:
        path = self._superadmin_path("users", id, "password")
        return self._json_request("PATCH", path, IAMUserControllerApiUser, body=request)

    def patch_user_super_admin(self, id: str, request: ApiPatchSuperAdminRequest) -> None:
        path = self._superadmin_path("users", id, "superadmin")
        self._void_request("PATCH", path, body=request, content_type=self.JSON)

    # ---- Auth methods ----

    def delete_user_auth_method(self, id: str, auth: str) -> IAMUserControllerApiUser:
        path = self._superadmin_path("users", id, "auths", auth)
        return self._json_request("DELETE", path, IAMUserControllerApiUser)

    def delete_refresh_token(self, id: str) -> None:
        path = self._superadmin_path("users", id, "refresh-token")
        self._void_request("DELETE", path)

    # ---- API tokens (Superadmin-scoped) ----

    def create_api_tokens_for_user(self, id: str, request: CreateApiTokenRequest) -> CreateApiTokenResponse:
        path = self._superadmin_path("users", id, "api-tokens")
        return self._json_request("POST", path, CreateApiTokenResponse, body=request)

    def list_api_tokens_for_user(self, id: str) -> ApiTokenList:
        path = self._superadmin_path("users", id, "api-tokens")
        return self._json_request("GET", path, ApiTokenList)

    def delete_api_token_for_user(self, id: str, token_id: str) -> None:
        path = self._superadmin_path("users", id, "api-tokens", token_id)
        self._void_request("DELETE", path)

    # ---- Impersonation ----

    def impersonate(self, id: str) -> Any:
        path = self._superadmin_path("users", id, "impersonate")
        resp = self._request("POST", path)
        if resp.content and 'application/json' in resp.headers.get('content-type', ''):
            return resp.json()
        return {"status": resp.status_code}

    # ---- Current user (me) ----

    def update_current_user_password(self, request: MeControllerApiUpdatePasswordRequest) -> Any:
        path = self._superadmin_path("me", "password")
        return self._raw_json_request("PUT", path, body=request)

    # ---- Tenant-scoped operations ----

    def autocomplete_users(
        self,
        tenant: str,
        request: IAMTenantAccessControllerUserApiAutocomplete,
    ) -> List[IAMTenantAccessControllerApiUserTenantAccess]:
        path = self._tenant_path(tenant, "tenant-access", "autocomplete")
        return self._json_list_request("POST", path, IAMTenantAccessControllerApiUserTenantAccess, body=request)

    def update_user_groups(
        self,
        id: str,
        tenant: str,
        request: IAMUserGroupControllerApiUpdateUserGroupsRequest,
    ) -> None:
        path = self._tenant_path(tenant, "users", id, "groups")
        self._void_request("PUT", path, body=request, content_type=self.JSON)
