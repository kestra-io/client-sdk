# ServiceUsage

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**DailyStatistics** | [**[]ServiceUsageDailyServiceStatistics**](ServiceUsageDailyServiceStatistics.md) |  | 

## Methods

### NewServiceUsage

`func NewServiceUsage(dailyStatistics []ServiceUsageDailyServiceStatistics, ) *ServiceUsage`

NewServiceUsage instantiates a new ServiceUsage object
This constructor will assign default values to properties that have it defined,
and makes sure properties required by API are set, but the set of arguments
will change when the set of required properties is changed

### NewServiceUsageWithDefaults

`func NewServiceUsageWithDefaults() *ServiceUsage`

NewServiceUsageWithDefaults instantiates a new ServiceUsage object
This constructor will only assign default values to properties that have it defined,
but it doesn't guarantee that properties required by API are set

### GetDailyStatistics

`func (o *ServiceUsage) GetDailyStatistics() []ServiceUsageDailyServiceStatistics`

GetDailyStatistics returns the DailyStatistics field if non-nil, zero value otherwise.

### GetDailyStatisticsOk

`func (o *ServiceUsage) GetDailyStatisticsOk() (*[]ServiceUsageDailyServiceStatistics, bool)`

GetDailyStatisticsOk returns a tuple with the DailyStatistics field if it's non-nil, zero value otherwise
and a boolean to check if the value has been set.

### SetDailyStatistics

`func (o *ServiceUsage) SetDailyStatistics(v []ServiceUsageDailyServiceStatistics)`

SetDailyStatistics sets DailyStatistics field to given value.



[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


