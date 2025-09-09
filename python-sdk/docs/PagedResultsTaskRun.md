# PagedResultsTaskRun


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[TaskRun]**](TaskRun.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_task_run import PagedResultsTaskRun

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsTaskRun from a JSON string
paged_results_task_run_instance = PagedResultsTaskRun.from_json(json)
# print the JSON string representation of the object
print(PagedResultsTaskRun.to_json())

# convert the object into a dict
paged_results_task_run_dict = paged_results_task_run_instance.to_dict()
# create an instance of PagedResultsTaskRun from a dict
paged_results_task_run_from_dict = PagedResultsTaskRun.from_dict(paged_results_task_run_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


