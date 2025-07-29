# PagedResultsAppsControllerApiApp


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[AppsControllerApiApp]**](AppsControllerApiApp.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_apps_controller_api_app import PagedResultsAppsControllerApiApp

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsAppsControllerApiApp from a JSON string
paged_results_apps_controller_api_app_instance = PagedResultsAppsControllerApiApp.from_json(json)
# print the JSON string representation of the object
print(PagedResultsAppsControllerApiApp.to_json())

# convert the object into a dict
paged_results_apps_controller_api_app_dict = paged_results_apps_controller_api_app_instance.to_dict()
# create an instance of PagedResultsAppsControllerApiApp from a dict
paged_results_apps_controller_api_app_from_dict = PagedResultsAppsControllerApiApp.from_dict(paged_results_apps_controller_api_app_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


