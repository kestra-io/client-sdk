# AuditLogDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**permission** | [**Permission**](Permission.md) |  | [optional] 
**resource_type** | [**ResourceType1**](ResourceType1.md) |  | [optional] 
**type** | **str** |  | 
**id** | **str** |  | [optional] 

## Example

```python
from kestra_api_client.models.audit_log_detail import AuditLogDetail

# TODO update the JSON string below
json = "{}"
# create an instance of AuditLogDetail from a JSON string
audit_log_detail_instance = AuditLogDetail.from_json(json)
# print the JSON string representation of the object
print(AuditLogDetail.to_json())

# convert the object into a dict
audit_log_detail_dict = audit_log_detail_instance.to_dict()
# create an instance of AuditLogDetail from a dict
audit_log_detail_from_dict = AuditLogDetail.from_dict(audit_log_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


