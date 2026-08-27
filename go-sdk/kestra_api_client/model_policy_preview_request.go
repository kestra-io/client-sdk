/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PolicyPreviewRequest type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PolicyPreviewRequest{}

// PolicyPreviewRequest struct for PolicyPreviewRequest
type PolicyPreviewRequest struct {
	Namespace            string `json:"namespace"`
	Source               string `json:"source"`
	AdditionalProperties map[string]interface{}
}

type _PolicyPreviewRequest PolicyPreviewRequest

// NewPolicyPreviewRequest instantiates a new PolicyPreviewRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPolicyPreviewRequest(namespace string, source string) *PolicyPreviewRequest {
	this := PolicyPreviewRequest{}
	this.Namespace = namespace
	this.Source = source
	return &this
}

// NewPolicyPreviewRequestWithDefaults instantiates a new PolicyPreviewRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPolicyPreviewRequestWithDefaults() *PolicyPreviewRequest {
	this := PolicyPreviewRequest{}
	return &this
}

// GetNamespace returns the Namespace field value
func (o *PolicyPreviewRequest) GetNamespace() string {
	if o == nil {
		var ret string
		return ret
	}
	return o.Namespace
}

// GetNamespaceOk returns a tuple with the Namespace field value
// and a boolean to check if the value has been set.
func (o *PolicyPreviewRequest) GetNamespaceOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Namespace, true
}

// SetNamespace sets field value
func (o *PolicyPreviewRequest) SetNamespace(v string) {
	o.Namespace = v
}

// GetSource returns the Source field value
func (o *PolicyPreviewRequest) GetSource() string {
	if o == nil {
		var ret string
		return ret
	}
	return o.Source
}

// GetSourceOk returns a tuple with the Source field value
// and a boolean to check if the value has been set.
func (o *PolicyPreviewRequest) GetSourceOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Source, true
}

// SetSource sets field value
func (o *PolicyPreviewRequest) SetSource(v string) {
	o.Source = v
}

func (o PolicyPreviewRequest) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PolicyPreviewRequest) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["namespace"] = o.Namespace
	toSerialize["source"] = o.Source

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PolicyPreviewRequest) UnmarshalJSON(data []byte) (err error) {
	varPolicyPreviewRequest := _PolicyPreviewRequest{}

	err = json.Unmarshal(data, &varPolicyPreviewRequest)

	if err != nil {
		return err
	}

	*o = PolicyPreviewRequest(varPolicyPreviewRequest)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "namespace")
		delete(additionalProperties, "source")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePolicyPreviewRequest struct {
	value *PolicyPreviewRequest
	isSet bool
}

func (v NullablePolicyPreviewRequest) Get() *PolicyPreviewRequest {
	return v.value
}

func (v *NullablePolicyPreviewRequest) Set(val *PolicyPreviewRequest) {
	v.value = val
	v.isSet = true
}

func (v NullablePolicyPreviewRequest) IsSet() bool {
	return v.isSet
}

func (v *NullablePolicyPreviewRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePolicyPreviewRequest(val *PolicyPreviewRequest) *NullablePolicyPreviewRequest {
	return &NullablePolicyPreviewRequest{value: val, isSet: true}
}

func (v NullablePolicyPreviewRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePolicyPreviewRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
