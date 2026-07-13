import json
from typing import Any, Dict, Generator, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.bulk_response import BulkResponse
from kestrapy.models.execution import Execution
from kestrapy.models.execution_controller_execution_response import ExecutionControllerExecutionResponse
from kestrapy.models.execution_controller_last_execution_response import ExecutionControllerLastExecutionResponse
from kestrapy.models.execution_controller_set_labels_by_ids_request import ExecutionControllerSetLabelsByIdsRequest
from kestrapy.models.execution_controller_state_request import ExecutionControllerStateRequest
from kestrapy.models.execution_kind import ExecutionKind
from kestrapy.models.execution_repository_interface_flow_filter import ExecutionRepositoryInterfaceFlowFilter
from kestrapy.models.execution_status_event import ExecutionStatusEvent
from kestrapy.models.file_metas import FileMetas
from kestrapy.models.flow_for_execution import FlowForExecution
from kestrapy.models.flow_graph import FlowGraph
from kestrapy.models.label import Label
from kestrapy.models.query_filter import QueryFilter
from kestrapy.models.state_type import StateType
from kestrapy.models.webhook_response import WebhookResponse


class ExecutionsApi(BaseApi):

    # ========================================================================
    # Create execution
    # ========================================================================

    def create_execution(
        self,
        tenant: str,
        namespace: str,
        id: str,
        inputs: Optional[Dict[str, Any]] = None,
        labels: Optional[List[str]] = None,
        wait: Optional[bool] = None,
        revision: Optional[int] = None,
        schedule_date: Optional[str] = None,
        breakpoints: Optional[str] = None,
        kind: Optional[ExecutionKind] = None,
    ) -> ExecutionControllerExecutionResponse:
        """Create a new execution for a flow.

        Flow inputs are passed via ``inputs`` as a mapping of input id to value.
        They are sent as ``multipart/form-data``, one form part per input:

        - ``str`` values are sent verbatim.
        - ``bytes``/``bytearray`` values are sent as a file part (for ``FILE`` inputs).
        - a ``(filename, content)`` or ``(filename, content, content_type)`` tuple is
          sent as a file part with that filename/content type (for ``FILE`` inputs).
        - any other value (``int``, ``float``, ``bool``, ``dict``, ``list``, ...) is
          JSON-encoded, so e.g. ``True`` becomes ``"true"`` and ``[1, 2]`` becomes
          ``"[1, 2]"`` (for ``JSON``/``ARRAY``/... inputs).
        """
        path = self._tenant_path(tenant, "executions", namespace, id)
        kind_val = kind.value if kind is not None and hasattr(kind, 'value') else kind
        params = list(self._build_query_params(
            wait=wait, revision=revision, scheduleDate=schedule_date,
            breakpoints=breakpoints, kind=kind_val,
        ).items())
        self._append_repeated_param(params, "labels", labels)
        files = self._build_inputs_multipart(inputs)
        resp = self._request("POST", path, params=params, files=files)
        return self._deserialize(resp.json(), ExecutionControllerExecutionResponse)

    @staticmethod
    def _build_inputs_multipart(inputs: Optional[Dict[str, Any]]):
        """Turn a flow-inputs mapping into ``requests``-style multipart file parts."""
        if not inputs:
            return None
        parts = []
        for key, value in inputs.items():
            if isinstance(value, (bytes, bytearray)):
                parts.append((key, (key, value)))
            elif isinstance(value, tuple):
                parts.append((key, value))
            elif isinstance(value, str):
                parts.append((key, (None, value)))
            else:
                parts.append((key, (None, json.dumps(value))))
        return parts

    # ========================================================================
    # Get execution
    # ========================================================================

    def execution(self, execution_id: str, tenant: str) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id)
        return self._json_request("GET", path, Execution)

    # ========================================================================
    # Search
    # ========================================================================

    def search_executions(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._raw_json_request("GET", path, params=params)

    def search_executions_by_flow_id(
        self,
        tenant: str,
        namespace: str,
        flow_id: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions")
        params = self._build_query_params(
            namespace=namespace, flowId=flow_id, page=page, size=size,
        )
        return self._raw_json_request("GET", path, params=params)

    def latest_executions(
        self,
        tenant: str,
        filters: List[ExecutionRepositoryInterfaceFlowFilter],
    ) -> List[ExecutionControllerLastExecutionResponse]:
        path = self._tenant_path(tenant, "executions", "latest")
        body = [f.model_dump(by_alias=True, exclude_none=True) if hasattr(f, 'model_dump') else f for f in filters]
        return self._json_list_request("POST", path, ExecutionControllerLastExecutionResponse, body=body)

    # ========================================================================
    # Graph & flow
    # ========================================================================

    def execution_flow_graph(
        self,
        execution_id: str,
        tenant: str,
        subflows: Optional[List[str]] = None,
    ) -> FlowGraph:
        path = self._tenant_path(tenant, "executions", execution_id, "graph")
        params: list = []
        self._append_repeated_param(params, "subflows", subflows)
        return self._json_request("GET", path, FlowGraph, params=params)

    def flow_from_execution(
        self,
        tenant: str,
        namespace: str,
        flow_id: str,
        revision: Optional[int] = None,
    ) -> FlowForExecution:
        path = self._tenant_path(tenant, "executions", "flows", namespace, flow_id)
        params = self._build_query_params(revision=revision)
        return self._json_request("GET", path, FlowForExecution, params=params)

    def flow_from_execution_by_id(self, execution_id: str, tenant: str) -> FlowForExecution:
        path = self._tenant_path(tenant, "executions", execution_id, "flow")
        return self._json_request("GET", path, FlowForExecution)

    # ========================================================================
    # File operations
    # ========================================================================

    def download_file_from_execution(
        self, execution_id: str, path_uri: str, tenant: str,
    ) -> bytes:
        path = self._tenant_path(tenant, "executions", execution_id, "file")
        params = self._build_query_params(path=path_uri)
        return self._download_request("GET", path, params=params)

    def file_metadatas_from_execution(
        self, execution_id: str, path_uri: str, tenant: str,
    ) -> FileMetas:
        path = self._tenant_path(tenant, "executions", execution_id, "file", "metas")
        params = self._build_query_params(path=path_uri)
        return self._json_request("GET", path, FileMetas, params=params)

    # ========================================================================
    # Eval expression
    # ========================================================================

    def eval_expression(
        self, execution_id: str, tenant: str, expression: str,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "eval")
        return self._raw_json_request("POST", path, body=expression, content_type=self.TEXT)

    # ========================================================================
    # Kill
    # ========================================================================

    def kill_execution(
        self, execution_id: str, tenant: str, is_on_kill_cascade: Optional[bool] = None,
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "kill")
        params = self._build_query_params(isOnKillCascade=is_on_kill_cascade)
        return self._json_request("DELETE", path, Execution, params=params)

    def kill_executions_by_ids(self, tenant: str, ids: List[str]) -> Any:
        path = self._tenant_path(tenant, "executions", "kill", "by-ids")
        return self._raw_json_request("DELETE", path, body=ids)

    def kill_executions_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "kill", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("DELETE", path, params=params)

    # ========================================================================
    # Delete
    # ========================================================================

    def delete_execution(
        self,
        execution_id: str,
        tenant: str,
        delete_logs: Optional[bool] = None,
        delete_metrics: Optional[bool] = None,
        delete_storage: Optional[bool] = None,
    ) -> None:
        path = self._tenant_path(tenant, "executions", execution_id)
        params = self._build_query_params(
            deleteLogs=delete_logs, deleteMetrics=delete_metrics, deleteStorage=delete_storage,
        )
        self._void_request("DELETE", path, params=params)

    def delete_executions_by_ids(
        self,
        tenant: str,
        ids: List[str],
        include_non_terminated: Optional[bool] = None,
        delete_logs: Optional[bool] = None,
        delete_metrics: Optional[bool] = None,
        delete_storage: Optional[bool] = None,
    ) -> BulkResponse:
        path = self._tenant_path(tenant, "executions", "by-ids")
        params = self._build_query_params(
            includeNonTerminated=include_non_terminated,
            deleteLogs=delete_logs, deleteMetrics=delete_metrics, deleteStorage=delete_storage,
        )
        return self._json_request("DELETE", path, BulkResponse, params=params, body=ids)

    def delete_executions_by_query(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
        include_non_terminated: Optional[bool] = None,
        delete_logs: Optional[bool] = None,
        delete_metrics: Optional[bool] = None,
        delete_storage: Optional[bool] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "by-query")
        params = list(self._build_query_params(
            includeNonTerminated=include_non_terminated,
            deleteLogs=delete_logs, deleteMetrics=delete_metrics, deleteStorage=delete_storage,
        ).items())
        self._append_filter_params(params, filters)
        return self._raw_json_request("DELETE", path, params=params)

    # ========================================================================
    # Pause / Resume
    # ========================================================================

    def pause_execution(self, execution_id: str, tenant: str) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "pause")
        return self._json_request("POST", path, Execution)

    def pause_executions_by_ids(self, tenant: str, ids: List[str]) -> Any:
        path = self._tenant_path(tenant, "executions", "pause", "by-ids")
        return self._raw_json_request("POST", path, body=ids)

    def pause_executions_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "pause", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    def resume_execution(self, execution_id: str, tenant: str) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "resume")
        return self._json_request("POST", path, Execution)

    def resume_executions_by_ids(self, tenant: str, ids: List[str]) -> Any:
        path = self._tenant_path(tenant, "executions", "resume", "by-ids")
        return self._raw_json_request("POST", path, body=ids)

    def resume_executions_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "resume", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ========================================================================
    # Restart
    # ========================================================================

    def restart_execution(
        self, execution_id: str, tenant: str, revision: Optional[int] = None,
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "restart")
        params = self._build_query_params(revision=revision)
        return self._json_request("POST", path, Execution, params=params)

    def restart_executions_by_ids(self, tenant: str, ids: List[str]) -> Any:
        path = self._tenant_path(tenant, "executions", "restart", "by-ids")
        return self._raw_json_request("POST", path, body=ids)

    def restart_executions_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "restart", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ========================================================================
    # Replay
    # ========================================================================

    def replay_execution(
        self,
        execution_id: str,
        tenant: str,
        task_run_id: Optional[str] = None,
        revision: Optional[int] = None,
        breakpoints: Optional[str] = None,
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "replay")
        params = self._build_query_params(
            taskRunId=task_run_id, revision=revision, breakpoints=breakpoints,
        )
        return self._json_request("POST", path, Execution, params=params)

    def replay_execution_with_inputs(
        self,
        execution_id: str,
        tenant: str,
        task_run_id: Optional[str] = None,
        revision: Optional[int] = None,
        breakpoints: Optional[str] = None,
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "replay-with-inputs")
        params = self._build_query_params(
            taskRunId=task_run_id, revision=revision, breakpoints=breakpoints,
        )
        return self._json_request("POST", path, Execution, params=params)

    def replay_executions_by_ids(
        self, tenant: str, ids: List[str], latest_revision: Optional[bool] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "replay", "by-ids")
        params = self._build_query_params(latestRevision=latest_revision)
        return self._raw_json_request("POST", path, params=params, body=ids)

    def replay_executions_by_query(
        self,
        tenant: str,
        filters: Optional[List[QueryFilter]] = None,
        latest_revision: Optional[bool] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "replay", "by-query")
        params = list(self._build_query_params(latestRevision=latest_revision).items())
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ========================================================================
    # Force run
    # ========================================================================

    def force_run_execution(self, execution_id: str, tenant: str) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "force-run")
        return self._json_request("POST", path, Execution)

    def force_run_by_ids(self, tenant: str, ids: List[str]) -> Any:
        path = self._tenant_path(tenant, "executions", "force-run", "by-ids")
        return self._raw_json_request("POST", path, body=ids)

    def force_run_executions_by_query(
        self, tenant: str, filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "force-run", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ========================================================================
    # Unqueue
    # ========================================================================

    def unqueue_execution(
        self, execution_id: str, tenant: str, state: Optional[StateType] = None,
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "unqueue")
        state_val = state.value if state is not None and hasattr(state, 'value') else state
        params = self._build_query_params(state=state_val)
        return self._json_request("POST", path, Execution, params=params)

    def unqueue_executions_by_ids(
        self, tenant: str, state: StateType, ids: List[str],
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "unqueue", "by-ids")
        state_val = state.value if hasattr(state, 'value') else str(state)
        params = self._build_query_params(state=state_val)
        return self._raw_json_request("POST", path, params=params, body=ids)

    def unqueue_executions_by_query(
        self,
        tenant: str,
        new_state: Optional[StateType] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "unqueue", "by-query")
        state_val = new_state.value if new_state is not None and hasattr(new_state, 'value') else new_state
        params = list(self._build_query_params(newState=state_val).items())
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ========================================================================
    # Labels
    # ========================================================================

    def set_labels_on_terminated_execution(
        self, execution_id: str, tenant: str, labels: List[Label],
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "labels")
        body = [lb.model_dump(by_alias=True, exclude_none=True) if hasattr(lb, 'model_dump') else lb for lb in labels]
        return self._json_request("POST", path, Execution, body=body)

    def set_labels_on_terminated_executions_by_ids(
        self, tenant: str, request: ExecutionControllerSetLabelsByIdsRequest,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "labels", "by-ids")
        return self._raw_json_request("POST", path, body=request)

    def set_labels_on_terminated_executions_by_query(
        self,
        tenant: str,
        labels: List[Label],
        filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "labels", "by-query")
        params: list = []
        self._append_filter_params(params, filters)
        body = [lb.model_dump(by_alias=True, exclude_none=True) if hasattr(lb, 'model_dump') else lb for lb in labels]
        return self._raw_json_request("POST", path, params=params, body=body)

    # ========================================================================
    # Change status
    # ========================================================================

    def update_execution_status(
        self, execution_id: str, status: StateType, tenant: str,
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "change-status")
        status_val = status.value if hasattr(status, 'value') else str(status)
        params = self._build_query_params(status=status_val)
        return self._json_request("POST", path, Execution, params=params)

    def update_executions_status_by_ids(
        self, tenant: str, new_status: StateType, ids: List[str],
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "change-status", "by-ids")
        status_val = new_status.value if hasattr(new_status, 'value') else str(new_status)
        params = self._build_query_params(newStatus=status_val)
        return self._raw_json_request("POST", path, params=params, body=ids)

    def update_executions_status_by_query(
        self,
        tenant: str,
        new_status: StateType,
        filters: Optional[List[QueryFilter]] = None,
    ) -> Any:
        path = self._tenant_path(tenant, "executions", "change-status", "by-query")
        status_val = new_status.value if hasattr(new_status, 'value') else str(new_status)
        params = list(self._build_query_params(newStatus=status_val).items())
        self._append_filter_params(params, filters)
        return self._raw_json_request("POST", path, params=params)

    # ========================================================================
    # Update task run state
    # ========================================================================

    def update_task_run_state(
        self,
        execution_id: str,
        tenant: str,
        request: ExecutionControllerStateRequest,
    ) -> Execution:
        path = self._tenant_path(tenant, "executions", execution_id, "actions", "state")
        return self._json_request("POST", path, Execution, body=request)

    # ========================================================================
    # Webhooks
    # ========================================================================

    def trigger_execution_by_get_webhook(
        self, tenant: str, namespace: str, id: str, key: str,
    ) -> WebhookResponse:
        path = self._tenant_path(tenant, "executions", "webhook", namespace, id, key)
        return self._json_request("GET", path, WebhookResponse)

    def trigger_execution_by_get_webhook_with_path(
        self, tenant: str, namespace: str, id: str, key: str, webhook_path: str,
    ) -> WebhookResponse:
        path = self._tenant_path(tenant, "executions", "webhook", namespace, id, key, webhook_path)
        return self._json_request("GET", path, WebhookResponse)

    def trigger_execution_by_post_webhook_with_path(
        self, tenant: str, namespace: str, id: str, key: str, webhook_path: str,
    ) -> WebhookResponse:
        path = self._tenant_path(tenant, "executions", "webhook", namespace, id, key, webhook_path)
        return self._json_request("POST", path, WebhookResponse)

    def trigger_execution_by_put_webhook_with_path(
        self, tenant: str, namespace: str, id: str, key: str, webhook_path: str,
    ) -> WebhookResponse:
        path = self._tenant_path(tenant, "executions", "webhook", namespace, id, key, webhook_path)
        return self._json_request("PUT", path, WebhookResponse)

    # ========================================================================
    # Streaming (SSE)
    # ========================================================================

    def follow_execution(
        self, execution_id: str, tenant: str,
    ) -> Generator[Execution, None, None]:
        path = self._tenant_path(tenant, "executions", execution_id, "follow")
        return self._sse_stream(path, Execution)

    def follow_dependencies_execution(
        self,
        execution_id: str,
        tenant: str,
        destination_only: Optional[bool] = None,
        expand_all: Optional[bool] = None,
    ) -> Generator[ExecutionStatusEvent, None, None]:
        path = self._tenant_path(tenant, "executions", execution_id, "follow-dependencies")
        params = self._build_query_params(destinationOnly=destination_only, expandAll=expand_all)
        return self._sse_stream(path, ExecutionStatusEvent, params=params)
