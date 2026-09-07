# PagedResultsMapStringObject


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | **List[Dict[str, object]]** |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_map_string_object import PagedResultsMapStringObject

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsMapStringObject from a JSON string
paged_results_map_string_object_instance = PagedResultsMapStringObject.from_json(json)
# print the JSON string representation of the object
print(PagedResultsMapStringObject.to_json())

# convert the object into a dict
paged_results_map_string_object_dict = paged_results_map_string_object_instance.to_dict()
# create an instance of PagedResultsMapStringObject from a dict
paged_results_map_string_object_from_dict = PagedResultsMapStringObject.from_dict(paged_results_map_string_object_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


