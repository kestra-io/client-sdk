# BlueprintControllerApiFlowBlueprint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**included_tasks** | **List[str]** |  | [optional] 
**tags** | **List[str]** |  | [optional] 
**source** | **str** |  | [optional] 
**published_at** | **datetime** |  | [optional] 
**template** | [**BlueprintTemplate**](BlueprintTemplate.md) |  | [optional] 

## Example

```python
from kestrapy.models.blueprint_controller_api_flow_blueprint import BlueprintControllerApiFlowBlueprint

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintControllerApiFlowBlueprint from a JSON string
blueprint_controller_api_flow_blueprint_instance = BlueprintControllerApiFlowBlueprint.from_json(json)
# print the JSON string representation of the object
print(BlueprintControllerApiFlowBlueprint.to_json())

# convert the object into a dict
blueprint_controller_api_flow_blueprint_dict = blueprint_controller_api_flow_blueprint_instance.to_dict()
# create an instance of BlueprintControllerApiFlowBlueprint from a dict
blueprint_controller_api_flow_blueprint_from_dict = BlueprintControllerApiFlowBlueprint.from_dict(blueprint_controller_api_flow_blueprint_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


