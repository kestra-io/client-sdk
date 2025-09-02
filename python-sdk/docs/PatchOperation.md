# PatchOperation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operation** | [**PatchOperationType**](PatchOperationType.md) |  | [optional] 
**path** | [**PatchOperationPath**](PatchOperationPath.md) |  | [optional] 
**value** | **object** |  | [optional] 

## Example

```python
from kestra_api_client.models.patch_operation import PatchOperation

# TODO update the JSON string below
json = "{}"
# create an instance of PatchOperation from a JSON string
patch_operation_instance = PatchOperation.from_json(json)
# print the JSON string representation of the object
print(PatchOperation.to_json())

# convert the object into a dict
patch_operation_dict = patch_operation_instance.to_dict()
# create an instance of PatchOperation from a dict
patch_operation_from_dict = PatchOperation.from_dict(patch_operation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


