from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.binding_type import BindingType
from kestrapy.models.iam_binding_controller_api_binding_detail import IAMBindingControllerApiBindingDetail
from kestrapy.models.iam_binding_controller_api_create_binding_request import IAMBindingControllerApiCreateBindingRequest
from kestrapy.models.paged_results_iam_binding_controller_api_binding_detail import PagedResultsIAMBindingControllerApiBindingDetail
from kestrapy.models.query_filter import QueryFilter


class BindingsApi(BaseApi):

    # ---- CRUD ----

    def create_binding(
        self,
        tenant: str,
        request: IAMBindingControllerApiCreateBindingRequest,
    ) -> IAMBindingControllerApiBindingDetail:
        path = self._tenant_path(tenant, "bindings")
        return self._json_request("POST", path, IAMBindingControllerApiBindingDetail, body=request)

    def binding(self, id: str, tenant: str) -> IAMBindingControllerApiBindingDetail:
        path = self._tenant_path(tenant, "bindings", id)
        return self._json_request("GET", path, IAMBindingControllerApiBindingDetail)

    def delete_binding(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "bindings", id)
        self._void_request("DELETE", path)

    # ---- Search ----

    def search_bindings(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        binding_type: Optional[BindingType] = None,
        external_id: Optional[str] = None,
        namespace: Optional[str] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsIAMBindingControllerApiBindingDetail:
        path = self._tenant_path(tenant, "bindings", "search")
        type_val = binding_type.value if binding_type is not None and hasattr(binding_type, 'value') else binding_type
        params = list(self._build_query_params(
            page=page, size=size, type=type_val, id=external_id, namespace=namespace,
        ).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsIAMBindingControllerApiBindingDetail, params=params)
