from typing import List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.kv_controller_api_delete_bulk_request import KVControllerApiDeleteBulkRequest
from kestrapy.models.kv_controller_api_delete_bulk_response import KVControllerApiDeleteBulkResponse
from kestrapy.models.kv_controller_kv_detail import KVControllerKvDetail
from kestrapy.models.kv_entry import KVEntry
from kestrapy.models.paged_results_kv_entry import PagedResultsKVEntry
from kestrapy.models.query_filter import QueryFilter


class KVApi(BaseApi):

    # ── Key-Value CRUD ──────────────────────────────────────────────

    def set_key_value(
        self,
        namespace: str,
        key: str,
        tenant: str,
        body: str,
    ) -> None:
        path = self._tenant_path(tenant, "namespaces", namespace, "kv", key)
        self._void_request("PUT", path, body=body, content_type=self.TEXT)

    def key_value(
        self,
        namespace: str,
        key: str,
        tenant: str,
    ) -> KVControllerKvDetail:
        path = self._tenant_path(tenant, "namespaces", namespace, "kv", key)
        return self._json_request("GET", path, KVControllerKvDetail)

    def delete_key_value(
        self,
        namespace: str,
        key: str,
        tenant: str,
    ) -> bool:
        path = self._tenant_path(tenant, "namespaces", namespace, "kv", key)
        return self._raw_json_request("DELETE", path)

    def delete_key_values(
        self,
        namespace: str,
        tenant: str,
        request: KVControllerApiDeleteBulkRequest,
    ) -> KVControllerApiDeleteBulkResponse:
        path = self._tenant_path(tenant, "namespaces", namespace, "kv")
        return self._json_request("DELETE", path, KVControllerApiDeleteBulkResponse, body=request)

    # ── List & Search ───────────────────────────────────────────────

    def list_all_keys(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsKVEntry:
        path = self._tenant_path(tenant, "kv")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsKVEntry, params=params)

    def list_keys_with_inheritance(
        self,
        namespace: str,
        tenant: str,
    ) -> List[KVEntry]:
        path = self._tenant_path(tenant, "namespaces", namespace, "kv", "inheritance")
        return self._json_list_request("GET", path, KVEntry)
