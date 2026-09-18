# FlowUsageTriggerUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**has_when_count** | **int** |  | [optional] 
**has_worker_selector_count** | **int** |  | [optional] 
**has_labels_count** | **int** |  | [optional] 
**has_stop_after_count** | **int** |  | [optional] 
**has_log_to_file_count** | **int** |  | [optional] 
**has_fail_on_error_count** | **int** |  | [optional] 
**has_allow_concurrent_count** | **int** |  | [optional] 
**has_assets_count** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.flow_usage_trigger_usage import FlowUsageTriggerUsage

# TODO update the JSON string below
json = "{}"
# create an instance of FlowUsageTriggerUsage from a JSON string
flow_usage_trigger_usage_instance = FlowUsageTriggerUsage.from_json(json)
# print the JSON string representation of the object
print(FlowUsageTriggerUsage.to_json())

# convert the object into a dict
flow_usage_trigger_usage_dict = flow_usage_trigger_usage_instance.to_dict()
# create an instance of FlowUsageTriggerUsage from a dict
flow_usage_trigger_usage_from_dict = FlowUsageTriggerUsage.from_dict(flow_usage_trigger_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


