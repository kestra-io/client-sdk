# HostUsageJvm


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  | [optional] 
**vendor** | **str** |  | [optional] 
**version** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.host_usage_jvm import HostUsageJvm

# TODO update the JSON string below
json = "{}"
# create an instance of HostUsageJvm from a JSON string
host_usage_jvm_instance = HostUsageJvm.from_json(json)
# print the JSON string representation of the object
print(HostUsageJvm.to_json())

# convert the object into a dict
host_usage_jvm_dict = host_usage_jvm_instance.to_dict()
# create an instance of HostUsageJvm from a dict
host_usage_jvm_from_dict = HostUsageJvm.from_dict(host_usage_jvm_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


