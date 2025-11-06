# IAMTenantAccessControllerApiTenantAccess

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | Pointer to **string** |  | [optional] 
**UserId** | Pointer to **string** |  | [optional] 
**Username** | Pointer to **string** |  | [optional] 
**DisplayName** | Pointer to **string** |  | [optional] 
**Groups** | Pointer to [**[]IAMTenantAccessControllerApiGroup**](IAMTenantAccessControllerApiGroup.md) |  | [optional] 
**Roles** | Pointer to [**[]IAMTenantAccessControllerApiRoleAssignment**](IAMTenantAccessControllerApiRoleAssignment.md) |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMTenantAccessControllerApiTenantAccess

`func NewIAMTenantAccessControllerApiTenantAccess() *IAMTenantAccessControllerApiTenantAccess`

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

### HasTenantId

`func (o *IAMTenantAccessControllerApiTenantAccess) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

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

### HasUserId

`func (o *IAMTenantAccessControllerApiTenantAccess) HasUserId() bool`

HasUserId returns a boolean if a field has been set.

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

### HasUsername

`func (o *IAMTenantAccessControllerApiTenantAccess) HasUsername() bool`

HasUsername returns a boolean if a field has been set.

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

### HasDisplayName

`func (o *IAMTenantAccessControllerApiTenantAccess) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.

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

### HasGroups

`func (o *IAMTenantAccessControllerApiTenantAccess) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

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

### HasRoles

`func (o *IAMTenantAccessControllerApiTenantAccess) HasRoles() bool`

HasRoles returns a boolean if a field has been set.

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

### HasSuperAdmin

`func (o *IAMTenantAccessControllerApiTenantAccess) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


