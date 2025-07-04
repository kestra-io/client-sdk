/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
	"fmt"
)

// QueryFilterField the model 'QueryFilterField'
type QueryFilterField string

// List of QueryFilter.Field
const (
	QUERYFILTERFIELD_QUERY                QueryFilterField = "QUERY"
	QUERYFILTERFIELD_SCOPE                QueryFilterField = "SCOPE"
	QUERYFILTERFIELD_NAMESPACE            QueryFilterField = "NAMESPACE"
	QUERYFILTERFIELD_LABELS               QueryFilterField = "LABELS"
	QUERYFILTERFIELD_FLOW_ID              QueryFilterField = "FLOW_ID"
	QUERYFILTERFIELD_START_DATE           QueryFilterField = "START_DATE"
	QUERYFILTERFIELD_END_DATE             QueryFilterField = "END_DATE"
	QUERYFILTERFIELD_STATE                QueryFilterField = "STATE"
	QUERYFILTERFIELD_TIME_RANGE           QueryFilterField = "TIME_RANGE"
	QUERYFILTERFIELD_TRIGGER_EXECUTION_ID QueryFilterField = "TRIGGER_EXECUTION_ID"
	QUERYFILTERFIELD_TRIGGER_ID           QueryFilterField = "TRIGGER_ID"
	QUERYFILTERFIELD_CHILD_FILTER         QueryFilterField = "CHILD_FILTER"
	QUERYFILTERFIELD_WORKER_ID            QueryFilterField = "WORKER_ID"
	QUERYFILTERFIELD_EXISTING_ONLY        QueryFilterField = "EXISTING_ONLY"
	QUERYFILTERFIELD_MIN_LEVEL            QueryFilterField = "MIN_LEVEL"
)

// All allowed values of QueryFilterField enum
var AllowedQueryFilterFieldEnumValues = []QueryFilterField{
	"QUERY",
	"SCOPE",
	"NAMESPACE",
	"LABELS",
	"FLOW_ID",
	"START_DATE",
	"END_DATE",
	"STATE",
	"TIME_RANGE",
	"TRIGGER_EXECUTION_ID",
	"TRIGGER_ID",
	"CHILD_FILTER",
	"WORKER_ID",
	"EXISTING_ONLY",
	"MIN_LEVEL",
}

func (v *QueryFilterField) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := QueryFilterField(value)
	for _, existing := range AllowedQueryFilterFieldEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid QueryFilterField", value)
}

// NewQueryFilterFieldFromValue returns a pointer to a valid QueryFilterField
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewQueryFilterFieldFromValue(v string) (*QueryFilterField, error) {
	ev := QueryFilterField(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for QueryFilterField: valid values are %v", v, AllowedQueryFilterFieldEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v QueryFilterField) IsValid() bool {
	for _, existing := range AllowedQueryFilterFieldEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to QueryFilter.Field value
func (v QueryFilterField) Ptr() *QueryFilterField {
	return &v
}

type NullableQueryFilterField struct {
	value *QueryFilterField
	isSet bool
}

func (v NullableQueryFilterField) Get() *QueryFilterField {
	return v.value
}

func (v *NullableQueryFilterField) Set(val *QueryFilterField) {
	v.value = val
	v.isSet = true
}

func (v NullableQueryFilterField) IsSet() bool {
	return v.isSet
}

func (v *NullableQueryFilterField) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableQueryFilterField(val *QueryFilterField) *NullableQueryFilterField {
	return &NullableQueryFilterField{value: val, isSet: true}
}

func (v NullableQueryFilterField) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableQueryFilterField) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
