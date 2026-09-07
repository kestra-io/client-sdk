# DailyExecutionStatisticsExecutionCounts


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**created** | **int** |  | [optional] 
**submitted** | **int** |  | [optional] 
**running** | **int** |  | [optional] 
**paused** | **int** |  | [optional] 
**restarted** | **int** |  | [optional] 
**killing** | **int** |  | [optional] 
**success** | **int** |  | [optional] 
**warning** | **int** |  | [optional] 
**failed** | **int** |  | [optional] 
**killed** | **int** |  | [optional] 
**cancelled** | **int** |  | [optional] 
**queued** | **int** |  | [optional] 
**retrying** | **int** |  | [optional] 
**retried** | **int** |  | [optional] 
**skipped** | **int** |  | [optional] 
**breakpoint** | **int** |  | [optional] 
**resubmitted** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.daily_execution_statistics_execution_counts import DailyExecutionStatisticsExecutionCounts

# TODO update the JSON string below
json = "{}"
# create an instance of DailyExecutionStatisticsExecutionCounts from a JSON string
daily_execution_statistics_execution_counts_instance = DailyExecutionStatisticsExecutionCounts.from_json(json)
# print the JSON string representation of the object
print(DailyExecutionStatisticsExecutionCounts.to_json())

# convert the object into a dict
daily_execution_statistics_execution_counts_dict = daily_execution_statistics_execution_counts_instance.to_dict()
# create an instance of DailyExecutionStatisticsExecutionCounts from a dict
daily_execution_statistics_execution_counts_from_dict = DailyExecutionStatisticsExecutionCounts.from_dict(daily_execution_statistics_execution_counts_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


