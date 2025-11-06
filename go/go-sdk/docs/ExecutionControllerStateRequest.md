# ExecutionControllerStateRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TaskRunId** | Pointer to **string** |  | [optional] 
**State** | Pointer to [**StateType**](StateType.md) |  | [optional] 

## Methods

### NewExecutionControllerStateRequest

`func NewExecutionControllerStateRequest() *ExecutionControllerStateRequest`

NewExecutionControllerStateRequest instantiates a new ExecutionControllerStateRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionControllerStateRequestWithDefaults

`func NewExecutionControllerStateRequestWithDefaults() *ExecutionControllerStateRequest`

NewExecutionControllerStateRequestWithDefaults instantiates a new ExecutionControllerStateRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTaskRunId

`func (o *ExecutionControllerStateRequest) GetTaskRunId() string`

GetTaskRunId returns the TaskRunId field if non-nil, zero value otherwise.

### GetTaskRunIdOk

`func (o *ExecutionControllerStateRequest) GetTaskRunIdOk() (*string, bool)`

GetTaskRunIdOk returns a tuple with the TaskRunId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunId

`func (o *ExecutionControllerStateRequest) SetTaskRunId(v string)`

SetTaskRunId sets TaskRunId field to given value.

### HasTaskRunId

`func (o *ExecutionControllerStateRequest) HasTaskRunId() bool`

HasTaskRunId returns a boolean if a field has been set.

### GetState

`func (o *ExecutionControllerStateRequest) GetState() StateType`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *ExecutionControllerStateRequest) GetStateOk() (*StateType, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *ExecutionControllerStateRequest) SetState(v StateType)`

SetState sets State field to given value.

### HasState

`func (o *ExecutionControllerStateRequest) HasState() bool`

HasState returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


