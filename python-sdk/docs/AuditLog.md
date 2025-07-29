# AuditLog


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | [**CrudEventType**](CrudEventType.md) |  | 
**detail** | [**AuditLogDetail**](AuditLogDetail.md) |  | 
**var_date** | **datetime** |  | 
**user_id** | **str** |  | 
**ip_address** | **str** |  | [optional] 
**impersonated_by** | **str** |  | [optional] 
**deleted** | **bool** |  | [optional] 
**applied_patch** | **List[object]** |  | [optional] 
**revert_patch** | **List[object]** |  | [optional] 

## Example

```python
from kestrapy.models.audit_log import AuditLog

# TODO update the JSON string below
json = "{}"
# create an instance of AuditLog from a JSON string
audit_log_instance = AuditLog.from_json(json)
# print the JSON string representation of the object
print(AuditLog.to_json())

# convert the object into a dict
audit_log_dict = audit_log_instance.to_dict()
# create an instance of AuditLog from a dict
audit_log_from_dict = AuditLog.from_dict(audit_log_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


