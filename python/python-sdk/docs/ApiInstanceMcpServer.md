# ApiInstanceMcpServer

Instance-scoped API DTO for MCP servers, extending io.kestra.webserver.models.api.ApiMcpServer with a `tenantId` field so instance owners can identify which tenant owns each server.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** | Tenant that owns this MCP server. | [optional] 
**id** | **str** | Unique identifier of the MCP server. | [optional] 
**description** | **str** | Human-readable description of the MCP server. | [optional] 
**server_type** | [**McpServerServerType**](McpServerServerType.md) | Visibility of the server. | [optional] 
**auth_type** | [**McpServerAuthType**](McpServerAuthType.md) | Authentication type for private servers. | [optional] 
**disabled** | **bool** | Whether the MCP server is disabled. | [optional] 
**is_default** | **bool** | Whether this is the default MCP server. | [optional] [readonly] 
**created** | **datetime** | Timestamp when the server was created. | [optional] [readonly] 
**updated** | **datetime** | Timestamp when the server was last updated. | [optional] [readonly] 

## Example

```python
from kestrapy.models.api_instance_mcp_server import ApiInstanceMcpServer

# TODO update the JSON string below
json = "{}"
# create an instance of ApiInstanceMcpServer from a JSON string
api_instance_mcp_server_instance = ApiInstanceMcpServer.from_json(json)
# print the JSON string representation of the object
print(ApiInstanceMcpServer.to_json())

# convert the object into a dict
api_instance_mcp_server_dict = api_instance_mcp_server_instance.to_dict()
# create an instance of ApiInstanceMcpServer from a dict
api_instance_mcp_server_from_dict = ApiInstanceMcpServer.from_dict(api_instance_mcp_server_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


