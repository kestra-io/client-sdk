# IAMUserControllerApiTenant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 

## Example

```python
from kestra_api_client.models.iam_user_controller_api_tenant import IAMUserControllerApiTenant

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiTenant from a JSON string
iam_user_controller_api_tenant_instance = IAMUserControllerApiTenant.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiTenant.to_json())

# convert the object into a dict
iam_user_controller_api_tenant_dict = iam_user_controller_api_tenant_instance.to_dict()
# create an instance of IAMUserControllerApiTenant from a dict
iam_user_controller_api_tenant_from_dict = IAMUserControllerApiTenant.from_dict(iam_user_controller_api_tenant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


