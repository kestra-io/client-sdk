# IAMGroupControllerApiCreateGroupRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | 
**description** | **str** |  | 
**members_id** | **List[str]** |  | 

## Example

```python
from kestra_api_client.models.iam_group_controller_api_create_group_request import IAMGroupControllerApiCreateGroupRequest

# TODO update the JSON string below
json = "{}"
# create an instance of IAMGroupControllerApiCreateGroupRequest from a JSON string
iam_group_controller_api_create_group_request_instance = IAMGroupControllerApiCreateGroupRequest.from_json(json)
# print the JSON string representation of the object
print(IAMGroupControllerApiCreateGroupRequest.to_json())

# convert the object into a dict
iam_group_controller_api_create_group_request_dict = iam_group_controller_api_create_group_request_instance.to_dict()
# create an instance of IAMGroupControllerApiCreateGroupRequest from a dict
iam_group_controller_api_create_group_request_from_dict = IAMGroupControllerApiCreateGroupRequest.from_dict(iam_group_controller_api_create_group_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


