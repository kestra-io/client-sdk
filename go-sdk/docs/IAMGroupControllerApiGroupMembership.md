# IAMGroupControllerApiGroupMembership

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**External** | Pointer to **bool** |  | [optional] 
**Membership** | Pointer to [**GroupIdentifierMembership**](GroupIdentifierMembership.md) |  | [optional] 

## Methods

### NewIAMGroupControllerApiGroupMembership

`func NewIAMGroupControllerApiGroupMembership() *IAMGroupControllerApiGroupMembership`

NewIAMGroupControllerApiGroupMembership instantiates a new IAMGroupControllerApiGroupMembership object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMGroupControllerApiGroupMembershipWithDefaults

`func NewIAMGroupControllerApiGroupMembershipWithDefaults() *IAMGroupControllerApiGroupMembership`

NewIAMGroupControllerApiGroupMembershipWithDefaults instantiates a new IAMGroupControllerApiGroupMembership object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMGroupControllerApiGroupMembership) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMGroupControllerApiGroupMembership) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMGroupControllerApiGroupMembership) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMGroupControllerApiGroupMembership) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *IAMGroupControllerApiGroupMembership) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMGroupControllerApiGroupMembership) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMGroupControllerApiGroupMembership) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *IAMGroupControllerApiGroupMembership) HasName() bool`

HasName returns a boolean if a field has been set.

### GetExternal

`func (o *IAMGroupControllerApiGroupMembership) GetExternal() bool`

GetExternal returns the External field if non-nil, zero value otherwise.

### GetExternalOk

`func (o *IAMGroupControllerApiGroupMembership) GetExternalOk() (*bool, bool)`

GetExternalOk returns a tuple with the External field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternal

`func (o *IAMGroupControllerApiGroupMembership) SetExternal(v bool)`

SetExternal sets External field to given value.

### HasExternal

`func (o *IAMGroupControllerApiGroupMembership) HasExternal() bool`

HasExternal returns a boolean if a field has been set.

### GetMembership

`func (o *IAMGroupControllerApiGroupMembership) GetMembership() GroupIdentifierMembership`

GetMembership returns the Membership field if non-nil, zero value otherwise.

### GetMembershipOk

`func (o *IAMGroupControllerApiGroupMembership) GetMembershipOk() (*GroupIdentifierMembership, bool)`

GetMembershipOk returns a tuple with the Membership field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMembership

`func (o *IAMGroupControllerApiGroupMembership) SetMembership(v GroupIdentifierMembership)`

SetMembership sets Membership field to given value.

### HasMembership

`func (o *IAMGroupControllerApiGroupMembership) HasMembership() bool`

HasMembership returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


