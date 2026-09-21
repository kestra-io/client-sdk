package kestra_api_client

import (
	"encoding/json"
	"fmt"
	"os"
	"reflect"
	"testing"
)

// goldenFieldMap maps the logical field names used in the shared golden vectors
// to this SDK's SearchFilterField wire values.
var goldenFieldMap = map[string]SearchFilterField{
	"NAMESPACE": FilterNamespace,
	"FLOW_ID":   FilterFlowId,
	"SCOPE":     FilterScope,
	"STATE":     FilterState,
	"LABELS":    FilterLabels,
	"QUERY":     FilterQuery,
	"MIN_LEVEL": FilterMinLevel,
}

type goldenFile struct {
	Cases []goldenCase `json:"cases"`
}

type goldenCase struct {
	Name     string          `json:"name"`
	Input    json.RawMessage `json:"input"`
	Expected []string        `json:"expected"`
}

type rawNode struct {
	Field    *string           `json:"field"`
	Op       *string           `json:"op"`
	Value    json.RawMessage   `json:"value"`
	Logical  *string           `json:"logical"`
	Children []json.RawMessage `json:"children"`
}

// parseNode recursively builds a DSL node ([]SearchFilter of length 0/1) from a
// golden JSON node, exercising the And/Or/Filter constructors.
func parseNode(t *testing.T, raw json.RawMessage) []SearchFilter {
	t.Helper()
	var n rawNode
	if err := json.Unmarshal(raw, &n); err != nil {
		t.Fatalf("unmarshal node: %v", err)
	}

	if n.Logical != nil {
		kids := make([][]SearchFilter, 0, len(n.Children))
		for _, c := range n.Children {
			kids = append(kids, parseNode(t, c))
		}
		switch *n.Logical {
		case "AND":
			return And(kids...)
		case "OR":
			return Or(kids...)
		default:
			t.Fatalf("unknown logical %q", *n.Logical)
		}
	}

	if n.Field == nil || n.Op == nil {
		t.Fatalf("leaf missing field/op: %s", string(raw))
	}
	field, ok := goldenFieldMap[*n.Field]
	if !ok {
		t.Fatalf("unmapped field %q", *n.Field)
	}
	return FilterBy(field, SearchFilterOp(*n.Op), parseValue(t, n.Value))
}

func parseValue(t *testing.T, raw json.RawMessage) interface{} {
	t.Helper()
	if len(raw) == 0 {
		return nil
	}
	var s string
	if err := json.Unmarshal(raw, &s); err == nil {
		return s
	}
	var arr []string
	if err := json.Unmarshal(raw, &arr); err == nil {
		return arr
	}
	var m map[string]string
	if err := json.Unmarshal(raw, &m); err == nil {
		return m
	}
	t.Fatalf("unsupported value shape: %s", string(raw))
	return nil
}

// serializeOrdered renders the ordered filter params as key=value strings.
func serializeOrdered(t *testing.T, filters []SearchFilter) []string {
	t.Helper()
	pairs, err := buildFilterParams(filters)
	if err != nil {
		t.Fatalf("buildFilterParams error: %v", err)
	}
	out := make([]string, 0, len(pairs))
	for _, p := range pairs {
		out = append(out, fmt.Sprintf("%s=%s", p.Key, p.Value))
	}
	return out
}

func TestQueryFilterGolden(t *testing.T) {
	data, err := os.ReadFile("../../test-utils/query-filter-golden.json")
	if err != nil {
		t.Fatalf("read golden file: %v", err)
	}
	var gf goldenFile
	if err := json.Unmarshal(data, &gf); err != nil {
		t.Fatalf("unmarshal golden file: %v", err)
	}
	if len(gf.Cases) == 0 {
		t.Fatal("no golden cases loaded")
	}

	for _, tc := range gf.Cases {
		tc := tc
		t.Run(tc.Name, func(t *testing.T) {
			var input map[string]json.RawMessage
			if err := json.Unmarshal(tc.Input, &input); err != nil {
				t.Fatalf("unmarshal input: %v", err)
			}

			var filters []SearchFilter
			if where, ok := input["where"]; ok {
				filters = Where(parseNode(t, where))
			} else if list, ok := input["list"]; ok {
				var nodes []json.RawMessage
				if err := json.Unmarshal(list, &nodes); err != nil {
					t.Fatalf("unmarshal list: %v", err)
				}
				for _, n := range nodes {
					filters = append(filters, parseNode(t, n)...)
				}
			} else {
				t.Fatalf("case %q has neither where nor list", tc.Name)
			}

			actual := serializeOrdered(t, filters)
			expected := tc.Expected
			if expected == nil {
				expected = []string{}
			}
			if len(actual) == 0 {
				actual = []string{}
			}
			if !reflect.DeepEqual(actual, expected) {
				t.Errorf("case %q:\n  actual:   %v\n  expected: %v", tc.Name, actual, expected)
			}
		})
	}
}

// TestQueryFilterMinLevel verifies MIN_LEVEL maps to the `level` wire name.
func TestQueryFilterMinLevel(t *testing.T) {
	filters := Where(Gte(FilterMinLevel, "INFO"))
	actual := serializeOrdered(t, filters)
	expected := []string{"filters[level][GREATER_THAN_OR_EQUAL_TO]=INFO"}
	if !reflect.DeepEqual(actual, expected) {
		t.Errorf("actual %v, expected %v", actual, expected)
	}
}

// TestQueryFilterNestedTooDeep verifies nesting deeper than one level errors.
func TestQueryFilterNestedTooDeep(t *testing.T) {
	or := LogicalOr
	inner := SearchFilter{Logical: &or, Children: []SearchFilter{
		{Field: FilterScope, Operation: OpEquals, Value: "s1"},
	}}
	group := SearchFilter{Logical: &or, Children: []SearchFilter{
		inner, // a group nested inside a group unit → too deep
		{Field: FilterScope, Operation: OpEquals, Value: "s2"},
	}}
	filters := []SearchFilter{
		{Field: FilterNamespace, Operation: OpEquals, Value: "ns"},
		group,
	}
	if _, err := buildFilterParams(filters); err == nil {
		t.Fatal("expected error for nested groups deeper than one level, got nil")
	}
}

// TestQueryFilterLeafAndGroupAmbiguous verifies a node that is both a leaf and a
// group is rejected by emitLeaf.
func TestQueryFilterLeafAndGroupAmbiguous(t *testing.T) {
	and := LogicalAnd
	f := SearchFilter{Field: FilterNamespace, Operation: OpEquals, Logical: &and}
	if _, err := emitLeaf("filters", f); err == nil {
		t.Fatal("expected error for ambiguous leaf+group node, got nil")
	}
}

// TestQueryFilterMapKeySort verifies LABELS map keys are emitted sorted.
func TestQueryFilterMapKeySort(t *testing.T) {
	filters := Where(Eq(FilterLabels, map[string]string{"c": "3", "a": "1", "b": "2"}))
	actual := serializeOrdered(t, filters)
	expected := []string{
		"filters[labels][EQUALS][a]=1",
		"filters[labels][EQUALS][b]=2",
		"filters[labels][EQUALS][c]=3",
	}
	if !reflect.DeepEqual(actual, expected) {
		t.Errorf("actual %v, expected %v", actual, expected)
	}
}

// TestQueryFilterAddNotSet verifies duplicate keys survive (params.Add, not Set):
// two OR children on the same field must both appear.
func TestQueryFilterAddNotSet(t *testing.T) {
	filters := Where(Or(Eq(FilterScope, "s1"), Eq(FilterScope, "s2")))
	pairs, err := buildFilterParams(filters)
	if err != nil {
		t.Fatalf("buildFilterParams error: %v", err)
	}
	if len(pairs) != 2 {
		t.Fatalf("expected 2 ordered pairs, got %d: %v", len(pairs), pairs)
	}
}
