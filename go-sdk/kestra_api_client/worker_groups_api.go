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
