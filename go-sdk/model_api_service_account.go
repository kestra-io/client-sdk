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

// checks if the ApiServiceAccount type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ApiServiceAccount{}

// ApiServiceAccount A User Service Account.
type ApiServiceAccount struct {
	// the identifier of this service account.
	Id string `json:"id"`
	// the name of this service account.
	Name string `json:"name" validate:"regexp=^(?=.{1,63}$)[a-z0-9]+(?:-[a-z0-9]+)*$"`
	// the description of this service account.
	Description          string            `json:"description"`
	GroupList            []GroupIdentifier `json:"groupList"`
	IsSuperAdmin         bool              `json:"isSuperAdmin"`
	AdditionalProperties map[string]interface{}
}

type _ApiServiceAccount ApiServiceAccount

// NewApiServiceAccount instantiates a new ApiServiceAccount object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewApiServiceAccount(id string, name string, description string, groupList []GroupIdentifier, isSuperAdmin bool) *ApiServiceAccount {
	this := ApiServiceAccount{}
	this.Id = id
	this.Name = name
	this.Description = description
	this.GroupList = groupList
	this.IsSuperAdmin = isSuperAdmin
	return &this
}

// NewApiServiceAccountWithDefaults instantiates a new ApiServiceAccount object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewApiServiceAccountWithDefaults() *ApiServiceAccount {
	this := ApiServiceAccount{}
	return &this
}

// GetId returns the Id field value
func (o *ApiServiceAccount) GetId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *ApiServiceAccount) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value
func (o *ApiServiceAccount) SetId(v string) {
	o.Id = v
}

// GetName returns the Name field value
func (o *ApiServiceAccount) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *ApiServiceAccount) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *ApiServiceAccount) SetName(v string) {
	o.Name = v
}

// GetDescription returns the Description field value
func (o *ApiServiceAccount) GetDescription() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Description
}

// GetDescriptionOk returns a tuple with the Description field value
// and a boolean to check if the value has been set.
func (o *ApiServiceAccount) GetDescriptionOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Description, true
}

// SetDescription sets field value
func (o *ApiServiceAccount) SetDescription(v string) {
	o.Description = v
}

// GetGroupList returns the GroupList field value
func (o *ApiServiceAccount) GetGroupList() []GroupIdentifier {
	if o == nil {
		var ret []GroupIdentifier
		return ret
	}

	return o.GroupList
}

// GetGroupListOk returns a tuple with the GroupList field value
// and a boolean to check if the value has been set.
func (o *ApiServiceAccount) GetGroupListOk() ([]GroupIdentifier, bool) {
	if o == nil {
		return nil, false
	}
	return o.GroupList, true
}

// SetGroupList sets field value
func (o *ApiServiceAccount) SetGroupList(v []GroupIdentifier) {
	o.GroupList = v
}

// GetIsSuperAdmin returns the IsSuperAdmin field value
func (o *ApiServiceAccount) GetIsSuperAdmin() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.IsSuperAdmin
}

// GetIsSuperAdminOk returns a tuple with the IsSuperAdmin field value
// and a boolean to check if the value has been set.
func (o *ApiServiceAccount) GetIsSuperAdminOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IsSuperAdmin, true
}

// SetIsSuperAdmin sets field value
func (o *ApiServiceAccount) SetIsSuperAdmin(v bool) {
	o.IsSuperAdmin = v
}

func (o ApiServiceAccount) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ApiServiceAccount) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["id"] = o.Id
	toSerialize["name"] = o.Name
	toSerialize["description"] = o.Description
	toSerialize["groupList"] = o.GroupList
	toSerialize["isSuperAdmin"] = o.IsSuperAdmin

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ApiServiceAccount) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"id",
		"name",
		"description",
		"groupList",
		"isSuperAdmin",
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

	varApiServiceAccount := _ApiServiceAccount{}

	err = json.Unmarshal(data, &varApiServiceAccount)

	if err != nil {
		return err
	}

	*o = ApiServiceAccount(varApiServiceAccount)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "id")
		delete(additionalProperties, "name")
		delete(additionalProperties, "description")
		delete(additionalProperties, "groupList")
		delete(additionalProperties, "isSuperAdmin")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableApiServiceAccount struct {
	value *ApiServiceAccount
	isSet bool
}

func (v NullableApiServiceAccount) Get() *ApiServiceAccount {
	return v.value
}

func (v *NullableApiServiceAccount) Set(val *ApiServiceAccount) {
	v.value = val
	v.isSet = true
}

func (v NullableApiServiceAccount) IsSet() bool {
	return v.isSet
}

func (v *NullableApiServiceAccount) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiServiceAccount(val *ApiServiceAccount) *NullableApiServiceAccount {
	return &NullableApiServiceAccount{value: val, isSet: true}
}

func (v NullableApiServiceAccount) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableApiServiceAccount) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
