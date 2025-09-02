# Metric

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** |  | 
**Type** | **string** |  | 
**Description** | **string** |  | 
**BaseUnit** | **string** |  | 
**Tags** | [**[]MetricTag**](MetricTag.md) |  | 
**Value** | **map[string]interface{}** |  | 

## Methods

### NewMetric

`func NewMetric(name string, type_ string, description string, baseUnit string, tags []MetricTag, value map[string]interface{}, ) *Metric`

NewMetric instantiates a new Metric object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMetricWithDefaults

`func NewMetricWithDefaults() *Metric`

NewMetricWithDefaults instantiates a new Metric object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *Metric) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *Metric) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *Metric) SetName(v string)`

SetName sets Name field to given value.


### GetType

`func (o *Metric) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *Metric) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *Metric) SetType(v string)`

SetType sets Type field to given value.


### GetDescription

`func (o *Metric) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Metric) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Metric) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetBaseUnit

`func (o *Metric) GetBaseUnit() string`

GetBaseUnit returns the BaseUnit field if non-nil, zero value otherwise.

### GetBaseUnitOk

`func (o *Metric) GetBaseUnitOk() (*string, bool)`

GetBaseUnitOk returns a tuple with the BaseUnit field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBaseUnit

`func (o *Metric) SetBaseUnit(v string)`

SetBaseUnit sets BaseUnit field to given value.


### GetTags

`func (o *Metric) GetTags() []MetricTag`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *Metric) GetTagsOk() (*[]MetricTag, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *Metric) SetTags(v []MetricTag)`

SetTags sets Tags field to given value.


### GetValue

`func (o *Metric) GetValue() map[string]interface{}`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *Metric) GetValueOk() (*map[string]interface{}, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *Metric) SetValue(v map[string]interface{})`

SetValue sets Value field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


