# Binding

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** |  | [optional] 
**Type** | [**BindingType**](BindingType.md) |  | 
**ExternalId** | **string** |  | 
**RoleId** | **string** |  | 
**NamespaceId** | Pointer to **string** |  | [optional] 
**Deleted** | **bool** |  | 

## Methods

### NewBinding

`func NewBinding(type_ BindingType, externalId string, roleId string, deleted bool, ) *Binding`

NewBinding instantiates a new Binding object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBindingWithDefaults

`func NewBindingWithDefaults() *Binding`

NewBindingWithDefaults instantiates a new Binding object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *Binding) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *Binding) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *Binding) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *Binding) HasId() bool`

HasId returns a boolean if a field has been set.

### GetType

`func (o *Binding) GetType() BindingType`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *Binding) GetTypeOk() (*BindingType, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *Binding) SetType(v BindingType)`

SetType sets Type field to given value.


### GetExternalId

`func (o *Binding) GetExternalId() string`

GetExternalId returns the ExternalId field if non-nil, zero value otherwise.

### GetExternalIdOk

`func (o *Binding) GetExternalIdOk() (*string, bool)`

GetExternalIdOk returns a tuple with the ExternalId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExternalId

`func (o *Binding) SetExternalId(v string)`

SetExternalId sets ExternalId field to given value.


### GetRoleId

`func (o *Binding) GetRoleId() string`

GetRoleId returns the RoleId field if non-nil, zero value otherwise.

### GetRoleIdOk

`func (o *Binding) GetRoleIdOk() (*string, bool)`

GetRoleIdOk returns a tuple with the RoleId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRoleId

`func (o *Binding) SetRoleId(v string)`

SetRoleId sets RoleId field to given value.


### GetNamespaceId

`func (o *Binding) GetNamespaceId() string`

GetNamespaceId returns the NamespaceId field if non-nil, zero value otherwise.

### GetNamespaceIdOk

`func (o *Binding) GetNamespaceIdOk() (*string, bool)`

GetNamespaceIdOk returns a tuple with the NamespaceId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespaceId

`func (o *Binding) SetNamespaceId(v string)`

SetNamespaceId sets NamespaceId field to given value.

### HasNamespaceId

`func (o *Binding) HasNamespaceId() bool`

HasNamespaceId returns a boolean if a field has been set.

### GetDeleted

`func (o *Binding) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *Binding) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *Binding) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.



[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


