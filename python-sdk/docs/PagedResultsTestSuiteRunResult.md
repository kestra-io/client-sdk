# PagedResultsTestSuiteRunResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[TestSuiteRunResult]**](TestSuiteRunResult.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestra_api_client.models.paged_results_test_suite_run_result import PagedResultsTestSuiteRunResult

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsTestSuiteRunResult from a JSON string
paged_results_test_suite_run_result_instance = PagedResultsTestSuiteRunResult.from_json(json)
# print the JSON string representation of the object
print(PagedResultsTestSuiteRunResult.to_json())

# convert the object into a dict
paged_results_test_suite_run_result_dict = paged_results_test_suite_run_result_instance.to_dict()
# create an instance of PagedResultsTestSuiteRunResult from a dict
paged_results_test_suite_run_result_from_dict = PagedResultsTestSuiteRunResult.from_dict(paged_results_test_suite_run_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


