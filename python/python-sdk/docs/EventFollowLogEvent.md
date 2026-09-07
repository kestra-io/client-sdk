# EventFollowLogEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data** | [**FollowLogEvent**](FollowLogEvent.md) |  | [optional] 
**id** | **str** |  | [optional] 
**name** | **str** |  | [optional] 
**comment** | **str** |  | [optional] 
**retry** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.event_follow_log_event import EventFollowLogEvent

# TODO update the JSON string below
json = "{}"
# create an instance of EventFollowLogEvent from a JSON string
event_follow_log_event_instance = EventFollowLogEvent.from_json(json)
# print the JSON string representation of the object
print(EventFollowLogEvent.to_json())

# convert the object into a dict
event_follow_log_event_dict = event_follow_log_event_instance.to_dict()
# create an instance of EventFollowLogEvent from a dict
event_follow_log_event_from_dict = EventFollowLogEvent.from_dict(event_follow_log_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


