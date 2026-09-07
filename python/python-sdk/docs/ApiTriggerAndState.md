# ApiTriggerAndState


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**trigger** | [**AbstractTrigger**](AbstractTrigger.md) |  | 
**state** | [**ApiTriggerState**](ApiTriggerState.md) |  | 

## Example

```python
from kestrapy.models.api_trigger_and_state import ApiTriggerAndState

# TODO update the JSON string below
json = "{}"
# create an instance of ApiTriggerAndState from a JSON string
api_trigger_and_state_instance = ApiTriggerAndState.from_json(json)
# print the JSON string representation of the object
print(ApiTriggerAndState.to_json())

# convert the object into a dict
api_trigger_and_state_dict = api_trigger_and_state_instance.to_dict()
# create an instance of ApiTriggerAndState from a dict
api_trigger_and_state_from_dict = ApiTriggerAndState.from_dict(api_trigger_and_state_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


