# PagedResultsTrigger


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Trigger]**](Trigger.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_trigger import PagedResultsTrigger

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsTrigger from a JSON string
paged_results_trigger_instance = PagedResultsTrigger.from_json(json)
# print the JSON string representation of the object
print(PagedResultsTrigger.to_json())

# convert the object into a dict
paged_results_trigger_dict = paged_results_trigger_instance.to_dict()
# create an instance of PagedResultsTrigger from a dict
paged_results_trigger_from_dict = PagedResultsTrigger.from_dict(paged_results_trigger_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


