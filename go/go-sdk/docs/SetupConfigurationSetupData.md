# SetupConfigurationSetupData

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Username** | Pointer to **string** |  | [optional] 
**Password** | Pointer to **string** |  | [optional] 
**Tenant** | Pointer to [**Tenant**](Tenant.md) |  | [optional] 

## Methods

### NewSetupConfigurationSetupData

`func NewSetupConfigurationSetupData() *SetupConfigurationSetupData`

NewSetupConfigurationSetupData instantiates a new SetupConfigurationSetupData object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewSetupConfigurationSetupDataWithDefaults

`func NewSetupConfigurationSetupDataWithDefaults() *SetupConfigurationSetupData`

NewSetupConfigurationSetupDataWithDefaults instantiates a new SetupConfigurationSetupData object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUsername

`func (o *SetupConfigurationSetupData) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *SetupConfigurationSetupData) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *SetupConfigurationSetupData) SetUsername(v string)`

SetUsername sets Username field to given value.

### HasUsername

`func (o *SetupConfigurationSetupData) HasUsername() bool`

HasUsername returns a boolean if a field has been set.

### GetPassword

`func (o *SetupConfigurationSetupData) GetPassword() string`

GetPassword returns the Password field if non-nil, zero value otherwise.

### GetPasswordOk

`func (o *SetupConfigurationSetupData) GetPasswordOk() (*string, bool)`

GetPasswordOk returns a tuple with the Password field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPassword

`func (o *SetupConfigurationSetupData) SetPassword(v string)`

SetPassword sets Password field to given value.

### HasPassword

`func (o *SetupConfigurationSetupData) HasPassword() bool`

HasPassword returns a boolean if a field has been set.

### GetTenant

`func (o *SetupConfigurationSetupData) GetTenant() Tenant`

GetTenant returns the Tenant field if non-nil, zero value otherwise.

### GetTenantOk

`func (o *SetupConfigurationSetupData) GetTenantOk() (*Tenant, bool)`

GetTenantOk returns a tuple with the Tenant field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTenant

`func (o *SetupConfigurationSetupData) SetTenant(v Tenant)`

SetTenant sets Tenant field to given value.

### HasTenant

`func (o *SetupConfigurationSetupData) HasTenant() bool`

HasTenant returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


