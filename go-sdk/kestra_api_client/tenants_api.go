package kestra_api_client

import "context"

// TenantsAPI covers the instance-level /api/v1/tenants routes (instance-owner-only).
type TenantsAPI struct {
	baseAPI
}

func (a *TenantsAPI) CreateTenant(ctx context.Context, tenant Tenant) (*Tenant, error) {
	return doJSON[*Tenant](&a.baseAPI, ctx, "POST", superadminPath("tenants"), tenant, nil)
}

func (a *TenantsAPI) SearchTenants(ctx context.Context, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsTenant, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsTenant](&a.baseAPI, ctx, "GET", superadminPath("tenants", "search"), nil, params)
}

func (a *TenantsAPI) Tenant(ctx context.Context, id string) (*Tenant, error) {
	return doJSON[*Tenant](&a.baseAPI, ctx, "GET", superadminPath("tenants", id), nil, nil)
}

func (a *TenantsAPI) UpdateTenant(ctx context.Context, id string, tenant Tenant) (*Tenant, error) {
	return doJSON[*Tenant](&a.baseAPI, ctx, "PUT", superadminPath("tenants", id), tenant, nil)
}

// DeleteTenant deletes the tenant and all resources linked to it (flows,
// namespaces, apps, ...).
func (a *TenantsAPI) DeleteTenant(ctx context.Context, id string) error {
	return a.doVoidJSON(ctx, "DELETE", superadminPath("tenants", id), nil, nil)
}
