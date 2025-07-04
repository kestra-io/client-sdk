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

// checks if the ServiceInstanceTimestampedEvent type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ServiceInstanceTimestampedEvent{}

// ServiceInstanceTimestampedEvent struct for ServiceInstanceTimestampedEvent
type ServiceInstanceTimestampedEvent struct {
	Ts                   time.Time           `json:"ts"`
	Value                string              `json:"value"`
	Type                 string              `json:"type"`
	State                ServiceServiceState `json:"state"`
	AdditionalProperties map[string]interface{}
}

type _ServiceInstanceTimestampedEvent ServiceInstanceTimestampedEvent

// NewServiceInstanceTimestampedEvent instantiates a new ServiceInstanceTimestampedEvent object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewServiceInstanceTimestampedEvent(ts time.Time, value string, type_ string, state ServiceServiceState) *ServiceInstanceTimestampedEvent {
	this := ServiceInstanceTimestampedEvent{}
	this.Ts = ts
	this.Value = value
	this.Type = type_
	this.State = state
	return &this
}

// NewServiceInstanceTimestampedEventWithDefaults instantiates a new ServiceInstanceTimestampedEvent object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewServiceInstanceTimestampedEventWithDefaults() *ServiceInstanceTimestampedEvent {
	this := ServiceInstanceTimestampedEvent{}
	return &this
}

// GetTs returns the Ts field value
func (o *ServiceInstanceTimestampedEvent) GetTs() time.Time {
	if o == nil {
		var ret time.Time
		return ret
	}

	return o.Ts
}

// GetTsOk returns a tuple with the Ts field value
// and a boolean to check if the value has been set.
func (o *ServiceInstanceTimestampedEvent) GetTsOk() (*time.Time, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Ts, true
}

// SetTs sets field value
func (o *ServiceInstanceTimestampedEvent) SetTs(v time.Time) {
	o.Ts = v
}

// GetValue returns the Value field value
func (o *ServiceInstanceTimestampedEvent) GetValue() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Value
}

// GetValueOk returns a tuple with the Value field value
// and a boolean to check if the value has been set.
func (o *ServiceInstanceTimestampedEvent) GetValueOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Value, true
}

// SetValue sets field value
func (o *ServiceInstanceTimestampedEvent) SetValue(v string) {
	o.Value = v
}

// GetType returns the Type field value
func (o *ServiceInstanceTimestampedEvent) GetType() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Type
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
func (o *ServiceInstanceTimestampedEvent) GetTypeOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Type, true
}

// SetType sets field value
func (o *ServiceInstanceTimestampedEvent) SetType(v string) {
	o.Type = v
}

// GetState returns the State field value
func (o *ServiceInstanceTimestampedEvent) GetState() ServiceServiceState {
	if o == nil {
		var ret ServiceServiceState
		return ret
	}

	return o.State
}

// GetStateOk returns a tuple with the State field value
// and a boolean to check if the value has been set.
func (o *ServiceInstanceTimestampedEvent) GetStateOk() (*ServiceServiceState, bool) {
	if o == nil {
		return nil, false
	}
	return &o.State, true
}

// SetState sets field value
func (o *ServiceInstanceTimestampedEvent) SetState(v ServiceServiceState) {
	o.State = v
}

func (o ServiceInstanceTimestampedEvent) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ServiceInstanceTimestampedEvent) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["ts"] = o.Ts
	toSerialize["value"] = o.Value
	toSerialize["type"] = o.Type
	toSerialize["state"] = o.State

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ServiceInstanceTimestampedEvent) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"ts",
		"value",
		"type",
		"state",
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

	varServiceInstanceTimestampedEvent := _ServiceInstanceTimestampedEvent{}

	err = json.Unmarshal(data, &varServiceInstanceTimestampedEvent)

	if err != nil {
		return err
	}

	*o = ServiceInstanceTimestampedEvent(varServiceInstanceTimestampedEvent)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "ts")
		delete(additionalProperties, "value")
		delete(additionalProperties, "type")
		delete(additionalProperties, "state")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableServiceInstanceTimestampedEvent struct {
	value *ServiceInstanceTimestampedEvent
	isSet bool
}

func (v NullableServiceInstanceTimestampedEvent) Get() *ServiceInstanceTimestampedEvent {
	return v.value
}

func (v *NullableServiceInstanceTimestampedEvent) Set(val *ServiceInstanceTimestampedEvent) {
	v.value = val
	v.isSet = true
}

func (v NullableServiceInstanceTimestampedEvent) IsSet() bool {
	return v.isSet
}

func (v *NullableServiceInstanceTimestampedEvent) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableServiceInstanceTimestampedEvent(val *ServiceInstanceTimestampedEvent) *NullableServiceInstanceTimestampedEvent {
	return &NullableServiceInstanceTimestampedEvent{value: val, isSet: true}
}

func (v NullableServiceInstanceTimestampedEvent) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableServiceInstanceTimestampedEvent) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
