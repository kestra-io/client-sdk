# TriggerFixture


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | **str** |  | 
**variables** | **Dict[str, object]** |  | [optional] 

## Example

```python
from kestrapy.models.trigger_fixture import TriggerFixture

# TODO update the JSON string below
json = "{}"
# create an instance of TriggerFixture from a JSON string
trigger_fixture_instance = TriggerFixture.from_json(json)
# print the JSON string representation of the object
print(TriggerFixture.to_json())

# convert the object into a dict
trigger_fixture_dict = trigger_fixture_instance.to_dict()
# create an instance of TriggerFixture from a dict
trigger_fixture_from_dict = TriggerFixture.from_dict(trigger_fixture_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


