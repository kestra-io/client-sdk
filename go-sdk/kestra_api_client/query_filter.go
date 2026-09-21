package kestra_api_client

import (
	"fmt"
	"net/url"
	"sort"
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
	FilterMinLevel  SearchFilterField = "level"
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

// SearchFilterLogical is the logical combinator for a group of SearchFilter
// children (issue #246). Serialized lowercase (`and`/`or`) to match the Kestra
// UI encoder wire form.
type SearchFilterLogical string

const (
	LogicalAnd SearchFilterLogical = "and"
	LogicalOr  SearchFilterLogical = "or"
)

// SearchFilter is either:
//   - a leaf:  has Field + Operation (+ optional Value), and no Children.
//   - a group: has Logical (and/or) + Children, and no Field.
//
// The Logical/Children fields are additive (issue #246); a zero SearchFilter with
// only Field/Operation/Value behaves exactly as before.
type SearchFilter struct {
	Field     SearchFilterField
	Operation SearchFilterOp
	Value     interface{}
	Logical   *SearchFilterLogical
	Children  []SearchFilter
}

// isGroup reports whether the node is a logical group (has a Logical combinator).
func (f SearchFilter) isGroup() bool {
	return f.Logical != nil
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

// filterParam is a single ordered key/value pair of the serialized filters
// query. url.Values is a map and loses insertion order, so the serializer builds
// this ordered slice first (which the offline golden test asserts against) and
// AppendFilterParams then replays it into url.Values via Add.
type filterParam struct {
	Key   string
	Value string
}

// appendFilterParams is the internal alias for AppendFilterParams.
func appendFilterParams(params url.Values, filters []SearchFilter) {
	AppendFilterParams(params, filters)
}

// AppendFilterParams appends query filter parameters to the given url.Values.
//
// It implements the complex AND/OR + one-level-nested group algorithm (issue
// #246). The exported 2-arg signature is preserved; the top-level list is an
// implicit AND and serialization starts at the "filters" prefix.
//
// Uses params.Add (not Set) so duplicate keys (e.g. two OR children on the same
// field) survive. If the filters are malformed (nested more than one level deep,
// or a node that is both a leaf and a group) nothing is appended.
func AppendFilterParams(params url.Values, filters []SearchFilter) {
	pairs, err := buildFilterParams(filters)
	if err != nil {
		return
	}
	for _, p := range pairs {
		params.Add(p.Key, p.Value)
	}
}

// buildFilterParams produces the ordered key/value pairs for the given top-level
// filter list. It returns an error for structurally invalid filters (nested
// groups deeper than one level, or a node that is both a leaf and a group).
func buildFilterParams(filters []SearchFilter) ([]filterParam, error) {
	if len(filters) == 0 {
		return nil, nil
	}

	// Determine the top-level logical and the units to emit.
	topLogical := LogicalAnd
	units := filters
	if len(filters) == 1 && filters[0].isGroup() {
		topLogical = *filters[0].Logical
		units = filters[0].Children
	}

	// Flat (backward-compat) form: top-level AND whose units are all leaves →
	// bare filters[field][OP]=value, byte-identical to the legacy output.
	if topLogical == LogicalAnd && allLeaves(units) {
		var out []filterParam
		for _, u := range units {
			leafPairs, err := emitLeaf("filters", u)
			if err != nil {
				return nil, err
			}
			out = append(out, leafPairs...)
		}
		return out, nil
	}

	var out []filterParam
	for i, unit := range units {
		unitPrefix := fmt.Sprintf("filters[%s][%d]", topLogical, i)
		if !unit.isGroup() {
			leafPairs, err := emitLeaf(unitPrefix, unit)
			if err != nil {
				return nil, err
			}
			out = append(out, leafPairs...)
			continue
		}
		for j, child := range unit.Children {
			if child.isGroup() {
				return nil, fmt.Errorf("nested groups are limited to one level; flatten the inner group")
			}
			childPrefix := fmt.Sprintf("%s[%s][%d]", unitPrefix, *unit.Logical, j)
			leafPairs, err := emitLeaf(childPrefix, child)
			if err != nil {
				return nil, err
			}
			out = append(out, leafPairs...)
		}
	}
	return out, nil
}

// allLeaves reports whether every filter in the slice is a leaf (no group).
func allLeaves(filters []SearchFilter) bool {
	for _, f := range filters {
		if f.isGroup() {
			return false
		}
	}
	return true
}

// emitLeaf serializes a single leaf filter under the given prefix into ordered
// key/value pairs. Map values emit a [key] suffix (keys sorted for
// determinism); IN/NOT_IN and slice values are CSV-joined by encodeFilterValue.
func emitLeaf(prefix string, f SearchFilter) ([]filterParam, error) {
	if f.isGroup() {
		return nil, fmt.Errorf("a filter node cannot be both a leaf and a group")
	}
	base := fmt.Sprintf("%s[%s][%s]", prefix, f.Field, f.Operation)

	switch val := f.Value.(type) {
	case map[string]string:
		keys := make([]string, 0, len(val))
		for k := range val {
			keys = append(keys, k)
		}
		sort.Strings(keys)
		out := make([]filterParam, 0, len(keys))
		for _, k := range keys {
			out = append(out, filterParam{Key: fmt.Sprintf("%s[%s]", base, k), Value: val[k]})
		}
		return out, nil
	default:
		return []filterParam{{Key: base, Value: encodeFilterValue(val)}}, nil
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
