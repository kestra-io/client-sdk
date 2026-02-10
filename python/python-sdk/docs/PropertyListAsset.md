# PropertyListAsset


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | [optional] 
**value** | [**List[Asset]**](Asset.md) |  | [optional] 

## Example

```python
from kestrapy.models.property_list_asset import PropertyListAsset

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyListAsset from a JSON string
property_list_asset_instance = PropertyListAsset.from_json(json)
# print the JSON string representation of the object
print(PropertyListAsset.to_json())

# convert the object into a dict
property_list_asset_dict = property_list_asset_instance.to_dict()
# create an instance of PropertyListAsset from a dict
property_list_asset_from_dict = PropertyListAsset.from_dict(property_list_asset_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


