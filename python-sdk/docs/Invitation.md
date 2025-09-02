# Invitation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**is_expired** | **bool** |  | 
**email** | **str** |  | 
**id** | **str** |  | 
**bindings** | [**List[Binding]**](Binding.md) |  | 
**group_ids** | **List[str]** |  | 
**tenant_id** | **str** |  | 
**status** | [**InvitationInvitationStatus**](InvitationInvitationStatus.md) |  | 
**sent_at** | **datetime** |  | 
**expired_at** | **datetime** |  | 
**accepted_at** | **datetime** |  | 
**deleted** | **bool** |  | 
**user_type** | [**UserType**](UserType.md) |  | 
**super_admin** | **bool** |  | 
**link** | **str** |  | 

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


