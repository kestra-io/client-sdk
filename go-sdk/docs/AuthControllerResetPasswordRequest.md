# AuthControllerResetPasswordRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Token** | **string** |  | 
**Password** | **string** |  | 

## Methods

### NewAuthControllerResetPasswordRequest

`func NewAuthControllerResetPasswordRequest(token string, password string, ) *AuthControllerResetPasswordRequest`

NewAuthControllerResetPasswordRequest instantiates a new AuthControllerResetPasswordRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAuthControllerResetPasswordRequestWithDefaults

`func NewAuthControllerResetPasswordRequestWithDefaults() *AuthControllerResetPasswordRequest`

NewAuthControllerResetPasswordRequestWithDefaults instantiates a new AuthControllerResetPasswordRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetToken

`func (o *AuthControllerResetPasswordRequest) GetToken() string`

GetToken returns the Token field if non-nil, zero value otherwise.

### GetTokenOk

`func (o *AuthControllerResetPasswordRequest) GetTokenOk() (*string, bool)`

GetTokenOk returns a tuple with the Token field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetToken

`func (o *AuthControllerResetPasswordRequest) SetToken(v string)`

SetToken sets Token field to given value.


### GetPassword

`func (o *AuthControllerResetPasswordRequest) GetPassword() string`

GetPassword returns the Password field if non-nil, zero value otherwise.

### GetPasswordOk

`func (o *AuthControllerResetPasswordRequest) GetPasswordOk() (*string, bool)`

GetPasswordOk returns a tuple with the Password field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetPassword

`func (o *AuthControllerResetPasswordRequest) SetPassword(v string)`

SetPassword sets Password field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


