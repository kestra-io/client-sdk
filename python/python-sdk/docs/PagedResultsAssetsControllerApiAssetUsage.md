# PagedResultsAssetsControllerApiAssetUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[AssetsControllerApiAssetUsage]**](AssetsControllerApiAssetUsage.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_assets_controller_api_asset_usage import PagedResultsAssetsControllerApiAssetUsage

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsAssetsControllerApiAssetUsage from a JSON string
paged_results_assets_controller_api_asset_usage_instance = PagedResultsAssetsControllerApiAssetUsage.from_json(json)
# print the JSON string representation of the object
print(PagedResultsAssetsControllerApiAssetUsage.to_json())

# convert the object into a dict
paged_results_assets_controller_api_asset_usage_dict = paged_results_assets_controller_api_asset_usage_instance.to_dict()
# create an instance of PagedResultsAssetsControllerApiAssetUsage from a dict
paged_results_assets_controller_api_asset_usage_from_dict = PagedResultsAssetsControllerApiAssetUsage.from_dict(paged_results_assets_controller_api_asset_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


