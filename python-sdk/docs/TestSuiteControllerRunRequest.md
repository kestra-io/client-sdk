# TestSuiteControllerRunRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**test_cases** | **List[str]** |  | 

## Example

```python
from kestrapy.models.test_suite_controller_run_request import TestSuiteControllerRunRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuiteControllerRunRequest from a JSON string
test_suite_controller_run_request_instance = TestSuiteControllerRunRequest.from_json(json)
# print the JSON string representation of the object
print(TestSuiteControllerRunRequest.to_json())

# convert the object into a dict
test_suite_controller_run_request_dict = test_suite_controller_run_request_instance.to_dict()
# create an instance of TestSuiteControllerRunRequest from a dict
test_suite_controller_run_request_from_dict = TestSuiteControllerRunRequest.from_dict(test_suite_controller_run_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


