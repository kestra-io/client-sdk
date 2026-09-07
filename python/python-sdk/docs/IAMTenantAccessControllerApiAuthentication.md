# IAMTenantAccessControllerApiAuthentication


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**type** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.iam_tenant_access_controller_api_authentication import IAMTenantAccessControllerApiAuthentication

# TODO update the JSON string below
json = "{}"
# create an instance of IAMTenantAccessControllerApiAuthentication from a JSON string
iam_tenant_access_controller_api_authentication_instance = IAMTenantAccessControllerApiAuthentication.from_json(json)
# print the JSON string representation of the object
print(IAMTenantAccessControllerApiAuthentication.to_json())

# convert the object into a dict
iam_tenant_access_controller_api_authentication_dict = iam_tenant_access_controller_api_authentication_instance.to_dict()
# create an instance of IAMTenantAccessControllerApiAuthentication from a dict
iam_tenant_access_controller_api_authentication_from_dict = IAMTenantAccessControllerApiAuthentication.from_dict(iam_tenant_access_controller_api_authentication_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


