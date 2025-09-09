# ApiAuth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **str** |  | 
**type** | **str** |  | 
**name** | **str** |  | 

## Example

```python
from kestrapy.models.api_auth import ApiAuth

# TODO update the JSON string below
json = "{}"
# create an instance of ApiAuth from a JSON string
api_auth_instance = ApiAuth.from_json(json)
# print the JSON string representation of the object
print(ApiAuth.to_json())

# convert the object into a dict
api_auth_dict = api_auth_instance.to_dict()
# create an instance of ApiAuth from a dict
api_auth_from_dict = ApiAuth.from_dict(api_auth_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


