package kestra_api_client

import "context"

// PromotionTargetsAPI covers /api/v1/{tenant}/promotion-targets. The controller
// is gated by the PROMOTION_TARGET resource and the FEATURE_PROMOTE license
// feature, so routes answer 403 when the feature is disabled.
type PromotionTargetsAPI struct {
	baseAPI
}

// ListPromotionTargets returns a page of promotion targets. Backs GET
// /api/v1/{tenant}/promotion-targets.
func (a *PromotionTargetsAPI) ListPromotionTargets(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "promotion-targets"), nil, params)
}

// PromotionTarget returns a single promotion target by id. Backs GET
// /api/v1/{tenant}/promotion-targets/{id}.
func (a *PromotionTargetsAPI) PromotionTarget(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "promotion-targets", id), nil, nil)
}

// CreatePromotionTarget creates a promotion target. `body` is an
// ApiCreatePromotionTargetRequest. Backs POST /api/v1/{tenant}/promotion-targets.
func (a *PromotionTargetsAPI) CreatePromotionTarget(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "promotion-targets"), body, nil)
}

// UpdatePromotionTarget updates a promotion target. Backs PUT
// /api/v1/{tenant}/promotion-targets/{id}.
func (a *PromotionTargetsAPI) UpdatePromotionTarget(ctx context.Context, id, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "promotion-targets", id), body, nil)
}

// DeletePromotionTarget deletes a promotion target. Backs DELETE
// /api/v1/{tenant}/promotion-targets/{id}.
func (a *PromotionTargetsAPI) DeletePromotionTarget(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "promotion-targets", id), nil, nil)
}

// TestPromotionTarget tests an unsaved promotion-target definition. The optional
// `id` is sent as a query param (not a path segment) to reuse a stored token.
// Backs POST /api/v1/{tenant}/promotion-targets/test.
func (a *PromotionTargetsAPI) TestPromotionTarget(ctx context.Context, tenant string, body interface{}, id *string) (*ApiTestConnectionResponse, error) {
	params := buildQueryParams("id", id)
	return doJSON[*ApiTestConnectionResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "promotion-targets", "test"), body, params)
}

// TestSavedPromotionTarget tests a stored promotion target's connection. Backs
// POST /api/v1/{tenant}/promotion-targets/{id}/test.
func (a *PromotionTargetsAPI) TestSavedPromotionTarget(ctx context.Context, id, tenant string) (*ApiTestConnectionResponse, error) {
	return doJSON[*ApiTestConnectionResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "promotion-targets", id, "test"), nil, nil)
}

// PromotionTargetFlowSource fetches the source of a flow as it exists on the
// promotion target. Backs GET /api/v1/{tenant}/promotion-targets/{id}/flow-source.
func (a *PromotionTargetsAPI) PromotionTargetFlowSource(ctx context.Context, id, tenant, namespace, flowId string, revision *int) (map[string]interface{}, error) {
	params := buildQueryParams("namespace", namespace, "flowId", flowId, "revision", revision)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "promotion-targets", id, "flow-source"), nil, params)
}

// PromotionTargetFlowHashes returns per-flow content hashes on the promotion
// target for a batch of flow references. `body` is an ApiFlowHashBatch.Request
// ({flows: [{namespace, flowId}]}). Backs POST
// /api/v1/{tenant}/promotion-targets/{id}/flow-hashes.
func (a *PromotionTargetsAPI) PromotionTargetFlowHashes(ctx context.Context, id, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "promotion-targets", id, "flow-hashes"), body, nil)
}
