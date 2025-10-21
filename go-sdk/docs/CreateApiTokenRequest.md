# CreateApiTokenRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Name** | **string** |  | 
**Description** | Pointer to **string** |  | [optional] 
**MaxAge** | Pointer to **string** |  | [optional] 
**Extended** | Pointer to **bool** |  | [optional] 

## Methods

### NewCreateApiTokenRequest

`func NewCreateApiTokenRequest(name string, ) *CreateApiTokenRequest`

NewCreateApiTokenRequest instantiates a new CreateApiTokenRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewCreateApiTokenRequestWithDefaults

`func NewCreateApiTokenRequestWithDefaults() *CreateApiTokenRequest`

NewCreateApiTokenRequestWithDefaults instantiates a new CreateApiTokenRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetName

`func (o *CreateApiTokenRequest) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *CreateApiTokenRequest) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *CreateApiTokenRequest) SetName(v string)`

SetName sets Name field to given value.


### GetDescription

`func (o *CreateApiTokenRequest) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *CreateApiTokenRequest) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *CreateApiTokenRequest) SetDescription(v string)`

SetDescription sets Description field to given value.

### HasDescription

`func (o *CreateApiTokenRequest) HasDescription() bool`

HasDescription returns a boolean if a field has been set.

### GetMaxAge

`func (o *CreateApiTokenRequest) GetMaxAge() string`

GetMaxAge returns the MaxAge field if non-nil, zero value otherwise.

### GetMaxAgeOk

`func (o *CreateApiTokenRequest) GetMaxAgeOk() (*string, bool)`

GetMaxAgeOk returns a tuple with the MaxAge field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMaxAge

`func (o *CreateApiTokenRequest) SetMaxAge(v string)`

SetMaxAge sets MaxAge field to given value.

### HasMaxAge

`func (o *CreateApiTokenRequest) HasMaxAge() bool`

HasMaxAge returns a boolean if a field has been set.

### GetExtended

`func (o *CreateApiTokenRequest) GetExtended() bool`

GetExtended returns the Extended field if non-nil, zero value otherwise.

### GetExtendedOk

`func (o *CreateApiTokenRequest) GetExtendedOk() (*bool, bool)`

GetExtendedOk returns a tuple with the Extended field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExtended

`func (o *CreateApiTokenRequest) SetExtended(v bool)`

SetExtended sets Extended field to given value.

### HasExtended

`func (o *CreateApiTokenRequest) HasExtended() bool`

HasExtended returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


