package kestra_api_client

import (
	"net/url"
	"testing"
)

func TestQueryFilterToSearchFilter_FieldCasing(t *testing.T) {
	tests := []struct {
		name     string
		input    QueryFilterField
		expected SearchFilterField
	}{
		{"modern flowId stays flowId", QUERYFILTERFIELD_FLOW_ID, SearchFilterField("flowId")},
		{"modern startDate stays startDate", QUERYFILTERFIELD_START_DATE, SearchFilterField("startDate")},
		{"legacy FLOW_ID becomes flowId", QueryFilterField("FLOW_ID"), SearchFilterField("flowId")},
		{"legacy START_DATE becomes startDate", QueryFilterField("START_DATE"), SearchFilterField("startDate")},
		{"legacy flow_id becomes flowId", QueryFilterField("flow_id"), SearchFilterField("flowId")},
		{"namespace unchanged", QUERYFILTERFIELD_NAMESPACE, SearchFilterField("namespace")},
		{"state unchanged", QUERYFILTERFIELD_STATE, SearchFilterField("state")},
		{"level unchanged", QUERYFILTERFIELD_MIN_LEVEL, SearchFilterField("level")},
		// Legacy "query" input maps to "q". The exported constant
		// QUERYFILTERFIELD_QUERY is already "q", so the literal stays here.
		{"query maps to q", QueryFilterField("query"), SearchFilterField("q")},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			field := tc.input
			sf := queryFilterToSearchFilter(QueryFilter{Field: &field})
			if sf.Field != tc.expected {
				t.Fatalf("field: got %q, want %q", sf.Field, tc.expected)
			}
		})
	}
}

func TestQueryFilterToSearchFilter_NestedChildrenPreserveCasing(t *testing.T) {
	flowID := QUERYFILTERFIELD_FLOW_ID
	startDate := QUERYFILTERFIELD_START_DATE

	and := QueryFilterLogical("AND")
	parent := QueryFilter{
		Logical: &and,
		Children: []QueryFilter{
			{Field: &flowID},
			{
				Logical: &and,
				Children: []QueryFilter{
					{Field: &startDate},
				},
			},
		},
	}

	sf := queryFilterToSearchFilter(parent)

	if sf.Field != "" {
		t.Fatalf("parent field should be empty, got %q", sf.Field)
	}
	if len(sf.Children) != 2 {
		t.Fatalf("expected 2 children, got %d", len(sf.Children))
	}
	if sf.Children[0].Field != "flowId" {
		t.Errorf("first child field: got %q, want %q", sf.Children[0].Field, "flowId")
	}
	if len(sf.Children[1].Children) != 1 {
		t.Fatalf("expected 1 grandchild, got %d", len(sf.Children[1].Children))
	}
	if got := sf.Children[1].Children[0].Field; got != "startDate" {
		t.Errorf("grandchild field: got %q, want %q", got, "startDate")
	}
}

// TestAddFilterQueryParams_PreservesModernFieldWireName is a wire-level
// regression test for issue #475. It drives the same QueryFilter -> *ByQuery
// path callers use (addFilterQueryParams -> buildQueryFilterParams ->
// queryFilterToSearchFilter) and asserts the resulting url.Values key. With
// the original bug, "flowId" was lowercased to "flowid", producing the key
// "filters[flowid][EQUALS]" and this test fails.
func TestAddFilterQueryParams_PreservesModernFieldWireName(t *testing.T) {
	field := QUERYFILTERFIELD_FLOW_ID
	op := QueryFilterOp("EQUALS")
	filters := []QueryFilter{{
		Field:     &field,
		Operation: &op,
		Value:     "my-flow",
	}}

	params := url.Values{}
	if err := addFilterQueryParams(params, filters); err != nil {
		t.Fatalf("addFilterQueryParams: %v", err)
	}

	const wantKey = "filters[flowId][EQUALS]"
	if got := params.Get(wantKey); got != "my-flow" {
		t.Fatalf("%s: got %q, want %q (flowId may have been lowercased to flowid)", wantKey, got, "my-flow")
	}
	if got := params.Get("filters[flowid][EQUALS]"); got != "" {
		t.Fatalf("unexpected lowercase key filters[flowid][EQUALS]=%q", got)
	}
}
