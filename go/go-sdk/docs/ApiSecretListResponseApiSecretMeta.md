# ApiSecretListResponseApiSecretMeta

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ReadOnly** | **bool** |  | 
**Results** | [**[]ApiSecretMetaEE**](ApiSecretMetaEE.md) |  | 
**Total** | Pointer to **int64** |  | [optional] 

## Methods

### NewApiSecretListResponseApiSecretMeta

`func NewApiSecretListResponseApiSecretMeta(readOnly bool, results []ApiSecretMetaEE, ) *ApiSecretListResponseApiSecretMeta`

NewApiSecretListResponseApiSecretMeta instantiates a new ApiSecretListResponseApiSecretMeta object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiSecretListResponseApiSecretMetaWithDefaults

`func NewApiSecretListResponseApiSecretMetaWithDefaults() *ApiSecretListResponseApiSecretMeta`

NewApiSecretListResponseApiSecretMetaWithDefaults instantiates a new ApiSecretListResponseApiSecretMeta object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetReadOnly

`func (o *ApiSecretListResponseApiSecretMeta) GetReadOnly() bool`

GetReadOnly returns the ReadOnly field if non-nil, zero value otherwise.

### GetReadOnlyOk

`func (o *ApiSecretListResponseApiSecretMeta) GetReadOnlyOk() (*bool, bool)`

GetReadOnlyOk returns a tuple with the ReadOnly field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetReadOnly

`func (o *ApiSecretListResponseApiSecretMeta) SetReadOnly(v bool)`

SetReadOnly sets ReadOnly field to given value.


### GetResults

`func (o *ApiSecretListResponseApiSecretMeta) GetResults() []ApiSecretMetaEE`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *ApiSecretListResponseApiSecretMeta) GetResultsOk() (*[]ApiSecretMetaEE, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *ApiSecretListResponseApiSecretMeta) SetResults(v []ApiSecretMetaEE)`

SetResults sets Results field to given value.


### GetTotal

`func (o *ApiSecretListResponseApiSecretMeta) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *ApiSecretListResponseApiSecretMeta) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *ApiSecretListResponseApiSecretMeta) SetTotal(v int64)`

SetTotal sets Total field to given value.

### HasTotal

`func (o *ApiSecretListResponseApiSecretMeta) HasTotal() bool`

HasTotal returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


