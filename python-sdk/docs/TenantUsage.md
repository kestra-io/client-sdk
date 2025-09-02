# TenantUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **int** |  | [optional] 

## Example

```python
from kestra_api_client.models.tenant_usage import TenantUsage

# TODO update the JSON string below
json = "{}"
# create an instance of TenantUsage from a JSON string
tenant_usage_instance = TenantUsage.from_json(json)
# print the JSON string representation of the object
print(TenantUsage.to_json())

# convert the object into a dict
tenant_usage_dict = tenant_usage_instance.to_dict()
# create an instance of TenantUsage from a dict
tenant_usage_from_dict = TenantUsage.from_dict(tenant_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


