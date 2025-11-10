# ExecutionControllerEvalResult

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Result** | Pointer to **string** |  | [optional] 
**Error** | Pointer to **string** |  | [optional] 
**StackTrace** | Pointer to **string** |  | [optional] 

## Methods

### NewExecutionControllerEvalResult

`func NewExecutionControllerEvalResult() *ExecutionControllerEvalResult`

NewExecutionControllerEvalResult instantiates a new ExecutionControllerEvalResult object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionControllerEvalResultWithDefaults

`func NewExecutionControllerEvalResultWithDefaults() *ExecutionControllerEvalResult`

NewExecutionControllerEvalResultWithDefaults instantiates a new ExecutionControllerEvalResult object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetResult

`func (o *ExecutionControllerEvalResult) GetResult() string`

GetResult returns the Result field if non-nil, zero value otherwise.

### GetResultOk

`func (o *ExecutionControllerEvalResult) GetResultOk() (*string, bool)`

GetResultOk returns a tuple with the Result field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetResult

`func (o *ExecutionControllerEvalResult) SetResult(v string)`

SetResult sets Result field to given value.

### HasResult

`func (o *ExecutionControllerEvalResult) HasResult() bool`

HasResult returns a boolean if a field has been set.

### GetError

`func (o *ExecutionControllerEvalResult) GetError() string`

GetError returns the Error field if non-nil, zero value otherwise.

### GetErrorOk

`func (o *ExecutionControllerEvalResult) GetErrorOk() (*string, bool)`

GetErrorOk returns a tuple with the Error field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetError

`func (o *ExecutionControllerEvalResult) SetError(v string)`

SetError sets Error field to given value.

### HasError

`func (o *ExecutionControllerEvalResult) HasError() bool`

HasError returns a boolean if a field has been set.

### GetStackTrace

`func (o *ExecutionControllerEvalResult) GetStackTrace() string`

GetStackTrace returns the StackTrace field if non-nil, zero value otherwise.

### GetStackTraceOk

`func (o *ExecutionControllerEvalResult) GetStackTraceOk() (*string, bool)`

GetStackTraceOk returns a tuple with the StackTrace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStackTrace

`func (o *ExecutionControllerEvalResult) SetStackTrace(v string)`

SetStackTrace sets StackTrace field to given value.

### HasStackTrace

`func (o *ExecutionControllerEvalResult) HasStackTrace() bool`

HasStackTrace returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


