# ServiceInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**server** | [**ServerInstance**](ServerInstance.md) |  | [optional] 
**metrics** | [**List[Metric]**](Metric.md) |  | [optional] 
**state** | [**ServiceServiceState**](ServiceServiceState.md) |  | [optional] 
**id** | **str** |  | [optional] 
**type** | [**ServiceType**](ServiceType.md) |  | [optional] 
**created_at** | **datetime** |  | [optional] 
**updated_at** | **datetime** |  | [optional] 
**events** | [**List[ServiceInstanceTimestampedEvent]**](ServiceInstanceTimestampedEvent.md) |  | [optional] 
**config** | [**ServerConfig**](ServerConfig.md) |  | [optional] 
**props** | **Dict[str, object]** |  | [optional] 
**seq_id** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.service_instance import ServiceInstance

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceInstance from a JSON string
service_instance_instance = ServiceInstance.from_json(json)
# print the JSON string representation of the object
print(ServiceInstance.to_json())

# convert the object into a dict
service_instance_dict = service_instance_instance.to_dict()
# create an instance of ServiceInstance from a dict
service_instance_from_dict = ServiceInstance.from_dict(service_instance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


