package kestra_api_client

import (
	"fmt"
	"net/url"
	"reflect"
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

// isAmbiguous reports whether the node is BOTH a leaf and a group: it carries a
// Logical combinator AND leaf data (Field/Operation/Value). Such a node is a
// programmer error — the leaf data would be silently discarded if it were
// treated as a pure group — and mirrors Java's isGroupNode (throws) and Python's
// _classify (raises) for the identical input.
func (f SearchFilter) isAmbiguous() bool {
	return f.Logical != nil && (f.Field != "" || f.Operation != "" || f.Value != nil)
}

func encodeFilterValue(v interface{}) string {
	switch val := v.(type) {
	case nil:
		// A valueless leaf serializes to an empty string, matching the UI encoder
		// (`value?.toString() ?? ""`) and the Java/Python serializers.
		return ""
	case string:
		return val
	case time.Time:
		return val.Format(time.RFC3339)
	case []byte:
		// Raw bytes are treated as an opaque scalar (not CSV-split element by
		// element); keep the pre-existing %v rendering.
		return fmt.Sprintf("%v", val)
	case fmt.Stringer:
		return val.String()
	}
	// Any other slice/array (e.g. []string, []int, []interface{}) is CSV-joined —
	// matching Java (convertValueToString/rawValueToString) and Python
	// (_encode_value), which comma-join ANY list. Each element is encoded through
	// encodeFilterValue so nested nils/bools/stringers stay consistent.
	rv := reflect.ValueOf(v)
	if rv.Kind() == reflect.Slice || rv.Kind() == reflect.Array {
		parts := make([]string, rv.Len())
		for i := 0; i < rv.Len(); i++ {
			parts[i] = encodeFilterValue(rv.Index(i).Interface())
		}
		return strings.Join(parts, ",")
	}
	return fmt.Sprintf("%v", v)
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
// field) survive.
//
// A structurally invalid filter tree (nested more than one level deep, a node
// that is both a leaf and a group, or a leaf with no field) is a programmer
// error and panics — mirroring the Java (ApiException) and Python (ValueError)
// SDKs, which raise for the identical input. This is deliberately loud: silently
// emitting no filters would turn a malformed *ByQuery into an unbounded
// "match everything" request (e.g. a delete-by-query that hits every row).
func AppendFilterParams(params url.Values, filters []SearchFilter) {
	pairs, err := buildFilterParams(filters)
	if err != nil {
		panic(fmt.Sprintf("kestra: invalid query filter: %v", err))
	}
	for _, p := range pairs {
		params.Add(p.Key, p.Value)
	}
}

// buildFilterParams produces the ordered key/value pairs for the given top-level
// filter list. It returns an error for structurally invalid filters (nested
// groups deeper than one level, or a node that is both a leaf and a group).
func buildFilterParams(filters []SearchFilter) ([]filterParam, error) {
	// Normalize raw input the same way the DSL constructors and the Java/Python
	// serializers do: drop empty groups and flatten single-child groups. This
	// keeps callers that build SearchFilter structs by hand (bypassing And/Or)
	// wire-identical to callers that use the DSL. Normalization also rejects
	// nodes that are ambiguously both a leaf and a group.
	filters, err := normalizeFilters(filters)
	if err != nil {
		return nil, err
	}
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

// normalizeFilter drops empty groups and flattens single-child groups. The
// second return value is false when the node collapses to nothing (an empty
// group) and should be dropped by the caller. It returns an error for a node
// that is ambiguously both a leaf and a group (mirroring Java/Python).
func normalizeFilter(f SearchFilter) (SearchFilter, bool, error) {
	if f.isAmbiguous() {
		return SearchFilter{}, false, fmt.Errorf("a filter node cannot be both a leaf and a group")
	}
	if !f.isGroup() {
		return f, true, nil
	}
	var kids []SearchFilter
	for _, c := range f.Children {
		nc, ok, err := normalizeFilter(c)
		if err != nil {
			return SearchFilter{}, false, err
		}
		if ok {
			kids = append(kids, nc)
		}
	}
	switch len(kids) {
	case 0:
		return SearchFilter{}, false, nil
	case 1:
		return kids[0], true, nil
	default:
		f.Children = kids
		return f, true, nil
	}
}

// normalizeFilters normalizes each top-level filter, dropping collapsed ones.
func normalizeFilters(filters []SearchFilter) ([]SearchFilter, error) {
	var out []SearchFilter
	for _, f := range filters {
		nf, ok, err := normalizeFilter(f)
		if err != nil {
			return nil, err
		}
		if ok {
			out = append(out, nf)
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
	if f.Field == "" {
		return nil, fmt.Errorf("a leaf filter requires a field")
	}
	base := fmt.Sprintf("%s[%s][%s]", prefix, f.Field, f.Operation)

	// Any map value (map[string]string, map[string]interface{}, LABELS, ...) emits
	// a [key] suffix per entry, keys sorted for determinism — matching Java's
	// Map<?,?> branch and Python's dict handling.
	if rv := reflect.ValueOf(f.Value); rv.Kind() == reflect.Map {
		type entry struct {
			k string
			v interface{}
		}
		entries := make([]entry, 0, rv.Len())
		for _, mk := range rv.MapKeys() {
			entries = append(entries, entry{fmt.Sprint(mk.Interface()), rv.MapIndex(mk).Interface()})
		}
		sort.Slice(entries, func(i, j int) bool { return entries[i].k < entries[j].k })
		out := make([]filterParam, 0, len(entries))
		for _, e := range entries {
			out = append(out, filterParam{Key: fmt.Sprintf("%s[%s]", base, e.k), Value: encodeFilterValue(e.v)})
		}
		return out, nil
	}
	return []filterParam{{Key: base, Value: encodeFilterValue(f.Value)}}, nil
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
