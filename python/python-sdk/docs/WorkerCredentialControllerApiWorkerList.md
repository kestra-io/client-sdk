# WorkerCredentialControllerApiWorkerList


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**workers** | [**List[WorkerCredentialControllerApiWorkerCredential]**](WorkerCredentialControllerApiWorkerCredential.md) |  | [optional] 

## Example

```python
from kestrapy.models.worker_credential_controller_api_worker_list import WorkerCredentialControllerApiWorkerList

# TODO update the JSON string below
json = "{}"
# create an instance of WorkerCredentialControllerApiWorkerList from a JSON string
worker_credential_controller_api_worker_list_instance = WorkerCredentialControllerApiWorkerList.from_json(json)
# print the JSON string representation of the object
print(WorkerCredentialControllerApiWorkerList.to_json())

# convert the object into a dict
worker_credential_controller_api_worker_list_dict = worker_credential_controller_api_worker_list_instance.to_dict()
# create an instance of WorkerCredentialControllerApiWorkerList from a dict
worker_credential_controller_api_worker_list_from_dict = WorkerCredentialControllerApiWorkerList.from_dict(worker_credential_controller_api_worker_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


