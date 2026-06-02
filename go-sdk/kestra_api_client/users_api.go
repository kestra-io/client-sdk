package kestra_api_client

import "context"

type UsersAPI struct {
	baseAPI
}

func (a *UsersAPI) CreateUser(ctx context.Context, request interface{}) (*IAMUserControllerApiUser, error) {
	return doJSON[*IAMUserControllerApiUser](&a.baseAPI, ctx, "POST", superadminPath("users"), request, nil)
}

func (a *UsersAPI) User(ctx context.Context, id string) (*IAMUserControllerApiUser, error) {
	return doJSON[*IAMUserControllerApiUser](&a.baseAPI, ctx, "GET", superadminPath("users", id), nil, nil)
}

func (a *UsersAPI) UpdateUser(ctx context.Context, id string, request interface{}) (*IAMUserControllerApiUser, error) {
	return doJSON[*IAMUserControllerApiUser](&a.baseAPI, ctx, "PUT", superadminPath("users", id), request, nil)
}

func (a *UsersAPI) DeleteUser(ctx context.Context, id string) error {
	return a.doVoidJSON(ctx, "DELETE", superadminPath("users", id), nil, nil)
}

func (a *UsersAPI) ListUsers(ctx context.Context, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsIAMUserControllerApiUserSummary, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsIAMUserControllerApiUserSummary](&a.baseAPI, ctx, "GET", superadminPath("users"), nil, params)
}

func (a *UsersAPI) PatchUser(ctx context.Context, id string, request interface{}) (*IAMUserControllerApiUser, error) {
	return doJSON[*IAMUserControllerApiUser](&a.baseAPI, ctx, "PATCH", superadminPath("users", id), request, nil)
}

func (a *UsersAPI) PatchUserDemo(ctx context.Context, id string, request interface{}) error {
	return a.doVoidJSON(ctx, "PATCH", superadminPath("users", id, "restricted"), request, nil)
}

func (a *UsersAPI) PatchUserPassword(ctx context.Context, id string, request interface{}) (*IAMUserControllerApiUser, error) {
	return doJSON[*IAMUserControllerApiUser](&a.baseAPI, ctx, "PATCH", superadminPath("users", id, "password"), request, nil)
}

func (a *UsersAPI) PatchUserSuperAdmin(ctx context.Context, id string, request interface{}) error {
	return a.doVoidJSON(ctx, "PATCH", superadminPath("users", id, "superadmin"), request, nil)
}

func (a *UsersAPI) DeleteUserAuthMethod(ctx context.Context, id, auth string) (*IAMUserControllerApiUser, error) {
	return doJSON[*IAMUserControllerApiUser](&a.baseAPI, ctx, "DELETE", superadminPath("users", id, "auths", auth), nil, nil)
}

func (a *UsersAPI) DeleteRefreshToken(ctx context.Context, id string) error {
	return a.doVoidJSON(ctx, "DELETE", superadminPath("users", id, "refresh-token"), nil, nil)
}

func (a *UsersAPI) CreateApiTokensForUser(ctx context.Context, id string, request interface{}) (*CreateApiTokenResponse, error) {
	return doJSON[*CreateApiTokenResponse](&a.baseAPI, ctx, "POST", superadminPath("users", id, "api-tokens"), request, nil)
}

func (a *UsersAPI) ListApiTokensForUser(ctx context.Context, id string) (*ApiTokenList, error) {
	return doJSON[*ApiTokenList](&a.baseAPI, ctx, "GET", superadminPath("users", id, "api-tokens"), nil, nil)
}

func (a *UsersAPI) DeleteApiTokenForUser(ctx context.Context, id, tokenId string) error {
	return a.doVoidJSON(ctx, "DELETE", superadminPath("users", id, "api-tokens", tokenId), nil, nil)
}

func (a *UsersAPI) Impersonate(ctx context.Context, id string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", superadminPath("users", id, "impersonate"), nil, nil)
}

func (a *UsersAPI) UpdateCurrentUserPassword(ctx context.Context, request interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "PUT", "/api/v1/me/password", request, nil)
}

func (a *UsersAPI) AutocompleteUsers(ctx context.Context, tenant string, request interface{}) ([]IAMTenantAccessControllerApiUserTenantAccess, error) {
	return doJSON[[]IAMTenantAccessControllerApiUserTenantAccess](&a.baseAPI, ctx, "POST", tenantPath(tenant, "tenant-access", "autocomplete"), request, nil)
}

func (a *UsersAPI) UpdateUserGroups(ctx context.Context, id, tenant string, request interface{}) error {
	return a.doVoidJSON(ctx, "PUT", tenantPath(tenant, "users", id, "groups"), request, nil)
}
