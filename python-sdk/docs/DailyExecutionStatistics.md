# DailyExecutionStatistics


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**start_date** | **datetime** |  | 
**duration** | [**DailyExecutionStatisticsDuration**](DailyExecutionStatisticsDuration.md) |  | 
**execution_counts** | [**DailyExecutionStatisticsExecutionCounts**](DailyExecutionStatisticsExecutionCounts.md) |  | [optional] 
**group_by** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.daily_execution_statistics import DailyExecutionStatistics

# TODO update the JSON string below
json = "{}"
# create an instance of DailyExecutionStatistics from a JSON string
daily_execution_statistics_instance = DailyExecutionStatistics.from_json(json)
# print the JSON string representation of the object
print(DailyExecutionStatistics.to_json())

# convert the object into a dict
daily_execution_statistics_dict = daily_execution_statistics_instance.to_dict()
# create an instance of DailyExecutionStatistics from a dict
daily_execution_statistics_from_dict = DailyExecutionStatistics.from_dict(daily_execution_statistics_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


