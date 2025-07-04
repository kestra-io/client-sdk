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

// checks if the ApiAuth type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ApiAuth{}

// ApiAuth struct for ApiAuth
type ApiAuth struct {
	Uid                  string `json:"uid"`
	Type                 string `json:"type"`
	Name                 string `json:"name"`
	AdditionalProperties map[string]interface{}
}

type _ApiAuth ApiAuth

// NewApiAuth instantiates a new ApiAuth object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewApiAuth(uid string, type_ string, name string) *ApiAuth {
	this := ApiAuth{}
	this.Uid = uid
	this.Type = type_
	this.Name = name
	return &this
}

// NewApiAuthWithDefaults instantiates a new ApiAuth object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewApiAuthWithDefaults() *ApiAuth {
	this := ApiAuth{}
	return &this
}

// GetUid returns the Uid field value
func (o *ApiAuth) GetUid() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Uid
}

// GetUidOk returns a tuple with the Uid field value
// and a boolean to check if the value has been set.
func (o *ApiAuth) GetUidOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Uid, true
}

// SetUid sets field value
func (o *ApiAuth) SetUid(v string) {
	o.Uid = v
}

// GetType returns the Type field value
func (o *ApiAuth) GetType() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Type
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
func (o *ApiAuth) GetTypeOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Type, true
}

// SetType sets field value
func (o *ApiAuth) SetType(v string) {
	o.Type = v
}

// GetName returns the Name field value
func (o *ApiAuth) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *ApiAuth) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *ApiAuth) SetName(v string) {
	o.Name = v
}

func (o ApiAuth) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ApiAuth) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["uid"] = o.Uid
	toSerialize["type"] = o.Type
	toSerialize["name"] = o.Name

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ApiAuth) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"uid",
		"type",
		"name",
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

	varApiAuth := _ApiAuth{}

	err = json.Unmarshal(data, &varApiAuth)

	if err != nil {
		return err
	}

	*o = ApiAuth(varApiAuth)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "uid")
		delete(additionalProperties, "type")
		delete(additionalProperties, "name")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableApiAuth struct {
	value *ApiAuth
	isSet bool
}

func (v NullableApiAuth) Get() *ApiAuth {
	return v.value
}

func (v *NullableApiAuth) Set(val *ApiAuth) {
	v.value = val
	v.isSet = true
}

func (v NullableApiAuth) IsSet() bool {
	return v.isSet
}

func (v *NullableApiAuth) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiAuth(val *ApiAuth) *NullableApiAuth {
	return &NullableApiAuth{value: val, isSet: true}
}

func (v NullableApiAuth) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableApiAuth) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
