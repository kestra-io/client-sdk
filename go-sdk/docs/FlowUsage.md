# FlowUsage

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Count** | Pointer to **int32** |  | [optional] 
**NamespacesCount** | Pointer to **int64** |  | [optional] 
**TaskTypeCount** | Pointer to **map[string]int64** |  | [optional] 
**TriggerTypeCount** | Pointer to **map[string]int64** |  | [optional] 
**TaskRunnerTypeCount** | Pointer to **map[string]int64** |  | [optional] 

## Methods

### NewFlowUsage

`func NewFlowUsage() *FlowUsage`

NewFlowUsage instantiates a new FlowUsage object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewFlowUsageWithDefaults

`func NewFlowUsageWithDefaults() *FlowUsage`

NewFlowUsageWithDefaults instantiates a new FlowUsage object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetCount

`func (o *FlowUsage) GetCount() int32`

GetCount returns the Count field if non-nil, zero value otherwise.

### GetCountOk

`func (o *FlowUsage) GetCountOk() (*int32, bool)`

GetCountOk returns a tuple with the Count field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetCount

`func (o *FlowUsage) SetCount(v int32)`

SetCount sets Count field to given value.

### HasCount

`func (o *FlowUsage) HasCount() bool`

HasCount returns a boolean if a field has been set.

### GetNamespacesCount

`func (o *FlowUsage) GetNamespacesCount() int64`

GetNamespacesCount returns the NamespacesCount field if non-nil, zero value otherwise.

### GetNamespacesCountOk

`func (o *FlowUsage) GetNamespacesCountOk() (*int64, bool)`

GetNamespacesCountOk returns a tuple with the NamespacesCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetNamespacesCount

`func (o *FlowUsage) SetNamespacesCount(v int64)`

SetNamespacesCount sets NamespacesCount field to given value.

### HasNamespacesCount

`func (o *FlowUsage) HasNamespacesCount() bool`

HasNamespacesCount returns a boolean if a field has been set.

### GetTaskTypeCount

`func (o *FlowUsage) GetTaskTypeCount() map[string]int64`

GetTaskTypeCount returns the TaskTypeCount field if non-nil, zero value otherwise.

### GetTaskTypeCountOk

`func (o *FlowUsage) GetTaskTypeCountOk() (*map[string]int64, bool)`

GetTaskTypeCountOk returns a tuple with the TaskTypeCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskTypeCount

`func (o *FlowUsage) SetTaskTypeCount(v map[string]int64)`

SetTaskTypeCount sets TaskTypeCount field to given value.

### HasTaskTypeCount

`func (o *FlowUsage) HasTaskTypeCount() bool`

HasTaskTypeCount returns a boolean if a field has been set.

### GetTriggerTypeCount

`func (o *FlowUsage) GetTriggerTypeCount() map[string]int64`

GetTriggerTypeCount returns the TriggerTypeCount field if non-nil, zero value otherwise.

### GetTriggerTypeCountOk

`func (o *FlowUsage) GetTriggerTypeCountOk() (*map[string]int64, bool)`

GetTriggerTypeCountOk returns a tuple with the TriggerTypeCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTriggerTypeCount

`func (o *FlowUsage) SetTriggerTypeCount(v map[string]int64)`

SetTriggerTypeCount sets TriggerTypeCount field to given value.

### HasTriggerTypeCount

`func (o *FlowUsage) HasTriggerTypeCount() bool`

HasTriggerTypeCount returns a boolean if a field has been set.

### GetTaskRunnerTypeCount

`func (o *FlowUsage) GetTaskRunnerTypeCount() map[string]int64`

GetTaskRunnerTypeCount returns the TaskRunnerTypeCount field if non-nil, zero value otherwise.

### GetTaskRunnerTypeCountOk

`func (o *FlowUsage) GetTaskRunnerTypeCountOk() (*map[string]int64, bool)`

GetTaskRunnerTypeCountOk returns a tuple with the TaskRunnerTypeCount field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetTaskRunnerTypeCount

`func (o *FlowUsage) SetTaskRunnerTypeCount(v map[string]int64)`

SetTaskRunnerTypeCount sets TaskRunnerTypeCount field to given value.

### HasTaskRunnerTypeCount

`func (o *FlowUsage) HasTaskRunnerTypeCount() bool`

HasTaskRunnerTypeCount returns a boolean if a field has been set.


[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


