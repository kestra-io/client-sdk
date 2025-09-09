# KVControllerApiDeleteBulkResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**keys** | **List[str]** |  | 

## Example

```python
from kestrapy.models.kv_controller_api_delete_bulk_response import KVControllerApiDeleteBulkResponse

# TODO update the JSON string below
json = "{}"
# create an instance of KVControllerApiDeleteBulkResponse from a JSON string
kv_controller_api_delete_bulk_response_instance = KVControllerApiDeleteBulkResponse.from_json(json)
# print the JSON string representation of the object
print(KVControllerApiDeleteBulkResponse.to_json())

# convert the object into a dict
kv_controller_api_delete_bulk_response_dict = kv_controller_api_delete_bulk_response_instance.to_dict()
# create an instance of KVControllerApiDeleteBulkResponse from a dict
kv_controller_api_delete_bulk_response_from_dict = KVControllerApiDeleteBulkResponse.from_dict(kv_controller_api_delete_bulk_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


