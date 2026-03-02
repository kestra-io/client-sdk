# ImportPluginDefaultsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file_upload** | **bytearray** |  | [optional] 

## Example

```python
from kestrapy.models.import_plugin_defaults_request import ImportPluginDefaultsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ImportPluginDefaultsRequest from a JSON string
import_plugin_defaults_request_instance = ImportPluginDefaultsRequest.from_json(json)
# print the JSON string representation of the object
print(ImportPluginDefaultsRequest.to_json())

# convert the object into a dict
import_plugin_defaults_request_dict = import_plugin_defaults_request_instance.to_dict()
# create an instance of ImportPluginDefaultsRequest from a dict
import_plugin_defaults_request_from_dict = ImportPluginDefaultsRequest.from_dict(import_plugin_defaults_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


