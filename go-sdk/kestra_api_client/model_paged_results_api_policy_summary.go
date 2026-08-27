/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: 2.0.0-SNAPSHOT
*/

package kestra_api_client

import (
	"encoding/json"
)

// checks if the PagedResultsApiPolicySummary type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &PagedResultsApiPolicySummary{}

// PagedResultsApiPolicySummary struct for PagedResultsApiPolicySummary
type PagedResultsApiPolicySummary struct {
	Results              []PolicySummary `json:"results"`
	Total                int64           `json:"total"`
	AdditionalProperties map[string]interface{}
}

type _PagedResultsApiPolicySummary PagedResultsApiPolicySummary

// NewPagedResultsApiPolicySummary instantiates a new PagedResultsApiPolicySummary object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewPagedResultsApiPolicySummary(results []PolicySummary, total int64) *PagedResultsApiPolicySummary {
	this := PagedResultsApiPolicySummary{}
	this.Results = results
	this.Total = total
	return &this
}

// NewPagedResultsApiPolicySummaryWithDefaults instantiates a new PagedResultsApiPolicySummary object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewPagedResultsApiPolicySummaryWithDefaults() *PagedResultsApiPolicySummary {
	this := PagedResultsApiPolicySummary{}
	return &this
}

// GetResults returns the Results field value
func (o *PagedResultsApiPolicySummary) GetResults() []PolicySummary {
	if o == nil {
		var ret []PolicySummary
		return ret
	}
	return o.Results
}

// GetResultsOk returns a tuple with the Results field value
// and a boolean to check if the value has been set.
func (o *PagedResultsApiPolicySummary) GetResultsOk() (*[]PolicySummary, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Results, true
}

// SetResults sets field value
func (o *PagedResultsApiPolicySummary) SetResults(v []PolicySummary) {
	o.Results = v
}

// GetTotal returns the Total field value
func (o *PagedResultsApiPolicySummary) GetTotal() int64 {
	if o == nil {
		var ret int64
		return ret
	}
	return o.Total
}

// GetTotalOk returns a tuple with the Total field value
// and a boolean to check if the value has been set.
func (o *PagedResultsApiPolicySummary) GetTotalOk() (*int64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Total, true
}

// SetTotal sets field value
func (o *PagedResultsApiPolicySummary) SetTotal(v int64) {
	o.Total = v
}

func (o PagedResultsApiPolicySummary) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o PagedResultsApiPolicySummary) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	toSerialize["results"] = o.Results
	toSerialize["total"] = o.Total

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *PagedResultsApiPolicySummary) UnmarshalJSON(data []byte) (err error) {
	varPagedResultsApiPolicySummary := _PagedResultsApiPolicySummary{}

	err = json.Unmarshal(data, &varPagedResultsApiPolicySummary)

	if err != nil {
		return err
	}

	*o = PagedResultsApiPolicySummary(varPagedResultsApiPolicySummary)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "results")
		delete(additionalProperties, "total")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullablePagedResultsApiPolicySummary struct {
	value *PagedResultsApiPolicySummary
	isSet bool
}

func (v NullablePagedResultsApiPolicySummary) Get() *PagedResultsApiPolicySummary {
	return v.value
}

func (v *NullablePagedResultsApiPolicySummary) Set(val *PagedResultsApiPolicySummary) {
	v.value = val
	v.isSet = true
}

func (v NullablePagedResultsApiPolicySummary) IsSet() bool {
	return v.isSet
}

func (v *NullablePagedResultsApiPolicySummary) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePagedResultsApiPolicySummary(val *PagedResultsApiPolicySummary) *NullablePagedResultsApiPolicySummary {
	return &NullablePagedResultsApiPolicySummary{value: val, isSet: true}
}

func (v NullablePagedResultsApiPolicySummary) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullablePagedResultsApiPolicySummary) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
