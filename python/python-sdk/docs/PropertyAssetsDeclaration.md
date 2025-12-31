# PropertyAssetsDeclaration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | [optional] 
**value** | [**AssetsDeclaration**](AssetsDeclaration.md) |  | [optional] 

## Example

```python
from kestrapy.models.property_assets_declaration import PropertyAssetsDeclaration

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyAssetsDeclaration from a JSON string
property_assets_declaration_instance = PropertyAssetsDeclaration.from_json(json)
# print the JSON string representation of the object
print(PropertyAssetsDeclaration.to_json())

# convert the object into a dict
property_assets_declaration_dict = property_assets_declaration_instance.to_dict()
# create an instance of PropertyAssetsDeclaration from a dict
property_assets_declaration_from_dict = PropertyAssetsDeclaration.from_dict(property_assets_declaration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


