# ApiSecretMetaEE

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Key** | **string** |  | 
**Namespace** | Pointer to **string** |  | [optional] 
**Description** | **string** |  | 
**Tags** | [**[]ApiSecretTag**](ApiSecretTag.md) |  | 

## Methods

### NewApiSecretMetaEE

`func NewApiSecretMetaEE(key string, description string, tags []ApiSecretTag, ) *ApiSecretMetaEE`

NewApiSecretMetaEE instantiates a new ApiSecretMetaEE object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiSecretMetaEEWithDefaults

`func NewApiSecretMetaEEWithDefaults() *ApiSecretMetaEE`

NewApiSecretMetaEEWithDefaults instantiates a new ApiSecretMetaEE object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetKey

`func (o *ApiSecretMetaEE) GetKey() string`

GetKey returns the Key field if non-nil, zero value otherwise.

### GetKeyOk

`func (o *ApiSecretMetaEE) GetKeyOk() (*string, bool)`

GetKeyOk returns a tuple with the Key field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetKey

`func (o *ApiSecretMetaEE) SetKey(v string)`

SetKey sets Key field to given value.


### GetNamespace

`func (o *ApiSecretMetaEE) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ApiSecretMetaEE) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ApiSecretMetaEE) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.

### HasNamespace

`func (o *ApiSecretMetaEE) HasNamespace() bool`

HasNamespace returns a boolean if a field has been set.

### GetDescription

`func (o *ApiSecretMetaEE) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *ApiSecretMetaEE) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *ApiSecretMetaEE) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetTags

`func (o *ApiSecretMetaEE) GetTags() []ApiSecretTag`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *ApiSecretMetaEE) GetTagsOk() (*[]ApiSecretTag, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *ApiSecretMetaEE) SetTags(v []ApiSecretTag)`

SetTags sets Tags field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


