# Executions1


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Execution]**](Execution.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.executions1 import Executions1

# TODO update the JSON string below
json = "{}"
# create an instance of Executions1 from a JSON string
executions1_instance = Executions1.from_json(json)
# print the JSON string representation of the object
print(Executions1.to_json())

# convert the object into a dict
executions1_dict = executions1_instance.to_dict()
# create an instance of Executions1 from a dict
executions1_from_dict = Executions1.from_dict(executions1_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


