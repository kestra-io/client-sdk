# BaseResourcePatchRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schemas** | **List[str]** |  | [optional] 

## Example

```python
from kestra_api_client.models.base_resource_patch_request import BaseResourcePatchRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BaseResourcePatchRequest from a JSON string
base_resource_patch_request_instance = BaseResourcePatchRequest.from_json(json)
# print the JSON string representation of the object
print(BaseResourcePatchRequest.to_json())

# convert the object into a dict
base_resource_patch_request_dict = base_resource_patch_request_instance.to_dict()
# create an instance of BaseResourcePatchRequest from a dict
base_resource_patch_request_from_dict = BaseResourcePatchRequest.from_dict(base_resource_patch_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


