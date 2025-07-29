# PagedResultsNamespaceWithDisabled


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[NamespaceWithDisabled]**](NamespaceWithDisabled.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_namespace_with_disabled import PagedResultsNamespaceWithDisabled

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsNamespaceWithDisabled from a JSON string
paged_results_namespace_with_disabled_instance = PagedResultsNamespaceWithDisabled.from_json(json)
# print the JSON string representation of the object
print(PagedResultsNamespaceWithDisabled.to_json())

# convert the object into a dict
paged_results_namespace_with_disabled_dict = paged_results_namespace_with_disabled_instance.to_dict()
# create an instance of PagedResultsNamespaceWithDisabled from a dict
paged_results_namespace_with_disabled_from_dict = PagedResultsNamespaceWithDisabled.from_dict(paged_results_namespace_with_disabled_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


