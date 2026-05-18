package kestra_api_client

import (
	"context"
	"net/url"
	"strings"
)

// FlowsAPI provides methods for managing Kestra flows.
type FlowsAPI struct {
	baseAPI
}

// ========================================================================
// CRUD
// ========================================================================

// CreateFlow creates a new flow from a YAML body.
func (a *FlowsAPI) CreateFlow(ctx context.Context, tenant, yamlBody string) (*FlowWithSource, error) {
	path := tenantPath(tenant, "flows")
	result, err := doJSONWithYAMLBody[FlowWithSource](&a.baseAPI, ctx, "POST", path, yamlBody, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// Flow retrieves a single flow by namespace and id.
func (a *FlowsAPI) Flow(ctx context.Context, namespace, id, tenant string, source *bool, revision *int, allowDeleted *bool) (*FlowWithSource, error) {
	path := tenantPath(tenant, "flows", namespace, id)
	params := buildQueryParams("source", source, "revision", revision, "allowDeleted", allowDeleted)
	result, err := doJSON[FlowWithSource](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// UpdateFlow updates an existing flow from a YAML body.
func (a *FlowsAPI) UpdateFlow(ctx context.Context, namespace, id, tenant, yamlBody string) (*FlowWithSource, error) {
	path := tenantPath(tenant, "flows", namespace, id)
	result, err := doJSONWithYAMLBody[FlowWithSource](&a.baseAPI, ctx, "PUT", path, yamlBody, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DeleteFlow deletes a flow by namespace and id.
func (a *FlowsAPI) DeleteFlow(ctx context.Context, namespace, id, tenant string) error {
	path := tenantPath(tenant, "flows", namespace, id)
	return a.doVoid(ctx, "DELETE", path, nil, nil)
}

// ========================================================================
// Bulk CRUD
// ========================================================================

// BulkUpdateFlows creates or updates multiple flows from a YAML body.
func (a *FlowsAPI) BulkUpdateFlows(ctx context.Context, tenant string, delete *bool, namespace *string, allowNamespaceChild *bool, yamlBody string) ([]FlowInterface, error) {
	path := tenantPath(tenant, "flows", "bulk")
	params := buildQueryParams("delete", delete, "namespace", namespace, "allowNamespaceChild", allowNamespaceChild)
	result, err := doJSONWithYAMLBody[[]FlowInterface](&a.baseAPI, ctx, "POST", path, yamlBody, params)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// DeleteFlowsByIds deletes multiple flows by their ids.
func (a *FlowsAPI) DeleteFlowsByIds(ctx context.Context, tenant string, ids []IdWithNamespace) (*BulkResponse, error) {
	path := tenantPath(tenant, "flows", "delete", "by-ids")
	result, err := doJSON[BulkResponse](&a.baseAPI, ctx, "DELETE", path, ids, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DeleteFlowsByQuery deletes flows matching the given query filters.
func (a *FlowsAPI) DeleteFlowsByQuery(ctx context.Context, tenant string, filters []QueryFilter) (*BulkResponse, error) {
	path := tenantPath(tenant, "flows", "delete", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)
	result, err := doJSON[BulkResponse](&a.baseAPI, ctx, "DELETE", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DisableFlowsByIds disables multiple flows by their ids.
func (a *FlowsAPI) DisableFlowsByIds(ctx context.Context, tenant string, ids []IdWithNamespace) (*BulkResponse, error) {
	path := tenantPath(tenant, "flows", "disable", "by-ids")
	result, err := doJSON[BulkResponse](&a.baseAPI, ctx, "POST", path, ids, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// DisableFlowsByQuery disables flows matching the given query filters.
func (a *FlowsAPI) DisableFlowsByQuery(ctx context.Context, tenant string, filters []QueryFilter) (*BulkResponse, error) {
	path := tenantPath(tenant, "flows", "disable", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)
	result, err := doJSON[BulkResponse](&a.baseAPI, ctx, "POST", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// EnableFlowsByIds enables multiple flows by their ids.
func (a *FlowsAPI) EnableFlowsByIds(ctx context.Context, tenant string, ids []IdWithNamespace) (*BulkResponse, error) {
	path := tenantPath(tenant, "flows", "enable", "by-ids")
	result, err := doJSON[BulkResponse](&a.baseAPI, ctx, "POST", path, ids, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// EnableFlowsByQuery enables flows matching the given query filters.
func (a *FlowsAPI) EnableFlowsByQuery(ctx context.Context, tenant string, filters []QueryFilter) (*BulkResponse, error) {
	path := tenantPath(tenant, "flows", "enable", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)
	result, err := doJSON[BulkResponse](&a.baseAPI, ctx, "POST", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Search & List
// ========================================================================

// SearchFlows searches for flows with pagination, sorting, and filters.
func (a *FlowsAPI) SearchFlows(ctx context.Context, tenant string, page, size *int, sort []string, filters []QueryFilter) (*PagedResultsFlow, error) {
	path := tenantPath(tenant, "flows", "search")
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	result, err := doJSON[PagedResultsFlow](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// SearchFlowsBySourceCode searches flows by their source code content.
func (a *FlowsAPI) SearchFlowsBySourceCode(ctx context.Context, tenant string, page, size *int, sort []string, q, namespace *string) (*PagedResultsSearchResultFlow, error) {
	path := tenantPath(tenant, "flows", "source")
	params := buildQueryParams("page", page, "size", size, "q", q, "namespace", namespace)
	appendRepeatedParam(params, "sort", sort)
	result, err := doJSON[PagedResultsSearchResultFlow](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ListFlowsByNamespace lists all flows in a given namespace.
func (a *FlowsAPI) ListFlowsByNamespace(ctx context.Context, namespace, tenant string) ([]Flow, error) {
	path := tenantPath(tenant, "flows", namespace)
	result, err := doJSON[[]Flow](&a.baseAPI, ctx, "GET", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// ListDistinctNamespaces lists all distinct namespaces that contain flows.
func (a *FlowsAPI) ListDistinctNamespaces(ctx context.Context, tenant string, q *string) ([]string, error) {
	path := tenantPath(tenant, "flows", "distinct-namespaces")
	params := buildQueryParams("q", q)
	result, err := doJSON[[]string](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// ListDeprecated lists flows that contain deprecated tasks.
func (a *FlowsAPI) ListDeprecated(ctx context.Context, tenant string, namespace *string) ([]FlowControllerFlowWithDeprecatedTasks, error) {
	path := tenantPath(tenant, "flows", "deprecated")
	params := buildQueryParams("namespace", namespace)
	result, err := doJSON[[]FlowControllerFlowWithDeprecatedTasks](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// ========================================================================
// Revisions
// ========================================================================

// ListFlowRevisions lists all revisions of a flow.
func (a *FlowsAPI) ListFlowRevisions(ctx context.Context, namespace, id, tenant string, allowDelete *bool) ([]FlowWithSource, error) {
	path := tenantPath(tenant, "flows", namespace, id, "revisions")
	params := buildQueryParams("allowDelete", allowDelete)
	result, err := doJSON[[]FlowWithSource](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// DeleteRevisions deletes specific revisions of a flow.
func (a *FlowsAPI) DeleteRevisions(ctx context.Context, namespace, id, tenant string, revisions []string) error {
	path := tenantPath(tenant, "flows", namespace, id, "revisions")
	params := url.Values{}
	if len(revisions) > 0 {
		params.Set("revisions", strings.Join(revisions, ","))
	}
	return a.doVoid(ctx, "DELETE", path, nil, params)
}

// ========================================================================
// Namespace operations
// ========================================================================

// UpdateFlowsInNamespace creates or updates flows within a namespace from a YAML body.
func (a *FlowsAPI) UpdateFlowsInNamespace(ctx context.Context, namespace, tenant, yamlBody string, delete, override *bool) ([]FlowInterface, error) {
	path := tenantPath(tenant, "flows", namespace)
	params := buildQueryParams("delete", delete, "override", override)
	result, err := doJSONWithYAMLBody[[]FlowInterface](&a.baseAPI, ctx, "POST", path, yamlBody, params)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// ========================================================================
// Export & Import
// ========================================================================

// ExportFlowsByIds exports flows as a ZIP archive by their ids.
func (a *FlowsAPI) ExportFlowsByIds(ctx context.Context, tenant string, ids []IdWithNamespace) ([]byte, error) {
	path := tenantPath(tenant, "flows", "export", "by-ids")
	return a.doDownloadBytes(ctx, "POST", path, ids, nil)
}

// ExportFlowsByQuery exports flows as a ZIP archive matching the given query filters.
func (a *FlowsAPI) ExportFlowsByQuery(ctx context.Context, tenant string, filters []QueryFilter) ([]byte, error) {
	path := tenantPath(tenant, "flows", "export", "by-query")
	params := url.Values{}
	appendFilterParams(params, filters)
	return a.doDownloadBytes(ctx, "GET", path, nil, params)
}

// ImportFlows imports flows from a ZIP file.
func (a *FlowsAPI) ImportFlows(ctx context.Context, tenant string, failOnError *bool, filePath string) ([]string, error) {
	path := tenantPath(tenant, "flows", "import")
	params := buildQueryParams("failOnError", failOnError)
	return doMultipartUpload[[]string](&a.baseAPI, ctx, "POST", path, params, "fileUpload", filePath)
}

// ========================================================================
// Graph & Dependencies
// ========================================================================

// GenerateFlowGraph generates a graph for a flow.
func (a *FlowsAPI) GenerateFlowGraph(ctx context.Context, namespace, id, tenant string, revision *int, subflows []string) (*FlowGraph, error) {
	path := tenantPath(tenant, "flows", namespace, id, "graph")
	params := buildQueryParams("revision", revision)
	appendRepeatedParam(params, "subflows", subflows)
	result, err := doJSON[FlowGraph](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// GenerateFlowGraphFromSource generates a graph from a YAML flow source.
func (a *FlowsAPI) GenerateFlowGraphFromSource(ctx context.Context, tenant, yamlBody string, subflows []string) (*FlowGraph, error) {
	path := tenantPath(tenant, "flows", "graph")
	params := url.Values{}
	appendRepeatedParam(params, "subflows", subflows)
	result, err := doJSONWithYAMLBody[FlowGraph](&a.baseAPI, ctx, "POST", path, yamlBody, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// FlowDependencies retrieves the dependency graph for a specific flow.
func (a *FlowsAPI) FlowDependencies(ctx context.Context, namespace, id, tenant string, destinationOnly, expandAll *bool) (*FlowTopologyGraph, error) {
	path := tenantPath(tenant, "flows", namespace, id, "dependencies")
	params := buildQueryParams("destinationOnly", destinationOnly, "expandAll", expandAll)
	result, err := doJSON[FlowTopologyGraph](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// FlowDependenciesFromNamespace retrieves the dependency graph for all flows in a namespace.
func (a *FlowsAPI) FlowDependenciesFromNamespace(ctx context.Context, namespace, tenant string, destinationOnly *bool) (*FlowTopologyGraph, error) {
	path := tenantPath(tenant, "namespaces", namespace, "dependencies")
	params := buildQueryParams("destinationOnly", destinationOnly)
	result, err := doJSON[FlowTopologyGraph](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Tasks
// ========================================================================

// TaskFromFlow retrieves a specific task from a flow.
func (a *FlowsAPI) TaskFromFlow(ctx context.Context, namespace, id, taskId, tenant string, revision *int) (*Task, error) {
	path := tenantPath(tenant, "flows", namespace, id, "tasks", taskId)
	params := buildQueryParams("revision", revision)
	result, err := doJSON[Task](&a.baseAPI, ctx, "GET", path, nil, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Concurrency
// ========================================================================

// SearchConcurrencyLimits searches for concurrency limits.
func (a *FlowsAPI) SearchConcurrencyLimits(ctx context.Context, tenant string) (*PagedResultsConcurrencyLimit, error) {
	path := tenantPath(tenant, "concurrency-limit", "search")
	result, err := doJSON[PagedResultsConcurrencyLimit](&a.baseAPI, ctx, "GET", path, nil, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// UpdateConcurrencyLimit updates a concurrency limit for a flow.
func (a *FlowsAPI) UpdateConcurrencyLimit(ctx context.Context, namespace, flowId, tenant string, limit ConcurrencyLimit) (*ConcurrencyLimit, error) {
	path := tenantPath(tenant, "concurrency-limit", namespace, flowId)
	result, err := doJSON[ConcurrencyLimit](&a.baseAPI, ctx, "PUT", path, limit, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Validation
// ========================================================================

// ValidateFlows validates flows from a YAML body.
func (a *FlowsAPI) ValidateFlows(ctx context.Context, tenant, yamlBody string) ([]ValidateConstraintViolation, error) {
	path := tenantPath(tenant, "flows", "validate")
	result, err := doJSONWithYAMLBody[[]ValidateConstraintViolation](&a.baseAPI, ctx, "POST", path, yamlBody, nil)
	if err != nil {
		return nil, err
	}
	return result, nil
}

// ValidateTask validates a task definition.
func (a *FlowsAPI) ValidateTask(ctx context.Context, section, tenant string, body interface{}) (*ValidateConstraintViolation, error) {
	path := tenantPath(tenant, "flows", "validate", "task")
	params := buildQueryParams("section", section)
	result, err := doJSON[ValidateConstraintViolation](&a.baseAPI, ctx, "POST", path, body, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ValidateTrigger validates a trigger definition.
func (a *FlowsAPI) ValidateTrigger(ctx context.Context, tenant string, body interface{}) (*ValidateConstraintViolation, error) {
	path := tenantPath(tenant, "flows", "validate", "trigger")
	result, err := doJSON[ValidateConstraintViolation](&a.baseAPI, ctx, "POST", path, body, nil)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// ========================================================================
// Expressions
// ========================================================================

// Expressions retrieves the expression context for a flow.
func (a *FlowsAPI) Expressions(ctx context.Context, tenant, yamlBody string, taskId *string) (*ExpressionContext, error) {
	path := tenantPath(tenant, "flows", "expressions")
	params := buildQueryParams("taskId", taskId)
	result, err := doJSONWithYAMLBody[ExpressionContext](&a.baseAPI, ctx, "POST", path, yamlBody, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}
