# PagedResultsBlueprint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Blueprint]**](Blueprint.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_blueprint import PagedResultsBlueprint

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsBlueprint from a JSON string
paged_results_blueprint_instance = PagedResultsBlueprint.from_json(json)
# print the JSON string representation of the object
print(PagedResultsBlueprint.to_json())

# convert the object into a dict
paged_results_blueprint_dict = paged_results_blueprint_instance.to_dict()
# create an instance of PagedResultsBlueprint from a dict
paged_results_blueprint_from_dict = PagedResultsBlueprint.from_dict(paged_results_blueprint_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


