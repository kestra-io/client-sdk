# KVControllerApiDeleteBulkRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**keys** | **List[str]** |  | 

## Example

```python
from kestrapy.models.kv_controller_api_delete_bulk_request import KVControllerApiDeleteBulkRequest

# TODO update the JSON string below
json = "{}"
# create an instance of KVControllerApiDeleteBulkRequest from a JSON string
kv_controller_api_delete_bulk_request_instance = KVControllerApiDeleteBulkRequest.from_json(json)
# print the JSON string representation of the object
print(KVControllerApiDeleteBulkRequest.to_json())

# convert the object into a dict
kv_controller_api_delete_bulk_request_dict = kv_controller_api_delete_bulk_request_instance.to_dict()
# create an instance of KVControllerApiDeleteBulkRequest from a dict
kv_controller_api_delete_bulk_request_from_dict = KVControllerApiDeleteBulkRequest.from_dict(kv_controller_api_delete_bulk_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


