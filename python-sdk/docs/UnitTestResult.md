# UnitTestResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**test_id** | **str** |  | 
**test_type** | **str** |  | 
**execution_id** | **str** |  | 
**url** | **str** |  | 
**state** | [**TestState**](TestState.md) |  | 
**assertion_results** | [**List[AssertionResult]**](AssertionResult.md) |  | 
**errors** | [**List[AssertionRunError]**](AssertionRunError.md) |  | 
**fixtures** | [**Fixtures**](Fixtures.md) |  | 

## Example

```python
from kestra_api_client.models.unit_test_result import UnitTestResult

# TODO update the JSON string below
json = "{}"
# create an instance of UnitTestResult from a JSON string
unit_test_result_instance = UnitTestResult.from_json(json)
# print the JSON string representation of the object
print(UnitTestResult.to_json())

# convert the object into a dict
unit_test_result_dict = unit_test_result_instance.to_dict()
# create an instance of UnitTestResult from a dict
unit_test_result_from_dict = UnitTestResult.from_dict(unit_test_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


