# IAMBindingControllerApiBindingDetail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Type** | Pointer to [**BindingType**](BindingType.md) |  | [optional] 
**Namespace** | Pointer to **NullableString** |  | [optional] 
**Role** | Pointer to [**IAMBindingControllerApiRole**](IAMBindingControllerApiRole.md) |  | [optional] 
**Group** | Pointer to [**NullableIAMBindingControllerApiBindingGroup**](IAMBindingControllerApiBindingGroup.md) |  | [optional] 
**User** | Pointer to [**NullableIAMBindingControllerApiBindingUser**](IAMBindingControllerApiBindingUser.md) |  | [optional] 

## Methods

### NewIAMBindingControllerApiBindingDetail

`func NewIAMBindingControllerApiBindingDetail() *IAMBindingControllerApiBindingDetail`

NewIAMBindingControllerApiBindingDetail instantiates a new IAMBindingControllerApiBindingDetail object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMBindingControllerApiBindingDetailWithDefaults

`func NewIAMBindingControllerApiBindingDetailWithDefaults() *IAMBindingControllerApiBindingDetail`

NewIAMBindingControllerApiBindingDetailWithDefaults instantiates a new IAMBindingControllerApiBindingDetail object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMBindingControllerApiBindingDetail) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMBindingControllerApiBindingDetail) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMBindingControllerApiBindingDetail) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMBindingControllerApiBindingDetail) HasId() bool`

HasId returns a boolean if a field has been set.

### GetType

`func (o *IAMBindingControllerApiBindingDetail) GetType() BindingType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *IAMBindingControllerApiBindingDetail) GetTypeOk() (*BindingType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *IAMBindingControllerApiBindingDetail) SetType(v BindingType)`

SetType sets Type field to given value.

### HasType

`func (o *IAMBindingControllerApiBindingDetail) HasType() bool`

HasType returns a boolean if a field has been set.

### GetNamespace

`func (o *IAMBindingControllerApiBindingDetail) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *IAMBindingControllerApiBindingDetail) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *IAMBindingControllerApiBindingDetail) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *IAMBindingControllerApiBindingDetail) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### SetNamespaceNil

`func (o *IAMBindingControllerApiBindingDetail) SetNamespaceNil(b bool)`

 SetNamespaceNil sets the value for Namespace to be an explicit nil

### UnsetNamespace
`func (o *IAMBindingControllerApiBindingDetail) UnsetNamespace()`

UnsetNamespace ensures that no value is present for Namespace, not even an explicit nil
### GetRole

`func (o *IAMBindingControllerApiBindingDetail) GetRole() IAMBindingControllerApiRole`

GetRole returns the Role field if non-nil, zero value otherwise.

### GetRoleOk

`func (o *IAMBindingControllerApiBindingDetail) GetRoleOk() (*IAMBindingControllerApiRole, bool)`

GetRoleOk returns a tuple with the Role field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRole

`func (o *IAMBindingControllerApiBindingDetail) SetRole(v IAMBindingControllerApiRole)`

SetRole sets Role field to given value.

### HasRole

`func (o *IAMBindingControllerApiBindingDetail) HasRole() bool`

HasRole returns a boolean if a field has been set.

### GetGroup

`func (o *IAMBindingControllerApiBindingDetail) GetGroup() IAMBindingControllerApiBindingGroup`

GetGroup returns the Group field if non-nil, zero value otherwise.

### GetGroupOk

`func (o *IAMBindingControllerApiBindingDetail) GetGroupOk() (*IAMBindingControllerApiBindingGroup, bool)`

GetGroupOk returns a tuple with the Group field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroup

`func (o *IAMBindingControllerApiBindingDetail) SetGroup(v IAMBindingControllerApiBindingGroup)`

SetGroup sets Group field to given value.

### HasGroup

`func (o *IAMBindingControllerApiBindingDetail) HasGroup() bool`

HasGroup returns a boolean if a field has been set.

### SetGroupNil

`func (o *IAMBindingControllerApiBindingDetail) SetGroupNil(b bool)`

 SetGroupNil sets the value for Group to be an explicit nil

### UnsetGroup
`func (o *IAMBindingControllerApiBindingDetail) UnsetGroup()`

UnsetGroup ensures that no value is present for Group, not even an explicit nil
### GetUser

`func (o *IAMBindingControllerApiBindingDetail) GetUser() IAMBindingControllerApiBindingUser`

GetUser returns the User field if non-nil, zero value otherwise.

### GetUserOk

`func (o *IAMBindingControllerApiBindingDetail) GetUserOk() (*IAMBindingControllerApiBindingUser, bool)`

GetUserOk returns a tuple with the User field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUser

`func (o *IAMBindingControllerApiBindingDetail) SetUser(v IAMBindingControllerApiBindingUser)`

SetUser sets User field to given value.

### HasUser

`func (o *IAMBindingControllerApiBindingDetail) HasUser() bool`

HasUser returns a boolean if a field has been set.

### SetUserNil

`func (o *IAMBindingControllerApiBindingDetail) SetUserNil(b bool)`

 SetUserNil sets the value for User to be an explicit nil

### UnsetUser
`func (o *IAMBindingControllerApiBindingDetail) UnsetUser()`

UnsetUser ensures that no value is present for User, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


