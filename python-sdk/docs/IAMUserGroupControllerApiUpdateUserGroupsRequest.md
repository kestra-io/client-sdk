# IAMUserGroupControllerApiUpdateUserGroupsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**group_ids** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.iam_user_group_controller_api_update_user_groups_request import IAMUserGroupControllerApiUpdateUserGroupsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMUserGroupControllerApiUpdateUserGroupsRequest from a JSON string
iam_user_group_controller_api_update_user_groups_request_instance = IAMUserGroupControllerApiUpdateUserGroupsRequest.from_json(json)
# print the JSON string representation of the object
print(IAMUserGroupControllerApiUpdateUserGroupsRequest.to_json())

# convert the object into a dict
iam_user_group_controller_api_update_user_groups_request_dict = iam_user_group_controller_api_update_user_groups_request_instance.to_dict()
# create an instance of IAMUserGroupControllerApiUpdateUserGroupsRequest from a dict
iam_user_group_controller_api_update_user_groups_request_from_dict = IAMUserGroupControllerApiUpdateUserGroupsRequest.from_dict(iam_user_group_controller_api_update_user_groups_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


