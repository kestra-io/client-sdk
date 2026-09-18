# AssetsControllerApiAssetLineageEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**flow_revision** | **int** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**task_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**state** | **str** |  | [optional] 
**inputs** | [**List[AssetIdentifier]**](AssetIdentifier.md) |  | [optional] 
**outputs** | [**List[AssetIdentifier]**](AssetIdentifier.md) |  | [optional] 
**created** | **datetime** |  | [optional] 
**start_date** | **datetime** |  | [optional] 
**end_date** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.assets_controller_api_asset_lineage_event import AssetsControllerApiAssetLineageEvent

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiAssetLineageEvent from a JSON string
assets_controller_api_asset_lineage_event_instance = AssetsControllerApiAssetLineageEvent.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiAssetLineageEvent.to_json())

# convert the object into a dict
assets_controller_api_asset_lineage_event_dict = assets_controller_api_asset_lineage_event_instance.to_dict()
# create an instance of AssetsControllerApiAssetLineageEvent from a dict
assets_controller_api_asset_lineage_event_from_dict = AssetsControllerApiAssetLineageEvent.from_dict(assets_controller_api_asset_lineage_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


