/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyEvaluationResult type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyEvaluationResult{}

// PolicyEvaluationResult struct for PolicyEvaluationResult
type PolicyEvaluationResult struct {
	Resource             *ApiPolicyEvaluationResource `json:"resource,omitempty"`
	Mutations            []PolicyMutation             `json:"mutations,omitempty"`
	Violations           []PolicyViolation            `json:"violations,omitempty"`
	Conflicts            []PolicyConflict             `json:"conflicts,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyEvaluationResult PolicyEvaluationResult

// NewPolicyEvaluationResult instantiates a new PolicyEvaluationResult object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyEvaluationResult() *PolicyEvaluationResult {
	this := PolicyEvaluationResult{}

	return &this
}

// NewPolicyEvaluationResultWithDefaults instantiates a new PolicyEvaluationResult object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyEvaluationResultWithDefaults() *PolicyEvaluationResult {
	this := PolicyEvaluationResult{}
	return &this
}

// GetResource returns the Resource field value if set, zero value otherwise.
func (o *PolicyEvaluationResult) GetResource() ApiPolicyEvaluationResource {
	if o == nil || IsNil(o.Resource) {
		var ret ApiPolicyEvaluationResource
		return ret
	}
	return *o.Resource
}

// GetResourceOk returns a tuple with the Resource field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyEvaluationResult) GetResourceOk() (*ApiPolicyEvaluationResource, bool) {
	if o == nil || IsNil(o.Resource) {
		return nil, false
	}
	return o.Resource, true
}

// HasResource returns a boolean if a field has been set.
func (o *PolicyEvaluationResult) HasResource() bool {
	if o != nil && !IsNil(o.Resource) {
		return true
	}

	return false
}

// SetResource gets a reference to the given ApiPolicyEvaluationResource and assigns it to the Resource field.
func (o *PolicyEvaluationResult) SetResource(v ApiPolicyEvaluationResource) {
	o.Resource = &v
}

// GetMutations returns the Mutations field value if set, zero value otherwise.
func (o *PolicyEvaluationResult) GetMutations() []PolicyMutation {
	if o == nil || IsNil(o.Mutations) {
		var ret []PolicyMutation
		return ret
	}
	return o.Mutations
}

// GetMutationsOk returns a tuple with the Mutations field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyEvaluationResult) GetMutationsOk() (*[]PolicyMutation, bool) {
	if o == nil || IsNil(o.Mutations) {
		return nil, false
	}
	return &o.Mutations, true
}

// HasMutations returns a boolean if a field has been set.
func (o *PolicyEvaluationResult) HasMutations() bool {
	if o != nil && !IsNil(o.Mutations) {
		return true
	}

	return false
}

// SetMutations gets a reference to the given []PolicyMutation and assigns it to the Mutations field.
func (o *PolicyEvaluationResult) SetMutations(v []PolicyMutation) {
	o.Mutations = v
}

// GetViolations returns the Violations field value if set, zero value otherwise.
func (o *PolicyEvaluationResult) GetViolations() []PolicyViolation {
	if o == nil || IsNil(o.Violations) {
		var ret []PolicyViolation
		return ret
	}
	return o.Violations
}

// GetViolationsOk returns a tuple with the Violations field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyEvaluationResult) GetViolationsOk() (*[]PolicyViolation, bool) {
	if o == nil || IsNil(o.Violations) {
		return nil, false
	}
	return &o.Violations, true
}

// HasViolations returns a boolean if a field has been set.
func (o *PolicyEvaluationResult) HasViolations() bool {
	if o != nil && !IsNil(o.Violations) {
		return true
	}

	return false
}

// SetViolations gets a reference to the given []PolicyViolation and assigns it to the Violations field.
func (o *PolicyEvaluationResult) SetViolations(v []PolicyViolation) {
	o.Violations = v
}

// GetConflicts returns the Conflicts field value if set, zero value otherwise.
func (o *PolicyEvaluationResult) GetConflicts() []PolicyConflict {
	if o == nil || IsNil(o.Conflicts) {
		var ret []PolicyConflict
		return ret
	}
	return o.Conflicts
}

// GetConflictsOk returns a tuple with the Conflicts field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyEvaluationResult) GetConflictsOk() (*[]PolicyConflict, bool) {
	if o == nil || IsNil(o.Conflicts) {
		return nil, false
	}
	return &o.Conflicts, true
}

// HasConflicts returns a boolean if a field has been set.
func (o *PolicyEvaluationResult) HasConflicts() bool {
	if o != nil && !IsNil(o.Conflicts) {
		return true
	}

	return false
}

// SetConflicts gets a reference to the given []PolicyConflict and assigns it to the Conflicts field.
func (o *PolicyEvaluationResult) SetConflicts(v []PolicyConflict) {
	o.Conflicts = v
}

func (o PolicyEvaluationResult) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyEvaluationResult) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Resource) {
		toSerialize["resource"] = o.Resource
	}
	if !IsNil(o.Mutations) {
		toSerialize["mutations"] = o.Mutations
	}
	if !IsNil(o.Violations) {
		toSerialize["violations"] = o.Violations
	}
	if !IsNil(o.Conflicts) {
		toSerialize["conflicts"] = o.Conflicts
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyEvaluationResult) UnmarshalJSON(data []byte) (err error) {
	varPolicyEvaluationResult := _PolicyEvaluationResult{}

	err = json.Unmarshal(data, &varPolicyEvaluationResult)

	if err != nil {
		return err
	}

	*o = PolicyEvaluationResult(varPolicyEvaluationResult)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "resource")
		delete(additionalProperties, "mutations")
		delete(additionalProperties, "violations")
		delete(additionalProperties, "conflicts")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyEvaluationResult struct {
	value *PolicyEvaluationResult
	isSet bool
}

func (v NullablePolicyEvaluationResult) Get() *PolicyEvaluationResult {
	return v.value
}

func (v *NullablePolicyEvaluationResult) Set(val *PolicyEvaluationResult) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyEvaluationResult) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyEvaluationResult) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyEvaluationResult(val *PolicyEvaluationResult) *NullablePolicyEvaluationResult {
	return &NullablePolicyEvaluationResult{value: val, isSet: true}
}

func (v NullablePolicyEvaluationResult) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyEvaluationResult) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
