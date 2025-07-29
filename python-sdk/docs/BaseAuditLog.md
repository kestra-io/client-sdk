# BaseAuditLog


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

## Example

```python
from kestrapy.models.base_audit_log import BaseAuditLog

# TODO update the JSON string below
json = "{}"
# create an instance of BaseAuditLog from a JSON string
base_audit_log_instance = BaseAuditLog.from_json(json)
# print the JSON string representation of the object
print(BaseAuditLog.to_json())

# convert the object into a dict
base_audit_log_dict = base_audit_log_instance.to_dict()
# create an instance of BaseAuditLog from a dict
base_audit_log_from_dict = BaseAuditLog.from_dict(base_audit_log_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


