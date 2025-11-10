# PagedResultsBlueprint

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]Blueprint**](Blueprint.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsBlueprint

`func NewPagedResultsBlueprint(results []Blueprint, total int64, ) *PagedResultsBlueprint`

NewPagedResultsBlueprint instantiates a new PagedResultsBlueprint object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsBlueprintWithDefaults

`func NewPagedResultsBlueprintWithDefaults() *PagedResultsBlueprint`

NewPagedResultsBlueprintWithDefaults instantiates a new PagedResultsBlueprint object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsBlueprint) GetResults() []Blueprint`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsBlueprint) GetResultsOk() (*[]Blueprint, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsBlueprint) SetResults(v []Blueprint)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsBlueprint) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsBlueprint) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsBlueprint) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


