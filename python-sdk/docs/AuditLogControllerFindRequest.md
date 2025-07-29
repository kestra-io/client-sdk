# AuditLogControllerFindRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**permission** | [**Permission**](Permission.md) |  | [optional] 
**type** | [**CrudEventType**](CrudEventType.md) |  | [optional] 
**detail** | **Dict[str, object]** |  | [optional] 

## Example

```python
from kestrapy.models.audit_log_controller_find_request import AuditLogControllerFindRequest

# TODO update the JSON string below
json = "{}"
# create an instance of AuditLogControllerFindRequest from a JSON string
audit_log_controller_find_request_instance = AuditLogControllerFindRequest.from_json(json)
# print the JSON string representation of the object
print(AuditLogControllerFindRequest.to_json())

# convert the object into a dict
audit_log_controller_find_request_dict = audit_log_controller_find_request_instance.to_dict()
# create an instance of AuditLogControllerFindRequest from a dict
audit_log_controller_find_request_from_dict = AuditLogControllerFindRequest.from_dict(audit_log_controller_find_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


