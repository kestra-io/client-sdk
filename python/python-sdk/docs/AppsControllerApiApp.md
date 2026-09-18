# AppsControllerApiApp


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**enabled** | **bool** |  | [optional] 
**created** | **datetime** |  | [optional] 
**updated** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.apps_controller_api_app import AppsControllerApiApp

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


