from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.api_create_promotion_target_request import ApiCreatePromotionTargetRequest
from kestrapy.models.api_flow_hash_batch_request import ApiFlowHashBatchRequest
from kestrapy.models.api_flow_hashes_response import ApiFlowHashesResponse
from kestrapy.models.api_promotion_target_response import ApiPromotionTargetResponse
from kestrapy.models.api_test_connection_response import ApiTestConnectionResponse
from kestrapy.models.api_update_promotion_target_request import ApiUpdatePromotionTargetRequest
from kestrapy.models.paged_results_api_promotion_target_response import (
    PagedResultsApiPromotionTargetResponse,
)
from kestrapy.models.query_filter import QueryFilter


class PromotionTargetsApi(BaseApi):
    """Promotion targets (`/api/v1/{tenant}/promotion-targets`).

    A promotion target is a remote Kestra instance/tenant that flows can be
    promoted to. The controller is gated by the ``PROMOTION_TARGET`` resource
    and the ``FEATURE_PROMOTE`` licence feature, so every route answers 403 when
    the feature is disabled.
    """

    def list_promotion_targets(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsApiPromotionTargetResponse:
        path = self._tenant_path(tenant, "promotion-targets")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsApiPromotionTargetResponse, params=params)

    def promotion_target(self, id: str, tenant: str) -> ApiPromotionTargetResponse:
        path = self._tenant_path(tenant, "promotion-targets", id)
        return self._json_request("GET", path, ApiPromotionTargetResponse)

    def create_promotion_target(
        self, tenant: str, body: ApiCreatePromotionTargetRequest
    ) -> ApiPromotionTargetResponse:
        path = self._tenant_path(tenant, "promotion-targets")
        return self._json_request("POST", path, ApiPromotionTargetResponse, body=body)

    def update_promotion_target(
        self, id: str, tenant: str, body: ApiUpdatePromotionTargetRequest
    ) -> ApiPromotionTargetResponse:
        path = self._tenant_path(tenant, "promotion-targets", id)
        return self._json_request("PUT", path, ApiPromotionTargetResponse, body=body)

    def delete_promotion_target(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "promotion-targets", id)
        self._void_request("DELETE", path)

    def test_promotion_target(
        self,
        tenant: str,
        body: ApiCreatePromotionTargetRequest,
        id: Optional[str] = None,
    ) -> ApiTestConnectionResponse:
        """Test an unsaved promotion-target definition. ``id`` is sent as a query
        param (not a path segment) to reuse a stored token."""
        path = self._tenant_path(tenant, "promotion-targets", "test")
        params = self._build_query_params(id=id)
        return self._json_request("POST", path, ApiTestConnectionResponse, body=body, params=params)

    def test_saved_promotion_target(self, id: str, tenant: str) -> ApiTestConnectionResponse:
        path = self._tenant_path(tenant, "promotion-targets", id, "test")
        return self._json_request("POST", path, ApiTestConnectionResponse)

    def promotion_target_flow_source(
        self,
        id: str,
        tenant: str,
        namespace: str,
        flow_id: str,
        revision: Optional[int] = None,
    ) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "promotion-targets", id, "flow-source")
        params = self._build_query_params(namespace=namespace, flowId=flow_id, revision=revision)
        return self._raw_json_request("GET", path, params=params)

    def promotion_target_flow_hashes(
        self, id: str, tenant: str, body: ApiFlowHashBatchRequest
    ) -> ApiFlowHashesResponse:
        path = self._tenant_path(tenant, "promotion-targets", id, "flow-hashes")
        return self._json_request("POST", path, ApiFlowHashesResponse, body=body)
