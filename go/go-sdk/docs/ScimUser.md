# ScimUser

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Schemas** | Pointer to **[]string** |  | [optional] 
**BaseUrn** | Pointer to **string** |  | [optional] 
**Extensions** | Pointer to [**map[string]ScimExtension**](ScimExtension.md) |  | [optional] 
**Meta** | [**Meta**](Meta.md) |  | 
**Id** | Pointer to **string** |  | [optional] 
**ExternalId** | Pointer to **string** |  | [optional] 
**ResourceType** | Pointer to **string** |  | [optional] 
**PrimaryEmailAddress** | Pointer to [**NullableEmail**](Email.md) |  | [optional] 
**Active** | Pointer to **bool** |  | [optional] 
**Emails** | Pointer to [**[]Email**](Email.md) |  | [optional] 
**UserName** | Pointer to **string** |  | [optional] 
**Name** | Pointer to [**Name**](Name.md) |  | [optional] 
**Groups** | Pointer to [**[]UserGroup**](UserGroup.md) |  | [optional] 

## Methods

### NewScimUser

`func NewScimUser(meta Meta, ) *ScimUser`

NewScimUser instantiates a new ScimUser object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewScimUserWithDefaults

`func NewScimUserWithDefaults() *ScimUser`

NewScimUserWithDefaults instantiates a new ScimUser object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetSchemas

`func (o *ScimUser) GetSchemas() []string`

GetSchemas returns the Schemas field if non-nil, zero value otherwise.

### GetSchemasOk

`func (o *ScimUser) GetSchemasOk() (*[]string, bool)`

GetSchemasOk returns a tuple with the Schemas field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSchemas

`func (o *ScimUser) SetSchemas(v []string)`

SetSchemas sets Schemas field to given value.

### HasSchemas

`func (o *ScimUser) HasSchemas() bool`

HasSchemas returns a boolean if a field has been set.

### GetBaseUrn

`func (o *ScimUser) GetBaseUrn() string`

GetBaseUrn returns the BaseUrn field if non-nil, zero value otherwise.

### GetBaseUrnOk

`func (o *ScimUser) GetBaseUrnOk() (*string, bool)`

GetBaseUrnOk returns a tuple with the BaseUrn field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBaseUrn

`func (o *ScimUser) SetBaseUrn(v string)`

SetBaseUrn sets BaseUrn field to given value.

### HasBaseUrn

`func (o *ScimUser) HasBaseUrn() bool`

HasBaseUrn returns a boolean if a field has been set.

### GetExtensions

`func (o *ScimUser) GetExtensions() map[string]ScimExtension`

GetExtensions returns the Extensions field if non-nil, zero value otherwise.

### GetExtensionsOk

`func (o *ScimUser) GetExtensionsOk() (*map[string]ScimExtension, bool)`

GetExtensionsOk returns a tuple with the Extensions field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExtensions

`func (o *ScimUser) SetExtensions(v map[string]ScimExtension)`

SetExtensions sets Extensions field to given value.

### HasExtensions

`func (o *ScimUser) HasExtensions() bool`

HasExtensions returns a boolean if a field has been set.

### GetMeta

`func (o *ScimUser) GetMeta() Meta`

GetMeta returns the Meta field if non-nil, zero value otherwise.

### GetMetaOk

`func (o *ScimUser) GetMetaOk() (*Meta, bool)`

GetMetaOk returns a tuple with the Meta field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMeta

`func (o *ScimUser) SetMeta(v Meta)`

SetMeta sets Meta field to given value.


### GetId

`func (o *ScimUser) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ScimUser) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ScimUser) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *ScimUser) HasId() bool`

HasId returns a boolean if a field has been set.

### GetExternalId

`func (o *ScimUser) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *ScimUser) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *ScimUser) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.

### HasExternalId

`func (o *ScimUser) HasExternalId() bool`

HasExternalId returns a boolean if a field has been set.

### GetResourceType

`func (o *ScimUser) GetResourceType() string`

GetResourceType returns the ResourceType field if non-nil, zero value otherwise.

### GetResourceTypeOk

`func (o *ScimUser) GetResourceTypeOk() (*string, bool)`

GetResourceTypeOk returns a tuple with the ResourceType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResourceType

`func (o *ScimUser) SetResourceType(v string)`

SetResourceType sets ResourceType field to given value.

### HasResourceType

`func (o *ScimUser) HasResourceType() bool`

HasResourceType returns a boolean if a field has been set.

### GetPrimaryEmailAddress

`func (o *ScimUser) GetPrimaryEmailAddress() Email`

GetPrimaryEmailAddress returns the PrimaryEmailAddress field if non-nil, zero value otherwise.

### GetPrimaryEmailAddressOk

`func (o *ScimUser) GetPrimaryEmailAddressOk() (*Email, bool)`

GetPrimaryEmailAddressOk returns a tuple with the PrimaryEmailAddress field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPrimaryEmailAddress

`func (o *ScimUser) SetPrimaryEmailAddress(v Email)`

SetPrimaryEmailAddress sets PrimaryEmailAddress field to given value.

### HasPrimaryEmailAddress

`func (o *ScimUser) HasPrimaryEmailAddress() bool`

HasPrimaryEmailAddress returns a boolean if a field has been set.

### SetPrimaryEmailAddressNil

`func (o *ScimUser) SetPrimaryEmailAddressNil(b bool)`

 SetPrimaryEmailAddressNil sets the value for PrimaryEmailAddress to be an explicit nil

### UnsetPrimaryEmailAddress
`func (o *ScimUser) UnsetPrimaryEmailAddress()`

UnsetPrimaryEmailAddress ensures that no value is present for PrimaryEmailAddress, not even an explicit nil
### GetActive

`func (o *ScimUser) GetActive() bool`

GetActive returns the Active field if non-nil, zero value otherwise.

### GetActiveOk

`func (o *ScimUser) GetActiveOk() (*bool, bool)`

GetActiveOk returns a tuple with the Active field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetActive

`func (o *ScimUser) SetActive(v bool)`

SetActive sets Active field to given value.

### HasActive

`func (o *ScimUser) HasActive() bool`

HasActive returns a boolean if a field has been set.

### GetEmails

`func (o *ScimUser) GetEmails() []Email`

GetEmails returns the Emails field if non-nil, zero value otherwise.

### GetEmailsOk

`func (o *ScimUser) GetEmailsOk() (*[]Email, bool)`

GetEmailsOk returns a tuple with the Emails field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmails

`func (o *ScimUser) SetEmails(v []Email)`

SetEmails sets Emails field to given value.

### HasEmails

`func (o *ScimUser) HasEmails() bool`

HasEmails returns a boolean if a field has been set.

### GetUserName

`func (o *ScimUser) GetUserName() string`

GetUserName returns the UserName field if non-nil, zero value otherwise.

### GetUserNameOk

`func (o *ScimUser) GetUserNameOk() (*string, bool)`

GetUserNameOk returns a tuple with the UserName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUserName

`func (o *ScimUser) SetUserName(v string)`

SetUserName sets UserName field to given value.

### HasUserName

`func (o *ScimUser) HasUserName() bool`

HasUserName returns a boolean if a field has been set.

### GetName

`func (o *ScimUser) GetName() Name`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ScimUser) GetNameOk() (*Name, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ScimUser) SetName(v Name)`

SetName sets Name field to given value.

### HasName

`func (o *ScimUser) HasName() bool`

HasName returns a boolean if a field has been set.

### GetGroups

`func (o *ScimUser) GetGroups() []UserGroup`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *ScimUser) GetGroupsOk() (*[]UserGroup, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *ScimUser) SetGroups(v []UserGroup)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *ScimUser) HasGroups() bool`

HasGroups returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


