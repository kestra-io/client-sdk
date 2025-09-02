# Isolation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**denied_services** | [**List[ServiceType]**](ServiceType.md) |  | 
**enabled** | **bool** |  | 

## Example

```python
from kestra_api_client.models.isolation import Isolation

# TODO update the JSON string below
json = "{}"
# create an instance of Isolation from a JSON string
isolation_instance = Isolation.from_json(json)
# print the JSON string representation of the object
print(Isolation.to_json())

# convert the object into a dict
isolation_dict = isolation_instance.to_dict()
# create an instance of Isolation from a dict
isolation_from_dict = Isolation.from_dict(isolation_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


