# PagedResultsNamespace


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Namespace]**](Namespace.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_namespace import PagedResultsNamespace

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsNamespace from a JSON string
paged_results_namespace_instance = PagedResultsNamespace.from_json(json)
# print the JSON string representation of the object
print(PagedResultsNamespace.to_json())

# convert the object into a dict
paged_results_namespace_dict = paged_results_namespace_instance.to_dict()
# create an instance of PagedResultsNamespace from a dict
paged_results_namespace_from_dict = PagedResultsNamespace.from_dict(paged_results_namespace_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


