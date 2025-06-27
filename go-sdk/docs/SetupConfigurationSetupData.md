# SetupConfigurationSetupData

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Username** | **string** |  | 
**Password** | **string** |  | 
**Tenant** | [**Tenant**](Tenant.md) |  | 

## Methods

### NewSetupConfigurationSetupData

`func NewSetupConfigurationSetupData(username string, password string, tenant Tenant, ) *SetupConfigurationSetupData`

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



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


