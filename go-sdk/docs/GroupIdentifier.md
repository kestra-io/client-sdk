# GroupIdentifier

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**TenantId** | **NullableString** |  | 
**GroupId** | **string** |  | 
**Membership** | [**GroupIdentifierMembership**](GroupIdentifierMembership.md) |  | 
**ManagedExternally** | **bool** |  | 

## Methods

### NewGroupIdentifier

`func NewGroupIdentifier(tenantId NullableString, groupId string, membership GroupIdentifierMembership, managedExternally bool, ) *GroupIdentifier`

NewGroupIdentifier instantiates a new GroupIdentifier object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewGroupIdentifierWithDefaults

`func NewGroupIdentifierWithDefaults() *GroupIdentifier`

NewGroupIdentifierWithDefaults instantiates a new GroupIdentifier object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTenantId

`func (o *GroupIdentifier) GetTenantId() string`

GetTenantId returns the TenantId field if non-nil, zero value otherwise.

### GetTenantIdOk

`func (o *GroupIdentifier) GetTenantIdOk() (*string, bool)`

GetTenantIdOk returns a tuple with the TenantId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenantId

`func (o *GroupIdentifier) SetTenantId(v string)`

SetTenantId sets TenantId field to given value.


### SetTenantIdNil

`func (o *GroupIdentifier) SetTenantIdNil(b bool)`

 SetTenantIdNil sets the value for TenantId to be an explicit nil

### UnsetTenantId
`func (o *GroupIdentifier) UnsetTenantId()`

UnsetTenantId ensures that no value is present for TenantId, not even an explicit nil
### GetGroupId

`func (o *GroupIdentifier) GetGroupId() string`

GetGroupId returns the GroupId field if non-nil, zero value otherwise.

### GetGroupIdOk

`func (o *GroupIdentifier) GetGroupIdOk() (*string, bool)`

GetGroupIdOk returns a tuple with the GroupId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroupId

`func (o *GroupIdentifier) SetGroupId(v string)`

SetGroupId sets GroupId field to given value.


### GetMembership

`func (o *GroupIdentifier) GetMembership() GroupIdentifierMembership`

GetMembership returns the Membership field if non-nil, zero value otherwise.

### GetMembershipOk

`func (o *GroupIdentifier) GetMembershipOk() (*GroupIdentifierMembership, bool)`

GetMembershipOk returns a tuple with the Membership field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMembership

`func (o *GroupIdentifier) SetMembership(v GroupIdentifierMembership)`

SetMembership sets Membership field to given value.


### GetManagedExternally

`func (o *GroupIdentifier) GetManagedExternally() bool`

GetManagedExternally returns the ManagedExternally field if non-nil, zero value otherwise.

### GetManagedExternallyOk

`func (o *GroupIdentifier) GetManagedExternallyOk() (*bool, bool)`

GetManagedExternallyOk returns a tuple with the ManagedExternally field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetManagedExternally

`func (o *GroupIdentifier) SetManagedExternally(v bool)`

SetManagedExternally sets ManagedExternally field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


