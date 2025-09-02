# IAMGroupControllerApiGroupMembership


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 
**external** | **bool** |  | 
**membership** | [**GroupIdentifierMembership**](GroupIdentifierMembership.md) |  | 

## Example

```python
from kestra_api_client.models.iam_group_controller_api_group_membership import IAMGroupControllerApiGroupMembership

# TODO update the JSON string below
json = "{}"
# create an instance of IAMGroupControllerApiGroupMembership from a JSON string
iam_group_controller_api_group_membership_instance = IAMGroupControllerApiGroupMembership.from_json(json)
# print the JSON string representation of the object
print(IAMGroupControllerApiGroupMembership.to_json())

# convert the object into a dict
iam_group_controller_api_group_membership_dict = iam_group_controller_api_group_membership_instance.to_dict()
# create an instance of IAMGroupControllerApiGroupMembership from a dict
iam_group_controller_api_group_membership_from_dict = IAMGroupControllerApiGroupMembership.from_dict(iam_group_controller_api_group_membership_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


