# AppsControllerApiAppCatalogItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | 
**name** | **str** |  | 
**description** | **str** |  | 
**type** | **str** |  | 
**tags** | **List[str]** |  | 

## Example

```python
from kestrapy.models.apps_controller_api_app_catalog_item import AppsControllerApiAppCatalogItem

# TODO update the JSON string below
json = "{}"
# create an instance of AppsControllerApiAppCatalogItem from a JSON string
apps_controller_api_app_catalog_item_instance = AppsControllerApiAppCatalogItem.from_json(json)
# print the JSON string representation of the object
print(AppsControllerApiAppCatalogItem.to_json())

# convert the object into a dict
apps_controller_api_app_catalog_item_dict = apps_controller_api_app_catalog_item_instance.to_dict()
# create an instance of AppsControllerApiAppCatalogItem from a dict
apps_controller_api_app_catalog_item_from_dict = AppsControllerApiAppCatalogItem.from_dict(apps_controller_api_app_catalog_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


