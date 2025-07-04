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

// checks if the MiscControllerPreview type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &MiscControllerPreview{}

// MiscControllerPreview struct for MiscControllerPreview
type MiscControllerPreview struct {
	Initial              int32 `json:"initial"`
	Max                  int32 `json:"max"`
	AdditionalProperties map[string]interface{}
}

type _MiscControllerPreview MiscControllerPreview

// NewMiscControllerPreview instantiates a new MiscControllerPreview object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewMiscControllerPreview(initial int32, max int32) *MiscControllerPreview {
	this := MiscControllerPreview{}
	this.Initial = initial
	this.Max = max
	return &this
}

// NewMiscControllerPreviewWithDefaults instantiates a new MiscControllerPreview object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewMiscControllerPreviewWithDefaults() *MiscControllerPreview {
	this := MiscControllerPreview{}
	return &this
}

// GetInitial returns the Initial field value
func (o *MiscControllerPreview) GetInitial() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Initial
}

// GetInitialOk returns a tuple with the Initial field value
// and a boolean to check if the value has been set.
func (o *MiscControllerPreview) GetInitialOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Initial, true
}

// SetInitial sets field value
func (o *MiscControllerPreview) SetInitial(v int32) {
	o.Initial = v
}

// GetMax returns the Max field value
func (o *MiscControllerPreview) GetMax() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Max
}

// GetMaxOk returns a tuple with the Max field value
// and a boolean to check if the value has been set.
func (o *MiscControllerPreview) GetMaxOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Max, true
}

// SetMax sets field value
func (o *MiscControllerPreview) SetMax(v int32) {
	o.Max = v
}

func (o MiscControllerPreview) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o MiscControllerPreview) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["initial"] = o.Initial
	toSerialize["max"] = o.Max

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *MiscControllerPreview) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"initial",
		"max",
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

	varMiscControllerPreview := _MiscControllerPreview{}

	err = json.Unmarshal(data, &varMiscControllerPreview)

	if err != nil {
		return err
	}

	*o = MiscControllerPreview(varMiscControllerPreview)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "initial")
		delete(additionalProperties, "max")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableMiscControllerPreview struct {
	value *MiscControllerPreview
	isSet bool
}

func (v NullableMiscControllerPreview) Get() *MiscControllerPreview {
	return v.value
}

func (v *NullableMiscControllerPreview) Set(val *MiscControllerPreview) {
	v.value = val
	v.isSet = true
}

func (v NullableMiscControllerPreview) IsSet() bool {
	return v.isSet
}

func (v *NullableMiscControllerPreview) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableMiscControllerPreview(val *MiscControllerPreview) *NullableMiscControllerPreview {
	return &NullableMiscControllerPreview{value: val, isSet: true}
}

func (v NullableMiscControllerPreview) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableMiscControllerPreview) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
