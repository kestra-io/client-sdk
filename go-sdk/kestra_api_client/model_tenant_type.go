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

// TenantType the model 'TenantType'
type TenantType string

// List of TenantType
const (
	TENANTTYPE_DEFAULT TenantType = "DEFAULT"
	TENANTTYPE_INFRASTRUCTURE TenantType = "INFRASTRUCTURE"
	TENANTTYPE_UNKNOWN TenantType = "UNKNOWN"
)

// All allowed values of TenantType enum
var AllowedTenantTypeEnumValues = []TenantType{
	"DEFAULT",
	"INFRASTRUCTURE",
	"UNKNOWN",
}

func (v *TenantType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := TenantType(value)
	for _, existing := range AllowedTenantTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid TenantType", value)
}

// NewTenantTypeFromValue returns a pointer to a valid TenantType
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewTenantTypeFromValue(v string) (*TenantType, error) {
	ev := TenantType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for TenantType: valid values are %v", v, AllowedTenantTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v TenantType) IsValid() bool {
	for _, existing := range AllowedTenantTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to TenantType value
func (v TenantType) Ptr() *TenantType {
	return &v
}

type NullableTenantType struct {
	value *TenantType
	isSet bool
}

func (v NullableTenantType) Get() *TenantType {
	return v.value
}

func (v *NullableTenantType) Set(val *TenantType) {
	v.value = val
	v.isSet = true
}

func (v NullableTenantType) IsSet() bool {
	return v.isSet
}

func (v *NullableTenantType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTenantType(val *TenantType) *NullableTenantType {
	return &NullableTenantType{value: val, isSet: true}
}

func (v NullableTenantType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableTenantType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
