# AppsControllerApiBulkOperationRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uids** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.apps_controller_api_bulk_operation_request import AppsControllerApiBulkOperationRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AppsControllerApiBulkOperationRequest from a JSON string
apps_controller_api_bulk_operation_request_instance = AppsControllerApiBulkOperationRequest.from_json(json)
# print the JSON string representation of the object
print(AppsControllerApiBulkOperationRequest.to_json())

# convert the object into a dict
apps_controller_api_bulk_operation_request_dict = apps_controller_api_bulk_operation_request_instance.to_dict()
# create an instance of AppsControllerApiBulkOperationRequest from a dict
apps_controller_api_bulk_operation_request_from_dict = AppsControllerApiBulkOperationRequest.from_dict(apps_controller_api_bulk_operation_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


