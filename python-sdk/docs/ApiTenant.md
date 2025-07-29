# ApiTenant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**storage_isolation** | [**Isolation**](Isolation.md) |  | [optional] 
**secret_isolation** | [**Isolation**](Isolation.md) |  | [optional] 
**id** | **str** |  | 
**name** | **str** |  | 
**deleted** | **bool** |  | 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**storage_type** | **str** |  | [optional] 
**storage_configuration** | **Dict[str, object]** |  | [optional] 
**secret_type** | **str** |  | [optional] 
**secret_read_only** | **bool** |  | [optional] 
**secret_configuration** | **Dict[str, object]** |  | [optional] 
**require_existing_namespace** | **bool** |  | [optional] 
**outputs_in_internal_storage** | **bool** |  | [optional] 
**logo** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.api_tenant import ApiTenant

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


