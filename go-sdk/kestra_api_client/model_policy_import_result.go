/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyImportResult type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyImportResult{}

// PolicyImportResult struct for PolicyImportResult
type PolicyImportResult struct {
	Imported             *int32                       `json:"imported,omitempty"`
	Errors               []ApiPolicyImportResultError `json:"errors,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _PolicyImportResult PolicyImportResult

// NewPolicyImportResult instantiates a new PolicyImportResult object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyImportResult() *PolicyImportResult {
	this := PolicyImportResult{}

	return &this
}

// NewPolicyImportResultWithDefaults instantiates a new PolicyImportResult object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyImportResultWithDefaults() *PolicyImportResult {
	this := PolicyImportResult{}
	return &this
}

// GetImported returns the Imported field value if set, zero value otherwise.
func (o *PolicyImportResult) GetImported() int32 {
	if o == nil || IsNil(o.Imported) {
		var ret int32
		return ret
	}
	return *o.Imported
}

// GetImportedOk returns a tuple with the Imported field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyImportResult) GetImportedOk() (*int32, bool) {
	if o == nil || IsNil(o.Imported) {
		return nil, false
	}
	return o.Imported, true
}

// HasImported returns a boolean if a field has been set.
func (o *PolicyImportResult) HasImported() bool {
	if o != nil && !IsNil(o.Imported) {
		return true
	}

	return false
}

// SetImported gets a reference to the given int32 and assigns it to the Imported field.
func (o *PolicyImportResult) SetImported(v int32) {
	o.Imported = &v
}

// GetErrors returns the Errors field value if set, zero value otherwise.
func (o *PolicyImportResult) GetErrors() []ApiPolicyImportResultError {
	if o == nil || IsNil(o.Errors) {
		var ret []ApiPolicyImportResultError
		return ret
	}
	return o.Errors
}

// GetErrorsOk returns a tuple with the Errors field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *PolicyImportResult) GetErrorsOk() (*[]ApiPolicyImportResultError, bool) {
	if o == nil || IsNil(o.Errors) {
		return nil, false
	}
	return &o.Errors, true
}

// HasErrors returns a boolean if a field has been set.
func (o *PolicyImportResult) HasErrors() bool {
	if o != nil && !IsNil(o.Errors) {
		return true
	}

	return false
}

// SetErrors gets a reference to the given []ApiPolicyImportResultError and assigns it to the Errors field.
func (o *PolicyImportResult) SetErrors(v []ApiPolicyImportResultError) {
	o.Errors = v
}

func (o PolicyImportResult) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyImportResult) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Imported) {
		toSerialize["imported"] = o.Imported
	}
	if !IsNil(o.Errors) {
		toSerialize["errors"] = o.Errors
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyImportResult) UnmarshalJSON(data []byte) (err error) {
	varPolicyImportResult := _PolicyImportResult{}

	err = json.Unmarshal(data, &varPolicyImportResult)

	if err != nil {
		return err
	}

	*o = PolicyImportResult(varPolicyImportResult)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "imported")
		delete(additionalProperties, "errors")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyImportResult struct {
	value *PolicyImportResult
	isSet bool
}

func (v NullablePolicyImportResult) Get() *PolicyImportResult {
	return v.value
}

func (v *NullablePolicyImportResult) Set(val *PolicyImportResult) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyImportResult) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyImportResult) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyImportResult(val *PolicyImportResult) *NullablePolicyImportResult {
	return &NullablePolicyImportResult{value: val, isSet: true}
}

func (v NullablePolicyImportResult) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyImportResult) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
