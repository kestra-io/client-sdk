# BlueprintControllerApiBlueprintTagItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**published_at** | **datetime** |  | 

## Example

```python
from kestra_api_client.models.blueprint_controller_api_blueprint_tag_item import BlueprintControllerApiBlueprintTagItem

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintControllerApiBlueprintTagItem from a JSON string
blueprint_controller_api_blueprint_tag_item_instance = BlueprintControllerApiBlueprintTagItem.from_json(json)
# print the JSON string representation of the object
print(BlueprintControllerApiBlueprintTagItem.to_json())

# convert the object into a dict
blueprint_controller_api_blueprint_tag_item_dict = blueprint_controller_api_blueprint_tag_item_instance.to_dict()
# create an instance of BlueprintControllerApiBlueprintTagItem from a dict
blueprint_controller_api_blueprint_tag_item_from_dict = BlueprintControllerApiBlueprintTagItem.from_dict(blueprint_controller_api_blueprint_tag_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


