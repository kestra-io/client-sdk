# PagedResultsApiTriggerState


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiTriggerState]**](ApiTriggerState.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_trigger_state import PagedResultsApiTriggerState

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiTriggerState from a JSON string
paged_results_api_trigger_state_instance = PagedResultsApiTriggerState.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiTriggerState.to_json())

# convert the object into a dict
paged_results_api_trigger_state_dict = paged_results_api_trigger_state_instance.to_dict()
# create an instance of PagedResultsApiTriggerState from a dict
paged_results_api_trigger_state_from_dict = PagedResultsApiTriggerState.from_dict(paged_results_api_trigger_state_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


