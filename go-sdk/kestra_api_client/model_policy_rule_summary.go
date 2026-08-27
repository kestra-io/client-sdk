/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyRuleSummary type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyRuleSummary{}

// PolicyRuleSummary struct for PolicyRuleSummary
type PolicyRuleSummary struct {
	Mutate               *int32 `json:"mutate,omitempty"`
	Validate             *int32 `json:"validate,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyRuleSummary PolicyRuleSummary

// NewPolicyRuleSummary instantiates a new PolicyRuleSummary object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyRuleSummary() *PolicyRuleSummary {
	this := PolicyRuleSummary{}

	return &this
}

// NewPolicyRuleSummaryWithDefaults instantiates a new PolicyRuleSummary object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyRuleSummaryWithDefaults() *PolicyRuleSummary {
	this := PolicyRuleSummary{}
	return &this
}

// GetMutate returns the Mutate field value if set, zero value otherwise.
func (o *PolicyRuleSummary) GetMutate() int32 {
	if o == nil || IsNil(o.Mutate) {
		var ret int32
		return ret
	}
	return *o.Mutate
}

// GetMutateOk returns a tuple with the Mutate field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyRuleSummary) GetMutateOk() (*int32, bool) {
	if o == nil || IsNil(o.Mutate) {
		return nil, false
	}
	return o.Mutate, true
}

// HasMutate returns a boolean if a field has been set.
func (o *PolicyRuleSummary) HasMutate() bool {
	if o != nil && !IsNil(o.Mutate) {
		return true
	}

	return false
}

// SetMutate gets a reference to the given int32 and assigns it to the Mutate field.
func (o *PolicyRuleSummary) SetMutate(v int32) {
	o.Mutate = &v
}

// GetValidate returns the Validate field value if set, zero value otherwise.
func (o *PolicyRuleSummary) GetValidate() int32 {
	if o == nil || IsNil(o.Validate) {
		var ret int32
		return ret
	}
	return *o.Validate
}

// GetValidateOk returns a tuple with the Validate field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyRuleSummary) GetValidateOk() (*int32, bool) {
	if o == nil || IsNil(o.Validate) {
		return nil, false
	}
	return o.Validate, true
}

// HasValidate returns a boolean if a field has been set.
func (o *PolicyRuleSummary) HasValidate() bool {
	if o != nil && !IsNil(o.Validate) {
		return true
	}

	return false
}

// SetValidate gets a reference to the given int32 and assigns it to the Validate field.
func (o *PolicyRuleSummary) SetValidate(v int32) {
	o.Validate = &v
}

func (o PolicyRuleSummary) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyRuleSummary) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Mutate) {
		toSerialize["mutate"] = o.Mutate
	}
	if !IsNil(o.Validate) {
		toSerialize["validate"] = o.Validate
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyRuleSummary) UnmarshalJSON(data []byte) (err error) {
	varPolicyRuleSummary := _PolicyRuleSummary{}

	err = json.Unmarshal(data, &varPolicyRuleSummary)

	if err != nil {
		return err
	}

	*o = PolicyRuleSummary(varPolicyRuleSummary)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "mutate")
		delete(additionalProperties, "validate")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyRuleSummary struct {
	value *PolicyRuleSummary
	isSet bool
}

func (v NullablePolicyRuleSummary) Get() *PolicyRuleSummary {
	return v.value
}

func (v *NullablePolicyRuleSummary) Set(val *PolicyRuleSummary) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyRuleSummary) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyRuleSummary) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyRuleSummary(val *PolicyRuleSummary) *NullablePolicyRuleSummary {
	return &NullablePolicyRuleSummary{value: val, isSet: true}
}

func (v NullablePolicyRuleSummary) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyRuleSummary) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
