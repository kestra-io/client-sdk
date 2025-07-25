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

// checks if the ClusterControllerApiPluginListRequest type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ClusterControllerApiPluginListRequest{}

// ClusterControllerApiPluginListRequest struct for ClusterControllerApiPluginListRequest
type ClusterControllerApiPluginListRequest struct {
	Plugins              []string `json:"plugins"`
	AdditionalProperties map[string]interface{}
}

type _ClusterControllerApiPluginListRequest ClusterControllerApiPluginListRequest

// NewClusterControllerApiPluginListRequest instantiates a new ClusterControllerApiPluginListRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewClusterControllerApiPluginListRequest(plugins []string) *ClusterControllerApiPluginListRequest {
	this := ClusterControllerApiPluginListRequest{}
	this.Plugins = plugins
	return &this
}

// NewClusterControllerApiPluginListRequestWithDefaults instantiates a new ClusterControllerApiPluginListRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewClusterControllerApiPluginListRequestWithDefaults() *ClusterControllerApiPluginListRequest {
	this := ClusterControllerApiPluginListRequest{}
	return &this
}

// GetPlugins returns the Plugins field value
func (o *ClusterControllerApiPluginListRequest) GetPlugins() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.Plugins
}

// GetPluginsOk returns a tuple with the Plugins field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiPluginListRequest) GetPluginsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.Plugins, true
}

// SetPlugins sets field value
func (o *ClusterControllerApiPluginListRequest) SetPlugins(v []string) {
	o.Plugins = v
}

func (o ClusterControllerApiPluginListRequest) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ClusterControllerApiPluginListRequest) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["plugins"] = o.Plugins

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ClusterControllerApiPluginListRequest) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"plugins",
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

	varClusterControllerApiPluginListRequest := _ClusterControllerApiPluginListRequest{}

	err = json.Unmarshal(data, &varClusterControllerApiPluginListRequest)

	if err != nil {
		return err
	}

	*o = ClusterControllerApiPluginListRequest(varClusterControllerApiPluginListRequest)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "plugins")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableClusterControllerApiPluginListRequest struct {
	value *ClusterControllerApiPluginListRequest
	isSet bool
}

func (v NullableClusterControllerApiPluginListRequest) Get() *ClusterControllerApiPluginListRequest {
	return v.value
}

func (v *NullableClusterControllerApiPluginListRequest) Set(val *ClusterControllerApiPluginListRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableClusterControllerApiPluginListRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableClusterControllerApiPluginListRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableClusterControllerApiPluginListRequest(val *ClusterControllerApiPluginListRequest) *NullableClusterControllerApiPluginListRequest {
	return &NullableClusterControllerApiPluginListRequest{value: val, isSet: true}
}

func (v NullableClusterControllerApiPluginListRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableClusterControllerApiPluginListRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
