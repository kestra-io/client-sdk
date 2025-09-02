# AppsControllerApiApp


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | 
**id** | **str** |  | 
**name** | **str** |  | 
**type** | **str** |  | 
**namespace** | **str** |  | 
**tags** | **List[str]** |  | 
**enabled** | **bool** |  | 
**created** | **datetime** |  | 
**updated** | **datetime** |  | 

## Example

```python
from kestra_api_client.models.apps_controller_api_app import AppsControllerApiApp

# TODO update the JSON string below
json = "{}"
# create an instance of AppsControllerApiApp from a JSON string
apps_controller_api_app_instance = AppsControllerApiApp.from_json(json)
# print the JSON string representation of the object
print(AppsControllerApiApp.to_json())

# convert the object into a dict
apps_controller_api_app_dict = apps_controller_api_app_instance.to_dict()
# create an instance of AppsControllerApiApp from a dict
apps_controller_api_app_from_dict = AppsControllerApiApp.from_dict(apps_controller_api_app_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


