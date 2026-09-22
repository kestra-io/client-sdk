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

// CreateFlowFromObject creates a new flow from a native object (a *Flow / Flow
// value, or a map). The object is serialized to a YAML source string
// client-side (the write endpoint is YAML-only). draft is forwarded as a query
// parameter (never a body field); pass nil to leave it unset.
func (a *FlowsAPI) CreateFlowFromObject(ctx context.Context, tenant string, flow interface{}, draft *bool) (*FlowWithSource, error) {
	yamlBody, err := flowToYAML(flow)
	if err != nil {
		return nil, err
	}
	path := tenantPath(tenant, "flows")
	params := buildQueryParams("draft", draft)
	result, err := doJSONWithYAMLBody[FlowWithSource](&a.baseAPI, ctx, "POST", path, yamlBody, params)
	if err != nil {
		return nil, err
	}
	return &result, nil
}

// UpdateFlowFromObject updates an existing flow from a native object (a *Flow /
// Flow value, or a map). The object is serialized to a YAML source string
// client-side (the write endpoint is YAML-only). draft is forwarded as a query
// parameter (never a body field); pass nil to leave it unset.
func (a *FlowsAPI) UpdateFlowFromObject(ctx context.Context, namespace, id, tenant string, flow interface{}, draft *bool) (*FlowWithSource, error) {
	yamlBody, err := flowToYAML(flow)
	if err != nil {
		return nil, err
	}
	path := tenantPath(tenant, "flows", namespace, id)
	params := buildQueryParams("draft", draft)
	result, err := doJSONWithYAMLBody[FlowWithSource](&a.baseAPI, ctx, "PUT", path, yamlBody, params)
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
func (a *FlowsAPI) DeleteFlowsByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*BulkResponse, error) {
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
func (a *FlowsAPI) DisableFlowsByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*BulkResponse, error) {
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
func (a *FlowsAPI) EnableFlowsByQuery(ctx context.Context, tenant string, filters []SearchFilter) (*BulkResponse, error) {
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
func (a *FlowsAPI) SearchFlows(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (*PagedResultsFlow, error) {
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

// SearchFlowsBySourceCode searches flows by their source code content. Each hit
// is a flat SourceSearchResult carrying the matching lines, not the flow itself.
func (a *FlowsAPI) SearchFlowsBySourceCode(ctx context.Context, tenant string, page, size *int, sort []string, q, namespace *string, caseSensitive, wholeWord, regex *bool, scope *SourceSearchScope) (*PagedResultsSourceSearchResult, error) {
	path := tenantPath(tenant, "flows", "source")
	params := buildQueryParams("page", page, "size", size, "q", q, "namespace", namespace,
		"caseSensitive", caseSensitive, "wholeWord", wholeWord, "regex", regex, "scope", scope)
	appendRepeatedParam(params, "sort", sort)
	result, err := doJSON[PagedResultsSourceSearchResult](&a.baseAPI, ctx, "GET", path, nil, params)
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
func (a *FlowsAPI) ExportFlowsByQuery(ctx context.Context, tenant string, filters []SearchFilter) ([]byte, error) {
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

// ========================================================================
// CSV export
// ========================================================================

// ExportFlowsByQueryCsv exports all flows matching the given filters as a CSV
// document. Backs GET /api/v1/{tenant}/flows/export/by-query/csv.
func (a *FlowsAPI) ExportFlowsByQueryCsv(ctx context.Context, tenant string, filters []SearchFilter) (string, error) {
	path := tenantPath(tenant, "flows", "export", "by-query", "csv")
	params := url.Values{}
	appendFilterParams(params, filters)
	return a.doText(ctx, "GET", path, params, contentCSV)
}

// ========================================================================
// Source-search replace
// ========================================================================

// PreviewReplaceBySourceCode computes matched lines and their proposed replacement
// for every matching flow without persisting anything. Backs
// POST /api/v1/{tenant}/flows/source/replace/preview.
func (a *FlowsAPI) PreviewReplaceBySourceCode(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", "source", "replace", "preview")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", path, body, nil)
}

// ApplyReplaceBySourceCode replaces every match in the given flows and persists the
// new revisions. Backs POST /api/v1/{tenant}/flows/source/replace/apply.
func (a *FlowsAPI) ApplyReplaceBySourceCode(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", "source", "replace", "apply")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", path, body, nil)
}

// ReplaceLineBySourceCode replaces the matches on one line of one flow and persists
// the new revision. Backs POST /api/v1/{tenant}/flows/source/replace/line.
func (a *FlowsAPI) ReplaceLineBySourceCode(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", "source", "replace", "line")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", path, body, nil)
}

// ========================================================================
// Drift detection (EE)
// ========================================================================

// FlowHashesByIds batch-computes source hashes for flows by id (drift detection).
// Backs POST /api/v1/{tenant}/flows/hashes/by-ids.
func (a *FlowsAPI) FlowHashesByIds(ctx context.Context, tenant string, ids []IdWithNamespace) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", "hashes", "by-ids")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", path, ids, nil)
}

// ========================================================================
// Governance policies (EE)
// ========================================================================

// PreviewPolicies previews the governance policy effects (mutations + violations) on
// a flow source. Backs POST /api/v1/{tenant}/flows/policies/preview.
func (a *FlowsAPI) PreviewPolicies(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", "policies", "preview")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", path, body, nil)
}

// ========================================================================
// Promotions (EE)
// ========================================================================

// Promote promotes a flow to one or more SERVER-mode targets. Backs
// POST /api/v1/{tenant}/flows/{namespace}/{id}/promote.
func (a *FlowsAPI) Promote(ctx context.Context, namespace, id, tenant string, body interface{}) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", namespace, id, "promote")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", path, body, nil)
}

// PromoteByIds promotes flows by their ids to one or more SERVER-mode targets. Backs
// POST /api/v1/{tenant}/flows/promote/by-ids.
func (a *FlowsAPI) PromoteByIds(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", "promote", "by-ids")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", path, body, nil)
}

// ReportPromote reports a CLIENT-mode promote performed by the browser. Backs
// POST /api/v1/{tenant}/flows/{namespace}/{id}/promotions.
func (a *FlowsAPI) ReportPromote(ctx context.Context, namespace, id, tenant string, body interface{}) error {
	path := tenantPath(tenant, "flows", namespace, id, "promotions")
	return a.doVoidJSON(ctx, "POST", path, body, nil)
}

// ListPromotions lists a flow's promotion history. Backs
// GET /api/v1/{tenant}/flows/{namespace}/{id}/promotions.
func (a *FlowsAPI) ListPromotions(ctx context.Context, namespace, id, tenant string, page, size *int, sort []string) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", namespace, id, "promotions")
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", path, nil, params)
}

// PromoteDiff recomputes the diff of a past promote from its audit record. Backs
// GET /api/v1/{tenant}/flows/{namespace}/{id}/promotions/{auditId}/diff.
func (a *FlowsAPI) PromoteDiff(ctx context.Context, namespace, id, auditId, tenant string) (map[string]interface{}, error) {
	path := tenantPath(tenant, "flows", namespace, id, "promotions", auditId, "diff")
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", path, nil, nil)
}
