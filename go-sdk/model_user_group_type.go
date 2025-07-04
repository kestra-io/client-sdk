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

// UserGroupType the model 'UserGroupType'
type UserGroupType string

// List of UserGroup.Type
const (
	USERGROUPTYPE_DIRECT   UserGroupType = "DIRECT"
	USERGROUPTYPE_INDIRECT UserGroupType = "INDIRECT"
)

// All allowed values of UserGroupType enum
var AllowedUserGroupTypeEnumValues = []UserGroupType{
	"DIRECT",
	"INDIRECT",
}

func (v *UserGroupType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := UserGroupType(value)
	for _, existing := range AllowedUserGroupTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid UserGroupType", value)
}

// NewUserGroupTypeFromValue returns a pointer to a valid UserGroupType
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewUserGroupTypeFromValue(v string) (*UserGroupType, error) {
	ev := UserGroupType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for UserGroupType: valid values are %v", v, AllowedUserGroupTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v UserGroupType) IsValid() bool {
	for _, existing := range AllowedUserGroupTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to UserGroup.Type value
func (v UserGroupType) Ptr() *UserGroupType {
	return &v
}

type NullableUserGroupType struct {
	value *UserGroupType
	isSet bool
}

func (v NullableUserGroupType) Get() *UserGroupType {
	return v.value
}

func (v *NullableUserGroupType) Set(val *UserGroupType) {
	v.value = val
	v.isSet = true
}

func (v NullableUserGroupType) IsSet() bool {
	return v.isSet
}

func (v *NullableUserGroupType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUserGroupType(val *UserGroupType) *NullableUserGroupType {
	return &NullableUserGroupType{value: val, isSet: true}
}

func (v NullableUserGroupType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableUserGroupType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
