/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyMutation type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyMutation{}

// PolicyMutation struct for PolicyMutation
type PolicyMutation struct {
	Action               *ApiPolicyMutationAction `json:"action,omitempty"`
	Target               *string                  `json:"target,omitempty"`
	Value                *interface{}             `json:"value,omitempty"`
	PreviousValue        *interface{}             `json:"previousValue,omitempty"`
	PolicyId             *string                  `json:"policyId,omitempty"`
	Scope                *Scope                   `json:"scope,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyMutation PolicyMutation

// NewPolicyMutation instantiates a new PolicyMutation object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyMutation() *PolicyMutation {
	this := PolicyMutation{}

	return &this
}

// NewPolicyMutationWithDefaults instantiates a new PolicyMutation object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyMutationWithDefaults() *PolicyMutation {
	this := PolicyMutation{}
	return &this
}

// GetAction returns the Action field value if set, zero value otherwise.
func (o *PolicyMutation) GetAction() ApiPolicyMutationAction {
	if o == nil || IsNil(o.Action) {
		var ret ApiPolicyMutationAction
		return ret
	}
	return *o.Action
}

// GetActionOk returns a tuple with the Action field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyMutation) GetActionOk() (*ApiPolicyMutationAction, bool) {
	if o == nil || IsNil(o.Action) {
		return nil, false
	}
	return o.Action, true
}

// HasAction returns a boolean if a field has been set.
func (o *PolicyMutation) HasAction() bool {
	if o != nil && !IsNil(o.Action) {
		return true
	}

	return false
}

// SetAction gets a reference to the given ApiPolicyMutationAction and assigns it to the Action field.
func (o *PolicyMutation) SetAction(v ApiPolicyMutationAction) {
	o.Action = &v
}

// GetTarget returns the Target field value if set, zero value otherwise.
func (o *PolicyMutation) GetTarget() string {
	if o == nil || IsNil(o.Target) {
		var ret string
		return ret
	}
	return *o.Target
}

// GetTargetOk returns a tuple with the Target field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyMutation) GetTargetOk() (*string, bool) {
	if o == nil || IsNil(o.Target) {
		return nil, false
	}
	return o.Target, true
}

// HasTarget returns a boolean if a field has been set.
func (o *PolicyMutation) HasTarget() bool {
	if o != nil && !IsNil(o.Target) {
		return true
	}

	return false
}

// SetTarget gets a reference to the given string and assigns it to the Target field.
func (o *PolicyMutation) SetTarget(v string) {
	o.Target = &v
}

// GetValue returns the Value field value if set, zero value otherwise.
func (o *PolicyMutation) GetValue() interface{} {
	if o == nil || IsNil(o.Value) {
		var ret interface{}
		return ret
	}
	return *o.Value
}

// GetValueOk returns a tuple with the Value field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyMutation) GetValueOk() (*interface{}, bool) {
	if o == nil || IsNil(o.Value) {
		return nil, false
	}
	return o.Value, true
}

// HasValue returns a boolean if a field has been set.
func (o *PolicyMutation) HasValue() bool {
	if o != nil && !IsNil(o.Value) {
		return true
	}

	return false
}

// SetValue gets a reference to the given interface{} and assigns it to the Value field.
func (o *PolicyMutation) SetValue(v interface{}) {
	o.Value = &v
}

// GetPreviousValue returns the PreviousValue field value if set, zero value otherwise.
func (o *PolicyMutation) GetPreviousValue() interface{} {
	if o == nil || IsNil(o.PreviousValue) {
		var ret interface{}
		return ret
	}
	return *o.PreviousValue
}

// GetPreviousValueOk returns a tuple with the PreviousValue field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyMutation) GetPreviousValueOk() (*interface{}, bool) {
	if o == nil || IsNil(o.PreviousValue) {
		return nil, false
	}
	return o.PreviousValue, true
}

// HasPreviousValue returns a boolean if a field has been set.
func (o *PolicyMutation) HasPreviousValue() bool {
	if o != nil && !IsNil(o.PreviousValue) {
		return true
	}

	return false
}

// SetPreviousValue gets a reference to the given interface{} and assigns it to the PreviousValue field.
func (o *PolicyMutation) SetPreviousValue(v interface{}) {
	o.PreviousValue = &v
}

// GetPolicyId returns the PolicyId field value if set, zero value otherwise.
func (o *PolicyMutation) GetPolicyId() string {
	if o == nil || IsNil(o.PolicyId) {
		var ret string
		return ret
	}
	return *o.PolicyId
}

// GetPolicyIdOk returns a tuple with the PolicyId field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyMutation) GetPolicyIdOk() (*string, bool) {
	if o == nil || IsNil(o.PolicyId) {
		return nil, false
	}
	return o.PolicyId, true
}

// HasPolicyId returns a boolean if a field has been set.
func (o *PolicyMutation) HasPolicyId() bool {
	if o != nil && !IsNil(o.PolicyId) {
		return true
	}

	return false
}

// SetPolicyId gets a reference to the given string and assigns it to the PolicyId field.
func (o *PolicyMutation) SetPolicyId(v string) {
	o.PolicyId = &v
}

// GetScope returns the Scope field value if set, zero value otherwise.
func (o *PolicyMutation) GetScope() Scope {
	if o == nil || IsNil(o.Scope) {
		var ret Scope
		return ret
	}
	return *o.Scope
}

// GetScopeOk returns a tuple with the Scope field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyMutation) GetScopeOk() (*Scope, bool) {
	if o == nil || IsNil(o.Scope) {
		return nil, false
	}
	return o.Scope, true
}

// HasScope returns a boolean if a field has been set.
func (o *PolicyMutation) HasScope() bool {
	if o != nil && !IsNil(o.Scope) {
		return true
	}

	return false
}

// SetScope gets a reference to the given Scope and assigns it to the Scope field.
func (o *PolicyMutation) SetScope(v Scope) {
	o.Scope = &v
}

func (o PolicyMutation) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyMutation) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Action) {
		toSerialize["action"] = o.Action
	}
	if !IsNil(o.Target) {
		toSerialize["target"] = o.Target
	}
	if !IsNil(o.Value) {
		toSerialize["value"] = o.Value
	}
	if !IsNil(o.PreviousValue) {
		toSerialize["previousValue"] = o.PreviousValue
	}
	if !IsNil(o.PolicyId) {
		toSerialize["policyId"] = o.PolicyId
	}
	if !IsNil(o.Scope) {
		toSerialize["scope"] = o.Scope
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyMutation) UnmarshalJSON(data []byte) (err error) {
	varPolicyMutation := _PolicyMutation{}

	err = json.Unmarshal(data, &varPolicyMutation)

	if err != nil {
		return err
	}

	*o = PolicyMutation(varPolicyMutation)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "action")
		delete(additionalProperties, "target")
		delete(additionalProperties, "value")
		delete(additionalProperties, "previousValue")
		delete(additionalProperties, "policyId")
		delete(additionalProperties, "scope")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyMutation struct {
	value *PolicyMutation
	isSet bool
}

func (v NullablePolicyMutation) Get() *PolicyMutation {
	return v.value
}

func (v *NullablePolicyMutation) Set(val *PolicyMutation) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyMutation) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyMutation) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyMutation(val *PolicyMutation) *NullablePolicyMutation {
	return &NullablePolicyMutation{value: val, isSet: true}
}

func (v NullablePolicyMutation) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyMutation) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
