# MeControllerApiUserDetailsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**first_name** | **str** |  | [optional] 
**last_name** | **str** |  | [optional] 
**email** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.me_controller_api_user_details_request import MeControllerApiUserDetailsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of MeControllerApiUserDetailsRequest from a JSON string
me_controller_api_user_details_request_instance = MeControllerApiUserDetailsRequest.from_json(json)
# print the JSON string representation of the object
print(MeControllerApiUserDetailsRequest.to_json())

# convert the object into a dict
me_controller_api_user_details_request_dict = me_controller_api_user_details_request_instance.to_dict()
# create an instance of MeControllerApiUserDetailsRequest from a dict
me_controller_api_user_details_request_from_dict = MeControllerApiUserDetailsRequest.from_dict(me_controller_api_user_details_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


