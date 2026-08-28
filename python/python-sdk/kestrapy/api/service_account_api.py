from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_patch_super_admin_request import ApiPatchSuperAdminRequest
from kestrapy.models.create_api_token_request import CreateApiTokenRequest
from kestrapy.models.iam_service_account_controller_api_create_service_account_request import IAMServiceAccountControllerApiCreateServiceAccountRequest
from kestrapy.models.iam_service_account_controller_api_patch_service_account_request import IAMServiceAccountControllerApiPatchServiceAccountRequest
from kestrapy.models.iam_service_account_controller_api_service_account_detail import IAMServiceAccountControllerApiServiceAccountDetail
from kestrapy.models.iam_service_account_controller_api_service_account_request import IAMServiceAccountControllerApiServiceAccountRequest
from kestrapy.models.iam_service_account_controller_api_service_account_response import IAMServiceAccountControllerApiServiceAccountResponse
from kestrapy.models.paged_results_iam_service_account_controller_api_service_account_detail import PagedResultsIAMServiceAccountControllerApiServiceAccountDetail
from kestrapy.models.query_filter import QueryFilter


class ServiceAccountApi(BaseApi):

    # ---- CRUD (Superadmin-scoped) ----

    def create_service_account(self, request: IAMServiceAccountControllerApiCreateServiceAccountRequest) -> IAMServiceAccountControllerApiServiceAccountDetail:
        path = self._superadmin_path("service-accounts")
        return self._json_request("POST", path, IAMServiceAccountControllerApiServiceAccountDetail, body=request)

    def service_account(self, id: str) -> IAMServiceAccountControllerApiServiceAccountDetail:
        path = self._superadmin_path("service-accounts", id)
        return self._json_request("GET", path, IAMServiceAccountControllerApiServiceAccountDetail)

    def patch_service_account_details(self, id: str, request: IAMServiceAccountControllerApiPatchServiceAccountRequest) -> IAMServiceAccountControllerApiServiceAccountDetail:
        path = self._superadmin_path("service-accounts", id)
        return self._json_request("PATCH", path, IAMServiceAccountControllerApiServiceAccountDetail, body=request)

    def delete_service_account(self, id: str) -> None:
        path = self._superadmin_path("service-accounts", id)
        self._void_request("DELETE", path)

    # ---- Superadmin patch ----

    def patch_service_account_super_admin(self, id: str, request: ApiPatchSuperAdminRequest) -> None:
        path = self._superadmin_path("service-accounts", id, "superadmin")
        self._void_request("PATCH", path, body=request, content_type=self.JSON)

    # ---- Listing (Superadmin-scoped) ----

    def list_service_accounts(
        self,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsIAMServiceAccountControllerApiServiceAccountDetail:
        path = self._superadmin_path("service-accounts")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsIAMServiceAccountControllerApiServiceAccountDetail, params=params)

    # ---- API tokens (Superadmin-scoped) ----

    def create_api_tokens_for_service_account(self, id: str, request: CreateApiTokenRequest) -> Any:
        path = self._superadmin_path("service-accounts", id, "api-tokens")
        return self._raw_json_request("POST", path, body=request)

    def list_api_tokens_for_service_account(self, id: str) -> Any:
        path = self._superadmin_path("service-accounts", id, "api-tokens")
        return self._raw_json_request("GET", path)

    def delete_api_token_for_service_account(self, id: str, token_id: str) -> None:
        path = self._superadmin_path("service-accounts", id, "api-tokens", token_id)
        self._void_request("DELETE", path)

    # ---- Tenant-scoped operations ----

    def create_service_account_for_tenant(self, tenant: str, request: IAMServiceAccountControllerApiServiceAccountRequest) -> IAMServiceAccountControllerApiServiceAccountResponse:
        path = self._tenant_path(tenant, "service-accounts")
        return self._json_request("POST", path, IAMServiceAccountControllerApiServiceAccountResponse, body=request)

    def service_account_for_tenant(self, id: str, tenant: str) -> IAMServiceAccountControllerApiServiceAccountResponse:
        path = self._tenant_path(tenant, "service-accounts", id)
        return self._json_request("GET", path, IAMServiceAccountControllerApiServiceAccountResponse)

    def update_service_account(self, id: str, tenant: str, request: IAMServiceAccountControllerApiServiceAccountRequest) -> IAMServiceAccountControllerApiServiceAccountResponse:
        path = self._tenant_path(tenant, "service-accounts", id)
        return self._json_request("PUT", path, IAMServiceAccountControllerApiServiceAccountResponse, body=request)

    def delete_service_account_for_tenant(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "service-accounts", id)
        self._void_request("DELETE", path)

    # ---- API tokens (Tenant-scoped) ----

    def create_api_tokens_for_service_account_with_tenant(self, id: str, tenant: str, request: CreateApiTokenRequest) -> Any:
        path = self._tenant_path(tenant, "service-accounts", id, "api-tokens")
        return self._raw_json_request("POST", path, body=request)

    def list_api_tokens_for_service_account_with_tenant(self, id: str, tenant: str) -> Any:
        path = self._tenant_path(tenant, "service-accounts", id, "api-tokens")
        return self._raw_json_request("GET", path)

    def delete_api_token_for_service_account_with_tenant(self, id: str, token_id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "service-accounts", id, "api-tokens", token_id)
        self._void_request("DELETE", path)
