# MeControllerApiOwnedGroup


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenant_id** | **str** |  | [optional] 
**id** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.me_controller_api_owned_group import MeControllerApiOwnedGroup

# TODO update the JSON string below
json = "{}"
# create an instance of MeControllerApiOwnedGroup from a JSON string
me_controller_api_owned_group_instance = MeControllerApiOwnedGroup.from_json(json)
# print the JSON string representation of the object
print(MeControllerApiOwnedGroup.to_json())

# convert the object into a dict
me_controller_api_owned_group_dict = me_controller_api_owned_group_instance.to_dict()
# create an instance of MeControllerApiOwnedGroup from a dict
me_controller_api_owned_group_from_dict = MeControllerApiOwnedGroup.from_dict(me_controller_api_owned_group_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


