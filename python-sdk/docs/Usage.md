# Usage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
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
from kestrapy.models.usage import Usage

# TODO update the JSON string below
json = "{}"
# create an instance of Usage from a JSON string
usage_instance = Usage.from_json(json)
# print the JSON string representation of the object
print(Usage.to_json())

# convert the object into a dict
usage_dict = usage_instance.to_dict()
# create an instance of Usage from a dict
usage_from_dict = Usage.from_dict(usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


