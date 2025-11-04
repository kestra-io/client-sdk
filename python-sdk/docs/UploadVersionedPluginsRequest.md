# UploadVersionedPluginsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file** | **bytearray** |  | 
**force_install_on_existing_versions** | **bool** |  | [optional] 

## Example

```python
from kestrapy.models.upload_versioned_plugins_request import UploadVersionedPluginsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UploadVersionedPluginsRequest from a JSON string
upload_versioned_plugins_request_instance = UploadVersionedPluginsRequest.from_json(json)
# print the JSON string representation of the object
print(UploadVersionedPluginsRequest.to_json())

# convert the object into a dict
upload_versioned_plugins_request_dict = upload_versioned_plugins_request_instance.to_dict()
# create an instance of UploadVersionedPluginsRequest from a dict
upload_versioned_plugins_request_from_dict = UploadVersionedPluginsRequest.from_dict(upload_versioned_plugins_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


