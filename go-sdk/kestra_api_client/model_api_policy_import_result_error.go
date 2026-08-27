/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the ApiPolicyImportResultError type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ApiPolicyImportResultError{}

// ApiPolicyImportResultError struct for ApiPolicyImportResultError
type ApiPolicyImportResultError struct {
	Document             *string `json:"document,omitempty"`
	Message              *string `json:"message,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _ApiPolicyImportResultError ApiPolicyImportResultError

// NewApiPolicyImportResultError instantiates a new ApiPolicyImportResultError object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewApiPolicyImportResultError() *ApiPolicyImportResultError {
	this := ApiPolicyImportResultError{}

	return &this
}

// NewApiPolicyImportResultErrorWithDefaults instantiates a new ApiPolicyImportResultError object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewApiPolicyImportResultErrorWithDefaults() *ApiPolicyImportResultError {
	this := ApiPolicyImportResultError{}
	return &this
}

// GetDocument returns the Document field value if set, zero value otherwise.
func (o *ApiPolicyImportResultError) GetDocument() string {
	if o == nil || IsNil(o.Document) {
		var ret string
		return ret
	}
	return *o.Document
}

// GetDocumentOk returns a tuple with the Document field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyImportResultError) GetDocumentOk() (*string, bool) {
	if o == nil || IsNil(o.Document) {
		return nil, false
	}
	return o.Document, true
}

// HasDocument returns a boolean if a field has been set.
func (o *ApiPolicyImportResultError) HasDocument() bool {
	if o != nil && !IsNil(o.Document) {
		return true
	}

	return false
}

// SetDocument gets a reference to the given string and assigns it to the Document field.
func (o *ApiPolicyImportResultError) SetDocument(v string) {
	o.Document = &v
}

// GetMessage returns the Message field value if set, zero value otherwise.
func (o *ApiPolicyImportResultError) GetMessage() string {
	if o == nil || IsNil(o.Message) {
		var ret string
		return ret
	}
	return *o.Message
}

// GetMessageOk returns a tuple with the Message field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiPolicyImportResultError) GetMessageOk() (*string, bool) {
	if o == nil || IsNil(o.Message) {
		return nil, false
	}
	return o.Message, true
}

// HasMessage returns a boolean if a field has been set.
func (o *ApiPolicyImportResultError) HasMessage() bool {
	if o != nil && !IsNil(o.Message) {
		return true
	}

	return false
}

// SetMessage gets a reference to the given string and assigns it to the Message field.
func (o *ApiPolicyImportResultError) SetMessage(v string) {
	o.Message = &v
}

func (o ApiPolicyImportResultError) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ApiPolicyImportResultError) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Document) {
		toSerialize["document"] = o.Document
	}
	if !IsNil(o.Message) {
		toSerialize["message"] = o.Message
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ApiPolicyImportResultError) UnmarshalJSON(data []byte) (err error) {
	varApiPolicyImportResultError := _ApiPolicyImportResultError{}

	err = json.Unmarshal(data, &varApiPolicyImportResultError)

	if err != nil {
		return err
	}

	*o = ApiPolicyImportResultError(varApiPolicyImportResultError)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "document")
		delete(additionalProperties, "message")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableApiPolicyImportResultError struct {
	value *ApiPolicyImportResultError
	isSet bool
}

func (v NullableApiPolicyImportResultError) Get() *ApiPolicyImportResultError {
	return v.value
}

func (v *NullableApiPolicyImportResultError) Set(val *ApiPolicyImportResultError) {
	v.value = val
	v.isSet = true
}

func (v NullableApiPolicyImportResultError) IsSet() bool {
	return v.isSet
}

func (v *NullableApiPolicyImportResultError) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiPolicyImportResultError(val *ApiPolicyImportResultError) *NullableApiPolicyImportResultError {
	return &NullableApiPolicyImportResultError{value: val, isSet: true}
}

func (v NullableApiPolicyImportResultError) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableApiPolicyImportResultError) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
