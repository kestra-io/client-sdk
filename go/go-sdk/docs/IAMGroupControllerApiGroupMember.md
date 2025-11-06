# IAMGroupControllerApiGroupMember

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Username** | Pointer to **string** |  | [optional] 
**DisplayName** | Pointer to **string** |  | [optional] 
**Groups** | Pointer to [**[]IAMGroupControllerApiGroupMembership**](IAMGroupControllerApiGroupMembership.md) |  | [optional] 

## Methods

### NewIAMGroupControllerApiGroupMember

`func NewIAMGroupControllerApiGroupMember() *IAMGroupControllerApiGroupMember`

NewIAMGroupControllerApiGroupMember instantiates a new IAMGroupControllerApiGroupMember object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMGroupControllerApiGroupMemberWithDefaults

`func NewIAMGroupControllerApiGroupMemberWithDefaults() *IAMGroupControllerApiGroupMember`

NewIAMGroupControllerApiGroupMemberWithDefaults instantiates a new IAMGroupControllerApiGroupMember object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMGroupControllerApiGroupMember) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMGroupControllerApiGroupMember) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMGroupControllerApiGroupMember) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMGroupControllerApiGroupMember) HasId() bool`

HasId returns a boolean if a field has been set.

### GetUsername

`func (o *IAMGroupControllerApiGroupMember) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *IAMGroupControllerApiGroupMember) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *IAMGroupControllerApiGroupMember) SetUsername(v string)`

SetUsername sets Username field to given value.

### HasUsername

`func (o *IAMGroupControllerApiGroupMember) HasUsername() bool`

HasUsername returns a boolean if a field has been set.

### GetDisplayName

`func (o *IAMGroupControllerApiGroupMember) GetDisplayName() string`

GetDisplayName returns the DisplayName field if non-nil, zero value otherwise.

### GetDisplayNameOk

`func (o *IAMGroupControllerApiGroupMember) GetDisplayNameOk() (*string, bool)`

GetDisplayNameOk returns a tuple with the DisplayName field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplayName

`func (o *IAMGroupControllerApiGroupMember) SetDisplayName(v string)`

SetDisplayName sets DisplayName field to given value.

### HasDisplayName

`func (o *IAMGroupControllerApiGroupMember) HasDisplayName() bool`

HasDisplayName returns a boolean if a field has been set.

### GetGroups

`func (o *IAMGroupControllerApiGroupMember) GetGroups() []IAMGroupControllerApiGroupMembership`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMGroupControllerApiGroupMember) GetGroupsOk() (*[]IAMGroupControllerApiGroupMembership, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMGroupControllerApiGroupMember) SetGroups(v []IAMGroupControllerApiGroupMembership)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMGroupControllerApiGroupMember) HasGroups() bool`

HasGroups returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


