# WorkerGroupControllerApiGenerateTokenResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**token** | **str** |  | [optional] 
**details** | [**WorkerGroupControllerApiWorkerGroupTokenSummary**](WorkerGroupControllerApiWorkerGroupTokenSummary.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_group_controller_api_generate_token_response import WorkerGroupControllerApiGenerateTokenResponse

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerGroupControllerApiGenerateTokenResponse from a JSON string
worker_group_controller_api_generate_token_response_instance = WorkerGroupControllerApiGenerateTokenResponse.from_json(json)
# print the JSON string representation of the object
print(WorkerGroupControllerApiGenerateTokenResponse.to_json())

# convert the object into a dict
worker_group_controller_api_generate_token_response_dict = worker_group_controller_api_generate_token_response_instance.to_dict()
# create an instance of WorkerGroupControllerApiGenerateTokenResponse from a dict
worker_group_controller_api_generate_token_response_from_dict = WorkerGroupControllerApiGenerateTokenResponse.from_dict(worker_group_controller_api_generate_token_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


