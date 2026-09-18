package kestra_api_client

import "context"

// PluginsAPI covers the instance-level /api/v1/plugins routes exposing the
// installed plugin catalog: documentation, JSON schemas, icons, input types and
// the OSS auto-install flow. None of these routes are tenant-scoped.
type PluginsAPI struct {
	baseAPI
}

// List returns the catalog of installed plugins. Backs GET /api/v1/plugins.
func (a *PluginsAPI) List(ctx context.Context, page, size *int, sort []string) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins"), nil, params)
}

// ListBySubgroups returns the plugins expanded one entry per subgroup.
// Backs GET /api/v1/plugins/groups/subgroups.
func (a *PluginsAPI) ListBySubgroups(ctx context.Context) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "groups", "subgroups"), nil, nil)
}

// Icons returns the icon metadata index keyed by plugin class name.
// Backs GET /api/v1/plugins/icons.
func (a *PluginsAPI) Icons(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "icons"), nil, nil)
}

// GroupIcons returns the icon metadata index for plugin groups and subgroups.
// Backs GET /api/v1/plugins/icons/groups.
func (a *PluginsAPI) GroupIcons(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "icons", "groups"), nil, nil)
}

// Icon returns the icon metadata for a single plugin class.
// Backs GET /api/v1/plugins/icons/{cls}.
func (a *PluginsAPI) Icon(ctx context.Context, cls string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "icons", cls), nil, nil)
}

// IconSvg returns the raw SVG bytes of a single plugin icon as text.
// Backs GET /api/v1/plugins/icons/{cls}/icon.svg.
func (a *PluginsAPI) IconSvg(ctx context.Context, cls string) (string, error) {
	return a.doText(ctx, "GET", superadminPath("plugins", "icons", cls, "icon.svg"), nil, "image/svg+xml")
}

// InputTypes returns every available flow input type.
// Backs GET /api/v1/plugins/inputs.
func (a *PluginsAPI) InputTypes(ctx context.Context) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "inputs"), nil, nil)
}

// InputSchema returns the documentation and JSON schema for an input type.
// Backs GET /api/v1/plugins/inputs/{type}.
func (a *PluginsAPI) InputSchema(ctx context.Context, inputType string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "inputs", inputType), nil, nil)
}

// InstallJob returns the status of an async plugin installation job (OSS only).
// Backs GET /api/v1/plugins/install/{jobId}.
func (a *PluginsAPI) InstallJob(ctx context.Context, jobId string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "install", jobId), nil, nil)
}

// Properties returns the properties part of the JSON schema for a schema type.
// Backs GET /api/v1/plugins/properties/{type}.
func (a *PluginsAPI) Properties(ctx context.Context, schemaType string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "properties", schemaType), nil, nil)
}

// Schema returns the JSON schema for a schema type (FLOW, TASK, TRIGGER, ...).
// Backs GET /api/v1/plugins/schemas/{type}.
func (a *PluginsAPI) Schema(ctx context.Context, schemaType string, arrayOf, includeCatalog *bool) (map[string]interface{}, error) {
	params := buildQueryParams("arrayOf", arrayOf, "includeCatalog", includeCatalog)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "schemas", schemaType), nil, params)
}

// Triggers returns the trigger plugin catalog grouped by category.
// Backs GET /api/v1/plugins/triggers.
func (a *PluginsAPI) Triggers(ctx context.Context) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", "triggers"), nil, nil)
}

// Documentation returns the documentation and schema for a plugin class.
// Backs GET /api/v1/plugins/{cls}.
func (a *PluginsAPI) Documentation(ctx context.Context, cls string, allProperties *bool) (map[string]interface{}, error) {
	params := buildQueryParams("all", allProperties)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", cls), nil, params)
}

// PluginUi serves a plugin UI resource file for a plugin group.
// Backs GET /api/v1/plugins/{group}/pluginUi/{path}.
func (a *PluginsAPI) PluginUi(ctx context.Context, group, path string) (string, error) {
	return a.doText(ctx, "GET", superadminPath("plugins", group, "pluginUi", path), nil)
}

// Versions returns all installed versions for a plugin type.
// Backs GET /api/v1/plugins/{cls}/versions.
func (a *PluginsAPI) Versions(ctx context.Context, cls string) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", cls, "versions"), nil, nil)
}

// DocumentationForVersion returns the documentation and schema for a plugin
// class at a specific version. Backs GET /api/v1/plugins/{cls}/versions/{version}.
func (a *PluginsAPI) DocumentationForVersion(ctx context.Context, cls, version string, allProperties *bool) (map[string]interface{}, error) {
	params := buildQueryParams("all", allProperties)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("plugins", cls, "versions", version), nil, params)
}

// DetectMissingPlugins parses a flow YAML and maps its unregistered task and
// trigger types to their Maven artifacts (OSS only; EE returns 403).
// Backs POST /api/v1/plugins/auto-install/detect.
func (a *PluginsAPI) DetectMissingPlugins(ctx context.Context, flowYaml string) (map[string]interface{}, error) {
	return doJSONWithTextBody[map[string]interface{}](&a.baseAPI, ctx, "POST", superadminPath("plugins", "auto-install", "detect"), flowYaml, nil)
}

// Install enqueues installation of the given plugin artifacts and returns the
// install job (OSS only; EE returns 403). Backs POST /api/v1/plugins/install.
func (a *PluginsAPI) Install(ctx context.Context, artifacts interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", superadminPath("plugins", "install"), artifacts, nil)
}

// PluginUiManifest resolves the plugin UI manifest for the given tasks.
// Backs POST /api/v1/plugins/pluginUiManifest.
func (a *PluginsAPI) PluginUiManifest(ctx context.Context, taskWithVersions interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", superadminPath("plugins", "pluginUiManifest"), taskWithVersions, nil)
}
