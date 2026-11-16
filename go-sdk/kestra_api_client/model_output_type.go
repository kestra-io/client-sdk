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

// OutputType the model 'OutputType'
type OutputType string

// List of OutputType
const (
	OUTPUTTYPE_STRING OutputType = "STRING"
	OUTPUTTYPE_INT OutputType = "INT"
	OUTPUTTYPE_FLOAT OutputType = "FLOAT"
	OUTPUTTYPE_BOOL OutputType = "BOOL"
	OUTPUTTYPE_DATETIME OutputType = "DATETIME"
	OUTPUTTYPE_DATE OutputType = "DATE"
	OUTPUTTYPE_TIME OutputType = "TIME"
	OUTPUTTYPE_DURATION OutputType = "DURATION"
	OUTPUTTYPE_FILE OutputType = "FILE"
	OUTPUTTYPE_JSON OutputType = "JSON"
	OUTPUTTYPE_ION OutputType = "ION"
	OUTPUTTYPE_URI OutputType = "URI"
	OUTPUTTYPE_SECRET OutputType = "SECRET"
	OUTPUTTYPE_ARRAY OutputType = "ARRAY"
	OUTPUTTYPE_YAML OutputType = "YAML"
	OUTPUTTYPE_ASSET OutputType = "ASSET"
	OUTPUTTYPE_UNKNOWN OutputType = "UNKNOWN"
)

// All allowed values of OutputType enum
var AllowedOutputTypeEnumValues = []OutputType{
	"STRING",
	"INT",
	"FLOAT",
	"BOOL",
	"DATETIME",
	"DATE",
	"TIME",
	"DURATION",
	"FILE",
	"JSON",
	"ION",
	"URI",
	"SECRET",
	"ARRAY",
	"YAML",
	"ASSET",
	"UNKNOWN",
}

func (v *OutputType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := OutputType(value)
	for _, existing := range AllowedOutputTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid OutputType", value)
}

// NewOutputTypeFromValue returns a pointer to a valid OutputType
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewOutputTypeFromValue(v string) (*OutputType, error) {
	ev := OutputType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for OutputType: valid values are %v", v, AllowedOutputTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v OutputType) IsValid() bool {
	for _, existing := range AllowedOutputTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to OutputType value
func (v OutputType) Ptr() *OutputType {
	return &v
}

type NullableOutputType struct {
	value *OutputType
	isSet bool
}

func (v NullableOutputType) Get() *OutputType {
	return v.value
}

func (v *NullableOutputType) Set(val *OutputType) {
	v.value = val
	v.isSet = true
}

func (v NullableOutputType) IsSet() bool {
	return v.isSet
}

func (v *NullableOutputType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableOutputType(val *OutputType) *NullableOutputType {
	return &NullableOutputType{value: val, isSet: true}
}

func (v NullableOutputType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableOutputType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}

