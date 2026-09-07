# FlowControllerFlowWithDeprecatedTasks


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**revision** | **int** |  | [optional] 
**deprecated_tasks** | [**List[FlowServiceTaskDeprecation]**](FlowServiceTaskDeprecation.md) |  | [optional] 

## Example

```python
from kestrapy.models.flow_controller_flow_with_deprecated_tasks import FlowControllerFlowWithDeprecatedTasks

# TODO update the JSON string below
json = "{}"
# create an instance of FlowControllerFlowWithDeprecatedTasks from a JSON string
flow_controller_flow_with_deprecated_tasks_instance = FlowControllerFlowWithDeprecatedTasks.from_json(json)
# print the JSON string representation of the object
print(FlowControllerFlowWithDeprecatedTasks.to_json())

# convert the object into a dict
flow_controller_flow_with_deprecated_tasks_dict = flow_controller_flow_with_deprecated_tasks_instance.to_dict()
# create an instance of FlowControllerFlowWithDeprecatedTasks from a dict
flow_controller_flow_with_deprecated_tasks_from_dict = FlowControllerFlowWithDeprecatedTasks.from_dict(flow_controller_flow_with_deprecated_tasks_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


