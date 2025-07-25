# ClusterControllerApiCreateOrUpdateWorkerGroupRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Key** | **string** | The key of the worker group. | 
**Description** | **string** | The description of the worker group. | 
**AllowedTenants** | **[]string** |  | 

## Methods

### NewClusterControllerApiCreateOrUpdateWorkerGroupRequest

`func NewClusterControllerApiCreateOrUpdateWorkerGroupRequest(key string, description string, allowedTenants []string, ) *ClusterControllerApiCreateOrUpdateWorkerGroupRequest`

NewClusterControllerApiCreateOrUpdateWorkerGroupRequest instantiates a new ClusterControllerApiCreateOrUpdateWorkerGroupRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewClusterControllerApiCreateOrUpdateWorkerGroupRequestWithDefaults

`func NewClusterControllerApiCreateOrUpdateWorkerGroupRequestWithDefaults() *ClusterControllerApiCreateOrUpdateWorkerGroupRequest`

NewClusterControllerApiCreateOrUpdateWorkerGroupRequestWithDefaults instantiates a new ClusterControllerApiCreateOrUpdateWorkerGroupRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetKey

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) SetKey(v string)`

SetKey sets Key field to given value.


### GetDescription

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetAllowedTenants

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) GetAllowedTenants() []string`

GetAllowedTenants returns the AllowedTenants field if non-nil, zero value otherwise.

### GetAllowedTenantsOk

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) GetAllowedTenantsOk() (*[]string, bool)`

GetAllowedTenantsOk returns a tuple with the AllowedTenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTenants

`func (o *ClusterControllerApiCreateOrUpdateWorkerGroupRequest) SetAllowedTenants(v []string)`

SetAllowedTenants sets AllowedTenants field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


