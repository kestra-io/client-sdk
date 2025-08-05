# IAMRoleControllerApiRoleDetail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Permissions** | Pointer to [**IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions**](IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.md) |  | [optional] 
**IsDefault** | Pointer to **bool** |  | [optional] 
**IsManaged** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMRoleControllerApiRoleDetail

`func NewIAMRoleControllerApiRoleDetail() *IAMRoleControllerApiRoleDetail`

NewIAMRoleControllerApiRoleDetail instantiates a new IAMRoleControllerApiRoleDetail object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMRoleControllerApiRoleDetailWithDefaults

`func NewIAMRoleControllerApiRoleDetailWithDefaults() *IAMRoleControllerApiRoleDetail`

NewIAMRoleControllerApiRoleDetailWithDefaults instantiates a new IAMRoleControllerApiRoleDetail object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMRoleControllerApiRoleDetail) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMRoleControllerApiRoleDetail) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMRoleControllerApiRoleDetail) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMRoleControllerApiRoleDetail) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *IAMRoleControllerApiRoleDetail) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMRoleControllerApiRoleDetail) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMRoleControllerApiRoleDetail) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *IAMRoleControllerApiRoleDetail) HasName() bool`

HasName returns a boolean if a field has been set.

### GetDescription

`func (o *IAMRoleControllerApiRoleDetail) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMRoleControllerApiRoleDetail) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMRoleControllerApiRoleDetail) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMRoleControllerApiRoleDetail) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetPermissions

`func (o *IAMRoleControllerApiRoleDetail) GetPermissions() IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions`

GetPermissions returns the Permissions field if non-nil, zero value otherwise.

### GetPermissionsOk

`func (o *IAMRoleControllerApiRoleDetail) GetPermissionsOk() (*IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions, bool)`

GetPermissionsOk returns a tuple with the Permissions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPermissions

`func (o *IAMRoleControllerApiRoleDetail) SetPermissions(v IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions)`

SetPermissions sets Permissions field to given value.

### HasPermissions

`func (o *IAMRoleControllerApiRoleDetail) HasPermissions() bool`

HasPermissions returns a boolean if a field has been set.

### GetIsDefault

`func (o *IAMRoleControllerApiRoleDetail) GetIsDefault() bool`

GetIsDefault returns the IsDefault field if non-nil, zero value otherwise.

### GetIsDefaultOk

`func (o *IAMRoleControllerApiRoleDetail) GetIsDefaultOk() (*bool, bool)`

GetIsDefaultOk returns a tuple with the IsDefault field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsDefault

`func (o *IAMRoleControllerApiRoleDetail) SetIsDefault(v bool)`

SetIsDefault sets IsDefault field to given value.

### HasIsDefault

`func (o *IAMRoleControllerApiRoleDetail) HasIsDefault() bool`

HasIsDefault returns a boolean if a field has been set.

### GetIsManaged

`func (o *IAMRoleControllerApiRoleDetail) GetIsManaged() bool`

GetIsManaged returns the IsManaged field if non-nil, zero value otherwise.

### GetIsManagedOk

`func (o *IAMRoleControllerApiRoleDetail) GetIsManagedOk() (*bool, bool)`

GetIsManagedOk returns a tuple with the IsManaged field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsManaged

`func (o *IAMRoleControllerApiRoleDetail) SetIsManaged(v bool)`

SetIsManaged sets IsManaged field to given value.

### HasIsManaged

`func (o *IAMRoleControllerApiRoleDetail) HasIsManaged() bool`

HasIsManaged returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


