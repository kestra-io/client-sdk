# InstanceControllerApiWorkerGroupDetails

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** | The ID of worker group. | [optional] 
**Key** | Pointer to **string** | The key of the worker group. | [optional] 
**Description** | Pointer to **string** | The description of the worker group. | [optional] 
**AllowedTenants** | Pointer to **[]string** |  | [optional] 
**Workers** | Pointer to [**[]ServiceInstance**](ServiceInstance.md) | The list of workers for the group. | [optional] 

## Methods

### NewInstanceControllerApiWorkerGroupDetails

`func NewInstanceControllerApiWorkerGroupDetails() *InstanceControllerApiWorkerGroupDetails`

NewInstanceControllerApiWorkerGroupDetails instantiates a new InstanceControllerApiWorkerGroupDetails object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInstanceControllerApiWorkerGroupDetailsWithDefaults

`func NewInstanceControllerApiWorkerGroupDetailsWithDefaults() *InstanceControllerApiWorkerGroupDetails`

NewInstanceControllerApiWorkerGroupDetailsWithDefaults instantiates a new InstanceControllerApiWorkerGroupDetails object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *InstanceControllerApiWorkerGroupDetails) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *InstanceControllerApiWorkerGroupDetails) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *InstanceControllerApiWorkerGroupDetails) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *InstanceControllerApiWorkerGroupDetails) HasId() bool`

HasId returns a boolean if a field has been set.

### GetKey

`func (o *InstanceControllerApiWorkerGroupDetails) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *InstanceControllerApiWorkerGroupDetails) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *InstanceControllerApiWorkerGroupDetails) SetKey(v string)`

SetKey sets Key field to given value.

### HasKey

`func (o *InstanceControllerApiWorkerGroupDetails) HasKey() bool`

HasKey returns a boolean if a field has been set.

### GetDescription

`func (o *InstanceControllerApiWorkerGroupDetails) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *InstanceControllerApiWorkerGroupDetails) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *InstanceControllerApiWorkerGroupDetails) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *InstanceControllerApiWorkerGroupDetails) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetAllowedTenants

`func (o *InstanceControllerApiWorkerGroupDetails) GetAllowedTenants() []string`

GetAllowedTenants returns the AllowedTenants field if non-nil, zero value otherwise.

### GetAllowedTenantsOk

`func (o *InstanceControllerApiWorkerGroupDetails) GetAllowedTenantsOk() (*[]string, bool)`

GetAllowedTenantsOk returns a tuple with the AllowedTenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTenants

`func (o *InstanceControllerApiWorkerGroupDetails) SetAllowedTenants(v []string)`

SetAllowedTenants sets AllowedTenants field to given value.

### HasAllowedTenants

`func (o *InstanceControllerApiWorkerGroupDetails) HasAllowedTenants() bool`

HasAllowedTenants returns a boolean if a field has been set.

### GetWorkers

`func (o *InstanceControllerApiWorkerGroupDetails) GetWorkers() []ServiceInstance`

GetWorkers returns the Workers field if non-nil, zero value otherwise.

### GetWorkersOk

`func (o *InstanceControllerApiWorkerGroupDetails) GetWorkersOk() (*[]ServiceInstance, bool)`

GetWorkersOk returns a tuple with the Workers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkers

`func (o *InstanceControllerApiWorkerGroupDetails) SetWorkers(v []ServiceInstance)`

SetWorkers sets Workers field to given value.

### HasWorkers

`func (o *InstanceControllerApiWorkerGroupDetails) HasWorkers() bool`

HasWorkers returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


