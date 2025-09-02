# Output


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | 
**description** | **str** |  | [optional] 
**value** | **object** |  | 
**type** | [**Type**](Type.md) |  | 
**display_name** | **str** |  | [optional] 
**required** | **bool** |  | [optional] 

## Example

```python
from kestra_api_client.models.output import Output

# TODO update the JSON string below
json = "{}"
# create an instance of Output from a JSON string
output_instance = Output.from_json(json)
# print the JSON string representation of the object
print(Output.to_json())

# convert the object into a dict
output_dict = output_instance.to_dict()
# create an instance of Output from a dict
output_from_dict = Output.from_dict(output_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


