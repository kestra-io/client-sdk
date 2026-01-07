# PagedResultsFlow

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]Flow**](Flow.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsFlow

`func NewPagedResultsFlow(results []Flow, total int64, ) *PagedResultsFlow`

NewPagedResultsFlow instantiates a new PagedResultsFlow object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsFlowWithDefaults

`func NewPagedResultsFlowWithDefaults() *PagedResultsFlow`

NewPagedResultsFlowWithDefaults instantiates a new PagedResultsFlow object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsFlow) GetResults() []Flow`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsFlow) GetResultsOk() (*[]Flow, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsFlow) SetResults(v []Flow)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsFlow) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsFlow) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsFlow) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


