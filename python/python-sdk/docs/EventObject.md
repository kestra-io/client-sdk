# EventObject


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | **object** |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 
**retry** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.event_object import EventObject

# TODO update the JSON string below
json = "{}"
# create an instance of EventObject from a JSON string
event_object_instance = EventObject.from_json(json)
# print the JSON string representation of the object
print(EventObject.to_json())

# convert the object into a dict
event_object_dict = event_object_instance.to_dict()
# create an instance of EventObject from a dict
event_object_from_dict = EventObject.from_dict(event_object_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


