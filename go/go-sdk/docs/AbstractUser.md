# AbstractUser

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

## Methods

### NewAbstractUser

`func NewAbstractUser(type_ UserType, username string, email string, ) *AbstractUser`

NewAbstractUser instantiates a new AbstractUser object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAbstractUserWithDefaults

`func NewAbstractUserWithDefaults() *AbstractUser`

NewAbstractUserWithDefaults instantiates a new AbstractUser object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *AbstractUser) GetType() UserType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *AbstractUser) GetTypeOk() (*UserType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *AbstractUser) SetType(v UserType)`

SetType sets Type field to given value.


### GetGroupList

`func (o *AbstractUser) GetGroupList() []GroupIdentifier`

GetGroupList returns the GroupList field if non-nil, zero value otherwise.

### GetGroupListOk

`func (o *AbstractUser) GetGroupListOk() (*[]GroupIdentifier, bool)`

GetGroupListOk returns a tuple with the GroupList field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroupList

`func (o *AbstractUser) SetGroupList(v []GroupIdentifier)`

SetGroupList sets GroupList field to given value.

### HasGroupList

`func (o *AbstractUser) HasGroupList() bool`

HasGroupList returns a boolean if a field has been set.

### GetGroups

`func (o *AbstractUser) GetGroups() []map[string]interface{}`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *AbstractUser) GetGroupsOk() (*[]map[string]interface{}, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *AbstractUser) SetGroups(v []map[string]interface{})`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *AbstractUser) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetUsername

`func (o *AbstractUser) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *AbstractUser) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *AbstractUser) SetUsername(v string)`

SetUsername sets Username field to given value.


### GetEmail

`func (o *AbstractUser) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *AbstractUser) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *AbstractUser) SetEmail(v string)`

SetEmail sets Email field to given value.


### GetSuperAdmin

`func (o *AbstractUser) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *AbstractUser) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *AbstractUser) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *AbstractUser) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetId

`func (o *AbstractUser) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *AbstractUser) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *AbstractUser) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *AbstractUser) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *AbstractUser) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *AbstractUser) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *AbstractUser) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *AbstractUser) HasName() bool`

HasName returns a boolean if a field has been set.

### GetDescription

`func (o *AbstractUser) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *AbstractUser) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *AbstractUser) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *AbstractUser) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetFirstName

`func (o *AbstractUser) GetFirstName() string`

GetFirstName returns the FirstName field if non-nil, zero value otherwise.

### GetFirstNameOk

`func (o *AbstractUser) GetFirstNameOk() (*string, bool)`

GetFirstNameOk returns a tuple with the FirstName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFirstName

`func (o *AbstractUser) SetFirstName(v string)`

SetFirstName sets FirstName field to given value.

### HasFirstName

`func (o *AbstractUser) HasFirstName() bool`

HasFirstName returns a boolean if a field has been set.

### GetLastName

`func (o *AbstractUser) GetLastName() string`

GetLastName returns the LastName field if non-nil, zero value otherwise.

### GetLastNameOk

`func (o *AbstractUser) GetLastNameOk() (*string, bool)`

GetLastNameOk returns a tuple with the LastName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLastName

`func (o *AbstractUser) SetLastName(v string)`

SetLastName sets LastName field to given value.

### HasLastName

`func (o *AbstractUser) HasLastName() bool`

HasLastName returns a boolean if a field has been set.

### GetProviders

`func (o *AbstractUser) GetProviders() []AbstractUserTenantIdentityProvider`

GetProviders returns the Providers field if non-nil, zero value otherwise.

### GetProvidersOk

`func (o *AbstractUser) GetProvidersOk() (*[]AbstractUserTenantIdentityProvider, bool)`

GetProvidersOk returns a tuple with the Providers field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetProviders

`func (o *AbstractUser) SetProviders(v []AbstractUserTenantIdentityProvider)`

SetProviders sets Providers field to given value.

### HasProviders

`func (o *AbstractUser) HasProviders() bool`

HasProviders returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


