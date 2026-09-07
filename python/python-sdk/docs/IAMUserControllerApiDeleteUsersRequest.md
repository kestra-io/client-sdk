# IAMUserControllerApiDeleteUsersRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ids** | **List[str]** |  | 

## Example

```python
from kestrapy.models.iam_user_controller_api_delete_users_request import IAMUserControllerApiDeleteUsersRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserControllerApiDeleteUsersRequest from a JSON string
iam_user_controller_api_delete_users_request_instance = IAMUserControllerApiDeleteUsersRequest.from_json(json)
# print the JSON string representation of the object
print(IAMUserControllerApiDeleteUsersRequest.to_json())

# convert the object into a dict
iam_user_controller_api_delete_users_request_dict = iam_user_controller_api_delete_users_request_instance.to_dict()
# create an instance of IAMUserControllerApiDeleteUsersRequest from a dict
iam_user_controller_api_delete_users_request_from_dict = IAMUserControllerApiDeleteUsersRequest.from_dict(iam_user_controller_api_delete_users_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


