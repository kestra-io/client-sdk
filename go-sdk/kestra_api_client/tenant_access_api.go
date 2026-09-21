package kestra_api_client

import "context"

// TenantAccessAPI covers /api/v1/{tenant}/tenant-access.
//
// Since Kestra 2.0 tenant access is a prerequisite rather than something granted
// as a side effect: adding a user to a group resolves the user through a
// hasTenantAccess filter and rejects it otherwise, so the access has to be
// granted first through one of the Create calls here.
type TenantAccessAPI struct {
	baseAPI
}

// ListTenantAccess returns the users that can reach the tenant.
func (a *TenantAccessAPI) ListTenantAccess(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsIAMTenantAccessControllerApiUserTenantAccess, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsIAMTenantAccessControllerApiUserTenantAccess](&a.baseAPI, ctx, "GET", tenantPath(tenant, "tenant-access"), nil, params)
}

// TenantAccess returns one user's access to the tenant.
func (a *TenantAccessAPI) TenantAccess(ctx context.Context, userId, tenant string) (*IAMTenantAccessControllerApiTenantAccess, error) {
	return doJSON[*IAMTenantAccessControllerApiTenantAccess](&a.baseAPI, ctx, "GET", tenantPath(tenant, "tenant-access", userId), nil, nil)
}

// CreateTenantAccess grants access by user id. The server answers 201 with no body.
func (a *TenantAccessAPI) CreateTenantAccess(ctx context.Context, userId, tenant string) error {
	return a.doVoidJSON(ctx, "PUT", tenantPath(tenant, "tenant-access", userId), nil, nil)
}

// CreateTenantAccessByEmail grants access by email. The server answers 204 with no
// body, and 409 when the user already has access to the tenant.
func (a *TenantAccessAPI) CreateTenantAccessByEmail(ctx context.Context, tenant string, request interface{}) error {
	return a.doVoidJSON(ctx, "POST", tenantPath(tenant, "tenant-access"), request, nil)
}

// DeleteTenantAccess revokes a user's access to the tenant.
func (a *TenantAccessAPI) DeleteTenantAccess(ctx context.Context, userId, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "tenant-access", userId), nil, nil)
}

// AutocompleteTenantAccess resolves users reachable from the tenant.
func (a *TenantAccessAPI) AutocompleteTenantAccess(ctx context.Context, tenant string, request interface{}) ([]IAMTenantAccessControllerApiUserTenantAccess, error) {
	return doJSON[[]IAMTenantAccessControllerApiUserTenantAccess](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tenant-access", "autocomplete"), request, nil)
}
