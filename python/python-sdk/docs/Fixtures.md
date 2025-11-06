# Fixtures


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**inputs** | **Dict[str, object]** |  | [optional] 
**files** | **Dict[str, str]** |  | [optional] 
**tasks** | [**List[TaskFixture]**](TaskFixture.md) |  | [optional] 
**trigger** | [**TriggerFixture**](TriggerFixture.md) |  | [optional] 

## Example

```python
from kestrapy.models.fixtures import Fixtures

# TODO update the JSON string below
json = "{}"
# create an instance of Fixtures from a JSON string
fixtures_instance = Fixtures.from_json(json)
# print the JSON string representation of the object
print(Fixtures.to_json())

# convert the object into a dict
fixtures_dict = fixtures_instance.to_dict()
# create an instance of Fixtures from a dict
fixtures_from_dict = Fixtures.from_dict(fixtures_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


