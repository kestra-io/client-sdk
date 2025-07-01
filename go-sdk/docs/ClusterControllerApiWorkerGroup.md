# ClusterControllerApiWorkerGroup

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** | The ID of worker group. | 
**Key** | **string** | The key of the worker group. | 
**Description** | **string** | The description of the worker group. | 
**AllowedTenants** | **[]string** |  | 

## Methods

### NewClusterControllerApiWorkerGroup

`func NewClusterControllerApiWorkerGroup(id string, key string, description string, allowedTenants []string, ) *ClusterControllerApiWorkerGroup`

NewClusterControllerApiWorkerGroup instantiates a new ClusterControllerApiWorkerGroup object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewClusterControllerApiWorkerGroupWithDefaults

`func NewClusterControllerApiWorkerGroupWithDefaults() *ClusterControllerApiWorkerGroup`

NewClusterControllerApiWorkerGroupWithDefaults instantiates a new ClusterControllerApiWorkerGroup object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ClusterControllerApiWorkerGroup) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ClusterControllerApiWorkerGroup) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ClusterControllerApiWorkerGroup) SetId(v string)`

SetId sets Id field to given value.


### GetKey

`func (o *ClusterControllerApiWorkerGroup) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *ClusterControllerApiWorkerGroup) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *ClusterControllerApiWorkerGroup) SetKey(v string)`

SetKey sets Key field to given value.


### GetDescription

`func (o *ClusterControllerApiWorkerGroup) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ClusterControllerApiWorkerGroup) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ClusterControllerApiWorkerGroup) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetAllowedTenants

`func (o *ClusterControllerApiWorkerGroup) GetAllowedTenants() []string`

GetAllowedTenants returns the AllowedTenants field if non-nil, zero value otherwise.

### GetAllowedTenantsOk

`func (o *ClusterControllerApiWorkerGroup) GetAllowedTenantsOk() (*[]string, bool)`

GetAllowedTenantsOk returns a tuple with the AllowedTenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTenants

`func (o *ClusterControllerApiWorkerGroup) SetAllowedTenants(v []string)`

SetAllowedTenants sets AllowedTenants field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


