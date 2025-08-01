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

// checks if the PagedResultsGroup type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PagedResultsGroup{}

// PagedResultsGroup struct for PagedResultsGroup
type PagedResultsGroup struct {
	Results              []Group `json:"results"`
	Total                int64   `json:"total"`
	AdditionalProperties map[string]interface{}
}

type _PagedResultsGroup PagedResultsGroup

// NewPagedResultsGroup instantiates a new PagedResultsGroup object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPagedResultsGroup(results []Group, total int64) *PagedResultsGroup {
	this := PagedResultsGroup{}
	this.Results = results
	this.Total = total
	return &this
}

// NewPagedResultsGroupWithDefaults instantiates a new PagedResultsGroup object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPagedResultsGroupWithDefaults() *PagedResultsGroup {
	this := PagedResultsGroup{}
	return &this
}

// GetResults returns the Results field value
func (o *PagedResultsGroup) GetResults() []Group {
	if o == nil {
		var ret []Group
		return ret
	}

	return o.Results
}

// GetResultsOk returns a tuple with the Results field value
// and a boolean to check if the value has been set.
func (o *PagedResultsGroup) GetResultsOk() ([]Group, bool) {
	if o == nil {
		return nil, false
	}
	return o.Results, true
}

// SetResults sets field value
func (o *PagedResultsGroup) SetResults(v []Group) {
	o.Results = v
}

// GetTotal returns the Total field value
func (o *PagedResultsGroup) GetTotal() int64 {
	if o == nil {
		var ret int64
		return ret
	}

	return o.Total
}

// GetTotalOk returns a tuple with the Total field value
// and a boolean to check if the value has been set.
func (o *PagedResultsGroup) GetTotalOk() (*int64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Total, true
}

// SetTotal sets field value
func (o *PagedResultsGroup) SetTotal(v int64) {
	o.Total = v
}

func (o PagedResultsGroup) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PagedResultsGroup) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["results"] = o.Results
	toSerialize["total"] = o.Total

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PagedResultsGroup) UnmarshalJSON(data []byte) (err error) {
	// This validates that all required properties are included in the JSON object
	// by unmarshalling the object into a generic map with string keys and checking
	// that every required field exists as a key in the generic map.
	requiredProperties := []string{
		"results",
		"total",
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

	varPagedResultsGroup := _PagedResultsGroup{}

	err = json.Unmarshal(data, &varPagedResultsGroup)

	if err != nil {
		return err
	}

	*o = PagedResultsGroup(varPagedResultsGroup)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "results")
		delete(additionalProperties, "total")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePagedResultsGroup struct {
	value *PagedResultsGroup
	isSet bool
}

func (v NullablePagedResultsGroup) Get() *PagedResultsGroup {
	return v.value
}

func (v *NullablePagedResultsGroup) Set(val *PagedResultsGroup) {
	v.value = val
	v.isSet = true
}

func (v NullablePagedResultsGroup) IsSet() bool {
	return v.isSet
}

func (v *NullablePagedResultsGroup) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePagedResultsGroup(val *PagedResultsGroup) *NullablePagedResultsGroup {
	return &NullablePagedResultsGroup{value: val, isSet: true}
}

func (v NullablePagedResultsGroup) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePagedResultsGroup) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
