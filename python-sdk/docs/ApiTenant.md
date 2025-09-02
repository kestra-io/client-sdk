# ApiTenant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**storage_isolation** | [**Isolation**](Isolation.md) |  | 
**secret_isolation** | [**Isolation**](Isolation.md) |  | 
**id** | **str** |  | 
**name** | **str** |  | 
**deleted** | **bool** |  | 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | 
**storage_type** | **str** |  | 
**storage_configuration** | **Dict[str, object]** |  | 
**secret_type** | **str** |  | 
**secret_read_only** | **bool** |  | 
**secret_configuration** | **Dict[str, object]** |  | 
**require_existing_namespace** | **bool** |  | 
**outputs_in_internal_storage** | **bool** |  | 
**logo** | **str** |  | 

## Example

```python
from kestra_api_client.models.api_tenant import ApiTenant

# TODO update the JSON string below
json = "{}"
# create an instance of ApiTenant from a JSON string
api_tenant_instance = ApiTenant.from_json(json)
# print the JSON string representation of the object
print(ApiTenant.to_json())

# convert the object into a dict
api_tenant_dict = api_tenant_instance.to_dict()
# create an instance of ApiTenant from a dict
api_tenant_from_dict = ApiTenant.from_dict(api_tenant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


