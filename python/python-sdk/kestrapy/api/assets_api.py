from typing import Any, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.assets_controller_api_asset import AssetsControllerApiAsset
from kestrapy.models.assets_controller_api_asset_lineage_event import AssetsControllerApiAssetLineageEvent
from kestrapy.models.assets_controller_api_asset_usage import AssetsControllerApiAssetUsage
from kestrapy.models.asset_topology_graph import AssetTopologyGraph
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.paged_results_assets_controller_api_asset import PagedResultsAssetsControllerApiAsset
from kestrapy.models.paged_results_assets_controller_api_asset_lineage_event import PagedResultsAssetsControllerApiAssetLineageEvent
from kestrapy.models.paged_results_assets_controller_api_asset_usage import PagedResultsAssetsControllerApiAssetUsage
from kestrapy.models.query_filter import QueryFilter


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

    # ---- Dependencies ----

    def asset_dependencies(
        self,
        id: str,
        tenant: str,
        destination_only: Optional[bool] = None,
        expand_all: Optional[bool] = None,
    ) -> AssetTopologyGraph:
        path = self._tenant_path(tenant, "assets", id, "dependencies")
        params = self._build_query_params(destinationOnly=destination_only, expandAll=expand_all)
        return self._json_request("GET", path, AssetTopologyGraph, params=params)

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

    def delete_asset_lineage_events_by_query(self, tenant: str, filters: List[QueryFilter]) -> BulkResponse:
        path = self._tenant_path(tenant, "assets", "lineage-events", "by-query")
        params: list = []
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

    def search_asset_lineage_events(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsAssetsControllerApiAssetLineageEvent:
        path = self._tenant_path(tenant, "assets", "lineage-events", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsAssetsControllerApiAssetLineageEvent, params=params)

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
