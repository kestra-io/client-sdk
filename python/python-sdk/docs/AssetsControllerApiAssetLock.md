# AssetsControllerApiAssetLock


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**locked_until** | **datetime** |  | [optional] 
**acquired_at** | **datetime** |  | [optional] 
**owner_type** | **str** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**flow_namespace** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**username** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.assets_controller_api_asset_lock import AssetsControllerApiAssetLock

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiAssetLock from a JSON string
assets_controller_api_asset_lock_instance = AssetsControllerApiAssetLock.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiAssetLock.to_json())

# convert the object into a dict
assets_controller_api_asset_lock_dict = assets_controller_api_asset_lock_instance.to_dict()
# create an instance of AssetsControllerApiAssetLock from a dict
assets_controller_api_asset_lock_from_dict = AssetsControllerApiAssetLock.from_dict(assets_controller_api_asset_lock_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


