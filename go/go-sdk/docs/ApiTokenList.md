# ApiTokenList

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Total** | Pointer to **int32** |  | [optional] 
**Results** | Pointer to [**[]ApiToken**](ApiToken.md) |  | [optional] 

## Methods

### NewApiTokenList

`func NewApiTokenList() *ApiTokenList`

NewApiTokenList instantiates a new ApiTokenList object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewApiTokenListWithDefaults

`func NewApiTokenListWithDefaults() *ApiTokenList`

NewApiTokenListWithDefaults instantiates a new ApiTokenList object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetTotal

`func (o *ApiTokenList) GetTotal() int32`

GetTotal returns the Total field if non-nil, zero value otherwise.

### GetTotalOk

`func (o *ApiTokenList) GetTotalOk() (*int32, bool)`

GetTotalOk returns a tuple with the Total field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTotal

`func (o *ApiTokenList) SetTotal(v int32)`

SetTotal sets Total field to given value.

### HasTotal

`func (o *ApiTokenList) HasTotal() bool`

HasTotal returns a boolean if a field has been set.

### GetResults

`func (o *ApiTokenList) GetResults() []ApiToken`

GetResults returns the Results field if non-nil, zero value otherwise.

### GetResultsOk

`func (o *ApiTokenList) GetResultsOk() (*[]ApiToken, bool)`

GetResultsOk returns a tuple with the Results field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResults

`func (o *ApiTokenList) SetResults(v []ApiToken)`

SetResults sets Results field to given value.

### HasResults

`func (o *ApiTokenList) HasResults() bool`

HasResults returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


