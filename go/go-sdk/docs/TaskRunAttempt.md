# TaskRunAttempt

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Metrics** | Pointer to [**[]AbstractMetricEntryObject**](AbstractMetricEntryObject.md) |  | [optional] 
**State** | [**State**](State.md) |  | 
**WorkerId** | Pointer to **NullableString** |  | [optional] 
**LogFile** | Pointer to **NullableString** |  | [optional] 

## Methods

### NewTaskRunAttempt

`func NewTaskRunAttempt(state State, ) *TaskRunAttempt`

NewTaskRunAttempt instantiates a new TaskRunAttempt object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewTaskRunAttemptWithDefaults

`func NewTaskRunAttemptWithDefaults() *TaskRunAttempt`

NewTaskRunAttemptWithDefaults instantiates a new TaskRunAttempt object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetMetrics

`func (o *TaskRunAttempt) GetMetrics() []AbstractMetricEntryObject`

GetMetrics returns the Metrics field if non-nil, zero value otherwise.

### GetMetricsOk

`func (o *TaskRunAttempt) GetMetricsOk() (*[]AbstractMetricEntryObject, bool)`

GetMetricsOk returns a tuple with the Metrics field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetMetrics

`func (o *TaskRunAttempt) SetMetrics(v []AbstractMetricEntryObject)`

SetMetrics sets Metrics field to given value.

### HasMetrics

`func (o *TaskRunAttempt) HasMetrics() bool`

HasMetrics returns a boolean if a field has been set.

### GetState

`func (o *TaskRunAttempt) GetState() State`

GetState returns the State field if non-nil, zero value otherwise.

### GetStateOk

`func (o *TaskRunAttempt) GetStateOk() (*State, bool)`

GetStateOk returns a tuple with the State field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetState

`func (o *TaskRunAttempt) SetState(v State)`

SetState sets State field to given value.


### GetWorkerId

`func (o *TaskRunAttempt) GetWorkerId() string`

GetWorkerId returns the WorkerId field if non-nil, zero value otherwise.

### GetWorkerIdOk

`func (o *TaskRunAttempt) GetWorkerIdOk() (*string, bool)`

GetWorkerIdOk returns a tuple with the WorkerId field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetWorkerId

`func (o *TaskRunAttempt) SetWorkerId(v string)`

SetWorkerId sets WorkerId field to given value.

### HasWorkerId

`func (o *TaskRunAttempt) HasWorkerId() bool`

HasWorkerId returns a boolean if a field has been set.

### SetWorkerIdNil

`func (o *TaskRunAttempt) SetWorkerIdNil(b bool)`

 SetWorkerIdNil sets the value for WorkerId to be an explicit nil

### UnsetWorkerId
`func (o *TaskRunAttempt) UnsetWorkerId()`

UnsetWorkerId ensures that no value is present for WorkerId, not even an explicit nil
### GetLogFile

`func (o *TaskRunAttempt) GetLogFile() string`

GetLogFile returns the LogFile field if non-nil, zero value otherwise.

### GetLogFileOk

`func (o *TaskRunAttempt) GetLogFileOk() (*string, bool)`

GetLogFileOk returns a tuple with the LogFile field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetLogFile

`func (o *TaskRunAttempt) SetLogFile(v string)`

SetLogFile sets LogFile field to given value.

### HasLogFile

`func (o *TaskRunAttempt) HasLogFile() bool`

HasLogFile returns a boolean if a field has been set.

### SetLogFileNil

`func (o *TaskRunAttempt) SetLogFileNil(b bool)`

 SetLogFileNil sets the value for LogFile to be an explicit nil

### UnsetLogFile
`func (o *TaskRunAttempt) UnsetLogFile()`

UnsetLogFile ensures that no value is present for LogFile, not even an explicit nil

[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


