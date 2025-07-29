# HostUsageOs


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**family** | **str** |  | [optional] 
**version** | **str** |  | [optional] 
**code_name** | **str** |  | [optional] 
**build_number** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.host_usage_os import HostUsageOs

# TODO update the JSON string below
json = "{}"
# create an instance of HostUsageOs from a JSON string
host_usage_os_instance = HostUsageOs.from_json(json)
# print the JSON string representation of the object
print(HostUsageOs.to_json())

# convert the object into a dict
host_usage_os_dict = host_usage_os_instance.to_dict()
# create an instance of HostUsageOs from a dict
host_usage_os_from_dict = HostUsageOs.from_dict(host_usage_os_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


