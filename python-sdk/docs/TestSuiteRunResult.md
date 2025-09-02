# TestSuiteRunResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**test_suite_id** | **str** |  | 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**state** | [**TestState**](TestState.md) |  | 
**start_date** | **datetime** |  | 
**end_date** | **datetime** |  | 
**results** | [**List[UnitTestResult]**](UnitTestResult.md) |  | 

## Example

```python
from kestrapy.models.test_suite_run_result import TestSuiteRunResult

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuiteRunResult from a JSON string
test_suite_run_result_instance = TestSuiteRunResult.from_json(json)
# print the JSON string representation of the object
print(TestSuiteRunResult.to_json())

# convert the object into a dict
test_suite_run_result_dict = test_suite_run_result_instance.to_dict()
# create an instance of TestSuiteRunResult from a dict
test_suite_run_result_from_dict = TestSuiteRunResult.from_dict(test_suite_run_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


