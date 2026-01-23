# ConcurrencyLimit

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | **string** |  | 
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**Running** | Pointer to **int32** |  | [optional] 

## Methods

### NewConcurrencyLimit

`func NewConcurrencyLimit(tenantId string, namespace string, flowId string, ) *ConcurrencyLimit`

NewConcurrencyLimit instantiates a new ConcurrencyLimit object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewConcurrencyLimitWithDefaults

`func NewConcurrencyLimitWithDefaults() *ConcurrencyLimit`

NewConcurrencyLimitWithDefaults instantiates a new ConcurrencyLimit object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *ConcurrencyLimit) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *ConcurrencyLimit) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *ConcurrencyLimit) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.


### GetNamespace

`func (o *ConcurrencyLimit) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ConcurrencyLimit) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ConcurrencyLimit) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *ConcurrencyLimit) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *ConcurrencyLimit) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *ConcurrencyLimit) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetRunning

`func (o *ConcurrencyLimit) GetRunning() int32`

GetRunning returns the Running field if non-nil, zero value otherwise.

### GetRunningOk

`func (o *ConcurrencyLimit) GetRunningOk() (*int32, bool)`

GetRunningOk returns a tuple with the Running field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRunning

`func (o *ConcurrencyLimit) SetRunning(v int32)`

SetRunning sets Running field to given value.

### HasRunning

`func (o *ConcurrencyLimit) HasRunning() bool`

HasRunning returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


