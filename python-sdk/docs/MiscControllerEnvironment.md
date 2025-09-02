# MiscControllerEnvironment


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**color** | **str** |  | 

## Example

```python
from kestra_api_client.models.misc_controller_environment import MiscControllerEnvironment

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerEnvironment from a JSON string
misc_controller_environment_instance = MiscControllerEnvironment.from_json(json)
# print the JSON string representation of the object
print(MiscControllerEnvironment.to_json())

# convert the object into a dict
misc_controller_environment_dict = misc_controller_environment_instance.to_dict()
# create an instance of MiscControllerEnvironment from a dict
misc_controller_environment_from_dict = MiscControllerEnvironment.from_dict(misc_controller_environment_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


