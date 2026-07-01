package kestra_api_client

import "context"

type BlueprintsAPI struct {
	baseAPI
}

// Community blueprints

func (a *BlueprintsAPI) Blueprint(ctx context.Context, id, kind, tenant string) (*BlueprintControllerApiBlueprintItemWithSource, error) {
	return doJSON[*BlueprintControllerApiBlueprintItemWithSource](&a.baseAPI, ctx, "GET", tenantPath(tenant, "blueprints", "community", kind, id), nil, nil)
}

func (a *BlueprintsAPI) BlueprintGraph(ctx context.Context, id, kind, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "blueprints", "community", kind, id, "graph"), nil, nil)
}

func (a *BlueprintsAPI) BlueprintSource(ctx context.Context, id, kind, tenant string) (string, error) {
	return a.doText(ctx, "GET", tenantPath(tenant, "blueprints", "community", kind, id, "source"), nil, "application/yaml")
}

func (a *BlueprintsAPI) SearchBlueprints(ctx context.Context, kind, tenant string, q *string, sort []string, tags []string, page, size *int) (*PagedResultsBlueprintControllerApiBlueprintItem, error) {
	params := buildQueryParams("q", q, "page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendRepeatedParam(params, "tags", tags)
	return doJSON[*PagedResultsBlueprintControllerApiBlueprintItem](&a.baseAPI, ctx, "GET", tenantPath(tenant, "blueprints", "community", kind), nil, params)
}

// Flow blueprints

func (a *BlueprintsAPI) CreateFlowBlueprint(ctx context.Context, tenant string, request interface{}) (*BlueprintControllerApiFlowBlueprint, error) {
	return doJSON[*BlueprintControllerApiFlowBlueprint](&a.baseAPI, ctx, "POST", tenantPath(tenant, "blueprints", "flows"), request, nil)
}

func (a *BlueprintsAPI) FlowBlueprintById(ctx context.Context, id, tenant string) (*BlueprintControllerApiFlowBlueprint, error) {
	return doJSON[*BlueprintControllerApiFlowBlueprint](&a.baseAPI, ctx, "GET", tenantPath(tenant, "blueprints", "flows", id), nil, nil)
}

func (a *BlueprintsAPI) UpdateFlowBlueprint(ctx context.Context, id, tenant string, request interface{}) (*BlueprintControllerApiFlowBlueprint, error) {
	return doJSON[*BlueprintControllerApiFlowBlueprint](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "blueprints", "flows", id), request, nil)
}

func (a *BlueprintsAPI) DeleteFlowBlueprints(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "blueprints", "flows", id), nil, nil)
}

func (a *BlueprintsAPI) UseBlueprintTemplate(ctx context.Context, id, tenant string, request interface{}) (*BlueprintControllerUseBlueprintTemplateResponse, error) {
	return doJSON[*BlueprintControllerUseBlueprintTemplateResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "blueprints", "flows", id, "use-template"), request, nil)
}

func (a *BlueprintsAPI) FlowBlueprint(ctx context.Context, id, tenant string) (*BlueprintControllerApiFlowBlueprint, error) {
	return doJSON[*BlueprintControllerApiFlowBlueprint](&a.baseAPI, ctx, "GET", tenantPath(tenant, "blueprints", "flow", id), nil, nil)
}

// Internal/Custom blueprints (deprecated in Java but still available)

func (a *BlueprintsAPI) CreateInternalBlueprints(ctx context.Context, tenant string, request interface{}) (*BlueprintControllerApiBlueprintItemWithSource, error) {
	return doJSON[*BlueprintControllerApiBlueprintItemWithSource](&a.baseAPI, ctx, "POST", tenantPath(tenant, "blueprints", "custom"), request, nil)
}

func (a *BlueprintsAPI) InternalBlueprint(ctx context.Context, id, tenant string) (*BlueprintControllerApiFlowBlueprint, error) {
	return doJSON[*BlueprintControllerApiFlowBlueprint](&a.baseAPI, ctx, "GET", tenantPath(tenant, "blueprints", "custom", id), nil, nil)
}

func (a *BlueprintsAPI) InternalBlueprintFlow(ctx context.Context, id, tenant string) (string, error) {
	return a.doText(ctx, "GET", tenantPath(tenant, "blueprints", "custom", id, "source"), nil)
}

func (a *BlueprintsAPI) UpdateInternalBlueprints(ctx context.Context, id, tenant string, request interface{}) (*BlueprintWithFlowEntity, error) {
	return doJSON[*BlueprintWithFlowEntity](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "blueprints", "custom", id), request, nil)
}

func (a *BlueprintsAPI) DeleteInternalBlueprints(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "blueprints", "custom", id), nil, nil)
}

func (a *BlueprintsAPI) SearchInternalBlueprints(ctx context.Context, tenant string, q *string, sort, tags []string, page, size *int, source *string) (*PagedResultsBlueprint, error) {
	params := buildQueryParams("q", q, "page", page, "size", size, "source", source)
	appendRepeatedParam(params, "sort", sort)
	appendRepeatedParam(params, "tags", tags)
	return doJSON[*PagedResultsBlueprint](&a.baseAPI, ctx, "GET", tenantPath(tenant, "blueprints", "custom"), nil, params)
}
