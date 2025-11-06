# TestSuiteControllerTestsLastResultResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[TestSuiteRunResult]**](TestSuiteRunResult.md) |  | [optional] 

## Example

```python
from kestrapy.models.test_suite_controller_tests_last_result_response import TestSuiteControllerTestsLastResultResponse

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuiteControllerTestsLastResultResponse from a JSON string
test_suite_controller_tests_last_result_response_instance = TestSuiteControllerTestsLastResultResponse.from_json(json)
# print the JSON string representation of the object
print(TestSuiteControllerTestsLastResultResponse.to_json())

# convert the object into a dict
test_suite_controller_tests_last_result_response_dict = test_suite_controller_tests_last_result_response_instance.to_dict()
# create an instance of TestSuiteControllerTestsLastResultResponse from a dict
test_suite_controller_tests_last_result_response_from_dict = TestSuiteControllerTestsLastResultResponse.from_dict(test_suite_controller_tests_last_result_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


