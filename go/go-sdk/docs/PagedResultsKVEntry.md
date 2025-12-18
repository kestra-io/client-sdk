# PagedResultsKVEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]KVEntry**](KVEntry.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsKVEntry

`func NewPagedResultsKVEntry(results []KVEntry, total int64, ) *PagedResultsKVEntry`

NewPagedResultsKVEntry instantiates a new PagedResultsKVEntry object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsKVEntryWithDefaults

`func NewPagedResultsKVEntryWithDefaults() *PagedResultsKVEntry`

NewPagedResultsKVEntryWithDefaults instantiates a new PagedResultsKVEntry object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsKVEntry) GetResults() []KVEntry`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsKVEntry) GetResultsOk() (*[]KVEntry, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsKVEntry) SetResults(v []KVEntry)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsKVEntry) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsKVEntry) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsKVEntry) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


