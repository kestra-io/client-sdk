/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the ApiPolicyEvaluationResource type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ApiPolicyEvaluationResource{}

// ApiPolicyEvaluationResource struct for ApiPolicyEvaluationResource
type ApiPolicyEvaluationResource struct {
	Kind                 *string `json:"kind,omitempty"`
	Namespace            *string `json:"namespace,omitempty"`
	Id                   *string `json:"id,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _ApiPolicyEvaluationResource ApiPolicyEvaluationResource

// NewApiPolicyEvaluationResource instantiates a new ApiPolicyEvaluationResource object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewApiPolicyEvaluationResource() *ApiPolicyEvaluationResource {
	this := ApiPolicyEvaluationResource{}

	return &this
}

// NewApiPolicyEvaluationResourceWithDefaults instantiates a new ApiPolicyEvaluationResource object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewApiPolicyEvaluationResourceWithDefaults() *ApiPolicyEvaluationResource {
	this := ApiPolicyEvaluationResource{}
	return &this
}

// GetKind returns the Kind field value if set, zero value otherwise.
func (o *ApiPolicyEvaluationResource) GetKind() string {
	if o == nil || IsNil(o.Kind) {
		var ret string
		return ret
	}
	return *o.Kind
}

// GetKindOk returns a tuple with the Kind field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyEvaluationResource) GetKindOk() (*string, bool) {
	if o == nil || IsNil(o.Kind) {
		return nil, false
	}
	return o.Kind, true
}

// HasKind returns a boolean if a field has been set.
func (o *ApiPolicyEvaluationResource) HasKind() bool {
	if o != nil && !IsNil(o.Kind) {
		return true
	}

	return false
}

// SetKind gets a reference to the given string and assigns it to the Kind field.
func (o *ApiPolicyEvaluationResource) SetKind(v string) {
	o.Kind = &v
}

// GetNamespace returns the Namespace field value if set, zero value otherwise.
func (o *ApiPolicyEvaluationResource) GetNamespace() string {
	if o == nil || IsNil(o.Namespace) {
		var ret string
		return ret
	}
	return *o.Namespace
}

// GetNamespaceOk returns a tuple with the Namespace field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyEvaluationResource) GetNamespaceOk() (*string, bool) {
	if o == nil || IsNil(o.Namespace) {
		return nil, false
	}
	return o.Namespace, true
}

// HasNamespace returns a boolean if a field has been set.
func (o *ApiPolicyEvaluationResource) HasNamespace() bool {
	if o != nil && !IsNil(o.Namespace) {
		return true
	}

	return false
}

// SetNamespace gets a reference to the given string and assigns it to the Namespace field.
func (o *ApiPolicyEvaluationResource) SetNamespace(v string) {
	o.Namespace = &v
}

// GetId returns the Id field value if set, zero value otherwise.
func (o *ApiPolicyEvaluationResource) GetId() string {
	if o == nil || IsNil(o.Id) {
		var ret string
		return ret
	}
	return *o.Id
}

// GetIdOk returns a tuple with the Id field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyEvaluationResource) GetIdOk() (*string, bool) {
	if o == nil || IsNil(o.Id) {
		return nil, false
	}
	return o.Id, true
}

// HasId returns a boolean if a field has been set.
func (o *ApiPolicyEvaluationResource) HasId() bool {
	if o != nil && !IsNil(o.Id) {
		return true
	}

	return false
}

// SetId gets a reference to the given string and assigns it to the Id field.
func (o *ApiPolicyEvaluationResource) SetId(v string) {
	o.Id = &v
}

func (o ApiPolicyEvaluationResource) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ApiPolicyEvaluationResource) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Kind) {
		toSerialize["kind"] = o.Kind
	}
	if !IsNil(o.Namespace) {
		toSerialize["namespace"] = o.Namespace
	}
	if !IsNil(o.Id) {
		toSerialize["id"] = o.Id
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ApiPolicyEvaluationResource) UnmarshalJSON(data []byte) (err error) {
	varApiPolicyEvaluationResource := _ApiPolicyEvaluationResource{}

	err = json.Unmarshal(data, &varApiPolicyEvaluationResource)

	if err != nil {
		return err
	}

	*o = ApiPolicyEvaluationResource(varApiPolicyEvaluationResource)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "kind")
		delete(additionalProperties, "namespace")
		delete(additionalProperties, "id")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableApiPolicyEvaluationResource struct {
	value *ApiPolicyEvaluationResource
	isSet bool
}

func (v NullableApiPolicyEvaluationResource) Get() *ApiPolicyEvaluationResource {
	return v.value
}

func (v *NullableApiPolicyEvaluationResource) Set(val *ApiPolicyEvaluationResource) {
	v.value = val
	v.isSet = true
}

func (v NullableApiPolicyEvaluationResource) IsSet() bool {
	return v.isSet
}

func (v *NullableApiPolicyEvaluationResource) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiPolicyEvaluationResource(val *ApiPolicyEvaluationResource) *NullableApiPolicyEvaluationResource {
	return &NullableApiPolicyEvaluationResource{value: val, isSet: true}
}

func (v NullableApiPolicyEvaluationResource) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableApiPolicyEvaluationResource) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
