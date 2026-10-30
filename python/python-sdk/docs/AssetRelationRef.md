# AssetRelationRef


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespace** | **str** |  | [optional] 
**role** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.asset_relation_ref import AssetRelationRef

# TODO update the JSON string below
json = "{}"
# create an instance of AssetRelationRef from a JSON string
asset_relation_ref_instance = AssetRelationRef.from_json(json)
# print the JSON string representation of the object
print(AssetRelationRef.to_json())

# convert the object into a dict
asset_relation_ref_dict = asset_relation_ref_instance.to_dict()
# create an instance of AssetRelationRef from a dict
asset_relation_ref_from_dict = AssetRelationRef.from_dict(asset_relation_ref_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


