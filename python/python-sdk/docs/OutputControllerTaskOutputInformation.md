# OutputControllerTaskOutputInformation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**task_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**value** | **str** |  | [optional] 
**iteration** | **int** |  | [optional] 
**inline** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.output_controller_task_output_information import OutputControllerTaskOutputInformation

# TODO update the JSON string below
json = "{}"
# create an instance of OutputControllerTaskOutputInformation from a JSON string
output_controller_task_output_information_instance = OutputControllerTaskOutputInformation.from_json(json)
# print the JSON string representation of the object
print(OutputControllerTaskOutputInformation.to_json())

# convert the object into a dict
output_controller_task_output_information_dict = output_controller_task_output_information_instance.to_dict()
# create an instance of OutputControllerTaskOutputInformation from a dict
output_controller_task_output_information_from_dict = OutputControllerTaskOutputInformation.from_dict(output_controller_task_output_information_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


