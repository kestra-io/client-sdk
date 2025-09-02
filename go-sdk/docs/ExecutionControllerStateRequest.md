# ExecutionControllerStateRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TaskRunId** | **string** |  | 
**State** | [**StateType**](StateType.md) |  | 

## Methods

### NewExecutionControllerStateRequest

`func NewExecutionControllerStateRequest(taskRunId string, state StateType, ) *ExecutionControllerStateRequest`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


