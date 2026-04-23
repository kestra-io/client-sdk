# State


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**duration** | **str** |  | [optional] [readonly] 
**start_date** | **datetime** |  | [optional] [readonly] 
**end_date** | **datetime** |  | [optional] [readonly] 
**current** | [**StateType**](StateType.md) |  | 
**histories** | [**List[StateHistory]**](StateHistory.md) |  | [optional] 
**get_duration** | **str** |  | [readonly] 
**get_start_date** | **datetime** |  | [readonly] 
**get_end_date** | **datetime** |  | [readonly] 

## Example

```python
from kestrapy.models.state import State

# TODO update the JSON string below
json = "{}"
# create an instance of State from a JSON string
state_instance = State.from_json(json)
# print the JSON string representation of the object
print(State.to_json())

# convert the object into a dict
state_dict = state_instance.to_dict()
# create an instance of State from a dict
state_from_dict = State.from_dict(state_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


