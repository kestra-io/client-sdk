# PagedResultsTriggerControllerTriggers


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[TriggerControllerTriggers]**](TriggerControllerTriggers.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_trigger_controller_triggers import PagedResultsTriggerControllerTriggers

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsTriggerControllerTriggers from a JSON string
paged_results_trigger_controller_triggers_instance = PagedResultsTriggerControllerTriggers.from_json(json)
# print the JSON string representation of the object
print(PagedResultsTriggerControllerTriggers.to_json())

# convert the object into a dict
paged_results_trigger_controller_triggers_dict = paged_results_trigger_controller_triggers_instance.to_dict()
# create an instance of PagedResultsTriggerControllerTriggers from a dict
paged_results_trigger_controller_triggers_from_dict = PagedResultsTriggerControllerTriggers.from_dict(paged_results_trigger_controller_triggers_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


