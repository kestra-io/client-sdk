# UserGroup

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Value** | Pointer to **string** |  | [optional] 
**Ref** | Pointer to **string** |  | [optional] 
**Display** | Pointer to **string** |  | [optional] 
**Type** | Pointer to [**UserGroupType**](UserGroupType.md) |  | [optional] 

## Methods

### NewUserGroup

`func NewUserGroup() *UserGroup`

NewUserGroup instantiates a new UserGroup object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUserGroupWithDefaults

`func NewUserGroupWithDefaults() *UserGroup`

NewUserGroupWithDefaults instantiates a new UserGroup object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetValue

`func (o *UserGroup) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *UserGroup) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *UserGroup) SetValue(v string)`

SetValue sets Value field to given value.

### HasValue

`func (o *UserGroup) HasValue() bool`

HasValue returns a boolean if a field has been set.

### GetRef

`func (o *UserGroup) GetRef() string`

GetRef returns the Ref field if non-nil, zero value otherwise.

### GetRefOk

`func (o *UserGroup) GetRefOk() (*string, bool)`

GetRefOk returns a tuple with the Ref field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRef

`func (o *UserGroup) SetRef(v string)`

SetRef sets Ref field to given value.

### HasRef

`func (o *UserGroup) HasRef() bool`

HasRef returns a boolean if a field has been set.

### GetDisplay

`func (o *UserGroup) GetDisplay() string`

GetDisplay returns the Display field if non-nil, zero value otherwise.

### GetDisplayOk

`func (o *UserGroup) GetDisplayOk() (*string, bool)`

GetDisplayOk returns a tuple with the Display field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDisplay

`func (o *UserGroup) SetDisplay(v string)`

SetDisplay sets Display field to given value.

### HasDisplay

`func (o *UserGroup) HasDisplay() bool`

HasDisplay returns a boolean if a field has been set.

### GetType

`func (o *UserGroup) GetType() UserGroupType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *UserGroup) GetTypeOk() (*UserGroupType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *UserGroup) SetType(v UserGroupType)`

SetType sets Type field to given value.

### HasType

`func (o *UserGroup) HasType() bool`

HasType returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


