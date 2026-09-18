# PagedResultsApiInstanceMcpServer


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[ApiInstanceMcpServer]**](ApiInstanceMcpServer.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_api_instance_mcp_server import PagedResultsApiInstanceMcpServer

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsApiInstanceMcpServer from a JSON string
paged_results_api_instance_mcp_server_instance = PagedResultsApiInstanceMcpServer.from_json(json)
# print the JSON string representation of the object
print(PagedResultsApiInstanceMcpServer.to_json())

# convert the object into a dict
paged_results_api_instance_mcp_server_dict = paged_results_api_instance_mcp_server_instance.to_dict()
# create an instance of PagedResultsApiInstanceMcpServer from a dict
paged_results_api_instance_mcp_server_from_dict = PagedResultsApiInstanceMcpServer.from_dict(paged_results_api_instance_mcp_server_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


