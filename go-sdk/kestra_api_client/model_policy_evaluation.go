/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyEvaluation type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyEvaluation{}

// PolicyEvaluation struct for PolicyEvaluation
type PolicyEvaluation struct {
	Counts               *ApiPolicyEvaluationCounts `json:"counts,omitempty"`
	Total                *int64                     `json:"total,omitempty"`
	Results              []PolicyEvaluationResult   `json:"results,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyEvaluation PolicyEvaluation

// NewPolicyEvaluation instantiates a new PolicyEvaluation object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyEvaluation() *PolicyEvaluation {
	this := PolicyEvaluation{}

	return &this
}

// NewPolicyEvaluationWithDefaults instantiates a new PolicyEvaluation object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyEvaluationWithDefaults() *PolicyEvaluation {
	this := PolicyEvaluation{}
	return &this
}

// GetCounts returns the Counts field value if set, zero value otherwise.
func (o *PolicyEvaluation) GetCounts() ApiPolicyEvaluationCounts {
	if o == nil || IsNil(o.Counts) {
		var ret ApiPolicyEvaluationCounts
		return ret
	}
	return *o.Counts
}

// GetCountsOk returns a tuple with the Counts field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyEvaluation) GetCountsOk() (*ApiPolicyEvaluationCounts, bool) {
	if o == nil || IsNil(o.Counts) {
		return nil, false
	}
	return o.Counts, true
}

// HasCounts returns a boolean if a field has been set.
func (o *PolicyEvaluation) HasCounts() bool {
	if o != nil && !IsNil(o.Counts) {
		return true
	}

	return false
}

// SetCounts gets a reference to the given ApiPolicyEvaluationCounts and assigns it to the Counts field.
func (o *PolicyEvaluation) SetCounts(v ApiPolicyEvaluationCounts) {
	o.Counts = &v
}

// GetTotal returns the Total field value if set, zero value otherwise.
func (o *PolicyEvaluation) GetTotal() int64 {
	if o == nil || IsNil(o.Total) {
		var ret int64
		return ret
	}
	return *o.Total
}

// GetTotalOk returns a tuple with the Total field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyEvaluation) GetTotalOk() (*int64, bool) {
	if o == nil || IsNil(o.Total) {
		return nil, false
	}
	return o.Total, true
}

// HasTotal returns a boolean if a field has been set.
func (o *PolicyEvaluation) HasTotal() bool {
	if o != nil && !IsNil(o.Total) {
		return true
	}

	return false
}

// SetTotal gets a reference to the given int64 and assigns it to the Total field.
func (o *PolicyEvaluation) SetTotal(v int64) {
	o.Total = &v
}

// GetResults returns the Results field value if set, zero value otherwise.
func (o *PolicyEvaluation) GetResults() []PolicyEvaluationResult {
	if o == nil || IsNil(o.Results) {
		var ret []PolicyEvaluationResult
		return ret
	}
	return o.Results
}

// GetResultsOk returns a tuple with the Results field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyEvaluation) GetResultsOk() (*[]PolicyEvaluationResult, bool) {
	if o == nil || IsNil(o.Results) {
		return nil, false
	}
	return &o.Results, true
}

// HasResults returns a boolean if a field has been set.
func (o *PolicyEvaluation) HasResults() bool {
	if o != nil && !IsNil(o.Results) {
		return true
	}

	return false
}

// SetResults gets a reference to the given []PolicyEvaluationResult and assigns it to the Results field.
func (o *PolicyEvaluation) SetResults(v []PolicyEvaluationResult) {
	o.Results = v
}

func (o PolicyEvaluation) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyEvaluation) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Counts) {
		toSerialize["counts"] = o.Counts
	}
	if !IsNil(o.Total) {
		toSerialize["total"] = o.Total
	}
	if !IsNil(o.Results) {
		toSerialize["results"] = o.Results
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyEvaluation) UnmarshalJSON(data []byte) (err error) {
	varPolicyEvaluation := _PolicyEvaluation{}

	err = json.Unmarshal(data, &varPolicyEvaluation)

	if err != nil {
		return err
	}

	*o = PolicyEvaluation(varPolicyEvaluation)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "counts")
		delete(additionalProperties, "total")
		delete(additionalProperties, "results")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyEvaluation struct {
	value *PolicyEvaluation
	isSet bool
}

func (v NullablePolicyEvaluation) Get() *PolicyEvaluation {
	return v.value
}

func (v *NullablePolicyEvaluation) Set(val *PolicyEvaluation) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyEvaluation) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyEvaluation) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyEvaluation(val *PolicyEvaluation) *NullablePolicyEvaluation {
	return &NullablePolicyEvaluation{value: val, isSet: true}
}

func (v NullablePolicyEvaluation) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyEvaluation) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
