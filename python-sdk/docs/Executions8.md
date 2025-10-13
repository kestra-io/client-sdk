# Executions8


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 
**id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**flow_revision** | **int** |  | [optional] 
**trigger** | [**ExecutionTrigger**](ExecutionTrigger.md) |  | [optional] 
**outputs** | **Dict[str, object]** |  | [optional] 
**labels** | [**List[Label]**](Label.md) |  | [optional] 
**state** | [**State**](State.md) |  | [optional] 
**url** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.executions8 import Executions8

# TODO update the JSON string below
json = "{}"
# create an instance of Executions8 from a JSON string
executions8_instance = Executions8.from_json(json)
# print the JSON string representation of the object
print(Executions8.to_json())

# convert the object into a dict
executions8_dict = executions8_instance.to_dict()
# create an instance of Executions8 from a dict
executions8_from_dict = Executions8.from_dict(executions8_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


