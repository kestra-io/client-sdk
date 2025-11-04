# Namespace

A namespace is a logical grouping of flows and tasks. It is used to organize and manage flows and tasks within Kestra.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**deleted** | **bool** |  | 
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

## Example

```python
from kestrapy.models.namespace import Namespace

# TODO update the JSON string below
json = "{}"
# create an instance of Namespace from a JSON string
namespace_instance = Namespace.from_json(json)
# print the JSON string representation of the object
print(Namespace.to_json())

# convert the object into a dict
namespace_dict = namespace_instance.to_dict()
# create an instance of Namespace from a dict
namespace_from_dict = Namespace.from_dict(namespace_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


