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

func (a *NamespacesAPI) SearchNamespaces(ctx context.Context, tenant string, q *string, page, size *int, sort []string, existing *bool) (*PagedResultsNamespace, error) {
	params := buildQueryParams("page", page, "size", size, "existing", existing)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, appendStringFilter(nil, FilterQuery, q))
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

func (a *NamespacesAPI) InheritedVariables(ctx context.Context, id, tenant string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", id, "inherited-variables"), nil, nil)
}

func (a *NamespacesAPI) InheritedPluginDefaults(ctx context.Context, id, tenant string) ([]NamespaceControllerApiInheritedPluginDefaultFromNamespace, error) {
	return doJSON[[]NamespaceControllerApiInheritedPluginDefaultFromNamespace](&a.baseAPI, ctx, "GET", tenantPath(tenant, "namespaces", id, "inherited-plugindefaults"), nil, nil)
}

func (a *NamespacesAPI) ExportPluginDefaults(ctx context.Context, id, tenant string) ([]byte, error) {
	return a.doDownloadBytes(ctx, "POST", tenantPath(tenant, "namespaces", id, "plugindefaults", "export"), nil, nil)
}

func (a *NamespacesAPI) ImportPluginDefaults(ctx context.Context, id, tenant, filePath string) ([]string, error) {
	return doMultipartUpload[[]string](&a.baseAPI, ctx, "POST", tenantPath(tenant, "namespaces", id, "plugindefaults", "import"), nil, "fileUpload", filePath)
}

