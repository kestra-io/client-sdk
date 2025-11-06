# IAMUserControllerApiUser

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Username** | Pointer to **string** |  | [optional] 
**DisplayName** | Pointer to **string** |  | [optional] 
**FirstName** | Pointer to **string** |  | [optional] 
**LastName** | Pointer to **string** |  | [optional] 
**Email** | Pointer to **string** |  | [optional] 
**Tenants** | Pointer to [**[]ApiTenantSummary**](ApiTenantSummary.md) |  | [optional] 
**Auths** | Pointer to [**[]IAMUserControllerApiUserAuth**](IAMUserControllerApiUserAuth.md) |  | [optional] 
**Groups** | Pointer to [**[]IAMUserControllerApiGroup**](IAMUserControllerApiGroup.md) |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 
**Restricted** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMUserControllerApiUser

`func NewIAMUserControllerApiUser() *IAMUserControllerApiUser`

NewIAMUserControllerApiUser instantiates a new IAMUserControllerApiUser object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMUserControllerApiUserWithDefaults

`func NewIAMUserControllerApiUserWithDefaults() *IAMUserControllerApiUser`

NewIAMUserControllerApiUserWithDefaults instantiates a new IAMUserControllerApiUser object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMUserControllerApiUser) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMUserControllerApiUser) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMUserControllerApiUser) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMUserControllerApiUser) HasId() bool`

HasId returns a boolean if a field has been set.

### GetUsername

`func (o *IAMUserControllerApiUser) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *IAMUserControllerApiUser) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *IAMUserControllerApiUser) SetUsername(v string)`

SetUsername sets Username field to given value.

### HasUsername

`func (o *IAMUserControllerApiUser) HasUsername() bool`

HasUsername returns a boolean if a field has been set.

### GetDisplayName

`func (o *IAMUserControllerApiUser) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *IAMUserControllerApiUser) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *IAMUserControllerApiUser) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.

### HasDisplayName

`func (o *IAMUserControllerApiUser) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.

### GetFirstName

`func (o *IAMUserControllerApiUser) GetFirstName() string`

GetFirstName returns the FirstName field if non-nil, zero value otherwise.

### GetFirstNameOk

`func (o *IAMUserControllerApiUser) GetFirstNameOk() (*string, bool)`

GetFirstNameOk returns a tuple with the FirstName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFirstName

`func (o *IAMUserControllerApiUser) SetFirstName(v string)`

SetFirstName sets FirstName field to given value.

### HasFirstName

`func (o *IAMUserControllerApiUser) HasFirstName() bool`

HasFirstName returns a boolean if a field has been set.

### GetLastName

`func (o *IAMUserControllerApiUser) GetLastName() string`

GetLastName returns the LastName field if non-nil, zero value otherwise.

### GetLastNameOk

`func (o *IAMUserControllerApiUser) GetLastNameOk() (*string, bool)`

GetLastNameOk returns a tuple with the LastName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLastName

`func (o *IAMUserControllerApiUser) SetLastName(v string)`

SetLastName sets LastName field to given value.

### HasLastName

`func (o *IAMUserControllerApiUser) HasLastName() bool`

HasLastName returns a boolean if a field has been set.

### GetEmail

`func (o *IAMUserControllerApiUser) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *IAMUserControllerApiUser) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *IAMUserControllerApiUser) SetEmail(v string)`

SetEmail sets Email field to given value.

### HasEmail

`func (o *IAMUserControllerApiUser) HasEmail() bool`

HasEmail returns a boolean if a field has been set.

### GetTenants

`func (o *IAMUserControllerApiUser) GetTenants() []ApiTenantSummary`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *IAMUserControllerApiUser) GetTenantsOk() (*[]ApiTenantSummary, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *IAMUserControllerApiUser) SetTenants(v []ApiTenantSummary)`

SetTenants sets Tenants field to given value.

### HasTenants

`func (o *IAMUserControllerApiUser) HasTenants() bool`

HasTenants returns a boolean if a field has been set.

### GetAuths

`func (o *IAMUserControllerApiUser) GetAuths() []IAMUserControllerApiUserAuth`

GetAuths returns the Auths field if non-nil, zero value otherwise.

### GetAuthsOk

`func (o *IAMUserControllerApiUser) GetAuthsOk() (*[]IAMUserControllerApiUserAuth, bool)`

GetAuthsOk returns a tuple with the Auths field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuths

`func (o *IAMUserControllerApiUser) SetAuths(v []IAMUserControllerApiUserAuth)`

SetAuths sets Auths field to given value.

### HasAuths

`func (o *IAMUserControllerApiUser) HasAuths() bool`

HasAuths returns a boolean if a field has been set.

### GetGroups

`func (o *IAMUserControllerApiUser) GetGroups() []IAMUserControllerApiGroup`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMUserControllerApiUser) GetGroupsOk() (*[]IAMUserControllerApiGroup, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMUserControllerApiUser) SetGroups(v []IAMUserControllerApiGroup)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMUserControllerApiUser) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMUserControllerApiUser) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMUserControllerApiUser) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMUserControllerApiUser) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMUserControllerApiUser) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetRestricted

`func (o *IAMUserControllerApiUser) GetRestricted() bool`

GetRestricted returns the Restricted field if non-nil, zero value otherwise.

### GetRestrictedOk

`func (o *IAMUserControllerApiUser) GetRestrictedOk() (*bool, bool)`

GetRestrictedOk returns a tuple with the Restricted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRestricted

`func (o *IAMUserControllerApiUser) SetRestricted(v bool)`

SetRestricted sets Restricted field to given value.

### HasRestricted

`func (o *IAMUserControllerApiUser) HasRestricted() bool`

HasRestricted returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


