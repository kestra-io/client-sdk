# AssertionResult

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Operator** | **string** |  | 
**Expected** | **interface{}** |  | 
**Actual** | **interface{}** |  | 
**IsSuccess** | **bool** |  | 
**TaskId** | **string** |  | 
**Description** | **string** |  | 
**ErrorMessage** | **string** |  | 

## Methods

### NewAssertionResult

`func NewAssertionResult(operator string, expected interface{}, actual interface{}, isSuccess bool, taskId string, description string, errorMessage string, ) *AssertionResult`

NewAssertionResult instantiates a new AssertionResult object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewAssertionResultWithDefaults

`func NewAssertionResultWithDefaults() *AssertionResult`

NewAssertionResultWithDefaults instantiates a new AssertionResult object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetOperator

`func (o *AssertionResult) GetOperator() string`

GetOperator returns the Operator field if non-nil, zero value otherwise.

### GetOperatorOk

`func (o *AssertionResult) GetOperatorOk() (*string, bool)`

GetOperatorOk returns a tuple with the Operator field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetOperator

`func (o *AssertionResult) SetOperator(v string)`

SetOperator sets Operator field to given value.


### GetExpected

`func (o *AssertionResult) GetExpected() interface{}`

GetExpected returns the Expected field if non-nil, zero value otherwise.

### GetExpectedOk

`func (o *AssertionResult) GetExpectedOk() (*interface{}, bool)`

GetExpectedOk returns a tuple with the Expected field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExpected

`func (o *AssertionResult) SetExpected(v interface{})`

SetExpected sets Expected field to given value.


### SetExpectedNil

`func (o *AssertionResult) SetExpectedNil(b bool)`

 SetExpectedNil sets the value for Expected to be an explicit nil

### UnsetExpected
`func (o *AssertionResult) UnsetExpected()`

UnsetExpected ensures that no value is present for Expected, not even an explicit nil
### GetActual

`func (o *AssertionResult) GetActual() interface{}`

GetActual returns the Actual field if non-nil, zero value otherwise.

### GetActualOk

`func (o *AssertionResult) GetActualOk() (*interface{}, bool)`

GetActualOk returns a tuple with the Actual field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetActual

`func (o *AssertionResult) SetActual(v interface{})`

SetActual sets Actual field to given value.


### SetActualNil

`func (o *AssertionResult) SetActualNil(b bool)`

 SetActualNil sets the value for Actual to be an explicit nil

### UnsetActual
`func (o *AssertionResult) UnsetActual()`

UnsetActual ensures that no value is present for Actual, not even an explicit nil
### GetIsSuccess

`func (o *AssertionResult) GetIsSuccess() bool`

GetIsSuccess returns the IsSuccess field if non-nil, zero value otherwise.

### GetIsSuccessOk

`func (o *AssertionResult) GetIsSuccessOk() (*bool, bool)`

GetIsSuccessOk returns a tuple with the IsSuccess field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetIsSuccess

`func (o *AssertionResult) SetIsSuccess(v bool)`

SetIsSuccess sets IsSuccess field to given value.


### GetTaskId

`func (o *AssertionResult) GetTaskId() string`

GetTaskId returns the TaskId field if non-nil, zero value otherwise.

### GetTaskIdOk

`func (o *AssertionResult) GetTaskIdOk() (*string, bool)`

GetTaskIdOk returns a tuple with the TaskId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskId

`func (o *AssertionResult) SetTaskId(v string)`

SetTaskId sets TaskId field to given value.


### GetDescription

`func (o *AssertionResult) GetDescription() string`

GetDescription returns the Description field if non-nil, zero value otherwise.

### GetDescriptionOk

`func (o *AssertionResult) GetDescriptionOk() (*string, bool)`

GetDescriptionOk returns a tuple with the Description field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDescription

`func (o *AssertionResult) SetDescription(v string)`

SetDescription sets Description field to given value.


### GetErrorMessage

`func (o *AssertionResult) GetErrorMessage() string`

GetErrorMessage returns the ErrorMessage field if non-nil, zero value otherwise.

### GetErrorMessageOk

`func (o *AssertionResult) GetErrorMessageOk() (*string, bool)`

GetErrorMessageOk returns a tuple with the ErrorMessage field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetErrorMessage

`func (o *AssertionResult) SetErrorMessage(v string)`

SetErrorMessage sets ErrorMessage field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


