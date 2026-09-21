from typing import Any, Dict, List

from kestrapy.base_api import BaseApi
from kestrapy.models.output_controller_task_output_information import (
    OutputControllerTaskOutputInformation,
)


class OutputsApi(BaseApi):
    """Execution outputs (`/api/v1/{tenant}/outputs`).

    Kestra 2.0 dropped the ``outputs`` property from the execution payload, so
    these routes are the only way to read flow- and task-level outputs.
    """

    def execution_outputs(self, execution_id: str, tenant: str) -> Dict[str, Any]:
        """The flow-level outputs of an execution.
        GET /api/v1/{tenant}/outputs/executions/{executionId}."""
        path = self._tenant_path(tenant, "outputs", "executions", execution_id)
        return self._raw_json_request("GET", path)

    def task_outputs_information(
        self, execution_id: str, tenant: str
    ) -> List[OutputControllerTaskOutputInformation]:
        """The task runs of an execution that have outputs.
        GET /api/v1/{tenant}/outputs/tasks/{executionId}."""
        path = self._tenant_path(tenant, "outputs", "tasks", execution_id)
        return self._json_list_request(
            "GET", path, OutputControllerTaskOutputInformation
        )

    def task_run_outputs(
        self, execution_id: str, task_run_id: str, tenant: str
    ) -> Dict[str, Any]:
        """The outputs of a single task run.
        GET /api/v1/{tenant}/outputs/tasks/{executionId}/{taskRunId}."""
        path = self._tenant_path(tenant, "outputs", "tasks", execution_id, task_run_id)
        return self._raw_json_request("GET", path)
