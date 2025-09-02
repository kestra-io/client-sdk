# LeftSidebarConfiguration


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**disabled_menus** | **List[str]** |  | [optional] 

## Example

```python
from kestra_api_client.models.left_sidebar_configuration import LeftSidebarConfiguration

# TODO update the JSON string below
json = "{}"
# create an instance of LeftSidebarConfiguration from a JSON string
left_sidebar_configuration_instance = LeftSidebarConfiguration.from_json(json)
# print the JSON string representation of the object
print(LeftSidebarConfiguration.to_json())

# convert the object into a dict
left_sidebar_configuration_dict = left_sidebar_configuration_instance.to_dict()
# create an instance of LeftSidebarConfiguration from a dict
left_sidebar_configuration_from_dict = LeftSidebarConfiguration.from_dict(left_sidebar_configuration_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


