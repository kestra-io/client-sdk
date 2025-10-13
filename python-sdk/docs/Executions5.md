# Executions5


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**inputs** | [**List[ExecutionControllerApiValidateExecutionInputsResponseApiInputAndValue]**](ExecutionControllerApiValidateExecutionInputsResponseApiInputAndValue.md) |  | [optional] 

## Example

```python
from kestrapy.models.executions5 import Executions5

# TODO update the JSON string below
json = "{}"
# create an instance of Executions5 from a JSON string
executions5_instance = Executions5.from_json(json)
# print the JSON string representation of the object
print(Executions5.to_json())

# convert the object into a dict
executions5_dict = executions5_instance.to_dict()
# create an instance of Executions5 from a dict
executions5_from_dict = Executions5.from_dict(executions5_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


