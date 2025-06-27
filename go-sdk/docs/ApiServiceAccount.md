# ApiServiceAccount

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** | the identifier of this service account. | 
**Name** | **string** | the name of this service account. | 
**Description** | **string** | the description of this service account. | 
**GroupList** | [**[]GroupIdentifier**](GroupIdentifier.md) |  | 
**IsSuperAdmin** | **bool** |  | 

## Methods

### NewApiServiceAccount

`func NewApiServiceAccount(id string, name string, description string, groupList []GroupIdentifier, isSuperAdmin bool, ) *ApiServiceAccount`

NewApiServiceAccount instantiates a new ApiServiceAccount object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiServiceAccountWithDefaults

`func NewApiServiceAccountWithDefaults() *ApiServiceAccount`

NewApiServiceAccountWithDefaults instantiates a new ApiServiceAccount object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ApiServiceAccount) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ApiServiceAccount) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ApiServiceAccount) SetId(v string)`

SetId sets Id field to given value.


### GetName

`func (o *ApiServiceAccount) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *ApiServiceAccount) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *ApiServiceAccount) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *ApiServiceAccount) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ApiServiceAccount) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ApiServiceAccount) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetGroupList

`func (o *ApiServiceAccount) GetGroupList() []GroupIdentifier`

GetGroupList returns the GroupList field if non-nil, zero value otherwise.

### GetGroupListOk

`func (o *ApiServiceAccount) GetGroupListOk() (*[]GroupIdentifier, bool)`

GetGroupListOk returns a tuple with the GroupList field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroupList

`func (o *ApiServiceAccount) SetGroupList(v []GroupIdentifier)`

SetGroupList sets GroupList field to given value.


### GetIsSuperAdmin

`func (o *ApiServiceAccount) GetIsSuperAdmin() bool`

GetIsSuperAdmin returns the IsSuperAdmin field if non-nil, zero value otherwise.

### GetIsSuperAdminOk

`func (o *ApiServiceAccount) GetIsSuperAdminOk() (*bool, bool)`

GetIsSuperAdminOk returns a tuple with the IsSuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsSuperAdmin

`func (o *ApiServiceAccount) SetIsSuperAdmin(v bool)`

SetIsSuperAdmin sets IsSuperAdmin field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


