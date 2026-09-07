# AssetsDeclaration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**enable_auto** | [**PropertyBoolean**](PropertyBoolean.md) |  | [optional] 
**inputs** | [**PropertyListAssetIdentifier**](PropertyListAssetIdentifier.md) |  | [optional] 
**outputs** | [**PropertyListAsset**](PropertyListAsset.md) |  | [optional] 
**asset_failure_behavior** | [**PropertyAssetFailureBehavior**](PropertyAssetFailureBehavior.md) | Behavior applied to the task state when a declared asset fails to render, emit, or be persisted (e.g. a lock conflict): FAIL escalates it to FAILED, WARN (default) warns it if it would otherwise succeed, IGNORE leaves the state untouched. | [optional] 

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


