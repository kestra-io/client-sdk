# SearchResultFlow


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**model** | [**Flow**](Flow.md) |  | 
**fragments** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.search_result_flow import SearchResultFlow

# TODO update the JSON string below
json = "{}"
# create an instance of SearchResultFlow from a JSON string
search_result_flow_instance = SearchResultFlow.from_json(json)
# print the JSON string representation of the object
print(SearchResultFlow.to_json())

# convert the object into a dict
search_result_flow_dict = search_result_flow_instance.to_dict()
# create an instance of SearchResultFlow from a dict
search_result_flow_from_dict = SearchResultFlow.from_dict(search_result_flow_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


