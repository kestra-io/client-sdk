package kestra_api_client

import "context"

type NamespacesAPI struct {
	baseAPI
}

func (a *NamespacesAPI) CreateNamespace(ctx context.Context, tenant string, namespace Namespace) (*Namespace, error) {
	return doJSON[*Namespace](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces"), namespace, nil)
}

func (a *NamespacesAPI) Namespace(ctx context.Context, id, tenant string) (*Namespace, error) {
	return doJSON[*Namespace](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", id), nil, nil)
}

func (a *NamespacesAPI) UpdateNamespace(ctx context.Context, id, tenant string, namespace Namespace) (*Namespace, error) {
	return doJSON[*Namespace](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "namespaces", id), namespace, nil)
}

func (a *NamespacesAPI) DeleteNamespace(ctx context.Context, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "namespaces", id), nil, nil)
}

func (a *NamespacesAPI) SearchNamespaces(ctx context.Context, tenant string, q *string, page, size *int, sort []string, existing *bool, filters []SearchFilter) (*PagedResultsNamespace, error) {
	params := buildQueryParams("page", page, "size", size, "existing", existing)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, appendStringFilter(filters, FilterQuery, q)); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsNamespace](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", "search"), nil, params)
}

func (a *NamespacesAPI) AutocompleteNamespaces(ctx context.Context, tenant string, request interface{}) ([]string, error) {
	return doJSON[[]string](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", "autocomplete"), request, nil)
}

func (a *NamespacesAPI) PutSecrets(ctx context.Context, namespace, tenant string, secretValue ApiSecretValue) ([]ApiSecretMetaEE, error) {
	return doJSON[[]ApiSecretMetaEE](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "secrets"), secretValue, nil)
}

func (a *NamespacesAPI) PatchSecret(ctx context.Context, namespace, key, tenant string, meta interface{}) ([]ApiSecretMetaEE, error) {
	return doJSON[[]ApiSecretMetaEE](&a.baseAPI, ctx, "PATCH", tenantPath(tenant, "namespaces", namespace, "secrets", key), meta, nil)
}

func (a *NamespacesAPI) DeleteSecret(ctx context.Context, namespace, key, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "secrets", key), nil, nil)
}

func (a *NamespacesAPI) InheritedSecrets(ctx context.Context, namespace, tenant string) (map[string][]string, error) {
	return doJSON[map[string][]string](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "inherited-secrets"), nil, nil)
}

// ListSecrets lists secrets across all namespaces. Backs GET /api/v1/{tenant}/secrets
// (SecretController.listSecrets). The endpoint requires at least one filter; pass a
// namespace EQUALS filter to scope the results, or use ListNamespaceSecrets.
func (a *NamespacesAPI) ListSecrets(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*ApiSecretListResponseApiSecretMeta, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[*ApiSecretListResponseApiSecretMeta](&a.baseAPI, ctx, "GET", tenantPath(tenant, "secrets"), nil, params)
}

// ListNamespaceSecrets lists the secrets of a namespace. Backs GET /api/v1/{tenant}/secrets
// with filters[namespace][EQUALS]=<namespace>; the former GET
// /api/v1/{tenant}/namespaces/{namespace}/secrets was removed in Kestra 2.0 (removed routes
// answer 403). For secrets inherited from parent namespaces, use InheritedSecrets.
func (a *NamespacesAPI) ListNamespaceSecrets(ctx context.Context, namespace, tenant string, page, size *int, sort []string, filters []SearchFilter) (*ApiSecretListResponseApiSecretMeta, error) {
	// Copy the caller's filters so the appended namespace filter never mutates their slice.
	scoped := make([]SearchFilter, 0, len(filters)+1)
	scoped = append(scoped, filters...)
	scoped = append(scoped, SearchFilter{Field: FilterNamespace, Operation: OpEquals, Value: namespace})
	return a.ListSecrets(ctx, tenant, page, size, sort, scoped)
}

func (a *NamespacesAPI) InheritedVariables(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", id, "inherited-variables"), nil, nil)
}

// --- Namespace credentials (NamespaceCredentialController) ---

// NamespaceCredentials lists credentials in a namespace. Backs GET /api/v1/{tenant}/namespaces/{namespace}/credentials.
func (a *NamespacesAPI) NamespaceCredentials(ctx context.Context, namespace, tenant string, page, size *int, sort []string, filters []SearchFilter) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "credentials"), nil, params)
}

// InheritedNamespaceCredentials returns credentials inherited from parent namespaces. Backs GET /api/v1/{tenant}/namespaces/{namespace}/credentials/inherited.
func (a *NamespacesAPI) InheritedNamespaceCredentials(ctx context.Context, namespace, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "credentials", "inherited"), nil, nil)
}

// NamespaceCredential gets a credential by name in a namespace. Backs GET /api/v1/{tenant}/namespaces/{namespace}/credentials/{name}.
func (a *NamespacesAPI) NamespaceCredential(ctx context.Context, namespace, name, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "credentials", name), nil, nil)
}

// CreateNamespaceCredential creates a credential in a namespace. Backs POST /api/v1/{tenant}/namespaces/{namespace}/credentials.
func (a *NamespacesAPI) CreateNamespaceCredential(ctx context.Context, namespace, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", namespace, "credentials"), body, nil)
}

// UpdateNamespaceCredential updates a credential in a namespace. Backs PUT /api/v1/{tenant}/namespaces/{namespace}/credentials/{name}.
func (a *NamespacesAPI) UpdateNamespaceCredential(ctx context.Context, namespace, name, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "credentials", name), body, nil)
}

// DeleteNamespaceCredential deletes a credential from a namespace. Backs DELETE /api/v1/{tenant}/namespaces/{namespace}/credentials/{name}.
func (a *NamespacesAPI) DeleteNamespaceCredential(ctx context.Context, namespace, name, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "credentials", name), nil, nil)
}

// TestNamespaceCredential tests a credential connection. Backs POST /api/v1/{tenant}/namespaces/{namespace}/credentials/{name}/test.
func (a *NamespacesAPI) TestNamespaceCredential(ctx context.Context, namespace, name, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", namespace, "credentials", name, "test"), nil, nil)
}

// --- Namespace KV detail (KVController) ---

// NamespaceKvDetail returns the advanced detail of a KV entry. Backs GET /api/v1/{tenant}/namespaces/{namespace}/kv/{key}/detail.
func (a *NamespacesAPI) NamespaceKvDetail(ctx context.Context, namespace, key, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "kv", key, "detail"), nil, nil)
}

// --- Namespace-scoped policies (PolicyController) ---

// SearchNamespacePolicies searches the policies applying to a namespace. Backs GET /api/v1/{tenant}/namespaces/{namespace}/policies/search.
func (a *NamespacesAPI) SearchNamespacePolicies(ctx context.Context, namespace, tenant string, page, size *int, filters []SearchFilter) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendFilterParams(params, filters)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "policies", "search"), nil, params)
}

// NamespacePolicy gets a namespace-scope policy. Backs GET /api/v1/{tenant}/namespaces/{namespace}/policies/{id}.
func (a *NamespacesAPI) NamespacePolicy(ctx context.Context, namespace, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "policies", id), nil, nil)
}

// EvaluateNamespacePolicy dry-runs a namespace-scope policy against every flow in its scope. Backs GET /api/v1/{tenant}/namespaces/{namespace}/policies/{id}/evaluate.
func (a *NamespacesAPI) EvaluateNamespacePolicy(ctx context.Context, namespace, id, tenant string, page, size *int) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", namespace, "policies", id, "evaluate"), nil, params)
}

// CreateNamespacePolicy creates a namespace-scope policy from its YAML source. Backs POST /api/v1/{tenant}/namespaces/{namespace}/policies.
func (a *NamespacesAPI) CreateNamespacePolicy(ctx context.Context, namespace, tenant, source string) (map[string]interface{}, error) {
	return doJSONWithYAMLBody[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies"), source, nil)
}

// UpdateNamespacePolicy updates a namespace-scope policy from its YAML source. Backs PUT /api/v1/{tenant}/namespaces/{namespace}/policies/{id}.
func (a *NamespacesAPI) UpdateNamespacePolicy(ctx context.Context, namespace, id, tenant, source string) (map[string]interface{}, error) {
	return doJSONWithYAMLBody[map[string]interface{}](&a.baseAPI, ctx, "PUT", tenantPath(tenant, "namespaces", namespace, "policies", id), source, nil)
}

// ValidateNamespacePolicy validates a namespace-scope policy YAML source without persisting it. Backs POST /api/v1/{tenant}/namespaces/{namespace}/policies/validate.
func (a *NamespacesAPI) ValidateNamespacePolicy(ctx context.Context, namespace, tenant, source string) (map[string]interface{}, error) {
	return doJSONWithYAMLBody[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies", "validate"), source, nil)
}

// DeleteNamespacePolicy deletes a namespace-scope policy. Backs DELETE /api/v1/{tenant}/namespaces/{namespace}/policies/{id}.
func (a *NamespacesAPI) DeleteNamespacePolicy(ctx context.Context, namespace, id, tenant string) error {
	return a.doVoidJSON(ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "policies", id), nil, nil)
}

// DeleteNamespacePoliciesByIds deletes namespace-scope policies by their IDs. Backs DELETE /api/v1/{tenant}/namespaces/{namespace}/policies/delete/by-ids.
func (a *NamespacesAPI) DeleteNamespacePoliciesByIds(ctx context.Context, namespace, tenant string, ids []string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "DELETE", tenantPath(tenant, "namespaces", namespace, "policies", "delete", "by-ids"), ids, nil)
}

// ExportNamespacePolicies exports every namespace-scope policy as YAML documents joined by '---'. Backs POST /api/v1/{tenant}/namespaces/{namespace}/policies/export.
func (a *NamespacesAPI) ExportNamespacePolicies(ctx context.Context, namespace, tenant string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies", "export"), nil, nil)
}

// ExportNamespacePoliciesByIds exports namespace-scope policies by their IDs as YAML documents joined by '---'. Backs POST /api/v1/{tenant}/namespaces/{namespace}/policies/export/by-ids.
func (a *NamespacesAPI) ExportNamespacePoliciesByIds(ctx context.Context, namespace, tenant string, ids []string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "namespaces", namespace, "policies", "export", "by-ids"), ids, nil)
}
