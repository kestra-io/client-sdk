# InstanceControllerApiCreateOrUpdateWorkerGroupRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Key** | **string** | The key of the worker group. | 
**Description** | **string** | The description of the worker group. | 
**AllowedTenants** | **[]string** |  | 

## Methods

### NewInstanceControllerApiCreateOrUpdateWorkerGroupRequest

`func NewInstanceControllerApiCreateOrUpdateWorkerGroupRequest(key string, description string, allowedTenants []string, ) *InstanceControllerApiCreateOrUpdateWorkerGroupRequest`

NewInstanceControllerApiCreateOrUpdateWorkerGroupRequest instantiates a new InstanceControllerApiCreateOrUpdateWorkerGroupRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInstanceControllerApiCreateOrUpdateWorkerGroupRequestWithDefaults

`func NewInstanceControllerApiCreateOrUpdateWorkerGroupRequestWithDefaults() *InstanceControllerApiCreateOrUpdateWorkerGroupRequest`

NewInstanceControllerApiCreateOrUpdateWorkerGroupRequestWithDefaults instantiates a new InstanceControllerApiCreateOrUpdateWorkerGroupRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetKey

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) SetKey(v string)`

SetKey sets Key field to given value.


### GetDescription

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetAllowedTenants

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) GetAllowedTenants() []string`

GetAllowedTenants returns the AllowedTenants field if non-nil, zero value otherwise.

### GetAllowedTenantsOk

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) GetAllowedTenantsOk() (*[]string, bool)`

GetAllowedTenantsOk returns a tuple with the AllowedTenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTenants

`func (o *InstanceControllerApiCreateOrUpdateWorkerGroupRequest) SetAllowedTenants(v []string)`

SetAllowedTenants sets AllowedTenants field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


