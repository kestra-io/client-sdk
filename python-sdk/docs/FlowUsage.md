# FlowUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **int** |  | [optional] 
**namespaces_count** | **int** |  | [optional] 
**task_type_count** | **Dict[str, int]** |  | [optional] 
**trigger_type_count** | **Dict[str, int]** |  | [optional] 
**task_runner_type_count** | **Dict[str, int]** |  | [optional] 

## Example

```python
from kestra_api_client.models.flow_usage import FlowUsage

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


