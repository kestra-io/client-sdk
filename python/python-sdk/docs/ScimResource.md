# ScimResource


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schemas** | **List[str]** |  | [optional] 
**base_urn** | **str** |  | [optional] 
**extensions** | [**Dict[str, ScimExtension]**](ScimExtension.md) |  | [optional] 
**meta** | [**Meta**](Meta.md) |  | 
**id** | **str** |  | [optional] 
**external_id** | **str** |  | [optional] 
**resource_type** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.scim_resource import ScimResource

# TODO update the JSON string below
json = "{}"
# create an instance of ScimResource from a JSON string
scim_resource_instance = ScimResource.from_json(json)
# print the JSON string representation of the object
print(ScimResource.to_json())

# convert the object into a dict
scim_resource_dict = scim_resource_instance.to_dict()
# create an instance of ScimResource from a dict
scim_resource_from_dict = ScimResource.from_dict(scim_resource_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


