from kestrapy.base_api import BaseApi
from kestrapy.models.worker_queue_controller_api_create_or_update_worker_queue_request import WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest
from kestrapy.models.worker_queue_controller_api_worker_queue import WorkerQueueControllerApiWorkerQueue
from kestrapy.models.worker_queue_controller_api_worker_queue_details import WorkerQueueControllerApiWorkerQueueDetails
from kestrapy.models.worker_queue_controller_api_worker_queue_list import WorkerQueueControllerApiWorkerQueueList
from kestrapy.models.worker_queue_controller_api_worker_queue_subscribers import WorkerQueueControllerApiWorkerQueueSubscribers


class WorkerQueuesApi(BaseApi):
    """Instance-scoped worker queues (`/api/v1/instance/worker-queues`). Instance-owner-only."""


    def list_worker_queues(self) -> WorkerQueueControllerApiWorkerQueueList:
        path = self._superadmin_path("instance", "worker-queues")
        return self._json_request("GET", path, WorkerQueueControllerApiWorkerQueueList)

    def worker_queue(self, id: str) -> WorkerQueueControllerApiWorkerQueueDetails:
        path = self._superadmin_path("instance", "worker-queues", id)
        return self._json_request("GET", path, WorkerQueueControllerApiWorkerQueueDetails)

    def create_worker_queue(self, request: WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest) -> WorkerQueueControllerApiWorkerQueue:
        path = self._superadmin_path("instance", "worker-queues")
        return self._json_request("POST", path, WorkerQueueControllerApiWorkerQueue, body=request)

    def update_worker_queue(self, id: str, request: WorkerQueueControllerApiCreateOrUpdateWorkerQueueRequest) -> WorkerQueueControllerApiWorkerQueue:
        path = self._superadmin_path("instance", "worker-queues", id)
        return self._json_request("PUT", path, WorkerQueueControllerApiWorkerQueue, body=request)

    def worker_queue_subscribers(self, id: str) -> WorkerQueueControllerApiWorkerQueueSubscribers:
        path = self._superadmin_path("instance", "worker-queues", id, "subscribers")
        return self._json_request("GET", path, WorkerQueueControllerApiWorkerQueueSubscribers)

    def delete_worker_queue(self, id: str) -> None:
        path = self._superadmin_path("instance", "worker-queues", id)
        self._void_request("DELETE", path)
