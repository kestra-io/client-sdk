# Execution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**labels** | [**List[Label]**](Label.md) |  | 
**id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**flow_revision** | **int** |  | 
**task_run_list** | [**List[TaskRun]**](TaskRun.md) |  | 
**inputs** | **Dict[str, object]** |  | 
**outputs** | **Dict[str, object]** |  | 
**variables** | **Dict[str, object]** |  | 
**state** | [**State**](State.md) |  | 
**parent_id** | **str** |  | 
**original_id** | **str** |  | 
**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | 
**deleted** | **bool** |  | 
**metadata** | [**ExecutionMetadata**](ExecutionMetadata.md) |  | 
**schedule_date** | **datetime** |  | [optional] 
**trace_parent** | **str** |  | 
**fixtures** | [**List[TaskFixture]**](TaskFixture.md) |  | [optional] 
**kind** | [**ExecutionKind**](ExecutionKind.md) |  | [optional] 
**breakpoints** | [**List[Breakpoint]**](Breakpoint.md) |  | [optional] 

## Example

```python
from kestra_api_client.models.execution import Execution

# TODO update the JSON string below
json = "{}"
# create an instance of Execution from a JSON string
execution_instance = Execution.from_json(json)
# print the JSON string representation of the object
print(Execution.to_json())

# convert the object into a dict
execution_dict = execution_instance.to_dict()
# create an instance of Execution from a dict
execution_from_dict = Execution.from_dict(execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


