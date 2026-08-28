# PagedResultsAppsControllerApiAppCatalogItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[AppsControllerApiAppCatalogItem]**](AppsControllerApiAppCatalogItem.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_apps_controller_api_app_catalog_item import PagedResultsAppsControllerApiAppCatalogItem

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsAppsControllerApiAppCatalogItem from a JSON string
paged_results_apps_controller_api_app_catalog_item_instance = PagedResultsAppsControllerApiAppCatalogItem.from_json(json)
# print the JSON string representation of the object
print(PagedResultsAppsControllerApiAppCatalogItem.to_json())

# convert the object into a dict
paged_results_apps_controller_api_app_catalog_item_dict = paged_results_apps_controller_api_app_catalog_item_instance.to_dict()
# create an instance of PagedResultsAppsControllerApiAppCatalogItem from a dict
paged_results_apps_controller_api_app_catalog_item_from_dict = PagedResultsAppsControllerApiAppCatalogItem.from_dict(paged_results_apps_controller_api_app_catalog_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


