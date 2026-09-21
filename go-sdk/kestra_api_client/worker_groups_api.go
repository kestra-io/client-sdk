package kestra_api_client

import "context"

// WorkerGroupsAPI covers the instance-level /api/v1/instance/worker-groups
// routes that are usable on a plain EE instance: reads and token management.
// The create/update/delete and subscription endpoints are feature-gated
// (FEATURE_WORKER_GROUP / FEATURE_WORKER_QUEUE) and are not wrapped here.
type WorkerGroupsAPI struct {
	baseAPI
}

// ListWorkerGroups returns every worker group. The optional filters use the
// WORKER_GROUP query filter format.
func (a *WorkerGroupsAPI) ListWorkerGroups(ctx context.Context, filters []SearchFilter) (*ApiWorkerGroupList, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[*ApiWorkerGroupList](&a.baseAPI, ctx, "GET", superadminPath("instance", "worker-groups"), nil, params)
}

// WorkerGroup returns a single worker group by id.
func (a *WorkerGroupsAPI) WorkerGroup(ctx context.Context, id string) (*ApiWorkerGroup, error) {
	return doJSON[*ApiWorkerGroup](&a.baseAPI, ctx, "GET", superadminPath("instance", "worker-groups", id), nil, nil)
}

// CreateWorkerGroup creates a worker group. Requires the WORKER_GROUP feature,
// and the license caps how many worker groups may exist.
func (a *WorkerGroupsAPI) CreateWorkerGroup(ctx context.Context, request ApiCreateWorkerGroupRequest) (*ApiWorkerGroup, error) {
	return doJSON[*ApiWorkerGroup](&a.baseAPI, ctx, "POST", superadminPath("instance", "worker-groups"), request, nil)
}

// UpdateWorkerGroup updates the worker group with the given id.
func (a *WorkerGroupsAPI) UpdateWorkerGroup(ctx context.Context, id string, request ApiUpdateWorkerGroupRequest) (*ApiWorkerGroup, error) {
	return doJSON[*ApiWorkerGroup](&a.baseAPI, ctx, "PUT", superadminPath("instance", "worker-groups", id), request, nil)
}

// DeleteWorkerGroup deletes the worker group with the given id. force removes it
// even if workers are still active. The default group cannot be deleted (400).
func (a *WorkerGroupsAPI) DeleteWorkerGroup(ctx context.Context, id string, force *bool) error {
	params := buildQueryParams("force", force)
	return a.doVoid(ctx, "DELETE", superadminPath("instance", "worker-groups", id), nil, params)
}

// AddWorkerGroupSubscription subscribes the worker group to a worker queue.
// Requires the WORKER_QUEUE feature and an existing worker queue.
func (a *WorkerGroupsAPI) AddWorkerGroupSubscription(ctx context.Context, id string, request ApiSubscriptionRequest) (*ApiWorkerGroup, error) {
	return doJSON[*ApiWorkerGroup](&a.baseAPI, ctx, "POST", superadminPath("instance", "worker-groups", id, "subscriptions"), request, nil)
}

// UpdateWorkerGroupSubscription changes the reserved capacity of a subscription.
func (a *WorkerGroupsAPI) UpdateWorkerGroupSubscription(ctx context.Context, id, workerQueueId string, request ApiUpdateSubscriptionRequest) (*ApiWorkerGroup, error) {
	return doJSON[*ApiWorkerGroup](&a.baseAPI, ctx, "PATCH", superadminPath("instance", "worker-groups", id, "subscriptions", workerQueueId), request, nil)
}

// RemoveWorkerGroupSubscription unsubscribes the worker group from a worker queue.
func (a *WorkerGroupsAPI) RemoveWorkerGroupSubscription(ctx context.Context, id, workerQueueId string) (*ApiWorkerGroup, error) {
	return doJSON[*ApiWorkerGroup](&a.baseAPI, ctx, "DELETE", superadminPath("instance", "worker-groups", id, "subscriptions", workerQueueId), nil, nil)
}

// GenerateWorkerGroupToken mints a registration token for a worker group. The
// plaintext token is returned exactly once, in the response.
func (a *WorkerGroupsAPI) GenerateWorkerGroupToken(ctx context.Context, id string, request ApiGenerateTokenRequest) (*ApiGenerateTokenResponse, error) {
	return doJSON[*ApiGenerateTokenResponse](&a.baseAPI, ctx, "POST", superadminPath("instance", "worker-groups", id, "tokens"), request, nil)
}

// RevokeWorkerGroupToken revokes a worker group's registration token without
// deleting it; the returned group reflects the token's revoked state.
func (a *WorkerGroupsAPI) RevokeWorkerGroupToken(ctx context.Context, id, tokenId string) (*ApiWorkerGroup, error) {
	return doJSON[*ApiWorkerGroup](&a.baseAPI, ctx, "POST", superadminPath("instance", "worker-groups", id, "tokens", tokenId, "revoke"), nil, nil)
}

// DeleteWorkerGroupToken permanently deletes a worker group's registration token.
func (a *WorkerGroupsAPI) DeleteWorkerGroupToken(ctx context.Context, id, tokenId string) error {
	return a.doVoid(ctx, "DELETE", superadminPath("instance", "worker-groups", id, "tokens", tokenId), nil, nil)
}
