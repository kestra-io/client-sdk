# TestSuiteServiceTestRunByQueryResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request_made** | [**TestSuiteServiceRunByQueryRequest**](TestSuiteServiceRunByQueryRequest.md) |  | 
**tenant_id** | **str** |  | 
**number_of_test_suites_to_be_run** | **int** |  | 
**number_of_test_cases_to_be_run** | **int** |  | 
**results** | [**List[TestSuiteRunResult]**](TestSuiteRunResult.md) |  | 

## Example

```python
from kestra_api_client.models.test_suite_service_test_run_by_query_result import TestSuiteServiceTestRunByQueryResult

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuiteServiceTestRunByQueryResult from a JSON string
test_suite_service_test_run_by_query_result_instance = TestSuiteServiceTestRunByQueryResult.from_json(json)
# print the JSON string representation of the object
print(TestSuiteServiceTestRunByQueryResult.to_json())

# convert the object into a dict
test_suite_service_test_run_by_query_result_dict = test_suite_service_test_run_by_query_result_instance.to_dict()
# create an instance of TestSuiteServiceTestRunByQueryResult from a dict
test_suite_service_test_run_by_query_result_from_dict = TestSuiteServiceTestRunByQueryResult.from_dict(test_suite_service_test_run_by_query_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


