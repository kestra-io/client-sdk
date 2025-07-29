# NamespaceWithDisabled


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**deleted** | **bool** |  | 
**allowed_triggers** | [**List[NamespaceAllowedTrigger]**](NamespaceAllowedTrigger.md) |  | [optional] 
**storage_isolation** | [**Isolation**](Isolation.md) |  | [optional] 
**secret_isolation** | [**Isolation**](Isolation.md) |  | [optional] 
**description** | **str** |  | [optional] 
**variables** | **Dict[str, object]** |  | [optional] 
**plugin_defaults** | [**List[PluginDefault]**](PluginDefault.md) |  | [optional] 
**allowed_namespaces** | [**List[NamespaceAllowedNamespace]**](NamespaceAllowedNamespace.md) |  | [optional] 
**worker_group** | [**WorkerGroup**](WorkerGroup.md) |  | [optional] 
**storage_type** | **str** |  | [optional] 
**storage_configuration** | **Dict[str, object]** |  | [optional] 
**secret_type** | **str** |  | [optional] 
**secret_read_only** | **bool** |  | [optional] 
**secret_configuration** | **Dict[str, object]** |  | [optional] 
**outputs_in_internal_storage** | **bool** |  | [optional] 
**disabled** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.namespace_with_disabled import NamespaceWithDisabled

# TODO update the JSON string below
json = "{}"
# create an instance of NamespaceWithDisabled from a JSON string
namespace_with_disabled_instance = NamespaceWithDisabled.from_json(json)
# print the JSON string representation of the object
print(NamespaceWithDisabled.to_json())

# convert the object into a dict
namespace_with_disabled_dict = namespace_with_disabled_instance.to_dict()
# create an instance of NamespaceWithDisabled from a dict
namespace_with_disabled_from_dict = NamespaceWithDisabled.from_dict(namespace_with_disabled_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


