# PagedResultsNamespace

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Results** | [**[]Namespace**](Namespace.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewPagedResultsNamespace

`func NewPagedResultsNamespace(results []Namespace, total int64, ) *PagedResultsNamespace`

NewPagedResultsNamespace instantiates a new PagedResultsNamespace object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPagedResultsNamespaceWithDefaults

`func NewPagedResultsNamespaceWithDefaults() *PagedResultsNamespace`

NewPagedResultsNamespaceWithDefaults instantiates a new PagedResultsNamespace object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResults

`func (o *PagedResultsNamespace) GetResults() []Namespace`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *PagedResultsNamespace) GetResultsOk() (*[]Namespace, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *PagedResultsNamespace) SetResults(v []Namespace)`

SetResults sets Results field to given value.


### GetTotal

`func (o *PagedResultsNamespace) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *PagedResultsNamespace) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *PagedResultsNamespace) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


