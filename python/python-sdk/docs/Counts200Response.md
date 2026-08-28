# Counts200Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**open** | **int** |  | [optional] 
**acknowledged** | **int** |  | [optional] 
**investigating** | **int** |  | [optional] 
**resolved** | **int** |  | [optional] 
**cancelled** | **int** |  | [optional] 

## Example

```python
from kestrapy.models.counts200_response import Counts200Response

# TODO update the JSON string below
json = "{}"
# create an instance of Counts200Response from a JSON string
counts200_response_instance = Counts200Response.from_json(json)
# print the JSON string representation of the object
print(Counts200Response.to_json())

# convert the object into a dict
counts200_response_dict = counts200_response_instance.to_dict()
# create an instance of Counts200Response from a dict
counts200_response_from_dict = Counts200Response.from_dict(counts200_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


