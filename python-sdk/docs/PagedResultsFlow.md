# PagedResultsFlow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Flow]**](Flow.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_flow import PagedResultsFlow

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsFlow from a JSON string
paged_results_flow_instance = PagedResultsFlow.from_json(json)
# print the JSON string representation of the object
print(PagedResultsFlow.to_json())

# convert the object into a dict
paged_results_flow_dict = paged_results_flow_instance.to_dict()
# create an instance of PagedResultsFlow from a dict
paged_results_flow_from_dict = PagedResultsFlow.from_dict(paged_results_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


