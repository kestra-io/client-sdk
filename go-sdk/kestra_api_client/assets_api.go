package kestra_api_client

import "context"

type AssetsAPI struct {
	baseAPI
}

func (a *AssetsAPI) CreateAsset(ctx context.Context, tenant, yamlBody string) (*AssetsControllerApiAsset, error) {
	return doJSONWithYAMLBody[*AssetsControllerApiAsset](&a.baseAPI, ctx, "POST", tenantPath(tenant, "assets"), yamlBody, nil)
}

func (a *AssetsAPI) Asset(ctx context.Context, id, tenant string, allowDeleted *bool) (*AssetsControllerApiAsset, error) {
	params := buildQueryParams("allowDeleted", allowDeleted)
	return doJSON[*AssetsControllerApiAsset](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", id), nil, params)
}

func (a *AssetsAPI) DeleteAsset(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "assets", id), nil, nil)
}

func (a *AssetsAPI) AssetDependencies(ctx context.Context, id, tenant string, destinationOnly, expandAll *bool) (*AssetTopologyGraph, error) {
	params := buildQueryParams("destinationOnly", destinationOnly, "expandAll", expandAll)
	return doJSON[*AssetTopologyGraph](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", id, "dependencies"), nil, params)
}

func (a *AssetsAPI) DeleteAssetsByIds(ctx context.Context, tenant string, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", "by-ids"), ids, nil)
}

func (a *AssetsAPI) DeleteAssetsByQuery(ctx context.Context, tenant string, filters []QueryFilter, purge *bool) (*BulkResponse, error) {
	params := buildQueryParams("purge", purge)
	appendFilterParams(params, filters)
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", "by-query"), nil, params)
}

func (a *AssetsAPI) DeleteAssetLineageEventsByQuery(ctx context.Context, tenant string, filters []QueryFilter) (*BulkResponse, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", "lineage-events", "by-query"), nil, params)
}

func (a *AssetsAPI) DeleteAssetUsagesByQuery(ctx context.Context, tenant string, filters []QueryFilter) (*BulkResponse, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "assets", "usages", "by-query"), nil, params)
}

func (a *AssetsAPI) SearchAssets(ctx context.Context, tenant string, page, size *int, sort []string, filters []QueryFilter) (*PagedResultsAssetsControllerApiAsset, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsAssetsControllerApiAsset](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", "search"), nil, params)
}

func (a *AssetsAPI) SearchAssetLineageEvents(ctx context.Context, tenant string, page, size *int, sort []string, filters []QueryFilter) (*PagedResultsAssetsControllerApiAssetLineageEvent, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsAssetsControllerApiAssetLineageEvent](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", "lineage-events", "search"), nil, params)
}

func (a *AssetsAPI) SearchAssetUsages(ctx context.Context, tenant string, page, size *int, sort []string, filters []QueryFilter) (*PagedResultsAssetsControllerApiAssetUsage, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsAssetsControllerApiAssetUsage](&a.baseAPI, ctx, "GET", tenantPath(tenant, "assets", "usages", "search"), nil, params)
}
