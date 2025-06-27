# Invitation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**IsExpired** | **bool** |  | 
**Email** | **string** |  | 
**Id** | **string** |  | 
**Bindings** | [**[]Binding**](Binding.md) |  | 
**GroupIds** | **[]string** |  | 
**TenantId** | **string** |  | 
**Status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) |  | 
**SentAt** | **time.Time** |  | 
**ExpiredAt** | **time.Time** |  | 
**AcceptedAt** | **time.Time** |  | 
**Deleted** | **bool** |  | 
**UserType** | [**UserType**](UserType.md) |  | 
**SuperAdmin** | **bool** |  | 
**Link** | **string** |  | 

## Methods

### NewInvitation

`func NewInvitation(isExpired bool, email string, id string, bindings []Binding, groupIds []string, tenantId string, status InvitationInvitationStatus, sentAt time.Time, expiredAt time.Time, acceptedAt time.Time, deleted bool, userType UserType, superAdmin bool, link string, ) *Invitation`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


