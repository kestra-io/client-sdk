# AuditLogControllerAuditLogWithUser


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**audit_log** | [**AuditLog**](AuditLog.md) |  | [optional] 
**user** | [**ApiUser**](ApiUser.md) |  | [optional] 

## Example

```python
from kestrapy.models.audit_log_controller_audit_log_with_user import AuditLogControllerAuditLogWithUser

# TODO update the JSON string below
json = "{}"
# create an instance of AuditLogControllerAuditLogWithUser from a JSON string
audit_log_controller_audit_log_with_user_instance = AuditLogControllerAuditLogWithUser.from_json(json)
# print the JSON string representation of the object
print(AuditLogControllerAuditLogWithUser.to_json())

# convert the object into a dict
audit_log_controller_audit_log_with_user_dict = audit_log_controller_audit_log_with_user_instance.to_dict()
# create an instance of AuditLogControllerAuditLogWithUser from a dict
audit_log_controller_audit_log_with_user_from_dict = AuditLogControllerAuditLogWithUser.from_dict(audit_log_controller_audit_log_with_user_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


