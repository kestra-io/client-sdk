# Invitation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**is_expired** | **bool** |  | [optional] 
**email** | **str** |  | 
**id** | **str** |  | [optional] 
**bindings** | [**List[Binding]**](Binding.md) |  | [optional] 
**group_ids** | **List[str]** |  | [optional] 
**tenant_id** | **str** |  | [optional] 
**status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) |  | [optional] 
**sent_at** | **datetime** |  | [optional] 
**expired_at** | **datetime** |  | [optional] 
**accepted_at** | **datetime** |  | [optional] 
**deleted** | **bool** |  | 
**user_type** | [**UserType**](UserType.md) |  | [optional] 
**super_admin** | **bool** |  | [optional] 
**link** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.invitation import Invitation

# TODO update the JSON string below
json = "{}"
# create an instance of Invitation from a JSON string
invitation_instance = Invitation.from_json(json)
# print the JSON string representation of the object
print(Invitation.to_json())

# convert the object into a dict
invitation_dict = invitation_instance.to_dict()
# create an instance of Invitation from a dict
invitation_from_dict = Invitation.from_dict(invitation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


