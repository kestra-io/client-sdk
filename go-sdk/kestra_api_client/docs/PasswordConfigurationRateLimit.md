# PasswordConfigurationRateLimit

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**MaxRequests** | Pointer to **int32** |  | [optional] [default to 10]
**Window** | Pointer to **string** |  | [optional] [default to "PT1H"]

## Methods

### NewPasswordConfigurationRateLimit

`func NewPasswordConfigurationRateLimit() *PasswordConfigurationRateLimit`

NewPasswordConfigurationRateLimit instantiates a new PasswordConfigurationRateLimit object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPasswordConfigurationRateLimitWithDefaults

`func NewPasswordConfigurationRateLimitWithDefaults() *PasswordConfigurationRateLimit`

NewPasswordConfigurationRateLimitWithDefaults instantiates a new PasswordConfigurationRateLimit object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetMaxRequests

`func (o *PasswordConfigurationRateLimit) GetMaxRequests() int32`

GetMaxRequests returns the MaxRequests field if non-nil, zero value otherwise.

### GetMaxRequestsOk

`func (o *PasswordConfigurationRateLimit) GetMaxRequestsOk() (*int32, bool)`

GetMaxRequestsOk returns a tuple with the MaxRequests field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMaxRequests

`func (o *PasswordConfigurationRateLimit) SetMaxRequests(v int32)`

SetMaxRequests sets MaxRequests field to given value.

### HasMaxRequests

`func (o *PasswordConfigurationRateLimit) HasMaxRequests() bool`

HasMaxRequests returns a boolean if a field has been set.

### GetWindow

`func (o *PasswordConfigurationRateLimit) GetWindow() string`

GetWindow returns the Window field if non-nil, zero value otherwise.

### GetWindowOk

`func (o *PasswordConfigurationRateLimit) GetWindowOk() (*string, bool)`

GetWindowOk returns a tuple with the Window field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWindow

`func (o *PasswordConfigurationRateLimit) SetWindow(v string)`

SetWindow sets Window field to given value.

### HasWindow

`func (o *PasswordConfigurationRateLimit) HasWindow() bool`

HasWindow returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


