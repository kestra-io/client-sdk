# IAMUserControllerApiCreateOrUpdateUserRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Tenants** | Pointer to **[]string** |  | [optional] 
**Groups** | Pointer to **[]string** |  | [optional] 
**FirstName** | Pointer to **string** |  | [optional] 
**LastName** | Pointer to **string** |  | [optional] 
**Email** | **string** |  | 
**Password** | Pointer to **string** |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 
**Restricted** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMUserControllerApiCreateOrUpdateUserRequest

`func NewIAMUserControllerApiCreateOrUpdateUserRequest(email string, ) *IAMUserControllerApiCreateOrUpdateUserRequest`

NewIAMUserControllerApiCreateOrUpdateUserRequest instantiates a new IAMUserControllerApiCreateOrUpdateUserRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMUserControllerApiCreateOrUpdateUserRequestWithDefaults

`func NewIAMUserControllerApiCreateOrUpdateUserRequestWithDefaults() *IAMUserControllerApiCreateOrUpdateUserRequest`

NewIAMUserControllerApiCreateOrUpdateUserRequestWithDefaults instantiates a new IAMUserControllerApiCreateOrUpdateUserRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenants

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetTenants() []string`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetTenantsOk() (*[]string, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetTenants(v []string)`

SetTenants sets Tenants field to given value.

### HasTenants

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) HasTenants() bool`

HasTenants returns a boolean if a field has been set.

### GetGroups

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetGroups() []string`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetGroupsOk() (*[]string, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetGroups(v []string)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetFirstName

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetFirstName() string`

GetFirstName returns the FirstName field if non-nil, zero value otherwise.

### GetFirstNameOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetFirstNameOk() (*string, bool)`

GetFirstNameOk returns a tuple with the FirstName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFirstName

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetFirstName(v string)`

SetFirstName sets FirstName field to given value.

### HasFirstName

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) HasFirstName() bool`

HasFirstName returns a boolean if a field has been set.

### GetLastName

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetLastName() string`

GetLastName returns the LastName field if non-nil, zero value otherwise.

### GetLastNameOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetLastNameOk() (*string, bool)`

GetLastNameOk returns a tuple with the LastName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLastName

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetLastName(v string)`

SetLastName sets LastName field to given value.

### HasLastName

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) HasLastName() bool`

HasLastName returns a boolean if a field has been set.

### GetEmail

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetEmail(v string)`

SetEmail sets Email field to given value.


### GetPassword

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetPassword() string`

GetPassword returns the Password field if non-nil, zero value otherwise.

### GetPasswordOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetPasswordOk() (*string, bool)`

GetPasswordOk returns a tuple with the Password field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPassword

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetPassword(v string)`

SetPassword sets Password field to given value.

### HasPassword

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) HasPassword() bool`

HasPassword returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetRestricted

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetRestricted() bool`

GetRestricted returns the Restricted field if non-nil, zero value otherwise.

### GetRestrictedOk

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) GetRestrictedOk() (*bool, bool)`

GetRestrictedOk returns a tuple with the Restricted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRestricted

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) SetRestricted(v bool)`

SetRestricted sets Restricted field to given value.

### HasRestricted

`func (o *IAMUserControllerApiCreateOrUpdateUserRequest) HasRestricted() bool`

HasRestricted returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


