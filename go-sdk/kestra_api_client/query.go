package kestra_api_client

// Fluent DSL for building complex AND/OR + one-level-nested query filters
// (issue #246). It is a thin, type-safe constructor layer over SearchFilter that
// produces the []SearchFilter value every *ByQuery search method already accepts.
//
// A "node" is represented as a []SearchFilter of length 0 or 1:
//   - length 0 → an empty / absent node (a null child, or an empty group).
//   - length 1 → the single leaf or group node.
//
// This makes null-dropping and single-child flattening natural in Go while
// keeping every helper's return type uniform.

// FilterBy builds a leaf node for the given field, operation and value.
//
// NOTE: named FilterBy rather than Filter because `Filter` is already an
// existing generated model type in this package; renaming it would be a breaking
// change. The convenience helpers below (Eq, In, ...) are the primary DSL entry
// points and keep their spec names.
func FilterBy(field SearchFilterField, op SearchFilterOp, value interface{}) []SearchFilter {
	return []SearchFilter{{Field: field, Operation: op, Value: value}}
}

// Eq builds a leaf with the EQUALS operation.
func Eq(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpEquals, value)
}

// NotEq builds a leaf with the NOT_EQUALS operation.
func NotEq(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpNotEquals, value)
}

// In builds a leaf with the IN operation (values are CSV-joined on the wire).
func In(field SearchFilterField, values ...string) []SearchFilter {
	return FilterBy(field, OpIn, values)
}

// NotIn builds a leaf with the NOT_IN operation (values are CSV-joined).
func NotIn(field SearchFilterField, values ...string) []SearchFilter {
	return FilterBy(field, OpNotIn, values)
}

// Contains builds a leaf with the CONTAINS operation.
func Contains(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpContains, value)
}

// StartsWith builds a leaf with the STARTS_WITH operation.
func StartsWith(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpStartsWith, value)
}

// EndsWith builds a leaf with the ENDS_WITH operation.
func EndsWith(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpEndsWith, value)
}

// Regex builds a leaf with the REGEX operation.
func Regex(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpRegex, value)
}

// Prefix builds a leaf with the PREFIX operation.
func Prefix(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpPrefix, value)
}

// Gt builds a leaf with the GREATER_THAN operation.
func Gt(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpGreaterThan, value)
}

// Gte builds a leaf with the GREATER_THAN_OR_EQUAL_TO operation.
func Gte(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpGreaterThanOrEqualTo, value)
}

// Lt builds a leaf with the LESS_THAN operation.
func Lt(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpLessThan, value)
}

// Lte builds a leaf with the LESS_THAN_OR_EQUAL_TO operation.
func Lte(field SearchFilterField, value interface{}) []SearchFilter {
	return FilterBy(field, OpLessThanOrEqualTo, value)
}

// And combines its children into an AND group.
//
//   - null / empty children are dropped.
//   - 0 effective children → nil (an empty group).
//   - exactly 1 effective child → that child directly (single-child flatten).
//   - otherwise → an AND group node.
func And(children ...[]SearchFilter) []SearchFilter {
	return group(LogicalAnd, children)
}

// Or combines its children into an OR group, with the same drop/flatten rules as And.
func Or(children ...[]SearchFilter) []SearchFilter {
	return group(LogicalOr, children)
}

func group(logical SearchFilterLogical, children [][]SearchFilter) []SearchFilter {
	var effective []SearchFilter
	for _, child := range children {
		effective = append(effective, child...)
	}
	switch len(effective) {
	case 0:
		return nil
	case 1:
		return []SearchFilter{effective[0]}
	default:
		l := logical
		return []SearchFilter{{Logical: &l, Children: effective}}
	}
}

// Where turns a DSL root node into the []SearchFilter list every *ByQuery method
// accepts:
//   - empty root → an empty list.
//   - a top-level AND group → its children (flattened one level).
//   - otherwise → a single-element list holding the root node.
func Where(root []SearchFilter) []SearchFilter {
	if len(root) == 0 {
		return []SearchFilter{}
	}
	if len(root) == 1 && root[0].isGroup() && *root[0].Logical == LogicalAnd {
		return root[0].Children
	}
	return root
}
