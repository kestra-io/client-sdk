# ServiceInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**server** | [**ServerInstance**](ServerInstance.md) |  | 
**metrics** | [**List[Metric]**](Metric.md) |  | 
**state** | [**ServiceServiceState**](ServiceServiceState.md) |  | 
**id** | **str** |  | 
**type** | [**ServiceType**](ServiceType.md) |  | 
**created_at** | **datetime** |  | 
**updated_at** | **datetime** |  | 
**events** | [**List[ServiceInstanceTimestampedEvent]**](ServiceInstanceTimestampedEvent.md) |  | 
**config** | [**ServerConfig**](ServerConfig.md) |  | 
**props** | **Dict[str, object]** |  | 
**seq_id** | **int** |  | 

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


