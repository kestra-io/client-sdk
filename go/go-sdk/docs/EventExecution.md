# EventExecution

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Data** | Pointer to [**Execution**](Execution.md) |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Comment** | Pointer to **string** |  | [optional] 
**Retry** | Pointer to **string** |  | [optional] 

## Methods

### NewEventExecution

`func NewEventExecution() *EventExecution`

NewEventExecution instantiates a new EventExecution object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewEventExecutionWithDefaults

`func NewEventExecutionWithDefaults() *EventExecution`

NewEventExecutionWithDefaults instantiates a new EventExecution object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetData

`func (o *EventExecution) GetData() Execution`

GetData returns the Data field if non-nil, zero value otherwise.

### GetDataOk

`func (o *EventExecution) GetDataOk() (*Execution, bool)`

GetDataOk returns a tuple with the Data field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetData

`func (o *EventExecution) SetData(v Execution)`

SetData sets Data field to given value.

### HasData

`func (o *EventExecution) HasData() bool`

HasData returns a boolean if a field has been set.

### GetId

`func (o *EventExecution) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *EventExecution) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *EventExecution) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *EventExecution) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *EventExecution) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *EventExecution) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *EventExecution) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *EventExecution) HasName() bool`

HasName returns a boolean if a field has been set.

### GetComment

`func (o *EventExecution) GetComment() string`

GetComment returns the Comment field if non-nil, zero value otherwise.

### GetCommentOk

`func (o *EventExecution) GetCommentOk() (*string, bool)`

GetCommentOk returns a tuple with the Comment field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetComment

`func (o *EventExecution) SetComment(v string)`

SetComment sets Comment field to given value.

### HasComment

`func (o *EventExecution) HasComment() bool`

HasComment returns a boolean if a field has been set.

### GetRetry

`func (o *EventExecution) GetRetry() string`

GetRetry returns the Retry field if non-nil, zero value otherwise.

### GetRetryOk

`func (o *EventExecution) GetRetryOk() (*string, bool)`

GetRetryOk returns a tuple with the Retry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRetry

`func (o *EventExecution) SetRetry(v string)`

SetRetry sets Retry field to given value.

### HasRetry

`func (o *EventExecution) HasRetry() bool`

HasRetry returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


