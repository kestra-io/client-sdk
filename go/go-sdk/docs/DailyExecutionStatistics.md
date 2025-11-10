# DailyExecutionStatistics

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**StartDate** | **time.Time** |  | 
**Duration** | [**DailyExecutionStatisticsDuration**](DailyExecutionStatisticsDuration.md) |  | 
**ExecutionCounts** | Pointer to [**DailyExecutionStatisticsExecutionCounts**](DailyExecutionStatisticsExecutionCounts.md) |  | [optional] 
**GroupBy** | Pointer to **string** |  | [optional] 

## Methods

### NewDailyExecutionStatistics

`func NewDailyExecutionStatistics(startDate time.Time, duration DailyExecutionStatisticsDuration, ) *DailyExecutionStatistics`

NewDailyExecutionStatistics instantiates a new DailyExecutionStatistics object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewDailyExecutionStatisticsWithDefaults

`func NewDailyExecutionStatisticsWithDefaults() *DailyExecutionStatistics`

NewDailyExecutionStatisticsWithDefaults instantiates a new DailyExecutionStatistics object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetStartDate

`func (o *DailyExecutionStatistics) GetStartDate() time.Time`

GetStartDate returns the StartDate field if non-nil, zero value otherwise.

### GetStartDateOk

`func (o *DailyExecutionStatistics) GetStartDateOk() (*time.Time, bool)`

GetStartDateOk returns a tuple with the StartDate field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetStartDate

`func (o *DailyExecutionStatistics) SetStartDate(v time.Time)`

SetStartDate sets StartDate field to given value.


### GetDuration

`func (o *DailyExecutionStatistics) GetDuration() DailyExecutionStatisticsDuration`

GetDuration returns the Duration field if non-nil, zero value otherwise.

### GetDurationOk

`func (o *DailyExecutionStatistics) GetDurationOk() (*DailyExecutionStatisticsDuration, bool)`

GetDurationOk returns a tuple with the Duration field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDuration

`func (o *DailyExecutionStatistics) SetDuration(v DailyExecutionStatisticsDuration)`

SetDuration sets Duration field to given value.


### GetExecutionCounts

`func (o *DailyExecutionStatistics) GetExecutionCounts() DailyExecutionStatisticsExecutionCounts`

GetExecutionCounts returns the ExecutionCounts field if non-nil, zero value otherwise.

### GetExecutionCountsOk

`func (o *DailyExecutionStatistics) GetExecutionCountsOk() (*DailyExecutionStatisticsExecutionCounts, bool)`

GetExecutionCountsOk returns a tuple with the ExecutionCounts field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetExecutionCounts

`func (o *DailyExecutionStatistics) SetExecutionCounts(v DailyExecutionStatisticsExecutionCounts)`

SetExecutionCounts sets ExecutionCounts field to given value.

### HasExecutionCounts

`func (o *DailyExecutionStatistics) HasExecutionCounts() bool`

HasExecutionCounts returns a boolean if a field has been set.

### GetGroupBy

`func (o *DailyExecutionStatistics) GetGroupBy() string`

GetGroupBy returns the GroupBy field if non-nil, zero value otherwise.

### GetGroupByOk

`func (o *DailyExecutionStatistics) GetGroupByOk() (*string, bool)`

GetGroupByOk returns a tuple with the GroupBy field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetGroupBy

`func (o *DailyExecutionStatistics) SetGroupBy(v string)`

SetGroupBy sets GroupBy field to given value.

### HasGroupBy

`func (o *DailyExecutionStatistics) HasGroupBy() bool`

HasGroupBy returns a boolean if a field has been set.


[[Back to Model list]](../../../python-sdk/README.md#documentation-for-models) [[Back to API list]](../../../python-sdk/README.md#documentation-for-api-endpoints) [[Back to README]](../../../python-sdk/README.md)


