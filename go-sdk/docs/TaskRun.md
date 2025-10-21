# TaskRun

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Items** | Pointer to **string** |  | [optional] 
**Id** | **string** |  | 
**ExecutionId** | **string** |  | 
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**TaskId** | **string** |  | 
**ParentTaskRunId** | Pointer to **string** |  | [optional] 
**Value** | Pointer to **string** |  | [optional] 
**Attempts** | Pointer to [**[]TaskRunAttempt**](TaskRunAttempt.md) |  | [optional] 
**Outputs** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**State** | [**State**](State.md) |  | 
**Iteration** | Pointer to **int32** |  | [optional] 
**Dynamic** | Pointer to **bool** |  | [optional] 
**ForceExecution** | Pointer to **bool** |  | [optional] 

## Methods

### NewTaskRun

`func NewTaskRun(id string, executionId string, namespace string, flowId string, taskId string, state State, ) *TaskRun`

NewTaskRun instantiates a new TaskRun object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTaskRunWithDefaults

`func NewTaskRunWithDefaults() *TaskRun`

NewTaskRunWithDefaults instantiates a new TaskRun object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetItems

`func (o *TaskRun) GetItems() string`

GetItems returns the Items field if non-nil, zero value otherwise.

### GetItemsOk

`func (o *TaskRun) GetItemsOk() (*string, bool)`

GetItemsOk returns a tuple with the Items field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetItems

`func (o *TaskRun) SetItems(v string)`

SetItems sets Items field to given value.

### HasItems

`func (o *TaskRun) HasItems() bool`

HasItems returns a boolean if a field has been set.

### GetId

`func (o *TaskRun) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *TaskRun) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *TaskRun) SetId(v string)`

SetId sets Id field to given value.


### GetExecutionId

`func (o *TaskRun) GetExecutionId() string`

GetExecutionId returns the ExecutionId field if non-nil, zero value otherwise.

### GetExecutionIdOk

`func (o *TaskRun) GetExecutionIdOk() (*string, bool)`

GetExecutionIdOk returns a tuple with the ExecutionId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionId

`func (o *TaskRun) SetExecutionId(v string)`

SetExecutionId sets ExecutionId field to given value.


### GetNamespace

`func (o *TaskRun) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *TaskRun) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *TaskRun) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *TaskRun) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *TaskRun) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *TaskRun) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetTaskId

`func (o *TaskRun) GetTaskId() string`

GetTaskId returns the TaskId field if non-nil, zero value otherwise.

### GetTaskIdOk

`func (o *TaskRun) GetTaskIdOk() (*string, bool)`

GetTaskIdOk returns a tuple with the TaskId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskId

`func (o *TaskRun) SetTaskId(v string)`

SetTaskId sets TaskId field to given value.


### GetParentTaskRunId

`func (o *TaskRun) GetParentTaskRunId() string`

GetParentTaskRunId returns the ParentTaskRunId field if non-nil, zero value otherwise.

### GetParentTaskRunIdOk

`func (o *TaskRun) GetParentTaskRunIdOk() (*string, bool)`

GetParentTaskRunIdOk returns a tuple with the ParentTaskRunId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetParentTaskRunId

`func (o *TaskRun) SetParentTaskRunId(v string)`

SetParentTaskRunId sets ParentTaskRunId field to given value.

### HasParentTaskRunId

`func (o *TaskRun) HasParentTaskRunId() bool`

HasParentTaskRunId returns a boolean if a field has been set.

### GetValue

`func (o *TaskRun) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *TaskRun) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *TaskRun) SetValue(v string)`

SetValue sets Value field to given value.

### HasValue

`func (o *TaskRun) HasValue() bool`

HasValue returns a boolean if a field has been set.

### GetAttempts

`func (o *TaskRun) GetAttempts() []TaskRunAttempt`

GetAttempts returns the Attempts field if non-nil, zero value otherwise.

### GetAttemptsOk

`func (o *TaskRun) GetAttemptsOk() (*[]TaskRunAttempt, bool)`

GetAttemptsOk returns a tuple with the Attempts field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttempts

`func (o *TaskRun) SetAttempts(v []TaskRunAttempt)`

SetAttempts sets Attempts field to given value.

### HasAttempts

`func (o *TaskRun) HasAttempts() bool`

HasAttempts returns a boolean if a field has been set.

### GetOutputs

`func (o *TaskRun) GetOutputs() map[string]map[string]interface{}`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *TaskRun) GetOutputsOk() (*map[string]map[string]interface{}, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *TaskRun) SetOutputs(v map[string]map[string]interface{})`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *TaskRun) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### SetOutputsNil

`func (o *TaskRun) SetOutputsNil(b bool)`

 SetOutputsNil sets the value for Outputs to be an explicit nil

### UnsetOutputs
`func (o *TaskRun) UnsetOutputs()`

UnsetOutputs ensures that no value is present for Outputs, not even an explicit nil
### GetState

`func (o *TaskRun) GetState() State`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *TaskRun) GetStateOk() (*State, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *TaskRun) SetState(v State)`

SetState sets State field to given value.


### GetIteration

`func (o *TaskRun) GetIteration() int32`

GetIteration returns the Iteration field if non-nil, zero value otherwise.

### GetIterationOk

`func (o *TaskRun) GetIterationOk() (*int32, bool)`

GetIterationOk returns a tuple with the Iteration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIteration

`func (o *TaskRun) SetIteration(v int32)`

SetIteration sets Iteration field to given value.

### HasIteration

`func (o *TaskRun) HasIteration() bool`

HasIteration returns a boolean if a field has been set.

### GetDynamic

`func (o *TaskRun) GetDynamic() bool`

GetDynamic returns the Dynamic field if non-nil, zero value otherwise.

### GetDynamicOk

`func (o *TaskRun) GetDynamicOk() (*bool, bool)`

GetDynamicOk returns a tuple with the Dynamic field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDynamic

`func (o *TaskRun) SetDynamic(v bool)`

SetDynamic sets Dynamic field to given value.

### HasDynamic

`func (o *TaskRun) HasDynamic() bool`

HasDynamic returns a boolean if a field has been set.

### GetForceExecution

`func (o *TaskRun) GetForceExecution() bool`

GetForceExecution returns the ForceExecution field if non-nil, zero value otherwise.

### GetForceExecutionOk

`func (o *TaskRun) GetForceExecutionOk() (*bool, bool)`

GetForceExecutionOk returns a tuple with the ForceExecution field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetForceExecution

`func (o *TaskRun) SetForceExecution(v bool)`

SetForceExecution sets ForceExecution field to given value.

### HasForceExecution

`func (o *TaskRun) HasForceExecution() bool`

HasForceExecution returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


