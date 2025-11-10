# PreviewAppRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parameters** | [**HttpParameters**](HttpParameters.md) |  | [optional] 

## Example

```python
from kestrapy.models.preview_app_request import PreviewAppRequest

# TODO update the JSON string below
json = "{}"
# create an instance of PreviewAppRequest from a JSON string
preview_app_request_instance = PreviewAppRequest.from_json(json)
# print the JSON string representation of the object
print(PreviewAppRequest.to_json())

# convert the object into a dict
preview_app_request_dict = preview_app_request_instance.to_dict()
# create an instance of PreviewAppRequest from a dict
preview_app_request_from_dict = PreviewAppRequest.from_dict(preview_app_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


