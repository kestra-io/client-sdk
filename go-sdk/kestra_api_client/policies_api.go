package kestra_api_client

import "context"

// PoliciesAPI covers the EE governance policy endpoints across the tenant,
// namespace and instance scopes. The whole controller requires the POLICIES
// license feature. Policy create/update/validate bodies are raw YAML.
type PoliciesAPI struct {
	baseAPI
}

// --- Tenant scope: /api/v1/{tenant}/policies ---

func (a *PoliciesAPI) SearchTenantPolicies(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiPolicySummary, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsApiPolicySummary](&a.baseAPI, ctx, "GET", tenantPath(tenant, "policies", "search"), nil, params)
}

func (a *PoliciesAPI) TenantPolicy(ctx context.Context, tenant, id string) (*Policy, error) {
	return doJSON[*Policy](&a.baseAPI, ctx, "GET", tenantPath(tenant, "policies", id), nil, nil)
}

func (a *PoliciesAPI) CreateTenantPolicy(ctx context.Context, tenant, yamlBody string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "POST", tenantPath(tenant, "policies"), yamlBody, nil)
}

func (a *PoliciesAPI) UpdateTenantPolicy(ctx context.Context, tenant, id, yamlBody string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "policies", id), yamlBody, nil)
}

func (a *PoliciesAPI) ValidateTenantPolicy(ctx context.Context, tenant, yamlBody string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", tenantPath(tenant, "policies", "validate"), yamlBody, nil)
}

func (a *PoliciesAPI) DeleteTenantPolicy(ctx context.Context, tenant, id string) error {
	return a.doVoid(ctx, "DELETE", tenantPath(tenant, "policies", id), nil, nil)
}

func (a *PoliciesAPI) DeleteTenantPoliciesByIds(ctx context.Context, tenant string, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "policies", "delete", "by-ids"), ids, nil)
}

func (a *PoliciesAPI) EvaluateTenantPolicy(ctx context.Context, tenant, id string, page, size *int) (*ApiPolicyEvaluation, error) {
	params := buildQueryParams("page", page, "size", size)
	return doJSON[*ApiPolicyEvaluation](&a.baseAPI, ctx, "GET", tenantPath(tenant, "policies", id, "evaluate"), nil, params)
}

func (a *PoliciesAPI) ExportTenantPolicies(ctx context.Context, tenant string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "policies", "export"), nil, nil)
}

func (a *PoliciesAPI) ExportTenantPoliciesByIds(ctx context.Context, tenant string, ids []string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "policies", "export", "by-ids"), ids, nil)
}

// --- Namespace scope: /api/v1/{tenant}/namespaces/{namespace}/policies ---

func (a *PoliciesAPI) SearchNamespacePolicies(ctx context.Context, tenant, namespace string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiPolicySummary, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsApiPolicySummary](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "policies", "search"), nil, params)
}

func (a *PoliciesAPI) NamespacePolicy(ctx context.Context, tenant, namespace, id string) (*Policy, error) {
	return doJSON[*Policy](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "policies", id), nil, nil)
}

func (a *PoliciesAPI) CreateNamespacePolicy(ctx context.Context, tenant, namespace, yamlBody string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies"), yamlBody, nil)
}

func (a *PoliciesAPI) UpdateNamespacePolicy(ctx context.Context, tenant, namespace, id, yamlBody string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "policies", id), yamlBody, nil)
}

func (a *PoliciesAPI) ValidateNamespacePolicy(ctx context.Context, tenant, namespace, yamlBody string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies", "validate"), yamlBody, nil)
}

func (a *PoliciesAPI) DeleteNamespacePolicy(ctx context.Context, tenant, namespace, id string) error {
	return a.doVoid(ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "policies", id), nil, nil)
}

func (a *PoliciesAPI) DeleteNamespacePoliciesByIds(ctx context.Context, tenant, namespace string, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "policies", "delete", "by-ids"), ids, nil)
}

func (a *PoliciesAPI) EvaluateNamespacePolicy(ctx context.Context, tenant, namespace, id string, page, size *int) (*ApiPolicyEvaluation, error) {
	params := buildQueryParams("page", page, "size", size)
	return doJSON[*ApiPolicyEvaluation](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "policies", id, "evaluate"), nil, params)
}

func (a *PoliciesAPI) ExportNamespacePolicies(ctx context.Context, tenant, namespace string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies", "export"), nil, nil)
}

func (a *PoliciesAPI) ExportNamespacePoliciesByIds(ctx context.Context, tenant, namespace string, ids []string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies", "export", "by-ids"), ids, nil)
}

// --- Instance scope: /api/v1/instance/policies (instance owner) ---

func (a *PoliciesAPI) SearchInstancePolicies(ctx context.Context, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiPolicySummary, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsApiPolicySummary](&a.baseAPI, ctx, "GET", superadminPath("instance", "policies", "search"), nil, params)
}

// InstancePolicy returns an instance-scoped policy. scope may be "INSTANCE"
// (default) or "STATIC" to read a policy defined in the static configuration.
func (a *PoliciesAPI) InstancePolicy(ctx context.Context, id string, scope *string) (*Policy, error) {
	params := buildQueryParams("scope", scope)
	return doJSON[*Policy](&a.baseAPI, ctx, "GET", superadminPath("instance", "policies", id), nil, params)
}

func (a *PoliciesAPI) CreateInstancePolicy(ctx context.Context, yamlBody string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "POST", superadminPath("instance", "policies"), yamlBody, nil)
}

func (a *PoliciesAPI) UpdateInstancePolicy(ctx context.Context, id, yamlBody string) (*Policy, error) {
	return doJSONWithYAMLBody[*Policy](&a.baseAPI, ctx, "PUT", superadminPath("instance", "policies", id), yamlBody, nil)
}

func (a *PoliciesAPI) ValidateInstancePolicy(ctx context.Context, yamlBody string) (*ValidateConstraintViolation, error) {
	return doJSONWithYAMLBody[*ValidateConstraintViolation](&a.baseAPI, ctx, "POST", superadminPath("instance", "policies", "validate"), yamlBody, nil)
}

func (a *PoliciesAPI) DeleteInstancePolicy(ctx context.Context, id string) error {
	return a.doVoid(ctx, "DELETE", superadminPath("instance", "policies", id), nil, nil)
}

func (a *PoliciesAPI) DeleteInstancePoliciesByIds(ctx context.Context, ids []string) (*BulkResponse, error) {
	return doJSON[*BulkResponse](&a.baseAPI, ctx, "DELETE", superadminPath("instance", "policies", "delete", "by-ids"), ids, nil)
}

func (a *PoliciesAPI) EvaluateInstancePolicy(ctx context.Context, id string, page, size *int, scope *string) (*ApiPolicyEvaluation, error) {
	params := buildQueryParams("page", page, "size", size, "scope", scope)
	return doJSON[*ApiPolicyEvaluation](&a.baseAPI, ctx, "GET", superadminPath("instance", "policies", id, "evaluate"), nil, params)
}

func (a *PoliciesAPI) ExportInstancePolicies(ctx context.Context) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", superadminPath("instance", "policies", "export"), nil, nil)
}

func (a *PoliciesAPI) ExportInstancePoliciesByIds(ctx context.Context, ids []string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", superadminPath("instance", "policies", "export", "by-ids"), ids, nil)
}
