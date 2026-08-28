# McpServerControllerApiMcpToolAnnotations

MCP tool behavioural annotations.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**read_only** | **bool** |  | [optional] 
**open_world** | **bool** |  | [optional] 
**destructive** | **bool** |  | [optional] 
**idempotent** | **bool** |  | [optional] 
**return_direct** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.mcp_server_controller_api_mcp_tool_annotations import McpServerControllerApiMcpToolAnnotations

# TODO update the JSON string below
json = "{}"
# create an instance of McpServerControllerApiMcpToolAnnotations from a JSON string
mcp_server_controller_api_mcp_tool_annotations_instance = McpServerControllerApiMcpToolAnnotations.from_json(json)
# print the JSON string representation of the object
print(McpServerControllerApiMcpToolAnnotations.to_json())

# convert the object into a dict
mcp_server_controller_api_mcp_tool_annotations_dict = mcp_server_controller_api_mcp_tool_annotations_instance.to_dict()
# create an instance of McpServerControllerApiMcpToolAnnotations from a dict
mcp_server_controller_api_mcp_tool_annotations_from_dict = McpServerControllerApiMcpToolAnnotations.from_dict(mcp_server_controller_api_mcp_tool_annotations_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


