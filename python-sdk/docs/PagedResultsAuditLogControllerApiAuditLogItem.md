# PagedResultsAuditLogControllerApiAuditLogItem


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[AuditLogControllerApiAuditLogItem]**](AuditLogControllerApiAuditLogItem.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_audit_log_controller_api_audit_log_item import PagedResultsAuditLogControllerApiAuditLogItem

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsAuditLogControllerApiAuditLogItem from a JSON string
paged_results_audit_log_controller_api_audit_log_item_instance = PagedResultsAuditLogControllerApiAuditLogItem.from_json(json)
# print the JSON string representation of the object
print(PagedResultsAuditLogControllerApiAuditLogItem.to_json())

# convert the object into a dict
paged_results_audit_log_controller_api_audit_log_item_dict = paged_results_audit_log_controller_api_audit_log_item_instance.to_dict()
# create an instance of PagedResultsAuditLogControllerApiAuditLogItem from a dict
paged_results_audit_log_controller_api_audit_log_item_from_dict = PagedResultsAuditLogControllerApiAuditLogItem.from_dict(paged_results_audit_log_controller_api_audit_log_item_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


