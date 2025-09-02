# InstanceControllerApiWorkerGroupItem

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** | The ID of worker group. | 
**Key** | **string** | The key of the worker group. | 
**Description** | **string** | The description of the worker group. | 
**ActiveWorkers** | **int32** | The number of active workers for the group. | 

## Methods

### NewInstanceControllerApiWorkerGroupItem

`func NewInstanceControllerApiWorkerGroupItem(id string, key string, description string, activeWorkers int32, ) *InstanceControllerApiWorkerGroupItem`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


