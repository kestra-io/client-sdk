package kestra_api_client

import (
	"fmt"
	"net/url"
	"strings"
	"time"
)

// Search-endpoint compatibility across Kestra versions.
//
// The `filters` query array (filters[field][op]=value) was added per endpoint at
// different Kestra versions, so each search method in this SDK is shaped to match
// what BOTH targeted versions (currently 1.3 and 2.x) understand. The rule:
// only make a search method filters-only when the 1.3 controller for that
// endpoint already accepts `filters`; otherwise 1.3 silently drops the unknown
// query params and returns unfiltered results (no error).
//
//	endpoint      SDK sends                     1.3                          2.x
//	------------  ----------------------------  ---------------------------  ---------------------------
//	logs          filters only                  filters + deprecated legacy  filters + deprecated legacy
//	apps          legacy q/ns/flowId + filters  legacy params                legacy + filters
//	namespaces    q only                        q only                       q only
//	blueprints    q only                        q only                       q only
//	invitations   email/status (+ filters)      email/status only            filters + deprecated email/status
//
// When 1.3 support is eventually dropped, the hybrid/legacy methods can move to
// filters-only and the deprecated params can be removed.
type SearchFilterField string

const (
	FilterQuery     SearchFilterField = "q"
	FilterNamespace SearchFilterField = "namespace"
	FilterFlowId    SearchFilterField = "flowId"
	FilterState     SearchFilterField = "state"
	FilterLabels    SearchFilterField = "labels"
	FilterCreated   SearchFilterField = "created"
	FilterUpdated   SearchFilterField = "updated"
	FilterStartDate SearchFilterField = "startDate"
	FilterEndDate   SearchFilterField = "endDate"
	FilterTimeRange SearchFilterField = "timeRange"
	FilterScope     SearchFilterField = "scope"
	FilterAssetId   SearchFilterField = "assetId"
	FilterParentId  SearchFilterField = "childFilter"
	FilterTaskId    SearchFilterField = "taskId"
	FilterUserId    SearchFilterField = "userId"
	FilterAction    SearchFilterField = "action"
	FilterDetails   SearchFilterField = "details"
	FilterMinLevel  SearchFilterField = "minLevel"
	FilterTriggerId SearchFilterField = "triggerId"
	FilterExisting  SearchFilterField = "existing"
	FilterKey       SearchFilterField = "key"
	FilterResource  SearchFilterField = "resource"

	FilterTags          SearchFilterField = "tags"
	FilterTaskRunId     SearchFilterField = "taskRunId"
	FilterAttemptNumber SearchFilterField = "attemptNumber"

	FilterEmail      SearchFilterField = "email"
	FilterStatus     SearchFilterField = "status"
	FilterExpiredAt  SearchFilterField = "expired_at"
	FilterSuperAdmin SearchFilterField = "super_admin"
)

type SearchFilterOp string

const (
	OpEquals               SearchFilterOp = "EQUALS"
	OpNotEquals            SearchFilterOp = "NOT_EQUALS"
	OpGreaterThan          SearchFilterOp = "GREATER_THAN"
	OpGreaterThanOrEqualTo SearchFilterOp = "GREATER_THAN_OR_EQUAL_TO"
	OpLessThan             SearchFilterOp = "LESS_THAN"
	OpLessThanOrEqualTo    SearchFilterOp = "LESS_THAN_OR_EQUAL_TO"
	OpIn                   SearchFilterOp = "IN"
	OpNotIn                SearchFilterOp = "NOT_IN"
	OpStartsWith           SearchFilterOp = "STARTS_WITH"
	OpEndsWith             SearchFilterOp = "ENDS_WITH"
	OpContains             SearchFilterOp = "CONTAINS"
	OpRegex                SearchFilterOp = "REGEX"
	OpPrefix               SearchFilterOp = "PREFIX"
)

type SearchFilter struct {
	Field     SearchFilterField
	Operation SearchFilterOp
	Value     interface{}
}

func encodeFilterValue(v interface{}) string {
	switch val := v.(type) {
	case string:
		return val
	case time.Time:
		return val.Format(time.RFC3339)
	case []string:
		return strings.Join(val, ",")
	case fmt.Stringer:
		return val.String()
	default:
		return fmt.Sprintf("%v", val)
	}
}

// appendFilterParams is the internal alias for AppendFilterParams.
func appendFilterParams(params url.Values, filters []SearchFilter) {
	AppendFilterParams(params, filters)
}

// AppendFilterParams appends query filter parameters to the given url.Values.
func AppendFilterParams(params url.Values, filters []SearchFilter) {
	for _, f := range filters {
		switch val := f.Value.(type) {
		case map[string]string:
			for k, v := range val {
				key := fmt.Sprintf("filters[%s][%s][%s]", f.Field, f.Operation, k)
				params.Set(key, v)
			}
		default:
			key := fmt.Sprintf("filters[%s][%s]", f.Field, f.Operation)
			params.Set(key, encodeFilterValue(val))
		}
	}
}

// Kestra 2.0 replaced the per-endpoint filter query params (q, namespace,
// taskId, level, ...) with a unified `filters` array. These helpers translate
// the legacy scalar/slice params the SDK methods still accept into EQUALS
// filters, so the public signatures stay backward-compatible.

func appendStringFilter(filters []SearchFilter, field SearchFilterField, value *string) []SearchFilter {
	return appendStringFilterOp(filters, field, OpEquals, value)
}

// appendStringFilterOp lets the caller pick the operation, since 2.0 restricts
// it per field (e.g. LEVEL only allows GREATER_THAN_OR_EQUAL_TO / LESS_THAN_OR_EQUAL_TO).
func appendStringFilterOp(filters []SearchFilter, field SearchFilterField, op SearchFilterOp, value *string) []SearchFilter {
	if value != nil {
		filters = append(filters, SearchFilter{Field: field, Operation: op, Value: *value})
	}
	return filters
}

// appendSliceFilter uses IN: collection fields like TAGS reject EQUALS.
func appendSliceFilter(filters []SearchFilter, field SearchFilterField, values []string) []SearchFilter {
	if len(values) > 0 {
		filters = append(filters, SearchFilter{Field: field, Operation: OpIn, Value: values})
	}
	return filters
}

func appendIntFilter(filters []SearchFilter, field SearchFilterField, value *int) []SearchFilter {
	if value != nil {
		filters = append(filters, SearchFilter{Field: field, Operation: OpEquals, Value: *value})
	}
	return filters
}
