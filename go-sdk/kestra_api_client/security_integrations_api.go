package kestra_api_client

import "context"

// SecurityIntegrationsAPI covers /api/v1/{tenant}/security-integrations (SCIM).
// The controller requires instance-owner access and the FEATURE_SCIM license
// feature, so routes answer 403 otherwise.
type SecurityIntegrationsAPI struct {
	baseAPI
}

// ListSecurityIntegrations returns every security integration in an envelope
// {total, results}. Deprecated server-side in favour of SearchSecurityIntegrations.
// Backs GET /api/v1/{tenant}/security-integrations.
func (a *SecurityIntegrationsAPI) ListSecurityIntegrations(ctx context.Context, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "security-integrations"), nil, nil)
}

// SearchSecurityIntegrations returns a page of security integrations. Backs GET
// /api/v1/{tenant}/security-integrations/search.
func (a *SecurityIntegrationsAPI) SearchSecurityIntegrations(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "security-integrations", "search"), nil, params)
}

// SecurityIntegration returns a single security integration by id. Backs GET
// /api/v1/{tenant}/security-integrations/{id}.
func (a *SecurityIntegrationsAPI) SecurityIntegration(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "security-integrations", id), nil, nil)
}

// CreateSecurityIntegration creates a security integration. `body` is a
// CreateSecurityIntegrationRequest ({name, description, type}); the response
// carries the SCIM bearer token once, at creation. Backs POST
// /api/v1/{tenant}/security-integrations.
func (a *SecurityIntegrationsAPI) CreateSecurityIntegration(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "security-integrations"), body, nil)
}

// DeleteSecurityIntegration deletes a security integration. Backs DELETE
// /api/v1/{tenant}/security-integrations/{id}.
func (a *SecurityIntegrationsAPI) DeleteSecurityIntegration(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "security-integrations", id), nil, nil)
}

// EnableSecurityIntegration enables a security integration. Backs POST
// /api/v1/{tenant}/security-integrations/{id}/enable.
func (a *SecurityIntegrationsAPI) EnableSecurityIntegration(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "security-integrations", id, "enable"), nil, nil)
}

// DisableSecurityIntegration disables a security integration. Backs POST
// /api/v1/{tenant}/security-integrations/{id}/disable.
func (a *SecurityIntegrationsAPI) DisableSecurityIntegration(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "security-integrations", id, "disable"), nil, nil)
}
