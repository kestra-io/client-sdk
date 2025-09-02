# IAMTenantAccessControllerApiTenantAccess

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | **string** |  | 
**UserId** | **string** |  | 
**Username** | **string** |  | 
**DisplayName** | **string** |  | 
**Groups** | [**[]IAMTenantAccessControllerApiGroup**](IAMTenantAccessControllerApiGroup.md) |  | 
**Roles** | [**[]IAMTenantAccessControllerApiRoleAssignment**](IAMTenantAccessControllerApiRoleAssignment.md) |  | 
**SuperAdmin** | **bool** |  | 

## Methods

### NewIAMTenantAccessControllerApiTenantAccess

`func NewIAMTenantAccessControllerApiTenantAccess(tenantId string, userId string, username string, displayName string, groups []IAMTenantAccessControllerApiGroup, roles []IAMTenantAccessControllerApiRoleAssignment, superAdmin bool, ) *IAMTenantAccessControllerApiTenantAccess`

NewIAMTenantAccessControllerApiTenantAccess instantiates a new IAMTenantAccessControllerApiTenantAccess object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMTenantAccessControllerApiTenantAccessWithDefaults

`func NewIAMTenantAccessControllerApiTenantAccessWithDefaults() *IAMTenantAccessControllerApiTenantAccess`

NewIAMTenantAccessControllerApiTenantAccessWithDefaults instantiates a new IAMTenantAccessControllerApiTenantAccess object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *IAMTenantAccessControllerApiTenantAccess) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *IAMTenantAccessControllerApiTenantAccess) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *IAMTenantAccessControllerApiTenantAccess) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.


### GetUserId

`func (o *IAMTenantAccessControllerApiTenantAccess) GetUserId() string`

GetUserId returns the UserId field if non-nil, zero value otherwise.

### GetUserIdOk

`func (o *IAMTenantAccessControllerApiTenantAccess) GetUserIdOk() (*string, bool)`

GetUserIdOk returns a tuple with the UserId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUserId

`func (o *IAMTenantAccessControllerApiTenantAccess) SetUserId(v string)`

SetUserId sets UserId field to given value.


### GetUsername

`func (o *IAMTenantAccessControllerApiTenantAccess) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *IAMTenantAccessControllerApiTenantAccess) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *IAMTenantAccessControllerApiTenantAccess) SetUsername(v string)`

SetUsername sets Username field to given value.


### GetDisplayName

`func (o *IAMTenantAccessControllerApiTenantAccess) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *IAMTenantAccessControllerApiTenantAccess) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *IAMTenantAccessControllerApiTenantAccess) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.


### GetGroups

`func (o *IAMTenantAccessControllerApiTenantAccess) GetGroups() []IAMTenantAccessControllerApiGroup`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMTenantAccessControllerApiTenantAccess) GetGroupsOk() (*[]IAMTenantAccessControllerApiGroup, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMTenantAccessControllerApiTenantAccess) SetGroups(v []IAMTenantAccessControllerApiGroup)`

SetGroups sets Groups field to given value.


### GetRoles

`func (o *IAMTenantAccessControllerApiTenantAccess) GetRoles() []IAMTenantAccessControllerApiRoleAssignment`

GetRoles returns the Roles field if non-nil, zero value otherwise.

### GetRolesOk

`func (o *IAMTenantAccessControllerApiTenantAccess) GetRolesOk() (*[]IAMTenantAccessControllerApiRoleAssignment, bool)`

GetRolesOk returns a tuple with the Roles field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRoles

`func (o *IAMTenantAccessControllerApiTenantAccess) SetRoles(v []IAMTenantAccessControllerApiRoleAssignment)`

SetRoles sets Roles field to given value.


### GetSuperAdmin

`func (o *IAMTenantAccessControllerApiTenantAccess) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMTenantAccessControllerApiTenantAccess) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMTenantAccessControllerApiTenantAccess) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


