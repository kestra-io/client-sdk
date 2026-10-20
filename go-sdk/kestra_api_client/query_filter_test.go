package kestra_api_client

import "testing"

func TestQueryFilterToSearchFilter_FieldCasing(t *testing.T) {
	tests := []struct {
		name     string
		input    QueryFilterField
		expected SearchFilterField
	}{
		{"modern flowId stays flowId", QueryFilterField("flowId"), SearchFilterField("flowId")},
		{"modern startDate stays startDate", QueryFilterField("startDate"), SearchFilterField("startDate")},
		{"legacy FLOW_ID becomes flowId", QueryFilterField("FLOW_ID"), SearchFilterField("flowId")},
		{"legacy START_DATE becomes startDate", QueryFilterField("START_DATE"), SearchFilterField("startDate")},
		{"legacy flow_id becomes flowId", QueryFilterField("flow_id"), SearchFilterField("flowId")},
		{"namespace unchanged", QueryFilterField("namespace"), SearchFilterField("namespace")},
		{"state unchanged", QueryFilterField("state"), SearchFilterField("state")},
		{"level unchanged", QueryFilterField("level"), SearchFilterField("level")},
		{"query maps to q", QueryFilterField("query"), SearchFilterField("q")},
	}

	for _, tc := range tests {
		tc := tc
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
	flowID := QueryFilterField("flowId")
	startDate := QueryFilterField("startDate")

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
