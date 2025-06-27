# ExecutionControllerSetLabelsByIdsRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ExecutionsId** | **[]string** |  | 
**ExecutionLabels** | [**[]Label**](Label.md) |  | 

## Methods

### NewExecutionControllerSetLabelsByIdsRequest

`func NewExecutionControllerSetLabelsByIdsRequest(executionsId []string, executionLabels []Label, ) *ExecutionControllerSetLabelsByIdsRequest`

NewExecutionControllerSetLabelsByIdsRequest instantiates a new ExecutionControllerSetLabelsByIdsRequest object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionControllerSetLabelsByIdsRequestWithDefaults

`func NewExecutionControllerSetLabelsByIdsRequestWithDefaults() *ExecutionControllerSetLabelsByIdsRequest`

NewExecutionControllerSetLabelsByIdsRequestWithDefaults instantiates a new ExecutionControllerSetLabelsByIdsRequest object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetExecutionsId

`func (o *ExecutionControllerSetLabelsByIdsRequest) GetExecutionsId() []string`

GetExecutionsId returns the ExecutionsId field if non-nil, zero value otherwise.

### GetExecutionsIdOk

`func (o *ExecutionControllerSetLabelsByIdsRequest) GetExecutionsIdOk() (*[]string, bool)`

GetExecutionsIdOk returns a tuple with the ExecutionsId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionsId

`func (o *ExecutionControllerSetLabelsByIdsRequest) SetExecutionsId(v []string)`

SetExecutionsId sets ExecutionsId field to given value.


### GetExecutionLabels

`func (o *ExecutionControllerSetLabelsByIdsRequest) GetExecutionLabels() []Label`

GetExecutionLabels returns the ExecutionLabels field if non-nil, zero value otherwise.

### GetExecutionLabelsOk

`func (o *ExecutionControllerSetLabelsByIdsRequest) GetExecutionLabelsOk() (*[]Label, bool)`

GetExecutionLabelsOk returns a tuple with the ExecutionLabels field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionLabels

`func (o *ExecutionControllerSetLabelsByIdsRequest) SetExecutionLabels(v []Label)`

SetExecutionLabels sets ExecutionLabels field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


