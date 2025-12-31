# AssetsInOut


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**inputs** | [**List[AssetIdentifier]**](AssetIdentifier.md) |  | [optional] 
**outputs** | [**List[Asset]**](Asset.md) |  | [optional] 

## Example

```python
from kestrapy.models.assets_in_out import AssetsInOut

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsInOut from a JSON string
assets_in_out_instance = AssetsInOut.from_json(json)
# print the JSON string representation of the object
print(AssetsInOut.to_json())

# convert the object into a dict
assets_in_out_dict = assets_in_out_instance.to_dict()
# create an instance of AssetsInOut from a dict
assets_in_out_from_dict = AssetsInOut.from_dict(assets_in_out_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


