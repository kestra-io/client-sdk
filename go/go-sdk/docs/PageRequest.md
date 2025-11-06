# PageRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**StartIndex** | Pointer to **int32** |  | [optional] 
**Count** | Pointer to **int32** |  | [optional] 

## Methods

### NewPageRequest

`func NewPageRequest() *PageRequest`

NewPageRequest instantiates a new PageRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewPageRequestWithDefaults

`func NewPageRequestWithDefaults() *PageRequest`

NewPageRequestWithDefaults instantiates a new PageRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetStartIndex

`func (o *PageRequest) GetStartIndex() int32`

GetStartIndex returns the StartIndex field if non-nil, zero value otherwise.

### GetStartIndexOk

`func (o *PageRequest) GetStartIndexOk() (*int32, bool)`

GetStartIndexOk returns a tuple with the StartIndex field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartIndex

`func (o *PageRequest) SetStartIndex(v int32)`

SetStartIndex sets StartIndex field to given value.

### HasStartIndex

`func (o *PageRequest) HasStartIndex() bool`

HasStartIndex returns a boolean if a field has been set.

### GetCount

`func (o *PageRequest) GetCount() int32`

GetCount returns the Count field if non-nil, zero value otherwise.

### GetCountOk

`func (o *PageRequest) GetCountOk() (*int32, bool)`

GetCountOk returns a tuple with the Count field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCount

`func (o *PageRequest) SetCount(v int32)`

SetCount sets Count field to given value.

### HasCount

`func (o *PageRequest) HasCount() bool`

HasCount returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


