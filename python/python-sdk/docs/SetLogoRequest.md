# SetLogoRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**logo** | **bytearray** | The logo file | [optional] 

## Example

```python
from kestrapy.models.set_logo_request import SetLogoRequest

# TODO update the JSON string below
json = "{}"
# create an instance of SetLogoRequest from a JSON string
set_logo_request_instance = SetLogoRequest.from_json(json)
# print the JSON string representation of the object
print(SetLogoRequest.to_json())

# convert the object into a dict
set_logo_request_dict = set_logo_request_instance.to_dict()
# create an instance of SetLogoRequest from a dict
set_logo_request_from_dict = SetLogoRequest.from_dict(set_logo_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


