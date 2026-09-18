# MeControllerApiProfile


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **str** |  | [optional] 
**first_name** | **str** |  | [optional] 
**last_name** | **str** |  | [optional] 
**username** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.me_controller_api_profile import MeControllerApiProfile

# TODO update the JSON string below
json = "{}"
# create an instance of MeControllerApiProfile from a JSON string
me_controller_api_profile_instance = MeControllerApiProfile.from_json(json)
# print the JSON string representation of the object
print(MeControllerApiProfile.to_json())

# convert the object into a dict
me_controller_api_profile_dict = me_controller_api_profile_instance.to_dict()
# create an instance of MeControllerApiProfile from a dict
me_controller_api_profile_from_dict = MeControllerApiProfile.from_dict(me_controller_api_profile_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


