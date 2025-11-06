# ScimExtension


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**urn** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.scim_extension import ScimExtension

# TODO update the JSON string below
json = "{}"
# create an instance of ScimExtension from a JSON string
scim_extension_instance = ScimExtension.from_json(json)
# print the JSON string representation of the object
print(ScimExtension.to_json())

# convert the object into a dict
scim_extension_dict = scim_extension_instance.to_dict()
# create an instance of ScimExtension from a dict
scim_extension_from_dict = ScimExtension.from_dict(scim_extension_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


