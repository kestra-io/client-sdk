# TenantControllerAppsCatalogConfigRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **str** |  | [optional] 
**title_color** | **str** |  | [optional] 
**primary_color** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.tenant_controller_apps_catalog_config_request import TenantControllerAppsCatalogConfigRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TenantControllerAppsCatalogConfigRequest from a JSON string
tenant_controller_apps_catalog_config_request_instance = TenantControllerAppsCatalogConfigRequest.from_json(json)
# print the JSON string representation of the object
print(TenantControllerAppsCatalogConfigRequest.to_json())

# convert the object into a dict
tenant_controller_apps_catalog_config_request_dict = tenant_controller_apps_catalog_config_request_instance.to_dict()
# create an instance of TenantControllerAppsCatalogConfigRequest from a dict
tenant_controller_apps_catalog_config_request_from_dict = TenantControllerAppsCatalogConfigRequest.from_dict(tenant_controller_apps_catalog_config_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


