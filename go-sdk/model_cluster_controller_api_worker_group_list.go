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

// checks if the ClusterControllerApiWorkerGroupList type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ClusterControllerApiWorkerGroupList{}

// ClusterControllerApiWorkerGroupList ApiWorkerGroupList.
type ClusterControllerApiWorkerGroupList struct {
	// The list of worker groups.
	WorkerGroups         []ClusterControllerApiWorkerGroupItem `json:"workerGroups"`
	AdditionalProperties map[string]interface{}
}

type _ClusterControllerApiWorkerGroupList ClusterControllerApiWorkerGroupList

// NewClusterControllerApiWorkerGroupList instantiates a new ClusterControllerApiWorkerGroupList object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewClusterControllerApiWorkerGroupList(workerGroups []ClusterControllerApiWorkerGroupItem) *ClusterControllerApiWorkerGroupList {
	this := ClusterControllerApiWorkerGroupList{}
	this.WorkerGroups = workerGroups
	return &this
}

// NewClusterControllerApiWorkerGroupListWithDefaults instantiates a new ClusterControllerApiWorkerGroupList object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewClusterControllerApiWorkerGroupListWithDefaults() *ClusterControllerApiWorkerGroupList {
	this := ClusterControllerApiWorkerGroupList{}
	return &this
}

// GetWorkerGroups returns the WorkerGroups field value
func (o *ClusterControllerApiWorkerGroupList) GetWorkerGroups() []ClusterControllerApiWorkerGroupItem {
	if o == nil {
		var ret []ClusterControllerApiWorkerGroupItem
		return ret
	}

	return o.WorkerGroups
}

// GetWorkerGroupsOk returns a tuple with the WorkerGroups field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiWorkerGroupList) GetWorkerGroupsOk() ([]ClusterControllerApiWorkerGroupItem, bool) {
	if o == nil {
		return nil, false
	}
	return o.WorkerGroups, true
}

// SetWorkerGroups sets field value
func (o *ClusterControllerApiWorkerGroupList) SetWorkerGroups(v []ClusterControllerApiWorkerGroupItem) {
	o.WorkerGroups = v
}

func (o ClusterControllerApiWorkerGroupList) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ClusterControllerApiWorkerGroupList) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["workerGroups"] = o.WorkerGroups

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ClusterControllerApiWorkerGroupList) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"workerGroups",
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

	varClusterControllerApiWorkerGroupList := _ClusterControllerApiWorkerGroupList{}

	err = json.Unmarshal(data, &varClusterControllerApiWorkerGroupList)

	if err != nil {
		return err
	}

	*o = ClusterControllerApiWorkerGroupList(varClusterControllerApiWorkerGroupList)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "workerGroups")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableClusterControllerApiWorkerGroupList struct {
	value *ClusterControllerApiWorkerGroupList
	isSet bool
}

func (v NullableClusterControllerApiWorkerGroupList) Get() *ClusterControllerApiWorkerGroupList {
	return v.value
}

func (v *NullableClusterControllerApiWorkerGroupList) Set(val *ClusterControllerApiWorkerGroupList) {
	v.value = val
	v.isSet = true
}

func (v NullableClusterControllerApiWorkerGroupList) IsSet() bool {
	return v.isSet
}

func (v *NullableClusterControllerApiWorkerGroupList) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableClusterControllerApiWorkerGroupList(val *ClusterControllerApiWorkerGroupList) *NullableClusterControllerApiWorkerGroupList {
	return &NullableClusterControllerApiWorkerGroupList{value: val, isSet: true}
}

func (v NullableClusterControllerApiWorkerGroupList) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableClusterControllerApiWorkerGroupList) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
