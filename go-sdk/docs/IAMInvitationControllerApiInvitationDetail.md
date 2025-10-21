# IAMInvitationControllerApiInvitationDetail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Roles** | Pointer to [**[]ApiRoleSummary**](ApiRoleSummary.md) |  | [optional] 
**Groups** | Pointer to [**[]ApiGroupSummary**](ApiGroupSummary.md) |  | [optional] 
**TenantId** | Pointer to **string** |  | [optional] 
**Email** | Pointer to **string** |  | [optional] 
**Status** | Pointer to [**InvitationInvitationStatus**](InvitationInvitationStatus.md) |  | [optional] 
**SentAt** | Pointer to **time.Time** |  | [optional] 
**ExpiredAt** | Pointer to **time.Time** |  | [optional] 
**AcceptedAt** | Pointer to **time.Time** |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 
**Link** | Pointer to **string** |  | [optional] 

## Methods

### NewIAMInvitationControllerApiInvitationDetail

`func NewIAMInvitationControllerApiInvitationDetail() *IAMInvitationControllerApiInvitationDetail`

NewIAMInvitationControllerApiInvitationDetail instantiates a new IAMInvitationControllerApiInvitationDetail object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMInvitationControllerApiInvitationDetailWithDefaults

`func NewIAMInvitationControllerApiInvitationDetailWithDefaults() *IAMInvitationControllerApiInvitationDetail`

NewIAMInvitationControllerApiInvitationDetailWithDefaults instantiates a new IAMInvitationControllerApiInvitationDetail object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMInvitationControllerApiInvitationDetail) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMInvitationControllerApiInvitationDetail) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMInvitationControllerApiInvitationDetail) HasId() bool`

HasId returns a boolean if a field has been set.

### GetRoles

`func (o *IAMInvitationControllerApiInvitationDetail) GetRoles() []ApiRoleSummary`

GetRoles returns the Roles field if non-nil, zero value otherwise.

### GetRolesOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetRolesOk() (*[]ApiRoleSummary, bool)`

GetRolesOk returns a tuple with the Roles field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRoles

`func (o *IAMInvitationControllerApiInvitationDetail) SetRoles(v []ApiRoleSummary)`

SetRoles sets Roles field to given value.

### HasRoles

`func (o *IAMInvitationControllerApiInvitationDetail) HasRoles() bool`

HasRoles returns a boolean if a field has been set.

### GetGroups

`func (o *IAMInvitationControllerApiInvitationDetail) GetGroups() []ApiGroupSummary`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetGroupsOk() (*[]ApiGroupSummary, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMInvitationControllerApiInvitationDetail) SetGroups(v []ApiGroupSummary)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMInvitationControllerApiInvitationDetail) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetTenantId

`func (o *IAMInvitationControllerApiInvitationDetail) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *IAMInvitationControllerApiInvitationDetail) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.

### HasTenantId

`func (o *IAMInvitationControllerApiInvitationDetail) HasTenantId() bool`

HasTenantId returns a boolean if a field has been set.

### GetEmail

`func (o *IAMInvitationControllerApiInvitationDetail) GetEmail() string`

GetEmail returns the Email field if non-nil, zero value otherwise.

### GetEmailOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetEmailOk() (*string, bool)`

GetEmailOk returns a tuple with the Email field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetEmail

`func (o *IAMInvitationControllerApiInvitationDetail) SetEmail(v string)`

SetEmail sets Email field to given value.

### HasEmail

`func (o *IAMInvitationControllerApiInvitationDetail) HasEmail() bool`

HasEmail returns a boolean if a field has been set.

### GetStatus

`func (o *IAMInvitationControllerApiInvitationDetail) GetStatus() InvitationInvitationStatus`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetStatusOk() (*InvitationInvitationStatus, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *IAMInvitationControllerApiInvitationDetail) SetStatus(v InvitationInvitationStatus)`

SetStatus sets Status field to given value.

### HasStatus

`func (o *IAMInvitationControllerApiInvitationDetail) HasStatus() bool`

HasStatus returns a boolean if a field has been set.

### GetSentAt

`func (o *IAMInvitationControllerApiInvitationDetail) GetSentAt() time.Time`

GetSentAt returns the SentAt field if non-nil, zero value otherwise.

### GetSentAtOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetSentAtOk() (*time.Time, bool)`

GetSentAtOk returns a tuple with the SentAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSentAt

`func (o *IAMInvitationControllerApiInvitationDetail) SetSentAt(v time.Time)`

SetSentAt sets SentAt field to given value.

### HasSentAt

`func (o *IAMInvitationControllerApiInvitationDetail) HasSentAt() bool`

HasSentAt returns a boolean if a field has been set.

### GetExpiredAt

`func (o *IAMInvitationControllerApiInvitationDetail) GetExpiredAt() time.Time`

GetExpiredAt returns the ExpiredAt field if non-nil, zero value otherwise.

### GetExpiredAtOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetExpiredAtOk() (*time.Time, bool)`

GetExpiredAtOk returns a tuple with the ExpiredAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpiredAt

`func (o *IAMInvitationControllerApiInvitationDetail) SetExpiredAt(v time.Time)`

SetExpiredAt sets ExpiredAt field to given value.

### HasExpiredAt

`func (o *IAMInvitationControllerApiInvitationDetail) HasExpiredAt() bool`

HasExpiredAt returns a boolean if a field has been set.

### GetAcceptedAt

`func (o *IAMInvitationControllerApiInvitationDetail) GetAcceptedAt() time.Time`

GetAcceptedAt returns the AcceptedAt field if non-nil, zero value otherwise.

### GetAcceptedAtOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetAcceptedAtOk() (*time.Time, bool)`

GetAcceptedAtOk returns a tuple with the AcceptedAt field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAcceptedAt

`func (o *IAMInvitationControllerApiInvitationDetail) SetAcceptedAt(v time.Time)`

SetAcceptedAt sets AcceptedAt field to given value.

### HasAcceptedAt

`func (o *IAMInvitationControllerApiInvitationDetail) HasAcceptedAt() bool`

HasAcceptedAt returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMInvitationControllerApiInvitationDetail) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMInvitationControllerApiInvitationDetail) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMInvitationControllerApiInvitationDetail) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetLink

`func (o *IAMInvitationControllerApiInvitationDetail) GetLink() string`

GetLink returns the Link field if non-nil, zero value otherwise.

### GetLinkOk

`func (o *IAMInvitationControllerApiInvitationDetail) GetLinkOk() (*string, bool)`

GetLinkOk returns a tuple with the Link field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLink

`func (o *IAMInvitationControllerApiInvitationDetail) SetLink(v string)`

SetLink sets Link field to given value.

### HasLink

`func (o *IAMInvitationControllerApiInvitationDetail) HasLink() bool`

HasLink returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


