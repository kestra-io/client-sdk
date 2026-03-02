# SDKAuth


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**api_token** | **str** |  | [optional] 
**username** | **str** |  | [optional] 
**password** | **str** |  | [optional] 

## Example

```python
from kestrapy.models.sdk_auth import SDKAuth

# TODO update the JSON string below
json = "{}"
# create an instance of SDKAuth from a JSON string
sdk_auth_instance = SDKAuth.from_json(json)
# print the JSON string representation of the object
print(SDKAuth.to_json())

# convert the object into a dict
sdk_auth_dict = sdk_auth_instance.to_dict()
# create an instance of SDKAuth from a dict
sdk_auth_from_dict = SDKAuth.from_dict(sdk_auth_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


