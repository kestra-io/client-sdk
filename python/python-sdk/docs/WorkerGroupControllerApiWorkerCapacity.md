# WorkerGroupControllerApiWorkerCapacity

Compact per-worker capacity projection extracted from the worker's heartbeat metric set. Replaces the previous full `Set` payload --- the Workers tab only needs these three numbers, and shipping the rest forced tag-disambiguation logic onto the client.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**pending** | **int** |  | [optional] 
**running** | **int** |  | [optional] 
**max** | **int** |  | [optional] 
**threads** | **int** |  | [optional] 
**ended_rate** | **float** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_capacity import WorkerGroupControllerApiWorkerCapacity

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerCapacity from a JSON string
worker_group_controller_api_worker_capacity_instance = WorkerGroupControllerApiWorkerCapacity.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerCapacity.to_json())

# convert the object into a dict
worker_group_controller_api_worker_capacity_dict = worker_group_controller_api_worker_capacity_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerCapacity from a dict
worker_group_controller_api_worker_capacity_from_dict = WorkerGroupControllerApiWorkerCapacity.from_dict(worker_group_controller_api_worker_capacity_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


