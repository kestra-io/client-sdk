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

// ApiPolicyMutationAction the model 'ApiPolicyMutationAction'
type ApiPolicyMutationAction string

// List of ApiPolicyMutation.Action
const (
	APIPOLICYMUTATIONACTION_ADDED    ApiPolicyMutationAction = "ADDED"
	APIPOLICYMUTATIONACTION_REPLACED ApiPolicyMutationAction = "REPLACED"
	APIPOLICYMUTATIONACTION_REMOVED  ApiPolicyMutationAction = "REMOVED"
)

// All allowed values of ApiPolicyMutationAction enum
var AllowedApiPolicyMutationActionEnumValues = []ApiPolicyMutationAction{
	"ADDED",
	"REPLACED",
	"REMOVED",
}

func (v *ApiPolicyMutationAction) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := ApiPolicyMutationAction(value)
	for _, existing := range AllowedApiPolicyMutationActionEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid ApiPolicyMutationAction", value)
}

// NewApiPolicyMutationActionFromValue returns a pointer to a valid ApiPolicyMutationAction
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewApiPolicyMutationActionFromValue(v string) (*ApiPolicyMutationAction, error) {
	ev := ApiPolicyMutationAction(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for ApiPolicyMutationAction: valid values are %v", v, AllowedApiPolicyMutationActionEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v ApiPolicyMutationAction) IsValid() bool {
	for _, existing := range AllowedApiPolicyMutationActionEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to ApiPolicyMutation.Action value
func (v ApiPolicyMutationAction) Ptr() *ApiPolicyMutationAction {
	return &v
}

type NullableApiPolicyMutationAction struct {
	value *ApiPolicyMutationAction
	isSet bool
}

func (v NullableApiPolicyMutationAction) Get() *ApiPolicyMutationAction {
	return v.value
}

func (v *NullableApiPolicyMutationAction) Set(val *ApiPolicyMutationAction) {
	v.value = val
	v.isSet = true
}

func (v NullableApiPolicyMutationAction) IsSet() bool {
	return v.isSet
}

func (v *NullableApiPolicyMutationAction) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiPolicyMutationAction(val *ApiPolicyMutationAction) *NullableApiPolicyMutationAction {
	return &NullableApiPolicyMutationAction{value: val, isSet: true}
}

func (v NullableApiPolicyMutationAction) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableApiPolicyMutationAction) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
