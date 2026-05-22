from typing import Generator, List, Optional

from kestrapy.base_api import BaseApi
from kestrapy.models.log_entry import LogEntry
from kestrapy.models.paged_results_log_entry import PagedResultsLogEntry
from kestrapy.models.query_filter import QueryFilter


class LogsApi(BaseApi):

    # ── Execution Logs ──────────────────────────────────────────────

    def list_logs_from_execution(
        self,
        execution_id: str,
        tenant: str,
        min_level: Optional[str] = None,
        task_run_id: Optional[str] = None,
        task_id: Optional[str] = None,
        attempt: Optional[int] = None,
    ) -> List[LogEntry]:
        path = self._tenant_path(tenant, "logs", execution_id)
        params = self._build_query_params(
            minLevel=min_level, taskRunId=task_run_id,
            taskId=task_id, attempt=attempt,
        )
        return self._json_list_request("GET", path, LogEntry, params=params)

    def download_logs_from_execution(
        self,
        execution_id: str,
        tenant: str,
        min_level: Optional[str] = None,
        task_run_id: Optional[str] = None,
        task_id: Optional[str] = None,
        attempt: Optional[int] = None,
    ) -> str:
        path = self._tenant_path(tenant, "logs", execution_id, "download")
        params = self._build_query_params(
            minLevel=min_level, taskRunId=task_run_id,
            taskId=task_id, attempt=attempt,
        )
        return self._text_request("GET", path, params=params, accept=self.TEXT)

    def delete_logs_from_execution(
        self,
        execution_id: str,
        tenant: str,
        min_level: Optional[str] = None,
        task_run_id: Optional[str] = None,
        task_id: Optional[str] = None,
        attempt: Optional[int] = None,
    ) -> None:
        path = self._tenant_path(tenant, "logs", execution_id)
        params = self._build_query_params(
            minLevel=min_level, taskRunId=task_run_id,
            taskId=task_id, attempt=attempt,
        )
        self._void_request("DELETE", path, params=params)

    def follow_logs_from_execution(
        self,
        execution_id: str,
        tenant: str,
        min_level: Optional[str] = None,
    ) -> Generator[LogEntry, None, None]:
        path = self._tenant_path(tenant, "logs", execution_id, "follow")
        params = self._build_query_params(minLevel=min_level)
        return self._sse_stream(path, LogEntry, params=params)

    def delete_logs_from_flow(
        self,
        namespace: str,
        flow_id: str,
        trigger_id: str,
        tenant: str,
    ) -> None:
        path = self._tenant_path(tenant, "logs", namespace, flow_id)
        params = self._build_query_params(triggerId=trigger_id)
        self._void_request("DELETE", path, params=params)

    # ── Search ──────────────────────────────────────────────────────

    def search_logs(
        self,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        filters: Optional[List[QueryFilter]] = None,
    ) -> PagedResultsLogEntry:
        path = self._tenant_path(tenant, "logs", "search")
        params = list(self._build_query_params(page=page, size=size).items())
        self._append_repeated_param(params, "sort", sort)
        self._append_filter_params(params, filters)
        return self._json_request("GET", path, PagedResultsLogEntry, params=params)
