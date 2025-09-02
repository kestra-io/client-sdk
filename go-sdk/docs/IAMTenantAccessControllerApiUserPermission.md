# IAMTenantAccessControllerApiUserPermission

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Permission** | [**Permission**](Permission.md) |  | 
**Actions** | [**[]Action**](Action.md) |  | 

## Methods

### NewIAMTenantAccessControllerApiUserPermission

`func NewIAMTenantAccessControllerApiUserPermission(permission Permission, actions []Action, ) *IAMTenantAccessControllerApiUserPermission`

NewIAMTenantAccessControllerApiUserPermission instantiates a new IAMTenantAccessControllerApiUserPermission object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMTenantAccessControllerApiUserPermissionWithDefaults

`func NewIAMTenantAccessControllerApiUserPermissionWithDefaults() *IAMTenantAccessControllerApiUserPermission`

NewIAMTenantAccessControllerApiUserPermissionWithDefaults instantiates a new IAMTenantAccessControllerApiUserPermission object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetPermission

`func (o *IAMTenantAccessControllerApiUserPermission) GetPermission() Permission`

GetPermission returns the Permission field if non-nil, zero value otherwise.

### GetPermissionOk

`func (o *IAMTenantAccessControllerApiUserPermission) GetPermissionOk() (*Permission, bool)`

GetPermissionOk returns a tuple with the Permission field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPermission

`func (o *IAMTenantAccessControllerApiUserPermission) SetPermission(v Permission)`

SetPermission sets Permission field to given value.


### GetActions

`func (o *IAMTenantAccessControllerApiUserPermission) GetActions() []Action`

GetActions returns the Actions field if non-nil, zero value otherwise.

### GetActionsOk

`func (o *IAMTenantAccessControllerApiUserPermission) GetActionsOk() (*[]Action, bool)`

GetActionsOk returns a tuple with the Actions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetActions

`func (o *IAMTenantAccessControllerApiUserPermission) SetActions(v []Action)`

SetActions sets Actions field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


