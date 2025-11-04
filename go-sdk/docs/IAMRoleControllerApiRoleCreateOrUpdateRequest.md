# IAMRoleControllerApiRoleCreateOrUpdateRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Permissions** | [**IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions**](IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.md) |  | 
**Name** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**IsDefault** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMRoleControllerApiRoleCreateOrUpdateRequest

`func NewIAMRoleControllerApiRoleCreateOrUpdateRequest(permissions IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions, name string, ) *IAMRoleControllerApiRoleCreateOrUpdateRequest`

NewIAMRoleControllerApiRoleCreateOrUpdateRequest instantiates a new IAMRoleControllerApiRoleCreateOrUpdateRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMRoleControllerApiRoleCreateOrUpdateRequestWithDefaults

`func NewIAMRoleControllerApiRoleCreateOrUpdateRequestWithDefaults() *IAMRoleControllerApiRoleCreateOrUpdateRequest`

NewIAMRoleControllerApiRoleCreateOrUpdateRequestWithDefaults instantiates a new IAMRoleControllerApiRoleCreateOrUpdateRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetPermissions

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetPermissions() IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions`

GetPermissions returns the Permissions field if non-nil, zero value otherwise.

### GetPermissionsOk

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetPermissionsOk() (*IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions, bool)`

GetPermissionsOk returns a tuple with the Permissions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPermissions

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) SetPermissions(v IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions)`

SetPermissions sets Permissions field to given value.


### GetName

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetIsDefault

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetIsDefault() bool`

GetIsDefault returns the IsDefault field if non-nil, zero value otherwise.

### GetIsDefaultOk

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) GetIsDefaultOk() (*bool, bool)`

GetIsDefaultOk returns a tuple with the IsDefault field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsDefault

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) SetIsDefault(v bool)`

SetIsDefault sets IsDefault field to given value.

### HasIsDefault

`func (o *IAMRoleControllerApiRoleCreateOrUpdateRequest) HasIsDefault() bool`

HasIsDefault returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


