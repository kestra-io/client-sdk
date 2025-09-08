# ApiPatchSuperAdminRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**super_admin** | **bool** |  | 

## Example

```python
from kestra_api_client.models.api_patch_super_admin_request import ApiPatchSuperAdminRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiPatchSuperAdminRequest from a JSON string
api_patch_super_admin_request_instance = ApiPatchSuperAdminRequest.from_json(json)
# print the JSON string representation of the object
print(ApiPatchSuperAdminRequest.to_json())

# convert the object into a dict
api_patch_super_admin_request_dict = api_patch_super_admin_request_instance.to_dict()
# create an instance of ApiPatchSuperAdminRequest from a dict
api_patch_super_admin_request_from_dict = ApiPatchSuperAdminRequest.from_dict(api_patch_super_admin_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


