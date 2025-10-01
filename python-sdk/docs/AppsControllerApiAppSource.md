# AppsControllerApiAppSource


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**disabled** | **bool** |  | [optional] 
**source** | **str** |  | [optional] 
**created** | **datetime** |  | [optional] 
**updated** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.apps_controller_api_app_source import AppsControllerApiAppSource

# TODO update the JSON string below
json = "{}"
# create an instance of AppsControllerApiAppSource from a JSON string
apps_controller_api_app_source_instance = AppsControllerApiAppSource.from_json(json)
# print the JSON string representation of the object
print(AppsControllerApiAppSource.to_json())

# convert the object into a dict
apps_controller_api_app_source_dict = apps_controller_api_app_source_instance.to_dict()
# create an instance of AppsControllerApiAppSource from a dict
apps_controller_api_app_source_from_dict = AppsControllerApiAppSource.from_dict(apps_controller_api_app_source_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


