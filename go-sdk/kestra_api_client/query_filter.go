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
type QueryFilterField string

const (
	FilterQuery     QueryFilterField = "q"
	FilterNamespace QueryFilterField = "namespace"
	FilterFlowId    QueryFilterField = "flowId"
	FilterState     QueryFilterField = "state"
	FilterLabels    QueryFilterField = "labels"
	FilterCreated   QueryFilterField = "created"
	FilterUpdated   QueryFilterField = "updated"
	FilterStartDate QueryFilterField = "startDate"
	FilterEndDate   QueryFilterField = "endDate"
	FilterTimeRange QueryFilterField = "timeRange"
	FilterScope     QueryFilterField = "scope"
	FilterAssetId   QueryFilterField = "assetId"
	FilterParentId  QueryFilterField = "childFilter"
	FilterTaskId    QueryFilterField = "taskId"
	FilterUserId    QueryFilterField = "userId"
	FilterAction    QueryFilterField = "action"
	FilterDetails   QueryFilterField = "details"
	FilterMinLevel  QueryFilterField = "level"
	FilterTriggerId QueryFilterField = "triggerId"
	FilterExisting  QueryFilterField = "existing"
	FilterKey       QueryFilterField = "key"
	FilterResource  QueryFilterField = "resource"

	FilterTags          QueryFilterField = "tags"
	FilterTaskRunId     QueryFilterField = "taskRunId"
	FilterAttemptNumber QueryFilterField = "attemptNumber"

	FilterEmail      QueryFilterField = "email"
	FilterStatus     QueryFilterField = "status"
	FilterExpiredAt  QueryFilterField = "expired_at"
	FilterSuperAdmin QueryFilterField = "super_admin"
)

type QueryFilterOp string

const (
	OpEquals               QueryFilterOp = "EQUALS"
	OpNotEquals            QueryFilterOp = "NOT_EQUALS"
	OpGreaterThan          QueryFilterOp = "GREATER_THAN"
	OpGreaterThanOrEqualTo QueryFilterOp = "GREATER_THAN_OR_EQUAL_TO"
	OpLessThan             QueryFilterOp = "LESS_THAN"
	OpLessThanOrEqualTo    QueryFilterOp = "LESS_THAN_OR_EQUAL_TO"
	OpIn                   QueryFilterOp = "IN"
	OpNotIn                QueryFilterOp = "NOT_IN"
	OpStartsWith           QueryFilterOp = "STARTS_WITH"
	OpEndsWith             QueryFilterOp = "ENDS_WITH"
	OpContains             QueryFilterOp = "CONTAINS"
	OpRegex                QueryFilterOp = "REGEX"
	OpPrefix               QueryFilterOp = "PREFIX"
)

type QueryFilter struct {
	Field     QueryFilterField
	Operation QueryFilterOp
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
func appendFilterParams(params url.Values, filters []QueryFilter) {
	AppendFilterParams(params, filters)
}

// AppendFilterParams appends query filter parameters to the given url.Values.
func AppendFilterParams(params url.Values, filters []QueryFilter) {
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

func appendStringFilter(filters []QueryFilter, field QueryFilterField, value *string) []QueryFilter {
	return appendStringFilterOp(filters, field, OpEquals, value)
}

// appendStringFilterOp lets the caller pick the operation, since 2.0 restricts
// it per field (e.g. LEVEL only allows GREATER_THAN_OR_EQUAL_TO / LESS_THAN_OR_EQUAL_TO).
func appendStringFilterOp(filters []QueryFilter, field QueryFilterField, op QueryFilterOp, value *string) []QueryFilter {
	if value != nil {
		filters = append(filters, QueryFilter{Field: field, Operation: op, Value: *value})
	}
	return filters
}

// appendSliceFilter uses IN: collection fields like TAGS reject EQUALS.
func appendSliceFilter(filters []QueryFilter, field QueryFilterField, values []string) []QueryFilter {
	if len(values) > 0 {
		filters = append(filters, QueryFilter{Field: field, Operation: OpIn, Value: values})
	}
	return filters
}

func appendIntFilter(filters []QueryFilter, field QueryFilterField, value *int) []QueryFilter {
	if value != nil {
		filters = append(filters, QueryFilter{Field: field, Operation: OpEquals, Value: *value})
	}
	return filters
}
