# AuditLogControllerApiAuditLogItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**audit_log** | [**AuditLog**](AuditLog.md) |  | 
**user** | [**ApiUser**](ApiUser.md) |  | 

## Example

```python
from kestrapy.models.audit_log_controller_api_audit_log_item import AuditLogControllerApiAuditLogItem

# TODO update the JSON string below
json = "{}"
# create an instance of AuditLogControllerApiAuditLogItem from a JSON string
audit_log_controller_api_audit_log_item_instance = AuditLogControllerApiAuditLogItem.from_json(json)
# print the JSON string representation of the object
print(AuditLogControllerApiAuditLogItem.to_json())

# convert the object into a dict
audit_log_controller_api_audit_log_item_dict = audit_log_controller_api_audit_log_item_instance.to_dict()
# create an instance of AuditLogControllerApiAuditLogItem from a dict
audit_log_controller_api_audit_log_item_from_dict = AuditLogControllerApiAuditLogItem.from_dict(audit_log_controller_api_audit_log_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


