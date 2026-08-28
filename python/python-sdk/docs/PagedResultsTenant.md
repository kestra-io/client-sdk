# PagedResultsTenant


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**results** | [**List[Tenant]**](Tenant.md) |  | 
**total** | **int** |  | 

## Example

```python
from kestrapy.models.paged_results_tenant import PagedResultsTenant

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultsTenant from a JSON string
paged_results_tenant_instance = PagedResultsTenant.from_json(json)
# print the JSON string representation of the object
print(PagedResultsTenant.to_json())

# convert the object into a dict
paged_results_tenant_dict = paged_results_tenant_instance.to_dict()
# create an instance of PagedResultsTenant from a dict
paged_results_tenant_from_dict = PagedResultsTenant.from_dict(paged_results_tenant_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


