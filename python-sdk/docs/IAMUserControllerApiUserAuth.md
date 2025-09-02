# IAMUserControllerApiUserAuth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**type** | **str** |  | 

## Example

```python
from kestra_api_client.models.iam_user_controller_api_user_auth import IAMUserControllerApiUserAuth

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiUserAuth from a JSON string
iam_user_controller_api_user_auth_instance = IAMUserControllerApiUserAuth.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiUserAuth.to_json())

# convert the object into a dict
iam_user_controller_api_user_auth_dict = iam_user_controller_api_user_auth_instance.to_dict()
# create an instance of IAMUserControllerApiUserAuth from a dict
iam_user_controller_api_user_auth_from_dict = IAMUserControllerApiUserAuth.from_dict(iam_user_controller_api_user_auth_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


