# Executions2


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**result** | **str** |  | [optional] 
**error** | **str** |  | [optional] 
**stack_trace** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.executions2 import Executions2

# TODO update the JSON string below
json = "{}"
# create an instance of Executions2 from a JSON string
executions2_instance = Executions2.from_json(json)
# print the JSON string representation of the object
print(Executions2.to_json())

# convert the object into a dict
executions2_dict = executions2_instance.to_dict()
# create an instance of Executions2 from a dict
executions2_from_dict = Executions2.from_dict(executions2_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


