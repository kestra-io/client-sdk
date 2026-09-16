from typing import Any, Dict, List, Optional

from kestrapy.base_api import BaseApi


class MetricsApi(BaseApi):
    """Metrics (`/api/v1/{tenant}/metrics`).

    Task/flow metric lookups. The EE controller is gated by the ``EXECUTION``
    resource, so routes may answer 403 when the feature is unavailable.
    """

    def execution_metrics(
        self,
        execution_id: str,
        tenant: str,
        page: Optional[int] = None,
        size: Optional[int] = None,
        sort: Optional[List[str]] = None,
        task_run_id: Optional[str] = None,
        task_id: Optional[str] = None,
    ) -> Dict[str, Any]:
        """A page of the metrics emitted by one execution, optionally narrowed to
        a task run or task id. GET /api/v1/{tenant}/metrics/{executionId}."""
        path = self._tenant_path(tenant, "metrics", execution_id)
        params = list(
            self._build_query_params(
                page=page, size=size, taskRunId=task_run_id, taskId=task_id
            ).items()
        )
        self._append_repeated_param(params, "sort", sort)
        return self._raw_json_request("GET", path, params=params)

    def flow_metric_names(self, namespace: str, flow_id: str, tenant: str) -> List[str]:
        """Distinct metric names emitted by a flow.
        GET /api/v1/{tenant}/metrics/names/{namespace}/{flowId}."""
        path = self._tenant_path(tenant, "metrics", "names", namespace, flow_id)
        return self._json_list_request("GET", path, str)

    def task_metric_names(
        self, namespace: str, flow_id: str, task_id: str, tenant: str
    ) -> List[str]:
        """Distinct metric names emitted by one task of a flow.
        GET /api/v1/{tenant}/metrics/names/{namespace}/{flowId}/{taskId}."""
        path = self._tenant_path(tenant, "metrics", "names", namespace, flow_id, task_id)
        return self._json_list_request("GET", path, str)

    def tasks_with_metrics(
        self, namespace: str, flow_id: str, tenant: str
    ) -> List[str]:
        """Task ids of a flow that have emitted metrics.
        GET /api/v1/{tenant}/metrics/tasks/{namespace}/{flowId}."""
        path = self._tenant_path(tenant, "metrics", "tasks", namespace, flow_id)
        return self._json_list_request("GET", path, str)

    def aggregate_flow_metric(
        self,
        namespace: str,
        flow_id: str,
        metric: str,
        tenant: str,
        start_date: Optional[str] = None,
        end_date: Optional[str] = None,
        aggregation: Optional[str] = None,
    ) -> Dict[str, Any]:
        """Time-bucketed aggregation of one metric across a flow's executions.
        GET /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{metric}."""
        path = self._tenant_path(tenant, "metrics", "aggregates", namespace, flow_id, metric)
        params = self._build_query_params(
            startDate=start_date, endDate=end_date, aggregation=aggregation
        )
        return self._raw_json_request("GET", path, params=params)

    def aggregate_task_metric(
        self,
        namespace: str,
        flow_id: str,
        task_id: str,
        metric: str,
        tenant: str,
        start_date: Optional[str] = None,
        end_date: Optional[str] = None,
        aggregation: Optional[str] = None,
    ) -> Dict[str, Any]:
        """Time-bucketed aggregation of one metric for a single task across a
        flow's executions.
        GET /api/v1/{tenant}/metrics/aggregates/{namespace}/{flowId}/{taskId}/{metric}."""
        path = self._tenant_path(
            tenant, "metrics", "aggregates", namespace, flow_id, task_id, metric
        )
        params = self._build_query_params(
            startDate=start_date, endDate=end_date, aggregation=aggregation
        )
        return self._raw_json_request("GET", path, params=params)
