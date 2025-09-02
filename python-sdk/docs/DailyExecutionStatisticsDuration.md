# DailyExecutionStatisticsDuration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**min** | **str** |  | 
**avg** | **str** |  | 
**max** | **str** |  | 
**sum** | **str** |  | 
**count** | **int** |  | 

## Example

```python
from kestra_api_client.models.daily_execution_statistics_duration import DailyExecutionStatisticsDuration

# TODO update the JSON string below
json = "{}"
# create an instance of DailyExecutionStatisticsDuration from a JSON string
daily_execution_statistics_duration_instance = DailyExecutionStatisticsDuration.from_json(json)
# print the JSON string representation of the object
print(DailyExecutionStatisticsDuration.to_json())

# convert the object into a dict
daily_execution_statistics_duration_dict = daily_execution_statistics_duration_instance.to_dict()
# create an instance of DailyExecutionStatisticsDuration from a dict
daily_execution_statistics_duration_from_dict = DailyExecutionStatisticsDuration.from_dict(daily_execution_statistics_duration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


