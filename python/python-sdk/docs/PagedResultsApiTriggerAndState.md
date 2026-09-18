# PagedResultsApiTriggerAndState


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiTriggerAndState]**](ApiTriggerAndState.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_trigger_and_state import PagedResultsApiTriggerAndState

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiTriggerAndState from a JSON string
paged_results_api_trigger_and_state_instance = PagedResultsApiTriggerAndState.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiTriggerAndState.to_json())

# convert the object into a dict
paged_results_api_trigger_and_state_dict = paged_results_api_trigger_and_state_instance.to_dict()
# create an instance of PagedResultsApiTriggerAndState from a dict
paged_results_api_trigger_and_state_from_dict = PagedResultsApiTriggerAndState.from_dict(paged_results_api_trigger_and_state_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


