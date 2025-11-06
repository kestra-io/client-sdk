# BulkImportAppsRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**file_upload** | **bytearray** | The file to import, can be a ZIP archive or a multi-objects YAML file | [optional] 

## Example

```python
from kestrapy.models.bulk_import_apps_request import BulkImportAppsRequest

# TODO update the JSON string below
json = "{}"
# create an instance of BulkImportAppsRequest from a JSON string
bulk_import_apps_request_instance = BulkImportAppsRequest.from_json(json)
# print the JSON string representation of the object
print(BulkImportAppsRequest.to_json())

# convert the object into a dict
bulk_import_apps_request_dict = bulk_import_apps_request_instance.to_dict()
# create an instance of BulkImportAppsRequest from a dict
bulk_import_apps_request_from_dict = BulkImportAppsRequest.from_dict(bulk_import_apps_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


