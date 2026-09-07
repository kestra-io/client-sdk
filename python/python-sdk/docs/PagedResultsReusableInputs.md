# PagedResultsReusableInputs


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ReusableInputs]**](ReusableInputs.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_reusable_inputs import PagedResultsReusableInputs

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsReusableInputs from a JSON string
paged_results_reusable_inputs_instance = PagedResultsReusableInputs.from_json(json)
# print the JSON string representation of the object
print(PagedResultsReusableInputs.to_json())

# convert the object into a dict
paged_results_reusable_inputs_dict = paged_results_reusable_inputs_instance.to_dict()
# create an instance of PagedResultsReusableInputs from a dict
paged_results_reusable_inputs_from_dict = PagedResultsReusableInputs.from_dict(paged_results_reusable_inputs_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


