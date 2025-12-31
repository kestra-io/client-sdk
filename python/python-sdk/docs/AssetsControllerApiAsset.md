# AssetsControllerApiAsset


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**type** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**metadata** | **Dict[str, object]** |  | [optional] 
**created** | **datetime** |  | [optional] 
**updated** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.assets_controller_api_asset import AssetsControllerApiAsset

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiAsset from a JSON string
assets_controller_api_asset_instance = AssetsControllerApiAsset.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiAsset.to_json())

# convert the object into a dict
assets_controller_api_asset_dict = assets_controller_api_asset_instance.to_dict()
# create an instance of AssetsControllerApiAsset from a dict
assets_controller_api_asset_from_dict = AssetsControllerApiAsset.from_dict(assets_controller_api_asset_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


