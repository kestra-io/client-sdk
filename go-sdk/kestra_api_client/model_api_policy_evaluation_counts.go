/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the ApiPolicyEvaluationCounts type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ApiPolicyEvaluationCounts{}

// ApiPolicyEvaluationCounts struct for ApiPolicyEvaluationCounts
type ApiPolicyEvaluationCounts struct {
	Scanned              *int64 `json:"scanned,omitempty"`
	Mutated              *int64 `json:"mutated,omitempty"`
	Violating            *int64 `json:"violating,omitempty"`
	Conflicting          *int64 `json:"conflicting,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _ApiPolicyEvaluationCounts ApiPolicyEvaluationCounts

// NewApiPolicyEvaluationCounts instantiates a new ApiPolicyEvaluationCounts object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewApiPolicyEvaluationCounts() *ApiPolicyEvaluationCounts {
	this := ApiPolicyEvaluationCounts{}

	return &this
}

// NewApiPolicyEvaluationCountsWithDefaults instantiates a new ApiPolicyEvaluationCounts object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewApiPolicyEvaluationCountsWithDefaults() *ApiPolicyEvaluationCounts {
	this := ApiPolicyEvaluationCounts{}
	return &this
}

// GetScanned returns the Scanned field value if set, zero value otherwise.
func (o *ApiPolicyEvaluationCounts) GetScanned() int64 {
	if o == nil || IsNil(o.Scanned) {
		var ret int64
		return ret
	}
	return *o.Scanned
}

// GetScannedOk returns a tuple with the Scanned field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyEvaluationCounts) GetScannedOk() (*int64, bool) {
	if o == nil || IsNil(o.Scanned) {
		return nil, false
	}
	return o.Scanned, true
}

// HasScanned returns a boolean if a field has been set.
func (o *ApiPolicyEvaluationCounts) HasScanned() bool {
	if o != nil && !IsNil(o.Scanned) {
		return true
	}

	return false
}

// SetScanned gets a reference to the given int64 and assigns it to the Scanned field.
func (o *ApiPolicyEvaluationCounts) SetScanned(v int64) {
	o.Scanned = &v
}

// GetMutated returns the Mutated field value if set, zero value otherwise.
func (o *ApiPolicyEvaluationCounts) GetMutated() int64 {
	if o == nil || IsNil(o.Mutated) {
		var ret int64
		return ret
	}
	return *o.Mutated
}

// GetMutatedOk returns a tuple with the Mutated field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyEvaluationCounts) GetMutatedOk() (*int64, bool) {
	if o == nil || IsNil(o.Mutated) {
		return nil, false
	}
	return o.Mutated, true
}

// HasMutated returns a boolean if a field has been set.
func (o *ApiPolicyEvaluationCounts) HasMutated() bool {
	if o != nil && !IsNil(o.Mutated) {
		return true
	}

	return false
}

// SetMutated gets a reference to the given int64 and assigns it to the Mutated field.
func (o *ApiPolicyEvaluationCounts) SetMutated(v int64) {
	o.Mutated = &v
}

// GetViolating returns the Violating field value if set, zero value otherwise.
func (o *ApiPolicyEvaluationCounts) GetViolating() int64 {
	if o == nil || IsNil(o.Violating) {
		var ret int64
		return ret
	}
	return *o.Violating
}

// GetViolatingOk returns a tuple with the Violating field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyEvaluationCounts) GetViolatingOk() (*int64, bool) {
	if o == nil || IsNil(o.Violating) {
		return nil, false
	}
	return o.Violating, true
}

// HasViolating returns a boolean if a field has been set.
func (o *ApiPolicyEvaluationCounts) HasViolating() bool {
	if o != nil && !IsNil(o.Violating) {
		return true
	}

	return false
}

// SetViolating gets a reference to the given int64 and assigns it to the Violating field.
func (o *ApiPolicyEvaluationCounts) SetViolating(v int64) {
	o.Violating = &v
}

// GetConflicting returns the Conflicting field value if set, zero value otherwise.
func (o *ApiPolicyEvaluationCounts) GetConflicting() int64 {
	if o == nil || IsNil(o.Conflicting) {
		var ret int64
		return ret
	}
	return *o.Conflicting
}

// GetConflictingOk returns a tuple with the Conflicting field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyEvaluationCounts) GetConflictingOk() (*int64, bool) {
	if o == nil || IsNil(o.Conflicting) {
		return nil, false
	}
	return o.Conflicting, true
}

// HasConflicting returns a boolean if a field has been set.
func (o *ApiPolicyEvaluationCounts) HasConflicting() bool {
	if o != nil && !IsNil(o.Conflicting) {
		return true
	}

	return false
}

// SetConflicting gets a reference to the given int64 and assigns it to the Conflicting field.
func (o *ApiPolicyEvaluationCounts) SetConflicting(v int64) {
	o.Conflicting = &v
}

func (o ApiPolicyEvaluationCounts) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ApiPolicyEvaluationCounts) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Scanned) {
		toSerialize["scanned"] = o.Scanned
	}
	if !IsNil(o.Mutated) {
		toSerialize["mutated"] = o.Mutated
	}
	if !IsNil(o.Violating) {
		toSerialize["violating"] = o.Violating
	}
	if !IsNil(o.Conflicting) {
		toSerialize["conflicting"] = o.Conflicting
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ApiPolicyEvaluationCounts) UnmarshalJSON(data []byte) (err error) {
	varApiPolicyEvaluationCounts := _ApiPolicyEvaluationCounts{}

	err = json.Unmarshal(data, &varApiPolicyEvaluationCounts)

	if err != nil {
		return err
	}

	*o = ApiPolicyEvaluationCounts(varApiPolicyEvaluationCounts)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "scanned")
		delete(additionalProperties, "mutated")
		delete(additionalProperties, "violating")
		delete(additionalProperties, "conflicting")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableApiPolicyEvaluationCounts struct {
	value *ApiPolicyEvaluationCounts
	isSet bool
}

func (v NullableApiPolicyEvaluationCounts) Get() *ApiPolicyEvaluationCounts {
	return v.value
}

func (v *NullableApiPolicyEvaluationCounts) Set(val *ApiPolicyEvaluationCounts) {
	v.value = val
	v.isSet = true
}

func (v NullableApiPolicyEvaluationCounts) IsSet() bool {
	return v.isSet
}

func (v *NullableApiPolicyEvaluationCounts) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiPolicyEvaluationCounts(val *ApiPolicyEvaluationCounts) *NullableApiPolicyEvaluationCounts {
	return &NullableApiPolicyEvaluationCounts{value: val, isSet: true}
}

func (v NullableApiPolicyEvaluationCounts) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableApiPolicyEvaluationCounts) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
