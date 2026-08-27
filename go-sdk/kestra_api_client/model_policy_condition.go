/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyCondition type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyCondition{}

// PolicyCondition struct for PolicyCondition
type PolicyCondition struct {
	Field                string                   `json:"field"`
	Operator             AbstractFilterFilterType `json:"operator"`
	Value                *interface{}             `json:"value,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyCondition PolicyCondition

// NewPolicyCondition instantiates a new PolicyCondition object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyCondition(field string, operator AbstractFilterFilterType) *PolicyCondition {
	this := PolicyCondition{}
	this.Field = field
	this.Operator = operator
	return &this
}

// NewPolicyConditionWithDefaults instantiates a new PolicyCondition object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyConditionWithDefaults() *PolicyCondition {
	this := PolicyCondition{}
	return &this
}

// GetField returns the Field field value
func (o *PolicyCondition) GetField() string {
	if o == nil {
		var ret string
		return ret
	}
	return o.Field
}

// GetFieldOk returns a tuple with the Field field value
// and a boolean to check if the value has been set.
func (o *PolicyCondition) GetFieldOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Field, true
}

// SetField sets field value
func (o *PolicyCondition) SetField(v string) {
	o.Field = v
}

// GetOperator returns the Operator field value
func (o *PolicyCondition) GetOperator() AbstractFilterFilterType {
	if o == nil {
		var ret AbstractFilterFilterType
		return ret
	}
	return o.Operator
}

// GetOperatorOk returns a tuple with the Operator field value
// and a boolean to check if the value has been set.
func (o *PolicyCondition) GetOperatorOk() (*AbstractFilterFilterType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Operator, true
}

// SetOperator sets field value
func (o *PolicyCondition) SetOperator(v AbstractFilterFilterType) {
	o.Operator = v
}

// GetValue returns the Value field value if set, zero value otherwise.
func (o *PolicyCondition) GetValue() interface{} {
	if o == nil || IsNil(o.Value) {
		var ret interface{}
		return ret
	}
	return *o.Value
}

// GetValueOk returns a tuple with the Value field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyCondition) GetValueOk() (*interface{}, bool) {
	if o == nil || IsNil(o.Value) {
		return nil, false
	}
	return o.Value, true
}

// HasValue returns a boolean if a field has been set.
func (o *PolicyCondition) HasValue() bool {
	if o != nil && !IsNil(o.Value) {
		return true
	}

	return false
}

// SetValue gets a reference to the given interface{} and assigns it to the Value field.
func (o *PolicyCondition) SetValue(v interface{}) {
	o.Value = &v
}

func (o PolicyCondition) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyCondition) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["field"] = o.Field
	toSerialize["operator"] = o.Operator
	if !IsNil(o.Value) {
		toSerialize["value"] = o.Value
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyCondition) UnmarshalJSON(data []byte) (err error) {
	varPolicyCondition := _PolicyCondition{}

	err = json.Unmarshal(data, &varPolicyCondition)

	if err != nil {
		return err
	}

	*o = PolicyCondition(varPolicyCondition)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "field")
		delete(additionalProperties, "operator")
		delete(additionalProperties, "value")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyCondition struct {
	value *PolicyCondition
	isSet bool
}

func (v NullablePolicyCondition) Get() *PolicyCondition {
	return v.value
}

func (v *NullablePolicyCondition) Set(val *PolicyCondition) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyCondition) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyCondition) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyCondition(val *PolicyCondition) *NullablePolicyCondition {
	return &NullablePolicyCondition{value: val, isSet: true}
}

func (v NullablePolicyCondition) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyCondition) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
