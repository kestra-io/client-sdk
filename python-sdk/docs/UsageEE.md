# UsageEE


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**GroupUsage**](GroupUsage.md) |  | [optional] 
**users** | [**UserUsage**](UserUsage.md) |  | [optional] 
**roles** | [**RoleUsage**](RoleUsage.md) |  | [optional] 
**tenants** | [**TenantUsage**](TenantUsage.md) |  | [optional] 
**flows** | [**FlowUsage**](FlowUsage.md) |  | [optional] 
**executions** | [**ExecutionUsage**](ExecutionUsage.md) |  | [optional] 

## Example

```python
from kestrapy.models.usage_ee import UsageEE

# TODO update the JSON string below
json = "{}"
# create an instance of UsageEE from a JSON string
usage_ee_instance = UsageEE.from_json(json)
# print the JSON string representation of the object
print(UsageEE.to_json())

# convert the object into a dict
usage_ee_dict = usage_ee_instance.to_dict()
# create an instance of UsageEE from a dict
usage_ee_from_dict = UsageEE.from_dict(usage_ee_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


