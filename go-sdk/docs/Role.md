# Role

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**IsManaged** | **bool** |  | 
**Permissions** | Pointer to [**IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions**](IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.md) |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Name** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**IsDefault** | Pointer to **bool** |  | [optional] 
**Deleted** | **bool** |  | 

## Methods

### NewRole

`func NewRole(isManaged bool, name string, deleted bool, ) *Role`

NewRole instantiates a new Role object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewRoleWithDefaults

`func NewRoleWithDefaults() *Role`

NewRoleWithDefaults instantiates a new Role object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetIsManaged

`func (o *Role) GetIsManaged() bool`

GetIsManaged returns the IsManaged field if non-nil, zero value otherwise.

### GetIsManagedOk

`func (o *Role) GetIsManagedOk() (*bool, bool)`

GetIsManagedOk returns a tuple with the IsManaged field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsManaged

`func (o *Role) SetIsManaged(v bool)`

SetIsManaged sets IsManaged field to given value.


### GetPermissions

`func (o *Role) GetPermissions() IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions`

GetPermissions returns the Permissions field if non-nil, zero value otherwise.

### GetPermissionsOk

`func (o *Role) GetPermissionsOk() (*IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions, bool)`

GetPermissionsOk returns a tuple with the Permissions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPermissions

`func (o *Role) SetPermissions(v IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions)`

SetPermissions sets Permissions field to given value.

### HasPermissions

`func (o *Role) HasPermissions() bool`

HasPermissions returns a boolean if a field has been set.

### GetId

`func (o *Role) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Role) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Role) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *Role) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *Role) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *Role) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *Role) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *Role) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *Role) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *Role) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *Role) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetIsDefault

`func (o *Role) GetIsDefault() bool`

GetIsDefault returns the IsDefault field if non-nil, zero value otherwise.

### GetIsDefaultOk

`func (o *Role) GetIsDefaultOk() (*bool, bool)`

GetIsDefaultOk returns a tuple with the IsDefault field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsDefault

`func (o *Role) SetIsDefault(v bool)`

SetIsDefault sets IsDefault field to given value.

### HasIsDefault

`func (o *Role) HasIsDefault() bool`

HasIsDefault returns a boolean if a field has been set.

### GetDeleted

`func (o *Role) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *Role) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *Role) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


