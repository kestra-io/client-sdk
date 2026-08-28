# ApiMcpServer


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** | Unique identifier of the MCP server. | 
**description** | **str** | Human-readable description of the MCP server. | [optional] 
**instructions** | **str** | Instructions sent to the AI model when using this server. | [optional] 
**server_type** | [**McpServerServerType**](McpServerServerType.md) | Visibility of the server. | [optional] 
**auth_type** | [**McpServerAuthType**](McpServerAuthType.md) | Authentication type for private servers. | [optional] 
**oauth_provider** | **str** | OAuth provider key from micronaut.security.oauth2.clients. Required when authType is OAUTH. | [optional] 
**oauth_scopes_supported** | **List[str]** | Scopes advertised in the server&#39;s RFC 9728 Protected Resource Metadata document. Only meaningful when authType is OAUTH. When null or empty the field is omitted from the PRM document. | [optional] 
**disabled** | **bool** | Whether the MCP server is disabled. | [optional] 
**is_default** | **bool** | Whether this is the default MCP server, auto-provisioned per tenant. | [optional] [readonly] 
**created** | **datetime** | Timestamp when the server was created. | [optional] [readonly] 
**updated** | **datetime** | Timestamp when the server was last updated. | [optional] [readonly] 

## Example

```python
from kestrapy.models.api_mcp_server import ApiMcpServer

# TODO update the JSON string below
json = "{}"
# create an instance of ApiMcpServer from a JSON string
api_mcp_server_instance = ApiMcpServer.from_json(json)
# print the JSON string representation of the object
print(ApiMcpServer.to_json())

# convert the object into a dict
api_mcp_server_dict = api_mcp_server_instance.to_dict()
# create an instance of ApiMcpServer from a dict
api_mcp_server_from_dict = ApiMcpServer.from_dict(api_mcp_server_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


