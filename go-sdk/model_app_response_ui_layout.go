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

// checks if the AppResponseUILayout type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &AppResponseUILayout{}

// AppResponseUILayout struct for AppResponseUILayout
type AppResponseUILayout struct {
	Blocks               []map[string]interface{} `json:"blocks"`
	AdditionalProperties map[string]interface{}
}

type _AppResponseUILayout AppResponseUILayout

// NewAppResponseUILayout instantiates a new AppResponseUILayout object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAppResponseUILayout(blocks []map[string]interface{}) *AppResponseUILayout {
	this := AppResponseUILayout{}
	this.Blocks = blocks
	return &this
}

// NewAppResponseUILayoutWithDefaults instantiates a new AppResponseUILayout object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAppResponseUILayoutWithDefaults() *AppResponseUILayout {
	this := AppResponseUILayout{}
	return &this
}

// GetBlocks returns the Blocks field value
func (o *AppResponseUILayout) GetBlocks() []map[string]interface{} {
	if o == nil {
		var ret []map[string]interface{}
		return ret
	}

	return o.Blocks
}

// GetBlocksOk returns a tuple with the Blocks field value
// and a boolean to check if the value has been set.
func (o *AppResponseUILayout) GetBlocksOk() ([]map[string]interface{}, bool) {
	if o == nil {
		return nil, false
	}
	return o.Blocks, true
}

// SetBlocks sets field value
func (o *AppResponseUILayout) SetBlocks(v []map[string]interface{}) {
	o.Blocks = v
}

func (o AppResponseUILayout) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o AppResponseUILayout) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["blocks"] = o.Blocks

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *AppResponseUILayout) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"blocks",
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

	varAppResponseUILayout := _AppResponseUILayout{}

	err = json.Unmarshal(data, &varAppResponseUILayout)

	if err != nil {
		return err
	}

	*o = AppResponseUILayout(varAppResponseUILayout)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "blocks")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableAppResponseUILayout struct {
	value *AppResponseUILayout
	isSet bool
}

func (v NullableAppResponseUILayout) Get() *AppResponseUILayout {
	return v.value
}

func (v *NullableAppResponseUILayout) Set(val *AppResponseUILayout) {
	v.value = val
	v.isSet = true
}

func (v NullableAppResponseUILayout) IsSet() bool {
	return v.isSet
}

func (v *NullableAppResponseUILayout) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAppResponseUILayout(val *AppResponseUILayout) *NullableAppResponseUILayout {
	return &NullableAppResponseUILayout{value: val, isSet: true}
}

func (v NullableAppResponseUILayout) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAppResponseUILayout) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
