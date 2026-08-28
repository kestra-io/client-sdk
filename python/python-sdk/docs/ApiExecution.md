# ApiExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | 
**id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**flow_revision** | **int** |  | 
**task_run_list** | [**List[ApiTaskRun]**](ApiTaskRun.md) |  | [optional] 
**inputs** | **Dict[str, object]** |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**variables** | **Dict[str, object]** |  | [optional] 
**state** | [**State**](State.md) |  | 
**parent_id** | **str** |  | [optional] 
**original_id** | **str** |  | 
**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | [optional] 
**metadata** | [**ExecutionMetadata**](ExecutionMetadata.md) |  | 
**schedule_date** | **datetime** |  | [optional] 
**trace_parent** | **str** |  | [optional] 
**fixtures** | [**List[TaskFixture]**](TaskFixture.md) |  | [optional] 
**kind** | [**ExecutionKind**](ExecutionKind.md) |  | [optional] 
**breakpoints** | [**List[Breakpoint]**](Breakpoint.md) |  | [optional] 
**loop_run** | [**LoopRun**](LoopRun.md) |  | [optional] 

## Example

```python
from kestrapy.models.api_execution import ApiExecution

# TODO update the JSON string below
json = "{}"
# create an instance of ApiExecution from a JSON string
api_execution_instance = ApiExecution.from_json(json)
# print the JSON string representation of the object
print(ApiExecution.to_json())

# convert the object into a dict
api_execution_dict = api_execution_instance.to_dict()
# create an instance of ApiExecution from a dict
api_execution_from_dict = ApiExecution.from_dict(api_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


