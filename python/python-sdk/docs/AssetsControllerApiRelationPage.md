# AssetsControllerApiRelationPage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[AssetsControllerApiRelationItem]**](AssetsControllerApiRelationItem.md) |  | [optional] 
**total** | **int** |  | [optional] 
**next_cursor** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_relation_page import AssetsControllerApiRelationPage

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiRelationPage from a JSON string
assets_controller_api_relation_page_instance = AssetsControllerApiRelationPage.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiRelationPage.to_json())

# convert the object into a dict
assets_controller_api_relation_page_dict = assets_controller_api_relation_page_instance.to_dict()
# create an instance of AssetsControllerApiRelationPage from a dict
assets_controller_api_relation_page_from_dict = AssetsControllerApiRelationPage.from_dict(assets_controller_api_relation_page_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


