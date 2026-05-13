package kestra_api_client

import "context"

type RolesAPI struct {
	baseAPI
}

func (a *RolesAPI) CreateRole(ctx context.Context, tenant string, request interface{}) (*IAMRoleControllerApiRoleDetail, error) {
	return doJSON[*IAMRoleControllerApiRoleDetail](&a.baseAPI, ctx, "POST", tenantPath(tenant, "roles"), request, nil)
}

func (a *RolesAPI) Role(ctx context.Context, id, tenant string) (*IAMRoleControllerApiRoleDetail, error) {
	return doJSON[*IAMRoleControllerApiRoleDetail](&a.baseAPI, ctx, "GET", tenantPath(tenant, "roles", id), nil, nil)
}

func (a *RolesAPI) UpdateRole(ctx context.Context, id, tenant string, request interface{}) (*IAMRoleControllerApiRoleDetail, error) {
	return doJSON[*IAMRoleControllerApiRoleDetail](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "roles", id), request, nil)
}

func (a *RolesAPI) DeleteRole(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "roles", id), nil, nil)
}

func (a *RolesAPI) SearchRoles(ctx context.Context, tenant string, page, size *int, sort []string, filters []QueryFilter) (*PagedResultsApiRoleSummary, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsApiRoleSummary](&a.baseAPI, ctx, "GET", tenantPath(tenant, "roles", "search"), nil, params)
}

func (a *RolesAPI) AutocompleteRoles(ctx context.Context, tenant string, request interface{}) ([]ApiRoleSummary, error) {
	return doJSON[[]ApiRoleSummary](&a.baseAPI, ctx, "POST", tenantPath(tenant, "roles", "autocomplete"), request, nil)
}

func (a *RolesAPI) ListRolesFromGivenIds(ctx context.Context, tenant string, ids []string) ([]Role, error) {
	return doJSON[[]Role](&a.baseAPI, ctx, "POST", tenantPath(tenant, "roles", "ids"), ApiIds{Ids: ids}, nil)
}
