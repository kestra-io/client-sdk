# ApiUser

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Type** | [**UserType**](UserType.md) |  | 
**GroupList** | Pointer to [**[]GroupIdentifier**](GroupIdentifier.md) |  | [optional] 
**Groups** | Pointer to **[]map[string]interface{}** |  | [optional] 
**Username** | **string** |  | 
**Email** | **string** |  | 
**SuperAdmin** | Pointer to **bool** |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Description** | Pointer to **string** |  | [optional] 
**FirstName** | Pointer to **string** |  | [optional] 
**LastName** | Pointer to **string** |  | [optional] 
**Providers** | Pointer to [**[]AbstractUserTenantIdentityProvider**](AbstractUserTenantIdentityProvider.md) |  | [optional] 
**Auths** | Pointer to [**[]ApiAuth**](ApiAuth.md) |  | [optional] 

## Methods

### NewApiUser

`func NewApiUser(type_ UserType, username string, email string, ) *ApiUser`

NewApiUser instantiates a new ApiUser object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiUserWithDefaults

`func NewApiUserWithDefaults() *ApiUser`

NewApiUserWithDefaults instantiates a new ApiUser object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *ApiUser) GetType() UserType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *ApiUser) GetTypeOk() (*UserType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *ApiUser) SetType(v UserType)`

SetType sets Type field to given value.


### GetGroupList

`func (o *ApiUser) GetGroupList() []GroupIdentifier`

GetGroupList returns the GroupList field if non-nil, zero value otherwise.

### GetGroupListOk

`func (o *ApiUser) GetGroupListOk() (*[]GroupIdentifier, bool)`

GetGroupListOk returns a tuple with the GroupList field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroupList

`func (o *ApiUser) SetGroupList(v []GroupIdentifier)`

SetGroupList sets GroupList field to given value.

### HasGroupList

`func (o *ApiUser) HasGroupList() bool`

HasGroupList returns a boolean if a field has been set.

### GetGroups

`func (o *ApiUser) GetGroups() []map[string]interface{}`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *ApiUser) GetGroupsOk() (*[]map[string]interface{}, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *ApiUser) SetGroups(v []map[string]interface{})`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *ApiUser) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetUsername

`func (o *ApiUser) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *ApiUser) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *ApiUser) SetUsername(v string)`

SetUsername sets Username field to given value.


### GetEmail

`func (o *ApiUser) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *ApiUser) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *ApiUser) SetEmail(v string)`

SetEmail sets Email field to given value.


### GetSuperAdmin

`func (o *ApiUser) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *ApiUser) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *ApiUser) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *ApiUser) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetId

`func (o *ApiUser) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ApiUser) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ApiUser) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ApiUser) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *ApiUser) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ApiUser) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ApiUser) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *ApiUser) HasName() bool`

HasName returns a boolean if a field has been set.

### GetDescription

`func (o *ApiUser) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ApiUser) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ApiUser) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *ApiUser) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetFirstName

`func (o *ApiUser) GetFirstName() string`

GetFirstName returns the FirstName field if non-nil, zero value otherwise.

### GetFirstNameOk

`func (o *ApiUser) GetFirstNameOk() (*string, bool)`

GetFirstNameOk returns a tuple with the FirstName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFirstName

`func (o *ApiUser) SetFirstName(v string)`

SetFirstName sets FirstName field to given value.

### HasFirstName

`func (o *ApiUser) HasFirstName() bool`

HasFirstName returns a boolean if a field has been set.

### GetLastName

`func (o *ApiUser) GetLastName() string`

GetLastName returns the LastName field if non-nil, zero value otherwise.

### GetLastNameOk

`func (o *ApiUser) GetLastNameOk() (*string, bool)`

GetLastNameOk returns a tuple with the LastName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLastName

`func (o *ApiUser) SetLastName(v string)`

SetLastName sets LastName field to given value.

### HasLastName

`func (o *ApiUser) HasLastName() bool`

HasLastName returns a boolean if a field has been set.

### GetProviders

`func (o *ApiUser) GetProviders() []AbstractUserTenantIdentityProvider`

GetProviders returns the Providers field if non-nil, zero value otherwise.

### GetProvidersOk

`func (o *ApiUser) GetProvidersOk() (*[]AbstractUserTenantIdentityProvider, bool)`

GetProvidersOk returns a tuple with the Providers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetProviders

`func (o *ApiUser) SetProviders(v []AbstractUserTenantIdentityProvider)`

SetProviders sets Providers field to given value.

### HasProviders

`func (o *ApiUser) HasProviders() bool`

HasProviders returns a boolean if a field has been set.

### GetAuths

`func (o *ApiUser) GetAuths() []ApiAuth`

GetAuths returns the Auths field if non-nil, zero value otherwise.

### GetAuthsOk

`func (o *ApiUser) GetAuthsOk() (*[]ApiAuth, bool)`

GetAuthsOk returns a tuple with the Auths field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAuths

`func (o *ApiUser) SetAuths(v []ApiAuth)`

SetAuths sets Auths field to given value.

### HasAuths

`func (o *ApiUser) HasAuths() bool`

HasAuths returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


