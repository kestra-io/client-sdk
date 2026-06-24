package kestra_api_client

import "context"

type TenantAccessAPI struct {
	baseAPI
}

func (a *TenantAccessAPI) CreateTenantAccess(ctx context.Context, tenant string, request IAMTenantAccessControllerApiCreateTenantAccessRequest) error {
	return a.doVoidJSON(ctx, "POST", tenantPath(tenant, "tenant-access"), request, nil)
}

func (a *TenantAccessAPI) DeleteTenantAccess(ctx context.Context, userId, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "tenant-access", userId), nil, nil)
}

func (a *TenantAccessAPI) ListTenantAccess(ctx context.Context, tenant string, page, size *int) (*PagedResultsIAMTenantAccessControllerApiUserTenantAccess, error) {
	params := buildQueryParams("page", page, "size", size)
	return doJSON[*PagedResultsIAMTenantAccessControllerApiUserTenantAccess](&a.baseAPI, ctx, "GET", tenantPath(tenant, "tenant-access"), nil, params)
}
