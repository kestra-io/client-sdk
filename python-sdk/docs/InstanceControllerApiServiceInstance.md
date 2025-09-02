# InstanceControllerApiServiceInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | [**ServiceType**](ServiceType.md) |  | 
**state** | [**ServiceServiceState**](ServiceServiceState.md) |  | 
**server** | [**InstanceControllerApiServerInstance**](InstanceControllerApiServerInstance.md) |  | 
**created_at** | **datetime** |  | 
**updated_at** | **datetime** |  | 

## Example

```python
from kestra_api_client.models.instance_controller_api_service_instance import InstanceControllerApiServiceInstance

# TODO update the JSON string below
json = "{}"
# create an instance of InstanceControllerApiServiceInstance from a JSON string
instance_controller_api_service_instance_instance = InstanceControllerApiServiceInstance.from_json(json)
# print the JSON string representation of the object
print(InstanceControllerApiServiceInstance.to_json())

# convert the object into a dict
instance_controller_api_service_instance_dict = instance_controller_api_service_instance_instance.to_dict()
# create an instance of InstanceControllerApiServiceInstance from a dict
instance_controller_api_service_instance_from_dict = InstanceControllerApiServiceInstance.from_dict(instance_controller_api_service_instance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


