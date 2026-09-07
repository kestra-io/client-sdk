# FlowUsageTaskUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**has_retry_count** | **int** |  | [optional] 
**has_timeout_count** | **int** |  | [optional] 
**has_worker_selector_count** | **int** |  | [optional] 
**has_allow_failure_count** | **int** |  | [optional] 
**has_log_to_file_count** | **int** |  | [optional] 
**has_run_if_count** | **int** |  | [optional] 
**has_allow_warning_count** | **int** |  | [optional] 
**has_cache_count** | **int** |  | [optional] 
**has_assets_count** | **int** |  | [optional] 
**has_errors_count** | **int** |  | [optional] 
**has_finally_count** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.flow_usage_task_usage import FlowUsageTaskUsage

# TODO update the JSON string below
json = "{}"
# create an instance of FlowUsageTaskUsage from a JSON string
flow_usage_task_usage_instance = FlowUsageTaskUsage.from_json(json)
# print the JSON string representation of the object
print(FlowUsageTaskUsage.to_json())

# convert the object into a dict
flow_usage_task_usage_dict = flow_usage_task_usage_instance.to_dict()
# create an instance of FlowUsageTaskUsage from a dict
flow_usage_task_usage_from_dict = FlowUsageTaskUsage.from_dict(flow_usage_task_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


