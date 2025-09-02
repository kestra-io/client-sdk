# PatchRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schemas** | **List[str]** |  | [optional] 
**patch_operation_list** | [**List[PatchOperation]**](PatchOperation.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.patch_request import PatchRequest

# TODO update the JSON string below
json = "{}"
# create an instance of PatchRequest from a JSON string
patch_request_instance = PatchRequest.from_json(json)
# print the JSON string representation of the object
print(PatchRequest.to_json())

# convert the object into a dict
patch_request_dict = patch_request_instance.to_dict()
# create an instance of PatchRequest from a dict
patch_request_from_dict = PatchRequest.from_dict(patch_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


