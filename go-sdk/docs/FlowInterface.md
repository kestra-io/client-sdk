# FlowInterface

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Namespace** | Pointer to **string** |  | [optional] 
**Revision** | Pointer to **int32** |  | [optional] 
**TenantId** | Pointer to **string** |  | [optional] 
**Deleted** | Pointer to **bool** |  | [optional] 
**Disabled** | Pointer to **bool** |  | [optional] 
**Labels** | Pointer to [**[]Label**](Label.md) |  | [optional] 
**Inputs** | Pointer to [**[]InputObject**](InputObject.md) |  | [optional] 
**Outputs** | Pointer to [**[]Output**](Output.md) |  | [optional] 
**Variables** | Pointer to **map[string]map[string]interface{}** |  | [optional] 
**WorkerGroup** | Pointer to [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**Concurrency** | Pointer to [**Concurrency**](Concurrency.md) |  | [optional] 
**Sla** | Pointer to [**[]SLA**](SLA.md) |  | [optional] 
**Source** | Pointer to **string** |  | [optional] 

## Methods

### NewFlowInterface

`func NewFlowInterface() *FlowInterface`

NewFlowInterface instantiates a new FlowInterface object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowInterfaceWithDefaults

`func NewFlowInterfaceWithDefaults() *FlowInterface`

NewFlowInterfaceWithDefaults instantiates a new FlowInterface object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *FlowInterface) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *FlowInterface) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *FlowInterface) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *FlowInterface) HasId() bool`

HasId returns a boolean if a field has been set.

### GetNamespace

`func (o *FlowInterface) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *FlowInterface) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *FlowInterface) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *FlowInterface) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetRevision

`func (o *FlowInterface) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *FlowInterface) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *FlowInterface) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *FlowInterface) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### GetTenantId

`func (o *FlowInterface) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *FlowInterface) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *FlowInterface) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *FlowInterface) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetDeleted

`func (o *FlowInterface) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *FlowInterface) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *FlowInterface) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.

### HasDeleted

`func (o *FlowInterface) HasDeleted() bool`

HasDeleted returns a boolean if a field has been set.

### GetDisabled

`func (o *FlowInterface) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *FlowInterface) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *FlowInterface) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.

### HasDisabled

`func (o *FlowInterface) HasDisabled() bool`

HasDisabled returns a boolean if a field has been set.

### GetLabels

`func (o *FlowInterface) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *FlowInterface) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *FlowInterface) SetLabels(v []Label)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *FlowInterface) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetInputs

`func (o *FlowInterface) GetInputs() []InputObject`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *FlowInterface) GetInputsOk() (*[]InputObject, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *FlowInterface) SetInputs(v []InputObject)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *FlowInterface) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *FlowInterface) GetOutputs() []Output`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *FlowInterface) GetOutputsOk() (*[]Output, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *FlowInterface) SetOutputs(v []Output)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *FlowInterface) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetVariables

`func (o *FlowInterface) GetVariables() map[string]map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *FlowInterface) GetVariablesOk() (*map[string]map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *FlowInterface) SetVariables(v map[string]map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *FlowInterface) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *FlowInterface) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *FlowInterface) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *FlowInterface) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *FlowInterface) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetConcurrency

`func (o *FlowInterface) GetConcurrency() Concurrency`

GetConcurrency returns the Concurrency field if non-nil, zero value otherwise.

### GetConcurrencyOk

`func (o *FlowInterface) GetConcurrencyOk() (*Concurrency, bool)`

GetConcurrencyOk returns a tuple with the Concurrency field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetConcurrency

`func (o *FlowInterface) SetConcurrency(v Concurrency)`

SetConcurrency sets Concurrency field to given value.

### HasConcurrency

`func (o *FlowInterface) HasConcurrency() bool`

HasConcurrency returns a boolean if a field has been set.

### GetSla

`func (o *FlowInterface) GetSla() []SLA`

GetSla returns the Sla field if non-nil, zero value otherwise.

### GetSlaOk

`func (o *FlowInterface) GetSlaOk() (*[]SLA, bool)`

GetSlaOk returns a tuple with the Sla field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSla

`func (o *FlowInterface) SetSla(v []SLA)`

SetSla sets Sla field to given value.

### HasSla

`func (o *FlowInterface) HasSla() bool`

HasSla returns a boolean if a field has been set.

### GetSource

`func (o *FlowInterface) GetSource() string`

GetSource returns the Source field if non-nil, zero value otherwise.

### GetSourceOk

`func (o *FlowInterface) GetSourceOk() (*string, bool)`

GetSourceOk returns a tuple with the Source field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSource

`func (o *FlowInterface) SetSource(v string)`

SetSource sets Source field to given value.

### HasSource

`func (o *FlowInterface) HasSource() bool`

HasSource returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


