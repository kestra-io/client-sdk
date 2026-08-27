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

// Enforcement the model 'Enforcement'
type Enforcement string

// List of Enforcement
const (
	ENFORCEMENT_ACTIVE    Enforcement = "ACTIVE"
	ENFORCEMENT_EVALUATE  Enforcement = "EVALUATE"
	ENFORCEMENT_DISABLED  Enforcement = "DISABLED"
	ENFORCEMENT_REFERENCE Enforcement = "REFERENCE"
)

// All allowed values of Enforcement enum
var AllowedEnforcementEnumValues = []Enforcement{
	"ACTIVE",
	"EVALUATE",
	"DISABLED",
	"REFERENCE",
}

func (v *Enforcement) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := Enforcement(value)
	for _, existing := range AllowedEnforcementEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid Enforcement", value)
}

// NewEnforcementFromValue returns a pointer to a valid Enforcement
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewEnforcementFromValue(v string) (*Enforcement, error) {
	ev := Enforcement(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for Enforcement: valid values are %v", v, AllowedEnforcementEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v Enforcement) IsValid() bool {
	for _, existing := range AllowedEnforcementEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to Enforcement value
func (v Enforcement) Ptr() *Enforcement {
	return &v
}

type NullableEnforcement struct {
	value *Enforcement
	isSet bool
}

func (v NullableEnforcement) Get() *Enforcement {
	return v.value
}

func (v *NullableEnforcement) Set(val *Enforcement) {
	v.value = val
	v.isSet = true
}

func (v NullableEnforcement) IsSet() bool {
	return v.isSet
}

func (v *NullableEnforcement) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEnforcement(val *Enforcement) *NullableEnforcement {
	return &NullableEnforcement{value: val, isSet: true}
}

func (v NullableEnforcement) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableEnforcement) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
