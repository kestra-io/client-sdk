# AssetsDeclaration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**enable_auto** | [**PropertyBoolean**](PropertyBoolean.md) |  | [optional] 
**inputs** | [**PropertyListAssetIdentifier**](PropertyListAssetIdentifier.md) |  | [optional] 
**outputs** | [**PropertyListAsset**](PropertyListAsset.md) |  | [optional] 

## Example

```python
from kestrapy.models.assets_declaration import AssetsDeclaration

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsDeclaration from a JSON string
assets_declaration_instance = AssetsDeclaration.from_json(json)
# print the JSON string representation of the object
print(AssetsDeclaration.to_json())

# convert the object into a dict
assets_declaration_dict = assets_declaration_instance.to_dict()
# create an instance of AssetsDeclaration from a dict
assets_declaration_from_dict = AssetsDeclaration.from_dict(assets_declaration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


