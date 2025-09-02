# Tenant


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

## Example

```python
from kestra_api_client.models.tenant import Tenant

# TODO update the JSON string below
json = "{}"
# create an instance of Tenant from a JSON string
tenant_instance = Tenant.from_json(json)
# print the JSON string representation of the object
print(Tenant.to_json())

# convert the object into a dict
tenant_dict = tenant_instance.to_dict()
# create an instance of Tenant from a dict
tenant_from_dict = Tenant.from_dict(tenant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


