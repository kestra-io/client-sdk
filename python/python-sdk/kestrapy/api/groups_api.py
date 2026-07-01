from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_autocomplete import ApiAutocomplete
from kestrapy.models.api_group_summary import ApiGroupSummary
from kestrapy.models.api_ids import ApiIds
from kestrapy.models.group_identifier_membership import GroupIdentifierMembership
from kestrapy.models.iam_group_controller_api_create_group_request import IAMGroupControllerApiCreateGroupRequest
from kestrapy.models.iam_group_controller_api_group_detail import IAMGroupControllerApiGroupDetail
from kestrapy.models.iam_group_controller_api_group_member import IAMGroupControllerApiGroupMember
from kestrapy.models.iam_group_controller_api_update_group_request import IAMGroupControllerApiUpdateGroupRequest
from kestrapy.models.paged_results_api_group_summary import PagedResultsApiGroupSummary
from kestrapy.models.paged_results_iam_group_controller_api_group_member import PagedResultsIAMGroupControllerApiGroupMember
from kestrapy.models.query_filter import QueryFilter


class GroupsApi(BaseApi):

    # ── CRUD ────────────────────────────────────────────────────────

    def create_group(
        self,
        tenant: str,
        request: IAMGroupControllerApiCreateGroupRequest,
    ) -> IAMGroupControllerApiGroupDetail:
        path = self._tenant_path(tenant, "groups")
        return self._json_request("POST", path, IAMGroupControllerApiGroupDetail, body=request)

    def group(
        self,
        id: str,
        tenant: str,
    ) -> IAMGroupControllerApiGroupDetail:
        path = self._tenant_path(tenant, "groups", id)
        return self._json_request("GET", path, IAMGroupControllerApiGroupDetail)

    def update_group(
        self,
        id: str,
        tenant: str,
        request: IAMGroupControllerApiUpdateGroupRequest,
    ) -> IAMGroupControllerApiGroupDetail:
        path = self._tenant_path(tenant, "groups", id)
        return self._json_request("PUT", path, IAMGroupControllerApiGroupDetail, body=request)

    def delete_group(
        self,
        id: str,
        tenant: str,
    ) -> None:
        path = self._tenant_path(tenant, "groups", id)
        self._void_request("DELETE", path)

    # ── Members ─────────────────────────────────────────────────────

    def add_user_to_group(
        self,
        id: str,
        user_id: str,
        tenant: str,
    ) -> IAMGroupControllerApiGroupMember:
        path = self._tenant_path(tenant, "groups", id, "members", user_id)
        return self._json_request("PUT", path, IAMGroupControllerApiGroupMember)

    def delete_user_from_group(
        self,
        id: str,
        user_id: str,
        tenant: str,
    ) -> IAMGroupControllerApiGroupMember:
        path = self._tenant_path(tenant, "groups", id, "members", user_id)
        return self._json_request("DELETE", path, IAMGroupControllerApiGroupMember)

    def set_user_membership_for_group(
        self,
        id: str,
        user_id: str,
        membership: GroupIdentifierMembership,
        tenant: str,
    ) -> IAMGroupControllerApiGroupMember:
        path = self._tenant_path(tenant, "groups", id, "members", "membership", user_id)
        membership_val = membership.value if hasattr(membership, 'value') else membership
        params = self._build_query_params(membership=membership_val)
        return self._json_request("PUT", path, IAMGroupControllerApiGroupMember, params=params)

    def search_group_members(
        self,
        id: str,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsIAMGroupControllerApiGroupMember:
        path = self._tenant_path(tenant, "groups", id, "members")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsIAMGroupControllerApiGroupMember, params=params)

    # ── Search & List ───────────────────────────────────────────────

    def search_groups(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        q: Optional[str] = None,
    ) -> PagedResultsApiGroupSummary:
        path = self._tenant_path(tenant, "groups", "search")
        params = list(self._build_query_params(page=page, size=size, q=q).items())
        self._append_repeated_param(params, "sort", sort)
        return self._json_request("GET", path, PagedResultsApiGroupSummary, params=params)

    def autocomplete_groups(
        self,
        tenant: str,
        request: ApiAutocomplete,
        filters: Optional[List[QueryFilter]] = None,
    ) -> List[ApiGroupSummary]:
        path = self._tenant_path(tenant, "groups", "autocomplete")
        params = []
        self._append_filter_params(params, filters)
        return self._json_list_request("POST", path, ApiGroupSummary, body=request, params=params if params else None)

    def list_group_ids(
        self,
        tenant: str,
        ids: ApiIds,
    ) -> List[ApiGroupSummary]:
        path = self._tenant_path(tenant, "groups", "ids")
        return self._json_list_request("POST", path, ApiGroupSummary, body=ids)
