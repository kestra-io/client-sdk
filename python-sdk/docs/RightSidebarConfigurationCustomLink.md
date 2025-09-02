# RightSidebarConfigurationCustomLink


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**title** | **str** |  | 
**url** | **str** |  | 

## Example

```python
from kestra_api_client.models.right_sidebar_configuration_custom_link import RightSidebarConfigurationCustomLink

# TODO update the JSON string below
json = "{}"
# create an instance of RightSidebarConfigurationCustomLink from a JSON string
right_sidebar_configuration_custom_link_instance = RightSidebarConfigurationCustomLink.from_json(json)
# print the JSON string representation of the object
print(RightSidebarConfigurationCustomLink.to_json())

# convert the object into a dict
right_sidebar_configuration_custom_link_dict = right_sidebar_configuration_custom_link_instance.to_dict()
# create an instance of RightSidebarConfigurationCustomLink from a dict
right_sidebar_configuration_custom_link_from_dict = RightSidebarConfigurationCustomLink.from_dict(right_sidebar_configuration_custom_link_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


