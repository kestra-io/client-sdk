# IAMTenantAccessControllerApiUserTenantAccess

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Username** | Pointer to **string** |  | [optional] 
**DisplayName** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**Groups** | Pointer to [**[]IAMTenantAccessControllerApiGroup**](IAMTenantAccessControllerApiGroup.md) |  | [optional] 
**Auths** | Pointer to [**[]IAMTenantAccessControllerApiAuthentication**](IAMTenantAccessControllerApiAuthentication.md) |  | [optional] 

## Methods

### NewIAMTenantAccessControllerApiUserTenantAccess

`func NewIAMTenantAccessControllerApiUserTenantAccess() *IAMTenantAccessControllerApiUserTenantAccess`

NewIAMTenantAccessControllerApiUserTenantAccess instantiates a new IAMTenantAccessControllerApiUserTenantAccess object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMTenantAccessControllerApiUserTenantAccessWithDefaults

`func NewIAMTenantAccessControllerApiUserTenantAccessWithDefaults() *IAMTenantAccessControllerApiUserTenantAccess`

NewIAMTenantAccessControllerApiUserTenantAccessWithDefaults instantiates a new IAMTenantAccessControllerApiUserTenantAccess object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMTenantAccessControllerApiUserTenantAccess) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMTenantAccessControllerApiUserTenantAccess) HasId() bool`

HasId returns a boolean if a field has been set.

### GetUsername

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *IAMTenantAccessControllerApiUserTenantAccess) SetUsername(v string)`

SetUsername sets Username field to given value.

### HasUsername

`func (o *IAMTenantAccessControllerApiUserTenantAccess) HasUsername() bool`

HasUsername returns a boolean if a field has been set.

### GetDisplayName

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *IAMTenantAccessControllerApiUserTenantAccess) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.

### HasDisplayName

`func (o *IAMTenantAccessControllerApiUserTenantAccess) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.

### GetDescription

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMTenantAccessControllerApiUserTenantAccess) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMTenantAccessControllerApiUserTenantAccess) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetGroups

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetGroups() []IAMTenantAccessControllerApiGroup`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetGroupsOk() (*[]IAMTenantAccessControllerApiGroup, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMTenantAccessControllerApiUserTenantAccess) SetGroups(v []IAMTenantAccessControllerApiGroup)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMTenantAccessControllerApiUserTenantAccess) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetAuths

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetAuths() []IAMTenantAccessControllerApiAuthentication`

GetAuths returns the Auths field if non-nil, zero value otherwise.

### GetAuthsOk

`func (o *IAMTenantAccessControllerApiUserTenantAccess) GetAuthsOk() (*[]IAMTenantAccessControllerApiAuthentication, bool)`

GetAuthsOk returns a tuple with the Auths field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuths

`func (o *IAMTenantAccessControllerApiUserTenantAccess) SetAuths(v []IAMTenantAccessControllerApiAuthentication)`

SetAuths sets Auths field to given value.

### HasAuths

`func (o *IAMTenantAccessControllerApiUserTenantAccess) HasAuths() bool`

HasAuths returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


