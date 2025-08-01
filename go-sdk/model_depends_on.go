/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
)

// checks if the DependsOn type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &DependsOn{}

// DependsOn struct for DependsOn
type DependsOn struct {
	Inputs               []string       `json:"inputs,omitempty"`
	Condition            NullableString `json:"condition,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _DependsOn DependsOn

// NewDependsOn instantiates a new DependsOn object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewDependsOn() *DependsOn {
	this := DependsOn{}
	return &this
}

// NewDependsOnWithDefaults instantiates a new DependsOn object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewDependsOnWithDefaults() *DependsOn {
	this := DependsOn{}
	return &this
}

// GetInputs returns the Inputs field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *DependsOn) GetInputs() []string {
	if o == nil {
		var ret []string
		return ret
	}
	return o.Inputs
}

// GetInputsOk returns a tuple with the Inputs field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *DependsOn) GetInputsOk() ([]string, bool) {
	if o == nil || IsNil(o.Inputs) {
		return nil, false
	}
	return o.Inputs, true
}

// HasInputs returns a boolean if a field has been set.
func (o *DependsOn) HasInputs() bool {
	if o != nil && !IsNil(o.Inputs) {
		return true
	}

	return false
}

// SetInputs gets a reference to the given []string and assigns it to the Inputs field.
func (o *DependsOn) SetInputs(v []string) {
	o.Inputs = v
}

// GetCondition returns the Condition field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *DependsOn) GetCondition() string {
	if o == nil || IsNil(o.Condition.Get()) {
		var ret string
		return ret
	}
	return *o.Condition.Get()
}

// GetConditionOk returns a tuple with the Condition field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *DependsOn) GetConditionOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return o.Condition.Get(), o.Condition.IsSet()
}

// HasCondition returns a boolean if a field has been set.
func (o *DependsOn) HasCondition() bool {
	if o != nil && o.Condition.IsSet() {
		return true
	}

	return false
}

// SetCondition gets a reference to the given NullableString and assigns it to the Condition field.
func (o *DependsOn) SetCondition(v string) {
	o.Condition.Set(&v)
}

// SetConditionNil sets the value for Condition to be an explicit nil
func (o *DependsOn) SetConditionNil() {
	o.Condition.Set(nil)
}

// UnsetCondition ensures that no value is present for Condition, not even an explicit nil
func (o *DependsOn) UnsetCondition() {
	o.Condition.Unset()
}

func (o DependsOn) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o DependsOn) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if o.Inputs != nil {
		toSerialize["inputs"] = o.Inputs
	}
	if o.Condition.IsSet() {
		toSerialize["condition"] = o.Condition.Get()
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *DependsOn) UnmarshalJSON(data []byte) (err error) {
	varDependsOn := _DependsOn{}

	err = json.Unmarshal(data, &varDependsOn)

	if err != nil {
		return err
	}

	*o = DependsOn(varDependsOn)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "inputs")
		delete(additionalProperties, "condition")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableDependsOn struct {
	value *DependsOn
	isSet bool
}

func (v NullableDependsOn) Get() *DependsOn {
	return v.value
}

func (v *NullableDependsOn) Set(val *DependsOn) {
	v.value = val
	v.isSet = true
}

func (v NullableDependsOn) IsSet() bool {
	return v.isSet
}

func (v *NullableDependsOn) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDependsOn(val *DependsOn) *NullableDependsOn {
	return &NullableDependsOn{value: val, isSet: true}
}

func (v NullableDependsOn) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableDependsOn) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
