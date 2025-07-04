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

// checks if the AbstractBindingControllerApiBindingDetail type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &AbstractBindingControllerApiBindingDetail{}

// AbstractBindingControllerApiBindingDetail struct for AbstractBindingControllerApiBindingDetail
type AbstractBindingControllerApiBindingDetail struct {
	Binding              Binding `json:"binding"`
	Role                 Role    `json:"role"`
	User                 ApiUser `json:"user"`
	Group                Group   `json:"group"`
	AdditionalProperties map[string]interface{}
}

type _AbstractBindingControllerApiBindingDetail AbstractBindingControllerApiBindingDetail

// NewAbstractBindingControllerApiBindingDetail instantiates a new AbstractBindingControllerApiBindingDetail object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAbstractBindingControllerApiBindingDetail(binding Binding, role Role, user ApiUser, group Group) *AbstractBindingControllerApiBindingDetail {
	this := AbstractBindingControllerApiBindingDetail{}
	this.Binding = binding
	this.Role = role
	this.User = user
	this.Group = group
	return &this
}

// NewAbstractBindingControllerApiBindingDetailWithDefaults instantiates a new AbstractBindingControllerApiBindingDetail object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAbstractBindingControllerApiBindingDetailWithDefaults() *AbstractBindingControllerApiBindingDetail {
	this := AbstractBindingControllerApiBindingDetail{}
	return &this
}

// GetBinding returns the Binding field value
func (o *AbstractBindingControllerApiBindingDetail) GetBinding() Binding {
	if o == nil {
		var ret Binding
		return ret
	}

	return o.Binding
}

// GetBindingOk returns a tuple with the Binding field value
// and a boolean to check if the value has been set.
func (o *AbstractBindingControllerApiBindingDetail) GetBindingOk() (*Binding, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Binding, true
}

// SetBinding sets field value
func (o *AbstractBindingControllerApiBindingDetail) SetBinding(v Binding) {
	o.Binding = v
}

// GetRole returns the Role field value
func (o *AbstractBindingControllerApiBindingDetail) GetRole() Role {
	if o == nil {
		var ret Role
		return ret
	}

	return o.Role
}

// GetRoleOk returns a tuple with the Role field value
// and a boolean to check if the value has been set.
func (o *AbstractBindingControllerApiBindingDetail) GetRoleOk() (*Role, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Role, true
}

// SetRole sets field value
func (o *AbstractBindingControllerApiBindingDetail) SetRole(v Role) {
	o.Role = v
}

// GetUser returns the User field value
func (o *AbstractBindingControllerApiBindingDetail) GetUser() ApiUser {
	if o == nil {
		var ret ApiUser
		return ret
	}

	return o.User
}

// GetUserOk returns a tuple with the User field value
// and a boolean to check if the value has been set.
func (o *AbstractBindingControllerApiBindingDetail) GetUserOk() (*ApiUser, bool) {
	if o == nil {
		return nil, false
	}
	return &o.User, true
}

// SetUser sets field value
func (o *AbstractBindingControllerApiBindingDetail) SetUser(v ApiUser) {
	o.User = v
}

// GetGroup returns the Group field value
func (o *AbstractBindingControllerApiBindingDetail) GetGroup() Group {
	if o == nil {
		var ret Group
		return ret
	}

	return o.Group
}

// GetGroupOk returns a tuple with the Group field value
// and a boolean to check if the value has been set.
func (o *AbstractBindingControllerApiBindingDetail) GetGroupOk() (*Group, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Group, true
}

// SetGroup sets field value
func (o *AbstractBindingControllerApiBindingDetail) SetGroup(v Group) {
	o.Group = v
}

func (o AbstractBindingControllerApiBindingDetail) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o AbstractBindingControllerApiBindingDetail) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["binding"] = o.Binding
	toSerialize["role"] = o.Role
	toSerialize["user"] = o.User
	toSerialize["group"] = o.Group

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *AbstractBindingControllerApiBindingDetail) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"binding",
		"role",
		"user",
		"group",
	}

	allProperties := make(map[string]interface{})

	err = json.Unmarshal(data, &allProperties)

	if err != nil {
		return err
	}

	for _, requiredProperty := range requiredProperties {
		if _, exists := allProperties[requiredProperty]; !exists {
			return fmt.Errorf("no value given for required property %v", requiredProperty)
		}
	}

	varAbstractBindingControllerApiBindingDetail := _AbstractBindingControllerApiBindingDetail{}

	err = json.Unmarshal(data, &varAbstractBindingControllerApiBindingDetail)

	if err != nil {
		return err
	}

	*o = AbstractBindingControllerApiBindingDetail(varAbstractBindingControllerApiBindingDetail)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "binding")
		delete(additionalProperties, "role")
		delete(additionalProperties, "user")
		delete(additionalProperties, "group")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableAbstractBindingControllerApiBindingDetail struct {
	value *AbstractBindingControllerApiBindingDetail
	isSet bool
}

func (v NullableAbstractBindingControllerApiBindingDetail) Get() *AbstractBindingControllerApiBindingDetail {
	return v.value
}

func (v *NullableAbstractBindingControllerApiBindingDetail) Set(val *AbstractBindingControllerApiBindingDetail) {
	v.value = val
	v.isSet = true
}

func (v NullableAbstractBindingControllerApiBindingDetail) IsSet() bool {
	return v.isSet
}

func (v *NullableAbstractBindingControllerApiBindingDetail) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAbstractBindingControllerApiBindingDetail(val *AbstractBindingControllerApiBindingDetail) *NullableAbstractBindingControllerApiBindingDetail {
	return &NullableAbstractBindingControllerApiBindingDetail{value: val, isSet: true}
}

func (v NullableAbstractBindingControllerApiBindingDetail) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAbstractBindingControllerApiBindingDetail) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
