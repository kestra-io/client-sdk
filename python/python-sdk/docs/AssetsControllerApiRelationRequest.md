# AssetsControllerApiRelationRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**kind** | [**RelationKind**](RelationKind.md) |  | 
**direction** | [**RelationDirection**](RelationDirection.md) |  | 
**target_id** | **str** |  | 
**target_namespace** | **str** |  | [optional] 
**role** | **str** |  | [optional] 

## Example

```python
import kestrapy
from kestrapy.models.assets_controller_api_relation_request import AssetsControllerApiRelationRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AssetsControllerApiRelationRequest from a JSON string
assets_controller_api_relation_request_instance = AssetsControllerApiRelationRequest.from_json(json)
# print the JSON string representation of the object
print(AssetsControllerApiRelationRequest.to_json())

# convert the object into a dict
assets_controller_api_relation_request_dict = assets_controller_api_relation_request_instance.to_dict()
# create an instance of AssetsControllerApiRelationRequest from a dict
assets_controller_api_relation_request_from_dict = AssetsControllerApiRelationRequest.from_dict(assets_controller_api_relation_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


