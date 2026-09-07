# WorkerGroupControllerApiWorkerGroupTokenSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**token_prefix** | **str** |  | [optional] 
**created_at** | **datetime** |  | [optional] 
**expires_at** | **datetime** |  | [optional] 
**use_count** | **int** |  | [optional] 
**revoked** | **bool** |  | [optional] 
**valid** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_worker_group_token_summary import WorkerGroupControllerApiWorkerGroupTokenSummary

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiWorkerGroupTokenSummary from a JSON string
worker_group_controller_api_worker_group_token_summary_instance = WorkerGroupControllerApiWorkerGroupTokenSummary.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiWorkerGroupTokenSummary.to_json())

# convert the object into a dict
worker_group_controller_api_worker_group_token_summary_dict = worker_group_controller_api_worker_group_token_summary_instance.to_dict()
# create an instance of WorkerGroupControllerApiWorkerGroupTokenSummary from a dict
worker_group_controller_api_worker_group_token_summary_from_dict = WorkerGroupControllerApiWorkerGroupTokenSummary.from_dict(worker_group_controller_api_worker_group_token_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


