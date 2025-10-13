# Executions9


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**namespace** | **str** |  | 
**revision** | **int** |  | [optional] 
**description** | **str** |  | [optional] 
**inputs** | [**List[InputObject]**](InputObject.md) |  | [optional] 
**outputs** | [**List[Output]**](Output.md) |  | [optional] 
**disabled** | **bool** |  | 
**labels** | [**List[Label]**](Label.md) | Labels as a list of Label (key/value pairs) or as a map of string to string. | [optional] 
**variables** | **object** |  | [optional] 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**deleted** | **bool** |  | 
**tasks** | [**List[TaskForExecution]**](TaskForExecution.md) |  | 
**errors** | [**List[TaskForExecution]**](TaskForExecution.md) |  | [optional] 
**var_finally** | [**List[TaskForExecution]**](TaskForExecution.md) |  | [optional] 
**after_execution** | [**List[TaskForExecution]**](TaskForExecution.md) |  | [optional] 
**triggers** | [**List[AbstractTriggerForExecution]**](AbstractTriggerForExecution.md) |  | [optional] 

## Example

```python
from kestrapy.models.executions9 import Executions9

# TODO update the JSON string below
json = "{}"
# create an instance of Executions9 from a JSON string
executions9_instance = Executions9.from_json(json)
# print the JSON string representation of the object
print(Executions9.to_json())

# convert the object into a dict
executions9_dict = executions9_instance.to_dict()
# create an instance of Executions9 from a dict
executions9_from_dict = Executions9.from_dict(executions9_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


