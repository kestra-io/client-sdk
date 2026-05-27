from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.blueprint_controller_api_blueprint_item_with_source import BlueprintControllerApiBlueprintItemWithSource
from kestrapy.models.blueprint_controller_api_flow_blueprint import BlueprintControllerApiFlowBlueprint
from kestrapy.models.blueprint_controller_flow_blueprint_create_or_update import BlueprintControllerFlowBlueprintCreateOrUpdate
from kestrapy.models.blueprint_controller_kind import BlueprintControllerKind
from kestrapy.models.blueprint_controller_use_blueprint_template_request import BlueprintControllerUseBlueprintTemplateRequest
from kestrapy.models.blueprint_controller_use_blueprint_template_response import BlueprintControllerUseBlueprintTemplateResponse
from kestrapy.models.blueprint_with_flow_entity import BlueprintWithFlowEntity
from kestrapy.models.paged_results_blueprint_controller_api_blueprint_item import PagedResultsBlueprintControllerApiBlueprintItem
from kestrapy.models.paged_results_blueprint import PagedResultsBlueprint


class BlueprintsApi(BaseApi):

    # ---- Community Blueprints ----

    def blueprint(self, id: str, kind: BlueprintControllerKind, tenant: str) -> BlueprintControllerApiBlueprintItemWithSource:
        path = self._tenant_path(tenant, "blueprints", "community", kind.value, id)
        return self._json_request("GET", path, BlueprintControllerApiBlueprintItemWithSource)

    def blueprint_graph(self, id: str, kind: BlueprintControllerKind, tenant: str) -> Dict[str, Any]:
        path = self._tenant_path(tenant, "blueprints", "community", kind.value, id, "graph")
        return self._raw_json_request("GET", path)

    def blueprint_source(self, id: str, kind: BlueprintControllerKind, tenant: str) -> str:
        path = self._tenant_path(tenant, "blueprints", "community", kind.value, id, "source")
        return self._text_request("GET", path, accept=self.YAML)

    def search_blueprints(
        self,
        kind: BlueprintControllerKind,
        tenant: str,
        q: Optional[str] = None,
        sort: Optional[str] = None,
        tags: Optional[List[str]] = None,
        page: Optional[int] = None,
        size: Optional[int] = None,
    ) -> PagedResultsBlueprintControllerApiBlueprintItem:
        path = self._tenant_path(tenant, "blueprints", "community", kind.value)
        params = list(self._build_query_params(q=q, sort=sort, page=page, size=size).items())
        self._append_repeated_param(params, "tags", tags)
        return self._json_request("GET", path, PagedResultsBlueprintControllerApiBlueprintItem, params=params)

    # ---- Flow Blueprints ----

    def create_flow_blueprint(self, tenant: str, request: BlueprintControllerFlowBlueprintCreateOrUpdate) -> BlueprintControllerApiFlowBlueprint:
        path = self._tenant_path(tenant, "blueprints", "flows")
        return self._json_request("POST", path, BlueprintControllerApiFlowBlueprint, body=request)

    def flow_blueprint_by_id(self, id: str, tenant: str) -> BlueprintControllerApiFlowBlueprint:
        path = self._tenant_path(tenant, "blueprints", "flows", id)
        return self._json_request("GET", path, BlueprintControllerApiFlowBlueprint)

    def update_flow_blueprint(self, id: str, tenant: str, request: BlueprintControllerFlowBlueprintCreateOrUpdate) -> BlueprintControllerApiFlowBlueprint:
        path = self._tenant_path(tenant, "blueprints", "flows", id)
        return self._json_request("PUT", path, BlueprintControllerApiFlowBlueprint, body=request)

    def delete_flow_blueprints(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "blueprints", "flows", id)
        self._void_request("DELETE", path)

    def use_blueprint_template(self, id: str, tenant: str, request: BlueprintControllerUseBlueprintTemplateRequest) -> BlueprintControllerUseBlueprintTemplateResponse:
        path = self._tenant_path(tenant, "blueprints", "flows", id, "use-template")
        return self._json_request("POST", path, BlueprintControllerUseBlueprintTemplateResponse, body=request)

    def flow_blueprint(self, id: str, tenant: str) -> BlueprintControllerApiFlowBlueprint:
        path = self._tenant_path(tenant, "blueprints", "flow", id)
        return self._json_request("GET", path, BlueprintControllerApiFlowBlueprint)

    # ---- Custom/Internal Blueprints (deprecated) ----

    def create_internal_blueprints(self, tenant: str, request: BlueprintControllerApiBlueprintItemWithSource) -> BlueprintControllerApiBlueprintItemWithSource:
        path = self._tenant_path(tenant, "blueprints", "custom")
        return self._json_request("POST", path, BlueprintControllerApiBlueprintItemWithSource, body=request)

    def internal_blueprint(self, id: str, tenant: str) -> BlueprintControllerApiFlowBlueprint:
        path = self._tenant_path(tenant, "blueprints", "custom", id)
        return self._json_request("GET", path, BlueprintControllerApiFlowBlueprint)

    def internal_blueprint_flow(self, id: str, tenant: str) -> str:
        path = self._tenant_path(tenant, "blueprints", "custom", id, "source")
        return self._text_request("GET", path, accept=self.YAML)

    def update_internal_blueprints(self, id: str, tenant: str, request: BlueprintControllerApiBlueprintItemWithSource) -> BlueprintWithFlowEntity:
        path = self._tenant_path(tenant, "blueprints", "custom", id)
        return self._json_request("PUT", path, BlueprintWithFlowEntity, body=request)

    def delete_internal_blueprints(self, id: str, tenant: str) -> None:
        path = self._tenant_path(tenant, "blueprints", "custom", id)
        self._void_request("DELETE", path)

    def search_internal_blueprints(
        self,
        tenant: str,
        q: Optional[str] = None,
        sort: Optional[str] = None,
        tags: Optional[List[str]] = None,
        page: Optional[int] = None,
        size: Optional[int] = None,
        source: Optional[bool] = None,
    ) -> PagedResultsBlueprint:
        path = self._tenant_path(tenant, "blueprints", "custom")
        params = list(self._build_query_params(q=q, sort=sort, page=page, size=size, source=source).items())
        self._append_repeated_param(params, "tags", tags)
        return self._json_request("GET", path, PagedResultsBlueprint, params=params)
