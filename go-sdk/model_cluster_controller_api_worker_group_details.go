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

// checks if the ClusterControllerApiWorkerGroupDetails type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ClusterControllerApiWorkerGroupDetails{}

// ClusterControllerApiWorkerGroupDetails ApiWorkerGroupDetails.
type ClusterControllerApiWorkerGroupDetails struct {
	// The ID of worker group.
	Id string `json:"id"`
	// The key of the worker group.
	Key string `json:"key"`
	// The description of the worker group.
	Description    string   `json:"description"`
	AllowedTenants []string `json:"allowedTenants"`
	// The list of workers for the group.
	Workers              []ServiceInstance `json:"workers"`
	AdditionalProperties map[string]interface{}
}

type _ClusterControllerApiWorkerGroupDetails ClusterControllerApiWorkerGroupDetails

// NewClusterControllerApiWorkerGroupDetails instantiates a new ClusterControllerApiWorkerGroupDetails object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewClusterControllerApiWorkerGroupDetails(id string, key string, description string, allowedTenants []string, workers []ServiceInstance) *ClusterControllerApiWorkerGroupDetails {
	this := ClusterControllerApiWorkerGroupDetails{}
	this.Id = id
	this.Key = key
	this.Description = description
	this.AllowedTenants = allowedTenants
	this.Workers = workers
	return &this
}

// NewClusterControllerApiWorkerGroupDetailsWithDefaults instantiates a new ClusterControllerApiWorkerGroupDetails object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewClusterControllerApiWorkerGroupDetailsWithDefaults() *ClusterControllerApiWorkerGroupDetails {
	this := ClusterControllerApiWorkerGroupDetails{}
	return &this
}

// GetId returns the Id field value
func (o *ClusterControllerApiWorkerGroupDetails) GetId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiWorkerGroupDetails) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value
func (o *ClusterControllerApiWorkerGroupDetails) SetId(v string) {
	o.Id = v
}

// GetKey returns the Key field value
func (o *ClusterControllerApiWorkerGroupDetails) GetKey() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Key
}

// GetKeyOk returns a tuple with the Key field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiWorkerGroupDetails) GetKeyOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Key, true
}

// SetKey sets field value
func (o *ClusterControllerApiWorkerGroupDetails) SetKey(v string) {
	o.Key = v
}

// GetDescription returns the Description field value
func (o *ClusterControllerApiWorkerGroupDetails) GetDescription() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Description
}

// GetDescriptionOk returns a tuple with the Description field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiWorkerGroupDetails) GetDescriptionOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Description, true
}

// SetDescription sets field value
func (o *ClusterControllerApiWorkerGroupDetails) SetDescription(v string) {
	o.Description = v
}

// GetAllowedTenants returns the AllowedTenants field value
func (o *ClusterControllerApiWorkerGroupDetails) GetAllowedTenants() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.AllowedTenants
}

// GetAllowedTenantsOk returns a tuple with the AllowedTenants field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiWorkerGroupDetails) GetAllowedTenantsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.AllowedTenants, true
}

// SetAllowedTenants sets field value
func (o *ClusterControllerApiWorkerGroupDetails) SetAllowedTenants(v []string) {
	o.AllowedTenants = v
}

// GetWorkers returns the Workers field value
func (o *ClusterControllerApiWorkerGroupDetails) GetWorkers() []ServiceInstance {
	if o == nil {
		var ret []ServiceInstance
		return ret
	}

	return o.Workers
}

// GetWorkersOk returns a tuple with the Workers field value
// and a boolean to check if the value has been set.
func (o *ClusterControllerApiWorkerGroupDetails) GetWorkersOk() ([]ServiceInstance, bool) {
	if o == nil {
		return nil, false
	}
	return o.Workers, true
}

// SetWorkers sets field value
func (o *ClusterControllerApiWorkerGroupDetails) SetWorkers(v []ServiceInstance) {
	o.Workers = v
}

func (o ClusterControllerApiWorkerGroupDetails) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ClusterControllerApiWorkerGroupDetails) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["id"] = o.Id
	toSerialize["key"] = o.Key
	toSerialize["description"] = o.Description
	toSerialize["allowedTenants"] = o.AllowedTenants
	toSerialize["workers"] = o.Workers

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ClusterControllerApiWorkerGroupDetails) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"id",
		"key",
		"description",
		"allowedTenants",
		"workers",
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

	varClusterControllerApiWorkerGroupDetails := _ClusterControllerApiWorkerGroupDetails{}

	err = json.Unmarshal(data, &varClusterControllerApiWorkerGroupDetails)

	if err != nil {
		return err
	}

	*o = ClusterControllerApiWorkerGroupDetails(varClusterControllerApiWorkerGroupDetails)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "id")
		delete(additionalProperties, "key")
		delete(additionalProperties, "description")
		delete(additionalProperties, "allowedTenants")
		delete(additionalProperties, "workers")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableClusterControllerApiWorkerGroupDetails struct {
	value *ClusterControllerApiWorkerGroupDetails
	isSet bool
}

func (v NullableClusterControllerApiWorkerGroupDetails) Get() *ClusterControllerApiWorkerGroupDetails {
	return v.value
}

func (v *NullableClusterControllerApiWorkerGroupDetails) Set(val *ClusterControllerApiWorkerGroupDetails) {
	v.value = val
	v.isSet = true
}

func (v NullableClusterControllerApiWorkerGroupDetails) IsSet() bool {
	return v.isSet
}

func (v *NullableClusterControllerApiWorkerGroupDetails) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableClusterControllerApiWorkerGroupDetails(val *ClusterControllerApiWorkerGroupDetails) *NullableClusterControllerApiWorkerGroupDetails {
	return &NullableClusterControllerApiWorkerGroupDetails{value: val, isSet: true}
}

func (v NullableClusterControllerApiWorkerGroupDetails) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableClusterControllerApiWorkerGroupDetails) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
