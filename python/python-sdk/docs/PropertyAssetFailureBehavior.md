# PropertyAssetFailureBehavior


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expression** | **str** |  | [optional] 
**value** | [**AssetFailureBehavior**](AssetFailureBehavior.md) |  | [optional] 

## Example

```python
from kestrapy.models.property_asset_failure_behavior import PropertyAssetFailureBehavior

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyAssetFailureBehavior from a JSON string
property_asset_failure_behavior_instance = PropertyAssetFailureBehavior.from_json(json)
# print the JSON string representation of the object
print(PropertyAssetFailureBehavior.to_json())

# convert the object into a dict
property_asset_failure_behavior_dict = property_asset_failure_behavior_instance.to_dict()
# create an instance of PropertyAssetFailureBehavior from a dict
property_asset_failure_behavior_from_dict = PropertyAssetFailureBehavior.from_dict(property_asset_failure_behavior_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


