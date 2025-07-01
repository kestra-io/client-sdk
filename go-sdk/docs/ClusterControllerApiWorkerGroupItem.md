# ClusterControllerApiWorkerGroupItem

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** | The ID of worker group. | 
**Key** | **string** | The key of the worker group. | 
**Description** | **string** | The description of the worker group. | 
**ActiveWorkers** | **int32** | The number of active workers for the group. | 

## Methods

### NewClusterControllerApiWorkerGroupItem

`func NewClusterControllerApiWorkerGroupItem(id string, key string, description string, activeWorkers int32, ) *ClusterControllerApiWorkerGroupItem`

NewClusterControllerApiWorkerGroupItem instantiates a new ClusterControllerApiWorkerGroupItem object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewClusterControllerApiWorkerGroupItemWithDefaults

`func NewClusterControllerApiWorkerGroupItemWithDefaults() *ClusterControllerApiWorkerGroupItem`

NewClusterControllerApiWorkerGroupItemWithDefaults instantiates a new ClusterControllerApiWorkerGroupItem object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ClusterControllerApiWorkerGroupItem) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ClusterControllerApiWorkerGroupItem) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ClusterControllerApiWorkerGroupItem) SetId(v string)`

SetId sets Id field to given value.


### GetKey

`func (o *ClusterControllerApiWorkerGroupItem) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *ClusterControllerApiWorkerGroupItem) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *ClusterControllerApiWorkerGroupItem) SetKey(v string)`

SetKey sets Key field to given value.


### GetDescription

`func (o *ClusterControllerApiWorkerGroupItem) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ClusterControllerApiWorkerGroupItem) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ClusterControllerApiWorkerGroupItem) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetActiveWorkers

`func (o *ClusterControllerApiWorkerGroupItem) GetActiveWorkers() int32`

GetActiveWorkers returns the ActiveWorkers field if non-nil, zero value otherwise.

### GetActiveWorkersOk

`func (o *ClusterControllerApiWorkerGroupItem) GetActiveWorkersOk() (*int32, bool)`

GetActiveWorkersOk returns a tuple with the ActiveWorkers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetActiveWorkers

`func (o *ClusterControllerApiWorkerGroupItem) SetActiveWorkers(v int32)`

SetActiveWorkers sets ActiveWorkers field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


