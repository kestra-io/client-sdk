# PagedResultsApiMcpServer


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiMcpServer]**](ApiMcpServer.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_mcp_server import PagedResultsApiMcpServer

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiMcpServer from a JSON string
paged_results_api_mcp_server_instance = PagedResultsApiMcpServer.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiMcpServer.to_json())

# convert the object into a dict
paged_results_api_mcp_server_dict = paged_results_api_mcp_server_instance.to_dict()
# create an instance of PagedResultsApiMcpServer from a dict
paged_results_api_mcp_server_from_dict = PagedResultsApiMcpServer.from_dict(paged_results_api_mcp_server_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


