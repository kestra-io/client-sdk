# ApiLightExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | 
**id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**flow_revision** | **int** |  | 
**inputs** | **Dict[str, object]** |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**state** | [**State**](State.md) |  | 
**parent_id** | **str** |  | [optional] 
**original_id** | **str** |  | 
**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | [optional] 
**schedule_date** | **datetime** |  | [optional] 
**kind** | [**ExecutionKind**](ExecutionKind.md) |  | [optional] 
**loop_run** | [**LoopRun**](LoopRun.md) |  | [optional] 

## Example

```python
from kestrapy.models.api_light_execution import ApiLightExecution

# TODO update the JSON string below
json = "{}"
# create an instance of ApiLightExecution from a JSON string
api_light_execution_instance = ApiLightExecution.from_json(json)
# print the JSON string representation of the object
print(ApiLightExecution.to_json())

# convert the object into a dict
api_light_execution_dict = api_light_execution_instance.to_dict()
# create an instance of ApiLightExecution from a dict
api_light_execution_from_dict = ApiLightExecution.from_dict(api_light_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


