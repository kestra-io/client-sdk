# AbstractTrigger


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**min_log_level** | [**Level**](Level.md) |  | [optional] 
**id** | **str** |  | 
**type** | **str** |  | 
**version** | **str** |  | [optional] 
**description** | **str** |  | [optional] 
**conditions** | [**List[Condition]**](Condition.md) |  | [optional] 
**disabled** | **bool** |  | 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**log_level** | [**Level**](Level.md) |  | [optional] 
**labels** | [**TheLabelsToPassToTheExecutionCreated**](TheLabelsToPassToTheExecutionCreated.md) |  | [optional] 
**stop_after** | [**List[StateType]**](StateType.md) |  | [optional] 
**log_to_file** | **bool** |  | [optional] 
**fail_on_trigger_error** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.abstract_trigger import AbstractTrigger

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractTrigger from a JSON string
abstract_trigger_instance = AbstractTrigger.from_json(json)
# print the JSON string representation of the object
print(AbstractTrigger.to_json())

# convert the object into a dict
abstract_trigger_dict = abstract_trigger_instance.to_dict()
# create an instance of AbstractTrigger from a dict
abstract_trigger_from_dict = AbstractTrigger.from_dict(abstract_trigger_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


