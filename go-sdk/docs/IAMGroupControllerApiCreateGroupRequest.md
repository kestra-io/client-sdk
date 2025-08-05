# IAMGroupControllerApiCreateGroupRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**MembersId** | Pointer to **[]string** |  | [optional] 

## Methods

### NewIAMGroupControllerApiCreateGroupRequest

`func NewIAMGroupControllerApiCreateGroupRequest(name string, ) *IAMGroupControllerApiCreateGroupRequest`

NewIAMGroupControllerApiCreateGroupRequest instantiates a new IAMGroupControllerApiCreateGroupRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMGroupControllerApiCreateGroupRequestWithDefaults

`func NewIAMGroupControllerApiCreateGroupRequestWithDefaults() *IAMGroupControllerApiCreateGroupRequest`

NewIAMGroupControllerApiCreateGroupRequestWithDefaults instantiates a new IAMGroupControllerApiCreateGroupRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *IAMGroupControllerApiCreateGroupRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMGroupControllerApiCreateGroupRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMGroupControllerApiCreateGroupRequest) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *IAMGroupControllerApiCreateGroupRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMGroupControllerApiCreateGroupRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMGroupControllerApiCreateGroupRequest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMGroupControllerApiCreateGroupRequest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetMembersId

`func (o *IAMGroupControllerApiCreateGroupRequest) GetMembersId() []string`

GetMembersId returns the MembersId field if non-nil, zero value otherwise.

### GetMembersIdOk

`func (o *IAMGroupControllerApiCreateGroupRequest) GetMembersIdOk() (*[]string, bool)`

GetMembersIdOk returns a tuple with the MembersId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMembersId

`func (o *IAMGroupControllerApiCreateGroupRequest) SetMembersId(v []string)`

SetMembersId sets MembersId field to given value.

### HasMembersId

`func (o *IAMGroupControllerApiCreateGroupRequest) HasMembersId() bool`

HasMembersId returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


