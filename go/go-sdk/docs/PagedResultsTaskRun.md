# PagedResultsTaskRun

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]TaskRun**](TaskRun.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsTaskRun

`func NewPagedResultsTaskRun(results []TaskRun, total int64, ) *PagedResultsTaskRun`

NewPagedResultsTaskRun instantiates a new PagedResultsTaskRun object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsTaskRunWithDefaults

`func NewPagedResultsTaskRunWithDefaults() *PagedResultsTaskRun`

NewPagedResultsTaskRunWithDefaults instantiates a new PagedResultsTaskRun object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsTaskRun) GetResults() []TaskRun`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsTaskRun) GetResultsOk() (*[]TaskRun, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsTaskRun) SetResults(v []TaskRun)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsTaskRun) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsTaskRun) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsTaskRun) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


