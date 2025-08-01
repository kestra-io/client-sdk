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

// checks if the AssertionResult type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &AssertionResult{}

// AssertionResult struct for AssertionResult
type AssertionResult struct {
	Operator             string      `json:"operator"`
	Expected             interface{} `json:"expected"`
	Actual               interface{} `json:"actual"`
	IsSuccess            bool        `json:"isSuccess"`
	TaskId               string      `json:"taskId"`
	Description          string      `json:"description"`
	ErrorMessage         string      `json:"errorMessage"`
	AdditionalProperties map[string]interface{}
}

type _AssertionResult AssertionResult

// NewAssertionResult instantiates a new AssertionResult object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAssertionResult(operator string, expected interface{}, actual interface{}, isSuccess bool, taskId string, description string, errorMessage string) *AssertionResult {
	this := AssertionResult{}
	this.Operator = operator
	this.Expected = expected
	this.Actual = actual
	this.IsSuccess = isSuccess
	this.TaskId = taskId
	this.Description = description
	this.ErrorMessage = errorMessage
	return &this
}

// NewAssertionResultWithDefaults instantiates a new AssertionResult object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAssertionResultWithDefaults() *AssertionResult {
	this := AssertionResult{}
	return &this
}

// GetOperator returns the Operator field value
func (o *AssertionResult) GetOperator() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Operator
}

// GetOperatorOk returns a tuple with the Operator field value
// and a boolean to check if the value has been set.
func (o *AssertionResult) GetOperatorOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Operator, true
}

// SetOperator sets field value
func (o *AssertionResult) SetOperator(v string) {
	o.Operator = v
}

// GetExpected returns the Expected field value
// If the value is explicit nil, the zero value for interface{} will be returned
func (o *AssertionResult) GetExpected() interface{} {
	if o == nil {
		var ret interface{}
		return ret
	}

	return o.Expected
}

// GetExpectedOk returns a tuple with the Expected field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *AssertionResult) GetExpectedOk() (*interface{}, bool) {
	if o == nil || IsNil(o.Expected) {
		return nil, false
	}
	return &o.Expected, true
}

// SetExpected sets field value
func (o *AssertionResult) SetExpected(v interface{}) {
	o.Expected = v
}

// GetActual returns the Actual field value
// If the value is explicit nil, the zero value for interface{} will be returned
func (o *AssertionResult) GetActual() interface{} {
	if o == nil {
		var ret interface{}
		return ret
	}

	return o.Actual
}

// GetActualOk returns a tuple with the Actual field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *AssertionResult) GetActualOk() (*interface{}, bool) {
	if o == nil || IsNil(o.Actual) {
		return nil, false
	}
	return &o.Actual, true
}

// SetActual sets field value
func (o *AssertionResult) SetActual(v interface{}) {
	o.Actual = v
}

// GetIsSuccess returns the IsSuccess field value
func (o *AssertionResult) GetIsSuccess() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.IsSuccess
}

// GetIsSuccessOk returns a tuple with the IsSuccess field value
// and a boolean to check if the value has been set.
func (o *AssertionResult) GetIsSuccessOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IsSuccess, true
}

// SetIsSuccess sets field value
func (o *AssertionResult) SetIsSuccess(v bool) {
	o.IsSuccess = v
}

// GetTaskId returns the TaskId field value
func (o *AssertionResult) GetTaskId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.TaskId
}

// GetTaskIdOk returns a tuple with the TaskId field value
// and a boolean to check if the value has been set.
func (o *AssertionResult) GetTaskIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TaskId, true
}

// SetTaskId sets field value
func (o *AssertionResult) SetTaskId(v string) {
	o.TaskId = v
}

// GetDescription returns the Description field value
func (o *AssertionResult) GetDescription() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Description
}

// GetDescriptionOk returns a tuple with the Description field value
// and a boolean to check if the value has been set.
func (o *AssertionResult) GetDescriptionOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Description, true
}

// SetDescription sets field value
func (o *AssertionResult) SetDescription(v string) {
	o.Description = v
}

// GetErrorMessage returns the ErrorMessage field value
func (o *AssertionResult) GetErrorMessage() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ErrorMessage
}

// GetErrorMessageOk returns a tuple with the ErrorMessage field value
// and a boolean to check if the value has been set.
func (o *AssertionResult) GetErrorMessageOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ErrorMessage, true
}

// SetErrorMessage sets field value
func (o *AssertionResult) SetErrorMessage(v string) {
	o.ErrorMessage = v
}

func (o AssertionResult) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o AssertionResult) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["operator"] = o.Operator
	if o.Expected != nil {
		toSerialize["expected"] = o.Expected
	}
	if o.Actual != nil {
		toSerialize["actual"] = o.Actual
	}
	toSerialize["isSuccess"] = o.IsSuccess
	toSerialize["taskId"] = o.TaskId
	toSerialize["description"] = o.Description
	toSerialize["errorMessage"] = o.ErrorMessage

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *AssertionResult) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"operator",
		"expected",
		"actual",
		"isSuccess",
		"taskId",
		"description",
		"errorMessage",
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

	varAssertionResult := _AssertionResult{}

	err = json.Unmarshal(data, &varAssertionResult)

	if err != nil {
		return err
	}

	*o = AssertionResult(varAssertionResult)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "operator")
		delete(additionalProperties, "expected")
		delete(additionalProperties, "actual")
		delete(additionalProperties, "isSuccess")
		delete(additionalProperties, "taskId")
		delete(additionalProperties, "description")
		delete(additionalProperties, "errorMessage")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableAssertionResult struct {
	value *AssertionResult
	isSet bool
}

func (v NullableAssertionResult) Get() *AssertionResult {
	return v.value
}

func (v *NullableAssertionResult) Set(val *AssertionResult) {
	v.value = val
	v.isSet = true
}

func (v NullableAssertionResult) IsSet() bool {
	return v.isSet
}

func (v *NullableAssertionResult) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAssertionResult(val *AssertionResult) *NullableAssertionResult {
	return &NullableAssertionResult{value: val, isSet: true}
}

func (v NullableAssertionResult) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAssertionResult) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
