# WorkerGroupControllerApiGenerateTokenRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**description** | **str** |  | [optional] 
**expires_at** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_generate_token_request import WorkerGroupControllerApiGenerateTokenRequest

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiGenerateTokenRequest from a JSON string
worker_group_controller_api_generate_token_request_instance = WorkerGroupControllerApiGenerateTokenRequest.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiGenerateTokenRequest.to_json())

# convert the object into a dict
worker_group_controller_api_generate_token_request_dict = worker_group_controller_api_generate_token_request_instance.to_dict()
# create an instance of WorkerGroupControllerApiGenerateTokenRequest from a dict
worker_group_controller_api_generate_token_request_from_dict = WorkerGroupControllerApiGenerateTokenRequest.from_dict(worker_group_controller_api_generate_token_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


