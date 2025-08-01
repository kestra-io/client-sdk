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

// checks if the Metric type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &Metric{}

// Metric struct for Metric
type Metric struct {
	Name                 string      `json:"name"`
	Type                 string      `json:"type"`
	Description          string      `json:"description"`
	BaseUnit             string      `json:"baseUnit"`
	Tags                 []MetricTag `json:"tags"`
	Value                interface{} `json:"value"`
	AdditionalProperties map[string]interface{}
}

type _Metric Metric

// NewMetric instantiates a new Metric object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewMetric(name string, type_ string, description string, baseUnit string, tags []MetricTag, value interface{}) *Metric {
	this := Metric{}
	this.Name = name
	this.Type = type_
	this.Description = description
	this.BaseUnit = baseUnit
	this.Tags = tags
	this.Value = value
	return &this
}

// NewMetricWithDefaults instantiates a new Metric object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewMetricWithDefaults() *Metric {
	this := Metric{}
	return &this
}

// GetName returns the Name field value
func (o *Metric) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *Metric) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *Metric) SetName(v string) {
	o.Name = v
}

// GetType returns the Type field value
func (o *Metric) GetType() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Type
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
func (o *Metric) GetTypeOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Type, true
}

// SetType sets field value
func (o *Metric) SetType(v string) {
	o.Type = v
}

// GetDescription returns the Description field value
func (o *Metric) GetDescription() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Description
}

// GetDescriptionOk returns a tuple with the Description field value
// and a boolean to check if the value has been set.
func (o *Metric) GetDescriptionOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Description, true
}

// SetDescription sets field value
func (o *Metric) SetDescription(v string) {
	o.Description = v
}

// GetBaseUnit returns the BaseUnit field value
func (o *Metric) GetBaseUnit() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.BaseUnit
}

// GetBaseUnitOk returns a tuple with the BaseUnit field value
// and a boolean to check if the value has been set.
func (o *Metric) GetBaseUnitOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.BaseUnit, true
}

// SetBaseUnit sets field value
func (o *Metric) SetBaseUnit(v string) {
	o.BaseUnit = v
}

// GetTags returns the Tags field value
func (o *Metric) GetTags() []MetricTag {
	if o == nil {
		var ret []MetricTag
		return ret
	}

	return o.Tags
}

// GetTagsOk returns a tuple with the Tags field value
// and a boolean to check if the value has been set.
func (o *Metric) GetTagsOk() ([]MetricTag, bool) {
	if o == nil {
		return nil, false
	}
	return o.Tags, true
}

// SetTags sets field value
func (o *Metric) SetTags(v []MetricTag) {
	o.Tags = v
}

// GetValue returns the Value field value
// If the value is explicit nil, the zero value for interface{} will be returned
func (o *Metric) GetValue() interface{} {
	if o == nil {
		var ret interface{}
		return ret
	}

	return o.Value
}

// GetValueOk returns a tuple with the Value field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *Metric) GetValueOk() (*interface{}, bool) {
	if o == nil || IsNil(o.Value) {
		return nil, false
	}
	return &o.Value, true
}

// SetValue sets field value
func (o *Metric) SetValue(v interface{}) {
	o.Value = v
}

func (o Metric) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o Metric) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["name"] = o.Name
	toSerialize["type"] = o.Type
	toSerialize["description"] = o.Description
	toSerialize["baseUnit"] = o.BaseUnit
	toSerialize["tags"] = o.Tags
	if o.Value != nil {
		toSerialize["value"] = o.Value
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *Metric) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"name",
		"type",
		"description",
		"baseUnit",
		"tags",
		"value",
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

	varMetric := _Metric{}

	err = json.Unmarshal(data, &varMetric)

	if err != nil {
		return err
	}

	*o = Metric(varMetric)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "name")
		delete(additionalProperties, "type")
		delete(additionalProperties, "description")
		delete(additionalProperties, "baseUnit")
		delete(additionalProperties, "tags")
		delete(additionalProperties, "value")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableMetric struct {
	value *Metric
	isSet bool
}

func (v NullableMetric) Get() *Metric {
	return v.value
}

func (v *NullableMetric) Set(val *Metric) {
	v.value = val
	v.isSet = true
}

func (v NullableMetric) IsSet() bool {
	return v.isSet
}

func (v *NullableMetric) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableMetric(val *Metric) *NullableMetric {
	return &NullableMetric{value: val, isSet: true}
}

func (v NullableMetric) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableMetric) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
