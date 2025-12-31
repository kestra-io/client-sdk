# AssetsControllerApiAssetUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**asset_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**flow_revision** | **int** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**task_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**created** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.assets_controller_api_asset_usage import AssetsControllerApiAssetUsage

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiAssetUsage from a JSON string
assets_controller_api_asset_usage_instance = AssetsControllerApiAssetUsage.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiAssetUsage.to_json())

# convert the object into a dict
assets_controller_api_asset_usage_dict = assets_controller_api_asset_usage_instance.to_dict()
# create an instance of AssetsControllerApiAssetUsage from a dict
assets_controller_api_asset_usage_from_dict = AssetsControllerApiAssetUsage.from_dict(assets_controller_api_asset_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


