# IAMGroupControllerApiGroupMember


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**username** | **str** |  | [optional] 
**display_name** | **str** |  | [optional] 
**groups** | [**List[IAMGroupControllerApiGroupMembership]**](IAMGroupControllerApiGroupMembership.md) |  | [optional] 

## Example

```python
from kestrapy.models.iam_group_controller_api_group_member import IAMGroupControllerApiGroupMember

# TODO update the JSON string below
json = "{}"
# create an instance of IAMGroupControllerApiGroupMember from a JSON string
iam_group_controller_api_group_member_instance = IAMGroupControllerApiGroupMember.from_json(json)
# print the JSON string representation of the object
print(IAMGroupControllerApiGroupMember.to_json())

# convert the object into a dict
iam_group_controller_api_group_member_dict = iam_group_controller_api_group_member_instance.to_dict()
# create an instance of IAMGroupControllerApiGroupMember from a dict
iam_group_controller_api_group_member_from_dict = IAMGroupControllerApiGroupMember.from_dict(iam_group_controller_api_group_member_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


