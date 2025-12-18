# InstanceControllerApiWorkerGroupItem

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** | The ID of worker group. | [optional] 
**Key** | Pointer to **string** | The key of the worker group. | [optional] 
**Description** | Pointer to **string** | The description of the worker group. | [optional] 
**ActiveWorkers** | Pointer to **int32** | The number of active workers for the group. | [optional] 

## Methods

### NewInstanceControllerApiWorkerGroupItem

`func NewInstanceControllerApiWorkerGroupItem() *InstanceControllerApiWorkerGroupItem`

NewInstanceControllerApiWorkerGroupItem instantiates a new InstanceControllerApiWorkerGroupItem object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInstanceControllerApiWorkerGroupItemWithDefaults

`func NewInstanceControllerApiWorkerGroupItemWithDefaults() *InstanceControllerApiWorkerGroupItem`

NewInstanceControllerApiWorkerGroupItemWithDefaults instantiates a new InstanceControllerApiWorkerGroupItem object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *InstanceControllerApiWorkerGroupItem) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *InstanceControllerApiWorkerGroupItem) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *InstanceControllerApiWorkerGroupItem) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *InstanceControllerApiWorkerGroupItem) HasId() bool`

HasId returns a boolean if a field has been set.

### GetKey

`func (o *InstanceControllerApiWorkerGroupItem) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *InstanceControllerApiWorkerGroupItem) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *InstanceControllerApiWorkerGroupItem) SetKey(v string)`

SetKey sets Key field to given value.

### HasKey

`func (o *InstanceControllerApiWorkerGroupItem) HasKey() bool`

HasKey returns a boolean if a field has been set.

### GetDescription

`func (o *InstanceControllerApiWorkerGroupItem) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *InstanceControllerApiWorkerGroupItem) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *InstanceControllerApiWorkerGroupItem) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *InstanceControllerApiWorkerGroupItem) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetActiveWorkers

`func (o *InstanceControllerApiWorkerGroupItem) GetActiveWorkers() int32`

GetActiveWorkers returns the ActiveWorkers field if non-nil, zero value otherwise.

### GetActiveWorkersOk

`func (o *InstanceControllerApiWorkerGroupItem) GetActiveWorkersOk() (*int32, bool)`

GetActiveWorkersOk returns a tuple with the ActiveWorkers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetActiveWorkers

`func (o *InstanceControllerApiWorkerGroupItem) SetActiveWorkers(v int32)`

SetActiveWorkers sets ActiveWorkers field to given value.

### HasActiveWorkers

`func (o *InstanceControllerApiWorkerGroupItem) HasActiveWorkers() bool`

HasActiveWorkers returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


