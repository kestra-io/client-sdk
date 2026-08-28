# ApiChatTurnRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**prompt** | **str** |  | [optional] 
**mode** | [**AgentMode**](AgentMode.md) |  | [optional] 
**additional_context** | **Dict[str, object]** |  | [optional] 
**provider_id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_chat_turn_request import ApiChatTurnRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ApiChatTurnRequest from a JSON string
api_chat_turn_request_instance = ApiChatTurnRequest.from_json(json)
# print the JSON string representation of the object
print(ApiChatTurnRequest.to_json())

# convert the object into a dict
api_chat_turn_request_dict = api_chat_turn_request_instance.to_dict()
# create an instance of ApiChatTurnRequest from a dict
api_chat_turn_request_from_dict = ApiChatTurnRequest.from_dict(api_chat_turn_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


