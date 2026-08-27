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

// RuleTarget the model 'RuleTarget'
type RuleTarget string

// List of RuleTarget
const (
	RULETARGET_FLOW   RuleTarget = "FLOW"
	RULETARGET_PLUGIN RuleTarget = "PLUGIN"
)

// All allowed values of RuleTarget enum
var AllowedRuleTargetEnumValues = []RuleTarget{
	"FLOW",
	"PLUGIN",
}

func (v *RuleTarget) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := RuleTarget(value)
	for _, existing := range AllowedRuleTargetEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid RuleTarget", value)
}

// NewRuleTargetFromValue returns a pointer to a valid RuleTarget
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewRuleTargetFromValue(v string) (*RuleTarget, error) {
	ev := RuleTarget(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for RuleTarget: valid values are %v", v, AllowedRuleTargetEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v RuleTarget) IsValid() bool {
	for _, existing := range AllowedRuleTargetEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to RuleTarget value
func (v RuleTarget) Ptr() *RuleTarget {
	return &v
}

type NullableRuleTarget struct {
	value *RuleTarget
	isSet bool
}

func (v NullableRuleTarget) Get() *RuleTarget {
	return v.value
}

func (v *NullableRuleTarget) Set(val *RuleTarget) {
	v.value = val
	v.isSet = true
}

func (v NullableRuleTarget) IsSet() bool {
	return v.isSet
}

func (v *NullableRuleTarget) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRuleTarget(val *RuleTarget) *NullableRuleTarget {
	return &NullableRuleTarget{value: val, isSet: true}
}

func (v NullableRuleTarget) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableRuleTarget) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
