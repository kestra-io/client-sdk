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

// checks if the BulkErrorResponse type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &BulkErrorResponse{}

// BulkErrorResponse struct for BulkErrorResponse
type BulkErrorResponse struct {
	Message              *string     `json:"message,omitempty"`
	Invalids             interface{} `json:"invalids,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _BulkErrorResponse BulkErrorResponse

// NewBulkErrorResponse instantiates a new BulkErrorResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewBulkErrorResponse() *BulkErrorResponse {
	this := BulkErrorResponse{}
	return &this
}

// NewBulkErrorResponseWithDefaults instantiates a new BulkErrorResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewBulkErrorResponseWithDefaults() *BulkErrorResponse {
	this := BulkErrorResponse{}
	return &this
}

// GetMessage returns the Message field value if set, zero value otherwise.
func (o *BulkErrorResponse) GetMessage() string {
	if o == nil || IsNil(o.Message) {
		var ret string
		return ret
	}
	return *o.Message
}

// GetMessageOk returns a tuple with the Message field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BulkErrorResponse) GetMessageOk() (*string, bool) {
	if o == nil || IsNil(o.Message) {
		return nil, false
	}
	return o.Message, true
}

// HasMessage returns a boolean if a field has been set.
func (o *BulkErrorResponse) HasMessage() bool {
	if o != nil && !IsNil(o.Message) {
		return true
	}

	return false
}

// SetMessage gets a reference to the given string and assigns it to the Message field.
func (o *BulkErrorResponse) SetMessage(v string) {
	o.Message = &v
}

// GetInvalids returns the Invalids field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *BulkErrorResponse) GetInvalids() interface{} {
	if o == nil {
		var ret interface{}
		return ret
	}
	return o.Invalids
}

// GetInvalidsOk returns a tuple with the Invalids field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *BulkErrorResponse) GetInvalidsOk() (*interface{}, bool) {
	if o == nil || IsNil(o.Invalids) {
		return nil, false
	}
	return &o.Invalids, true
}

// HasInvalids returns a boolean if a field has been set.
func (o *BulkErrorResponse) HasInvalids() bool {
	if o != nil && !IsNil(o.Invalids) {
		return true
	}

	return false
}

// SetInvalids gets a reference to the given interface{} and assigns it to the Invalids field.
func (o *BulkErrorResponse) SetInvalids(v interface{}) {
	o.Invalids = v
}

func (o BulkErrorResponse) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o BulkErrorResponse) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Message) {
		toSerialize["message"] = o.Message
	}
	if o.Invalids != nil {
		toSerialize["invalids"] = o.Invalids
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *BulkErrorResponse) UnmarshalJSON(data []byte) (err error) {
	varBulkErrorResponse := _BulkErrorResponse{}

	err = json.Unmarshal(data, &varBulkErrorResponse)

	if err != nil {
		return err
	}

	*o = BulkErrorResponse(varBulkErrorResponse)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "message")
		delete(additionalProperties, "invalids")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableBulkErrorResponse struct {
	value *BulkErrorResponse
	isSet bool
}

func (v NullableBulkErrorResponse) Get() *BulkErrorResponse {
	return v.value
}

func (v *NullableBulkErrorResponse) Set(val *BulkErrorResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableBulkErrorResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableBulkErrorResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBulkErrorResponse(val *BulkErrorResponse) *NullableBulkErrorResponse {
	return &NullableBulkErrorResponse{value: val, isSet: true}
}

func (v NullableBulkErrorResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBulkErrorResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
