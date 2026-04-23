# UnitTest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**disabled** | **bool** |  | [optional] 
**description** | **str** |  | [optional] 
**fixtures** | [**Fixtures**](Fixtures.md) |  | [optional] 
**assertions** | [**List[Assertion]**](Assertion.md) |  | 

## Example

```python
from kestrapy.models.unit_test import UnitTest

# TODO update the JSON string below
json = "{}"
# create an instance of UnitTest from a JSON string
unit_test_instance = UnitTest.from_json(json)
# print the JSON string representation of the object
print(UnitTest.to_json())

# convert the object into a dict
unit_test_dict = unit_test_instance.to_dict()
# create an instance of UnitTest from a dict
unit_test_from_dict = UnitTest.from_dict(unit_test_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


