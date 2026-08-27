package kestra_api_client

import "context"

type TenantAccessAPI struct {
	baseAPI
}

// CreateTenantAccess grants a user access to the tenant. Users created through
// POST /api/v1/users exist instance-wide but hold no tenant access, and the
// tenant-scoped IAM endpoints reject them with 404 "User does not exist" until
// this is called. The user is identified by email, not id.
func (a *TenantAccessAPI) CreateTenantAccess(ctx context.Context, tenant string, request interface{}) error {
	return a.doVoidJSON(ctx, "POST", tenantPath(tenant, "tenant-access"), request, nil)
}
