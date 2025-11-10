# UpdateFlow200Response

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

### NewUpdateFlow200Response

`func NewUpdateFlow200Response(id string, namespace string, disabled bool, deleted bool, tasks []Task, ) *UpdateFlow200Response`

NewUpdateFlow200Response instantiates a new UpdateFlow200Response object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUpdateFlow200ResponseWithDefaults

`func NewUpdateFlow200ResponseWithDefaults() *UpdateFlow200Response`

NewUpdateFlow200ResponseWithDefaults instantiates a new UpdateFlow200Response object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *UpdateFlow200Response) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *UpdateFlow200Response) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *UpdateFlow200Response) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *UpdateFlow200Response) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *UpdateFlow200Response) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *UpdateFlow200Response) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetRevision

`func (o *UpdateFlow200Response) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *UpdateFlow200Response) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *UpdateFlow200Response) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *UpdateFlow200Response) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### GetDescription

`func (o *UpdateFlow200Response) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *UpdateFlow200Response) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *UpdateFlow200Response) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *UpdateFlow200Response) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetInputs

`func (o *UpdateFlow200Response) GetInputs() []InputObject`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *UpdateFlow200Response) GetInputsOk() (*[]InputObject, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *UpdateFlow200Response) SetInputs(v []InputObject)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *UpdateFlow200Response) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *UpdateFlow200Response) GetOutputs() []Output`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *UpdateFlow200Response) GetOutputsOk() (*[]Output, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *UpdateFlow200Response) SetOutputs(v []Output)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *UpdateFlow200Response) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetDisabled

`func (o *UpdateFlow200Response) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *UpdateFlow200Response) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *UpdateFlow200Response) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.


### GetLabels

`func (o *UpdateFlow200Response) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *UpdateFlow200Response) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *UpdateFlow200Response) SetLabels(v []Label)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *UpdateFlow200Response) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetVariables

`func (o *UpdateFlow200Response) GetVariables() map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *UpdateFlow200Response) GetVariablesOk() (*map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *UpdateFlow200Response) SetVariables(v map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *UpdateFlow200Response) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *UpdateFlow200Response) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *UpdateFlow200Response) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *UpdateFlow200Response) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *UpdateFlow200Response) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetDeleted

`func (o *UpdateFlow200Response) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *UpdateFlow200Response) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *UpdateFlow200Response) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetFinally

`func (o *UpdateFlow200Response) GetFinally() []Task`

GetFinally returns the Finally field if non-nil, zero value otherwise.

### GetFinallyOk

`func (o *UpdateFlow200Response) GetFinallyOk() (*[]Task, bool)`

GetFinallyOk returns a tuple with the Finally field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFinally

`func (o *UpdateFlow200Response) SetFinally(v []Task)`

SetFinally sets Finally field to given value.

### HasFinally

`func (o *UpdateFlow200Response) HasFinally() bool`

HasFinally returns a boolean if a field has been set.

### GetTaskDefaults

`func (o *UpdateFlow200Response) GetTaskDefaults() []PluginDefault`

GetTaskDefaults returns the TaskDefaults field if non-nil, zero value otherwise.

### GetTaskDefaultsOk

`func (o *UpdateFlow200Response) GetTaskDefaultsOk() (*[]PluginDefault, bool)`

GetTaskDefaultsOk returns a tuple with the TaskDefaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskDefaults

`func (o *UpdateFlow200Response) SetTaskDefaults(v []PluginDefault)`

SetTaskDefaults sets TaskDefaults field to given value.

### HasTaskDefaults

`func (o *UpdateFlow200Response) HasTaskDefaults() bool`

HasTaskDefaults returns a boolean if a field has been set.

### GetTasks

`func (o *UpdateFlow200Response) GetTasks() []Task`

GetTasks returns the Tasks field if non-nil, zero value otherwise.

### GetTasksOk

`func (o *UpdateFlow200Response) GetTasksOk() (*[]Task, bool)`

GetTasksOk returns a tuple with the Tasks field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTasks

`func (o *UpdateFlow200Response) SetTasks(v []Task)`

SetTasks sets Tasks field to given value.


### GetErrors

`func (o *UpdateFlow200Response) GetErrors() []Task`

GetErrors returns the Errors field if non-nil, zero value otherwise.

### GetErrorsOk

`func (o *UpdateFlow200Response) GetErrorsOk() (*[]Task, bool)`

GetErrorsOk returns a tuple with the Errors field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrors

`func (o *UpdateFlow200Response) SetErrors(v []Task)`

SetErrors sets Errors field to given value.

### HasErrors

`func (o *UpdateFlow200Response) HasErrors() bool`

HasErrors returns a boolean if a field has been set.

### GetListeners

`func (o *UpdateFlow200Response) GetListeners() []Listener`

GetListeners returns the Listeners field if non-nil, zero value otherwise.

### GetListenersOk

`func (o *UpdateFlow200Response) GetListenersOk() (*[]Listener, bool)`

GetListenersOk returns a tuple with the Listeners field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetListeners

`func (o *UpdateFlow200Response) SetListeners(v []Listener)`

SetListeners sets Listeners field to given value.

### HasListeners

`func (o *UpdateFlow200Response) HasListeners() bool`

HasListeners returns a boolean if a field has been set.

### GetAfterExecution

`func (o *UpdateFlow200Response) GetAfterExecution() []Task`

GetAfterExecution returns the AfterExecution field if non-nil, zero value otherwise.

### GetAfterExecutionOk

`func (o *UpdateFlow200Response) GetAfterExecutionOk() (*[]Task, bool)`

GetAfterExecutionOk returns a tuple with the AfterExecution field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAfterExecution

`func (o *UpdateFlow200Response) SetAfterExecution(v []Task)`

SetAfterExecution sets AfterExecution field to given value.

### HasAfterExecution

`func (o *UpdateFlow200Response) HasAfterExecution() bool`

HasAfterExecution returns a boolean if a field has been set.

### GetTriggers

`func (o *UpdateFlow200Response) GetTriggers() []AbstractTrigger`

GetTriggers returns the Triggers field if non-nil, zero value otherwise.

### GetTriggersOk

`func (o *UpdateFlow200Response) GetTriggersOk() (*[]AbstractTrigger, bool)`

GetTriggersOk returns a tuple with the Triggers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggers

`func (o *UpdateFlow200Response) SetTriggers(v []AbstractTrigger)`

SetTriggers sets Triggers field to given value.

### HasTriggers

`func (o *UpdateFlow200Response) HasTriggers() bool`

HasTriggers returns a boolean if a field has been set.

### GetPluginDefaults

`func (o *UpdateFlow200Response) GetPluginDefaults() []PluginDefault`

GetPluginDefaults returns the PluginDefaults field if non-nil, zero value otherwise.

### GetPluginDefaultsOk

`func (o *UpdateFlow200Response) GetPluginDefaultsOk() (*[]PluginDefault, bool)`

GetPluginDefaultsOk returns a tuple with the PluginDefaults field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPluginDefaults

`func (o *UpdateFlow200Response) SetPluginDefaults(v []PluginDefault)`

SetPluginDefaults sets PluginDefaults field to given value.

### HasPluginDefaults

`func (o *UpdateFlow200Response) HasPluginDefaults() bool`

HasPluginDefaults returns a boolean if a field has been set.

### GetConcurrency

`func (o *UpdateFlow200Response) GetConcurrency() Concurrency`

GetConcurrency returns the Concurrency field if non-nil, zero value otherwise.

### GetConcurrencyOk

`func (o *UpdateFlow200Response) GetConcurrencyOk() (*Concurrency, bool)`

GetConcurrencyOk returns a tuple with the Concurrency field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConcurrency

`func (o *UpdateFlow200Response) SetConcurrency(v Concurrency)`

SetConcurrency sets Concurrency field to given value.

### HasConcurrency

`func (o *UpdateFlow200Response) HasConcurrency() bool`

HasConcurrency returns a boolean if a field has been set.

### GetRetry

`func (o *UpdateFlow200Response) GetRetry() map[string]interface{}`

GetRetry returns the Retry field if non-nil, zero value otherwise.

### GetRetryOk

`func (o *UpdateFlow200Response) GetRetryOk() (*map[string]interface{}, bool)`

GetRetryOk returns a tuple with the Retry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRetry

`func (o *UpdateFlow200Response) SetRetry(v map[string]interface{})`

SetRetry sets Retry field to given value.

### HasRetry

`func (o *UpdateFlow200Response) HasRetry() bool`

HasRetry returns a boolean if a field has been set.

### GetSla

`func (o *UpdateFlow200Response) GetSla() []SLA`

GetSla returns the Sla field if non-nil, zero value otherwise.

### GetSlaOk

`func (o *UpdateFlow200Response) GetSlaOk() (*[]SLA, bool)`

GetSlaOk returns a tuple with the Sla field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSla

`func (o *UpdateFlow200Response) SetSla(v []SLA)`

SetSla sets Sla field to given value.

### HasSla

`func (o *UpdateFlow200Response) HasSla() bool`

HasSla returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


