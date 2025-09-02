# ExecutionTrigger


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**variables** | **Dict[str, object]** |  | 
**log_file** | **str** |  | 

## Example

```python
from kestra_api_client.models.execution_trigger import ExecutionTrigger

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionTrigger from a JSON string
execution_trigger_instance = ExecutionTrigger.from_json(json)
# print the JSON string representation of the object
print(ExecutionTrigger.to_json())

# convert the object into a dict
execution_trigger_dict = execution_trigger_instance.to_dict()
# create an instance of ExecutionTrigger from a dict
execution_trigger_from_dict = ExecutionTrigger.from_dict(execution_trigger_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


