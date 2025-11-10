# LogEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**TaskId** | Pointer to **NullableString** |  | [optional] 
**ExecutionId** | Pointer to **NullableString** |  | [optional] 
**TaskRunId** | Pointer to **NullableString** |  | [optional] 
**AttemptNumber** | Pointer to **NullableInt32** |  | [optional] 
**TriggerId** | Pointer to **NullableString** |  | [optional] 
**Timestamp** | Pointer to **time.Time** |  | [optional] 
**Level** | Pointer to [**Level**](Level.md) |  | [optional] 
**Thread** | Pointer to **string** |  | [optional] 
**Message** | Pointer to **string** |  | [optional] 
**Deleted** | **bool** |  | 
**ExecutionKind** | Pointer to [**NullableExecutionKind**](ExecutionKind.md) |  | [optional] 

## Methods

### NewLogEntry

`func NewLogEntry(namespace string, flowId string, deleted bool, ) *LogEntry`

NewLogEntry instantiates a new LogEntry object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewLogEntryWithDefaults

`func NewLogEntryWithDefaults() *LogEntry`

NewLogEntryWithDefaults instantiates a new LogEntry object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNamespace

`func (o *LogEntry) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *LogEntry) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *LogEntry) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *LogEntry) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *LogEntry) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *LogEntry) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetTaskId

`func (o *LogEntry) GetTaskId() string`

GetTaskId returns the TaskId field if non-nil, zero value otherwise.

### GetTaskIdOk

`func (o *LogEntry) GetTaskIdOk() (*string, bool)`

GetTaskIdOk returns a tuple with the TaskId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskId

`func (o *LogEntry) SetTaskId(v string)`

SetTaskId sets TaskId field to given value.

### HasTaskId

`func (o *LogEntry) HasTaskId() bool`

HasTaskId returns a boolean if a field has been set.

### SetTaskIdNil

`func (o *LogEntry) SetTaskIdNil(b bool)`

 SetTaskIdNil sets the value for TaskId to be an explicit nil

### UnsetTaskId
`func (o *LogEntry) UnsetTaskId()`

UnsetTaskId ensures that no value is present for TaskId, not even an explicit nil
### GetExecutionId

`func (o *LogEntry) GetExecutionId() string`

GetExecutionId returns the ExecutionId field if non-nil, zero value otherwise.

### GetExecutionIdOk

`func (o *LogEntry) GetExecutionIdOk() (*string, bool)`

GetExecutionIdOk returns a tuple with the ExecutionId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionId

`func (o *LogEntry) SetExecutionId(v string)`

SetExecutionId sets ExecutionId field to given value.

### HasExecutionId

`func (o *LogEntry) HasExecutionId() bool`

HasExecutionId returns a boolean if a field has been set.

### SetExecutionIdNil

`func (o *LogEntry) SetExecutionIdNil(b bool)`

 SetExecutionIdNil sets the value for ExecutionId to be an explicit nil

### UnsetExecutionId
`func (o *LogEntry) UnsetExecutionId()`

UnsetExecutionId ensures that no value is present for ExecutionId, not even an explicit nil
### GetTaskRunId

`func (o *LogEntry) GetTaskRunId() string`

GetTaskRunId returns the TaskRunId field if non-nil, zero value otherwise.

### GetTaskRunIdOk

`func (o *LogEntry) GetTaskRunIdOk() (*string, bool)`

GetTaskRunIdOk returns a tuple with the TaskRunId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunId

`func (o *LogEntry) SetTaskRunId(v string)`

SetTaskRunId sets TaskRunId field to given value.

### HasTaskRunId

`func (o *LogEntry) HasTaskRunId() bool`

HasTaskRunId returns a boolean if a field has been set.

### SetTaskRunIdNil

`func (o *LogEntry) SetTaskRunIdNil(b bool)`

 SetTaskRunIdNil sets the value for TaskRunId to be an explicit nil

### UnsetTaskRunId
`func (o *LogEntry) UnsetTaskRunId()`

UnsetTaskRunId ensures that no value is present for TaskRunId, not even an explicit nil
### GetAttemptNumber

`func (o *LogEntry) GetAttemptNumber() int32`

GetAttemptNumber returns the AttemptNumber field if non-nil, zero value otherwise.

### GetAttemptNumberOk

`func (o *LogEntry) GetAttemptNumberOk() (*int32, bool)`

GetAttemptNumberOk returns a tuple with the AttemptNumber field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetAttemptNumber

`func (o *LogEntry) SetAttemptNumber(v int32)`

SetAttemptNumber sets AttemptNumber field to given value.

### HasAttemptNumber

`func (o *LogEntry) HasAttemptNumber() bool`

HasAttemptNumber returns a boolean if a field has been set.

### SetAttemptNumberNil

`func (o *LogEntry) SetAttemptNumberNil(b bool)`

 SetAttemptNumberNil sets the value for AttemptNumber to be an explicit nil

### UnsetAttemptNumber
`func (o *LogEntry) UnsetAttemptNumber()`

UnsetAttemptNumber ensures that no value is present for AttemptNumber, not even an explicit nil
### GetTriggerId

`func (o *LogEntry) GetTriggerId() string`

GetTriggerId returns the TriggerId field if non-nil, zero value otherwise.

### GetTriggerIdOk

`func (o *LogEntry) GetTriggerIdOk() (*string, bool)`

GetTriggerIdOk returns a tuple with the TriggerId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggerId

`func (o *LogEntry) SetTriggerId(v string)`

SetTriggerId sets TriggerId field to given value.

### HasTriggerId

`func (o *LogEntry) HasTriggerId() bool`

HasTriggerId returns a boolean if a field has been set.

### SetTriggerIdNil

`func (o *LogEntry) SetTriggerIdNil(b bool)`

 SetTriggerIdNil sets the value for TriggerId to be an explicit nil

### UnsetTriggerId
`func (o *LogEntry) UnsetTriggerId()`

UnsetTriggerId ensures that no value is present for TriggerId, not even an explicit nil
### GetTimestamp

`func (o *LogEntry) GetTimestamp() time.Time`

GetTimestamp returns the Timestamp field if non-nil, zero value otherwise.

### GetTimestampOk

`func (o *LogEntry) GetTimestampOk() (*time.Time, bool)`

GetTimestampOk returns a tuple with the Timestamp field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTimestamp

`func (o *LogEntry) SetTimestamp(v time.Time)`

SetTimestamp sets Timestamp field to given value.

### HasTimestamp

`func (o *LogEntry) HasTimestamp() bool`

HasTimestamp returns a boolean if a field has been set.

### GetLevel

`func (o *LogEntry) GetLevel() Level`

GetLevel returns the Level field if non-nil, zero value otherwise.

### GetLevelOk

`func (o *LogEntry) GetLevelOk() (*Level, bool)`

GetLevelOk returns a tuple with the Level field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLevel

`func (o *LogEntry) SetLevel(v Level)`

SetLevel sets Level field to given value.

### HasLevel

`func (o *LogEntry) HasLevel() bool`

HasLevel returns a boolean if a field has been set.

### GetThread

`func (o *LogEntry) GetThread() string`

GetThread returns the Thread field if non-nil, zero value otherwise.

### GetThreadOk

`func (o *LogEntry) GetThreadOk() (*string, bool)`

GetThreadOk returns a tuple with the Thread field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetThread

`func (o *LogEntry) SetThread(v string)`

SetThread sets Thread field to given value.

### HasThread

`func (o *LogEntry) HasThread() bool`

HasThread returns a boolean if a field has been set.

### GetMessage

`func (o *LogEntry) GetMessage() string`

GetMessage returns the Message field if non-nil, zero value otherwise.

### GetMessageOk

`func (o *LogEntry) GetMessageOk() (*string, bool)`

GetMessageOk returns a tuple with the Message field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMessage

`func (o *LogEntry) SetMessage(v string)`

SetMessage sets Message field to given value.

### HasMessage

`func (o *LogEntry) HasMessage() bool`

HasMessage returns a boolean if a field has been set.

### GetDeleted

`func (o *LogEntry) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *LogEntry) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *LogEntry) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetExecutionKind

`func (o *LogEntry) GetExecutionKind() ExecutionKind`

GetExecutionKind returns the ExecutionKind field if non-nil, zero value otherwise.

### GetExecutionKindOk

`func (o *LogEntry) GetExecutionKindOk() (*ExecutionKind, bool)`

GetExecutionKindOk returns a tuple with the ExecutionKind field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionKind

`func (o *LogEntry) SetExecutionKind(v ExecutionKind)`

SetExecutionKind sets ExecutionKind field to given value.

### HasExecutionKind

`func (o *LogEntry) HasExecutionKind() bool`

HasExecutionKind returns a boolean if a field has been set.

### SetExecutionKindNil

`func (o *LogEntry) SetExecutionKindNil(b bool)`

 SetExecutionKindNil sets the value for ExecutionKind to be an explicit nil

### UnsetExecutionKind
`func (o *LogEntry) UnsetExecutionKind()`

UnsetExecutionKind ensures that no value is present for ExecutionKind, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


