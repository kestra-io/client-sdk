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

// RuleAction the model 'RuleAction'
type RuleAction string

// List of RuleAction
const (
	RULEACTION_BLOCK RuleAction = "BLOCK"
	RULEACTION_WARN  RuleAction = "WARN"
)

// All allowed values of RuleAction enum
var AllowedRuleActionEnumValues = []RuleAction{
	"BLOCK",
	"WARN",
}

func (v *RuleAction) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := RuleAction(value)
	for _, existing := range AllowedRuleActionEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid RuleAction", value)
}

// NewRuleActionFromValue returns a pointer to a valid RuleAction
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewRuleActionFromValue(v string) (*RuleAction, error) {
	ev := RuleAction(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for RuleAction: valid values are %v", v, AllowedRuleActionEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v RuleAction) IsValid() bool {
	for _, existing := range AllowedRuleActionEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to RuleAction value
func (v RuleAction) Ptr() *RuleAction {
	return &v
}

type NullableRuleAction struct {
	value *RuleAction
	isSet bool
}

func (v NullableRuleAction) Get() *RuleAction {
	return v.value
}

func (v *NullableRuleAction) Set(val *RuleAction) {
	v.value = val
	v.isSet = true
}

func (v NullableRuleAction) IsSet() bool {
	return v.isSet
}

func (v *NullableRuleAction) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRuleAction(val *RuleAction) *NullableRuleAction {
	return &NullableRuleAction{value: val, isSet: true}
}

func (v NullableRuleAction) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableRuleAction) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
