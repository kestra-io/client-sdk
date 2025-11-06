# ExecutionControllerLastExecutionResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**FlowId** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**StartDate** | Pointer to **time.Time** |  | [optional] 
**Status** | Pointer to [**StateType**](StateType.md) |  | [optional] 

## Methods

### NewExecutionControllerLastExecutionResponse

`func NewExecutionControllerLastExecutionResponse() *ExecutionControllerLastExecutionResponse`

NewExecutionControllerLastExecutionResponse instantiates a new ExecutionControllerLastExecutionResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionControllerLastExecutionResponseWithDefaults

`func NewExecutionControllerLastExecutionResponseWithDefaults() *ExecutionControllerLastExecutionResponse`

NewExecutionControllerLastExecutionResponseWithDefaults instantiates a new ExecutionControllerLastExecutionResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ExecutionControllerLastExecutionResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ExecutionControllerLastExecutionResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ExecutionControllerLastExecutionResponse) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ExecutionControllerLastExecutionResponse) HasId() bool`

HasId returns a boolean if a field has been set.

### GetFlowId

`func (o *ExecutionControllerLastExecutionResponse) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *ExecutionControllerLastExecutionResponse) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *ExecutionControllerLastExecutionResponse) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.

### HasFlowId

`func (o *ExecutionControllerLastExecutionResponse) HasFlowId() bool`

HasFlowId returns a boolean if a field has been set.

### GetNamespace

`func (o *ExecutionControllerLastExecutionResponse) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ExecutionControllerLastExecutionResponse) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ExecutionControllerLastExecutionResponse) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *ExecutionControllerLastExecutionResponse) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetStartDate

`func (o *ExecutionControllerLastExecutionResponse) GetStartDate() time.Time`

GetStartDate returns the StartDate field if non-nil, zero value otherwise.

### GetStartDateOk

`func (o *ExecutionControllerLastExecutionResponse) GetStartDateOk() (*time.Time, bool)`

GetStartDateOk returns a tuple with the StartDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartDate

`func (o *ExecutionControllerLastExecutionResponse) SetStartDate(v time.Time)`

SetStartDate sets StartDate field to given value.

### HasStartDate

`func (o *ExecutionControllerLastExecutionResponse) HasStartDate() bool`

HasStartDate returns a boolean if a field has been set.

### GetStatus

`func (o *ExecutionControllerLastExecutionResponse) GetStatus() StateType`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *ExecutionControllerLastExecutionResponse) GetStatusOk() (*StateType, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *ExecutionControllerLastExecutionResponse) SetStatus(v StateType)`

SetStatus sets Status field to given value.

### HasStatus

`func (o *ExecutionControllerLastExecutionResponse) HasStatus() bool`

HasStatus returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


