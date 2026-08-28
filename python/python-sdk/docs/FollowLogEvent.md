# FollowLogEvent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 
**namespace** | **str** |  | [optional] 
**flow_id** | **str** |  | [optional] 
**task_id** | **str** |  | [optional] 
**execution_id** | **str** |  | [optional] 
**task_run_id** | **str** |  | [optional] 
**attempt_number** | **int** |  | [optional] 
**trigger_id** | **str** |  | [optional] 
**timestamp** | **datetime** |  | [optional] 
**level** | [**Level**](Level.md) |  | [optional] 
**thread** | **str** |  | [optional] 
**message** | **str** |  | [optional] 
**execution_kind** | [**ExecutionKind**](ExecutionKind.md) |  | [optional] 
**progress** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.follow_log_event import FollowLogEvent

# TODO update the JSON string below
json = "{}"
# create an instance of FollowLogEvent from a JSON string
follow_log_event_instance = FollowLogEvent.from_json(json)
# print the JSON string representation of the object
print(FollowLogEvent.to_json())

# convert the object into a dict
follow_log_event_dict = follow_log_event_instance.to_dict()
# create an instance of FollowLogEvent from a dict
follow_log_event_from_dict = FollowLogEvent.from_dict(follow_log_event_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


