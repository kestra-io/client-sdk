# AuthControllerAuth

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**LoginPassword** | Pointer to **bool** |  | [optional] 
**MailsEnabled** | Pointer to **bool** |  | [optional] 
**Passwordless** | Pointer to **bool** |  | [optional] 
**Oauths** | Pointer to **[]string** |  | [optional] 

## Methods

### NewAuthControllerAuth

`func NewAuthControllerAuth() *AuthControllerAuth`

NewAuthControllerAuth instantiates a new AuthControllerAuth object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAuthControllerAuthWithDefaults

`func NewAuthControllerAuthWithDefaults() *AuthControllerAuth`

NewAuthControllerAuthWithDefaults instantiates a new AuthControllerAuth object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetLoginPassword

`func (o *AuthControllerAuth) GetLoginPassword() bool`

GetLoginPassword returns the LoginPassword field if non-nil, zero value otherwise.

### GetLoginPasswordOk

`func (o *AuthControllerAuth) GetLoginPasswordOk() (*bool, bool)`

GetLoginPasswordOk returns a tuple with the LoginPassword field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLoginPassword

`func (o *AuthControllerAuth) SetLoginPassword(v bool)`

SetLoginPassword sets LoginPassword field to given value.

### HasLoginPassword

`func (o *AuthControllerAuth) HasLoginPassword() bool`

HasLoginPassword returns a boolean if a field has been set.

### GetMailsEnabled

`func (o *AuthControllerAuth) GetMailsEnabled() bool`

GetMailsEnabled returns the MailsEnabled field if non-nil, zero value otherwise.

### GetMailsEnabledOk

`func (o *AuthControllerAuth) GetMailsEnabledOk() (*bool, bool)`

GetMailsEnabledOk returns a tuple with the MailsEnabled field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMailsEnabled

`func (o *AuthControllerAuth) SetMailsEnabled(v bool)`

SetMailsEnabled sets MailsEnabled field to given value.

### HasMailsEnabled

`func (o *AuthControllerAuth) HasMailsEnabled() bool`

HasMailsEnabled returns a boolean if a field has been set.

### GetPasswordless

`func (o *AuthControllerAuth) GetPasswordless() bool`

GetPasswordless returns the Passwordless field if non-nil, zero value otherwise.

### GetPasswordlessOk

`func (o *AuthControllerAuth) GetPasswordlessOk() (*bool, bool)`

GetPasswordlessOk returns a tuple with the Passwordless field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPasswordless

`func (o *AuthControllerAuth) SetPasswordless(v bool)`

SetPasswordless sets Passwordless field to given value.

### HasPasswordless

`func (o *AuthControllerAuth) HasPasswordless() bool`

HasPasswordless returns a boolean if a field has been set.

### GetOauths

`func (o *AuthControllerAuth) GetOauths() []string`

GetOauths returns the Oauths field if non-nil, zero value otherwise.

### GetOauthsOk

`func (o *AuthControllerAuth) GetOauthsOk() (*[]string, bool)`

GetOauthsOk returns a tuple with the Oauths field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOauths

`func (o *AuthControllerAuth) SetOauths(v []string)`

SetOauths sets Oauths field to given value.

### HasOauths

`func (o *AuthControllerAuth) HasOauths() bool`

HasOauths returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


