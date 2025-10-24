# ExecutionUsage

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**DailyExecutionsCount** | Pointer to [**[]DailyExecutionStatistics**](DailyExecutionStatistics.md) |  | [optional] 
**DailyTaskRunsCount** | Pointer to [**[]DailyExecutionStatistics**](DailyExecutionStatistics.md) |  | [optional] 

## Methods

### NewExecutionUsage

`func NewExecutionUsage() *ExecutionUsage`

NewExecutionUsage instantiates a new ExecutionUsage object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewExecutionUsageWithDefaults

`func NewExecutionUsageWithDefaults() *ExecutionUsage`

NewExecutionUsageWithDefaults instantiates a new ExecutionUsage object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDailyExecutionsCount

`func (o *ExecutionUsage) GetDailyExecutionsCount() []DailyExecutionStatistics`

GetDailyExecutionsCount returns the DailyExecutionsCount field if non-nil, zero value otherwise.

### GetDailyExecutionsCountOk

`func (o *ExecutionUsage) GetDailyExecutionsCountOk() (*[]DailyExecutionStatistics, bool)`

GetDailyExecutionsCountOk returns a tuple with the DailyExecutionsCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDailyExecutionsCount

`func (o *ExecutionUsage) SetDailyExecutionsCount(v []DailyExecutionStatistics)`

SetDailyExecutionsCount sets DailyExecutionsCount field to given value.

### HasDailyExecutionsCount

`func (o *ExecutionUsage) HasDailyExecutionsCount() bool`

HasDailyExecutionsCount returns a boolean if a field has been set.

### GetDailyTaskRunsCount

`func (o *ExecutionUsage) GetDailyTaskRunsCount() []DailyExecutionStatistics`

GetDailyTaskRunsCount returns the DailyTaskRunsCount field if non-nil, zero value otherwise.

### GetDailyTaskRunsCountOk

`func (o *ExecutionUsage) GetDailyTaskRunsCountOk() (*[]DailyExecutionStatistics, bool)`

GetDailyTaskRunsCountOk returns a tuple with the DailyTaskRunsCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDailyTaskRunsCount

`func (o *ExecutionUsage) SetDailyTaskRunsCount(v []DailyExecutionStatistics)`

SetDailyTaskRunsCount sets DailyTaskRunsCount field to given value.

### HasDailyTaskRunsCount

`func (o *ExecutionUsage) HasDailyTaskRunsCount() bool`

HasDailyTaskRunsCount returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


