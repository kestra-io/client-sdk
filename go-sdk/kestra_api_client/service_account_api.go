package kestra_api_client

import "context"

type ServiceAccountAPI struct {
	baseAPI
}

// Superadmin endpoints (no tenant)

func (a *ServiceAccountAPI) CreateServiceAccount(ctx context.Context, request interface{}) (*IAMServiceAccountControllerApiServiceAccountDetail, error) {
	return doJSON[*IAMServiceAccountControllerApiServiceAccountDetail](&a.baseAPI, ctx, "POST", superadminPath("service-accounts"), request, nil)
}

func (a *ServiceAccountAPI) ServiceAccount(ctx context.Context, id string) (*IAMServiceAccountControllerApiServiceAccountDetail, error) {
	return doJSON[*IAMServiceAccountControllerApiServiceAccountDetail](&a.baseAPI, ctx, "GET", superadminPath("service-accounts", id), nil, nil)
}

func (a *ServiceAccountAPI) PatchServiceAccountDetails(ctx context.Context, id string, request interface{}) (*IAMServiceAccountControllerApiServiceAccountDetail, error) {
	return doJSON[*IAMServiceAccountControllerApiServiceAccountDetail](&a.baseAPI, ctx, "PATCH", superadminPath("service-accounts", id), request, nil)
}

func (a *ServiceAccountAPI) DeleteServiceAccount(ctx context.Context, id string) error {
	return a.doVoidJSON(ctx, "DELETE", superadminPath("service-accounts", id), nil, nil)
}

func (a *ServiceAccountAPI) PatchServiceAccountSuperAdmin(ctx context.Context, id string, request interface{}) error {
	return a.doVoidJSON(ctx, "PATCH", superadminPath("service-accounts", id, "superadmin"), request, nil)
}

func (a *ServiceAccountAPI) ListServiceAccounts(ctx context.Context, page, size *int, sort []string, filters []QueryFilter) (*PagedResultsIAMServiceAccountControllerApiServiceAccountDetail, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsIAMServiceAccountControllerApiServiceAccountDetail](&a.baseAPI, ctx, "GET", superadminPath("service-accounts"), nil, params)
}

func (a *ServiceAccountAPI) CreateApiTokensForServiceAccount(ctx context.Context, id string, request interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", superadminPath("service-accounts", id, "api-tokens"), request, nil)
}

func (a *ServiceAccountAPI) ListApiTokensForServiceAccount(ctx context.Context, id string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("service-accounts", id, "api-tokens"), nil, nil)
}

func (a *ServiceAccountAPI) DeleteApiTokenForServiceAccount(ctx context.Context, id, tokenId string) error {
	return a.doVoidJSON(ctx, "DELETE", superadminPath("service-accounts", id, "api-tokens", tokenId), nil, nil)
}

// Tenant-scoped endpoints

func (a *ServiceAccountAPI) CreateServiceAccountForTenant(ctx context.Context, tenant string, request interface{}) (*IAMServiceAccountControllerApiServiceAccountResponse, error) {
	return doJSON[*IAMServiceAccountControllerApiServiceAccountResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "service-accounts"), request, nil)
}

func (a *ServiceAccountAPI) ServiceAccountForTenant(ctx context.Context, id, tenant string) (*IAMServiceAccountControllerApiServiceAccountResponse, error) {
	return doJSON[*IAMServiceAccountControllerApiServiceAccountResponse](&a.baseAPI, ctx, "GET", tenantPath(tenant, "service-accounts", id), nil, nil)
}

func (a *ServiceAccountAPI) UpdateServiceAccount(ctx context.Context, id, tenant string, request interface{}) (*IAMServiceAccountControllerApiServiceAccountResponse, error) {
	return doJSON[*IAMServiceAccountControllerApiServiceAccountResponse](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "service-accounts", id), request, nil)
}

func (a *ServiceAccountAPI) DeleteServiceAccountForTenant(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "service-accounts", id), nil, nil)
}

func (a *ServiceAccountAPI) CreateApiTokensForServiceAccountWithTenant(ctx context.Context, id, tenant string, request interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "service-accounts", id, "api-tokens"), request, nil)
}

func (a *ServiceAccountAPI) ListApiTokensForServiceAccountWithTenant(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "service-accounts", id, "api-tokens"), nil, nil)
}

func (a *ServiceAccountAPI) DeleteApiTokenForServiceAccountWithTenant(ctx context.Context, id, tokenId, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "service-accounts", id, "api-tokens", tokenId), nil, nil)
}
