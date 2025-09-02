# WorkerGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **str** |  | [optional] 
**fallback** | [**WorkerGroupFallback**](WorkerGroupFallback.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.worker_group import WorkerGroup

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroup from a JSON string
worker_group_instance = WorkerGroup.from_json(json)
# print the JSON string representation of the object
print(WorkerGroup.to_json())

# convert the object into a dict
worker_group_dict = worker_group_instance.to_dict()
# create an instance of WorkerGroup from a dict
worker_group_from_dict = WorkerGroup.from_dict(worker_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


