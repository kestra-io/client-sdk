# IAMRoleControllerApiRoleCreateOrUpdateRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**permissions** | [**IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions**](IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.md) |  | 
**name** | **str** |  | 
**description** | **str** |  | 
**is_default** | **bool** |  | 

## Example

```python
from kestrapy.models.iam_role_controller_api_role_create_or_update_request import IAMRoleControllerApiRoleCreateOrUpdateRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMRoleControllerApiRoleCreateOrUpdateRequest from a JSON string
iam_role_controller_api_role_create_or_update_request_instance = IAMRoleControllerApiRoleCreateOrUpdateRequest.from_json(json)
# print the JSON string representation of the object
print(IAMRoleControllerApiRoleCreateOrUpdateRequest.to_json())

# convert the object into a dict
iam_role_controller_api_role_create_or_update_request_dict = iam_role_controller_api_role_create_or_update_request_instance.to_dict()
# create an instance of IAMRoleControllerApiRoleCreateOrUpdateRequest from a dict
iam_role_controller_api_role_create_or_update_request_from_dict = IAMRoleControllerApiRoleCreateOrUpdateRequest.from_dict(iam_role_controller_api_role_create_or_update_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


