# ServiceInstanceTimestampedEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ts** | **datetime** |  | 
**value** | **str** |  | 
**type** | **str** |  | 
**state** | [**ServiceServiceState**](ServiceServiceState.md) |  | 

## Example

```python
from kestrapy.models.service_instance_timestamped_event import ServiceInstanceTimestampedEvent

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceInstanceTimestampedEvent from a JSON string
service_instance_timestamped_event_instance = ServiceInstanceTimestampedEvent.from_json(json)
# print the JSON string representation of the object
print(ServiceInstanceTimestampedEvent.to_json())

# convert the object into a dict
service_instance_timestamped_event_dict = service_instance_timestamped_event_instance.to_dict()
# create an instance of ServiceInstanceTimestampedEvent from a dict
service_instance_timestamped_event_from_dict = ServiceInstanceTimestampedEvent.from_dict(service_instance_timestamped_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


