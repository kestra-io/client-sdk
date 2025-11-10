# MeControllerApiUpdatePasswordRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**OldPassword** | Pointer to **string** |  | [optional] 
**NewPassword** | Pointer to **string** |  | [optional] 

## Methods

### NewMeControllerApiUpdatePasswordRequest

`func NewMeControllerApiUpdatePasswordRequest() *MeControllerApiUpdatePasswordRequest`

NewMeControllerApiUpdatePasswordRequest instantiates a new MeControllerApiUpdatePasswordRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMeControllerApiUpdatePasswordRequestWithDefaults

`func NewMeControllerApiUpdatePasswordRequestWithDefaults() *MeControllerApiUpdatePasswordRequest`

NewMeControllerApiUpdatePasswordRequestWithDefaults instantiates a new MeControllerApiUpdatePasswordRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetOldPassword

`func (o *MeControllerApiUpdatePasswordRequest) GetOldPassword() string`

GetOldPassword returns the OldPassword field if non-nil, zero value otherwise.

### GetOldPasswordOk

`func (o *MeControllerApiUpdatePasswordRequest) GetOldPasswordOk() (*string, bool)`

GetOldPasswordOk returns a tuple with the OldPassword field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOldPassword

`func (o *MeControllerApiUpdatePasswordRequest) SetOldPassword(v string)`

SetOldPassword sets OldPassword field to given value.

### HasOldPassword

`func (o *MeControllerApiUpdatePasswordRequest) HasOldPassword() bool`

HasOldPassword returns a boolean if a field has been set.

### GetNewPassword

`func (o *MeControllerApiUpdatePasswordRequest) GetNewPassword() string`

GetNewPassword returns the NewPassword field if non-nil, zero value otherwise.

### GetNewPasswordOk

`func (o *MeControllerApiUpdatePasswordRequest) GetNewPasswordOk() (*string, bool)`

GetNewPasswordOk returns a tuple with the NewPassword field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNewPassword

`func (o *MeControllerApiUpdatePasswordRequest) SetNewPassword(v string)`

SetNewPassword sets NewPassword field to given value.

### HasNewPassword

`func (o *MeControllerApiUpdatePasswordRequest) HasNewPassword() bool`

HasNewPassword returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


