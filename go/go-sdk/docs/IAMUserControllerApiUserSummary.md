# IAMUserControllerApiUserSummary

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Username** | Pointer to **string** |  | [optional] 
**DisplayName** | Pointer to **string** |  | [optional] 
**Tenants** | Pointer to [**[]ApiTenantSummary**](ApiTenantSummary.md) |  | [optional] 
**Auths** | Pointer to [**[]IAMUserControllerApiUserAuth**](IAMUserControllerApiUserAuth.md) |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMUserControllerApiUserSummary

`func NewIAMUserControllerApiUserSummary() *IAMUserControllerApiUserSummary`

NewIAMUserControllerApiUserSummary instantiates a new IAMUserControllerApiUserSummary object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMUserControllerApiUserSummaryWithDefaults

`func NewIAMUserControllerApiUserSummaryWithDefaults() *IAMUserControllerApiUserSummary`

NewIAMUserControllerApiUserSummaryWithDefaults instantiates a new IAMUserControllerApiUserSummary object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMUserControllerApiUserSummary) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMUserControllerApiUserSummary) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMUserControllerApiUserSummary) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMUserControllerApiUserSummary) HasId() bool`

HasId returns a boolean if a field has been set.

### GetUsername

`func (o *IAMUserControllerApiUserSummary) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *IAMUserControllerApiUserSummary) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *IAMUserControllerApiUserSummary) SetUsername(v string)`

SetUsername sets Username field to given value.

### HasUsername

`func (o *IAMUserControllerApiUserSummary) HasUsername() bool`

HasUsername returns a boolean if a field has been set.

### GetDisplayName

`func (o *IAMUserControllerApiUserSummary) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *IAMUserControllerApiUserSummary) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *IAMUserControllerApiUserSummary) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.

### HasDisplayName

`func (o *IAMUserControllerApiUserSummary) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.

### GetTenants

`func (o *IAMUserControllerApiUserSummary) GetTenants() []ApiTenantSummary`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *IAMUserControllerApiUserSummary) GetTenantsOk() (*[]ApiTenantSummary, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *IAMUserControllerApiUserSummary) SetTenants(v []ApiTenantSummary)`

SetTenants sets Tenants field to given value.

### HasTenants

`func (o *IAMUserControllerApiUserSummary) HasTenants() bool`

HasTenants returns a boolean if a field has been set.

### GetAuths

`func (o *IAMUserControllerApiUserSummary) GetAuths() []IAMUserControllerApiUserAuth`

GetAuths returns the Auths field if non-nil, zero value otherwise.

### GetAuthsOk

`func (o *IAMUserControllerApiUserSummary) GetAuthsOk() (*[]IAMUserControllerApiUserAuth, bool)`

GetAuthsOk returns a tuple with the Auths field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuths

`func (o *IAMUserControllerApiUserSummary) SetAuths(v []IAMUserControllerApiUserAuth)`

SetAuths sets Auths field to given value.

### HasAuths

`func (o *IAMUserControllerApiUserSummary) HasAuths() bool`

HasAuths returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMUserControllerApiUserSummary) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMUserControllerApiUserSummary) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMUserControllerApiUserSummary) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMUserControllerApiUserSummary) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


