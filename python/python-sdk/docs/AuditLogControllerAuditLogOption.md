# AuditLogControllerAuditLogOption


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**var_date** | **datetime** |  | [optional] 
**username** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.audit_log_controller_audit_log_option import AuditLogControllerAuditLogOption

# TODO update the JSON string below
json = "{}"
# create an instance of AuditLogControllerAuditLogOption from a JSON string
audit_log_controller_audit_log_option_instance = AuditLogControllerAuditLogOption.from_json(json)
# print the JSON string representation of the object
print(AuditLogControllerAuditLogOption.to_json())

# convert the object into a dict
audit_log_controller_audit_log_option_dict = audit_log_controller_audit_log_option_instance.to_dict()
# create an instance of AuditLogControllerAuditLogOption from a dict
audit_log_controller_audit_log_option_from_dict = AuditLogControllerAuditLogOption.from_dict(audit_log_controller_audit_log_option_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


