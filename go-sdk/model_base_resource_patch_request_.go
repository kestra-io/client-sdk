/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
)

// checks if the BaseResourcePatchRequest type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &BaseResourcePatchRequest{}

// BaseResourcePatchRequest struct for BaseResourcePatchRequest
type BaseResourcePatchRequest struct {
	Schemas              []string `json:"schemas,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _BaseResourcePatchRequest BaseResourcePatchRequest

// NewBaseResourcePatchRequest instantiates a new BaseResourcePatchRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewBaseResourcePatchRequest() *BaseResourcePatchRequest {
	this := BaseResourcePatchRequest{}
	return &this
}

// NewBaseResourcePatchRequestWithDefaults instantiates a new BaseResourcePatchRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewBaseResourcePatchRequestWithDefaults() *BaseResourcePatchRequest {
	this := BaseResourcePatchRequest{}
	return &this
}

// GetSchemas returns the Schemas field value if set, zero value otherwise.
func (o *BaseResourcePatchRequest) GetSchemas() []string {
	if o == nil || IsNil(o.Schemas) {
		var ret []string
		return ret
	}
	return o.Schemas
}

// GetSchemasOk returns a tuple with the Schemas field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseResourcePatchRequest) GetSchemasOk() ([]string, bool) {
	if o == nil || IsNil(o.Schemas) {
		return nil, false
	}
	return o.Schemas, true
}

// HasSchemas returns a boolean if a field has been set.
func (o *BaseResourcePatchRequest) HasSchemas() bool {
	if o != nil && !IsNil(o.Schemas) {
		return true
	}

	return false
}

// SetSchemas gets a reference to the given []string and assigns it to the Schemas field.
func (o *BaseResourcePatchRequest) SetSchemas(v []string) {
	o.Schemas = v
}

func (o BaseResourcePatchRequest) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o BaseResourcePatchRequest) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Schemas) {
		toSerialize["schemas"] = o.Schemas
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *BaseResourcePatchRequest) UnmarshalJSON(data []byte) (err error) {
	varBaseResourcePatchRequest := _BaseResourcePatchRequest{}

	err = json.Unmarshal(data, &varBaseResourcePatchRequest)

	if err != nil {
		return err
	}

	*o = BaseResourcePatchRequest(varBaseResourcePatchRequest)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "schemas")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableBaseResourcePatchRequest struct {
	value *BaseResourcePatchRequest
	isSet bool
}

func (v NullableBaseResourcePatchRequest) Get() *BaseResourcePatchRequest {
	return v.value
}

func (v *NullableBaseResourcePatchRequest) Set(val *BaseResourcePatchRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableBaseResourcePatchRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableBaseResourcePatchRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBaseResourcePatchRequest(val *BaseResourcePatchRequest) *NullableBaseResourcePatchRequest {
	return &NullableBaseResourcePatchRequest{value: val, isSet: true}
}

func (v NullableBaseResourcePatchRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBaseResourcePatchRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
