# ExecutableTaskSubflowId


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**revision** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.executable_task_subflow_id import ExecutableTaskSubflowId

# TODO update the JSON string below
json = "{}"
# create an instance of ExecutableTaskSubflowId from a JSON string
executable_task_subflow_id_instance = ExecutableTaskSubflowId.from_json(json)
# print the JSON string representation of the object
print(ExecutableTaskSubflowId.to_json())

# convert the object into a dict
executable_task_subflow_id_dict = executable_task_subflow_id_instance.to_dict()
# create an instance of ExecutableTaskSubflowId from a dict
executable_task_subflow_id_from_dict = ExecutableTaskSubflowId.from_dict(executable_task_subflow_id_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


