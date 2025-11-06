# PagedResultsMetricEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]MetricEntry**](MetricEntry.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsMetricEntry

`func NewPagedResultsMetricEntry(results []MetricEntry, total int64, ) *PagedResultsMetricEntry`

NewPagedResultsMetricEntry instantiates a new PagedResultsMetricEntry object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsMetricEntryWithDefaults

`func NewPagedResultsMetricEntryWithDefaults() *PagedResultsMetricEntry`

NewPagedResultsMetricEntryWithDefaults instantiates a new PagedResultsMetricEntry object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsMetricEntry) GetResults() []MetricEntry`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsMetricEntry) GetResultsOk() (*[]MetricEntry, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsMetricEntry) SetResults(v []MetricEntry)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsMetricEntry) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsMetricEntry) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsMetricEntry) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


