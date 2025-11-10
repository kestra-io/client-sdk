# ServerInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional] 
**type** | [**ServerInstanceType**](ServerInstanceType.md) |  | [optional] 
**version** | **str** |  | [optional] 
**hostname** | **str** |  | [optional] 
**props** | **Dict[str, object]** |  | [optional] 
**metrics** | [**List[Metric]**](Metric.md) |  | [optional] 

## Example

```python
from kestrapy.models.server_instance import ServerInstance

# TODO update the JSON string below
json = "{}"
# create an instance of ServerInstance from a JSON string
server_instance_instance = ServerInstance.from_json(json)
# print the JSON string representation of the object
print(ServerInstance.to_json())

# convert the object into a dict
server_instance_dict = server_instance_instance.to_dict()
# create an instance of ServerInstance from a dict
server_instance_from_dict = ServerInstance.from_dict(server_instance_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


