from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.auth_controller_invitation_user_request import AuthControllerInvitationUserRequest
from kestrapy.models.iam_invitation_controller_api_invitation_create_request import IAMInvitationControllerApiInvitationCreateRequest
from kestrapy.models.iam_invitation_controller_api_invitation_detail import IAMInvitationControllerApiInvitationDetail
from kestrapy.models.invitation import Invitation
from kestrapy.models.invitation_invitation_status import InvitationInvitationStatus
from kestrapy.models.paged_results_iam_invitation_controller_api_invitation_detail import PagedResultsIAMInvitationControllerApiInvitationDetail
from kestrapy.models.query_filter import QueryFilter


class InvitationsApi(BaseApi):

    # ---- Tenant-scoped ----

    def create_invitation(
        self,
        tenant: str,
        request: IAMInvitationControllerApiInvitationCreateRequest,
    ) -> None:
        path = self._tenant_path(tenant, "invitations")
        self._void_request("POST", path, body=request, content_type=self.JSON)

    def list_invitations_by_email(
        self, email: str, tenant: str,
    ) -> List[IAMInvitationControllerApiInvitationDetail]:
        path = self._tenant_path(tenant, "invitations", "email", email)
        return self._json_list_request("GET", path, IAMInvitationControllerApiInvitationDetail)

    def search_invitations(
        self,
        tenant: str,
        email: Optional[str] = None,
        status: Optional[InvitationInvitationStatus] = None,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsIAMInvitationControllerApiInvitationDetail:
        path = self._tenant_path(tenant, "invitations", "search")
        status_val = status.value if status is not None and hasattr(status, 'value') else status
        params = list(self._build_query_params(
            email=email, status=status_val, page=page, size=size,
        ).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsIAMInvitationControllerApiInvitationDetail, params=params)

    def invitation(self, id: str, tenant: str) -> IAMInvitationControllerApiInvitationDetail:
        path = self._tenant_path(tenant, "invitations", id)
        return self._json_request("GET", path, IAMInvitationControllerApiInvitationDetail)

    def delete_invitation(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "invitations", id)
        self._void_request("DELETE", path)

    # ---- Current user (cross-tenant) ----

    def find_all_invitations_for_current_user(self) -> List[Invitation]:
        path = self._superadmin_path("me", "invitations")
        return self._json_list_request("GET", path, Invitation)

    # ---- Public auth flow (no tenant in path) ----

    def accept_invitation(self, invitation_id: str) -> Any:
        path = self._superadmin_path("invitation", "accept", invitation_id)
        return self._raw_json_request("POST", path)

    def create_from_invitation(
        self, invitation_id: str, request: AuthControllerInvitationUserRequest,
    ) -> Any:
        path = self._superadmin_path("invitation", "create", invitation_id)
        return self._raw_json_request("POST", path, body=request, content_type=self.JSON)
