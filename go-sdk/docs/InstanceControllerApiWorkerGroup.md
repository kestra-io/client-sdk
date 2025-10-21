# InstanceControllerApiWorkerGroup

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** | The ID of worker group. | [optional] 
**Key** | Pointer to **string** | The key of the worker group. | [optional] 
**Description** | Pointer to **string** | The description of the worker group. | [optional] 
**AllowedTenants** | Pointer to **[]string** |  | [optional] 

## Methods

### NewInstanceControllerApiWorkerGroup

`func NewInstanceControllerApiWorkerGroup() *InstanceControllerApiWorkerGroup`

NewInstanceControllerApiWorkerGroup instantiates a new InstanceControllerApiWorkerGroup object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInstanceControllerApiWorkerGroupWithDefaults

`func NewInstanceControllerApiWorkerGroupWithDefaults() *InstanceControllerApiWorkerGroup`

NewInstanceControllerApiWorkerGroupWithDefaults instantiates a new InstanceControllerApiWorkerGroup object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *InstanceControllerApiWorkerGroup) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *InstanceControllerApiWorkerGroup) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *InstanceControllerApiWorkerGroup) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *InstanceControllerApiWorkerGroup) HasId() bool`

HasId returns a boolean if a field has been set.

### GetKey

`func (o *InstanceControllerApiWorkerGroup) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *InstanceControllerApiWorkerGroup) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *InstanceControllerApiWorkerGroup) SetKey(v string)`

SetKey sets Key field to given value.

### HasKey

`func (o *InstanceControllerApiWorkerGroup) HasKey() bool`

HasKey returns a boolean if a field has been set.

### GetDescription

`func (o *InstanceControllerApiWorkerGroup) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *InstanceControllerApiWorkerGroup) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *InstanceControllerApiWorkerGroup) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *InstanceControllerApiWorkerGroup) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetAllowedTenants

`func (o *InstanceControllerApiWorkerGroup) GetAllowedTenants() []string`

GetAllowedTenants returns the AllowedTenants field if non-nil, zero value otherwise.

### GetAllowedTenantsOk

`func (o *InstanceControllerApiWorkerGroup) GetAllowedTenantsOk() (*[]string, bool)`

GetAllowedTenantsOk returns a tuple with the AllowedTenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAllowedTenants

`func (o *InstanceControllerApiWorkerGroup) SetAllowedTenants(v []string)`

SetAllowedTenants sets AllowedTenants field to given value.

### HasAllowedTenants

`func (o *InstanceControllerApiWorkerGroup) HasAllowedTenants() bool`

HasAllowedTenants returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


