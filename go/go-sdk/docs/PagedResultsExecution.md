# PagedResultsExecution

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]Execution**](Execution.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsExecution

`func NewPagedResultsExecution(results []Execution, total int64, ) *PagedResultsExecution`

NewPagedResultsExecution instantiates a new PagedResultsExecution object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsExecutionWithDefaults

`func NewPagedResultsExecutionWithDefaults() *PagedResultsExecution`

NewPagedResultsExecutionWithDefaults instantiates a new PagedResultsExecution object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsExecution) GetResults() []Execution`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsExecution) GetResultsOk() (*[]Execution, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsExecution) SetResults(v []Execution)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsExecution) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsExecution) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsExecution) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


