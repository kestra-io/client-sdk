# IdWithNamespace


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**namespace** | **str** |  | [optional] 
**id** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.id_with_namespace import IdWithNamespace

# TODO update the JSON string below
json = "{}"
# create an instance of IdWithNamespace from a JSON string
id_with_namespace_instance = IdWithNamespace.from_json(json)
# print the JSON string representation of the object
print(IdWithNamespace.to_json())

# convert the object into a dict
id_with_namespace_dict = id_with_namespace_instance.to_dict()
# create an instance of IdWithNamespace from a dict
id_with_namespace_from_dict = IdWithNamespace.from_dict(id_with_namespace_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


