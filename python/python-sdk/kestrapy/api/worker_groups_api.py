from typing import Any

from kestrapy.base_api import BaseApi
from kestrapy.models.worker_group_controller_api_create_worker_group_request import WorkerGroupControllerApiCreateWorkerGroupRequest
from kestrapy.models.worker_group_controller_api_generate_token_request import WorkerGroupControllerApiGenerateTokenRequest
from kestrapy.models.worker_group_controller_api_generate_token_response import WorkerGroupControllerApiGenerateTokenResponse
from kestrapy.models.worker_group_controller_api_subscription_request import WorkerGroupControllerApiSubscriptionRequest
from kestrapy.models.worker_group_controller_api_update_subscription_request import WorkerGroupControllerApiUpdateSubscriptionRequest
from kestrapy.models.worker_group_controller_api_update_worker_group_request import WorkerGroupControllerApiUpdateWorkerGroupRequest
from kestrapy.models.worker_group_controller_api_worker_group import WorkerGroupControllerApiWorkerGroup
from kestrapy.models.worker_group_controller_api_worker_group_capacity import WorkerGroupControllerApiWorkerGroupCapacity
from kestrapy.models.worker_group_controller_api_worker_group_list import WorkerGroupControllerApiWorkerGroupList
from kestrapy.models.worker_group_controller_api_worker_group_worker_list import WorkerGroupControllerApiWorkerGroupWorkerList


class WorkerGroupsApi(BaseApi):
    """Instance-scoped worker groups (`/api/v1/instance/worker-groups`). Instance-owner-only."""


    # ---- CRUD ----

    def list_worker_groups(self) -> WorkerGroupControllerApiWorkerGroupList:
        path = self._superadmin_path("instance", "worker-groups")
        return self._json_request("GET", path, WorkerGroupControllerApiWorkerGroupList)

    def worker_group(self, id: str) -> WorkerGroupControllerApiWorkerGroup:
        path = self._superadmin_path("instance", "worker-groups", id)
        return self._json_request("GET", path, WorkerGroupControllerApiWorkerGroup)

    def create_worker_group(self, request: WorkerGroupControllerApiCreateWorkerGroupRequest) -> WorkerGroupControllerApiWorkerGroup:
        path = self._superadmin_path("instance", "worker-groups")
        return self._json_request("POST", path, WorkerGroupControllerApiWorkerGroup, body=request)

    def update_worker_group(self, id: str, request: WorkerGroupControllerApiUpdateWorkerGroupRequest) -> WorkerGroupControllerApiWorkerGroup:
        path = self._superadmin_path("instance", "worker-groups", id)
        return self._json_request("PUT", path, WorkerGroupControllerApiWorkerGroup, body=request)

    def delete_worker_group(self, id: str) -> None:
        path = self._superadmin_path("instance", "worker-groups", id)
        self._void_request("DELETE", path)

    # ---- Subscriptions ----

    def add_worker_group_subscription(self, id: str, request: WorkerGroupControllerApiSubscriptionRequest) -> WorkerGroupControllerApiWorkerGroup:
        path = self._superadmin_path("instance", "worker-groups", id, "subscriptions")
        return self._json_request("POST", path, WorkerGroupControllerApiWorkerGroup, body=request)

    def update_worker_group_subscription_reservation(self, id: str, worker_queue_id: str, request: WorkerGroupControllerApiUpdateSubscriptionRequest) -> WorkerGroupControllerApiWorkerGroup:
        path = self._superadmin_path("instance", "worker-groups", id, "subscriptions", worker_queue_id)
        return self._json_request("PATCH", path, WorkerGroupControllerApiWorkerGroup, body=request, content_type=self.JSON)

    def remove_worker_group_subscription(self, id: str, worker_queue_id: str) -> WorkerGroupControllerApiWorkerGroup:
        path = self._superadmin_path("instance", "worker-groups", id, "subscriptions", worker_queue_id)
        return self._json_request("DELETE", path, WorkerGroupControllerApiWorkerGroup)

    # ---- Tokens ----

    def generate_worker_group_token(self, id: str, request: WorkerGroupControllerApiGenerateTokenRequest) -> WorkerGroupControllerApiGenerateTokenResponse:
        path = self._superadmin_path("instance", "worker-groups", id, "tokens")
        return self._json_request("POST", path, WorkerGroupControllerApiGenerateTokenResponse, body=request)

    def revoke_worker_group_token(self, id: str, token_id: str) -> WorkerGroupControllerApiWorkerGroup:
        path = self._superadmin_path("instance", "worker-groups", id, "tokens", token_id, "revoke")
        return self._json_request("POST", path, WorkerGroupControllerApiWorkerGroup)

    def delete_worker_group_token(self, id: str, token_id: str) -> None:
        path = self._superadmin_path("instance", "worker-groups", id, "tokens", token_id)
        self._void_request("DELETE", path)

    # ---- Runtime ----

    def list_worker_group_workers(self, id: str) -> WorkerGroupControllerApiWorkerGroupWorkerList:
        path = self._superadmin_path("instance", "worker-groups", id, "workers")
        return self._json_request("GET", path, WorkerGroupControllerApiWorkerGroupWorkerList)

    def worker_group_capacity(self, id: str) -> WorkerGroupControllerApiWorkerGroupCapacity:
        path = self._superadmin_path("instance", "worker-groups", id, "capacity")
        return self._json_request("GET", path, WorkerGroupControllerApiWorkerGroupCapacity)
