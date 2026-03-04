# PasswordConfigurationPasswordReset

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Cooldown** | Pointer to **string** |  | [optional] [default to "PT5M"]
**RateLimit** | Pointer to [**PasswordConfigurationRateLimit**](PasswordConfigurationRateLimit.md) |  | [optional] 

## Methods

### NewPasswordConfigurationPasswordReset

`func NewPasswordConfigurationPasswordReset() *PasswordConfigurationPasswordReset`

NewPasswordConfigurationPasswordReset instantiates a new PasswordConfigurationPasswordReset object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPasswordConfigurationPasswordResetWithDefaults

`func NewPasswordConfigurationPasswordResetWithDefaults() *PasswordConfigurationPasswordReset`

NewPasswordConfigurationPasswordResetWithDefaults instantiates a new PasswordConfigurationPasswordReset object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetCooldown

`func (o *PasswordConfigurationPasswordReset) GetCooldown() string`

GetCooldown returns the Cooldown field if non-nil, zero value otherwise.

### GetCooldownOk

`func (o *PasswordConfigurationPasswordReset) GetCooldownOk() (*string, bool)`

GetCooldownOk returns a tuple with the Cooldown field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCooldown

`func (o *PasswordConfigurationPasswordReset) SetCooldown(v string)`

SetCooldown sets Cooldown field to given value.

### HasCooldown

`func (o *PasswordConfigurationPasswordReset) HasCooldown() bool`

HasCooldown returns a boolean if a field has been set.

### GetRateLimit

`func (o *PasswordConfigurationPasswordReset) GetRateLimit() PasswordConfigurationRateLimit`

GetRateLimit returns the RateLimit field if non-nil, zero value otherwise.

### GetRateLimitOk

`func (o *PasswordConfigurationPasswordReset) GetRateLimitOk() (*PasswordConfigurationRateLimit, bool)`

GetRateLimitOk returns a tuple with the RateLimit field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRateLimit

`func (o *PasswordConfigurationPasswordReset) SetRateLimit(v PasswordConfigurationRateLimit)`

SetRateLimit sets RateLimit field to given value.

### HasRateLimit

`func (o *PasswordConfigurationPasswordReset) HasRateLimit() bool`

HasRateLimit returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


