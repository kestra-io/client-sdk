# AssetsControllerApiRelationSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**List[AssetsControllerApiRelationGroup]**](AssetsControllerApiRelationGroup.md) |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_relation_summary import AssetsControllerApiRelationSummary

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiRelationSummary from a JSON string
assets_controller_api_relation_summary_instance = AssetsControllerApiRelationSummary.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiRelationSummary.to_json())

# convert the object into a dict
assets_controller_api_relation_summary_dict = assets_controller_api_relation_summary_instance.to_dict()
# create an instance of AssetsControllerApiRelationSummary from a dict
assets_controller_api_relation_summary_from_dict = AssetsControllerApiRelationSummary.from_dict(assets_controller_api_relation_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


