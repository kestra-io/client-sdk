from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.asset_relation_graph import AssetRelationGraph
from kestrapy.models.assets_controller_api_asset import AssetsControllerApiAsset
from kestrapy.models.assets_controller_api_asset_lock import AssetsControllerApiAssetLock
from kestrapy.models.assets_controller_api_asset_usage import AssetsControllerApiAssetUsage
from kestrapy.models.assets_controller_api_parent_request import AssetsControllerApiParentRequest
from kestrapy.models.assets_controller_api_relation import AssetsControllerApiRelation
from kestrapy.models.assets_controller_api_relation_page import AssetsControllerApiRelationPage
from kestrapy.models.assets_controller_api_relation_request import AssetsControllerApiRelationRequest
from kestrapy.models.assets_controller_api_relation_summary import AssetsControllerApiRelationSummary
from kestrapy.models.assets_controller_asset_lock_request import AssetsControllerAssetLockRequest
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.paged_results_assets_controller_api_asset import PagedResultsAssetsControllerApiAsset
from kestrapy.models.paged_results_assets_controller_api_asset_usage import PagedResultsAssetsControllerApiAssetUsage
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.relation_direction import RelationDirection
from kestrapy.models.relation_kind import RelationKind


def _enum_value(value: Any) -> Any:
    return value.value if hasattr(value, 'value') else value


class AssetsApi(BaseApi):

    # ---- CRUD ----

    def create_asset(self, tenant: str, yaml_body: str) -> AssetsControllerApiAsset:
        path = self._tenant_path(tenant, "assets")
        return self._json_request("POST", path, AssetsControllerApiAsset, body=yaml_body, content_type=self.YAML)

    def asset(self, id: str, tenant: str, allow_deleted: Optional[bool] = None) -> AssetsControllerApiAsset:
        path = self._tenant_path(tenant, "assets", id)
        params = self._build_query_params(allowDeleted=allow_deleted)
        return self._json_request("GET", path, AssetsControllerApiAsset, params=params)

    def delete_asset(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "assets", id)
        self._void_request("DELETE", path)

    # ---- Lock ----

    def lock_asset(
        self,
        id: str,
        tenant: str,
        request: Optional[AssetsControllerAssetLockRequest] = None,
    ) -> AssetsControllerApiAssetLock:
        path = self._tenant_path(tenant, "assets", id, "lock")
        return self._json_request("POST", path, AssetsControllerApiAssetLock, body=request)

    def unlock_asset(self, id: str, tenant: str, execution_id: Optional[str] = None) -> None:
        path = self._tenant_path(tenant, "assets", id, "lock")
        params = self._build_query_params(executionId=execution_id)
        self._void_request("DELETE", path, params=params)

    # ---- Dependencies ----

    def asset_dependencies(
        self,
        id: str,
        tenant: str,
        kinds: Optional[List[RelationKind]] = None,
        expand_all: Optional[bool] = None,
        hub_cursor: Optional[str] = None,
    ) -> AssetRelationGraph:
        path = self._tenant_path(tenant, "assets", id, "dependencies")
        return self._json_request("GET", path, AssetRelationGraph, params=self._graph_params(kinds, expand_all, hub_cursor))

    def flow_asset_dependencies(
        self,
        namespace: str,
        id: str,
        tenant: str,
        kinds: Optional[List[RelationKind]] = None,
        expand_all: Optional[bool] = None,
        hub_cursor: Optional[str] = None,
    ) -> AssetRelationGraph:
        path = self._tenant_path(tenant, "flows", namespace, id, "asset-dependencies")
        return self._json_request("GET", path, AssetRelationGraph, params=self._graph_params(kinds, expand_all, hub_cursor))

    def _graph_params(
        self,
        kinds: Optional[List[RelationKind]],
        expand_all: Optional[bool],
        hub_cursor: Optional[str],
    ) -> list:
        params = list(self._build_query_params(expandAll=expand_all, hubCursor=hub_cursor).items())
        self._append_repeated_param(params, "kinds", [_enum_value(k) for k in kinds] if kinds else None)
        return params

    # ---- Relations ----

    def asset_relation_summary(
        self, id: str, tenant: str, limit: Optional[int] = None
    ) -> AssetsControllerApiRelationSummary:
        path = self._tenant_path(tenant, "assets", id, "relations", "summary")
        params = self._build_query_params(limit=limit)
        return self._json_request("GET", path, AssetsControllerApiRelationSummary, params=params)

    def asset_relations(
        self,
        id: str,
        tenant: str,
        kind: RelationKind,
        direction: RelationDirection,
        after: Optional[str] = None,
        size: Optional[int] = None,
    ) -> AssetsControllerApiRelationPage:
        path = self._tenant_path(tenant, "assets", id, "relations")
        params = self._build_query_params(
            kind=_enum_value(kind), direction=_enum_value(direction), after=after, size=size
        )
        return self._json_request("GET", path, AssetsControllerApiRelationPage, params=params)

    def create_asset_relation(
        self, id: str, tenant: str, request: AssetsControllerApiRelationRequest
    ) -> AssetsControllerApiRelation:
        path = self._tenant_path(tenant, "assets", id, "relations")
        return self._json_request("POST", path, AssetsControllerApiRelation, body=request)

    def delete_asset_relation(self, id: str, uid: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "assets", id, "relations", uid)
        self._void_request("DELETE", path)

    # ---- Parent ----

    def set_asset_parent(self, id: str, tenant: str, parent: AssetsControllerApiParentRequest) -> AssetsControllerApiAsset:
        path = self._tenant_path(tenant, "assets", id, "parent")
        return self._json_request("PUT", path, AssetsControllerApiAsset, body=parent)

    def clear_asset_parent(self, id: str, tenant: str) -> AssetsControllerApiAsset:
        path = self._tenant_path(tenant, "assets", id, "parent")
        return self._json_request("DELETE", path, AssetsControllerApiAsset)

    # ---- Bulk delete ----

    def delete_assets_by_ids(self, tenant: str, ids: List[str]) -> BulkResponse:
        path = self._tenant_path(tenant, "assets", "by-ids")
        return self._json_request("DELETE", path, BulkResponse, body=ids)

    def delete_assets_by_query(
        self,
        tenant: str,
        filters: List[QueryFilter],
        purge: Optional[bool] = None,
    ) -> BulkResponse:
        path = self._tenant_path(tenant, "assets", "by-query")
        params = list(self._build_query_params(purge=purge).items())
        self._append_filter_params(params, filters)
        return self._json_request("DELETE", path, BulkResponse, params=params)

    def delete_asset_usages_by_query(self, tenant: str, filters: List[QueryFilter]) -> BulkResponse:
        path = self._tenant_path(tenant, "assets", "usages", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._json_request("DELETE", path, BulkResponse, params=params)

    # ---- Search ----

    def search_assets(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsAssetsControllerApiAsset:
        path = self._tenant_path(tenant, "assets", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsAssetsControllerApiAsset, params=params)

    def search_asset_usages(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsAssetsControllerApiAssetUsage:
        path = self._tenant_path(tenant, "assets", "usages", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsAssetsControllerApiAssetUsage, params=params)
