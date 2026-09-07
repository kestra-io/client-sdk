# ListPermissions200Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flow** | **List[str]** |  | [optional] 
**execution** | **List[str]** |  | [optional] 
**trigger** | **List[str]** |  | [optional] 
**namespace** | **List[str]** |  | [optional] 
**kvstore** | **List[str]** |  | [optional] 
**reusable_inputs** | **List[str]** |  | [optional] 
**dashboard** | **List[str]** |  | [optional] 
**secret** | **List[str]** |  | [optional] 
**credential** | **List[str]** |  | [optional] 
**blueprint** | **List[str]** |  | [optional] 
**app** | **List[str]** |  | [optional] 
**auditlog** | **List[str]** |  | [optional] 
**system_settings** | **List[str]** |  | [optional] 
**tenant_settings** | **List[str]** |  | [optional] 
**testsuite** | **List[str]** |  | [optional] 
**asset** | **List[str]** |  | [optional] 
**user** | **List[str]** |  | [optional] 
**group** | **List[str]** |  | [optional] 
**role** | **List[str]** |  | [optional] 
**binding** | **List[str]** |  | [optional] 
**service_account** | **List[str]** |  | [optional] 
**invitation** | **List[str]** |  | [optional] 
**copilot** | **List[str]** |  | [optional] 
**mcp_server** | **List[str]** |  | [optional] 
**support** | **List[str]** |  | [optional] 
**policy** | **List[str]** |  | [optional] 
**case** | **List[str]** |  | [optional] 
**promotion_target** | **List[str]** |  | [optional] 
**app_execution** | **List[str]** |  | [optional] 
**namespace_file** | **List[str]** |  | [optional] 
**testsuite_run** | **List[str]** |  | [optional] 
**tenant_access** | **List[str]** |  | [optional] 
**security_integration** | **List[str]** |  | [optional] 
**case_template** | **List[str]** |  | [optional] 
**banner** | **List[str]** |  | [optional] 
**kill_switch** | **List[str]** |  | [optional] 
**tenant** | **List[str]** |  | [optional] 
**versioned_plugin** | **List[str]** |  | [optional] 
**worker_group** | **List[str]** |  | [optional] 
**worker_queue** | **List[str]** |  | [optional] 
**instance** | **List[str]** |  | [optional] 
**unknown** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.list_permissions200_response import ListPermissions200Response

# TODO update the JSON string below
json = "{}"
# create an instance of ListPermissions200Response from a JSON string
list_permissions200_response_instance = ListPermissions200Response.from_json(json)
# print the JSON string representation of the object
print(ListPermissions200Response.to_json())

# convert the object into a dict
list_permissions200_response_dict = list_permissions200_response_instance.to_dict()
# create an instance of ListPermissions200Response from a dict
list_permissions200_response_from_dict = ListPermissions200Response.from_dict(list_permissions200_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


