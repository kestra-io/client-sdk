# PagedResultsGroup

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]Group**](Group.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsGroup

`func NewPagedResultsGroup(results []Group, total int64, ) *PagedResultsGroup`

NewPagedResultsGroup instantiates a new PagedResultsGroup object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsGroupWithDefaults

`func NewPagedResultsGroupWithDefaults() *PagedResultsGroup`

NewPagedResultsGroupWithDefaults instantiates a new PagedResultsGroup object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsGroup) GetResults() []Group`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsGroup) GetResultsOk() (*[]Group, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsGroup) SetResults(v []Group)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsGroup) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsGroup) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsGroup) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


