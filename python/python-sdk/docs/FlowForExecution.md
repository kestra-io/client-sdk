# FlowForExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespace** | **str** |  | 
**revision** | **int** |  | [optional] 
**updated** | **datetime** | The timestamp when this revision was created or last updated. | [optional] 
**description** | **str** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**List[Output]**](Output.md) |  | [optional] 
**disabled** | **bool** | A disabled flow does not run: its triggers are paused and new executions are rejected. | 
**draft** | **bool** | Whether this flow revision is a draft. Draft revisions are skipped when an execution starts without an explicit revision (webhooks, schedules, subflows, manual triggers). Executions can still target a draft by passing the revision explicitly. | 
**labels** | [**MapObjectObject**](MapObjectObject.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. | [optional] 
**variables** | **object** |  | [optional] 
**worker_selector** | [**WorkerSelector**](WorkerSelector.md) | Routing requirements (tags + fallback) for this flow. | [optional] 
**deleted** | **bool** |  | 
**tasks** | [**List[TaskForExecution]**](TaskForExecution.md) |  | 
**errors** | [**List[TaskForExecution]**](TaskForExecution.md) |  | [optional] 
**var_finally** | [**List[TaskForExecution]**](TaskForExecution.md) |  | [optional] 
**after_execution** | [**List[TaskForExecution]**](TaskForExecution.md) |  | [optional] 
**triggers** | [**List[AbstractTriggerForExecution]**](AbstractTriggerForExecution.md) |  | [optional] 

## Example

```python
from kestrapy.models.flow_for_execution import FlowForExecution

# TODO update the JSON string below
json = "{}"
# create an instance of FlowForExecution from a JSON string
flow_for_execution_instance = FlowForExecution.from_json(json)
# print the JSON string representation of the object
print(FlowForExecution.to_json())

# convert the object into a dict
flow_for_execution_dict = flow_for_execution_instance.to_dict()
# create an instance of FlowForExecution from a dict
flow_for_execution_from_dict = FlowForExecution.from_dict(flow_for_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


