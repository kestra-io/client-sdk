/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
	"fmt"
)

// AbstractFilterFilterType the model 'AbstractFilterFilterType'
type AbstractFilterFilterType string

// List of AbstractFilter.FilterType
const (
	ABSTRACTFILTERFILTERTYPE_CONTAINS                 AbstractFilterFilterType = "CONTAINS"
	ABSTRACTFILTERFILTERTYPE_ENDS_WITH                AbstractFilterFilterType = "ENDS_WITH"
	ABSTRACTFILTERFILTERTYPE_EQUAL_TO                 AbstractFilterFilterType = "EQUAL_TO"
	ABSTRACTFILTERFILTERTYPE_GREATER_THAN             AbstractFilterFilterType = "GREATER_THAN"
	ABSTRACTFILTERFILTERTYPE_GREATER_THAN_OR_EQUAL_TO AbstractFilterFilterType = "GREATER_THAN_OR_EQUAL_TO"
	ABSTRACTFILTERFILTERTYPE_IN                       AbstractFilterFilterType = "IN"
	ABSTRACTFILTERFILTERTYPE_IS_FALSE                 AbstractFilterFilterType = "IS_FALSE"
	ABSTRACTFILTERFILTERTYPE_IS_NOT_NULL              AbstractFilterFilterType = "IS_NOT_NULL"
	ABSTRACTFILTERFILTERTYPE_IS_NULL                  AbstractFilterFilterType = "IS_NULL"
	ABSTRACTFILTERFILTERTYPE_IS_TRUE                  AbstractFilterFilterType = "IS_TRUE"
	ABSTRACTFILTERFILTERTYPE_LESS_THAN                AbstractFilterFilterType = "LESS_THAN"
	ABSTRACTFILTERFILTERTYPE_LESS_THAN_OR_EQUAL_TO    AbstractFilterFilterType = "LESS_THAN_OR_EQUAL_TO"
	ABSTRACTFILTERFILTERTYPE_NOT_CONTAINS             AbstractFilterFilterType = "NOT_CONTAINS"
	ABSTRACTFILTERFILTERTYPE_NOT_EQUAL_TO             AbstractFilterFilterType = "NOT_EQUAL_TO"
	ABSTRACTFILTERFILTERTYPE_NOT_IN                   AbstractFilterFilterType = "NOT_IN"
	ABSTRACTFILTERFILTERTYPE_OR                       AbstractFilterFilterType = "OR"
	ABSTRACTFILTERFILTERTYPE_REGEX                    AbstractFilterFilterType = "REGEX"
	ABSTRACTFILTERFILTERTYPE_STARTS_WITH              AbstractFilterFilterType = "STARTS_WITH"
	ABSTRACTFILTERFILTERTYPE_PREFIX                   AbstractFilterFilterType = "PREFIX"
)

// All allowed values of AbstractFilterFilterType enum
var AllowedAbstractFilterFilterTypeEnumValues = []AbstractFilterFilterType{
	"CONTAINS",
	"ENDS_WITH",
	"EQUAL_TO",
	"GREATER_THAN",
	"GREATER_THAN_OR_EQUAL_TO",
	"IN",
	"IS_FALSE",
	"IS_NOT_NULL",
	"IS_NULL",
	"IS_TRUE",
	"LESS_THAN",
	"LESS_THAN_OR_EQUAL_TO",
	"NOT_CONTAINS",
	"NOT_EQUAL_TO",
	"NOT_IN",
	"OR",
	"REGEX",
	"STARTS_WITH",
	"PREFIX",
}

func (v *AbstractFilterFilterType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := AbstractFilterFilterType(value)
	for _, existing := range AllowedAbstractFilterFilterTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid AbstractFilterFilterType", value)
}

// NewAbstractFilterFilterTypeFromValue returns a pointer to a valid AbstractFilterFilterType
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewAbstractFilterFilterTypeFromValue(v string) (*AbstractFilterFilterType, error) {
	ev := AbstractFilterFilterType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for AbstractFilterFilterType: valid values are %v", v, AllowedAbstractFilterFilterTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v AbstractFilterFilterType) IsValid() bool {
	for _, existing := range AllowedAbstractFilterFilterTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to AbstractFilter.FilterType value
func (v AbstractFilterFilterType) Ptr() *AbstractFilterFilterType {
	return &v
}

type NullableAbstractFilterFilterType struct {
	value *AbstractFilterFilterType
	isSet bool
}

func (v NullableAbstractFilterFilterType) Get() *AbstractFilterFilterType {
	return v.value
}

func (v *NullableAbstractFilterFilterType) Set(val *AbstractFilterFilterType) {
	v.value = val
	v.isSet = true
}

func (v NullableAbstractFilterFilterType) IsSet() bool {
	return v.isSet
}

func (v *NullableAbstractFilterFilterType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAbstractFilterFilterType(val *AbstractFilterFilterType) *NullableAbstractFilterFilterType {
	return &NullableAbstractFilterFilterType{value: val, isSet: true}
}

func (v NullableAbstractFilterFilterType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAbstractFilterFilterType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
