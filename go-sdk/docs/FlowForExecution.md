# FlowForExecution

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Namespace** | **string** |  | 
**Revision** | Pointer to **int32** |  | [optional] 
**Inputs** | Pointer to [**[]InputObject**](InputObject.md) |  | [optional] 
**Outputs** | Pointer to [**[]Output**](Output.md) |  | [optional] 
**Disabled** | **bool** |  | 
**Labels** | Pointer to [**FlowForExecutionAllOfLabels**](FlowForExecutionAllOfLabels.md) |  | [optional] 
**Variables** | Pointer to **map[string]interface{}** |  | [optional] 
**WorkerGroup** | Pointer to [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**Deleted** | **bool** |  | 
**Tasks** | [**[]TaskForExecution**](TaskForExecution.md) |  | 
**Errors** | Pointer to [**[]TaskForExecution**](TaskForExecution.md) |  | [optional] 
**Finally** | Pointer to [**[]TaskForExecution**](TaskForExecution.md) |  | [optional] 
**AfterExecution** | Pointer to [**[]TaskForExecution**](TaskForExecution.md) |  | [optional] 
**Triggers** | Pointer to [**[]AbstractTriggerForExecution**](AbstractTriggerForExecution.md) |  | [optional] 

## Methods

### NewFlowForExecution

`func NewFlowForExecution(id string, namespace string, disabled bool, deleted bool, tasks []TaskForExecution, ) *FlowForExecution`

NewFlowForExecution instantiates a new FlowForExecution object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowForExecutionWithDefaults

`func NewFlowForExecutionWithDefaults() *FlowForExecution`

NewFlowForExecutionWithDefaults instantiates a new FlowForExecution object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *FlowForExecution) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *FlowForExecution) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *FlowForExecution) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *FlowForExecution) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *FlowForExecution) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *FlowForExecution) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetRevision

`func (o *FlowForExecution) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *FlowForExecution) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *FlowForExecution) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *FlowForExecution) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### GetInputs

`func (o *FlowForExecution) GetInputs() []InputObject`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *FlowForExecution) GetInputsOk() (*[]InputObject, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *FlowForExecution) SetInputs(v []InputObject)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *FlowForExecution) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *FlowForExecution) GetOutputs() []Output`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *FlowForExecution) GetOutputsOk() (*[]Output, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *FlowForExecution) SetOutputs(v []Output)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *FlowForExecution) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetDisabled

`func (o *FlowForExecution) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *FlowForExecution) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *FlowForExecution) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.


### GetLabels

`func (o *FlowForExecution) GetLabels() FlowForExecutionAllOfLabels`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *FlowForExecution) GetLabelsOk() (*FlowForExecutionAllOfLabels, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *FlowForExecution) SetLabels(v FlowForExecutionAllOfLabels)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *FlowForExecution) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetVariables

`func (o *FlowForExecution) GetVariables() map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *FlowForExecution) GetVariablesOk() (*map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *FlowForExecution) SetVariables(v map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *FlowForExecution) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *FlowForExecution) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *FlowForExecution) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *FlowForExecution) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *FlowForExecution) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetDeleted

`func (o *FlowForExecution) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *FlowForExecution) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *FlowForExecution) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetTasks

`func (o *FlowForExecution) GetTasks() []TaskForExecution`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *FlowForExecution) GetTasksOk() (*[]TaskForExecution, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *FlowForExecution) SetTasks(v []TaskForExecution)`

SetTasks sets Tasks field to given value.


### GetErrors

`func (o *FlowForExecution) GetErrors() []TaskForExecution`

GetErrors returns the Errors field if non-nil, zero value otherwise.

### GetErrorsOk

`func (o *FlowForExecution) GetErrorsOk() (*[]TaskForExecution, bool)`

GetErrorsOk returns a tuple with the Errors field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrors

`func (o *FlowForExecution) SetErrors(v []TaskForExecution)`

SetErrors sets Errors field to given value.

### HasErrors

`func (o *FlowForExecution) HasErrors() bool`

HasErrors returns a boolean if a field has been set.

### GetFinally

`func (o *FlowForExecution) GetFinally() []TaskForExecution`

GetFinally returns the Finally field if non-nil, zero value otherwise.

### GetFinallyOk

`func (o *FlowForExecution) GetFinallyOk() (*[]TaskForExecution, bool)`

GetFinallyOk returns a tuple with the Finally field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFinally

`func (o *FlowForExecution) SetFinally(v []TaskForExecution)`

SetFinally sets Finally field to given value.

### HasFinally

`func (o *FlowForExecution) HasFinally() bool`

HasFinally returns a boolean if a field has been set.

### GetAfterExecution

`func (o *FlowForExecution) GetAfterExecution() []TaskForExecution`

GetAfterExecution returns the AfterExecution field if non-nil, zero value otherwise.

### GetAfterExecutionOk

`func (o *FlowForExecution) GetAfterExecutionOk() (*[]TaskForExecution, bool)`

GetAfterExecutionOk returns a tuple with the AfterExecution field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAfterExecution

`func (o *FlowForExecution) SetAfterExecution(v []TaskForExecution)`

SetAfterExecution sets AfterExecution field to given value.

### HasAfterExecution

`func (o *FlowForExecution) HasAfterExecution() bool`

HasAfterExecution returns a boolean if a field has been set.

### GetTriggers

`func (o *FlowForExecution) GetTriggers() []AbstractTriggerForExecution`

GetTriggers returns the Triggers field if non-nil, zero value otherwise.

### GetTriggersOk

`func (o *FlowForExecution) GetTriggersOk() (*[]AbstractTriggerForExecution, bool)`

GetTriggersOk returns a tuple with the Triggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggers

`func (o *FlowForExecution) SetTriggers(v []AbstractTriggerForExecution)`

SetTriggers sets Triggers field to given value.

### HasTriggers

`func (o *FlowForExecution) HasTriggers() bool`

HasTriggers returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


