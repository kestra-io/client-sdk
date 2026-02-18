# UsernamePasswordCredentials

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Username** | **NullableString** |  | 
**Password** | **NullableString** |  | 
**Identity** | Pointer to **NullableString** |  | [optional] 
**Secret** | Pointer to **NullableString** |  | [optional] 

## Methods

### NewUsernamePasswordCredentials

`func NewUsernamePasswordCredentials(username NullableString, password NullableString, ) *UsernamePasswordCredentials`

NewUsernamePasswordCredentials instantiates a new UsernamePasswordCredentials object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewUsernamePasswordCredentialsWithDefaults

`func NewUsernamePasswordCredentialsWithDefaults() *UsernamePasswordCredentials`

NewUsernamePasswordCredentialsWithDefaults instantiates a new UsernamePasswordCredentials object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetUsername

`func (o *UsernamePasswordCredentials) GetUsername() string`

GetUsername returns the Username field if non-nil, zero value otherwise.

### GetUsernameOk

`func (o *UsernamePasswordCredentials) GetUsernameOk() (*string, bool)`

GetUsernameOk returns a tuple with the Username field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetUsername

`func (o *UsernamePasswordCredentials) SetUsername(v string)`

SetUsername sets Username field to given value.


### SetUsernameNil

`func (o *UsernamePasswordCredentials) SetUsernameNil(b bool)`

 SetUsernameNil sets the value for Username to be an explicit nil

### UnsetUsername
`func (o *UsernamePasswordCredentials) UnsetUsername()`

UnsetUsername ensures that no value is present for Username, not even an explicit nil
### GetPassword

`func (o *UsernamePasswordCredentials) GetPassword() string`

GetPassword returns the Password field if non-nil, zero value otherwise.

### GetPasswordOk

`func (o *UsernamePasswordCredentials) GetPasswordOk() (*string, bool)`

GetPasswordOk returns a tuple with the Password field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPassword

`func (o *UsernamePasswordCredentials) SetPassword(v string)`

SetPassword sets Password field to given value.


### SetPasswordNil

`func (o *UsernamePasswordCredentials) SetPasswordNil(b bool)`

 SetPasswordNil sets the value for Password to be an explicit nil

### UnsetPassword
`func (o *UsernamePasswordCredentials) UnsetPassword()`

UnsetPassword ensures that no value is present for Password, not even an explicit nil
### GetIdentity

`func (o *UsernamePasswordCredentials) GetIdentity() string`

GetIdentity returns the Identity field if non-nil, zero value otherwise.

### GetIdentityOk

`func (o *UsernamePasswordCredentials) GetIdentityOk() (*string, bool)`

GetIdentityOk returns a tuple with the Identity field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIdentity

`func (o *UsernamePasswordCredentials) SetIdentity(v string)`

SetIdentity sets Identity field to given value.

### HasIdentity

`func (o *UsernamePasswordCredentials) HasIdentity() bool`

HasIdentity returns a boolean if a field has been set.

### SetIdentityNil

`func (o *UsernamePasswordCredentials) SetIdentityNil(b bool)`

 SetIdentityNil sets the value for Identity to be an explicit nil

### UnsetIdentity
`func (o *UsernamePasswordCredentials) UnsetIdentity()`

UnsetIdentity ensures that no value is present for Identity, not even an explicit nil
### GetSecret

`func (o *UsernamePasswordCredentials) GetSecret() string`

GetSecret returns the Secret field if non-nil, zero value otherwise.

### GetSecretOk

`func (o *UsernamePasswordCredentials) GetSecretOk() (*string, bool)`

GetSecretOk returns a tuple with the Secret field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetSecret

`func (o *UsernamePasswordCredentials) SetSecret(v string)`

SetSecret sets Secret field to given value.

### HasSecret

`func (o *UsernamePasswordCredentials) HasSecret() bool`

HasSecret returns a boolean if a field has been set.

### SetSecretNil

`func (o *UsernamePasswordCredentials) SetSecretNil(b bool)`

 SetSecretNil sets the value for Secret to be an explicit nil

### UnsetSecret
`func (o *UsernamePasswordCredentials) UnsetSecret()`

UnsetSecret ensures that no value is present for Secret, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


