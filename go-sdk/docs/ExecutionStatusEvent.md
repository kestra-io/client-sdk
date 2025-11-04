# ExecutionStatusEvent

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ExecutionId** | Pointer to **string** |  | [optional] 
**TenantId** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**FlowId** | Pointer to **string** |  | [optional] 
**State** | Pointer to [**State**](State.md) |  | [optional] 

## Methods

### NewExecutionStatusEvent

`func NewExecutionStatusEvent() *ExecutionStatusEvent`

NewExecutionStatusEvent instantiates a new ExecutionStatusEvent object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionStatusEventWithDefaults

`func NewExecutionStatusEventWithDefaults() *ExecutionStatusEvent`

NewExecutionStatusEventWithDefaults instantiates a new ExecutionStatusEvent object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetExecutionId

`func (o *ExecutionStatusEvent) GetExecutionId() string`

GetExecutionId returns the ExecutionId field if non-nil, zero value otherwise.

### GetExecutionIdOk

`func (o *ExecutionStatusEvent) GetExecutionIdOk() (*string, bool)`

GetExecutionIdOk returns a tuple with the ExecutionId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionId

`func (o *ExecutionStatusEvent) SetExecutionId(v string)`

SetExecutionId sets ExecutionId field to given value.

### HasExecutionId

`func (o *ExecutionStatusEvent) HasExecutionId() bool`

HasExecutionId returns a boolean if a field has been set.

### GetTenantId

`func (o *ExecutionStatusEvent) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *ExecutionStatusEvent) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *ExecutionStatusEvent) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *ExecutionStatusEvent) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetNamespace

`func (o *ExecutionStatusEvent) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ExecutionStatusEvent) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ExecutionStatusEvent) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *ExecutionStatusEvent) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetFlowId

`func (o *ExecutionStatusEvent) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *ExecutionStatusEvent) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *ExecutionStatusEvent) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.

### HasFlowId

`func (o *ExecutionStatusEvent) HasFlowId() bool`

HasFlowId returns a boolean if a field has been set.

### GetState

`func (o *ExecutionStatusEvent) GetState() State`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *ExecutionStatusEvent) GetStateOk() (*State, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *ExecutionStatusEvent) SetState(v State)`

SetState sets State field to given value.

### HasState

`func (o *ExecutionStatusEvent) HasState() bool`

HasState returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


