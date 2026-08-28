# WorkerGroupControllerApiSharedCapacity


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**allocated** | **int** |  | [optional] 
**used** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_shared_capacity import WorkerGroupControllerApiSharedCapacity

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiSharedCapacity from a JSON string
worker_group_controller_api_shared_capacity_instance = WorkerGroupControllerApiSharedCapacity.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiSharedCapacity.to_json())

# convert the object into a dict
worker_group_controller_api_shared_capacity_dict = worker_group_controller_api_shared_capacity_instance.to_dict()
# create an instance of WorkerGroupControllerApiSharedCapacity from a dict
worker_group_controller_api_shared_capacity_from_dict = WorkerGroupControllerApiSharedCapacity.from_dict(worker_group_controller_api_shared_capacity_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


