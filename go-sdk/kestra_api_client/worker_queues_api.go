package kestra_api_client

import "context"

// WorkerQueuesAPI covers the read routes of /api/v1/instance/worker-queues.
// The create/update/delete endpoints are feature-gated (FEATURE_WORKER_QUEUE)
// and are not wrapped here.
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
