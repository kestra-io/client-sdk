# BlueprintControllerApiBlueprintItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**title** | **str** |  | 
**description** | **str** |  | 
**included_tasks** | **List[str]** |  | 
**tags** | **List[str]** |  | 
**published_at** | **datetime** |  | 

## Example

```python
from kestrapy.models.blueprint_controller_api_blueprint_item import BlueprintControllerApiBlueprintItem

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintControllerApiBlueprintItem from a JSON string
blueprint_controller_api_blueprint_item_instance = BlueprintControllerApiBlueprintItem.from_json(json)
# print the JSON string representation of the object
print(BlueprintControllerApiBlueprintItem.to_json())

# convert the object into a dict
blueprint_controller_api_blueprint_item_dict = blueprint_controller_api_blueprint_item_instance.to_dict()
# create an instance of BlueprintControllerApiBlueprintItem from a dict
blueprint_controller_api_blueprint_item_from_dict = BlueprintControllerApiBlueprintItem.from_dict(blueprint_controller_api_blueprint_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


