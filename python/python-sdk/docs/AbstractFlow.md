# AbstractFlow


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
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**variables** | **object** |  | [optional] 
**worker_selector** | [**WorkerSelector**](WorkerSelector.md) | Routing requirements (tags + fallback) for this flow. | [optional] 
**deleted** | **bool** |  | 

## Example

```python
from kestrapy.models.abstract_flow import AbstractFlow

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractFlow from a JSON string
abstract_flow_instance = AbstractFlow.from_json(json)
# print the JSON string representation of the object
print(AbstractFlow.to_json())

# convert the object into a dict
abstract_flow_dict = abstract_flow_instance.to_dict()
# create an instance of AbstractFlow from a dict
abstract_flow_from_dict = AbstractFlow.from_dict(abstract_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


