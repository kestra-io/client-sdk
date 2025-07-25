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

// checks if the EventAppResponse type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &EventAppResponse{}

// EventAppResponse struct for EventAppResponse
type EventAppResponse struct {
	Data                 *AppResponse `json:"data,omitempty"`
	Id                   *string      `json:"id,omitempty"`
	Name                 *string      `json:"name,omitempty"`
	Comment              *string      `json:"comment,omitempty"`
	Retry                *string      `json:"retry,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _EventAppResponse EventAppResponse

// NewEventAppResponse instantiates a new EventAppResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewEventAppResponse() *EventAppResponse {
	this := EventAppResponse{}
	return &this
}

// NewEventAppResponseWithDefaults instantiates a new EventAppResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewEventAppResponseWithDefaults() *EventAppResponse {
	this := EventAppResponse{}
	return &this
}

// GetData returns the Data field value if set, zero value otherwise.
func (o *EventAppResponse) GetData() AppResponse {
	if o == nil || IsNil(o.Data) {
		var ret AppResponse
		return ret
	}
	return *o.Data
}

// GetDataOk returns a tuple with the Data field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventAppResponse) GetDataOk() (*AppResponse, bool) {
	if o == nil || IsNil(o.Data) {
		return nil, false
	}
	return o.Data, true
}

// HasData returns a boolean if a field has been set.
func (o *EventAppResponse) HasData() bool {
	if o != nil && !IsNil(o.Data) {
		return true
	}

	return false
}

// SetData gets a reference to the given AppResponse and assigns it to the Data field.
func (o *EventAppResponse) SetData(v AppResponse) {
	o.Data = &v
}

// GetId returns the Id field value if set, zero value otherwise.
func (o *EventAppResponse) GetId() string {
	if o == nil || IsNil(o.Id) {
		var ret string
		return ret
	}
	return *o.Id
}

// GetIdOk returns a tuple with the Id field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventAppResponse) GetIdOk() (*string, bool) {
	if o == nil || IsNil(o.Id) {
		return nil, false
	}
	return o.Id, true
}

// HasId returns a boolean if a field has been set.
func (o *EventAppResponse) HasId() bool {
	if o != nil && !IsNil(o.Id) {
		return true
	}

	return false
}

// SetId gets a reference to the given string and assigns it to the Id field.
func (o *EventAppResponse) SetId(v string) {
	o.Id = &v
}

// GetName returns the Name field value if set, zero value otherwise.
func (o *EventAppResponse) GetName() string {
	if o == nil || IsNil(o.Name) {
		var ret string
		return ret
	}
	return *o.Name
}

// GetNameOk returns a tuple with the Name field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventAppResponse) GetNameOk() (*string, bool) {
	if o == nil || IsNil(o.Name) {
		return nil, false
	}
	return o.Name, true
}

// HasName returns a boolean if a field has been set.
func (o *EventAppResponse) HasName() bool {
	if o != nil && !IsNil(o.Name) {
		return true
	}

	return false
}

// SetName gets a reference to the given string and assigns it to the Name field.
func (o *EventAppResponse) SetName(v string) {
	o.Name = &v
}

// GetComment returns the Comment field value if set, zero value otherwise.
func (o *EventAppResponse) GetComment() string {
	if o == nil || IsNil(o.Comment) {
		var ret string
		return ret
	}
	return *o.Comment
}

// GetCommentOk returns a tuple with the Comment field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventAppResponse) GetCommentOk() (*string, bool) {
	if o == nil || IsNil(o.Comment) {
		return nil, false
	}
	return o.Comment, true
}

// HasComment returns a boolean if a field has been set.
func (o *EventAppResponse) HasComment() bool {
	if o != nil && !IsNil(o.Comment) {
		return true
	}

	return false
}

// SetComment gets a reference to the given string and assigns it to the Comment field.
func (o *EventAppResponse) SetComment(v string) {
	o.Comment = &v
}

// GetRetry returns the Retry field value if set, zero value otherwise.
func (o *EventAppResponse) GetRetry() string {
	if o == nil || IsNil(o.Retry) {
		var ret string
		return ret
	}
	return *o.Retry
}

// GetRetryOk returns a tuple with the Retry field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventAppResponse) GetRetryOk() (*string, bool) {
	if o == nil || IsNil(o.Retry) {
		return nil, false
	}
	return o.Retry, true
}

// HasRetry returns a boolean if a field has been set.
func (o *EventAppResponse) HasRetry() bool {
	if o != nil && !IsNil(o.Retry) {
		return true
	}

	return false
}

// SetRetry gets a reference to the given string and assigns it to the Retry field.
func (o *EventAppResponse) SetRetry(v string) {
	o.Retry = &v
}

func (o EventAppResponse) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o EventAppResponse) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Data) {
		toSerialize["data"] = o.Data
	}
	if !IsNil(o.Id) {
		toSerialize["id"] = o.Id
	}
	if !IsNil(o.Name) {
		toSerialize["name"] = o.Name
	}
	if !IsNil(o.Comment) {
		toSerialize["comment"] = o.Comment
	}
	if !IsNil(o.Retry) {
		toSerialize["retry"] = o.Retry
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *EventAppResponse) UnmarshalJSON(data []byte) (err error) {
	varEventAppResponse := _EventAppResponse{}

	err = json.Unmarshal(data, &varEventAppResponse)

	if err != nil {
		return err
	}

	*o = EventAppResponse(varEventAppResponse)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "data")
		delete(additionalProperties, "id")
		delete(additionalProperties, "name")
		delete(additionalProperties, "comment")
		delete(additionalProperties, "retry")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableEventAppResponse struct {
	value *EventAppResponse
	isSet bool
}

func (v NullableEventAppResponse) Get() *EventAppResponse {
	return v.value
}

func (v *NullableEventAppResponse) Set(val *EventAppResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableEventAppResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableEventAppResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEventAppResponse(val *EventAppResponse) *NullableEventAppResponse {
	return &NullableEventAppResponse{value: val, isSet: true}
}

func (v NullableEventAppResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableEventAppResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
