package kestra_api_client

import "context"

// CredentialsAPI covers /api/v1/{tenant}/credentials — tenant-level credentials
// (OAuth2 / GitHub App). The controller is guarded by the CREDENTIAL resource,
// so every route answers 403 when the caller lacks it or the feature is off.
//
// The request and response bodies are polymorphic (discriminated on `type`:
// OAUTH2 | GITHUB_APP), so create/update take a free-form body and reads return
// a decoded map — mirroring the namespace-credentials wrappers.
type CredentialsAPI struct {
	baseAPI
}

// The ApiTestConnectionResponse model (used here and by promotion targets) is
// reused from the existing generated model file.

// ListCredentials returns a page of tenant-level credentials. Backs GET
// /api/v1/{tenant}/credentials.
func (a *CredentialsAPI) ListCredentials(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "credentials"), nil, params)
}

// Credential returns a single tenant-level credential by id. Backs GET
// /api/v1/{tenant}/credentials/{id}.
func (a *CredentialsAPI) Credential(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "credentials", id), nil, nil)
}

// CreateCredential creates a tenant-level credential. `body` is an
// ApiCreateCredentialRequest (discriminated on `type`). Backs POST
// /api/v1/{tenant}/credentials.
func (a *CredentialsAPI) CreateCredential(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "credentials"), body, nil)
}

// UpdateCredential updates a tenant-level credential. Backs PUT
// /api/v1/{tenant}/credentials/{id}.
func (a *CredentialsAPI) UpdateCredential(ctx context.Context, id, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "credentials", id), body, nil)
}

// DeleteCredential deletes a tenant-level credential. Backs DELETE
// /api/v1/{tenant}/credentials/{id}.
func (a *CredentialsAPI) DeleteCredential(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "credentials", id), nil, nil)
}

// TestCredential tests a stored credential's connection. Backs POST
// /api/v1/{tenant}/credentials/{id}/test.
func (a *CredentialsAPI) TestCredential(ctx context.Context, id, tenant string) (*ApiTestConnectionResponse, error) {
	return doJSON[*ApiTestConnectionResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "credentials", id, "test"), nil, nil)
}
