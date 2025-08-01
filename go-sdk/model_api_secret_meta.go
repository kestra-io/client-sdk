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

// checks if the ApiSecretMeta type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ApiSecretMeta{}

// ApiSecretMeta struct for ApiSecretMeta
type ApiSecretMeta struct {
	Key                  string `json:"key"`
	AdditionalProperties map[string]interface{}
}

type _ApiSecretMeta ApiSecretMeta

// NewApiSecretMeta instantiates a new ApiSecretMeta object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewApiSecretMeta(key string) *ApiSecretMeta {
	this := ApiSecretMeta{}
	this.Key = key
	return &this
}

// NewApiSecretMetaWithDefaults instantiates a new ApiSecretMeta object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewApiSecretMetaWithDefaults() *ApiSecretMeta {
	this := ApiSecretMeta{}
	return &this
}

// GetKey returns the Key field value
func (o *ApiSecretMeta) GetKey() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Key
}

// GetKeyOk returns a tuple with the Key field value
// and a boolean to check if the value has been set.
func (o *ApiSecretMeta) GetKeyOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Key, true
}

// SetKey sets field value
func (o *ApiSecretMeta) SetKey(v string) {
	o.Key = v
}

func (o ApiSecretMeta) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ApiSecretMeta) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["key"] = o.Key

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ApiSecretMeta) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"key",
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

	varApiSecretMeta := _ApiSecretMeta{}

	err = json.Unmarshal(data, &varApiSecretMeta)

	if err != nil {
		return err
	}

	*o = ApiSecretMeta(varApiSecretMeta)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "key")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableApiSecretMeta struct {
	value *ApiSecretMeta
	isSet bool
}

func (v NullableApiSecretMeta) Get() *ApiSecretMeta {
	return v.value
}

func (v *NullableApiSecretMeta) Set(val *ApiSecretMeta) {
	v.value = val
	v.isSet = true
}

func (v NullableApiSecretMeta) IsSet() bool {
	return v.isSet
}

func (v *NullableApiSecretMeta) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiSecretMeta(val *ApiSecretMeta) *NullableApiSecretMeta {
	return &NullableApiSecretMeta{value: val, isSet: true}
}

func (v NullableApiSecretMeta) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableApiSecretMeta) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
