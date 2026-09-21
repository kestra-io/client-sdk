# RightSidebarConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**custom_links** | [**Dict[str, RightSidebarConfigurationCustomLink]**](RightSidebarConfigurationCustomLink.md) |  | [optional] 

## Example

```python
from kestrapy.models.right_sidebar_configuration import RightSidebarConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of RightSidebarConfiguration from a JSON string
right_sidebar_configuration_instance = RightSidebarConfiguration.from_json(json)
# print the JSON string representation of the object
print(RightSidebarConfiguration.to_json())

# convert the object into a dict
right_sidebar_configuration_dict = right_sidebar_configuration_instance.to_dict()
# create an instance of RightSidebarConfiguration from a dict
right_sidebar_configuration_from_dict = RightSidebarConfiguration.from_dict(right_sidebar_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


