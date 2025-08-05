# Invitation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**IsExpired** | Pointer to **bool** |  | [optional] 
**Email** | **string** |  | 
**Id** | Pointer to **string** |  | [optional] 
**Bindings** | Pointer to [**[]Binding**](Binding.md) |  | [optional] 
**GroupIds** | Pointer to **[]string** |  | [optional] 
**TenantId** | Pointer to **string** |  | [optional] 
**Status** | Pointer to [**InvitationInvitationStatus**](InvitationInvitationStatus.md) |  | [optional] 
**SentAt** | Pointer to **time.Time** |  | [optional] 
**ExpiredAt** | Pointer to **time.Time** |  | [optional] 
**AcceptedAt** | Pointer to **time.Time** |  | [optional] 
**Deleted** | **bool** |  | 
**UserType** | Pointer to [**UserType**](UserType.md) |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 
**Link** | Pointer to **string** |  | [optional] 

## Methods

### NewInvitation

`func NewInvitation(email string, deleted bool, ) *Invitation`

NewInvitation instantiates a new Invitation object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewInvitationWithDefaults

`func NewInvitationWithDefaults() *Invitation`

NewInvitationWithDefaults instantiates a new Invitation object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetIsExpired

`func (o *Invitation) GetIsExpired() bool`

GetIsExpired returns the IsExpired field if non-nil, zero value otherwise.

### GetIsExpiredOk

`func (o *Invitation) GetIsExpiredOk() (*bool, bool)`

GetIsExpiredOk returns a tuple with the IsExpired field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsExpired

`func (o *Invitation) SetIsExpired(v bool)`

SetIsExpired sets IsExpired field to given value.

### HasIsExpired

`func (o *Invitation) HasIsExpired() bool`

HasIsExpired returns a boolean if a field has been set.

### GetEmail

`func (o *Invitation) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *Invitation) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *Invitation) SetEmail(v string)`

SetEmail sets Email field to given value.


### GetId

`func (o *Invitation) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Invitation) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Invitation) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *Invitation) HasId() bool`

HasId returns a boolean if a field has been set.

### GetBindings

`func (o *Invitation) GetBindings() []Binding`

GetBindings returns the Bindings field if non-nil, zero value otherwise.

### GetBindingsOk

`func (o *Invitation) GetBindingsOk() (*[]Binding, bool)`

GetBindingsOk returns a tuple with the Bindings field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetBindings

`func (o *Invitation) SetBindings(v []Binding)`

SetBindings sets Bindings field to given value.

### HasBindings

`func (o *Invitation) HasBindings() bool`

HasBindings returns a boolean if a field has been set.

### GetGroupIds

`func (o *Invitation) GetGroupIds() []string`

GetGroupIds returns the GroupIds field if non-nil, zero value otherwise.

### GetGroupIdsOk

`func (o *Invitation) GetGroupIdsOk() (*[]string, bool)`

GetGroupIdsOk returns a tuple with the GroupIds field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroupIds

`func (o *Invitation) SetGroupIds(v []string)`

SetGroupIds sets GroupIds field to given value.

### HasGroupIds

`func (o *Invitation) HasGroupIds() bool`

HasGroupIds returns a boolean if a field has been set.

### GetTenantId

`func (o *Invitation) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *Invitation) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *Invitation) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *Invitation) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetStatus

`func (o *Invitation) GetStatus() InvitationInvitationStatus`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *Invitation) GetStatusOk() (*InvitationInvitationStatus, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *Invitation) SetStatus(v InvitationInvitationStatus)`

SetStatus sets Status field to given value.

### HasStatus

`func (o *Invitation) HasStatus() bool`

HasStatus returns a boolean if a field has been set.

### GetSentAt

`func (o *Invitation) GetSentAt() time.Time`

GetSentAt returns the SentAt field if non-nil, zero value otherwise.

### GetSentAtOk

`func (o *Invitation) GetSentAtOk() (*time.Time, bool)`

GetSentAtOk returns a tuple with the SentAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSentAt

`func (o *Invitation) SetSentAt(v time.Time)`

SetSentAt sets SentAt field to given value.

### HasSentAt

`func (o *Invitation) HasSentAt() bool`

HasSentAt returns a boolean if a field has been set.

### GetExpiredAt

`func (o *Invitation) GetExpiredAt() time.Time`

GetExpiredAt returns the ExpiredAt field if non-nil, zero value otherwise.

### GetExpiredAtOk

`func (o *Invitation) GetExpiredAtOk() (*time.Time, bool)`

GetExpiredAtOk returns a tuple with the ExpiredAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpiredAt

`func (o *Invitation) SetExpiredAt(v time.Time)`

SetExpiredAt sets ExpiredAt field to given value.

### HasExpiredAt

`func (o *Invitation) HasExpiredAt() bool`

HasExpiredAt returns a boolean if a field has been set.

### GetAcceptedAt

`func (o *Invitation) GetAcceptedAt() time.Time`

GetAcceptedAt returns the AcceptedAt field if non-nil, zero value otherwise.

### GetAcceptedAtOk

`func (o *Invitation) GetAcceptedAtOk() (*time.Time, bool)`

GetAcceptedAtOk returns a tuple with the AcceptedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAcceptedAt

`func (o *Invitation) SetAcceptedAt(v time.Time)`

SetAcceptedAt sets AcceptedAt field to given value.

### HasAcceptedAt

`func (o *Invitation) HasAcceptedAt() bool`

HasAcceptedAt returns a boolean if a field has been set.

### GetDeleted

`func (o *Invitation) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *Invitation) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *Invitation) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetUserType

`func (o *Invitation) GetUserType() UserType`

GetUserType returns the UserType field if non-nil, zero value otherwise.

### GetUserTypeOk

`func (o *Invitation) GetUserTypeOk() (*UserType, bool)`

GetUserTypeOk returns a tuple with the UserType field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUserType

`func (o *Invitation) SetUserType(v UserType)`

SetUserType sets UserType field to given value.

### HasUserType

`func (o *Invitation) HasUserType() bool`

HasUserType returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *Invitation) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *Invitation) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *Invitation) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *Invitation) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetLink

`func (o *Invitation) GetLink() string`

GetLink returns the Link field if non-nil, zero value otherwise.

### GetLinkOk

`func (o *Invitation) GetLinkOk() (*string, bool)`

GetLinkOk returns a tuple with the Link field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLink

`func (o *Invitation) SetLink(v string)`

SetLink sets Link field to given value.

### HasLink

`func (o *Invitation) HasLink() bool`

HasLink returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


