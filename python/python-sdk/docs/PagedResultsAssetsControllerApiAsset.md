# PagedResultsAssetsControllerApiAsset


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[AssetsControllerApiAsset]**](AssetsControllerApiAsset.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_assets_controller_api_asset import PagedResultsAssetsControllerApiAsset

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsAssetsControllerApiAsset from a JSON string
paged_results_assets_controller_api_asset_instance = PagedResultsAssetsControllerApiAsset.from_json(json)
# print the JSON string representation of the object
print(PagedResultsAssetsControllerApiAsset.to_json())

# convert the object into a dict
paged_results_assets_controller_api_asset_dict = paged_results_assets_controller_api_asset_instance.to_dict()
# create an instance of PagedResultsAssetsControllerApiAsset from a dict
paged_results_assets_controller_api_asset_from_dict = PagedResultsAssetsControllerApiAsset.from_dict(paged_results_assets_controller_api_asset_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


