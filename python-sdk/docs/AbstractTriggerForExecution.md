# AbstractTriggerForExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**version** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.abstract_trigger_for_execution import AbstractTriggerForExecution

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractTriggerForExecution from a JSON string
abstract_trigger_for_execution_instance = AbstractTriggerForExecution.from_json(json)
# print the JSON string representation of the object
print(AbstractTriggerForExecution.to_json())

# convert the object into a dict
abstract_trigger_for_execution_dict = abstract_trigger_for_execution_instance.to_dict()
# create an instance of AbstractTriggerForExecution from a dict
abstract_trigger_for_execution_from_dict = AbstractTriggerForExecution.from_dict(abstract_trigger_for_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


