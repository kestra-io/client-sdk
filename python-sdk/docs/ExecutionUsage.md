# ExecutionUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**daily_executions_count** | [**List[DailyExecutionStatistics]**](DailyExecutionStatistics.md) |  | [optional] 

## Example

```python
from kestrapy.models.execution_usage import ExecutionUsage

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionUsage from a JSON string
execution_usage_instance = ExecutionUsage.from_json(json)
# print the JSON string representation of the object
print(ExecutionUsage.to_json())

# convert the object into a dict
execution_usage_dict = execution_usage_instance.to_dict()
# create an instance of ExecutionUsage from a dict
execution_usage_from_dict = ExecutionUsage.from_dict(execution_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


