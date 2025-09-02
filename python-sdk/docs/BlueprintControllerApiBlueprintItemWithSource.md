# BlueprintControllerApiBlueprintItemWithSource


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**title** | **str** |  | 
**description** | **str** |  | 
**included_tasks** | **List[str]** |  | 
**tags** | **List[str]** |  | 
**published_at** | **datetime** |  | 
**source** | **str** |  | [optional] 
**kind** | [**BlueprintControllerKind**](BlueprintControllerKind.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.blueprint_controller_api_blueprint_item_with_source import BlueprintControllerApiBlueprintItemWithSource

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintControllerApiBlueprintItemWithSource from a JSON string
blueprint_controller_api_blueprint_item_with_source_instance = BlueprintControllerApiBlueprintItemWithSource.from_json(json)
# print the JSON string representation of the object
print(BlueprintControllerApiBlueprintItemWithSource.to_json())

# convert the object into a dict
blueprint_controller_api_blueprint_item_with_source_dict = blueprint_controller_api_blueprint_item_with_source_instance.to_dict()
# create an instance of BlueprintControllerApiBlueprintItemWithSource from a dict
blueprint_controller_api_blueprint_item_with_source_from_dict = BlueprintControllerApiBlueprintItemWithSource.from_dict(blueprint_controller_api_blueprint_item_with_source_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


