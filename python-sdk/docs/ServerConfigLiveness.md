# ServerConfigLiveness


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**enabled** | **bool** |  | [default to True]
**interval** | **str** |  | [default to '5s']
**timeout** | **str** |  | [default to '45s']
**initial_delay** | **str** |  | [default to '45s']
**heartbeat_interval** | **str** |  | [default to '3s']

## Example

```python
from kestra_api_client.models.server_config_liveness import ServerConfigLiveness

# TODO update the JSON string below
json = "{}"
# create an instance of ServerConfigLiveness from a JSON string
server_config_liveness_instance = ServerConfigLiveness.from_json(json)
# print the JSON string representation of the object
print(ServerConfigLiveness.to_json())

# convert the object into a dict
server_config_liveness_dict = server_config_liveness_instance.to_dict()
# create an instance of ServerConfigLiveness from a dict
server_config_liveness_from_dict = ServerConfigLiveness.from_dict(server_config_liveness_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


