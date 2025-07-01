# ClusterControllerApiWorkerGroupDetails

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** | The ID of worker group. | 
**Key** | **string** | The key of the worker group. | 
**Description** | **string** | The description of the worker group. | 
**AllowedTenants** | **[]string** |  | 
**Workers** | [**[]ServiceInstance**](ServiceInstance.md) | The list of workers for the group. | 

## Methods

### NewClusterControllerApiWorkerGroupDetails

`func NewClusterControllerApiWorkerGroupDetails(id string, key string, description string, allowedTenants []string, workers []ServiceInstance, ) *ClusterControllerApiWorkerGroupDetails`

NewClusterControllerApiWorkerGroupDetails instantiates a new ClusterControllerApiWorkerGroupDetails object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewClusterControllerApiWorkerGroupDetailsWithDefaults

`func NewClusterControllerApiWorkerGroupDetailsWithDefaults() *ClusterControllerApiWorkerGroupDetails`

NewClusterControllerApiWorkerGroupDetailsWithDefaults instantiates a new ClusterControllerApiWorkerGroupDetails object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ClusterControllerApiWorkerGroupDetails) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ClusterControllerApiWorkerGroupDetails) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ClusterControllerApiWorkerGroupDetails) SetId(v string)`

SetId sets Id field to given value.


### GetKey

`func (o *ClusterControllerApiWorkerGroupDetails) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *ClusterControllerApiWorkerGroupDetails) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *ClusterControllerApiWorkerGroupDetails) SetKey(v string)`

SetKey sets Key field to given value.


### GetDescription

`func (o *ClusterControllerApiWorkerGroupDetails) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ClusterControllerApiWorkerGroupDetails) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ClusterControllerApiWorkerGroupDetails) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetAllowedTenants

`func (o *ClusterControllerApiWorkerGroupDetails) GetAllowedTenants() []string`

GetAllowedTenants returns the AllowedTenants field if non-nil, zero value otherwise.

### GetAllowedTenantsOk

`func (o *ClusterControllerApiWorkerGroupDetails) GetAllowedTenantsOk() (*[]string, bool)`

GetAllowedTenantsOk returns a tuple with the AllowedTenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTenants

`func (o *ClusterControllerApiWorkerGroupDetails) SetAllowedTenants(v []string)`

SetAllowedTenants sets AllowedTenants field to given value.


### GetWorkers

`func (o *ClusterControllerApiWorkerGroupDetails) GetWorkers() []ServiceInstance`

GetWorkers returns the Workers field if non-nil, zero value otherwise.

### GetWorkersOk

`func (o *ClusterControllerApiWorkerGroupDetails) GetWorkersOk() (*[]ServiceInstance, bool)`

GetWorkersOk returns a tuple with the Workers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkers

`func (o *ClusterControllerApiWorkerGroupDetails) SetWorkers(v []ServiceInstance)`

SetWorkers sets Workers field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


