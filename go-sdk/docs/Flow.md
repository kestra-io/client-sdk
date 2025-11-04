# Flow

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
**TaskDefaults** | Pointer to [**[]PluginDefault**](PluginDefault.md) |  | [optional] 
**Tasks** | [**[]Task**](Task.md) |  | 
**Errors** | Pointer to [**[]Task**](Task.md) |  | [optional] 
**Listeners** | Pointer to [**[]Listener**](Listener.md) |  | [optional] 
**AfterExecution** | Pointer to [**[]Task**](Task.md) |  | [optional] 
**Triggers** | Pointer to [**[]AbstractTrigger**](AbstractTrigger.md) |  | [optional] 
**PluginDefaults** | Pointer to [**[]PluginDefault**](PluginDefault.md) |  | [optional] 
**Concurrency** | Pointer to [**Concurrency**](Concurrency.md) |  | [optional] 
**Retry** | Pointer to **map[string]interface{}** |  | [optional] 
**Sla** | Pointer to [**[]SLA**](SLA.md) |  | [optional] 

## Methods

### NewFlow

`func NewFlow(id string, namespace string, disabled bool, deleted bool, tasks []Task, ) *Flow`

NewFlow instantiates a new Flow object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowWithDefaults

`func NewFlowWithDefaults() *Flow`

NewFlowWithDefaults instantiates a new Flow object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *Flow) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Flow) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Flow) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *Flow) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *Flow) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *Flow) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetRevision

`func (o *Flow) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *Flow) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *Flow) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *Flow) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### GetDescription

`func (o *Flow) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Flow) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Flow) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Flow) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetInputs

`func (o *Flow) GetInputs() []InputObject`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *Flow) GetInputsOk() (*[]InputObject, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *Flow) SetInputs(v []InputObject)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *Flow) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *Flow) GetOutputs() []Output`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *Flow) GetOutputsOk() (*[]Output, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *Flow) SetOutputs(v []Output)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *Flow) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetDisabled

`func (o *Flow) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *Flow) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *Flow) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.


### GetLabels

`func (o *Flow) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *Flow) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *Flow) SetLabels(v []Label)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *Flow) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetVariables

`func (o *Flow) GetVariables() map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *Flow) GetVariablesOk() (*map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *Flow) SetVariables(v map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *Flow) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *Flow) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *Flow) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *Flow) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *Flow) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetDeleted

`func (o *Flow) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *Flow) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *Flow) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetFinally

`func (o *Flow) GetFinally() []Task`

GetFinally returns the Finally field if non-nil, zero value otherwise.

### GetFinallyOk

`func (o *Flow) GetFinallyOk() (*[]Task, bool)`

GetFinallyOk returns a tuple with the Finally field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFinally

`func (o *Flow) SetFinally(v []Task)`

SetFinally sets Finally field to given value.

### HasFinally

`func (o *Flow) HasFinally() bool`

HasFinally returns a boolean if a field has been set.

### GetTaskDefaults

`func (o *Flow) GetTaskDefaults() []PluginDefault`

GetTaskDefaults returns the TaskDefaults field if non-nil, zero value otherwise.

### GetTaskDefaultsOk

`func (o *Flow) GetTaskDefaultsOk() (*[]PluginDefault, bool)`

GetTaskDefaultsOk returns a tuple with the TaskDefaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskDefaults

`func (o *Flow) SetTaskDefaults(v []PluginDefault)`

SetTaskDefaults sets TaskDefaults field to given value.

### HasTaskDefaults

`func (o *Flow) HasTaskDefaults() bool`

HasTaskDefaults returns a boolean if a field has been set.

### GetTasks

`func (o *Flow) GetTasks() []Task`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *Flow) GetTasksOk() (*[]Task, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *Flow) SetTasks(v []Task)`

SetTasks sets Tasks field to given value.


### GetErrors

`func (o *Flow) GetErrors() []Task`

GetErrors returns the Errors field if non-nil, zero value otherwise.

### GetErrorsOk

`func (o *Flow) GetErrorsOk() (*[]Task, bool)`

GetErrorsOk returns a tuple with the Errors field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrors

`func (o *Flow) SetErrors(v []Task)`

SetErrors sets Errors field to given value.

### HasErrors

`func (o *Flow) HasErrors() bool`

HasErrors returns a boolean if a field has been set.

### GetListeners

`func (o *Flow) GetListeners() []Listener`

GetListeners returns the Listeners field if non-nil, zero value otherwise.

### GetListenersOk

`func (o *Flow) GetListenersOk() (*[]Listener, bool)`

GetListenersOk returns a tuple with the Listeners field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetListeners

`func (o *Flow) SetListeners(v []Listener)`

SetListeners sets Listeners field to given value.

### HasListeners

`func (o *Flow) HasListeners() bool`

HasListeners returns a boolean if a field has been set.

### GetAfterExecution

`func (o *Flow) GetAfterExecution() []Task`

GetAfterExecution returns the AfterExecution field if non-nil, zero value otherwise.

### GetAfterExecutionOk

`func (o *Flow) GetAfterExecutionOk() (*[]Task, bool)`

GetAfterExecutionOk returns a tuple with the AfterExecution field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAfterExecution

`func (o *Flow) SetAfterExecution(v []Task)`

SetAfterExecution sets AfterExecution field to given value.

### HasAfterExecution

`func (o *Flow) HasAfterExecution() bool`

HasAfterExecution returns a boolean if a field has been set.

### GetTriggers

`func (o *Flow) GetTriggers() []AbstractTrigger`

GetTriggers returns the Triggers field if non-nil, zero value otherwise.

### GetTriggersOk

`func (o *Flow) GetTriggersOk() (*[]AbstractTrigger, bool)`

GetTriggersOk returns a tuple with the Triggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggers

`func (o *Flow) SetTriggers(v []AbstractTrigger)`

SetTriggers sets Triggers field to given value.

### HasTriggers

`func (o *Flow) HasTriggers() bool`

HasTriggers returns a boolean if a field has been set.

### GetPluginDefaults

`func (o *Flow) GetPluginDefaults() []PluginDefault`

GetPluginDefaults returns the PluginDefaults field if non-nil, zero value otherwise.

### GetPluginDefaultsOk

`func (o *Flow) GetPluginDefaultsOk() (*[]PluginDefault, bool)`

GetPluginDefaultsOk returns a tuple with the PluginDefaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginDefaults

`func (o *Flow) SetPluginDefaults(v []PluginDefault)`

SetPluginDefaults sets PluginDefaults field to given value.

### HasPluginDefaults

`func (o *Flow) HasPluginDefaults() bool`

HasPluginDefaults returns a boolean if a field has been set.

### GetConcurrency

`func (o *Flow) GetConcurrency() Concurrency`

GetConcurrency returns the Concurrency field if non-nil, zero value otherwise.

### GetConcurrencyOk

`func (o *Flow) GetConcurrencyOk() (*Concurrency, bool)`

GetConcurrencyOk returns a tuple with the Concurrency field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConcurrency

`func (o *Flow) SetConcurrency(v Concurrency)`

SetConcurrency sets Concurrency field to given value.

### HasConcurrency

`func (o *Flow) HasConcurrency() bool`

HasConcurrency returns a boolean if a field has been set.

### GetRetry

`func (o *Flow) GetRetry() map[string]interface{}`

GetRetry returns the Retry field if non-nil, zero value otherwise.

### GetRetryOk

`func (o *Flow) GetRetryOk() (*map[string]interface{}, bool)`

GetRetryOk returns a tuple with the Retry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRetry

`func (o *Flow) SetRetry(v map[string]interface{})`

SetRetry sets Retry field to given value.

### HasRetry

`func (o *Flow) HasRetry() bool`

HasRetry returns a boolean if a field has been set.

### GetSla

`func (o *Flow) GetSla() []SLA`

GetSla returns the Sla field if non-nil, zero value otherwise.

### GetSlaOk

`func (o *Flow) GetSlaOk() (*[]SLA, bool)`

GetSlaOk returns a tuple with the Sla field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSla

`func (o *Flow) SetSla(v []SLA)`

SetSla sets Sla field to given value.

### HasSla

`func (o *Flow) HasSla() bool`

HasSla returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


