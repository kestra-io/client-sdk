/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
	"fmt"
)

// checks if the MeControllerUserDetailsRequest type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &MeControllerUserDetailsRequest{}

// MeControllerUserDetailsRequest struct for MeControllerUserDetailsRequest
type MeControllerUserDetailsRequest struct {
	FirstName            string `json:"firstName"`
	LastName             string `json:"lastName"`
	Email                string `json:"email"`
	AdditionalProperties map[string]interface{}
}

type _MeControllerUserDetailsRequest MeControllerUserDetailsRequest

// NewMeControllerUserDetailsRequest instantiates a new MeControllerUserDetailsRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewMeControllerUserDetailsRequest(firstName string, lastName string, email string) *MeControllerUserDetailsRequest {
	this := MeControllerUserDetailsRequest{}
	this.FirstName = firstName
	this.LastName = lastName
	this.Email = email
	return &this
}

// NewMeControllerUserDetailsRequestWithDefaults instantiates a new MeControllerUserDetailsRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewMeControllerUserDetailsRequestWithDefaults() *MeControllerUserDetailsRequest {
	this := MeControllerUserDetailsRequest{}
	return &this
}

// GetFirstName returns the FirstName field value
func (o *MeControllerUserDetailsRequest) GetFirstName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.FirstName
}

// GetFirstNameOk returns a tuple with the FirstName field value
// and a boolean to check if the value has been set.
func (o *MeControllerUserDetailsRequest) GetFirstNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.FirstName, true
}

// SetFirstName sets field value
func (o *MeControllerUserDetailsRequest) SetFirstName(v string) {
	o.FirstName = v
}

// GetLastName returns the LastName field value
func (o *MeControllerUserDetailsRequest) GetLastName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.LastName
}

// GetLastNameOk returns a tuple with the LastName field value
// and a boolean to check if the value has been set.
func (o *MeControllerUserDetailsRequest) GetLastNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.LastName, true
}

// SetLastName sets field value
func (o *MeControllerUserDetailsRequest) SetLastName(v string) {
	o.LastName = v
}

// GetEmail returns the Email field value
func (o *MeControllerUserDetailsRequest) GetEmail() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Email
}

// GetEmailOk returns a tuple with the Email field value
// and a boolean to check if the value has been set.
func (o *MeControllerUserDetailsRequest) GetEmailOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Email, true
}

// SetEmail sets field value
func (o *MeControllerUserDetailsRequest) SetEmail(v string) {
	o.Email = v
}

func (o MeControllerUserDetailsRequest) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o MeControllerUserDetailsRequest) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["firstName"] = o.FirstName
	toSerialize["lastName"] = o.LastName
	toSerialize["email"] = o.Email

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *MeControllerUserDetailsRequest) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"firstName",
		"lastName",
		"email",
	}

	allProperties := make(map[string]interface{})

	err = json.Unmarshal(data, &allProperties)

	if err != nil {
		return err
	}

	for _, requiredProperty := range requiredProperties {
		if _, exists := allProperties[requiredProperty]; !exists {
			return fmt.Errorf("no value given for required property %v", requiredProperty)
		}
	}

	varMeControllerUserDetailsRequest := _MeControllerUserDetailsRequest{}

	err = json.Unmarshal(data, &varMeControllerUserDetailsRequest)

	if err != nil {
		return err
	}

	*o = MeControllerUserDetailsRequest(varMeControllerUserDetailsRequest)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "firstName")
		delete(additionalProperties, "lastName")
		delete(additionalProperties, "email")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableMeControllerUserDetailsRequest struct {
	value *MeControllerUserDetailsRequest
	isSet bool
}

func (v NullableMeControllerUserDetailsRequest) Get() *MeControllerUserDetailsRequest {
	return v.value
}

func (v *NullableMeControllerUserDetailsRequest) Set(val *MeControllerUserDetailsRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableMeControllerUserDetailsRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableMeControllerUserDetailsRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableMeControllerUserDetailsRequest(val *MeControllerUserDetailsRequest) *NullableMeControllerUserDetailsRequest {
	return &NullableMeControllerUserDetailsRequest{value: val, isSet: true}
}

func (v NullableMeControllerUserDetailsRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableMeControllerUserDetailsRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
