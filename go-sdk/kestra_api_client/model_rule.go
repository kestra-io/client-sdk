/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the Rule type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &Rule{}

// Rule struct for Rule
type Rule struct {
	Type                 string            `json:"type"`
	On                   RuleTarget        `json:"on"`
	Where                []PolicyCondition `json:"where,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _Rule Rule

// NewRule instantiates a new Rule object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewRule(type_ string, on RuleTarget) *Rule {
	this := Rule{}
	this.Type = type_
	this.On = on
	return &this
}

// NewRuleWithDefaults instantiates a new Rule object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewRuleWithDefaults() *Rule {
	this := Rule{}
	return &this
}

// GetType returns the Type field value
func (o *Rule) GetType() string {
	if o == nil {
		var ret string
		return ret
	}
	return o.Type
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
func (o *Rule) GetTypeOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Type, true
}

// SetType sets field value
func (o *Rule) SetType(v string) {
	o.Type = v
}

// GetOn returns the On field value
func (o *Rule) GetOn() RuleTarget {
	if o == nil {
		var ret RuleTarget
		return ret
	}
	return o.On
}

// GetOnOk returns a tuple with the On field value
// and a boolean to check if the value has been set.
func (o *Rule) GetOnOk() (*RuleTarget, bool) {
	if o == nil {
		return nil, false
	}
	return &o.On, true
}

// SetOn sets field value
func (o *Rule) SetOn(v RuleTarget) {
	o.On = v
}

// GetWhere returns the Where field value if set, zero value otherwise.
func (o *Rule) GetWhere() []PolicyCondition {
	if o == nil || IsNil(o.Where) {
		var ret []PolicyCondition
		return ret
	}
	return o.Where
}

// GetWhereOk returns a tuple with the Where field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Rule) GetWhereOk() (*[]PolicyCondition, bool) {
	if o == nil || IsNil(o.Where) {
		return nil, false
	}
	return &o.Where, true
}

// HasWhere returns a boolean if a field has been set.
func (o *Rule) HasWhere() bool {
	if o != nil && !IsNil(o.Where) {
		return true
	}

	return false
}

// SetWhere gets a reference to the given []PolicyCondition and assigns it to the Where field.
func (o *Rule) SetWhere(v []PolicyCondition) {
	o.Where = v
}

func (o Rule) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o Rule) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["type"] = o.Type
	toSerialize["on"] = o.On
	if !IsNil(o.Where) {
		toSerialize["where"] = o.Where
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *Rule) UnmarshalJSON(data []byte) (err error) {
	varRule := _Rule{}

	err = json.Unmarshal(data, &varRule)

	if err != nil {
		return err
	}

	*o = Rule(varRule)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "type")
		delete(additionalProperties, "on")
		delete(additionalProperties, "where")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableRule struct {
	value *Rule
	isSet bool
}

func (v NullableRule) Get() *Rule {
	return v.value
}

func (v *NullableRule) Set(val *Rule) {
	v.value = val
	v.isSet = true
}

func (v NullableRule) IsSet() bool {
	return v.isSet
}

func (v *NullableRule) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRule(val *Rule) *NullableRule {
	return &NullableRule{value: val, isSet: true}
}

func (v NullableRule) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableRule) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
