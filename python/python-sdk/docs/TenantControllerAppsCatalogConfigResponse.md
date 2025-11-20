# TenantControllerAppsCatalogConfigResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **str** |  | [optional] 
**title_color** | **str** |  | [optional] 
**primary_color** | **str** |  | [optional] 
**logo** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.tenant_controller_apps_catalog_config_response import TenantControllerAppsCatalogConfigResponse

# TODO update the JSON string below
json = "{}"
# create an instance of TenantControllerAppsCatalogConfigResponse from a JSON string
tenant_controller_apps_catalog_config_response_instance = TenantControllerAppsCatalogConfigResponse.from_json(json)
# print the JSON string representation of the object
print(TenantControllerAppsCatalogConfigResponse.to_json())

# convert the object into a dict
tenant_controller_apps_catalog_config_response_dict = tenant_controller_apps_catalog_config_response_instance.to_dict()
# create an instance of TenantControllerAppsCatalogConfigResponse from a dict
tenant_controller_apps_catalog_config_response_from_dict = TenantControllerAppsCatalogConfigResponse.from_dict(tenant_controller_apps_catalog_config_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


