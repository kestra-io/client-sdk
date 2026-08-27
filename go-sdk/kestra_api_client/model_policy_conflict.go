/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyConflict type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyConflict{}

// PolicyConflict struct for PolicyConflict
type PolicyConflict struct {
	Target               *string `json:"target,omitempty"`
	AddPolicyId          *string `json:"addPolicyId,omitempty"`
	AddScope             *Scope  `json:"addScope,omitempty"`
	DeletePolicyId       *string `json:"deletePolicyId,omitempty"`
	DeleteScope          *Scope  `json:"deleteScope,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyConflict PolicyConflict

// NewPolicyConflict instantiates a new PolicyConflict object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyConflict() *PolicyConflict {
	this := PolicyConflict{}

	return &this
}

// NewPolicyConflictWithDefaults instantiates a new PolicyConflict object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyConflictWithDefaults() *PolicyConflict {
	this := PolicyConflict{}
	return &this
}

// GetTarget returns the Target field value if set, zero value otherwise.
func (o *PolicyConflict) GetTarget() string {
	if o == nil || IsNil(o.Target) {
		var ret string
		return ret
	}
	return *o.Target
}

// GetTargetOk returns a tuple with the Target field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyConflict) GetTargetOk() (*string, bool) {
	if o == nil || IsNil(o.Target) {
		return nil, false
	}
	return o.Target, true
}

// HasTarget returns a boolean if a field has been set.
func (o *PolicyConflict) HasTarget() bool {
	if o != nil && !IsNil(o.Target) {
		return true
	}

	return false
}

// SetTarget gets a reference to the given string and assigns it to the Target field.
func (o *PolicyConflict) SetTarget(v string) {
	o.Target = &v
}

// GetAddPolicyId returns the AddPolicyId field value if set, zero value otherwise.
func (o *PolicyConflict) GetAddPolicyId() string {
	if o == nil || IsNil(o.AddPolicyId) {
		var ret string
		return ret
	}
	return *o.AddPolicyId
}

// GetAddPolicyIdOk returns a tuple with the AddPolicyId field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyConflict) GetAddPolicyIdOk() (*string, bool) {
	if o == nil || IsNil(o.AddPolicyId) {
		return nil, false
	}
	return o.AddPolicyId, true
}

// HasAddPolicyId returns a boolean if a field has been set.
func (o *PolicyConflict) HasAddPolicyId() bool {
	if o != nil && !IsNil(o.AddPolicyId) {
		return true
	}

	return false
}

// SetAddPolicyId gets a reference to the given string and assigns it to the AddPolicyId field.
func (o *PolicyConflict) SetAddPolicyId(v string) {
	o.AddPolicyId = &v
}

// GetAddScope returns the AddScope field value if set, zero value otherwise.
func (o *PolicyConflict) GetAddScope() Scope {
	if o == nil || IsNil(o.AddScope) {
		var ret Scope
		return ret
	}
	return *o.AddScope
}

// GetAddScopeOk returns a tuple with the AddScope field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyConflict) GetAddScopeOk() (*Scope, bool) {
	if o == nil || IsNil(o.AddScope) {
		return nil, false
	}
	return o.AddScope, true
}

// HasAddScope returns a boolean if a field has been set.
func (o *PolicyConflict) HasAddScope() bool {
	if o != nil && !IsNil(o.AddScope) {
		return true
	}

	return false
}

// SetAddScope gets a reference to the given Scope and assigns it to the AddScope field.
func (o *PolicyConflict) SetAddScope(v Scope) {
	o.AddScope = &v
}

// GetDeletePolicyId returns the DeletePolicyId field value if set, zero value otherwise.
func (o *PolicyConflict) GetDeletePolicyId() string {
	if o == nil || IsNil(o.DeletePolicyId) {
		var ret string
		return ret
	}
	return *o.DeletePolicyId
}

// GetDeletePolicyIdOk returns a tuple with the DeletePolicyId field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyConflict) GetDeletePolicyIdOk() (*string, bool) {
	if o == nil || IsNil(o.DeletePolicyId) {
		return nil, false
	}
	return o.DeletePolicyId, true
}

// HasDeletePolicyId returns a boolean if a field has been set.
func (o *PolicyConflict) HasDeletePolicyId() bool {
	if o != nil && !IsNil(o.DeletePolicyId) {
		return true
	}

	return false
}

// SetDeletePolicyId gets a reference to the given string and assigns it to the DeletePolicyId field.
func (o *PolicyConflict) SetDeletePolicyId(v string) {
	o.DeletePolicyId = &v
}

// GetDeleteScope returns the DeleteScope field value if set, zero value otherwise.
func (o *PolicyConflict) GetDeleteScope() Scope {
	if o == nil || IsNil(o.DeleteScope) {
		var ret Scope
		return ret
	}
	return *o.DeleteScope
}

// GetDeleteScopeOk returns a tuple with the DeleteScope field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyConflict) GetDeleteScopeOk() (*Scope, bool) {
	if o == nil || IsNil(o.DeleteScope) {
		return nil, false
	}
	return o.DeleteScope, true
}

// HasDeleteScope returns a boolean if a field has been set.
func (o *PolicyConflict) HasDeleteScope() bool {
	if o != nil && !IsNil(o.DeleteScope) {
		return true
	}

	return false
}

// SetDeleteScope gets a reference to the given Scope and assigns it to the DeleteScope field.
func (o *PolicyConflict) SetDeleteScope(v Scope) {
	o.DeleteScope = &v
}

func (o PolicyConflict) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyConflict) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Target) {
		toSerialize["target"] = o.Target
	}
	if !IsNil(o.AddPolicyId) {
		toSerialize["addPolicyId"] = o.AddPolicyId
	}
	if !IsNil(o.AddScope) {
		toSerialize["addScope"] = o.AddScope
	}
	if !IsNil(o.DeletePolicyId) {
		toSerialize["deletePolicyId"] = o.DeletePolicyId
	}
	if !IsNil(o.DeleteScope) {
		toSerialize["deleteScope"] = o.DeleteScope
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyConflict) UnmarshalJSON(data []byte) (err error) {
	varPolicyConflict := _PolicyConflict{}

	err = json.Unmarshal(data, &varPolicyConflict)

	if err != nil {
		return err
	}

	*o = PolicyConflict(varPolicyConflict)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "target")
		delete(additionalProperties, "addPolicyId")
		delete(additionalProperties, "addScope")
		delete(additionalProperties, "deletePolicyId")
		delete(additionalProperties, "deleteScope")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyConflict struct {
	value *PolicyConflict
	isSet bool
}

func (v NullablePolicyConflict) Get() *PolicyConflict {
	return v.value
}

func (v *NullablePolicyConflict) Set(val *PolicyConflict) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyConflict) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyConflict) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyConflict(val *PolicyConflict) *NullablePolicyConflict {
	return &NullablePolicyConflict{value: val, isSet: true}
}

func (v NullablePolicyConflict) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyConflict) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
