# CustomLink


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**title** | **str** |  | [optional] 
**url** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.custom_link import CustomLink

# TODO update the JSON string below
json = "{}"
# create an instance of CustomLink from a JSON string
custom_link_instance = CustomLink.from_json(json)
# print the JSON string representation of the object
print(CustomLink.to_json())

# convert the object into a dict
custom_link_dict = custom_link_instance.to_dict()
# create an instance of CustomLink from a dict
custom_link_from_dict = CustomLink.from_dict(custom_link_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


