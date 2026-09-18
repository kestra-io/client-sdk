# FlowWithSource


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespace** | **str** |  | 
**revision** | **int** |  | [optional] 
**updated** | **datetime** | The timestamp when this revision was created or last updated. | [optional] 
**description** | **str** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**List[Output]**](Output.md) | Output values make information about the execution of your Flow available and expose for other Kestra flows to use. Output values are similar to return values in programming languages. | [optional] 
**disabled** | **bool** | A disabled flow does not run: its triggers are paused and new executions are rejected. | 
**draft** | **bool** | Whether this flow revision is a draft. Draft revisions are skipped when an execution starts without an explicit revision (webhooks, schedules, subflows, manual triggers). Executions can still target a draft by passing the revision explicitly. | 
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**variables** | **object** |  | [optional] 
**worker_selector** | [**WorkerSelector**](WorkerSelector.md) | Routing requirements (tags + fallback) for this flow. | [optional] 
**deleted** | **bool** |  | 
**var_finally** | [**List[Task]**](Task.md) |  | [optional] 
**tasks** | [**Dict[Task]**](Task.md) |  | 
**errors** | [**List[Task]**](Task.md) |  | [optional] 
**after_execution** | [**List[Task]**](Task.md) |  | [optional] 
**triggers** | [**List[AbstractTrigger]**](AbstractTrigger.md) |  | [optional] 
**policy_refs** | **List[str]** | Identifiers of &#x60;enforcement: REFERENCE&#x60; policies to attach to this flow, resolved within the flow&#39;s tenant/namespace scope chain. Enterprise Edition only; parsed but ignored in the open-source edition. | [optional] 
**concurrency** | [**Concurrency**](Concurrency.md) | Limits the number of concurrent executions of the flow. | [optional] 
**retry** | **object** | Retry policy applied when the flow fails. | [optional] 
**sla** | [**List[SLA]**](SLA.md) |  | [optional] 
**checks** | [**List[Check]**](Check.md) | A list of conditions that are evaluated before the flow is executed.  If no checks are defined, the flow executes normally. | [optional] 
**quotas** | [**List[Quota]**](Quota.md) | A list of quotas that are evaluated before the flow is executed. If no quotas are defined, the flow executes normally. Quotas can also be defined at the namespace and tenant level. | [optional] 
**source** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.flow_with_source import FlowWithSource

# TODO update the JSON string below
json = "{}"
# create an instance of FlowWithSource from a JSON string
flow_with_source_instance = FlowWithSource.from_json(json)
# print the JSON string representation of the object
print(FlowWithSource.to_json())

# convert the object into a dict
flow_with_source_dict = flow_with_source_instance.to_dict()
# create an instance of FlowWithSource from a dict
flow_with_source_from_dict = FlowWithSource.from_dict(flow_with_source_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


