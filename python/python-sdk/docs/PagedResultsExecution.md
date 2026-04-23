# PagedResultsExecution


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Execution]**](Execution.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_execution import PagedResultsExecution

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsExecution from a JSON string
paged_results_execution_instance = PagedResultsExecution.from_json(json)
# print the JSON string representation of the object
print(PagedResultsExecution.to_json())

# convert the object into a dict
paged_results_execution_dict = paged_results_execution_instance.to_dict()
# create an instance of PagedResultsExecution from a dict
paged_results_execution_from_dict = PagedResultsExecution.from_dict(paged_results_execution_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


