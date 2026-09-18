# McpServerControllerApiMcpTool


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tool_name** | **str** | Unique MCP tool identifier (the trigger&#39;s &#x60;toolName&#x60;). This is the name AI agents use to invoke the tool. | [optional] 
**trigger_id** | **str** | Trigger id within the flow (the &#x60;id&#x60; field of the McpToolTrigger). Distinct from &#x60;toolName&#x60;. | [optional] 
**title** | **str** | Human-readable display title shown to AI agents. | [optional] 
**description** | **str** | Description of what the tool does and when an AI agent should call it. | [optional] 
**annotations** | [**McpServerControllerApiMcpToolAnnotations**](McpServerControllerApiMcpToolAnnotations.md) | MCP tool behavioural annotations. | [optional] 
**namespace** | **str** | Namespace of the flow that defines this tool. | [optional] 
**flow_id** | **str** | Id of the flow that defines this tool. | [optional] 
**flow_revision** | **int** | Revision of the flow that defines this tool. | [optional] 
**disabled** | **bool** | Whether this tool is currently disabled (trigger disabled or flow disabled). | [optional] 

## Example

```python
from kestrapy.models.mcp_server_controller_api_mcp_tool import McpServerControllerApiMcpTool

# TODO update the JSON string below
json = "{}"
# create an instance of McpServerControllerApiMcpTool from a JSON string
mcp_server_controller_api_mcp_tool_instance = McpServerControllerApiMcpTool.from_json(json)
# print the JSON string representation of the object
print(McpServerControllerApiMcpTool.to_json())

# convert the object into a dict
mcp_server_controller_api_mcp_tool_dict = mcp_server_controller_api_mcp_tool_instance.to_dict()
# create an instance of McpServerControllerApiMcpTool from a dict
mcp_server_controller_api_mcp_tool_from_dict = McpServerControllerApiMcpTool.from_dict(mcp_server_controller_api_mcp_tool_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


