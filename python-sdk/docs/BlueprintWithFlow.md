# BlueprintWithFlow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**title** | **str** |  | 
**description** | **str** |  | 
**tags** | **List[str]** |  | 
**included_tasks** | **List[str]** |  | 
**published_at** | **datetime** |  | 
**deleted** | **bool** |  | 
**flow** | **str** |  | 

## Example

```python
from kestra_api_client.models.blueprint_with_flow import BlueprintWithFlow

# TODO update the JSON string below
json = "{}"
# create an instance of BlueprintWithFlow from a JSON string
blueprint_with_flow_instance = BlueprintWithFlow.from_json(json)
# print the JSON string representation of the object
print(BlueprintWithFlow.to_json())

# convert the object into a dict
blueprint_with_flow_dict = blueprint_with_flow_instance.to_dict()
# create an instance of BlueprintWithFlow from a dict
blueprint_with_flow_from_dict = BlueprintWithFlow.from_dict(blueprint_with_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


