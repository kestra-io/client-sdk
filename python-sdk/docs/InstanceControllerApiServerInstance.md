# InstanceControllerApiServerInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | [**ServerInstanceType**](ServerInstanceType.md) |  | 
**version** | **str** |  | 
**hostname** | **str** |  | 

## Example

```python
from kestra_api_client.models.instance_controller_api_server_instance import InstanceControllerApiServerInstance

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiServerInstance from a JSON string
instance_controller_api_server_instance_instance = InstanceControllerApiServerInstance.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiServerInstance.to_json())

# convert the object into a dict
instance_controller_api_server_instance_dict = instance_controller_api_server_instance_instance.to_dict()
# create an instance of InstanceControllerApiServerInstance from a dict
instance_controller_api_server_instance_from_dict = InstanceControllerApiServerInstance.from_dict(instance_controller_api_server_instance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


