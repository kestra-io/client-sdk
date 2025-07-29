# UsageEE


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**groups** | [**GroupUsage**](GroupUsage.md) |  | [optional] 
**users** | [**UserUsage**](UserUsage.md) |  | [optional] 
**roles** | [**RoleUsage**](RoleUsage.md) |  | [optional] 
**namespaces** | [**NamespaceUsage**](NamespaceUsage.md) |  | [optional] 
**tenants** | [**TenantUsage**](TenantUsage.md) |  | [optional] 
**uuid** | **str** |  | 
**start_uuid** | **str** |  | 
**instance_uuid** | **str** |  | 
**server_type** | [**ServerType**](ServerType.md) |  | 
**version** | **str** |  | 
**zone_id** | **str** |  | 
**uri** | **str** |  | [optional] 
**environments** | **List[str]** |  | [optional] 
**start_time** | **datetime** |  | 
**host** | [**HostUsage**](HostUsage.md) |  | [optional] 
**configurations** | [**ConfigurationUsage**](ConfigurationUsage.md) |  | [optional] 
**plugins** | [**List[PluginUsage]**](PluginUsage.md) |  | [optional] 
**flows** | [**FlowUsage**](FlowUsage.md) |  | [optional] 
**executions** | [**ExecutionUsage**](ExecutionUsage.md) |  | [optional] 
**services** | [**ServiceUsage**](ServiceUsage.md) |  | [optional] 
**plugin_metrics** | [**List[PluginMetric]**](PluginMetric.md) |  | [optional] 

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


