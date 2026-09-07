# WorkerCredentialControllerApiWorkerCredential


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**worker_id** | **str** |  | [optional] 
**worker_name** | **str** |  | [optional] 
**token_uid** | **str** |  | [optional] 
**created_at** | **datetime** |  | [optional] 
**last_seen_at** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.worker_credential_controller_api_worker_credential import WorkerCredentialControllerApiWorkerCredential

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerCredentialControllerApiWorkerCredential from a JSON string
worker_credential_controller_api_worker_credential_instance = WorkerCredentialControllerApiWorkerCredential.from_json(json)
# print the JSON string representation of the object
print(WorkerCredentialControllerApiWorkerCredential.to_json())

# convert the object into a dict
worker_credential_controller_api_worker_credential_dict = worker_credential_controller_api_worker_credential_instance.to_dict()
# create an instance of WorkerCredentialControllerApiWorkerCredential from a dict
worker_credential_controller_api_worker_credential_from_dict = WorkerCredentialControllerApiWorkerCredential.from_dict(worker_credential_controller_api_worker_credential_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


