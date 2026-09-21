# FlowUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **int** |  | [optional] 
**namespaces_count** | **int** |  | [optional] 
**task_type_count** | **Dict[str, int]** |  | [optional] 
**trigger_type_count** | **Dict[str, int]** |  | [optional] 
**task_runner_type_count** | **Dict[str, int]** |  | [optional] 
**input_type_count** | **Dict[str, int]** |  | [optional] 
**has_inputs_count** | **int** |  | [optional] 
**has_outputs_count** | **int** |  | [optional] 
**has_labels_count** | **int** |  | [optional] 
**has_variables_count** | **int** |  | [optional] 
**has_worker_selector_count** | **int** |  | [optional] 
**has_errors_count** | **int** |  | [optional] 
**has_finally_count** | **int** |  | [optional] 
**has_after_execution_count** | **int** |  | [optional] 
**has_triggers_count** | **int** |  | [optional] 
**has_concurrency_count** | **int** |  | [optional] 
**has_retry_count** | **int** |  | [optional] 
**has_sla_count** | **int** |  | [optional] 
**has_checks_count** | **int** |  | [optional] 
**has_quotas_count** | **int** |  | [optional] 
**tasks** | [**FlowUsageTaskUsage**](FlowUsageTaskUsage.md) |  | [optional] 
**triggers** | [**FlowUsageTriggerUsage**](FlowUsageTriggerUsage.md) |  | [optional] 

## Example

```python
from kestrapy.models.flow_usage import FlowUsage

# TODO update the JSON string below
json = "{}"
# create an instance of FlowUsage from a JSON string
flow_usage_instance = FlowUsage.from_json(json)
# print the JSON string representation of the object
print(FlowUsage.to_json())

# convert the object into a dict
flow_usage_dict = flow_usage_instance.to_dict()
# create an instance of FlowUsage from a dict
flow_usage_from_dict = FlowUsage.from_dict(flow_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


