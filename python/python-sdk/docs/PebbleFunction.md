# PebbleFunction


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**arguments** | [**List[PebbleFunctionArgument]**](PebbleFunctionArgument.md) |  | [optional] 

## Example

```python
from kestrapy.models.pebble_function import PebbleFunction

# TODO update the JSON string below
json = "{}"
# create an instance of PebbleFunction from a JSON string
pebble_function_instance = PebbleFunction.from_json(json)
# print the JSON string representation of the object
print(PebbleFunction.to_json())

# convert the object into a dict
pebble_function_dict = pebble_function_instance.to_dict()
# create an instance of PebbleFunction from a dict
pebble_function_from_dict = PebbleFunction.from_dict(pebble_function_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


