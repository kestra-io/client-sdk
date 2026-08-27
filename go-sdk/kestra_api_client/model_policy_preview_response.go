/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyPreviewResponse type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyPreviewResponse{}

// PolicyPreviewResponse struct for PolicyPreviewResponse
type PolicyPreviewResponse struct {
	ResolvedSource       *string           `json:"resolvedSource,omitempty"`
	Mutations            []PolicyMutation  `json:"mutations,omitempty"`
	Violations           []PolicyViolation `json:"violations,omitempty"`
	Conflicts            []PolicyConflict  `json:"conflicts,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyPreviewResponse PolicyPreviewResponse

// NewPolicyPreviewResponse instantiates a new PolicyPreviewResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyPreviewResponse() *PolicyPreviewResponse {
	this := PolicyPreviewResponse{}

	return &this
}

// NewPolicyPreviewResponseWithDefaults instantiates a new PolicyPreviewResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyPreviewResponseWithDefaults() *PolicyPreviewResponse {
	this := PolicyPreviewResponse{}
	return &this
}

// GetResolvedSource returns the ResolvedSource field value if set, zero value otherwise.
func (o *PolicyPreviewResponse) GetResolvedSource() string {
	if o == nil || IsNil(o.ResolvedSource) {
		var ret string
		return ret
	}
	return *o.ResolvedSource
}

// GetResolvedSourceOk returns a tuple with the ResolvedSource field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyPreviewResponse) GetResolvedSourceOk() (*string, bool) {
	if o == nil || IsNil(o.ResolvedSource) {
		return nil, false
	}
	return o.ResolvedSource, true
}

// HasResolvedSource returns a boolean if a field has been set.
func (o *PolicyPreviewResponse) HasResolvedSource() bool {
	if o != nil && !IsNil(o.ResolvedSource) {
		return true
	}

	return false
}

// SetResolvedSource gets a reference to the given string and assigns it to the ResolvedSource field.
func (o *PolicyPreviewResponse) SetResolvedSource(v string) {
	o.ResolvedSource = &v
}

// GetMutations returns the Mutations field value if set, zero value otherwise.
func (o *PolicyPreviewResponse) GetMutations() []PolicyMutation {
	if o == nil || IsNil(o.Mutations) {
		var ret []PolicyMutation
		return ret
	}
	return o.Mutations
}

// GetMutationsOk returns a tuple with the Mutations field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyPreviewResponse) GetMutationsOk() (*[]PolicyMutation, bool) {
	if o == nil || IsNil(o.Mutations) {
		return nil, false
	}
	return &o.Mutations, true
}

// HasMutations returns a boolean if a field has been set.
func (o *PolicyPreviewResponse) HasMutations() bool {
	if o != nil && !IsNil(o.Mutations) {
		return true
	}

	return false
}

// SetMutations gets a reference to the given []PolicyMutation and assigns it to the Mutations field.
func (o *PolicyPreviewResponse) SetMutations(v []PolicyMutation) {
	o.Mutations = v
}

// GetViolations returns the Violations field value if set, zero value otherwise.
func (o *PolicyPreviewResponse) GetViolations() []PolicyViolation {
	if o == nil || IsNil(o.Violations) {
		var ret []PolicyViolation
		return ret
	}
	return o.Violations
}

// GetViolationsOk returns a tuple with the Violations field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyPreviewResponse) GetViolationsOk() (*[]PolicyViolation, bool) {
	if o == nil || IsNil(o.Violations) {
		return nil, false
	}
	return &o.Violations, true
}

// HasViolations returns a boolean if a field has been set.
func (o *PolicyPreviewResponse) HasViolations() bool {
	if o != nil && !IsNil(o.Violations) {
		return true
	}

	return false
}

// SetViolations gets a reference to the given []PolicyViolation and assigns it to the Violations field.
func (o *PolicyPreviewResponse) SetViolations(v []PolicyViolation) {
	o.Violations = v
}

// GetConflicts returns the Conflicts field value if set, zero value otherwise.
func (o *PolicyPreviewResponse) GetConflicts() []PolicyConflict {
	if o == nil || IsNil(o.Conflicts) {
		var ret []PolicyConflict
		return ret
	}
	return o.Conflicts
}

// GetConflictsOk returns a tuple with the Conflicts field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyPreviewResponse) GetConflictsOk() (*[]PolicyConflict, bool) {
	if o == nil || IsNil(o.Conflicts) {
		return nil, false
	}
	return &o.Conflicts, true
}

// HasConflicts returns a boolean if a field has been set.
func (o *PolicyPreviewResponse) HasConflicts() bool {
	if o != nil && !IsNil(o.Conflicts) {
		return true
	}

	return false
}

// SetConflicts gets a reference to the given []PolicyConflict and assigns it to the Conflicts field.
func (o *PolicyPreviewResponse) SetConflicts(v []PolicyConflict) {
	o.Conflicts = v
}

func (o PolicyPreviewResponse) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyPreviewResponse) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.ResolvedSource) {
		toSerialize["resolvedSource"] = o.ResolvedSource
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

func (o *PolicyPreviewResponse) UnmarshalJSON(data []byte) (err error) {
	varPolicyPreviewResponse := _PolicyPreviewResponse{}

	err = json.Unmarshal(data, &varPolicyPreviewResponse)

	if err != nil {
		return err
	}

	*o = PolicyPreviewResponse(varPolicyPreviewResponse)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "resolvedSource")
		delete(additionalProperties, "mutations")
		delete(additionalProperties, "violations")
		delete(additionalProperties, "conflicts")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyPreviewResponse struct {
	value *PolicyPreviewResponse
	isSet bool
}

func (v NullablePolicyPreviewResponse) Get() *PolicyPreviewResponse {
	return v.value
}

func (v *NullablePolicyPreviewResponse) Set(val *PolicyPreviewResponse) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyPreviewResponse) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyPreviewResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyPreviewResponse(val *PolicyPreviewResponse) *NullablePolicyPreviewResponse {
	return &NullablePolicyPreviewResponse{value: val, isSet: true}
}

func (v NullablePolicyPreviewResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyPreviewResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
