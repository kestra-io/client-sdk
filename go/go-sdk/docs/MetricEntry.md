# MetricEntry

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Namespace** | **string** |  | 
**FlowId** | **string** |  | 
**TaskId** | Pointer to **NullableString** |  | [optional] 
**ExecutionId** | Pointer to **NullableString** |  | [optional] 
**TaskRunId** | Pointer to **NullableString** |  | [optional] 
**Type** | **string** |  | 
**Name** | **string** |  | 
**Value** | **float64** |  | 
**Timestamp** | **time.Time** |  | 
**Tags** | Pointer to **map[string]string** |  | [optional] 
**Deleted** | **bool** |  | 
**ExecutionKind** | Pointer to [**NullableExecutionKind**](ExecutionKind.md) |  | [optional] 

## Methods

### NewMetricEntry

`func NewMetricEntry(namespace string, flowId string, type_ string, name string, value float64, timestamp time.Time, deleted bool, ) *MetricEntry`

NewMetricEntry instantiates a new MetricEntry object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewMetricEntryWithDefaults

`func NewMetricEntryWithDefaults() *MetricEntry`

NewMetricEntryWithDefaults instantiates a new MetricEntry object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetNamespace

`func (o *MetricEntry) GetNamespace() string`

GetNamespace returns the Namespace field if non-nil, zero value otherwise.

### GetNamespaceOk

`func (o *MetricEntry) GetNamespaceOk() (*string, bool)`

GetNamespaceOk returns a tuple with the Namespace field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespace

`func (o *MetricEntry) SetNamespace(v string)`

SetNamespace sets Namespace field to given value.


### GetFlowId

`func (o *MetricEntry) GetFlowId() string`

GetFlowId returns the FlowId field if non-nil, zero value otherwise.

### GetFlowIdOk

`func (o *MetricEntry) GetFlowIdOk() (*string, bool)`

GetFlowIdOk returns a tuple with the FlowId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetFlowId

`func (o *MetricEntry) SetFlowId(v string)`

SetFlowId sets FlowId field to given value.


### GetTaskId

`func (o *MetricEntry) GetTaskId() string`

GetTaskId returns the TaskId field if non-nil, zero value otherwise.

### GetTaskIdOk

`func (o *MetricEntry) GetTaskIdOk() (*string, bool)`

GetTaskIdOk returns a tuple with the TaskId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskId

`func (o *MetricEntry) SetTaskId(v string)`

SetTaskId sets TaskId field to given value.

### HasTaskId

`func (o *MetricEntry) HasTaskId() bool`

HasTaskId returns a boolean if a field has been set.

### SetTaskIdNil

`func (o *MetricEntry) SetTaskIdNil(b bool)`

 SetTaskIdNil sets the value for TaskId to be an explicit nil

### UnsetTaskId
`func (o *MetricEntry) UnsetTaskId()`

UnsetTaskId ensures that no value is present for TaskId, not even an explicit nil
### GetExecutionId

`func (o *MetricEntry) GetExecutionId() string`

GetExecutionId returns the ExecutionId field if non-nil, zero value otherwise.

### GetExecutionIdOk

`func (o *MetricEntry) GetExecutionIdOk() (*string, bool)`

GetExecutionIdOk returns a tuple with the ExecutionId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionId

`func (o *MetricEntry) SetExecutionId(v string)`

SetExecutionId sets ExecutionId field to given value.

### HasExecutionId

`func (o *MetricEntry) HasExecutionId() bool`

HasExecutionId returns a boolean if a field has been set.

### SetExecutionIdNil

`func (o *MetricEntry) SetExecutionIdNil(b bool)`

 SetExecutionIdNil sets the value for ExecutionId to be an explicit nil

### UnsetExecutionId
`func (o *MetricEntry) UnsetExecutionId()`

UnsetExecutionId ensures that no value is present for ExecutionId, not even an explicit nil
### GetTaskRunId

`func (o *MetricEntry) GetTaskRunId() string`

GetTaskRunId returns the TaskRunId field if non-nil, zero value otherwise.

### GetTaskRunIdOk

`func (o *MetricEntry) GetTaskRunIdOk() (*string, bool)`

GetTaskRunIdOk returns a tuple with the TaskRunId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunId

`func (o *MetricEntry) SetTaskRunId(v string)`

SetTaskRunId sets TaskRunId field to given value.

### HasTaskRunId

`func (o *MetricEntry) HasTaskRunId() bool`

HasTaskRunId returns a boolean if a field has been set.

### SetTaskRunIdNil

`func (o *MetricEntry) SetTaskRunIdNil(b bool)`

 SetTaskRunIdNil sets the value for TaskRunId to be an explicit nil

### UnsetTaskRunId
`func (o *MetricEntry) UnsetTaskRunId()`

UnsetTaskRunId ensures that no value is present for TaskRunId, not even an explicit nil
### GetType

`func (o *MetricEntry) GetType() string`

GetType returns the Type field if non-nil, zero value otherwise.

### GetTypeOk

`func (o *MetricEntry) GetTypeOk() (*string, bool)`

GetTypeOk returns a tuple with the Type field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetType

`func (o *MetricEntry) SetType(v string)`

SetType sets Type field to given value.


### GetName

`func (o *MetricEntry) GetName() string`

GetName returns the Name field if non-nil, zero value otherwise.

### GetNameOk

`func (o *MetricEntry) GetNameOk() (*string, bool)`

GetNameOk returns a tuple with the Name field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetName

`func (o *MetricEntry) SetName(v string)`

SetName sets Name field to given value.


### GetValue

`func (o *MetricEntry) GetValue() float64`

GetValue returns the Value field if non-nil, zero value otherwise.

### GetValueOk

`func (o *MetricEntry) GetValueOk() (*float64, bool)`

GetValueOk returns a tuple with the Value field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetValue

`func (o *MetricEntry) SetValue(v float64)`

SetValue sets Value field to given value.


### GetTimestamp

`func (o *MetricEntry) GetTimestamp() time.Time`

GetTimestamp returns the Timestamp field if non-nil, zero value otherwise.

### GetTimestampOk

`func (o *MetricEntry) GetTimestampOk() (*time.Time, bool)`

GetTimestampOk returns a tuple with the Timestamp field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTimestamp

`func (o *MetricEntry) SetTimestamp(v time.Time)`

SetTimestamp sets Timestamp field to given value.


### GetTags

`func (o *MetricEntry) GetTags() map[string]string`

GetTags returns the Tags field if non-nil, zero value otherwise.

### GetTagsOk

`func (o *MetricEntry) GetTagsOk() (*map[string]string, bool)`

GetTagsOk returns a tuple with the Tags field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTags

`func (o *MetricEntry) SetTags(v map[string]string)`

SetTags sets Tags field to given value.

### HasTags

`func (o *MetricEntry) HasTags() bool`

HasTags returns a boolean if a field has been set.

### SetTagsNil

`func (o *MetricEntry) SetTagsNil(b bool)`

 SetTagsNil sets the value for Tags to be an explicit nil

### UnsetTags
`func (o *MetricEntry) UnsetTags()`

UnsetTags ensures that no value is present for Tags, not even an explicit nil
### GetDeleted

`func (o *MetricEntry) GetDeleted() bool`

GetDeleted returns the Deleted field if non-nil, zero value otherwise.

### GetDeletedOk

`func (o *MetricEntry) GetDeletedOk() (*bool, bool)`

GetDeletedOk returns a tuple with the Deleted field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDeleted

`func (o *MetricEntry) SetDeleted(v bool)`

SetDeleted sets Deleted field to given value.


### GetExecutionKind

`func (o *MetricEntry) GetExecutionKind() ExecutionKind`

GetExecutionKind returns the ExecutionKind field if non-nil, zero value otherwise.

### GetExecutionKindOk

`func (o *MetricEntry) GetExecutionKindOk() (*ExecutionKind, bool)`

GetExecutionKindOk returns a tuple with the ExecutionKind field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionKind

`func (o *MetricEntry) SetExecutionKind(v ExecutionKind)`

SetExecutionKind sets ExecutionKind field to given value.

### HasExecutionKind

`func (o *MetricEntry) HasExecutionKind() bool`

HasExecutionKind returns a boolean if a field has been set.

### SetExecutionKindNil

`func (o *MetricEntry) SetExecutionKindNil(b bool)`

 SetExecutionKindNil sets the value for ExecutionKind to be an explicit nil

### UnsetExecutionKind
`func (o *MetricEntry) UnsetExecutionKind()`

UnsetExecutionKind ensures that no value is present for ExecutionKind, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


