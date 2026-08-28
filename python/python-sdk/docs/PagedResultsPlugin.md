# PagedResultsPlugin


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Plugin]**](Plugin.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_plugin import PagedResultsPlugin

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsPlugin from a JSON string
paged_results_plugin_instance = PagedResultsPlugin.from_json(json)
# print the JSON string representation of the object
print(PagedResultsPlugin.to_json())

# convert the object into a dict
paged_results_plugin_dict = paged_results_plugin_instance.to_dict()
# create an instance of PagedResultsPlugin from a dict
paged_results_plugin_from_dict = PagedResultsPlugin.from_dict(paged_results_plugin_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


