# Executions10


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**ExecutionStatusEvent**](ExecutionStatusEvent.md) |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 
**retry** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.executions10 import Executions10

# TODO update the JSON string below
json = "{}"
# create an instance of Executions10 from a JSON string
executions10_instance = Executions10.from_json(json)
# print the JSON string representation of the object
print(Executions10.to_json())

# convert the object into a dict
executions10_dict = executions10_instance.to_dict()
# create an instance of Executions10 from a dict
executions10_from_dict = Executions10.from_dict(executions10_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


