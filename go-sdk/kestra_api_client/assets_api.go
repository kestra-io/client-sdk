package kestra_api_client

import "context"

type AssetsAPI struct {
	baseAPI
}

func (a *AssetsAPI) CreateAsset(ctx context.Context, tenant, yamlBody string) (*AssetsControllerApiAsset, error) {
	return doJSONWithYAMLBody[*AssetsControllerApiAsset](&a.baseAPI, ctx, "POST", tenantPath(tenant, "assets"), yamlBody, nil)
}

// UpdateAsset updates an existing asset. Kestra 2.0 stopped letting CreateAsset
// upsert -- POST now conflicts when the id already exists, so an update has to
// go through this PUT.
func (a *AssetsAPI) UpdateAsset(ctx context.Context, id, tenant, yamlBody string) (*AssetsControllerApiAsset, error) {
	return doJSONWithYAMLBody[*AssetsControllerApiAsset](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "assets", id), yamlBody, nil)
}

func (a *AssetsAPI) Asset(ctx context.Context, id, tenant string, allowDeleted *bool) (*AssetsControllerApiAsset, error) {
	params := buildQueryParams("allowDeleted", allowDeleted)
	return doJSON[*AssetsControllerApiAsset](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", id), nil, params)
}

func (a *AssetsAPI) DeleteAsset(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "assets", id), nil, nil)
}

func (a *AssetsAPI) LockAsset(ctx context.Context, id, tenant string, request AssetsControllerAssetLockRequest) (*AssetsControllerApiAssetLock, error) {
	return doJSON[*AssetsControllerApiAssetLock](&a.baseAPI, ctx, "POST", tenantPath(tenant, "assets", id, "lock"), request, nil)
}

func (a *AssetsAPI) UnlockAsset(ctx context.Context, id, tenant string, executionId *string) error {
	params := buildQueryParams("executionId", executionId)
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "assets", id, "lock"), nil, params)
}

// A nil kinds includes every current-state kind.
func (a *AssetsAPI) AssetDependencies(ctx context.Context, id, tenant string, kinds []RelationKind, expandAll *bool, hubCursor *string) (*AssetRelationGraph, error) {
	params := buildQueryParams("expandAll", expandAll, "hubCursor", hubCursor)
	appendRepeatedParam(params, "kinds", relationKindStrings(kinds))
	return doJSON[*AssetRelationGraph](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", id, "dependencies"), nil, params)
}

// A nil kinds includes every current-state kind.
func (a *AssetsAPI) FlowAssetDependencies(ctx context.Context, namespace, id, tenant string, kinds []RelationKind, expandAll *bool, hubCursor *string) (*AssetRelationGraph, error) {
	params := buildQueryParams("expandAll", expandAll, "hubCursor", hubCursor)
	appendRepeatedParam(params, "kinds", relationKindStrings(kinds))
	return doJSON[*AssetRelationGraph](&a.baseAPI, ctx, "GET", tenantPath(tenant, "flows", namespace, id, "asset-dependencies"), nil, params)
}

func (a *AssetsAPI) AssetRelationSummary(ctx context.Context, id, tenant string, limit *int) (*AssetsControllerApiRelationSummary, error) {
	params := buildQueryParams("limit", limit)
	return doJSON[*AssetsControllerApiRelationSummary](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", id, "relations", "summary"), nil, params)
}

// Take direction from the summary group being expanded; it is not derivable from kind alone.
func (a *AssetsAPI) AssetRelations(ctx context.Context, id, tenant string, kind RelationKind, direction RelationDirection, after *string, size *int) (*AssetsControllerApiRelationPage, error) {
	params := buildQueryParams("kind", string(kind), "direction", string(direction), "after", after, "size", size)
	return doJSON[*AssetsControllerApiRelationPage](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", id, "relations"), nil, params)
}

// PART_OF is not created here: it goes through SetAssetParent.
func (a *AssetsAPI) CreateAssetRelation(ctx context.Context, id, tenant string, request AssetsControllerApiRelationRequest) (*AssetsControllerApiRelation, error) {
	return doJSON[*AssetsControllerApiRelation](&a.baseAPI, ctx, "POST", tenantPath(tenant, "assets", id, "relations"), request, nil)
}

func (a *AssetsAPI) DeleteAssetRelation(ctx context.Context, id, uid, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "assets", id, "relations", uid), nil, nil)
}

func (a *AssetsAPI) SetAssetParent(ctx context.Context, id, tenant string, parent AssetsControllerApiParentRequest) (*AssetsControllerApiAsset, error) {
	return doJSON[*AssetsControllerApiAsset](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "assets", id, "parent"), parent, nil)
}

func (a *AssetsAPI) ClearAssetParent(ctx context.Context, id, tenant string) (*AssetsControllerApiAsset, error) {
	return doJSON[*AssetsControllerApiAsset](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", id, "parent"), nil, nil)
}

func relationKindStrings(kinds []RelationKind) []string {
	out := make([]string, len(kinds))
	for i, k := range kinds {
		out[i] = string(k)
	}
	return out
}

func (a *AssetsAPI) DeleteAssetsByIds(ctx context.Context, tenant string, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", "by-ids"), ids, nil)
}

func (a *AssetsAPI) DeleteAssetsByQuery(ctx context.Context, tenant string, filters []SearchFilter, purge *bool) (*BulkResponse, error) {
	params := buildQueryParams("purge", purge)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", "by-query"), nil, params)
}

func (a *AssetsAPI) DeleteAssetUsagesByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*BulkResponse, error) {
	params := buildQueryParams()
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", "usages", "by-query"), nil, params)
}

func (a *AssetsAPI) SearchAssets(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsAssetsControllerApiAsset, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsAssetsControllerApiAsset](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", "search"), nil, params)
}

func (a *AssetsAPI) SearchAssetUsages(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsAssetsControllerApiAssetUsage, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsAssetsControllerApiAssetUsage](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", "usages", "search"), nil, params)
}
