# IAMGroupControllerApiUpdateGroupRequest

Represents updatable properties for a Group.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** | of the group. | 
**description** | **str** | of the group. | 

## Example

```python
from kestra_api_client.models.iam_group_controller_api_update_group_request import IAMGroupControllerApiUpdateGroupRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMGroupControllerApiUpdateGroupRequest from a JSON string
iam_group_controller_api_update_group_request_instance = IAMGroupControllerApiUpdateGroupRequest.from_json(json)
# print the JSON string representation of the object
print(IAMGroupControllerApiUpdateGroupRequest.to_json())

# convert the object into a dict
iam_group_controller_api_update_group_request_dict = iam_group_controller_api_update_group_request_instance.to_dict()
# create an instance of IAMGroupControllerApiUpdateGroupRequest from a dict
iam_group_controller_api_update_group_request_from_dict = IAMGroupControllerApiUpdateGroupRequest.from_dict(iam_group_controller_api_update_group_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


