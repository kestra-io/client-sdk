package kestra_api_client

import "context"

// InstanceAPI covers the instance-level /api/v1/instance routes for services
// and maintenance. Every endpoint requires the caller to be an instance owner
// and is not tenant-scoped.
type InstanceAPI struct {
	baseAPI
}

// SearchServices returns a page of the running service instances. The optional
// filters use the SERVICE_INSTANCE query filter format.
func (a *InstanceAPI) SearchServices(ctx context.Context, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsInstanceControllerApiServiceInstance, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsInstanceControllerApiServiceInstance](&a.baseAPI, ctx, "GET", superadminPath("instance", "services", "search"), nil, params)
}

// ActiveServices returns the per-type counts of the currently active services.
func (a *InstanceAPI) ActiveServices(ctx context.Context) (*InstanceControllerApiActiveServiceList, error) {
	return doJSON[*InstanceControllerApiActiveServiceList](&a.baseAPI, ctx, "GET", superadminPath("instance", "services", "active"), nil, nil)
}

// Service returns a single service instance by id.
func (a *InstanceAPI) Service(ctx context.Context, id string) (*ServiceInstance, error) {
	return doJSON[*ServiceInstance](&a.baseAPI, ctx, "GET", superadminPath("instance", "services", id), nil, nil)
}

// MaintenanceStatus reports whether maintenance mode is enabled and whether the
// instance has reached a state that is safe to update.
func (a *InstanceAPI) MaintenanceStatus(ctx context.Context) (*MaintenanceStatusResponse, error) {
	return doJSON[*MaintenanceStatusResponse](&a.baseAPI, ctx, "GET", superadminPath("instance", "maintenance", "status"), nil, nil)
}

// ListAllMcpServers returns a page of the MCP servers across every tenant, each
// tagged with its owning tenant id.
func (a *InstanceAPI) ListAllMcpServers(ctx context.Context, page, size *int, sort []string) (*PagedResultsApiInstanceMcpServer, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[*PagedResultsApiInstanceMcpServer](&a.baseAPI, ctx, "GET", superadminPath("instance", "mcp-servers"), nil, params)
}

// ListVersionedPlugins returns a page of the installed versioned plugins.
// Requires plugin management to be enabled on the instance.
func (a *InstanceAPI) ListVersionedPlugins(ctx context.Context, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsApiPluginArtifact, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	if err := appendFilterParams(params, filters); err != nil {
		return nil, err
	}
	return doJSON[*PagedResultsApiPluginArtifact](&a.baseAPI, ctx, "GET", superadminPath("instance", "versioned-plugins"), nil, params)
}

// ListAvailableVersionedPlugins returns every plugin that can be installed.
func (a *InstanceAPI) ListAvailableVersionedPlugins(ctx context.Context) (*ApiAvailablePluginList, error) {
	return doJSON[*ApiAvailablePluginList](&a.baseAPI, ctx, "GET", superadminPath("instance", "versioned-plugins", "available"), nil, nil)
}

// ListAvailableVersionedPluginsForStorage returns the installable storage plugins.
func (a *InstanceAPI) ListAvailableVersionedPluginsForStorage(ctx context.Context) (*ApiAvailablePluginList, error) {
	return doJSON[*ApiAvailablePluginList](&a.baseAPI, ctx, "GET", superadminPath("instance", "versioned-plugins", "available", "storages"), nil, nil)
}

// ListAvailableVersionedPluginsForSecretManager returns the installable secret-manager plugins.
func (a *InstanceAPI) ListAvailableVersionedPluginsForSecretManager(ctx context.Context) (*ApiAvailablePluginList, error) {
	return doJSON[*ApiAvailablePluginList](&a.baseAPI, ctx, "GET", superadminPath("instance", "versioned-plugins", "available", "secrets-managers"), nil, nil)
}
