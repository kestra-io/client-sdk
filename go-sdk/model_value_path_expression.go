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

// checks if the ValuePathExpression type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ValuePathExpression{}

// ValuePathExpression struct for ValuePathExpression
type ValuePathExpression struct {
	AttributePath        AttributeReference     `json:"attributePath"`
	AttributeExpression  map[string]interface{} `json:"attributeExpression,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _ValuePathExpression ValuePathExpression

// NewValuePathExpression instantiates a new ValuePathExpression object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewValuePathExpression(attributePath AttributeReference) *ValuePathExpression {
	this := ValuePathExpression{}
	this.AttributePath = attributePath
	return &this
}

// NewValuePathExpressionWithDefaults instantiates a new ValuePathExpression object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewValuePathExpressionWithDefaults() *ValuePathExpression {
	this := ValuePathExpression{}
	return &this
}

// GetAttributePath returns the AttributePath field value
func (o *ValuePathExpression) GetAttributePath() AttributeReference {
	if o == nil {
		var ret AttributeReference
		return ret
	}

	return o.AttributePath
}

// GetAttributePathOk returns a tuple with the AttributePath field value
// and a boolean to check if the value has been set.
func (o *ValuePathExpression) GetAttributePathOk() (*AttributeReference, bool) {
	if o == nil {
		return nil, false
	}
	return &o.AttributePath, true
}

// SetAttributePath sets field value
func (o *ValuePathExpression) SetAttributePath(v AttributeReference) {
	o.AttributePath = v
}

// GetAttributeExpression returns the AttributeExpression field value if set, zero value otherwise.
func (o *ValuePathExpression) GetAttributeExpression() map[string]interface{} {
	if o == nil || IsNil(o.AttributeExpression) {
		var ret map[string]interface{}
		return ret
	}
	return o.AttributeExpression
}

// GetAttributeExpressionOk returns a tuple with the AttributeExpression field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ValuePathExpression) GetAttributeExpressionOk() (map[string]interface{}, bool) {
	if o == nil || IsNil(o.AttributeExpression) {
		return map[string]interface{}{}, false
	}
	return o.AttributeExpression, true
}

// HasAttributeExpression returns a boolean if a field has been set.
func (o *ValuePathExpression) HasAttributeExpression() bool {
	if o != nil && !IsNil(o.AttributeExpression) {
		return true
	}

	return false
}

// SetAttributeExpression gets a reference to the given map[string]interface{} and assigns it to the AttributeExpression field.
func (o *ValuePathExpression) SetAttributeExpression(v map[string]interface{}) {
	o.AttributeExpression = v
}

func (o ValuePathExpression) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ValuePathExpression) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["attributePath"] = o.AttributePath
	if !IsNil(o.AttributeExpression) {
		toSerialize["attributeExpression"] = o.AttributeExpression
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ValuePathExpression) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"attributePath",
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

	varValuePathExpression := _ValuePathExpression{}

	err = json.Unmarshal(data, &varValuePathExpression)

	if err != nil {
		return err
	}

	*o = ValuePathExpression(varValuePathExpression)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "attributePath")
		delete(additionalProperties, "attributeExpression")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableValuePathExpression struct {
	value *ValuePathExpression
	isSet bool
}

func (v NullableValuePathExpression) Get() *ValuePathExpression {
	return v.value
}

func (v *NullableValuePathExpression) Set(val *ValuePathExpression) {
	v.value = val
	v.isSet = true
}

func (v NullableValuePathExpression) IsSet() bool {
	return v.isSet
}

func (v *NullableValuePathExpression) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableValuePathExpression(val *ValuePathExpression) *NullableValuePathExpression {
	return &NullableValuePathExpression{value: val, isSet: true}
}

func (v NullableValuePathExpression) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableValuePathExpression) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
