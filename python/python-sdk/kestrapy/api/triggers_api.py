from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.delete_triggers_by_query_request import DeleteTriggersByQueryRequest
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.trigger_controller_set_disabled_request import TriggerControllerSetDisabledRequest


class TriggersApi(BaseApi):

    # ---- Search ----

    def search_triggers(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "triggers", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._raw_json_request("GET", path, params=params)

    def search_triggers_for_flow(
        self,
        tenant: str,
        namespace: str,
        flow_id: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        q: Optional[str] = None,
        sort: Optional[List[str]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "triggers", namespace, flow_id)
        params = list(self._build_query_params(page=page, size=size, q=q).items())
        self._append_repeated_param(params, "sort", sort)
        return self._raw_json_request("GET", path, params=params)

    def export_triggers(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
    ) -> str:
        path = self._tenant_path(tenant, "triggers", "export", "by-query", "csv")
        params: list = []
        self._append_filter_params(params, filters)
        return self._text_request("GET", path, params=params, accept=self.CSV)

    # ---- Enable / Disable ----

    def disabled_triggers_by_ids(self, tenant: str, request: TriggerControllerSetDisabledRequest) -> dict:
        path = self._tenant_path(tenant, "triggers", "set-disabled", "by-triggers")
        return self._raw_json_request("POST", path, body=request)

    def disabled_triggers_by_query(
        self,
        tenant: str,
        disabled: Optional[bool] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "triggers", "set-disabled", "by-query")
        params = list(self._build_query_params(disabled=disabled).items())
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ---- Restart / Unlock ----

    def restart_trigger(self, tenant: str, namespace: str, flow_id: str, trigger_id: str) -> dict:
        path = self._tenant_path(tenant, "triggers", namespace, flow_id, trigger_id, "restart")
        return self._raw_json_request("POST", path)

    def unlock_trigger(self, tenant: str, namespace: str, flow_id: str, trigger_id: str) -> dict:
        path = self._tenant_path(tenant, "triggers", namespace, flow_id, trigger_id, "unlock")
        return self._raw_json_request("POST", path)

    def unlock_triggers_by_ids(self, tenant: str, trigger_ids: List[Any]) -> dict:
        path = self._tenant_path(tenant, "triggers", "unlock", "by-triggers")
        return self._raw_json_request("POST", path, body=trigger_ids)

    def unlock_triggers_by_query(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "triggers", "unlock", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ---- Delete ----

    def delete_trigger(self, tenant: str, namespace: str, flow_id: str, trigger_id: str) -> None:
        path = self._tenant_path(tenant, "triggers", namespace, flow_id, trigger_id)
        self._void_request("DELETE", path)

    def delete_triggers_by_ids(self, tenant: str, trigger_ids: List[Any]) -> dict:
        path = self._tenant_path(tenant, "triggers", "delete", "by-triggers")
        return self._raw_json_request("DELETE", path, body=trigger_ids)

    def delete_triggers_by_query(self, tenant: str, request: DeleteTriggersByQueryRequest) -> dict:
        path = self._tenant_path(tenant, "triggers", "delete", "by-query")
        return self._raw_json_request("DELETE", path, body=request)

    # ---- Backfill ----

    def delete_backfill(self, tenant: str, trigger_id: Any) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "delete")
        return self._raw_json_request("POST", path, body=trigger_id)

    def delete_backfill_by_ids(self, tenant: str, trigger_ids: List[Any]) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "delete", "by-triggers")
        return self._raw_json_request("POST", path, body=trigger_ids)

    def delete_backfill_by_query(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "delete", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ---- Backfill pause/unpause ----

    def pause_backfill(self, tenant: str, trigger_id: Any) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "pause")
        return self._raw_json_request("PUT", path, body=trigger_id)

    def pause_backfill_by_ids(self, tenant: str, trigger_ids: List[Any]) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "pause", "by-triggers")
        return self._raw_json_request("POST", path, body=trigger_ids)

    def pause_backfill_by_query(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "pause", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    def unpause_backfill(self, tenant: str, trigger_id: Any) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "unpause")
        return self._raw_json_request("PUT", path, body=trigger_id)

    def unpause_backfill_by_ids(self, tenant: str, trigger_ids: List[Any]) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "unpause", "by-triggers")
        return self._raw_json_request("POST", path, body=trigger_ids)

    def unpause_backfill_by_query(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
    ) -> dict:
        path = self._tenant_path(tenant, "triggers", "backfill", "unpause", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)
