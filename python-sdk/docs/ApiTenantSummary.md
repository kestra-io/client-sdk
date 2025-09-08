# ApiTenantSummary


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**name** | **str** |  | 

## Example

```python
from kestra_api_client.models.api_tenant_summary import ApiTenantSummary

# TODO update the JSON string below
json = "{}"
# create an instance of ApiTenantSummary from a JSON string
api_tenant_summary_instance = ApiTenantSummary.from_json(json)
# print the JSON string representation of the object
print(ApiTenantSummary.to_json())

# convert the object into a dict
api_tenant_summary_dict = api_tenant_summary_instance.to_dict()
# create an instance of ApiTenantSummary from a dict
api_tenant_summary_from_dict = ApiTenantSummary.from_dict(api_tenant_summary_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


