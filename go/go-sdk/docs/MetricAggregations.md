# MetricAggregations

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**GroupBy** | **string** |  | 
**Aggregations** | [**[]MetricAggregation**](MetricAggregation.md) |  | 

## Methods

### NewMetricAggregations

`func NewMetricAggregations(groupBy string, aggregations []MetricAggregation, ) *MetricAggregations`

NewMetricAggregations instantiates a new MetricAggregations object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMetricAggregationsWithDefaults

`func NewMetricAggregationsWithDefaults() *MetricAggregations`

NewMetricAggregationsWithDefaults instantiates a new MetricAggregations object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetGroupBy

`func (o *MetricAggregations) GetGroupBy() string`

GetGroupBy returns the GroupBy field if non-nil, zero value otherwise.

### GetGroupByOk

`func (o *MetricAggregations) GetGroupByOk() (*string, bool)`

GetGroupByOk returns a tuple with the GroupBy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroupBy

`func (o *MetricAggregations) SetGroupBy(v string)`

SetGroupBy sets GroupBy field to given value.


### GetAggregations

`func (o *MetricAggregations) GetAggregations() []MetricAggregation`

GetAggregations returns the Aggregations field if non-nil, zero value otherwise.

### GetAggregationsOk

`func (o *MetricAggregations) GetAggregationsOk() (*[]MetricAggregation, bool)`

GetAggregationsOk returns a tuple with the Aggregations field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAggregations

`func (o *MetricAggregations) SetAggregations(v []MetricAggregation)`

SetAggregations sets Aggregations field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


