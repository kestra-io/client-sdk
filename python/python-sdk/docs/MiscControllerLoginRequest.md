# MiscControllerLoginRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**username** | **str** |  | [optional] 
**password** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.misc_controller_login_request import MiscControllerLoginRequest

# TODO update the JSON string below
json = "{}"
# create an instance of MiscControllerLoginRequest from a JSON string
misc_controller_login_request_instance = MiscControllerLoginRequest.from_json(json)
# print the JSON string representation of the object
print(MiscControllerLoginRequest.to_json())

# convert the object into a dict
misc_controller_login_request_dict = misc_controller_login_request_instance.to_dict()
# create an instance of MiscControllerLoginRequest from a dict
misc_controller_login_request_from_dict = MiscControllerLoginRequest.from_dict(misc_controller_login_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


