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

// checks if the ClusterControllerApiPluginVersionDetailsApiPluginClass type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ClusterControllerApiPluginVersionDetailsApiPluginClass{}

// ClusterControllerApiPluginVersionDetailsApiPluginClass struct for ClusterControllerApiPluginVersionDetailsApiPluginClass
type ClusterControllerApiPluginVersionDetailsApiPluginClass struct {
	Name                 string `json:"name"`
	Icon                 string `json:"icon"`
	AdditionalProperties map[string]interface{}
}

type _ClusterControllerApiPluginVersionDetailsApiPluginClass ClusterControllerApiPluginVersionDetailsApiPluginClass

// NewClusterControllerApiPluginVersionDetailsApiPluginClass instantiates a new ClusterControllerApiPluginVersionDetailsApiPluginClass object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewClusterControllerApiPluginVersionDetailsApiPluginClass(name string, icon string) *ClusterControllerApiPluginVersionDetailsApiPluginClass {
	this := ClusterControllerApiPluginVersionDetailsApiPluginClass{}
	this.Name = name
	this.Icon = icon
	return &this
}

// NewClusterControllerApiPluginVersionDetailsApiPluginClassWithDefaults instantiates a new ClusterControllerApiPluginVersionDetailsApiPluginClass object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewClusterControllerApiPluginVersionDetailsApiPluginClassWithDefaults() *ClusterControllerApiPluginVersionDetailsApiPluginClass {
	this := ClusterControllerApiPluginVersionDetailsApiPluginClass{}
	return &this
}

// GetName returns the Name field value
func (o *ClusterControllerApiPluginVersionDetailsApiPluginClass) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiPluginVersionDetailsApiPluginClass) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *ClusterControllerApiPluginVersionDetailsApiPluginClass) SetName(v string) {
	o.Name = v
}

// GetIcon returns the Icon field value
func (o *ClusterControllerApiPluginVersionDetailsApiPluginClass) GetIcon() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Icon
}

// GetIconOk returns a tuple with the Icon field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiPluginVersionDetailsApiPluginClass) GetIconOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Icon, true
}

// SetIcon sets field value
func (o *ClusterControllerApiPluginVersionDetailsApiPluginClass) SetIcon(v string) {
	o.Icon = v
}

func (o ClusterControllerApiPluginVersionDetailsApiPluginClass) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ClusterControllerApiPluginVersionDetailsApiPluginClass) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["name"] = o.Name
	toSerialize["icon"] = o.Icon

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ClusterControllerApiPluginVersionDetailsApiPluginClass) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"name",
		"icon",
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

	varClusterControllerApiPluginVersionDetailsApiPluginClass := _ClusterControllerApiPluginVersionDetailsApiPluginClass{}

	err = json.Unmarshal(data, &varClusterControllerApiPluginVersionDetailsApiPluginClass)

	if err != nil {
		return err
	}

	*o = ClusterControllerApiPluginVersionDetailsApiPluginClass(varClusterControllerApiPluginVersionDetailsApiPluginClass)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "name")
		delete(additionalProperties, "icon")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableClusterControllerApiPluginVersionDetailsApiPluginClass struct {
	value *ClusterControllerApiPluginVersionDetailsApiPluginClass
	isSet bool
}

func (v NullableClusterControllerApiPluginVersionDetailsApiPluginClass) Get() *ClusterControllerApiPluginVersionDetailsApiPluginClass {
	return v.value
}

func (v *NullableClusterControllerApiPluginVersionDetailsApiPluginClass) Set(val *ClusterControllerApiPluginVersionDetailsApiPluginClass) {
	v.value = val
	v.isSet = true
}

func (v NullableClusterControllerApiPluginVersionDetailsApiPluginClass) IsSet() bool {
	return v.isSet
}

func (v *NullableClusterControllerApiPluginVersionDetailsApiPluginClass) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableClusterControllerApiPluginVersionDetailsApiPluginClass(val *ClusterControllerApiPluginVersionDetailsApiPluginClass) *NullableClusterControllerApiPluginVersionDetailsApiPluginClass {
	return &NullableClusterControllerApiPluginVersionDetailsApiPluginClass{value: val, isSet: true}
}

func (v NullableClusterControllerApiPluginVersionDetailsApiPluginClass) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableClusterControllerApiPluginVersionDetailsApiPluginClass) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
