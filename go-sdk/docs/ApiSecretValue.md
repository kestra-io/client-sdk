# ApiSecretValue

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Tags** | [**[]ApiSecretTag**](ApiSecretTag.md) |  | 
**Key** | **string** |  | 
**Value** | **string** |  | 
**Description** | **string** |  | 

## Methods

### NewApiSecretValue

`func NewApiSecretValue(tags []ApiSecretTag, key string, value string, description string, ) *ApiSecretValue`

NewApiSecretValue instantiates a new ApiSecretValue object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiSecretValueWithDefaults

`func NewApiSecretValueWithDefaults() *ApiSecretValue`

NewApiSecretValueWithDefaults instantiates a new ApiSecretValue object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTags

`func (o *ApiSecretValue) GetTags() []ApiSecretTag`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *ApiSecretValue) GetTagsOk() (*[]ApiSecretTag, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *ApiSecretValue) SetTags(v []ApiSecretTag)`

SetTags sets Tags field to given value.


### GetKey

`func (o *ApiSecretValue) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *ApiSecretValue) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *ApiSecretValue) SetKey(v string)`

SetKey sets Key field to given value.


### GetValue

`func (o *ApiSecretValue) GetValue() string`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *ApiSecretValue) GetValueOk() (*string, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *ApiSecretValue) SetValue(v string)`

SetValue sets Value field to given value.


### GetDescription

`func (o *ApiSecretValue) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ApiSecretValue) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ApiSecretValue) SetDescription(v string)`

SetDescription sets Description field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


