# TestSuiteServiceRunByQueryRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**include_child_namespaces** | **bool** | Should child namespaces be included or not | [default to True]

## Example

```python
from kestrapy.models.test_suite_service_run_by_query_request import TestSuiteServiceRunByQueryRequest

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuiteServiceRunByQueryRequest from a JSON string
test_suite_service_run_by_query_request_instance = TestSuiteServiceRunByQueryRequest.from_json(json)
# print the JSON string representation of the object
print(TestSuiteServiceRunByQueryRequest.to_json())

# convert the object into a dict
test_suite_service_run_by_query_request_dict = test_suite_service_run_by_query_request_instance.to_dict()
# create an instance of TestSuiteServiceRunByQueryRequest from a dict
test_suite_service_run_by_query_request_from_dict = TestSuiteServiceRunByQueryRequest.from_dict(test_suite_service_run_by_query_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


