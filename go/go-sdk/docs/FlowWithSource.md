# FlowWithSource

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Namespace** | **string** |  | 
**Revision** | Pointer to **int32** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Inputs** | Pointer to [**[]InputObject**](InputObject.md) |  | [optional] 
**Outputs** | Pointer to [**[]Output**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. | [optional] 
**Disabled** | **bool** |  | 
**Labels** | Pointer to [**[]Label**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. | [optional] 
**Variables** | Pointer to **map[string]interface{}** |  | [optional] 
**WorkerGroup** | Pointer to [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**Deleted** | **bool** |  | 
**Finally** | Pointer to [**[]Task**](Task.md) |  | [optional] 
**Tasks** | [**[]Task**](Task.md) |  | 
**Errors** | Pointer to [**[]Task**](Task.md) |  | [optional] 
**AfterExecution** | Pointer to [**[]Task**](Task.md) |  | [optional] 
**Triggers** | Pointer to [**[]AbstractTrigger**](AbstractTrigger.md) |  | [optional] 
**PluginDefaults** | Pointer to [**[]PluginDefault**](PluginDefault.md) |  | [optional] 
**Concurrency** | Pointer to [**Concurrency**](Concurrency.md) |  | [optional] 
**Retry** | Pointer to **map[string]interface{}** |  | [optional] 
**Sla** | Pointer to [**[]SLA**](SLA.md) |  | [optional] 
**Source** | Pointer to **string** |  | [optional] 

## Methods

### NewFlowWithSource

`func NewFlowWithSource(id string, namespace string, disabled bool, deleted bool, tasks []Task, ) *FlowWithSource`

NewFlowWithSource instantiates a new FlowWithSource object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowWithSourceWithDefaults

`func NewFlowWithSourceWithDefaults() *FlowWithSource`

NewFlowWithSourceWithDefaults instantiates a new FlowWithSource object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *FlowWithSource) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *FlowWithSource) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *FlowWithSource) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *FlowWithSource) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *FlowWithSource) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *FlowWithSource) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetRevision

`func (o *FlowWithSource) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *FlowWithSource) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *FlowWithSource) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *FlowWithSource) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### GetDescription

`func (o *FlowWithSource) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *FlowWithSource) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *FlowWithSource) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *FlowWithSource) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetInputs

`func (o *FlowWithSource) GetInputs() []InputObject`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *FlowWithSource) GetInputsOk() (*[]InputObject, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *FlowWithSource) SetInputs(v []InputObject)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *FlowWithSource) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *FlowWithSource) GetOutputs() []Output`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *FlowWithSource) GetOutputsOk() (*[]Output, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *FlowWithSource) SetOutputs(v []Output)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *FlowWithSource) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetDisabled

`func (o *FlowWithSource) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *FlowWithSource) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *FlowWithSource) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.


### GetLabels

`func (o *FlowWithSource) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *FlowWithSource) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *FlowWithSource) SetLabels(v []Label)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *FlowWithSource) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetVariables

`func (o *FlowWithSource) GetVariables() map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *FlowWithSource) GetVariablesOk() (*map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *FlowWithSource) SetVariables(v map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *FlowWithSource) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *FlowWithSource) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *FlowWithSource) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *FlowWithSource) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *FlowWithSource) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetDeleted

`func (o *FlowWithSource) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *FlowWithSource) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *FlowWithSource) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetFinally

`func (o *FlowWithSource) GetFinally() []Task`

GetFinally returns the Finally field if non-nil, zero value otherwise.

### GetFinallyOk

`func (o *FlowWithSource) GetFinallyOk() (*[]Task, bool)`

GetFinallyOk returns a tuple with the Finally field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFinally

`func (o *FlowWithSource) SetFinally(v []Task)`

SetFinally sets Finally field to given value.

### HasFinally

`func (o *FlowWithSource) HasFinally() bool`

HasFinally returns a boolean if a field has been set.

### GetTasks

`func (o *FlowWithSource) GetTasks() []Task`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *FlowWithSource) GetTasksOk() (*[]Task, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *FlowWithSource) SetTasks(v []Task)`

SetTasks sets Tasks field to given value.


### GetErrors

`func (o *FlowWithSource) GetErrors() []Task`

GetErrors returns the Errors field if non-nil, zero value otherwise.

### GetErrorsOk

`func (o *FlowWithSource) GetErrorsOk() (*[]Task, bool)`

GetErrorsOk returns a tuple with the Errors field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrors

`func (o *FlowWithSource) SetErrors(v []Task)`

SetErrors sets Errors field to given value.

### HasErrors

`func (o *FlowWithSource) HasErrors() bool`

HasErrors returns a boolean if a field has been set.

### GetAfterExecution

`func (o *FlowWithSource) GetAfterExecution() []Task`

GetAfterExecution returns the AfterExecution field if non-nil, zero value otherwise.

### GetAfterExecutionOk

`func (o *FlowWithSource) GetAfterExecutionOk() (*[]Task, bool)`

GetAfterExecutionOk returns a tuple with the AfterExecution field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAfterExecution

`func (o *FlowWithSource) SetAfterExecution(v []Task)`

SetAfterExecution sets AfterExecution field to given value.

### HasAfterExecution

`func (o *FlowWithSource) HasAfterExecution() bool`

HasAfterExecution returns a boolean if a field has been set.

### GetTriggers

`func (o *FlowWithSource) GetTriggers() []AbstractTrigger`

GetTriggers returns the Triggers field if non-nil, zero value otherwise.

### GetTriggersOk

`func (o *FlowWithSource) GetTriggersOk() (*[]AbstractTrigger, bool)`

GetTriggersOk returns a tuple with the Triggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggers

`func (o *FlowWithSource) SetTriggers(v []AbstractTrigger)`

SetTriggers sets Triggers field to given value.

### HasTriggers

`func (o *FlowWithSource) HasTriggers() bool`

HasTriggers returns a boolean if a field has been set.

### GetPluginDefaults

`func (o *FlowWithSource) GetPluginDefaults() []PluginDefault`

GetPluginDefaults returns the PluginDefaults field if non-nil, zero value otherwise.

### GetPluginDefaultsOk

`func (o *FlowWithSource) GetPluginDefaultsOk() (*[]PluginDefault, bool)`

GetPluginDefaultsOk returns a tuple with the PluginDefaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginDefaults

`func (o *FlowWithSource) SetPluginDefaults(v []PluginDefault)`

SetPluginDefaults sets PluginDefaults field to given value.

### HasPluginDefaults

`func (o *FlowWithSource) HasPluginDefaults() bool`

HasPluginDefaults returns a boolean if a field has been set.

### GetConcurrency

`func (o *FlowWithSource) GetConcurrency() Concurrency`

GetConcurrency returns the Concurrency field if non-nil, zero value otherwise.

### GetConcurrencyOk

`func (o *FlowWithSource) GetConcurrencyOk() (*Concurrency, bool)`

GetConcurrencyOk returns a tuple with the Concurrency field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConcurrency

`func (o *FlowWithSource) SetConcurrency(v Concurrency)`

SetConcurrency sets Concurrency field to given value.

### HasConcurrency

`func (o *FlowWithSource) HasConcurrency() bool`

HasConcurrency returns a boolean if a field has been set.

### GetRetry

`func (o *FlowWithSource) GetRetry() map[string]interface{}`

GetRetry returns the Retry field if non-nil, zero value otherwise.

### GetRetryOk

`func (o *FlowWithSource) GetRetryOk() (*map[string]interface{}, bool)`

GetRetryOk returns a tuple with the Retry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRetry

`func (o *FlowWithSource) SetRetry(v map[string]interface{})`

SetRetry sets Retry field to given value.

### HasRetry

`func (o *FlowWithSource) HasRetry() bool`

HasRetry returns a boolean if a field has been set.

### GetSla

`func (o *FlowWithSource) GetSla() []SLA`

GetSla returns the Sla field if non-nil, zero value otherwise.

### GetSlaOk

`func (o *FlowWithSource) GetSlaOk() (*[]SLA, bool)`

GetSlaOk returns a tuple with the Sla field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSla

`func (o *FlowWithSource) SetSla(v []SLA)`

SetSla sets Sla field to given value.

### HasSla

`func (o *FlowWithSource) HasSla() bool`

HasSla returns a boolean if a field has been set.

### GetSource

`func (o *FlowWithSource) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *FlowWithSource) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *FlowWithSource) SetSource(v string)`

SetSource sets Source field to given value.

### HasSource

`func (o *FlowWithSource) HasSource() bool`

HasSource returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


