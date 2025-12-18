# IAMInvitationControllerApiInvitationCreateRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**CreateUserIfNotExist** | Pointer to **bool** |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 
**Roles** | Pointer to [**[]IAMInvitationControllerApiInvitationRole**](IAMInvitationControllerApiInvitationRole.md) |  | [optional] 
**Groups** | Pointer to **[]string** |  | [optional] 
**Email** | **string** |  | 

## Methods

### NewIAMInvitationControllerApiInvitationCreateRequest

`func NewIAMInvitationControllerApiInvitationCreateRequest(email string, ) *IAMInvitationControllerApiInvitationCreateRequest`

NewIAMInvitationControllerApiInvitationCreateRequest instantiates a new IAMInvitationControllerApiInvitationCreateRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMInvitationControllerApiInvitationCreateRequestWithDefaults

`func NewIAMInvitationControllerApiInvitationCreateRequestWithDefaults() *IAMInvitationControllerApiInvitationCreateRequest`

NewIAMInvitationControllerApiInvitationCreateRequestWithDefaults instantiates a new IAMInvitationControllerApiInvitationCreateRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetCreateUserIfNotExist

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetCreateUserIfNotExist() bool`

GetCreateUserIfNotExist returns the CreateUserIfNotExist field if non-nil, zero value otherwise.

### GetCreateUserIfNotExistOk

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetCreateUserIfNotExistOk() (*bool, bool)`

GetCreateUserIfNotExistOk returns a tuple with the CreateUserIfNotExist field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCreateUserIfNotExist

`func (o *IAMInvitationControllerApiInvitationCreateRequest) SetCreateUserIfNotExist(v bool)`

SetCreateUserIfNotExist sets CreateUserIfNotExist field to given value.

### HasCreateUserIfNotExist

`func (o *IAMInvitationControllerApiInvitationCreateRequest) HasCreateUserIfNotExist() bool`

HasCreateUserIfNotExist returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMInvitationControllerApiInvitationCreateRequest) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMInvitationControllerApiInvitationCreateRequest) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetRoles

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetRoles() []IAMInvitationControllerApiInvitationRole`

GetRoles returns the Roles field if non-nil, zero value otherwise.

### GetRolesOk

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetRolesOk() (*[]IAMInvitationControllerApiInvitationRole, bool)`

GetRolesOk returns a tuple with the Roles field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRoles

`func (o *IAMInvitationControllerApiInvitationCreateRequest) SetRoles(v []IAMInvitationControllerApiInvitationRole)`

SetRoles sets Roles field to given value.

### HasRoles

`func (o *IAMInvitationControllerApiInvitationCreateRequest) HasRoles() bool`

HasRoles returns a boolean if a field has been set.

### GetGroups

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetGroups() []string`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetGroupsOk() (*[]string, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMInvitationControllerApiInvitationCreateRequest) SetGroups(v []string)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMInvitationControllerApiInvitationCreateRequest) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetEmail

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *IAMInvitationControllerApiInvitationCreateRequest) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *IAMInvitationControllerApiInvitationCreateRequest) SetEmail(v string)`

SetEmail sets Email field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


