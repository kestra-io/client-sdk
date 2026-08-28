# AgentToolCall


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**kind** | [**AgentToolCallKind**](AgentToolCallKind.md) |  | [optional] 
**tool** | **str** |  | [optional] 
**family** | [**AgentToolFamily**](AgentToolFamily.md) |  | [optional] 
**arguments** | **Dict[str, object]** |  | [optional] 
**thinking** | [**AgentThinking**](AgentThinking.md) |  | [optional] 

## Example

```python
from kestrapy.models.agent_tool_call import AgentToolCall

# TODO update the JSON string below
json = "{}"
# create an instance of AgentToolCall from a JSON string
agent_tool_call_instance = AgentToolCall.from_json(json)
# print the JSON string representation of the object
print(AgentToolCall.to_json())

# convert the object into a dict
agent_tool_call_dict = agent_tool_call_instance.to_dict()
# create an instance of AgentToolCall from a dict
agent_tool_call_from_dict = AgentToolCall.from_dict(agent_tool_call_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


