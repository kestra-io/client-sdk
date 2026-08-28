# FlowServiceTaskDeprecation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**task_id** | **str** |  | [optional] 
**task_type** | **str** |  | [optional] 
**replacement** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.flow_service_task_deprecation import FlowServiceTaskDeprecation

# TODO update the JSON string below
json = "{}"
# create an instance of FlowServiceTaskDeprecation from a JSON string
flow_service_task_deprecation_instance = FlowServiceTaskDeprecation.from_json(json)
# print the JSON string representation of the object
print(FlowServiceTaskDeprecation.to_json())

# convert the object into a dict
flow_service_task_deprecation_dict = flow_service_task_deprecation_instance.to_dict()
# create an instance of FlowServiceTaskDeprecation from a dict
flow_service_task_deprecation_from_dict = FlowServiceTaskDeprecation.from_dict(flow_service_task_deprecation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


