# HostUsage


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **str** |  | [optional] 
**hardware** | [**HostUsageHardware**](HostUsageHardware.md) |  | [optional] 
**os** | [**HostUsageOs**](HostUsageOs.md) |  | [optional] 
**jvm** | [**HostUsageJvm**](HostUsageJvm.md) |  | [optional] 

## Example

```python
from kestrapy.models.host_usage import HostUsage

# TODO update the JSON string below
json = "{}"
# create an instance of HostUsage from a JSON string
host_usage_instance = HostUsage.from_json(json)
# print the JSON string representation of the object
print(HostUsage.to_json())

# convert the object into a dict
host_usage_dict = host_usage_instance.to_dict()
# create an instance of HostUsage from a dict
host_usage_from_dict = HostUsage.from_dict(host_usage_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


