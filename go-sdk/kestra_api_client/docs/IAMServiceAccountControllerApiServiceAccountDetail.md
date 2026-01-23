# IAMServiceAccountControllerApiServiceAccountDetail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | Pointer to **string** | the identifier of this service account. | [optional] 
**Name** | **string** | the name of this service account. | 
**Description** | Pointer to **string** | the description of this service account. | [optional] 
**Tenants** | Pointer to [**[]ApiTenantSummary**](ApiTenantSummary.md) |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 

## Methods

### NewIAMServiceAccountControllerApiServiceAccountDetail

`func NewIAMServiceAccountControllerApiServiceAccountDetail(name string, ) *IAMServiceAccountControllerApiServiceAccountDetail`

NewIAMServiceAccountControllerApiServiceAccountDetail instantiates a new IAMServiceAccountControllerApiServiceAccountDetail object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMServiceAccountControllerApiServiceAccountDetailWithDefaults

`func NewIAMServiceAccountControllerApiServiceAccountDetailWithDefaults() *IAMServiceAccountControllerApiServiceAccountDetail`

NewIAMServiceAccountControllerApiServiceAccountDetailWithDefaults instantiates a new IAMServiceAccountControllerApiServiceAccountDetail object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetTenants

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetTenants() []ApiTenantSummary`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetTenantsOk() (*[]ApiTenantSummary, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) SetTenants(v []ApiTenantSummary)`

SetTenants sets Tenants field to given value.

### HasTenants

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) HasTenants() bool`

HasTenants returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMServiceAccountControllerApiServiceAccountDetail) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


