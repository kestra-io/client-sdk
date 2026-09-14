package kestra_api_client

import "context"

// WorkerQueuesAPI covers /api/v1/instance/worker-queues. The create, update and
// delete endpoints require the WORKER_QUEUE license feature.
type WorkerQueuesAPI struct {
	baseAPI
}

// ListWorkerQueues returns every worker queue with its active-worker count.
func (a *WorkerQueuesAPI) ListWorkerQueues(ctx context.Context) (*ApiWorkerQueueList, error) {
	return doJSON[*ApiWorkerQueueList](&a.baseAPI, ctx, "GET", superadminPath("instance", "worker-queues"), nil, nil)
}

// WorkerQueue returns a single worker queue by id, including the workers
// currently serving it.
func (a *WorkerQueuesAPI) WorkerQueue(ctx context.Context, id string) (*ApiWorkerQueueDetails, error) {
	return doJSON[*ApiWorkerQueueDetails](&a.baseAPI, ctx, "GET", superadminPath("instance", "worker-queues", id), nil, nil)
}

// WorkerQueueSubscribers lists the worker groups subscribed to a worker queue.
func (a *WorkerQueuesAPI) WorkerQueueSubscribers(ctx context.Context, id string) (*ApiWorkerQueueSubscribers, error) {
	return doJSON[*ApiWorkerQueueSubscribers](&a.baseAPI, ctx, "GET", superadminPath("instance", "worker-queues", id, "subscribers"), nil, nil)
}

// CreateWorkerQueue creates a worker queue. Requires the WORKER_QUEUE feature.
func (a *WorkerQueuesAPI) CreateWorkerQueue(ctx context.Context, request ApiCreateOrUpdateWorkerQueueRequest) (*ApiWorkerQueue, error) {
	return doJSON[*ApiWorkerQueue](&a.baseAPI, ctx, "POST", superadminPath("instance", "worker-queues"), request, nil)
}

// UpdateWorkerQueue updates the worker queue with the given id. The id is
// immutable. Requires the WORKER_QUEUE feature.
func (a *WorkerQueuesAPI) UpdateWorkerQueue(ctx context.Context, id string, request ApiCreateOrUpdateWorkerQueueRequest) (*ApiWorkerQueue, error) {
	return doJSON[*ApiWorkerQueue](&a.baseAPI, ctx, "PUT", superadminPath("instance", "worker-queues", id), request, nil)
}

// DeleteWorkerQueue deletes the worker queue with the given id. The server
// answers 409 if worker groups are still subscribed. Requires the WORKER_QUEUE
// feature.
func (a *WorkerQueuesAPI) DeleteWorkerQueue(ctx context.Context, id string) error {
	return a.doVoid(ctx, "DELETE", superadminPath("instance", "worker-queues", id), nil, nil)
}
