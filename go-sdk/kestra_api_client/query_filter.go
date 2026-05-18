package kestra_api_client

import (
	"fmt"
	"net/url"
	"strings"
	"time"
)

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
)

type QueryFilterOp string

const (
	OpEquals                 QueryFilterOp = "EQUALS"
	OpNotEquals              QueryFilterOp = "NOT_EQUALS"
	OpGreaterThan            QueryFilterOp = "GREATER_THAN"
	OpGreaterThanOrEqualTo   QueryFilterOp = "GREATER_THAN_OR_EQUAL_TO"
	OpLessThan               QueryFilterOp = "LESS_THAN"
	OpLessThanOrEqualTo      QueryFilterOp = "LESS_THAN_OR_EQUAL_TO"
	OpIn                     QueryFilterOp = "IN"
	OpNotIn                  QueryFilterOp = "NOT_IN"
	OpStartsWith             QueryFilterOp = "STARTS_WITH"
	OpEndsWith               QueryFilterOp = "ENDS_WITH"
	OpContains               QueryFilterOp = "CONTAINS"
	OpRegex                  QueryFilterOp = "REGEX"
	OpPrefix                 QueryFilterOp = "PREFIX"
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
func appendFilterParams(params url.Values, filters []QueryFilter) { AppendFilterParams(params, filters) }

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
