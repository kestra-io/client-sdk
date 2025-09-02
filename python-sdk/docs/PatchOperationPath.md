# PatchOperationPath


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value_path_expression** | [**ValuePathExpression**](ValuePathExpression.md) |  | 

## Example

```python
from kestra_api_client.models.patch_operation_path import PatchOperationPath

# TODO update the JSON string below
json = "{}"
# create an instance of PatchOperationPath from a JSON string
patch_operation_path_instance = PatchOperationPath.from_json(json)
# print the JSON string representation of the object
print(PatchOperationPath.to_json())

# convert the object into a dict
patch_operation_path_dict = patch_operation_path_instance.to_dict()
# create an instance of PatchOperationPath from a dict
patch_operation_path_from_dict = PatchOperationPath.from_dict(patch_operation_path_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


