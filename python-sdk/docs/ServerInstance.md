# ServerInstance


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**type** | [**ServerInstanceType**](ServerInstanceType.md) |  | 
**version** | **str** |  | 
**hostname** | **str** |  | 
**props** | **Dict[str, object]** |  | 
**metrics** | [**List[Metric]**](Metric.md) |  | 

## Example

```python
from kestra_api_client.models.server_instance import ServerInstance

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


