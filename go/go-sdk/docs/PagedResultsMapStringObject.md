# PagedResultsMapStringObject

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | **[]map[string]map[string]interface{}** |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsMapStringObject

`func NewPagedResultsMapStringObject(results []map[string]map[string]interface{}, total int64, ) *PagedResultsMapStringObject`

NewPagedResultsMapStringObject instantiates a new PagedResultsMapStringObject object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsMapStringObjectWithDefaults

`func NewPagedResultsMapStringObjectWithDefaults() *PagedResultsMapStringObject`

NewPagedResultsMapStringObjectWithDefaults instantiates a new PagedResultsMapStringObject object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsMapStringObject) GetResults() []map[string]map[string]interface{}`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsMapStringObject) GetResultsOk() (*[]map[string]map[string]interface{}, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsMapStringObject) SetResults(v []map[string]map[string]interface{})`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsMapStringObject) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsMapStringObject) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsMapStringObject) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


