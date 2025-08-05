# AssertionRunError

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Message** | **string** |  | 
**Details** | Pointer to **string** |  | [optional] 

## Methods

### NewAssertionRunError

`func NewAssertionRunError(message string, ) *AssertionRunError`

NewAssertionRunError instantiates a new AssertionRunError object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssertionRunErrorWithDefaults

`func NewAssertionRunErrorWithDefaults() *AssertionRunError`

NewAssertionRunErrorWithDefaults instantiates a new AssertionRunError object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetMessage

`func (o *AssertionRunError) GetMessage() string`

GetMessage returns the Message field if non-nil, zero value otherwise.

### GetMessageOk

`func (o *AssertionRunError) GetMessageOk() (*string, bool)`

GetMessageOk returns a tuple with the Message field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMessage

`func (o *AssertionRunError) SetMessage(v string)`

SetMessage sets Message field to given value.


### GetDetails

`func (o *AssertionRunError) GetDetails() string`

GetDetails returns the Details field if non-nil, zero value otherwise.

### GetDetailsOk

`func (o *AssertionRunError) GetDetailsOk() (*string, bool)`

GetDetailsOk returns a tuple with the Details field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDetails

`func (o *AssertionRunError) SetDetails(v string)`

SetDetails sets Details field to given value.

### HasDetails

`func (o *AssertionRunError) HasDetails() bool`

HasDetails returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


