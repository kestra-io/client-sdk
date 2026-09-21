# MeControllerApiUpdatePasswordRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**old_password** | **str** |  | 
**new_password** | **str** |  | 

## Example

```python
from kestrapy.models.me_controller_api_update_password_request import MeControllerApiUpdatePasswordRequest

# TODO update the JSON string below
json = "{}"
# create an instance of MeControllerApiUpdatePasswordRequest from a JSON string
me_controller_api_update_password_request_instance = MeControllerApiUpdatePasswordRequest.from_json(json)
# print the JSON string representation of the object
print(MeControllerApiUpdatePasswordRequest.to_json())

# convert the object into a dict
me_controller_api_update_password_request_dict = me_controller_api_update_password_request_instance.to_dict()
# create an instance of MeControllerApiUpdatePasswordRequest from a dict
me_controller_api_update_password_request_from_dict = MeControllerApiUpdatePasswordRequest.from_dict(me_controller_api_update_password_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


