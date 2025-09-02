# HttpParameters


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conversion_service** | **object** |  | 
**empty** | **bool** |  | [optional] 

## Example

```python
from kestra_api_client.models.http_parameters import HttpParameters

# TODO update the JSON string below
json = "{}"
# create an instance of HttpParameters from a JSON string
http_parameters_instance = HttpParameters.from_json(json)
# print the JSON string representation of the object
print(HttpParameters.to_json())

# convert the object into a dict
http_parameters_dict = http_parameters_instance.to_dict()
# create an instance of HttpParameters from a dict
http_parameters_from_dict = HttpParameters.from_dict(http_parameters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


