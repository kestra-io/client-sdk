# ExecutionControllerSetLabelsByIdsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**executions_id** | **List[str]** |  | 
**execution_labels** | [**List[Label]**](Label.md) |  | 

## Example

```python
from kestra_api_client.models.execution_controller_set_labels_by_ids_request import ExecutionControllerSetLabelsByIdsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutionControllerSetLabelsByIdsRequest from a JSON string
execution_controller_set_labels_by_ids_request_instance = ExecutionControllerSetLabelsByIdsRequest.from_json(json)
# print the JSON string representation of the object
print(ExecutionControllerSetLabelsByIdsRequest.to_json())

# convert the object into a dict
execution_controller_set_labels_by_ids_request_dict = execution_controller_set_labels_by_ids_request_instance.to_dict()
# create an instance of ExecutionControllerSetLabelsByIdsRequest from a dict
execution_controller_set_labels_by_ids_request_from_dict = ExecutionControllerSetLabelsByIdsRequest.from_dict(execution_controller_set_labels_by_ids_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


