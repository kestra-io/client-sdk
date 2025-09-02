# ExecutionControllerLastExecutionResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** |  | 
**FlowId** | **string** |  | 
**Namespace** | **string** |  | 
**StartDate** | **time.Time** |  | 
**Status** | [**StateType**](StateType.md) |  | 

## Methods

### NewExecutionControllerLastExecutionResponse

`func NewExecutionControllerLastExecutionResponse(id string, flowId string, namespace string, startDate time.Time, status StateType, ) *ExecutionControllerLastExecutionResponse`

NewExecutionControllerLastExecutionResponse instantiates a new ExecutionControllerLastExecutionResponse object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionControllerLastExecutionResponseWithDefaults

`func NewExecutionControllerLastExecutionResponseWithDefaults() *ExecutionControllerLastExecutionResponse`

NewExecutionControllerLastExecutionResponseWithDefaults instantiates a new ExecutionControllerLastExecutionResponse object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetId

`func (o *ExecutionControllerLastExecutionResponse) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *ExecutionControllerLastExecutionResponse) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *ExecutionControllerLastExecutionResponse) SetId(v string)`

SetId sets Id field to given value.


### GetFlowId

`func (o *ExecutionControllerLastExecutionResponse) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *ExecutionControllerLastExecutionResponse) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *ExecutionControllerLastExecutionResponse) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetNamespace

`func (o *ExecutionControllerLastExecutionResponse) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *ExecutionControllerLastExecutionResponse) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *ExecutionControllerLastExecutionResponse) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetStartDate

`func (o *ExecutionControllerLastExecutionResponse) GetStartDate() time.Time`

GetStartDate returns the StartDate field if non-nil, zero value otherwise.

### GetStartDateOk

`func (o *ExecutionControllerLastExecutionResponse) GetStartDateOk() (*time.Time, bool)`

GetStartDateOk returns a tuple with the StartDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartDate

`func (o *ExecutionControllerLastExecutionResponse) SetStartDate(v time.Time)`

SetStartDate sets StartDate field to given value.


### GetStatus

`func (o *ExecutionControllerLastExecutionResponse) GetStatus() StateType`

GetStatus returns the Status field if non-nil, zero value otherwise.

### GetStatusOk

`func (o *ExecutionControllerLastExecutionResponse) GetStatusOk() (*StateType, bool)`

GetStatusOk returns a tuple with the Status field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStatus

`func (o *ExecutionControllerLastExecutionResponse) SetStatus(v StateType)`

SetStatus sets Status field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


