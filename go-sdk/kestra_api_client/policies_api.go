package kestra_api_client

import "context"

// PoliciesAPI covers governance Policies at the INSTANCE, TENANT and NAMESPACE scopes.
// Create/Update/Validate take the raw YAML source: the API parses it and stamps the scope,
// tenant and namespace from the URL.
type PoliciesAPI struct {
	baseAPI
}

// instancePoliciesPath: INSTANCE policies are not tenant-scoped, "instance" is literal.
func instancePoliciesPath(segments ...string) string {
	return tenantPath("instance", append([]string{"policies"}, segments...)...)
}

func tenantPoliciesPath(tenant string, segments ...string) string {
	return tenantPath(tenant, append([]string{"policies"}, segments...)...)
}

func namespacePoliciesPath(tenant, namespace string, segments ...string) string {
	return tenantPath(tenant, append([]string{"namespaces", namespace, "policies"}, segments...)...)
}

func policySearchParams(page, size *int, sort []string, filters []SearchFilter) map[string][]string {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return params
}

// INSTANCE scope

func (a *PoliciesAPI) CreateInstancePolicy(ctx context.Context, source string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "POST", instancePoliciesPath(), source, nil)
}

func (a *PoliciesAPI) InstancePolicy(ctx context.Context, id string) (*Policy, error) {
	return doJSON[*Policy](&a.baseAPI, ctx, "GET", instancePoliciesPath(id), nil, nil)
}

func (a *PoliciesAPI) UpdateInstancePolicy(ctx context.Context, id, source string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "PUT", instancePoliciesPath(id), source, nil)
}

func (a *PoliciesAPI) DeleteInstancePolicy(ctx context.Context, id string) error {
	return a.doVoidJSON(ctx, "DELETE", instancePoliciesPath(id), nil, nil)
}

func (a *PoliciesAPI) DeleteInstancePoliciesByIds(ctx context.Context, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", instancePoliciesPath("delete", "by-ids"), ids, nil)
}

func (a *PoliciesAPI) SearchInstancePolicies(ctx context.Context, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiPolicySummary, error) {
	return doJSON[*PagedResultsApiPolicySummary](&a.baseAPI, ctx, "GET", instancePoliciesPath("search"), nil, policySearchParams(page, size, sort, filters))
}

func (a *PoliciesAPI) ValidateInstancePolicy(ctx context.Context, source string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", instancePoliciesPath("validate"), source, nil)
}

func (a *PoliciesAPI) EvaluateInstancePolicy(ctx context.Context, id string, page, size *int) (*PolicyEvaluation, error) {
	return doJSON[*PolicyEvaluation](&a.baseAPI, ctx, "GET", instancePoliciesPath(id, "evaluate"), nil, buildQueryParams("page", page, "size", size))
}

func (a *PoliciesAPI) ExportInstancePolicies(ctx context.Context) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", instancePoliciesPath("export"), nil, nil)
}

func (a *PoliciesAPI) ExportInstancePoliciesByIds(ctx context.Context, ids []string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", instancePoliciesPath("export", "by-ids"), ids, nil)
}

// TENANT scope

func (a *PoliciesAPI) CreateTenantPolicy(ctx context.Context, tenant string, source string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "POST", tenantPoliciesPath(tenant), source, nil)
}

func (a *PoliciesAPI) TenantPolicy(ctx context.Context, tenant string, id string) (*Policy, error) {
	return doJSON[*Policy](&a.baseAPI, ctx, "GET", tenantPoliciesPath(tenant, id), nil, nil)
}

func (a *PoliciesAPI) UpdateTenantPolicy(ctx context.Context, tenant string, id, source string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "PUT", tenantPoliciesPath(tenant, id), source, nil)
}

func (a *PoliciesAPI) DeleteTenantPolicy(ctx context.Context, tenant string, id string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPoliciesPath(tenant, id), nil, nil)
}

func (a *PoliciesAPI) DeleteTenantPoliciesByIds(ctx context.Context, tenant string, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPoliciesPath(tenant, "delete", "by-ids"), ids, nil)
}

func (a *PoliciesAPI) SearchPolicies(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiPolicySummary, error) {
	return doJSON[*PagedResultsApiPolicySummary](&a.baseAPI, ctx, "GET", tenantPoliciesPath(tenant, "search"), nil, policySearchParams(page, size, sort, filters))
}

func (a *PoliciesAPI) ValidateTenantPolicy(ctx context.Context, tenant string, source string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", tenantPoliciesPath(tenant, "validate"), source, nil)
}

func (a *PoliciesAPI) EvaluateTenantPolicy(ctx context.Context, tenant string, id string, page, size *int) (*PolicyEvaluation, error) {
	return doJSON[*PolicyEvaluation](&a.baseAPI, ctx, "GET", tenantPoliciesPath(tenant, id, "evaluate"), nil, buildQueryParams("page", page, "size", size))
}

func (a *PoliciesAPI) ExportTenantPolicies(ctx context.Context, tenant string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPoliciesPath(tenant, "export"), nil, nil)
}

func (a *PoliciesAPI) ExportTenantPoliciesByIds(ctx context.Context, tenant string, ids []string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPoliciesPath(tenant, "export", "by-ids"), ids, nil)
}

// NAMESPACE scope

func (a *PoliciesAPI) CreateNamespacePolicy(ctx context.Context, tenant, namespace string, source string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "POST", namespacePoliciesPath(tenant, namespace), source, nil)
}

func (a *PoliciesAPI) NamespacePolicy(ctx context.Context, tenant, namespace string, id string) (*Policy, error) {
	return doJSON[*Policy](&a.baseAPI, ctx, "GET", namespacePoliciesPath(tenant, namespace, id), nil, nil)
}

func (a *PoliciesAPI) UpdateNamespacePolicy(ctx context.Context, tenant, namespace string, id, source string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "PUT", namespacePoliciesPath(tenant, namespace, id), source, nil)
}

func (a *PoliciesAPI) DeleteNamespacePolicy(ctx context.Context, tenant, namespace string, id string) error {
	return a.doVoidJSON(ctx, "DELETE", namespacePoliciesPath(tenant, namespace, id), nil, nil)
}

func (a *PoliciesAPI) DeleteNamespacePoliciesByIds(ctx context.Context, tenant, namespace string, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", namespacePoliciesPath(tenant, namespace, "delete", "by-ids"), ids, nil)
}

func (a *PoliciesAPI) SearchNamespacePolicies(ctx context.Context, tenant, namespace string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiPolicySummary, error) {
	return doJSON[*PagedResultsApiPolicySummary](&a.baseAPI, ctx, "GET", namespacePoliciesPath(tenant, namespace, "search"), nil, policySearchParams(page, size, sort, filters))
}

func (a *PoliciesAPI) ValidateNamespacePolicy(ctx context.Context, tenant, namespace string, source string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", namespacePoliciesPath(tenant, namespace, "validate"), source, nil)
}

func (a *PoliciesAPI) EvaluateNamespacePolicy(ctx context.Context, tenant, namespace string, id string, page, size *int) (*PolicyEvaluation, error) {
	return doJSON[*PolicyEvaluation](&a.baseAPI, ctx, "GET", namespacePoliciesPath(tenant, namespace, id, "evaluate"), nil, buildQueryParams("page", page, "size", size))
}

func (a *PoliciesAPI) ExportNamespacePolicies(ctx context.Context, tenant, namespace string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", namespacePoliciesPath(tenant, namespace, "export"), nil, nil)
}

func (a *PoliciesAPI) ExportNamespacePoliciesByIds(ctx context.Context, tenant, namespace string, ids []string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", namespacePoliciesPath(tenant, namespace, "export", "by-ids"), ids, nil)
}

// Import & Preview (tenant scope only)

// ImportPolicies imports from an archive, as produced by the export endpoints.
func (a *PoliciesAPI) ImportPolicies(ctx context.Context, tenant, filePath string) (*PolicyImportResult, error) {
	return doMultipartUpload[*PolicyImportResult](&a.baseAPI, ctx, "POST", tenantPoliciesPath(tenant, "import"), nil, "fileUpload", filePath)
}

// PreviewPolicies reports the policies that would apply to a flow, persisting nothing.
func (a *PoliciesAPI) PreviewPolicies(ctx context.Context, tenant string, request PolicyPreviewRequest) (*PolicyPreviewResponse, error) {
	return doJSON[*PolicyPreviewResponse](&a.baseAPI, ctx, "POST", tenantPath(tenant, "flows", "policies", "preview"), request, nil)
}
