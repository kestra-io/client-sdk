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
	"time"
)

// checks if the ServiceInstance type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ServiceInstance{}

// ServiceInstance struct for ServiceInstance
type ServiceInstance struct {
	Server               ServerInstance                    `json:"server"`
	Metrics              []Metric                          `json:"metrics"`
	State                ServiceServiceState               `json:"state"`
	Id                   string                            `json:"id"`
	Type                 ServiceType                       `json:"type"`
	CreatedAt            time.Time                         `json:"createdAt"`
	UpdatedAt            time.Time                         `json:"updatedAt"`
	Events               []ServiceInstanceTimestampedEvent `json:"events"`
	Config               ServerConfig                      `json:"config"`
	Props                map[string]interface{}            `json:"props"`
	SeqId                int64                             `json:"seqId"`
	AdditionalProperties map[string]interface{}
}

type _ServiceInstance ServiceInstance

// NewServiceInstance instantiates a new ServiceInstance object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewServiceInstance(server ServerInstance, metrics []Metric, state ServiceServiceState, id string, type_ ServiceType, createdAt time.Time, updatedAt time.Time, events []ServiceInstanceTimestampedEvent, config ServerConfig, props map[string]interface{}, seqId int64) *ServiceInstance {
	this := ServiceInstance{}
	this.Server = server
	this.Metrics = metrics
	this.State = state
	this.Id = id
	this.Type = type_
	this.CreatedAt = createdAt
	this.UpdatedAt = updatedAt
	this.Events = events
	this.Config = config
	this.Props = props
	this.SeqId = seqId
	return &this
}

// NewServiceInstanceWithDefaults instantiates a new ServiceInstance object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewServiceInstanceWithDefaults() *ServiceInstance {
	this := ServiceInstance{}
	return &this
}

// GetServer returns the Server field value
func (o *ServiceInstance) GetServer() ServerInstance {
	if o == nil {
		var ret ServerInstance
		return ret
	}

	return o.Server
}

// GetServerOk returns a tuple with the Server field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetServerOk() (*ServerInstance, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Server, true
}

// SetServer sets field value
func (o *ServiceInstance) SetServer(v ServerInstance) {
	o.Server = v
}

// GetMetrics returns the Metrics field value
func (o *ServiceInstance) GetMetrics() []Metric {
	if o == nil {
		var ret []Metric
		return ret
	}

	return o.Metrics
}

// GetMetricsOk returns a tuple with the Metrics field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetMetricsOk() ([]Metric, bool) {
	if o == nil {
		return nil, false
	}
	return o.Metrics, true
}

// SetMetrics sets field value
func (o *ServiceInstance) SetMetrics(v []Metric) {
	o.Metrics = v
}

// GetState returns the State field value
func (o *ServiceInstance) GetState() ServiceServiceState {
	if o == nil {
		var ret ServiceServiceState
		return ret
	}

	return o.State
}

// GetStateOk returns a tuple with the State field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetStateOk() (*ServiceServiceState, bool) {
	if o == nil {
		return nil, false
	}
	return &o.State, true
}

// SetState sets field value
func (o *ServiceInstance) SetState(v ServiceServiceState) {
	o.State = v
}

// GetId returns the Id field value
func (o *ServiceInstance) GetId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value
func (o *ServiceInstance) SetId(v string) {
	o.Id = v
}

// GetType returns the Type field value
func (o *ServiceInstance) GetType() ServiceType {
	if o == nil {
		var ret ServiceType
		return ret
	}

	return o.Type
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetTypeOk() (*ServiceType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Type, true
}

// SetType sets field value
func (o *ServiceInstance) SetType(v ServiceType) {
	o.Type = v
}

// GetCreatedAt returns the CreatedAt field value
func (o *ServiceInstance) GetCreatedAt() time.Time {
	if o == nil {
		var ret time.Time
		return ret
	}

	return o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetCreatedAtOk() (*time.Time, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreatedAt, true
}

// SetCreatedAt sets field value
func (o *ServiceInstance) SetCreatedAt(v time.Time) {
	o.CreatedAt = v
}

// GetUpdatedAt returns the UpdatedAt field value
func (o *ServiceInstance) GetUpdatedAt() time.Time {
	if o == nil {
		var ret time.Time
		return ret
	}

	return o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetUpdatedAtOk() (*time.Time, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdatedAt, true
}

// SetUpdatedAt sets field value
func (o *ServiceInstance) SetUpdatedAt(v time.Time) {
	o.UpdatedAt = v
}

// GetEvents returns the Events field value
func (o *ServiceInstance) GetEvents() []ServiceInstanceTimestampedEvent {
	if o == nil {
		var ret []ServiceInstanceTimestampedEvent
		return ret
	}

	return o.Events
}

// GetEventsOk returns a tuple with the Events field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetEventsOk() ([]ServiceInstanceTimestampedEvent, bool) {
	if o == nil {
		return nil, false
	}
	return o.Events, true
}

// SetEvents sets field value
func (o *ServiceInstance) SetEvents(v []ServiceInstanceTimestampedEvent) {
	o.Events = v
}

// GetConfig returns the Config field value
func (o *ServiceInstance) GetConfig() ServerConfig {
	if o == nil {
		var ret ServerConfig
		return ret
	}

	return o.Config
}

// GetConfigOk returns a tuple with the Config field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetConfigOk() (*ServerConfig, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Config, true
}

// SetConfig sets field value
func (o *ServiceInstance) SetConfig(v ServerConfig) {
	o.Config = v
}

// GetProps returns the Props field value
func (o *ServiceInstance) GetProps() map[string]interface{} {
	if o == nil {
		var ret map[string]interface{}
		return ret
	}

	return o.Props
}

// GetPropsOk returns a tuple with the Props field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetPropsOk() (map[string]interface{}, bool) {
	if o == nil {
		return map[string]interface{}{}, false
	}
	return o.Props, true
}

// SetProps sets field value
func (o *ServiceInstance) SetProps(v map[string]interface{}) {
	o.Props = v
}

// GetSeqId returns the SeqId field value
func (o *ServiceInstance) GetSeqId() int64 {
	if o == nil {
		var ret int64
		return ret
	}

	return o.SeqId
}

// GetSeqIdOk returns a tuple with the SeqId field value
// and a boolean to check if the value has been set.
func (o *ServiceInstance) GetSeqIdOk() (*int64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.SeqId, true
}

// SetSeqId sets field value
func (o *ServiceInstance) SetSeqId(v int64) {
	o.SeqId = v
}

func (o ServiceInstance) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ServiceInstance) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["server"] = o.Server
	toSerialize["metrics"] = o.Metrics
	toSerialize["state"] = o.State
	toSerialize["id"] = o.Id
	toSerialize["type"] = o.Type
	toSerialize["createdAt"] = o.CreatedAt
	toSerialize["updatedAt"] = o.UpdatedAt
	toSerialize["events"] = o.Events
	toSerialize["config"] = o.Config
	toSerialize["props"] = o.Props
	toSerialize["seqId"] = o.SeqId

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ServiceInstance) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"server",
		"metrics",
		"state",
		"id",
		"type",
		"createdAt",
		"updatedAt",
		"events",
		"config",
		"props",
		"seqId",
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

	varServiceInstance := _ServiceInstance{}

	err = json.Unmarshal(data, &varServiceInstance)

	if err != nil {
		return err
	}

	*o = ServiceInstance(varServiceInstance)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "server")
		delete(additionalProperties, "metrics")
		delete(additionalProperties, "state")
		delete(additionalProperties, "id")
		delete(additionalProperties, "type")
		delete(additionalProperties, "createdAt")
		delete(additionalProperties, "updatedAt")
		delete(additionalProperties, "events")
		delete(additionalProperties, "config")
		delete(additionalProperties, "props")
		delete(additionalProperties, "seqId")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableServiceInstance struct {
	value *ServiceInstance
	isSet bool
}

func (v NullableServiceInstance) Get() *ServiceInstance {
	return v.value
}

func (v *NullableServiceInstance) Set(val *ServiceInstance) {
	v.value = val
	v.isSet = true
}

func (v NullableServiceInstance) IsSet() bool {
	return v.isSet
}

func (v *NullableServiceInstance) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableServiceInstance(val *ServiceInstance) *NullableServiceInstance {
	return &NullableServiceInstance{value: val, isSet: true}
}

func (v NullableServiceInstance) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableServiceInstance) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
