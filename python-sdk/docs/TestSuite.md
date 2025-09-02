# TestSuite


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**description** | **str** |  | [optional] 
**namespace** | **str** |  | 
**flow_id** | **str** |  | 
**source** | **str** |  | [optional] 
**test_cases** | [**List[UnitTest]**](UnitTest.md) |  | 
**deleted** | **bool** |  | [optional] 
**disabled** | **bool** |  | [optional] 

## Example

```python
from kestra_api_client.models.test_suite import TestSuite

# TODO update the JSON string below
json = "{}"
# create an instance of TestSuite from a JSON string
test_suite_instance = TestSuite.from_json(json)
# print the JSON string representation of the object
print(TestSuite.to_json())

# convert the object into a dict
test_suite_dict = test_suite_instance.to_dict()
# create an instance of TestSuite from a dict
test_suite_from_dict = TestSuite.from_dict(test_suite_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


