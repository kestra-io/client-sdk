# EventExecutionStatusEvent

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Data** | Pointer to [**ExecutionStatusEvent**](ExecutionStatusEvent.md) |  | [optional] 
**Id** | Pointer to **string** |  | [optional] 
**Name** | Pointer to **string** |  | [optional] 
**Comment** | Pointer to **string** |  | [optional] 
**Retry** | Pointer to **string** |  | [optional] 

## Methods

### NewEventExecutionStatusEvent

`func NewEventExecutionStatusEvent() *EventExecutionStatusEvent`

NewEventExecutionStatusEvent instantiates a new EventExecutionStatusEvent object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewEventExecutionStatusEventWithDefaults

`func NewEventExecutionStatusEventWithDefaults() *EventExecutionStatusEvent`

NewEventExecutionStatusEventWithDefaults instantiates a new EventExecutionStatusEvent object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetData

`func (o *EventExecutionStatusEvent) GetData() ExecutionStatusEvent`

GetData returns the Data field if non-nil, zero value otherwise.

### GetDataOk

`func (o *EventExecutionStatusEvent) GetDataOk() (*ExecutionStatusEvent, bool)`

GetDataOk returns a tuple with the Data field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetData

`func (o *EventExecutionStatusEvent) SetData(v ExecutionStatusEvent)`

SetData sets Data field to given value.

### HasData

`func (o *EventExecutionStatusEvent) HasData() bool`

HasData returns a boolean if a field has been set.

### GetId

`func (o *EventExecutionStatusEvent) GetId() string`

GetId returns the Id field if non-nil, zero value otherwise.

### GetIdOk

`func (o *EventExecutionStatusEvent) GetIdOk() (*string, bool)`

GetIdOk returns a tuple with the Id field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetId

`func (o *EventExecutionStatusEvent) SetId(v string)`

SetId sets Id field to given value.

### HasId

`func (o *EventExecutionStatusEvent) HasId() bool`

HasId returns a boolean if a field has been set.

### GetName

`func (o *EventExecutionStatusEvent) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *EventExecutionStatusEvent) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *EventExecutionStatusEvent) SetName(v string)`

SetName sets Name field to given value.

### HasName

`func (o *EventExecutionStatusEvent) HasName() bool`

HasName returns a boolean if a field has been set.

### GetComment

`func (o *EventExecutionStatusEvent) GetComment() string`

GetComment returns the Comment field if non-nil, zero value otherwise.

### GetCommentOk

`func (o *EventExecutionStatusEvent) GetCommentOk() (*string, bool)`

GetCommentOk returns a tuple with the Comment field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetComment

`func (o *EventExecutionStatusEvent) SetComment(v string)`

SetComment sets Comment field to given value.

### HasComment

`func (o *EventExecutionStatusEvent) HasComment() bool`

HasComment returns a boolean if a field has been set.

### GetRetry

`func (o *EventExecutionStatusEvent) GetRetry() string`

GetRetry returns the Retry field if non-nil, zero value otherwise.

### GetRetryOk

`func (o *EventExecutionStatusEvent) GetRetryOk() (*string, bool)`

GetRetryOk returns a tuple with the Retry field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetRetry

`func (o *EventExecutionStatusEvent) SetRetry(v string)`

SetRetry sets Retry field to given value.

### HasRetry

`func (o *EventExecutionStatusEvent) HasRetry() bool`

HasRetry returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


