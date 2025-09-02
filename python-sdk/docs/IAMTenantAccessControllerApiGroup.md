# IAMTenantAccessControllerApiGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**external** | **bool** |  | 

## Example

```python
from kestra_api_client.models.iam_tenant_access_controller_api_group import IAMTenantAccessControllerApiGroup

# TODO update the JSON string below
json = "{}"
# create an instance of IAMTenantAccessControllerApiGroup from a JSON string
iam_tenant_access_controller_api_group_instance = IAMTenantAccessControllerApiGroup.from_json(json)
# print the JSON string representation of the object
print(IAMTenantAccessControllerApiGroup.to_json())

# convert the object into a dict
iam_tenant_access_controller_api_group_dict = iam_tenant_access_controller_api_group_instance.to_dict()
# create an instance of IAMTenantAccessControllerApiGroup from a dict
iam_tenant_access_controller_api_group_from_dict = IAMTenantAccessControllerApiGroup.from_dict(iam_tenant_access_controller_api_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


