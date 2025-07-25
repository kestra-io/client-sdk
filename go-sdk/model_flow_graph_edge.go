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

// checks if the FlowGraphEdge type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &FlowGraphEdge{}

// FlowGraphEdge struct for FlowGraphEdge
type FlowGraphEdge struct {
	Source               string   `json:"source"`
	Target               string   `json:"target"`
	Relation             Relation `json:"relation"`
	AdditionalProperties map[string]interface{}
}

type _FlowGraphEdge FlowGraphEdge

// NewFlowGraphEdge instantiates a new FlowGraphEdge object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewFlowGraphEdge(source string, target string, relation Relation) *FlowGraphEdge {
	this := FlowGraphEdge{}
	this.Source = source
	this.Target = target
	this.Relation = relation
	return &this
}

// NewFlowGraphEdgeWithDefaults instantiates a new FlowGraphEdge object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewFlowGraphEdgeWithDefaults() *FlowGraphEdge {
	this := FlowGraphEdge{}
	return &this
}

// GetSource returns the Source field value
func (o *FlowGraphEdge) GetSource() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Source
}

// GetSourceOk returns a tuple with the Source field value
// and a boolean to check if the value has been set.
func (o *FlowGraphEdge) GetSourceOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Source, true
}

// SetSource sets field value
func (o *FlowGraphEdge) SetSource(v string) {
	o.Source = v
}

// GetTarget returns the Target field value
func (o *FlowGraphEdge) GetTarget() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Target
}

// GetTargetOk returns a tuple with the Target field value
// and a boolean to check if the value has been set.
func (o *FlowGraphEdge) GetTargetOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Target, true
}

// SetTarget sets field value
func (o *FlowGraphEdge) SetTarget(v string) {
	o.Target = v
}

// GetRelation returns the Relation field value
func (o *FlowGraphEdge) GetRelation() Relation {
	if o == nil {
		var ret Relation
		return ret
	}

	return o.Relation
}

// GetRelationOk returns a tuple with the Relation field value
// and a boolean to check if the value has been set.
func (o *FlowGraphEdge) GetRelationOk() (*Relation, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Relation, true
}

// SetRelation sets field value
func (o *FlowGraphEdge) SetRelation(v Relation) {
	o.Relation = v
}

func (o FlowGraphEdge) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o FlowGraphEdge) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["source"] = o.Source
	toSerialize["target"] = o.Target
	toSerialize["relation"] = o.Relation

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *FlowGraphEdge) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"source",
		"target",
		"relation",
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

	varFlowGraphEdge := _FlowGraphEdge{}

	err = json.Unmarshal(data, &varFlowGraphEdge)

	if err != nil {
		return err
	}

	*o = FlowGraphEdge(varFlowGraphEdge)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "source")
		delete(additionalProperties, "target")
		delete(additionalProperties, "relation")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableFlowGraphEdge struct {
	value *FlowGraphEdge
	isSet bool
}

func (v NullableFlowGraphEdge) Get() *FlowGraphEdge {
	return v.value
}

func (v *NullableFlowGraphEdge) Set(val *FlowGraphEdge) {
	v.value = val
	v.isSet = true
}

func (v NullableFlowGraphEdge) IsSet() bool {
	return v.isSet
}

func (v *NullableFlowGraphEdge) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableFlowGraphEdge(val *FlowGraphEdge) *NullableFlowGraphEdge {
	return &NullableFlowGraphEdge{value: val, isSet: true}
}

func (v NullableFlowGraphEdge) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableFlowGraphEdge) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
