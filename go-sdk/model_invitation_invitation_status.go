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

// InvitationInvitationStatus the model 'InvitationInvitationStatus'
type InvitationInvitationStatus string

// List of Invitation.InvitationStatus
const (
	INVITATIONINVITATIONSTATUS_PENDING  InvitationInvitationStatus = "PENDING"
	INVITATIONINVITATIONSTATUS_ACCEPTED InvitationInvitationStatus = "ACCEPTED"
	INVITATIONINVITATIONSTATUS_EXPIRED  InvitationInvitationStatus = "EXPIRED"
)

// All allowed values of InvitationInvitationStatus enum
var AllowedInvitationInvitationStatusEnumValues = []InvitationInvitationStatus{
	"PENDING",
	"ACCEPTED",
	"EXPIRED",
}

func (v *InvitationInvitationStatus) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := InvitationInvitationStatus(value)
	for _, existing := range AllowedInvitationInvitationStatusEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid InvitationInvitationStatus", value)
}

// NewInvitationInvitationStatusFromValue returns a pointer to a valid InvitationInvitationStatus
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewInvitationInvitationStatusFromValue(v string) (*InvitationInvitationStatus, error) {
	ev := InvitationInvitationStatus(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for InvitationInvitationStatus: valid values are %v", v, AllowedInvitationInvitationStatusEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v InvitationInvitationStatus) IsValid() bool {
	for _, existing := range AllowedInvitationInvitationStatusEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to Invitation.InvitationStatus value
func (v InvitationInvitationStatus) Ptr() *InvitationInvitationStatus {
	return &v
}

type NullableInvitationInvitationStatus struct {
	value *InvitationInvitationStatus
	isSet bool
}

func (v NullableInvitationInvitationStatus) Get() *InvitationInvitationStatus {
	return v.value
}

func (v *NullableInvitationInvitationStatus) Set(val *InvitationInvitationStatus) {
	v.value = val
	v.isSet = true
}

func (v NullableInvitationInvitationStatus) IsSet() bool {
	return v.isSet
}

func (v *NullableInvitationInvitationStatus) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableInvitationInvitationStatus(val *InvitationInvitationStatus) *NullableInvitationInvitationStatus {
	return &NullableInvitationInvitationStatus{value: val, isSet: true}
}

func (v NullableInvitationInvitationStatus) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableInvitationInvitationStatus) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
