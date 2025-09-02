# IAMRoleControllerApiRoleDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**description** | **str** |  | 
**permissions** | [**IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions**](IAMRoleControllerApiRoleCreateOrUpdateRequestPermissions.md) |  | 
**is_default** | **bool** |  | 
**is_managed** | **bool** |  | 

## Example

```python
from kestrapy.models.iam_role_controller_api_role_detail import IAMRoleControllerApiRoleDetail

# TODO update the JSON string below
json = "{}"
# create an instance of IAMRoleControllerApiRoleDetail from a JSON string
iam_role_controller_api_role_detail_instance = IAMRoleControllerApiRoleDetail.from_json(json)
# print the JSON string representation of the object
print(IAMRoleControllerApiRoleDetail.to_json())

# convert the object into a dict
iam_role_controller_api_role_detail_dict = iam_role_controller_api_role_detail_instance.to_dict()
# create an instance of IAMRoleControllerApiRoleDetail from a dict
iam_role_controller_api_role_detail_from_dict = IAMRoleControllerApiRoleDetail.from_dict(iam_role_controller_api_role_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


