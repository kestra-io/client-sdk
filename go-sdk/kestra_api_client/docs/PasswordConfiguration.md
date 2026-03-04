# PasswordConfiguration

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**PasswordMinLength** | Pointer to **int32** |  | [optional] [default to 8]
**PasswordRequireSpecial** | Pointer to **bool** |  | [optional] [default to true]
**PasswordMinDigits** | Pointer to **int32** |  | [optional] [default to 1]
**PasswordMinLowerCase** | Pointer to **int32** |  | [optional] [default to 1]
**PasswordMinUpperCase** | Pointer to **int32** |  | [optional] [default to 1]
**PasswordAllowedSpecialCharacters** | Pointer to **string** |  | [optional] [default to "!@#$%^&*"]
**PasswordReset** | Pointer to [**PasswordConfigurationPasswordReset**](PasswordConfigurationPasswordReset.md) |  | [optional] 

## Methods

### NewPasswordConfiguration

`func NewPasswordConfiguration() *PasswordConfiguration`

NewPasswordConfiguration instantiates a new PasswordConfiguration object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPasswordConfigurationWithDefaults

`func NewPasswordConfigurationWithDefaults() *PasswordConfiguration`

NewPasswordConfigurationWithDefaults instantiates a new PasswordConfiguration object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetPasswordMinLength

`func (o *PasswordConfiguration) GetPasswordMinLength() int32`

GetPasswordMinLength returns the PasswordMinLength field if non-nil, zero value otherwise.

### GetPasswordMinLengthOk

`func (o *PasswordConfiguration) GetPasswordMinLengthOk() (*int32, bool)`

GetPasswordMinLengthOk returns a tuple with the PasswordMinLength field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordMinLength

`func (o *PasswordConfiguration) SetPasswordMinLength(v int32)`

SetPasswordMinLength sets PasswordMinLength field to given value.

### HasPasswordMinLength

`func (o *PasswordConfiguration) HasPasswordMinLength() bool`

HasPasswordMinLength returns a boolean if a field has been set.

### GetPasswordRequireSpecial

`func (o *PasswordConfiguration) GetPasswordRequireSpecial() bool`

GetPasswordRequireSpecial returns the PasswordRequireSpecial field if non-nil, zero value otherwise.

### GetPasswordRequireSpecialOk

`func (o *PasswordConfiguration) GetPasswordRequireSpecialOk() (*bool, bool)`

GetPasswordRequireSpecialOk returns a tuple with the PasswordRequireSpecial field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordRequireSpecial

`func (o *PasswordConfiguration) SetPasswordRequireSpecial(v bool)`

SetPasswordRequireSpecial sets PasswordRequireSpecial field to given value.

### HasPasswordRequireSpecial

`func (o *PasswordConfiguration) HasPasswordRequireSpecial() bool`

HasPasswordRequireSpecial returns a boolean if a field has been set.

### GetPasswordMinDigits

`func (o *PasswordConfiguration) GetPasswordMinDigits() int32`

GetPasswordMinDigits returns the PasswordMinDigits field if non-nil, zero value otherwise.

### GetPasswordMinDigitsOk

`func (o *PasswordConfiguration) GetPasswordMinDigitsOk() (*int32, bool)`

GetPasswordMinDigitsOk returns a tuple with the PasswordMinDigits field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordMinDigits

`func (o *PasswordConfiguration) SetPasswordMinDigits(v int32)`

SetPasswordMinDigits sets PasswordMinDigits field to given value.

### HasPasswordMinDigits

`func (o *PasswordConfiguration) HasPasswordMinDigits() bool`

HasPasswordMinDigits returns a boolean if a field has been set.

### GetPasswordMinLowerCase

`func (o *PasswordConfiguration) GetPasswordMinLowerCase() int32`

GetPasswordMinLowerCase returns the PasswordMinLowerCase field if non-nil, zero value otherwise.

### GetPasswordMinLowerCaseOk

`func (o *PasswordConfiguration) GetPasswordMinLowerCaseOk() (*int32, bool)`

GetPasswordMinLowerCaseOk returns a tuple with the PasswordMinLowerCase field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordMinLowerCase

`func (o *PasswordConfiguration) SetPasswordMinLowerCase(v int32)`

SetPasswordMinLowerCase sets PasswordMinLowerCase field to given value.

### HasPasswordMinLowerCase

`func (o *PasswordConfiguration) HasPasswordMinLowerCase() bool`

HasPasswordMinLowerCase returns a boolean if a field has been set.

### GetPasswordMinUpperCase

`func (o *PasswordConfiguration) GetPasswordMinUpperCase() int32`

GetPasswordMinUpperCase returns the PasswordMinUpperCase field if non-nil, zero value otherwise.

### GetPasswordMinUpperCaseOk

`func (o *PasswordConfiguration) GetPasswordMinUpperCaseOk() (*int32, bool)`

GetPasswordMinUpperCaseOk returns a tuple with the PasswordMinUpperCase field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordMinUpperCase

`func (o *PasswordConfiguration) SetPasswordMinUpperCase(v int32)`

SetPasswordMinUpperCase sets PasswordMinUpperCase field to given value.

### HasPasswordMinUpperCase

`func (o *PasswordConfiguration) HasPasswordMinUpperCase() bool`

HasPasswordMinUpperCase returns a boolean if a field has been set.

### GetPasswordAllowedSpecialCharacters

`func (o *PasswordConfiguration) GetPasswordAllowedSpecialCharacters() string`

GetPasswordAllowedSpecialCharacters returns the PasswordAllowedSpecialCharacters field if non-nil, zero value otherwise.

### GetPasswordAllowedSpecialCharactersOk

`func (o *PasswordConfiguration) GetPasswordAllowedSpecialCharactersOk() (*string, bool)`

GetPasswordAllowedSpecialCharactersOk returns a tuple with the PasswordAllowedSpecialCharacters field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordAllowedSpecialCharacters

`func (o *PasswordConfiguration) SetPasswordAllowedSpecialCharacters(v string)`

SetPasswordAllowedSpecialCharacters sets PasswordAllowedSpecialCharacters field to given value.

### HasPasswordAllowedSpecialCharacters

`func (o *PasswordConfiguration) HasPasswordAllowedSpecialCharacters() bool`

HasPasswordAllowedSpecialCharacters returns a boolean if a field has been set.

### GetPasswordReset

`func (o *PasswordConfiguration) GetPasswordReset() PasswordConfigurationPasswordReset`

GetPasswordReset returns the PasswordReset field if non-nil, zero value otherwise.

### GetPasswordResetOk

`func (o *PasswordConfiguration) GetPasswordResetOk() (*PasswordConfigurationPasswordReset, bool)`

GetPasswordResetOk returns a tuple with the PasswordReset field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordReset

`func (o *PasswordConfiguration) SetPasswordReset(v PasswordConfigurationPasswordReset)`

SetPasswordReset sets PasswordReset field to given value.

### HasPasswordReset

`func (o *PasswordConfiguration) HasPasswordReset() bool`

HasPasswordReset returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


