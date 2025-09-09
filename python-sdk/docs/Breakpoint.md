# Breakpoint


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**value** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.breakpoint import Breakpoint

# TODO update the JSON string below
json = "{}"
# create an instance of Breakpoint from a JSON string
breakpoint_instance = Breakpoint.from_json(json)
# print the JSON string representation of the object
print(Breakpoint.to_json())

# convert the object into a dict
breakpoint_dict = breakpoint_instance.to_dict()
# create an instance of Breakpoint from a dict
breakpoint_from_dict = Breakpoint.from_dict(breakpoint_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


