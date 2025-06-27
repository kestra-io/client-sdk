# ApiSecretListResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ReadOnly** | **bool** |  | 
**Results** | [**[]ApiSecretMeta**](ApiSecretMeta.md) |  | 
**Total** | **int64** |  | 

## Methods

### NewApiSecretListResponse

`func NewApiSecretListResponse(readOnly bool, results []ApiSecretMeta, total int64, ) *ApiSecretListResponse`

NewApiSecretListResponse instantiates a new ApiSecretListResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiSecretListResponseWithDefaults

`func NewApiSecretListResponseWithDefaults() *ApiSecretListResponse`

NewApiSecretListResponseWithDefaults instantiates a new ApiSecretListResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetReadOnly

`func (o *ApiSecretListResponse) GetReadOnly() bool`

GetReadOnly returns the ReadOnly field if non-nil, zero value otherwise.

### GetReadOnlyOk

`func (o *ApiSecretListResponse) GetReadOnlyOk() (*bool, bool)`

GetReadOnlyOk returns a tuple with the ReadOnly field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetReadOnly

`func (o *ApiSecretListResponse) SetReadOnly(v bool)`

SetReadOnly sets ReadOnly field to given value.


### GetResults

`func (o *ApiSecretListResponse) GetResults() []ApiSecretMeta`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *ApiSecretListResponse) GetResultsOk() (*[]ApiSecretMeta, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *ApiSecretListResponse) SetResults(v []ApiSecretMeta)`

SetResults sets Results field to given value.


### GetTotal

`func (o *ApiSecretListResponse) GetTotal() int64`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *ApiSecretListResponse) GetTotalOk() (*int64, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *ApiSecretListResponse) SetTotal(v int64)`

SetTotal sets Total field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


