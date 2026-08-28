# AgentThinking


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**text** | **str** |  | [optional] 
**signature** | **str** |  | [optional] 
**redacted** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.agent_thinking import AgentThinking

# TODO update the JSON string below
json = "{}"
# create an instance of AgentThinking from a JSON string
agent_thinking_instance = AgentThinking.from_json(json)
# print the JSON string representation of the object
print(AgentThinking.to_json())

# convert the object into a dict
agent_thinking_dict = agent_thinking_instance.to_dict()
# create an instance of AgentThinking from a dict
agent_thinking_from_dict = AgentThinking.from_dict(agent_thinking_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


