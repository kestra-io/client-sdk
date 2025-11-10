# IAMServiceAccountControllerApiServiceAccountRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Groups** | Pointer to [**[]IAMServiceAccountControllerApiGroup**](IAMServiceAccountControllerApiGroup.md) |  | [optional] 
**Name** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMServiceAccountControllerApiServiceAccountRequest

`func NewIAMServiceAccountControllerApiServiceAccountRequest(name string, ) *IAMServiceAccountControllerApiServiceAccountRequest`

NewIAMServiceAccountControllerApiServiceAccountRequest instantiates a new IAMServiceAccountControllerApiServiceAccountRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMServiceAccountControllerApiServiceAccountRequestWithDefaults

`func NewIAMServiceAccountControllerApiServiceAccountRequestWithDefaults() *IAMServiceAccountControllerApiServiceAccountRequest`

NewIAMServiceAccountControllerApiServiceAccountRequestWithDefaults instantiates a new IAMServiceAccountControllerApiServiceAccountRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetGroups

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetGroups() []IAMServiceAccountControllerApiGroup`

GetGroups returns the Groups field if non-nil, zero value otherwise.

### GetGroupsOk

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetGroupsOk() (*[]IAMServiceAccountControllerApiGroup, bool)`

GetGroupsOk returns a tuple with the Groups field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroups

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) SetGroups(v []IAMServiceAccountControllerApiGroup)`

SetGroups sets Groups field to given value.

### HasGroups

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) HasGroups() bool`

HasGroups returns a boolean if a field has been set.

### GetName

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountRequest) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


