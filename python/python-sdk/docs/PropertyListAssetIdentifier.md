# PropertyListAssetIdentifier


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | [optional] 
**value** | [**List[AssetIdentifier]**](AssetIdentifier.md) |  | [optional] 

## Example

```python
from kestrapy.models.property_list_asset_identifier import PropertyListAssetIdentifier

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyListAssetIdentifier from a JSON string
property_list_asset_identifier_instance = PropertyListAssetIdentifier.from_json(json)
# print the JSON string representation of the object
print(PropertyListAssetIdentifier.to_json())

# convert the object into a dict
property_list_asset_identifier_dict = property_list_asset_identifier_instance.to_dict()
# create an instance of PropertyListAssetIdentifier from a dict
property_list_asset_identifier_from_dict = PropertyListAssetIdentifier.from_dict(property_list_asset_identifier_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


