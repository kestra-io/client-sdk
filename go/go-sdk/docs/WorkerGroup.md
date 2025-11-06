# WorkerGroup

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Key** | Pointer to **string** |  | [optional] 
**Fallback** | Pointer to [**WorkerGroupFallback**](WorkerGroupFallback.md) |  | [optional] 

## Methods

### NewWorkerGroup

`func NewWorkerGroup() *WorkerGroup`

NewWorkerGroup instantiates a new WorkerGroup object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewWorkerGroupWithDefaults

`func NewWorkerGroupWithDefaults() *WorkerGroup`

NewWorkerGroupWithDefaults instantiates a new WorkerGroup object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetKey

`func (o *WorkerGroup) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *WorkerGroup) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *WorkerGroup) SetKey(v string)`

SetKey sets Key field to given value.

### HasKey

`func (o *WorkerGroup) HasKey() bool`

HasKey returns a boolean if a field has been set.

### GetFallback

`func (o *WorkerGroup) GetFallback() WorkerGroupFallback`

GetFallback returns the Fallback field if non-nil, zero value otherwise.

### GetFallbackOk

`func (o *WorkerGroup) GetFallbackOk() (*WorkerGroupFallback, bool)`

GetFallbackOk returns a tuple with the Fallback field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFallback

`func (o *WorkerGroup) SetFallback(v WorkerGroupFallback)`

SetFallback sets Fallback field to given value.

### HasFallback

`func (o *WorkerGroup) HasFallback() bool`

HasFallback returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


