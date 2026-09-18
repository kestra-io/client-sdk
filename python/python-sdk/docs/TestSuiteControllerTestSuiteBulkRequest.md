# TestSuiteControllerTestSuiteBulkRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | [**List[TestSuiteControllerTestSuiteApiId]**](TestSuiteControllerTestSuiteApiId.md) |  | 

## Example

```python
from kestrapy.models.test_suite_controller_test_suite_bulk_request import TestSuiteControllerTestSuiteBulkRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuiteControllerTestSuiteBulkRequest from a JSON string
test_suite_controller_test_suite_bulk_request_instance = TestSuiteControllerTestSuiteBulkRequest.from_json(json)
# print the JSON string representation of the object
print(TestSuiteControllerTestSuiteBulkRequest.to_json())

# convert the object into a dict
test_suite_controller_test_suite_bulk_request_dict = test_suite_controller_test_suite_bulk_request_instance.to_dict()
# create an instance of TestSuiteControllerTestSuiteBulkRequest from a dict
test_suite_controller_test_suite_bulk_request_from_dict = TestSuiteControllerTestSuiteBulkRequest.from_dict(test_suite_controller_test_suite_bulk_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


