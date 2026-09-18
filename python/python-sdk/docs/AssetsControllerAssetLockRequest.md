# AssetsControllerAssetLockRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ttl** | **str** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**flow_namespace** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.assets_controller_asset_lock_request import AssetsControllerAssetLockRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerAssetLockRequest from a JSON string
assets_controller_asset_lock_request_instance = AssetsControllerAssetLockRequest.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerAssetLockRequest.to_json())

# convert the object into a dict
assets_controller_asset_lock_request_dict = assets_controller_asset_lock_request_instance.to_dict()
# create an instance of AssetsControllerAssetLockRequest from a dict
assets_controller_asset_lock_request_from_dict = AssetsControllerAssetLockRequest.from_dict(assets_controller_asset_lock_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


