# IAMBindingControllerApiCreateBindingRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Type** | [**BindingType**](BindingType.md) |  | 
**ExternalId** | **string** |  | 
**RoleId** | **string** |  | 
**NamespaceId** | Pointer to **NullableString** |  | [optional] 

## Methods

### NewIAMBindingControllerApiCreateBindingRequest

`func NewIAMBindingControllerApiCreateBindingRequest(type_ BindingType, externalId string, roleId string, ) *IAMBindingControllerApiCreateBindingRequest`

NewIAMBindingControllerApiCreateBindingRequest instantiates a new IAMBindingControllerApiCreateBindingRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMBindingControllerApiCreateBindingRequestWithDefaults

`func NewIAMBindingControllerApiCreateBindingRequestWithDefaults() *IAMBindingControllerApiCreateBindingRequest`

NewIAMBindingControllerApiCreateBindingRequestWithDefaults instantiates a new IAMBindingControllerApiCreateBindingRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetType

`func (o *IAMBindingControllerApiCreateBindingRequest) GetType() BindingType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *IAMBindingControllerApiCreateBindingRequest) GetTypeOk() (*BindingType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *IAMBindingControllerApiCreateBindingRequest) SetType(v BindingType)`

SetType sets Type field to given value.


### GetExternalId

`func (o *IAMBindingControllerApiCreateBindingRequest) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *IAMBindingControllerApiCreateBindingRequest) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *IAMBindingControllerApiCreateBindingRequest) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.


### GetRoleId

`func (o *IAMBindingControllerApiCreateBindingRequest) GetRoleId() string`

GetRoleId returns the RoleId field if non-nil, zero value otherwise.

### GetRoleIdOk

`func (o *IAMBindingControllerApiCreateBindingRequest) GetRoleIdOk() (*string, bool)`

GetRoleIdOk returns a tuple with the RoleId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRoleId

`func (o *IAMBindingControllerApiCreateBindingRequest) SetRoleId(v string)`

SetRoleId sets RoleId field to given value.


### GetNamespaceId

`func (o *IAMBindingControllerApiCreateBindingRequest) GetNamespaceId() string`

GetNamespaceId returns the NamespaceId field if non-nil, zero value otherwise.

### GetNamespaceIdOk

`func (o *IAMBindingControllerApiCreateBindingRequest) GetNamespaceIdOk() (*string, bool)`

GetNamespaceIdOk returns a tuple with the NamespaceId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespaceId

`func (o *IAMBindingControllerApiCreateBindingRequest) SetNamespaceId(v string)`

SetNamespaceId sets NamespaceId field to given value.

### HasNamespaceId

`func (o *IAMBindingControllerApiCreateBindingRequest) HasNamespaceId() bool`

HasNamespaceId returns a boolean if a field has been set.

### SetNamespaceIdNil

`func (o *IAMBindingControllerApiCreateBindingRequest) SetNamespaceIdNil(b bool)`

 SetNamespaceIdNil sets the value for NamespaceId to be an explicit nil

### UnsetNamespaceId
`func (o *IAMBindingControllerApiCreateBindingRequest) UnsetNamespaceId()`

UnsetNamespaceId ensures that no value is present for NamespaceId, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


