# AssetsControllerApiParentRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parent_id** | **str** |  | 
**namespace** | **str** |  | [optional] 
**role** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_parent_request import AssetsControllerApiParentRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiParentRequest from a JSON string
assets_controller_api_parent_request_instance = AssetsControllerApiParentRequest.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiParentRequest.to_json())

# convert the object into a dict
assets_controller_api_parent_request_dict = assets_controller_api_parent_request_instance.to_dict()
# create an instance of AssetsControllerApiParentRequest from a dict
assets_controller_api_parent_request_from_dict = AssetsControllerApiParentRequest.from_dict(assets_controller_api_parent_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


