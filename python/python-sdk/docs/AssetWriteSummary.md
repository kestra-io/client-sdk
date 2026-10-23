# AssetWriteSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**execution_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**task_id** | **str** |  | [optional] 
**task_type** | **str** |  | [optional] 
**state** | [**StateType**](StateType.md) |  | [optional] 
**created** | **datetime** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.asset_write_summary import AssetWriteSummary

# TODO update the JSON string below
json = "{}"
# create an instance of AssetWriteSummary from a JSON string
asset_write_summary_instance = AssetWriteSummary.from_json(json)
# print the JSON string representation of the object
print(AssetWriteSummary.to_json())

# convert the object into a dict
asset_write_summary_dict = asset_write_summary_instance.to_dict()
# create an instance of AssetWriteSummary from a dict
asset_write_summary_from_dict = AssetWriteSummary.from_dict(asset_write_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


