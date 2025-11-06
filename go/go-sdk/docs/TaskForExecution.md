# TaskForExecution

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Type** | **string** |  | 
**Version** | Pointer to **string** |  | [optional] 
**Tasks** | Pointer to [**[]TaskForExecution**](TaskForExecution.md) |  | [optional] 
**Inputs** | Pointer to [**[]InputObject**](InputObject.md) |  | [optional] 
**SubflowId** | Pointer to [**ExecutableTaskSubflowId**](ExecutableTaskSubflowId.md) |  | [optional] 

## Methods

### NewTaskForExecution

`func NewTaskForExecution(id string, type_ string, ) *TaskForExecution`

NewTaskForExecution instantiates a new TaskForExecution object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTaskForExecutionWithDefaults

`func NewTaskForExecutionWithDefaults() *TaskForExecution`

NewTaskForExecutionWithDefaults instantiates a new TaskForExecution object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *TaskForExecution) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *TaskForExecution) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *TaskForExecution) SetId(v string)`

SetId sets Id field to given value.


### GetType

`func (o *TaskForExecution) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *TaskForExecution) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *TaskForExecution) SetType(v string)`

SetType sets Type field to given value.


### GetVersion

`func (o *TaskForExecution) GetVersion() string`

GetVersion returns the Version field if non-nil, zero value otherwise.

### GetVersionOk

`func (o *TaskForExecution) GetVersionOk() (*string, bool)`

GetVersionOk returns a tuple with the Version field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVersion

`func (o *TaskForExecution) SetVersion(v string)`

SetVersion sets Version field to given value.

### HasVersion

`func (o *TaskForExecution) HasVersion() bool`

HasVersion returns a boolean if a field has been set.

### GetTasks

`func (o *TaskForExecution) GetTasks() []TaskForExecution`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *TaskForExecution) GetTasksOk() (*[]TaskForExecution, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *TaskForExecution) SetTasks(v []TaskForExecution)`

SetTasks sets Tasks field to given value.

### HasTasks

`func (o *TaskForExecution) HasTasks() bool`

HasTasks returns a boolean if a field has been set.

### GetInputs

`func (o *TaskForExecution) GetInputs() []InputObject`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *TaskForExecution) GetInputsOk() (*[]InputObject, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *TaskForExecution) SetInputs(v []InputObject)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *TaskForExecution) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetSubflowId

`func (o *TaskForExecution) GetSubflowId() ExecutableTaskSubflowId`

GetSubflowId returns the SubflowId field if non-nil, zero value otherwise.

### GetSubflowIdOk

`func (o *TaskForExecution) GetSubflowIdOk() (*ExecutableTaskSubflowId, bool)`

GetSubflowIdOk returns a tuple with the SubflowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSubflowId

`func (o *TaskForExecution) SetSubflowId(v ExecutableTaskSubflowId)`

SetSubflowId sets SubflowId field to given value.

### HasSubflowId

`func (o *TaskForExecution) HasSubflowId() bool`

HasSubflowId returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


