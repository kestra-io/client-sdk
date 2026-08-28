# PebbleFunctionArgument


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**default_value** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.pebble_function_argument import PebbleFunctionArgument

# TODO update the JSON string below
json = "{}"
# create an instance of PebbleFunctionArgument from a JSON string
pebble_function_argument_instance = PebbleFunctionArgument.from_json(json)
# print the JSON string representation of the object
print(PebbleFunctionArgument.to_json())

# convert the object into a dict
pebble_function_argument_dict = pebble_function_argument_instance.to_dict()
# create an instance of PebbleFunctionArgument from a dict
pebble_function_argument_from_dict = PebbleFunctionArgument.from_dict(pebble_function_argument_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


