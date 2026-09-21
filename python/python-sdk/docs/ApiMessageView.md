# ApiMessageView


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | [optional] 
**role** | [**AgentMessageRole**](AgentMessageRole.md) |  | [optional] 
**type** | [**AgentMessageType**](AgentMessageType.md) |  | [optional] 
**content** | **str** |  | [optional] 
**tool_call** | [**AgentToolCall**](AgentToolCall.md) |  | [optional] 
**tool_result** | **Dict[str, object]** |  | [optional] 
**draft** | [**ArtefactDraft**](ArtefactDraft.md) |  | [optional] 
**created_at** | **datetime** |  | [optional] 

## Example

```python
from kestrapy.models.api_message_view import ApiMessageView

# TODO update the JSON string below
json = "{}"
# create an instance of ApiMessageView from a JSON string
api_message_view_instance = ApiMessageView.from_json(json)
# print the JSON string representation of the object
print(ApiMessageView.to_json())

# convert the object into a dict
api_message_view_dict = api_message_view_instance.to_dict()
# create an instance of ApiMessageView from a dict
api_message_view_from_dict = ApiMessageView.from_dict(api_message_view_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


