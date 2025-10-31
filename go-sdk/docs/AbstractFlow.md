# AbstractFlow

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**Namespace** | **string** |  | 
**Revision** | Pointer to **int32** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Inputs** | Pointer to [**[]InputObject**](InputObject.md) |  | [optional] 
**Outputs** | Pointer to [**[]Output**](Output.md) |  | [optional] 
**Disabled** | **bool** |  | 
**Labels** | Pointer to [**[]Label**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. | [optional] 
**Variables** | Pointer to **map[string]interface{}** |  | [optional] 
**WorkerGroup** | Pointer to [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**Deleted** | **bool** |  | 

## Methods

### NewAbstractFlow

`func NewAbstractFlow(id string, namespace string, disabled bool, deleted bool, ) *AbstractFlow`

NewAbstractFlow instantiates a new AbstractFlow object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAbstractFlowWithDefaults

`func NewAbstractFlowWithDefaults() *AbstractFlow`

NewAbstractFlowWithDefaults instantiates a new AbstractFlow object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *AbstractFlow) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *AbstractFlow) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *AbstractFlow) SetId(v string)`

SetId sets Id field to given value.


### GetNamespace

`func (o *AbstractFlow) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *AbstractFlow) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *AbstractFlow) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetRevision

`func (o *AbstractFlow) GetRevision() int32`

GetRevision returns the Revision field if non-nil, zero value otherwise.

### GetRevisionOk

`func (o *AbstractFlow) GetRevisionOk() (*int32, bool)`

GetRevisionOk returns a tuple with the Revision field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRevision

`func (o *AbstractFlow) SetRevision(v int32)`

SetRevision sets Revision field to given value.

### HasRevision

`func (o *AbstractFlow) HasRevision() bool`

HasRevision returns a boolean if a field has been set.

### GetDescription

`func (o *AbstractFlow) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *AbstractFlow) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *AbstractFlow) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *AbstractFlow) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetInputs

`func (o *AbstractFlow) GetInputs() []InputObject`

GetInputs returns the Inputs field if non-nil, zero value otherwise.

### GetInputsOk

`func (o *AbstractFlow) GetInputsOk() (*[]InputObject, bool)`

GetInputsOk returns a tuple with the Inputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInputs

`func (o *AbstractFlow) SetInputs(v []InputObject)`

SetInputs sets Inputs field to given value.

### HasInputs

`func (o *AbstractFlow) HasInputs() bool`

HasInputs returns a boolean if a field has been set.

### GetOutputs

`func (o *AbstractFlow) GetOutputs() []Output`

GetOutputs returns the Outputs field if non-nil, zero value otherwise.

### GetOutputsOk

`func (o *AbstractFlow) GetOutputsOk() (*[]Output, bool)`

GetOutputsOk returns a tuple with the Outputs field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOutputs

`func (o *AbstractFlow) SetOutputs(v []Output)`

SetOutputs sets Outputs field to given value.

### HasOutputs

`func (o *AbstractFlow) HasOutputs() bool`

HasOutputs returns a boolean if a field has been set.

### GetDisabled

`func (o *AbstractFlow) GetDisabled() bool`

GetDisabled returns the Disabled field if non-nil, zero value otherwise.

### GetDisabledOk

`func (o *AbstractFlow) GetDisabledOk() (*bool, bool)`

GetDisabledOk returns a tuple with the Disabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisabled

`func (o *AbstractFlow) SetDisabled(v bool)`

SetDisabled sets Disabled field to given value.


### GetLabels

`func (o *AbstractFlow) GetLabels() []Label`

GetLabels returns the Labels field if non-nil, zero value otherwise.

### GetLabelsOk

`func (o *AbstractFlow) GetLabelsOk() (*[]Label, bool)`

GetLabelsOk returns a tuple with the Labels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLabels

`func (o *AbstractFlow) SetLabels(v []Label)`

SetLabels sets Labels field to given value.

### HasLabels

`func (o *AbstractFlow) HasLabels() bool`

HasLabels returns a boolean if a field has been set.

### GetVariables

`func (o *AbstractFlow) GetVariables() map[string]interface{}`

GetVariables returns the Variables field if non-nil, zero value otherwise.

### GetVariablesOk

`func (o *AbstractFlow) GetVariablesOk() (*map[string]interface{}, bool)`

GetVariablesOk returns a tuple with the Variables field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetVariables

`func (o *AbstractFlow) SetVariables(v map[string]interface{})`

SetVariables sets Variables field to given value.

### HasVariables

`func (o *AbstractFlow) HasVariables() bool`

HasVariables returns a boolean if a field has been set.

### GetWorkerGroup

`func (o *AbstractFlow) GetWorkerGroup() WorkerGroup`

GetWorkerGroup returns the WorkerGroup field if non-nil, zero value otherwise.

### GetWorkerGroupOk

`func (o *AbstractFlow) GetWorkerGroupOk() (*WorkerGroup, bool)`

GetWorkerGroupOk returns a tuple with the WorkerGroup field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerGroup

`func (o *AbstractFlow) SetWorkerGroup(v WorkerGroup)`

SetWorkerGroup sets WorkerGroup field to given value.

### HasWorkerGroup

`func (o *AbstractFlow) HasWorkerGroup() bool`

HasWorkerGroup returns a boolean if a field has been set.

### GetDeleted

`func (o *AbstractFlow) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *AbstractFlow) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *AbstractFlow) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


