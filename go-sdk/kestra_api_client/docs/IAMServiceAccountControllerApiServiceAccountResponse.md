# IAMServiceAccountControllerApiServiceAccountResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** | the identifier of this service account. | [optional] 
**Name** | **string** | the name of this service account. | 
**Description** | Pointer to **string** | the description of this service account. | [optional] 
**Groups** | Pointer to [**[]IAMServiceAccountControllerApiGroup**](IAMServiceAccountControllerApiGroup.md) |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMServiceAccountControllerApiServiceAccountResponse

`func NewIAMServiceAccountControllerApiServiceAccountResponse(name string, ) *IAMServiceAccountControllerApiServiceAccountResponse`

NewIAMServiceAccountControllerApiServiceAccountResponse instantiates a new IAMServiceAccountControllerApiServiceAccountResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMServiceAccountControllerApiServiceAccountResponseWithDefaults

`func NewIAMServiceAccountControllerApiServiceAccountResponseWithDefaults() *IAMServiceAccountControllerApiServiceAccountResponse`

NewIAMServiceAccountControllerApiServiceAccountResponseWithDefaults instantiates a new IAMServiceAccountControllerApiServiceAccountResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetGroups

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetGroups() []IAMServiceAccountControllerApiGroup`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetGroupsOk() (*[]IAMServiceAccountControllerApiGroup, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) SetGroups(v []IAMServiceAccountControllerApiGroup)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountResponse) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


