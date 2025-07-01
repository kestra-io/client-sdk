# BulkErrorResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Message** | Pointer to **string** |  | [optional] 
**Invalids** | Pointer to **interface{}** |  | [optional] 

## Methods

### NewBulkErrorResponse

`func NewBulkErrorResponse() *BulkErrorResponse`

NewBulkErrorResponse instantiates a new BulkErrorResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewBulkErrorResponseWithDefaults

`func NewBulkErrorResponseWithDefaults() *BulkErrorResponse`

NewBulkErrorResponseWithDefaults instantiates a new BulkErrorResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetMessage

`func (o *BulkErrorResponse) GetMessage() string`

GetMessage returns the Message field if non-nil, zero value otherwise.

### GetMessageOk

`func (o *BulkErrorResponse) GetMessageOk() (*string, bool)`

GetMessageOk returns a tuple with the Message field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMessage

`func (o *BulkErrorResponse) SetMessage(v string)`

SetMessage sets Message field to given value.

### HasMessage

`func (o *BulkErrorResponse) HasMessage() bool`

HasMessage returns a boolean if a field has been set.

### GetInvalids

`func (o *BulkErrorResponse) GetInvalids() interface{}`

GetInvalids returns the Invalids field if non-nil, zero value otherwise.

### GetInvalidsOk

`func (o *BulkErrorResponse) GetInvalidsOk() (*interface{}, bool)`

GetInvalidsOk returns a tuple with the Invalids field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetInvalids

`func (o *BulkErrorResponse) SetInvalids(v interface{})`

SetInvalids sets Invalids field to given value.

### HasInvalids

`func (o *BulkErrorResponse) HasInvalids() bool`

HasInvalids returns a boolean if a field has been set.

### SetInvalidsNil

`func (o *BulkErrorResponse) SetInvalidsNil(b bool)`

 SetInvalidsNil sets the value for Invalids to be an explicit nil

### UnsetInvalids
`func (o *BulkErrorResponse) UnsetInvalids()`

UnsetInvalids ensures that no value is present for Invalids, not even an explicit nil

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


