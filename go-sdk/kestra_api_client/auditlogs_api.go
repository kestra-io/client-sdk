package kestra_api_client

import "context"

// AuditLogsAPI covers /api/v1/{tenant}/auditlogs and the instance-owner
// cross-tenant variants under /api/v1/auditlogs. The controller is gated by the
// AUDITLOG resource plus a license feature, so routes answer 403 otherwise.
type AuditLogsAPI struct {
	baseAPI
}

// SearchAuditLogs returns a page of a tenant's audit log. Backs GET
// /api/v1/{tenant}/auditlogs/search.
func (a *AuditLogsAPI) SearchAuditLogs(ctx context.Context, tenant string, page, size *int, sort []string, filters []SearchFilter) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "auditlogs", "search"), nil, params)
}

// SearchAllAuditLogs returns a page of the audit log across every tenant
// (instance-owner only). Backs GET /api/v1/auditlogs/search.
func (a *AuditLogsAPI) SearchAllAuditLogs(ctx context.Context, page, size *int, sort []string, filters []SearchFilter) (map[string]interface{}, error) {
	params := buildQueryParams("page", page, "size", size)
	appendRepeatedParam(params, "sort", sort)
	appendFilterParams(params, filters)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("auditlogs", "search"), nil, params)
}

// ExportAuditLogs streams a tenant's audit log as CSV. Backs GET
// /api/v1/{tenant}/auditlogs/export.
func (a *AuditLogsAPI) ExportAuditLogs(ctx context.Context, tenant string, filters []SearchFilter) (string, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return a.doText(ctx, "GET", tenantPath(tenant, "auditlogs", "export"), params, contentCSV)
}

// ExportAllAuditLogs streams the cross-tenant audit log as CSV (instance-owner
// only). Backs GET /api/v1/auditlogs/export.
func (a *AuditLogsAPI) ExportAllAuditLogs(ctx context.Context, filters []SearchFilter) (string, error) {
	params := buildQueryParams()
	appendFilterParams(params, filters)
	return a.doText(ctx, "GET", superadminPath("auditlogs", "export"), params, contentCSV)
}

// AuditLogDiff returns the before/after diff captured by an audit-log entry.
// `previousId` is optional. Backs GET /api/v1/{tenant}/auditlogs/{id}/diff.
func (a *AuditLogsAPI) AuditLogDiff(ctx context.Context, id, tenant string, previousId *string) (map[string]interface{}, error) {
	params := buildQueryParams("previousId", previousId)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "auditlogs", id, "diff"), nil, params)
}

// GlobalAuditLogDiff returns the diff for a global (non-tenant) resource audit
// entry (instance-owner only). Backs GET /api/v1/auditlogs/{id}/diff.
func (a *AuditLogsAPI) GlobalAuditLogDiff(ctx context.Context, id string, previousId *string) (map[string]interface{}, error) {
	params := buildQueryParams("previousId", previousId)
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "GET", superadminPath("auditlogs", id, "diff"), nil, params)
}

// FindAuditLog finds a single audit-log entry matching a resource/action/detail
// query. `body` is a FindRequest ({resource, type?, detail}). Backs POST
// /api/v1/{tenant}/auditlogs/find.
func (a *AuditLogsAPI) FindAuditLog(ctx context.Context, tenant string, body interface{}) (map[string]interface{}, error) {
	return doJSON[map[string]interface{}](&a.baseAPI, ctx, "POST", tenantPath(tenant, "auditlogs", "find"), body, nil)
}

// AuditLogHistory lists the audit-log entries recorded for a single resource id.
// Backs GET /api/v1/{tenant}/auditlogs/history/{detailId}.
func (a *AuditLogsAPI) AuditLogHistory(ctx context.Context, detailId, tenant string) ([]map[string]interface{}, error) {
	return doJSON[[]map[string]interface{}](&a.baseAPI, ctx, "GET", tenantPath(tenant, "auditlogs", "history", detailId), nil, nil)
}
