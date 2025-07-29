# HostUsageHardware


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**logical_processor_count** | **int** |  | [optional] 
**physical_processor_count** | **int** |  | [optional] 
**max_freq** | **int** |  | [optional] 
**memory** | **int** |  | [optional] 
**known_vm_mac_addr** | **bool** |  | [optional] 
**known_docker_mac_addr** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.host_usage_hardware import HostUsageHardware

# TODO update the JSON string below
json = "{}"
# create an instance of HostUsageHardware from a JSON string
host_usage_hardware_instance = HostUsageHardware.from_json(json)
# print the JSON string representation of the object
print(HostUsageHardware.to_json())

# convert the object into a dict
host_usage_hardware_dict = host_usage_hardware_instance.to_dict()
# create an instance of HostUsageHardware from a dict
host_usage_hardware_from_dict = HostUsageHardware.from_dict(host_usage_hardware_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


