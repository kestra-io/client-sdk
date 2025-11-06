# IAMServiceAccountControllerApiCreateServiceAccountRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**SuperAdmin** | Pointer to **bool** |  | [optional] 
**Tenants** | Pointer to **[]string** |  | [optional] 

## Methods

### NewIAMServiceAccountControllerApiCreateServiceAccountRequest

`func NewIAMServiceAccountControllerApiCreateServiceAccountRequest(name string, ) *IAMServiceAccountControllerApiCreateServiceAccountRequest`

NewIAMServiceAccountControllerApiCreateServiceAccountRequest instantiates a new IAMServiceAccountControllerApiCreateServiceAccountRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewIAMServiceAccountControllerApiCreateServiceAccountRequestWithDefaults

`func NewIAMServiceAccountControllerApiCreateServiceAccountRequestWithDefaults() *IAMServiceAccountControllerApiCreateServiceAccountRequest`

NewIAMServiceAccountControllerApiCreateServiceAccountRequestWithDefaults instantiates a new IAMServiceAccountControllerApiCreateServiceAccountRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetSuperAdmin

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetSuperAdmin() bool`

GetSuperAdmin returns the SuperAdmin field if non-nil, zero value otherwise.

### GetSuperAdminOk

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetSuperAdminOk() (*bool, bool)`

GetSuperAdminOk returns a tuple with the SuperAdmin field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSuperAdmin

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) SetSuperAdmin(v bool)`

SetSuperAdmin sets SuperAdmin field to given value.

### HasSuperAdmin

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) HasSuperAdmin() bool`

HasSuperAdmin returns a boolean if a field has been set.

### GetTenants

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetTenants() []string`

GetTenants returns the Tenants field if non-nil, zero value otherwise.

### GetTenantsOk

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) GetTenantsOk() (*[]string, bool)`

GetTenantsOk returns a tuple with the Tenants field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenants

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) SetTenants(v []string)`

SetTenants sets Tenants field to given value.

### HasTenants

`func (o *IAMServiceAccountControllerApiCreateServiceAccountRequest) HasTenants() bool`

HasTenants returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


