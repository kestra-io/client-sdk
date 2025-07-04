/*
Kestra EE

All API operations, except for Superadmin-only endpoints, require a tenant identifier in the HTTP path.<br/> Endpoints designated as Superadmin-only are not tenant-scoped.

API version: v1
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package kestra_api_client

import (
	"encoding/json"
	"time"
)

// checks if the GlobalFilter type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &GlobalFilter{}

// GlobalFilter struct for GlobalFilter
type GlobalFilter struct {
	StartDate            *time.Time         `json:"startDate,omitempty"`
	EndDate              *time.Time         `json:"endDate,omitempty"`
	PageSize             *int32             `json:"pageSize,omitempty"`
	PageNumber           *int32             `json:"pageNumber,omitempty"`
	Namespace            *string            `json:"namespace,omitempty"`
	Labels               *map[string]string `json:"labels,omitempty"`
	Filters              []QueryFilter      `json:"filters,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _GlobalFilter GlobalFilter

// NewGlobalFilter instantiates a new GlobalFilter object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewGlobalFilter() *GlobalFilter {
	this := GlobalFilter{}
	return &this
}

// NewGlobalFilterWithDefaults instantiates a new GlobalFilter object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewGlobalFilterWithDefaults() *GlobalFilter {
	this := GlobalFilter{}
	return &this
}

// GetStartDate returns the StartDate field value if set, zero value otherwise.
func (o *GlobalFilter) GetStartDate() time.Time {
	if o == nil || IsNil(o.StartDate) {
		var ret time.Time
		return ret
	}
	return *o.StartDate
}

// GetStartDateOk returns a tuple with the StartDate field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GlobalFilter) GetStartDateOk() (*time.Time, bool) {
	if o == nil || IsNil(o.StartDate) {
		return nil, false
	}
	return o.StartDate, true
}

// HasStartDate returns a boolean if a field has been set.
func (o *GlobalFilter) HasStartDate() bool {
	if o != nil && !IsNil(o.StartDate) {
		return true
	}

	return false
}

// SetStartDate gets a reference to the given time.Time and assigns it to the StartDate field.
func (o *GlobalFilter) SetStartDate(v time.Time) {
	o.StartDate = &v
}

// GetEndDate returns the EndDate field value if set, zero value otherwise.
func (o *GlobalFilter) GetEndDate() time.Time {
	if o == nil || IsNil(o.EndDate) {
		var ret time.Time
		return ret
	}
	return *o.EndDate
}

// GetEndDateOk returns a tuple with the EndDate field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GlobalFilter) GetEndDateOk() (*time.Time, bool) {
	if o == nil || IsNil(o.EndDate) {
		return nil, false
	}
	return o.EndDate, true
}

// HasEndDate returns a boolean if a field has been set.
func (o *GlobalFilter) HasEndDate() bool {
	if o != nil && !IsNil(o.EndDate) {
		return true
	}

	return false
}

// SetEndDate gets a reference to the given time.Time and assigns it to the EndDate field.
func (o *GlobalFilter) SetEndDate(v time.Time) {
	o.EndDate = &v
}

// GetPageSize returns the PageSize field value if set, zero value otherwise.
func (o *GlobalFilter) GetPageSize() int32 {
	if o == nil || IsNil(o.PageSize) {
		var ret int32
		return ret
	}
	return *o.PageSize
}

// GetPageSizeOk returns a tuple with the PageSize field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GlobalFilter) GetPageSizeOk() (*int32, bool) {
	if o == nil || IsNil(o.PageSize) {
		return nil, false
	}
	return o.PageSize, true
}

// HasPageSize returns a boolean if a field has been set.
func (o *GlobalFilter) HasPageSize() bool {
	if o != nil && !IsNil(o.PageSize) {
		return true
	}

	return false
}

// SetPageSize gets a reference to the given int32 and assigns it to the PageSize field.
func (o *GlobalFilter) SetPageSize(v int32) {
	o.PageSize = &v
}

// GetPageNumber returns the PageNumber field value if set, zero value otherwise.
func (o *GlobalFilter) GetPageNumber() int32 {
	if o == nil || IsNil(o.PageNumber) {
		var ret int32
		return ret
	}
	return *o.PageNumber
}

// GetPageNumberOk returns a tuple with the PageNumber field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GlobalFilter) GetPageNumberOk() (*int32, bool) {
	if o == nil || IsNil(o.PageNumber) {
		return nil, false
	}
	return o.PageNumber, true
}

// HasPageNumber returns a boolean if a field has been set.
func (o *GlobalFilter) HasPageNumber() bool {
	if o != nil && !IsNil(o.PageNumber) {
		return true
	}

	return false
}

// SetPageNumber gets a reference to the given int32 and assigns it to the PageNumber field.
func (o *GlobalFilter) SetPageNumber(v int32) {
	o.PageNumber = &v
}

// GetNamespace returns the Namespace field value if set, zero value otherwise.
func (o *GlobalFilter) GetNamespace() string {
	if o == nil || IsNil(o.Namespace) {
		var ret string
		return ret
	}
	return *o.Namespace
}

// GetNamespaceOk returns a tuple with the Namespace field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GlobalFilter) GetNamespaceOk() (*string, bool) {
	if o == nil || IsNil(o.Namespace) {
		return nil, false
	}
	return o.Namespace, true
}

// HasNamespace returns a boolean if a field has been set.
func (o *GlobalFilter) HasNamespace() bool {
	if o != nil && !IsNil(o.Namespace) {
		return true
	}

	return false
}

// SetNamespace gets a reference to the given string and assigns it to the Namespace field.
func (o *GlobalFilter) SetNamespace(v string) {
	o.Namespace = &v
}

// GetLabels returns the Labels field value if set, zero value otherwise.
func (o *GlobalFilter) GetLabels() map[string]string {
	if o == nil || IsNil(o.Labels) {
		var ret map[string]string
		return ret
	}
	return *o.Labels
}

// GetLabelsOk returns a tuple with the Labels field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GlobalFilter) GetLabelsOk() (*map[string]string, bool) {
	if o == nil || IsNil(o.Labels) {
		return nil, false
	}
	return o.Labels, true
}

// HasLabels returns a boolean if a field has been set.
func (o *GlobalFilter) HasLabels() bool {
	if o != nil && !IsNil(o.Labels) {
		return true
	}

	return false
}

// SetLabels gets a reference to the given map[string]string and assigns it to the Labels field.
func (o *GlobalFilter) SetLabels(v map[string]string) {
	o.Labels = &v
}

// GetFilters returns the Filters field value if set, zero value otherwise.
func (o *GlobalFilter) GetFilters() []QueryFilter {
	if o == nil || IsNil(o.Filters) {
		var ret []QueryFilter
		return ret
	}
	return o.Filters
}

// GetFiltersOk returns a tuple with the Filters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GlobalFilter) GetFiltersOk() ([]QueryFilter, bool) {
	if o == nil || IsNil(o.Filters) {
		return nil, false
	}
	return o.Filters, true
}

// HasFilters returns a boolean if a field has been set.
func (o *GlobalFilter) HasFilters() bool {
	if o != nil && !IsNil(o.Filters) {
		return true
	}

	return false
}

// SetFilters gets a reference to the given []QueryFilter and assigns it to the Filters field.
func (o *GlobalFilter) SetFilters(v []QueryFilter) {
	o.Filters = v
}

func (o GlobalFilter) MarshalJSON() ([]byte, error) {
	toSerialize, err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o GlobalFilter) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.StartDate) {
		toSerialize["startDate"] = o.StartDate
	}
	if !IsNil(o.EndDate) {
		toSerialize["endDate"] = o.EndDate
	}
	if !IsNil(o.PageSize) {
		toSerialize["pageSize"] = o.PageSize
	}
	if !IsNil(o.PageNumber) {
		toSerialize["pageNumber"] = o.PageNumber
	}
	if !IsNil(o.Namespace) {
		toSerialize["namespace"] = o.Namespace
	}
	if !IsNil(o.Labels) {
		toSerialize["labels"] = o.Labels
	}
	if !IsNil(o.Filters) {
		toSerialize["filters"] = o.Filters
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *GlobalFilter) UnmarshalJSON(data []byte) (err error) {
	varGlobalFilter := _GlobalFilter{}

	err = json.Unmarshal(data, &varGlobalFilter)

	if err != nil {
		return err
	}

	*o = GlobalFilter(varGlobalFilter)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "startDate")
		delete(additionalProperties, "endDate")
		delete(additionalProperties, "pageSize")
		delete(additionalProperties, "pageNumber")
		delete(additionalProperties, "namespace")
		delete(additionalProperties, "labels")
		delete(additionalProperties, "filters")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableGlobalFilter struct {
	value *GlobalFilter
	isSet bool
}

func (v NullableGlobalFilter) Get() *GlobalFilter {
	return v.value
}

func (v *NullableGlobalFilter) Set(val *GlobalFilter) {
	v.value = val
	v.isSet = true
}

func (v NullableGlobalFilter) IsSet() bool {
	return v.isSet
}

func (v *NullableGlobalFilter) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGlobalFilter(val *GlobalFilter) *NullableGlobalFilter {
	return &NullableGlobalFilter{value: val, isSet: true}
}

func (v NullableGlobalFilter) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableGlobalFilter) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
