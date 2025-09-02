# StateHistory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**state** | [**StateType**](StateType.md) |  | 
**var_date** | **datetime** |  | 

## Example

```python
from kestra_api_client.models.state_history import StateHistory

# TODO update the JSON string below
json = "{}"
# create an instance of StateHistory from a JSON string
state_history_instance = StateHistory.from_json(json)
# print the JSON string representation of the object
print(StateHistory.to_json())

# convert the object into a dict
state_history_dict = state_history_instance.to_dict()
# create an instance of StateHistory from a dict
state_history_from_dict = StateHistory.from_dict(state_history_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


