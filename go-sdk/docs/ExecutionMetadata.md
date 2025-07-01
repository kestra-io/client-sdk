# ExecutionMetadata

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**AttemptNumber** | **int32** |  | 
**OriginalCreatedDate** | **time.Time** |  | 

## Methods

### NewExecutionMetadata

`func NewExecutionMetadata(attemptNumber int32, originalCreatedDate time.Time, ) *ExecutionMetadata`

NewExecutionMetadata instantiates a new ExecutionMetadata object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionMetadataWithDefaults

`func NewExecutionMetadataWithDefaults() *ExecutionMetadata`

NewExecutionMetadataWithDefaults instantiates a new ExecutionMetadata object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetAttemptNumber

`func (o *ExecutionMetadata) GetAttemptNumber() int32`

GetAttemptNumber returns the AttemptNumber field if non-nil, zero value otherwise.

### GetAttemptNumberOk

`func (o *ExecutionMetadata) GetAttemptNumberOk() (*int32, bool)`

GetAttemptNumberOk returns a tuple with the AttemptNumber field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttemptNumber

`func (o *ExecutionMetadata) SetAttemptNumber(v int32)`

SetAttemptNumber sets AttemptNumber field to given value.


### GetOriginalCreatedDate

`func (o *ExecutionMetadata) GetOriginalCreatedDate() time.Time`

GetOriginalCreatedDate returns the OriginalCreatedDate field if non-nil, zero value otherwise.

### GetOriginalCreatedDateOk

`func (o *ExecutionMetadata) GetOriginalCreatedDateOk() (*time.Time, bool)`

GetOriginalCreatedDateOk returns a tuple with the OriginalCreatedDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOriginalCreatedDate

`func (o *ExecutionMetadata) SetOriginalCreatedDate(v time.Time)`

SetOriginalCreatedDate sets OriginalCreatedDate field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


