# Executions7


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**Execution**](Execution.md) |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 
**retry** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.executions7 import Executions7

# TODO update the JSON string below
json = "{}"
# create an instance of Executions7 from a JSON string
executions7_instance = Executions7.from_json(json)
# print the JSON string representation of the object
print(Executions7.to_json())

# convert the object into a dict
executions7_dict = executions7_instance.to_dict()
# create an instance of Executions7 from a dict
executions7_from_dict = Executions7.from_dict(executions7_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


