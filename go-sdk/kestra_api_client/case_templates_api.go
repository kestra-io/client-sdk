package kestra_api_client

import "context"

// CaseTemplatesAPI covers /api/v1/{tenant}/case-templates.
type CaseTemplatesAPI struct {
	baseAPI
}

// SearchCaseTemplates returns a page of case templates matching the given filters.
func (a *CaseTemplatesAPI) SearchCaseTemplates(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsCaseTemplate, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*PagedResultsCaseTemplate](&a.baseAPI, ctx, "GET", tenantPath(tenant, "case-templates", "search"), nil, params)
}

// CreateCaseTemplate creates a case template.
func (a *CaseTemplatesAPI) CreateCaseTemplate(ctx context.Context, tenant string, request CaseTemplateRequest) (*CaseTemplate, error) {
	return doJSON[*CaseTemplate](&a.baseAPI, ctx, "POST", tenantPath(tenant, "case-templates"), request, nil)
}

// GetCaseTemplate retrieves a case template by id.
func (a *CaseTemplatesAPI) GetCaseTemplate(ctx context.Context, tenant, id string) (*CaseTemplate, error) {
	return doJSON[*CaseTemplate](&a.baseAPI, ctx, "GET", tenantPath(tenant, "case-templates", id), nil, nil)
}

// UpdateCaseTemplate updates a case template.
func (a *CaseTemplatesAPI) UpdateCaseTemplate(ctx context.Context, tenant, id string, request CaseTemplateRequest) (*CaseTemplate, error) {
	return doJSON[*CaseTemplate](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "case-templates", id), request, nil)
}

// DeleteCaseTemplate deletes a case template.
func (a *CaseTemplatesAPI) DeleteCaseTemplate(ctx context.Context, tenant, id string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "case-templates", id), nil, nil)
}
