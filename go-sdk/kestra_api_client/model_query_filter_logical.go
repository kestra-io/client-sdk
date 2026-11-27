/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

*/

package kestra_api_client

import (
	"encoding/json"
	"fmt"
)

// QueryFilterLogical the model 'QueryFilterLogical'
//
// The logical combinator for a group of QueryFilter children (issue #246).
// Serialized lowercase (`and`/`or`) on both the query string and JSON body so it
// matches the Kestra UI encoder wire form.
type QueryFilterLogical string

// List of QueryFilter.Logical
const (
	QUERYFILTERLOGICAL_AND QueryFilterLogical = "and"
	QUERYFILTERLOGICAL_OR  QueryFilterLogical = "or"
)

// All allowed values of QueryFilterLogical enum
var AllowedQueryFilterLogicalEnumValues = []QueryFilterLogical{
	"and",
	"or",
}

func (v *QueryFilterLogical) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := QueryFilterLogical(value)
	for _, existing := range AllowedQueryFilterLogicalEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid QueryFilterLogical", value)
}

// NewQueryFilterLogicalFromValue returns a pointer to a valid QueryFilterLogical
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewQueryFilterLogicalFromValue(v string) (*QueryFilterLogical, error) {
	ev := QueryFilterLogical(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for QueryFilterLogical: valid values are %v", v, AllowedQueryFilterLogicalEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v QueryFilterLogical) IsValid() bool {
	for _, existing := range AllowedQueryFilterLogicalEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to QueryFilter.Logical value
func (v QueryFilterLogical) Ptr() *QueryFilterLogical {
	return &v
}

type NullableQueryFilterLogical struct {
	value *QueryFilterLogical
	isSet bool
}

func (v NullableQueryFilterLogical) Get() *QueryFilterLogical {
	return v.value
}

func (v *NullableQueryFilterLogical) Set(val *QueryFilterLogical) {
	v.value = val
	v.isSet = true
}

func (v NullableQueryFilterLogical) IsSet() bool {
	return v.isSet
}

func (v *NullableQueryFilterLogical) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableQueryFilterLogical(val *QueryFilterLogical) *NullableQueryFilterLogical {
	return &NullableQueryFilterLogical{value: val, isSet: true}
}

func (v NullableQueryFilterLogical) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableQueryFilterLogical) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
