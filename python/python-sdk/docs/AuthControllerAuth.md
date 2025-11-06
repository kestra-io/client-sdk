# AuthControllerAuth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**login_password** | **bool** |  | [optional] 
**mails_enabled** | **bool** |  | [optional] 
**passwordless** | **bool** |  | [optional] 
**oauths** | **List[str]** |  | [optional] 

## Example

```python
from kestrapy.models.auth_controller_auth import AuthControllerAuth

# TODO update the JSON string below
json = "{}"
# create an instance of AuthControllerAuth from a JSON string
auth_controller_auth_instance = AuthControllerAuth.from_json(json)
# print the JSON string representation of the object
print(AuthControllerAuth.to_json())

# convert the object into a dict
auth_controller_auth_dict = auth_controller_auth_instance.to_dict()
# create an instance of AuthControllerAuth from a dict
auth_controller_auth_from_dict = AuthControllerAuth.from_dict(auth_controller_auth_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


